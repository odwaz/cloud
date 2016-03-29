package com.iveri.client.example.transaction;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Configuration
{
	//----EXAMPLE CONFIGURATION-----
	//These settings only apply if a config.xml file is not found
	static String gateway = "nedbank"; // Change gateway here if not using iVeriClient config file default
	static String certificateID = "{00000000-0000-0000-0000-000000000000}"; // Enter GUID here if not using iVeriClient config file default
	static String applicationID = "{00000000-0000-0000-0000-000000000000}"; // Enter GUID here
	static String mode = "Test"; // Change default mode here
	static String userGroup = ""; // User Group as per BackOffice login
	static String userName = ""; // User Name as per BackOffice login
	static String password = ""; // Password as per BackOffice login
	static String ccnumber = "4242424242424242"; // Change the Credit Card number here
	static String expiry = "122012"; // Change the creditcard expiry date here (MMYYYY)
	static String cvv = "123"; // Change the Card Security Code here
	static String amount = "123"; // Change the amount in cents, here (1.23)
	static String cashAmount = "0";
	static String currency = "ZAR"; // Change the amount in cents, here (1.23)
	static String tranType = "webservice"; //webservice or enterprise

	static String server = "gateway.iveri.dev";
	static String path = "/iVeriWebService/Service.asmx";

	static String deviceMake = "Miura";
	static String connectionMethod = "bluetooth";
	static String bluetoothUrl = "btspp://001B10002A01:1";
	static String wifiPort = "6000";
	//---------------------------
	static File CONFIG_FILE = new File("config.xml");
	static Document CONFIG_DOCUMENT = null;
	static
	{
		try
		{
			//Load demo.xml config file
			CONFIG_DOCUMENT = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(CONFIG_FILE);
		}
		catch (Exception ex)
		{
			System.out.println("Failed to load config file from: " + CONFIG_FILE.getAbsolutePath());
			Element elmTransaction;
			Element webService;
			Element miura;
			Element elm;
			//Create one if it fails to load		
			try
			{
				CONFIG_DOCUMENT = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
				CONFIG_DOCUMENT.appendChild(CONFIG_DOCUMENT.createElement("XML"));
				elmTransaction = CONFIG_DOCUMENT.createElement("Transaction");
				CONFIG_DOCUMENT.getDocumentElement().appendChild(elmTransaction);
				//Configure gateway element
				elm = CONFIG_DOCUMENT.createElement("Gateway");
				elm.setAttribute("Value", gateway);
				elmTransaction.appendChild(elm);
				//Configure CertificateID element
				elm = CONFIG_DOCUMENT.createElement("CertificateID");
				elm.setAttribute("Value", certificateID);
				elmTransaction.appendChild(elm);
				//Configure ApplicationID element
				elm = CONFIG_DOCUMENT.createElement("ApplicationID");
				elm.setAttribute("Value", applicationID);
				elmTransaction.appendChild(elm);
				//Configure Mode element
				elm = CONFIG_DOCUMENT.createElement("Mode");
				elm.setAttribute("Value", mode);
				elmTransaction.appendChild(elm);				
				//Configure UserGroup element
				elm = CONFIG_DOCUMENT.createElement("UserGroup");
				elm.setAttribute("Value", userGroup);
				elmTransaction.appendChild(elm);
				//Configure UserName element
				elm = CONFIG_DOCUMENT.createElement("UserName");
				elm.setAttribute("Value", userName);
				elmTransaction.appendChild(elm);
				//Configure Password element
				elm = CONFIG_DOCUMENT.createElement("Password");
				elm.setAttribute("Value", password);
				elmTransaction.appendChild(elm);				
				//Configure CCNumber element
				elm = CONFIG_DOCUMENT.createElement("CCNumber");
				elm.setAttribute("Value", ccnumber);
				elmTransaction.appendChild(elm);
				//Configure Expiry element
				elm = CONFIG_DOCUMENT.createElement("Expiry");
				elm.setAttribute("Value", expiry);
				elmTransaction.appendChild(elm);
				//Configure CVV element
				elm = CONFIG_DOCUMENT.createElement("CVV");
				elm.setAttribute("Value", cvv);
				elmTransaction.appendChild(elm);
				//Configure Amount element
				elm = CONFIG_DOCUMENT.createElement("Amount");
				elm.setAttribute("Value", amount);
				elmTransaction.appendChild(elm);
				//Configure Cashback Amount element
				elm = CONFIG_DOCUMENT.createElement("CashBackAmount");
				elm.setAttribute("Value", cashAmount);
				elmTransaction.appendChild(elm);
				//Configure Amount element
				elm = CONFIG_DOCUMENT.createElement("Currency");
				elm.setAttribute("Value", currency);
				elmTransaction.appendChild(elm);
				//Configure TranType element
				elm = CONFIG_DOCUMENT.createElement("TranType");
				elm.setAttribute("Value", tranType);
				elmTransaction.appendChild(elm);

				webService = CONFIG_DOCUMENT.createElement("WebService");
				CONFIG_DOCUMENT.getDocumentElement().appendChild(webService);
				//Configure Server element
				elm = CONFIG_DOCUMENT.createElement("Server");
				elm.setAttribute("Value", server);
				webService.appendChild(elm);
				//Configure the web service path
				elm = CONFIG_DOCUMENT.createElement("WebServicePath");
				elm.setAttribute("Value", path);
				webService.appendChild(elm);

				miura = CONFIG_DOCUMENT.createElement("Miura");
				CONFIG_DOCUMENT.getDocumentElement().appendChild(miura);
				//Configure Miura Connection Method
				elm = CONFIG_DOCUMENT.createElement("ConnectionMethod");
				elm.setAttribute("Value", connectionMethod);
				miura.appendChild(elm);
				//Configure DeviceMake
				elm = CONFIG_DOCUMENT.createElement("DeviceMake");
				elm.setAttribute("Value", deviceMake);
				miura.appendChild(elm);
				//Configure Miura bluetooth url
				elm = CONFIG_DOCUMENT.createElement("BluetoothUrl");
				elm.setAttribute("Value", bluetoothUrl);
				miura.appendChild(elm);
				//Configure Miura wifi port
				elm = CONFIG_DOCUMENT.createElement("WifiPort");
				elm.setAttribute("Value", wifiPort);
				miura.appendChild(elm);

			}
			catch (ParserConfigurationException pcx)
			{
				System.out.println("ParserConfigurationException: " + pcx.getMessage());
				System.exit(-1);
			}
		}
	}

	public static String getCertificateID()
	{
		return getXPath("CertificateID");
	}

	public static String getApplicationID()
	{
		return getXPath("ApplicationID");
	}

	public static String getMode()
	{
		return getXPath("Mode");
	}

	public static String getUserGroup()
	{
		return getXPath("UserGroup");
	}

	public static String getUserName()
	{
		return getXPath("UserName");
	}

	public static String getPassword()
	{
		return getXPath("Password");
	}

	public static String getGateway()
	{
		return getXPath("Gateway");
	}

	public static String getExpiry()
	{
		return getXPath("Expiry");
	}

	public static String getCvv()
	{
		return getXPath("CVV");
	}

	public static String getCCNumber()
	{
		return getXPath("CCNumber");
	}

	public static String getAmount()
	{
		return getXPath("Amount");
	}

	public static String getCashBackAmount()
	{
		return getXPath("CashBackAmount");
	}

	public static String getCurrency()
	{
		return getXPath("Currency");
	}

	public static String getTranType()
	{
		return getXPath("TranType");
	}

	public static String getServer()
	{
		return getXPath("Server");
	}

	public static String getDeviceMake()
	{
		return getXPath("DeviceMake");
	}

	public static String getWebServicePath()
	{
		return getXPath("WebServicePath");
	}

	public static String getConnectionMethod()
	{
		return getXPath("ConnectionMethod");
	}

	public static String getBluetoothUrl()
	{
		return getXPath("BluetoothUrl");
	}

	public static String getWifiPort()
	{
		return getXPath("WifiPort");
	}

	private static String getXPath(String xpath)
	{
		try
		{
			XPath xp = XPathFactory.newInstance().newXPath();
			Node node = (Node)xp.evaluate("//" + xpath, CONFIG_DOCUMENT.getDocumentElement(), XPathConstants.NODE);
			Node attrib = node.getAttributes().getNamedItem("Value");
			return attrib.getNodeValue();
		}
		catch (Exception ex)
		{
			return "";
		}
	}
}
