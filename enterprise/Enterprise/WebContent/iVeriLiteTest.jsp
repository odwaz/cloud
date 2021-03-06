<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>iVeri Lite Example Asp Page</title>
	</head>
<body>
	<h2>iVeri Lite Example HTML Page</h2>
	<p>The following is an example that is designed to give developers an idea of what a
		payment page could look like.</p>
	<p>The customer is at the point in the purchase process where the basket has already
		been chosen and the customer is now on the brink of actually paying for it. The web
		site thus knows the price of the basket (99 cents), the Invoice Number
		(AUTOGENERATE) and, once the button has been clicked, the customers details.</p>
	<p>This example, although it could actually be used in a site, is intended as a guide
		to the logic involved in actually making the online debit.</p>
		
<form METHOD="POST" ACTION="https://backoffice.nedsecure.co.za/Lite/Transactions/New/EasyAuthorise.aspx" id="aForm" name="aForm">
<center>
	<table cellpadding="0" cellspacing="0" border="0" width="600" height="100%">
<!-- Lite -->
    <tr>
        <td align="left">
            Application Id:
        </td>
        <td align="left">
           <input type="text" id="Lite_Merchant_ApplicationID" name="Lite_Merchant_ApplicationID" value="d8b3ae1c-6e8a-41da-8c36-7323242f7e91" size="45" />
         </td>
    </tr>

    <!-- BillTo -->
        <tr>
            <td align="left">
                Name:
            </td>
            <td align="left">
				<SELECT id="Ecom_BillTo_Postal_Name_Prefix" name="Ecom_BillTo_Postal_Name_Prefix">
				    <option value="Mr." >Mr.</option>
				    <option value="Mrs." >Mrs.</option>
				    <option value="Miss." >Miss.</option>
				    <option value="Ms." >Ms.</option>
				    <option value="Prof." >Prof.</option>
				    <option value="Dr." >Dr.</option>
				    <option value="Sir." >Sir.</option>
				</SELECT>
				    <input type="text" id="Ecom_BillTo_Postal_Name_First" name="Ecom_BillTo_Postal_Name_First" value="John" size="8" />
				    <input type="hidden" id="Ecom_BillTo_Postal_Name_Middle" name="Ecom_BillTo_Postal_Name_Middle" value="" />
				    <input type="text" id="Ecom_BillTo_Postal_Name_Last" name="Ecom_BillTo_Postal_Name_Last" value="Doe" size="10" />
            </td>
        </tr>    
        
        <tr>
            <td align="left">
                Email:
            </td>
            <td align="left">
				<!-- Merchant should use his/her Test Application ID provided by iVeri untill such time that they go live -->
				
			    <input type="hidden" id="Lite_Order_Amount" name="Lite_Order_Amount" value="99" />
			    <input type="hidden" id="Lite_Order_Terminal" name="Lite_Order_Terminal" value="Web" />
			    <input type="hidden" id="Lite_Order_AuthorisationCode" name="Lite_Order_AuthorisationCode" value="" />
			    <input type="hidden" id="Lite_Order_BudgetPeriod" name="Lite_Order_BudgetPeriod" value="0" />
			    <input type="hidden" id="Lite_Website_TextColor" name="Lite_Website_TextColor" value="#ffffff" />
			    <input type="hidden" id="Lite_Website_BGColor" name="Lite_Website_BGColor" value="#86001B" />
			    <input type="hidden" id="Lite_ConsumerOrderID_PreFix" name="Lite_ConsumerOrderID_PreFix" value="PPP" />
			    <input type="hidden" id="Lite_On_Error_Resume_Next" name="Lite_On_Error_Resume_Next" value="True" />
			
			<!-- products -->
			    <input type="hidden" id="Lite_Order_LineItems_Product_1" name="Lite_Order_LineItems_Product_1" value="Donation product#1" />
			    <input type="hidden" id="Lite_Order_LineItems_Quantity_1" name="Lite_Order_LineItems_Quantity_1" value="1" />
			    <input type="hidden" id="Lite_Order_LineItems_Amount_1" name="Lite_Order_LineItems_Amount_1" value="35" />
			
			    <input type="hidden" id="Lite_Order_LineItems_Product_2" name="Lite_Order_LineItems_Product_2" value="Donation product#2" />
			    <input type="hidden" id="Lite_Order_LineItems_Quantity_2" name="Lite_Order_LineItems_Quantity_2" value="2" />
			    <input type="hidden" id="Lite_Order_LineItems_Amount_2" name="Lite_Order_LineItems_Amount_2" value="32" />
			
				<!--
							The following url's are used as examples. They do not exist and cant be used for
							development or debugging.
														-->
			    <input type="hidden" ID="Lite_Website_Successful_url" NAME="Lite_Website_Successful_url" VALUE="http://localhost:8282/Enterprise/result.jsp" />
			    <input type="hidden" ID="Lite_Website_Fail_url" NAME="Lite_Website_Fail_url" VALUE="http://localhost:8282/Enterprise/result.jsp" />
			    <input type="hidden" ID="Lite_Website_TryLater_url" NAME="Lite_Website_TryLater_url" VALUE="http://localhost:8282/Enterprise/result.jsp" />
			    <input type="hidden" ID="Lite_Website_Error_url" NAME="Lite_Website_Error_url" VALUE="http://localhost:8282/Enterprise/result.jsp" />
			
			<!-- Ecml start-->
			
			    <!-- ShipTo -->
			    <input type="hidden" id="Ecom_ShipTo_Postal_Name_Prefix" name="Ecom_ShipTo_Postal_Name_Prefix" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Name_First" name="Ecom_ShipTo_Postal_Name_First" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Name_Middle" name="Ecom_ShipTo_Postal_Name_Middle" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Name_Last" name="Ecom_ShipTo_Postal_Name_Last" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Name_Suffix" name="Ecom_ShipTo_Postal_Name_Suffix" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Street_Line1" name="Ecom_ShipTo_Postal_Street_Line1" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Street_Line2" name="Ecom_ShipTo_Postal_Street_Line2" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_Street_Line3" name="Ecom_ShipTo_Postal_Street_Line3" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_City" name="Ecom_ShipTo_Postal_City" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_StateProv" name="Ecom_ShipTo_Postal_StateProv" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_PostalCode" name="Ecom_ShipTo_Postal_PostalCode" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Postal_CountryCode" name="Ecom_ShipTo_Postal_CountryCode" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Telecom_Phone_Number" name="Ecom_ShipTo_Telecom_Phone_Number" value="" />
			    <input type="hidden" id="Ecom_ShipTo_Online_Email" name="Ecom_ShipTo_Online_Email" value="" />
			
			    <!-- ReceiptTo -->
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Name_Prefix" name="Ecom_ReceiptTo_Postal_Name_Prefix" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Name_First" name="Ecom_ReceiptTo_Postal_Name_First" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Name_Middle" name="Ecom_ReceiptTo_Postal_Name_Middle" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Name_Last" name="Ecom_ReceiptTo_Postal_Name_Last" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Name_Suffix" name="Ecom_ReceiptTo_Postal_Name_Suffix" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Street_Line1" name="Ecom_ReceiptTo_Postal_Street_Line1" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Street_Line2" name="Ecom_ReceiptTo_Postal_Street_Line2" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_Street_Line3" name="Ecom_ReceiptTo_Postal_Street_Line3" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_City" name="Ecom_ReceiptTo_Postal_City" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_StateProv" name="Ecom_ReceiptTo_Postal_StateProv" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_PostalCode" name="Ecom_ReceiptTo_Postal_PostalCode" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Postal_CountryCode" name="Ecom_ReceiptTo_Postal_CountryCode" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Telecom_Phone_Number" name="Ecom_ReceiptTo_Telecom_Phone_Number" value="" />
			    <input type="hidden" id="Ecom_ReceiptTo_Online_Email" name="Ecom_ReceiptTo_Online_Email" value="" />
			
			    <!-- Payment -->
			    <input type="hidden" id="Ecom_Payment_Card_Name" name="Ecom_Payment_Card_Name" value="" />
			    <input type="hidden" id="Ecom_Payment_Card_Type" name="Ecom_Payment_Card_Type" value="" />
			
			    <input type="hidden" id="Ecom_BillTo_Postal_Name_Suffix" name="Ecom_BillTo_Postal_Name_Suffix" value="iVeri" />
			    <input type="hidden" id="Ecom_BillTo_Postal_Street_Line1" name="Ecom_BillTo_Postal_Street_Line1" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_Street_Line2" name="Ecom_BillTo_Postal_Street_Line2" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_Street_Line3" name="Ecom_BillTo_Postal_Street_Line3" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_City" name="Ecom_BillTo_Postal_City" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_StateProv" name="Ecom_BillTo_Postal_StateProv" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_PostalCode" name="Ecom_BillTo_Postal_PostalCode" value="" />
			    <input type="hidden" id="Ecom_BillTo_Postal_CountryCode" name="Ecom_BillTo_Postal_CountryCode" value="" />
			    <input type="hidden" id="Ecom_BillTo_Telecom_Phone_Number" name="Ecom_BillTo_Telecom_Phone_Number" value="4457500" />
                <input type="text" id="Ecom_BillTo_Online_Email" name="Ecom_BillTo_Online_Email" value="" size="20" />
            </td>
        </tr>    


        <tr>
            <td align="left">
                Credit Card    Number:
            </td>
            <td align="left">
                <input TYPE="text" ID="Ecom_Payment_Card_Number" NAME="Ecom_Payment_Card_Number" VALUE="" size="20" />
                <small>Please type your credit card number without any spaces or hyphens</small>
            </td>
        </tr>
        <tr>
            <td align="left">
                Expiry Date:
            </td>
            <td align="left">
                <input type="hidden" id="Ecom_Payment_Card_StartDate_Day" name="Ecom_Payment_Card_StartDate_Day" value="00" />
                <input type="hidden" id="Ecom_Payment_Card_StartDate_Month" name="Ecom_Payment_Card_StartDate_Month" value="07" size="2" />
                <input type="hidden" id="Ecom_Payment_Card_StartDate_Year" name="Ecom_Payment_Card_StartDate_Year" value="1999" size="4" /><br />
                <input type="hidden" id="Ecom_Payment_Card_ExpDate_Day" name="Ecom_Payment_Card_ExpDate_Day" value="00" />
                <input type="text" id="Ecom_Payment_Card_ExpDate_Month" name="Ecom_Payment_Card_ExpDate_Month" value="07" size="2" />
                <input type="text" id="Ecom_Payment_Card_ExpDate_Year" name="Ecom_Payment_Card_ExpDate_Year" value="2001" size="4" /><br />
			    <input type="hidden" id="Ecom_Payment_Card_Verification" name="Ecom_Payment_Card_Verification" value="" />
			    <input type="hidden" id="Ecom_Payment_Card_Protocols" name="Ecom_Payment_Card_Protocols" value="iVeri" />
            </td>
        </tr>

        <tr>
            <td align="left">
                Invoice:
            </td>
            <td align="left">
                <input TYPE="text" ID="Ecom_ConsumerOrderID" NAME="Ecom_ConsumerOrderID" VALUE="AUTOGENERATE" size="20" />
			    <input type="hidden" id="Ecom_SchemaVersion" name="Ecom_SchemaVersion" value="" />
			    <input type="hidden" id="Ecom_TransactionComplete" name="Ecom_TransactionComplete" value="False" />
			<!-- Ecml end-->
			
			<!--Lite Version-->
			    <input type="hidden" id="Lite_Version" name="Lite_Version " value="2.0" />
			<!-- Version end-->
            </td>
        </tr>

        <tr>
            <td align="left"><input TYPE="SUBMIT" NAME="Authorise" VALUE="Authorise" /> </td>
            <td align="left"><input TYPE="RESET" NAME="Clear" VALUE="Clear" /> </td>
        </tr>
    </table>
</center>
</form>

</body>
</html>
