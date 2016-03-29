package com.iveri.client.example.transaction;

import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.NumberFormat;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class TransactionUtil
{

	/**
	   * Attach client certificate and CA certificates in java to the connection for authentication
	   * 
	   * @param https the HTTPS connection
	   * @throws NoSuchAlgorithmException
	   * @throws KeyStoreException
	   * @throws CertificateException
	   * @throws IOException
	   * @throws UnrecoverableKeyException
	   * @throws KeyManagementException
	   */
	public static void checkCertificates(HttpsURLConnection https) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException,
		UnrecoverableKeyException, KeyManagementException
	{
		//get the client certificates
		File clientFile = new File("C:\\{596195e5-0364-4e59-b41c-bc0671bd8347}\\keystore.jks"); //path to where your client keystore is 
		String clientPass = "passwd"; //password of the keystore
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		KeyStore clientks = KeyStore.getInstance(KeyStore.getDefaultType());
		InputStream keyInput = new FileInputStream(clientFile);
		clientks.load(keyInput, clientPass.toCharArray());
		keyInput.close();
		kmf.init(clientks, clientPass.toCharArray());

		//get the trust CA certificates from java keystore
		File cacertsFile = new File(System.getProperty("java.home") + File.separator + "lib" + File.separator + "security" + File.separator + "cacerts"); //default path to Java keystore file
		String defaultPassword = "changeit"; //default password for java keystore 'cacerts'
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		KeyStore cacertks = KeyStore.getInstance(KeyStore.getDefaultType());
		keyInput = new FileInputStream(cacertsFile);
		cacertks.load(keyInput, defaultPassword.toCharArray());
		keyInput.close();
		tmf.init(cacertks);

		SSLContext context = SSLContext.getInstance("SSLv3");
		context.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
		SSLSocketFactory sockFact = context.getSocketFactory();

		https.setSSLSocketFactory(sockFact);
	}

	/**
	   * private method to return a string representation of a XML document
	   * @param xmlDocument the XML document to be parsed
	   * @return string representation of the document
	   */
	public static String getXML(Document xmlDocument)
	{
		try
		{
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			DOMSource source = new DOMSource(xmlDocument.getDocumentElement());
			CharArrayWriter writer = new CharArrayWriter();
			StreamResult result = new StreamResult(writer);
			transformer.transform(source, result);
			writer.flush();
			String xml = writer.toString();
			writer.close();
			return xml;
		}
		catch (TransformerConfigurationException tcx)
		{
			return ("Error: Unable to convert XML Document to String : " + tcx.getMessage());
		}
		catch (TransformerException tx)
		{
			return ("Error: Unable to convert XML Document to String : " + tx.getMessage());
		}
	}

	public static Document getVXMLDoc(String xml)
	{
		InputStream xmlReader = new ByteArrayInputStream(xml.getBytes());
		try
		{
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlReader);
			return doc;
		}
		catch (Exception ex)
		{
			//This should never happen
			System.out.println("Error reading xml" + ex.getMessage());
		}
		return null;
	}

	public static String getXPath(String xpath, Document doc)
	{
		try
		{
			XPath xp = XPathFactory.newInstance().newXPath();
			Node node = (Node)xp.evaluate("//" + xpath, doc.getDocumentElement(), XPathConstants.NODE);
			return node.getTextContent();
		}
		catch (Exception ex)
		{
			return "";
		}
	}
	
	public static String convertDottedPan(String pan) // ;541283******6273
	{
		pan = pan.replace('*', '0');
		String newPan = pan;
		for (int i = 0; i < 10; i++)
		{
			newPan = pan.substring(0,pan.length()-5)+ (char)('0'+i) +pan.substring(pan.length()-4);
			if (isMod10(newPan))
				break;
		}
		return newPan;
	}

	public static boolean isMod10(String pan)
	{
		int multiplier = 2;
		int digitSum = 0;
		for (int i = pan.length() - 2; i >= 0; i--)
		{
			int digit = pan.charAt(i) - '0';
			int digitProduct = digit * multiplier;
			digitSum += digitProduct / 10 + digitProduct % 10;
			multiplier = 3 - multiplier;
		}
		return !((pan.length() == 0) || (pan.charAt(pan.length() - 1) - '0' != (10 - digitSum % 10) % 10));
	}

	public static String getDottedPan(String ccNumber)
	{
		if (ccNumber == null || ccNumber.equals(""))
		{
			System.out.println("Card Number is missing. Can not get Dotted PAN.");
			return "";
		}
		String dottedPAN = ccNumber.substring(0, 4) + "........" + ccNumber.substring(ccNumber.length() - 4);
		return dottedPAN;
	}

	public static String formatSymbolDecimalAmount(String currency, String symbolFormat, int decimalPlaces, double decimalAmount)
	{
		String sign;
		if (decimalAmount < 0)
		{
			sign = "-";
			decimalAmount = -decimalAmount;
		}
		else
			sign = "";
		
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(decimalPlaces);
		nf.setMinimumFractionDigits(decimalPlaces);
		nf.setMinimumIntegerDigits(1);
		nf.setGroupingUsed(true);
		String formattedAmount = nf.format(decimalAmount);
		symbolFormat = fixSymbolFormat(symbolFormat);
		String format = symbolFormat.substring(0, 3);
		String symbol = symbolFormat.substring(5);
		int i = symbol.indexOf("ISO");
		if (i >= 0)
			symbol = symbol.substring(0, i) + currency + symbol.substring(i + 3);
		if (format.equals("SAC"))
			return sign + formattedAmount + symbol;
		if (format.equals("SCA"))
			return sign + symbol + formattedAmount;
		if (format.equals("ASC"))
			return formattedAmount + sign + symbol;
		if (format.equals("ACS"))
			return formattedAmount + symbol + sign;
		if (format.equals("CSA"))
			return symbol + sign + formattedAmount;
		if (format.equals("CAS"))
			return symbol + formattedAmount + sign;
		return sign + formattedAmount + symbol;
	}

	private static String fixSymbolFormat(String symbolFormat)
	{
		if ((symbolFormat == null) || (symbolFormat.length() < 3))
			return "SACGD ISO";
		if (symbolFormat.length() <= 5)
			return symbolFormat.substring(0, 3) + "GD ISO";
		return symbolFormat;
	}
	
	public static String streamToString(InputStream inputStream) throws IOException
	{
		return IOUtils.toString(inputStream, "UTF-8");
	}

}
