package com.iveri.client.example.transaction;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.iveri.client.example.transaction.NPayHelper.NPaySwipe;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.ResultException;
import com.iveri.enterprise.ResultStatus;

public class EnterpriseTransaction
{
	private static InputStream binInputStream = null;
	
	
	

	
	public static Enterprise doEnterpriseTransaction(Enterprise enterprise) throws ResultException
	{
		System.out.println("REQUEST VXML...\n" + enterprise.getLoggableRequest());
		ResultStatus resultStatus = enterprise.execute();
		try
		{
			System.out.println("RESPONSE VXML...\n" + enterprise.getLoggableResponse());
		}
		catch (Exception e)
		{
			System.out.println("Error Decoding response. " + e.getMessage());
		}
		System.out.println("Result             : " + resultStatus.getValue());
		if (resultStatus == ResultStatus.UNSUCCESSFUL)
		{
			System.out.println("Result code        : " + enterprise.getResultCode());
			System.out.println("Result source      : " + enterprise.getResultSource());
			System.out.println("Result description : " + enterprise.getResultDescription());
		}
		else if (resultStatus == ResultStatus.SUCCESSFUL || resultStatus == ResultStatus.SUCCESSFUL_WITH_WARNING)
		{
			System.out.println("RequestID          : " + enterprise.getAttribute("RequestID"));
			System.out.println("Acquirer Reference : " + enterprise.getTag("AcquirerReference"));
			System.out.println("Acquirer Date      : " + enterprise.getTag("AcquirerDate"));
			System.out.println("Acquirer Time      : " + enterprise.getTag("AcquirerTime"));
			System.out.println("Authorisation Code : " + enterprise.getTag("AuthorisationCode"));
			System.out.println("Amount             : " + enterprise.getTag("Amount"));
			System.out.println("Transaction Index  : " + enterprise.getTag("TransactionIndex"));
		}
		return enterprise;

	}
	
	
	

	private static Element getUniqueXmlElement(org.w3c.dom.Document doc, String uniqueName)
	{
		return getUniqueXmlElement(doc.getDocumentElement(), uniqueName);
	}

	private static Element getUniqueXmlElement(Element parent, String uniqueName)
	{
		NodeList children = parent.getChildNodes();
		for (int i = 0; i < children.getLength(); i++)
		{
			if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				Element child = (Element)children.item(i);
				String tagName = child.getTagName();
				if (tagName.equals(uniqueName))
					return child;
			}
		}
		return null;
	}

}
