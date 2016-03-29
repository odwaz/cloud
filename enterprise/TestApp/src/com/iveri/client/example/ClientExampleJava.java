package com.iveri.client.example;

import javax.xml.transform.TransformerException;

import com.iveri.client.example.menu.Menu;
import com.iveri.client.example.menu.Menu.MenuAction;
import com.iveri.client.example.transaction.Transaction;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.ResultException;
import com.iveri.enterprise.ResultExceptionAction;
import com.iveri.enterprise.ResultStatus;

public class ClientExampleJava {

	//----USER CONFIGURATION-----
		//These settings only apply if a demo.xml file is not found
		static String gateway = "host"; // Change gateway here if not using iVeriClient config file default
		static String certificateID = "a2120034-9ce1-467e-82e5-e42d349f61d5"; // Enter GUID here if not using iVeriClient config file default
		static String applicationID = "67ccde9f-d03c-480c-a86a-d9d0a7e8aa48"; // Enter GUID here
		static String mode = "Test"; // Change default mode here
        // Change the Credit Card number here
		//static String expiry = "1216"; // Change the creditcard expiry date here (MMYY)
		//static String amount = "123"; // Change the amount in cents, here (1.23)
	static String currency = "USD"; // Change the amount in cents, here (1.23)

	public static void main(String args []) throws ResultException
	
	
	{
		Debit();
		
	}
	
	
	
	public static void Debit() throws ResultException
		{
			


		Enterprise e = new Enterprise (gateway, certificateID, ResultExceptionAction.RESULT_EXCEPTION_ON_UNSUCCESSFUL); 
		
		
		
			e.prepare("Enquiry", "ThreeDSecureCheckEnrollment", applicationID, mode);
			e.setAttribute("MerchantReference", String.valueOf(System.currentTimeMillis()));
			e.setTag("Amount", "100"); // R1.23
			e.setTag("CCNumber", "4000000000000002");
			e.setTag("ExpiryDate", "122017");
		    e.setTag("Currency","USD");				
			System.out.println(e.getLoggableRequest());
			
			
			ResultStatus resultStatus = e.execute();
			
			
			
			
			
			System.out.println("Result : " + resultStatus.getValue());
			if (resultStatus == ResultStatus.UNSUCCESSFUL)
			{
				// Display the result (eg. DENIED or ApplicationID not configured)
				System.out.println("Result code : " + e.getResultCode());
				System.out.println("Result source : " + e.getResultSource());
				System.out.println("Result description : " + e.getResultDescription());
			} 
			else if (resultStatus == ResultStatus.SUCCESSFUL || resultStatus == ResultStatus.SUCCESSFUL_WITH_WARNING)
			{
				System.out.println("RequestID : " + e.getAttribute("RequestID"));
				System.out.println("Acquirer Reference : " + e.getTag("AcquirerReference"));
				System.out.println("Acquirer Date : " + e.getTag("AcquirerDate"));
				System.out.println("Acquirer Time : " + e.getTag("AcquirerTime"));
				System.out.println("Authorisation Code : " + e.getTag("AuthorisationCode"));
				System.out.println("Amount : " + e.getTag("Amount"));
				System.out.println("Terminal : " + e.getTag("Terminal"));
				System.out.println("Transaction Index : " + e.getTag("TransactionIndex"));
				
				System.out.println("ThreeDSecure_PARec :" +e.getTag("ThreeDSecure_RequestID"));
				System.out.println("ThreeDSecure_ACS_URL :"+ e.getTag("ThreeDSecure_ACS_URL"));
				System.out.println("CardHolderAuthenticationID :"+ e.getTag("CardHolderAuthenticationID"));
				
				
				System.out.println();
				System.out.println("Response");
				try {
					System.out.println(e.getLoggableResponse());
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}

