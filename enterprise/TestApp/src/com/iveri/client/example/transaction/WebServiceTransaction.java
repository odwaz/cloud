package com.iveri.client.example.transaction;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.iveri.client.example.transaction.NPayHelper.NPaySwipe;

public class WebServiceTransaction
{

	public static Document setUpWebServiceManual(String command, boolean addAirlineData, boolean addCybersourceData) throws ParserConfigurationException
	{
		//Initialization for Web Service Manual Transaction
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element vxml = xmlDocument.createElement("V_XML");
		vxml.setAttribute("Version", "2.0");
		vxml.setAttribute("CertificateID", Configuration.getCertificateID());
		vxml.setAttribute("ProductType", "Enterprise");
		vxml.setAttribute("ProductVersion", "iVeriWebService 1.0");
		vxml.setAttribute("Direction", "Request");
		xmlDocument.appendChild(vxml);

		Element tran;
		tran = xmlDocument.createElement("Transaction");
		tran.setAttribute("Command", command);
		tran.setAttribute("Mode", Configuration.getMode());
		tran.setAttribute("ApplicationID", Configuration.getApplicationID());

		Element node = xmlDocument.createElement("Amount"); //Transaction amount in cent
		node.setTextContent(Configuration.getAmount());
		tran.appendChild(node);
		node = xmlDocument.createElement("ExpiryDate"); //in format MMYYYY
		node.setTextContent(Configuration.getExpiry());
		tran.appendChild(node);
		node = xmlDocument.createElement("CardSecurityCode"); //cvv
		node.setTextContent(Configuration.getCvv());
		tran.appendChild(node);
		node = xmlDocument.createElement("MerchantReference"); //merchant reference number
		node.setTextContent(String.valueOf(System.currentTimeMillis()));
		tran.appendChild(node);
		node = xmlDocument.createElement("MerchantTrace"); //merchant trace number
		node.setTextContent(String.valueOf(UUID.randomUUID()));
		tran.appendChild(node);
		node = xmlDocument.createElement("PAN"); //Credit card number
		node.setTextContent(Configuration.getCCNumber());
		tran.appendChild(node);
		node = xmlDocument.createElement("Currency"); //Currency
		node.setTextContent(Configuration.getCurrency());
		tran.appendChild(node);
		if (addAirlineData)
		{
			Element airline = addSampleAirlineData(xmlDocument);
			tran.appendChild(airline);
		}
		if (addCybersourceData)
		{
			Element cybersource = addSampleCybersourceData(xmlDocument);
			tran.appendChild(cybersource);
		}
		vxml.appendChild(tran);
		return xmlDocument;
	}

	private static Element addSampleCybersourceData(Document xmlDocument)
	{
		Element cybersource = xmlDocument.createElement("CyberSource");
		Element node = xmlDocument.createElement("DeliveryMethod");
		node.setTextContent("Virtual");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("DeviceFingerprintID");
		node.setTextContent("JHGSDFJH712387JHSGDF17263876");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_FirstName");
		node.setTextContent("John");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_LastName");
		node.setTextContent("Smith");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_Street");
		node.setTextContent("random street");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_City");
		node.setTextContent("Johannesburg");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_Country");
		node.setTextContent("ZA");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_Email");
		node.setTextContent("john@cybersource.com");
		cybersource.appendChild(node);
		node = xmlDocument.createElement("BillTo_IPAddress");
		node.setTextContent("127.0.0.1");
		cybersource.appendChild(node);
		return cybersource;
	}

	private static Element addSampleAirlineData(Document xmlDocument)
	{
		Element airline = xmlDocument.createElement("AirlineData");
		Element node = xmlDocument.createElement("PassengerName");
		node.setTextContent("John Smith");
		airline.appendChild(node);
		node = xmlDocument.createElement("PrimaryTicketNumber");
		node.setTextContent("1234567890");
		airline.appendChild(node);
		node = xmlDocument.createElement("FirstDepartureLocationCode");
		node.setTextContent("DUR");
		airline.appendChild(node);
		node = xmlDocument.createElement("FirstArrivalLocationCode");
		node.setTextContent("JNB");
		airline.appendChild(node);
		node = xmlDocument.createElement("PNRNumber");
		node.setTextContent("KSEHIA");
		airline.appendChild(node);
		node = xmlDocument.createElement("OfficeIATANumber");
		node.setTextContent("77491105");
		airline.appendChild(node);
		node = xmlDocument.createElement("OrderNumber");
		node.setTextContent("JS123456");
		airline.appendChild(node);
		node = xmlDocument.createElement("PlaceOfIssue");
		node.setTextContent("Comair");
		airline.appendChild(node);
		return airline;
	}

	public static Document setUpWebServiceNpay(NPaySwipe swipe, String command, boolean addAirlineData, boolean addCybersourceData)
		throws ParserConfigurationException
	{
		//Initialization for Web Service nPay Transaction
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element vxml = xmlDocument.createElement("V_XML");
		vxml.setAttribute("Version", "2.0");
		vxml.setAttribute("CertificateID", Configuration.getCertificateID());
		vxml.setAttribute("ProductType", "Enterprise");
		vxml.setAttribute("ProductVersion", "iVeriWebService 1.0");
		vxml.setAttribute("Direction", "Request");
		xmlDocument.appendChild(vxml);

		Element tran;
		tran = xmlDocument.createElement("Transaction");
		tran.setAttribute("Command", command);
		tran.setAttribute("Mode", Configuration.getMode());
		tran.setAttribute("ApplicationID", Configuration.getApplicationID());

		Element node = xmlDocument.createElement("Amount"); //Transaction amount in cent
		node.setTextContent(Configuration.getAmount());
		tran.appendChild(node);
		node = xmlDocument.createElement("Currency"); //Currency
		node.setTextContent(Configuration.getCurrency());
		tran.appendChild(node);
		node = xmlDocument.createElement("Terminal"); //Terminal
		node.setTextContent("nPay");
		tran.appendChild(node);
		node = xmlDocument.createElement("DeviceSerialNumber"); //device serial number
		node.setTextContent(swipe.DeviceSerialNumber);
		tran.appendChild(node);
		node = xmlDocument.createElement("DeviceMake"); //device make
		node.setTextContent(swipe.DeviceMake);
		tran.appendChild(node);
		node = xmlDocument.createElement("Track2"); //Track 2 Data
		node.setTextContent(swipe.Track2);
		tran.appendChild(node);
		node = xmlDocument.createElement("AccountType"); //account type
		node.setTextContent(swipe.AccountType);
		tran.appendChild(node);
		node = xmlDocument.createElement("MerchantReference"); //Reference number
		node.setTextContent(String.valueOf(System.currentTimeMillis()));
		tran.appendChild(node);
		node = xmlDocument.createElement("MerchantTrace"); //merchant trace number
		node.setTextContent(String.valueOf(UUID.randomUUID()));
		tran.appendChild(node);
		//set the pin
		if (swipe.PinBlock != null && !swipe.PinBlock.equals(""))
		{
			node = xmlDocument.createElement("KeySerialNumber"); //key serial number
			node.setTextContent(swipe.KeySerialNumber);
			tran.appendChild(node);
			node = xmlDocument.createElement("PINBlock"); //PIN block
			node.setTextContent(swipe.PinBlock);
			tran.appendChild(node);
		}
		//check EMV
		boolean isEMV = swipe.AuthorisationRequestCryptogram != null && !swipe.AuthorisationRequestCryptogram.equals("");
		if (isEMV)
		{
			node = xmlDocument.createElement("EMV_AuthorisationRequestCryptogram");
			node.setTextContent(swipe.AuthorisationRequestCryptogram);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_ApplicationIdentifier");
			node.setTextContent(swipe.ApplicationIdentifier);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_ApplicationInterchangeProfile");
			node.setTextContent(swipe.ApplicationInterchangeProfile);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_CardSequenceNumber");
			node.setTextContent(swipe.CardSequenceNumber);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_ApplicationTransactionCounter");
			node.setTextContent(swipe.ApplicationTransactionCounter);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_ApplicationVersion");
			node.setTextContent(swipe.ApplicationVersion);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_CardHolderVerificationMethodResult");
			node.setTextContent(swipe.CardHolderVerificationMethodResult);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_CryptogramInformationData");
			node.setTextContent(swipe.CryptogramInformationData);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_IssuerApplicationData");
			node.setTextContent(swipe.IssuerApplicationData);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_TerminalCapabilities");
			node.setTextContent(swipe.TerminalCapabilities);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_TerminalType");
			node.setTextContent(swipe.TerminalType);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_TerminalVerificationResult");
			node.setTextContent(swipe.TerminalVerificationResult);
			tran.appendChild(node);
			node = xmlDocument.createElement("EMV_UnpredictableNumber");
			node.setTextContent(swipe.UnpredictableNumber);
			tran.appendChild(node);
		}
		if (addAirlineData)
		{
			Element airline = addSampleAirlineData(xmlDocument);
			tran.appendChild(airline);
		}
		if (addCybersourceData)
		{
			Element cybersource = addSampleCybersourceData(xmlDocument);
			tran.appendChild(cybersource);
		}
		vxml.appendChild(tran);
		return xmlDocument;
	}

	public static Document setUpWebServiceToken(String command, String tagName, String tagValue) throws ParserConfigurationException
	{
		//Initialization for Web Service Follow Up Transaction
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element vxml = xmlDocument.createElement("V_XML");
		vxml.setAttribute("Version", "2.0");
		vxml.setAttribute("CertificateID", Configuration.getCertificateID());
		vxml.setAttribute("ProductType", "Enterprise");
		vxml.setAttribute("ProductVersion", "iVeriWebService 1.0");
		vxml.setAttribute("Direction", "Request");
		xmlDocument.appendChild(vxml);
		Element tran;
		tran = xmlDocument.createElement("Transaction");
		tran.setAttribute("Command", command);
		tran.setAttribute("Mode", Configuration.getMode());
		tran.setAttribute("ApplicationID", Configuration.getApplicationID());

		Element node = xmlDocument.createElement("Amount"); //Transaction amount in cent
		node.setTextContent(Configuration.getAmount());
		tran.appendChild(node);
		node = xmlDocument.createElement("Currency"); //Currency
		node.setTextContent(Configuration.getCurrency());
		tran.appendChild(node);
		node = xmlDocument.createElement("MerchantReference"); //Reference number
		node.setTextContent(String.valueOf(System.currentTimeMillis()));
		tran.appendChild(node);
		if (tagName.equalsIgnoreCase("MSISDN"))
		{
			node = xmlDocument.createElement("PANFormat");
			node.setTextContent("MSISDN");
			tran.appendChild(node);
		}
		else
		{
			node = xmlDocument.createElement("PANFormat");
			node.setTextContent("Tokenized");
			tran.appendChild(node);
			node = xmlDocument.createElement("PAN");
			node.setTextContent(TransactionUtil.getDottedPan(Configuration.getCCNumber()));
			tran.appendChild(node);
			node = xmlDocument.createElement("CardSecurityCode");
			node.setTextContent(Configuration.getCvv());
			tran.appendChild(node);
			node = xmlDocument.createElement(tagName);
			node.setTextContent(tagValue);
			tran.appendChild(node);
		}

		vxml.appendChild(tran);
		return xmlDocument;
	}

	public static Document setUpWebServiceFollowUp(String command, String transactionIndex) throws ParserConfigurationException
	{
		//Initialization for Web Service Follow Up Transaction
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element vxml = xmlDocument.createElement("V_XML");
		vxml.setAttribute("Version", "2.0");
		vxml.setAttribute("CertificateID", Configuration.getCertificateID());
		vxml.setAttribute("ProductType", "Enterprise");
		vxml.setAttribute("ProductVersion", "iVeriWebService 1.0");
		vxml.setAttribute("Direction", "Request");
		xmlDocument.appendChild(vxml);
		Element tran;
		tran = xmlDocument.createElement("Transaction");
		tran.setAttribute("Command", command);
		tran.setAttribute("Mode", Configuration.getMode());
		tran.setAttribute("ApplicationID", Configuration.getApplicationID());

		Element node = xmlDocument.createElement("Amount"); //Transaction amount in cent
		node.setTextContent(Configuration.getAmount());
		tran.appendChild(node);
		node = xmlDocument.createElement("Currency"); //Currency
		node.setTextContent(Configuration.getCurrency());
		tran.appendChild(node);
		node = xmlDocument.createElement("TransactionIndex"); //Currency
		node.setTextContent(transactionIndex);
		tran.appendChild(node);

		vxml.appendChild(tran);
		return xmlDocument;
	}

	public static Document setUpWebServiceVoid(String originalReference, boolean isMerchantTrace) throws ParserConfigurationException
	{
		//Initialization for Web Service Void Transaction
		Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		Element vxml = xmlDocument.createElement("V_XML");
		vxml.setAttribute("Version", "2.0");
		vxml.setAttribute("CertificateID", Configuration.getCertificateID());
		vxml.setAttribute("ProductType", "Enterprise");
		vxml.setAttribute("ProductVersion", "iVeriWebService 1.0");
		vxml.setAttribute("Direction", "Request");
		xmlDocument.appendChild(vxml);
		Element tran;
		tran = xmlDocument.createElement("Transaction");
		tran.setAttribute("Command", "Void");
		tran.setAttribute("Mode", Configuration.getMode());
		tran.setAttribute("ApplicationID", Configuration.getApplicationID());

		if (isMerchantTrace)
		{
			Element node = xmlDocument.createElement("OriginalMerchantTrace");
			node.setTextContent(originalReference);
			tran.appendChild(node);
		}
		else
		{
			Element node = xmlDocument.createElement("OriginalRequestID");
			node.setTextContent(originalReference);
			tran.appendChild(node);
		}

		vxml.appendChild(tran);
		return xmlDocument;
	}

	public static Document doWebServiceTransaction(Document requestXML)
	{
		String MethodName = "Execute";
		String XmlNamespace = "http://iveri.com/";
		String SoapAction = XmlNamespace + MethodName;
		URL url = null;
		HttpsURLConnection https = null;
		try
		{
			//initialize the https connection
			url = new URL("https", Configuration.getServer(), 443, Configuration.getWebServicePath());
			https = (HttpsURLConnection)url.openConnection();
			https.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			https.setRequestProperty("SOAPAction", SoapAction);
			https.setRequestMethod("POST");
			https.setDoOutput(true);
			https.setDoInput(true);
		}
		catch (Exception ex)
		{
			System.out.println("Error establishing connection: " + ex.getMessage());
			return null;
		}
		//attach certificates for authentication
		//	    try {	        
		//	        TransactionUtil.checkCertificates(https);		
		//	    } catch (Exception ex) {
		//	        System.out.println("Error attaching certificates: " + ex.getMessage());
		//	        return;
		//	    }
		try
		{
			//building up the SOAP request message          
			SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
			SOAPPart soapPart = soapMessage.getSOAPPart();
			SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
			SOAPBody soapBody = soapEnvelope.getBody();
			SOAPBodyElement methodName = soapBody.addBodyElement(soapEnvelope.createName("Execute", "", "http://iveri.com/"));
			SOAPElement node = methodName.addChildElement("validateRequest");
			node.setTextContent("false");
			node = methodName.addChildElement("protocol");
			node.setTextContent("V_XML");
			node = methodName.addChildElement("protocolVersion");
			node.setTextContent("2.0");
			SOAPElement request = methodName.addChildElement("request");
			request.setTextContent(TransactionUtil.getXML(requestXML));

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			soapMessage.writeTo(baos);

			//write message to the connection stream
			OutputStreamWriter out = new OutputStreamWriter(https.getOutputStream());
			out.write(baos.toString());
			out.flush();
			out.close();
			System.out.println("REQUEST.....\n" + baos.toString() + "\n");

			//read response from the input stream
			InputStream in = https.getInputStream();
			ByteArrayOutputStream returned = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer, 0, buffer.length)) != -1)
			{
				returned.write(buffer, 0, len);
			}

			byte[] xml = returned.toByteArray();
			if (xml.length == 0)
				return null;
			//convert response in byte array format to XML document
			Document responseXML = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml));

			String unescapeXml = StringEscapeUtils.unescapeXml(TransactionUtil.getXML(responseXML));
			System.out.println("RESPONSE.....\n" + unescapeXml);
			return TransactionUtil.getVXMLDoc(unescapeXml);
		}
		catch (Exception ex)
		{
			System.out.println("Error: Web Service Transaction Failed. " + ex.getMessage());
		}
		return null;
	}

}
