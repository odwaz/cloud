package com.iveri.client.example.transaction;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.ResultStatus;

public class NPayHelper
{

	public static class NPayPing
	{
		public NPayPing(JSONObject json) throws JSONException
		{
			Pong = json.getBoolean("Pong");
			Error = json.optString("Error");
		}

		public boolean Pong;
		public String Error;
	}

	public static class NPayPrint
	{
		public NPayPrint(JSONObject json) throws JSONException
		{
			Error = json.optString("Error");
		}

		public String Error;
	}

	public static class NPayEMVComplete
	{
		public NPayEMVComplete(JSONObject json) throws JSONException
		{
			Status = json.optString("Status");
			TransactionStatusInformation = json.optString("TransactionStatusInformation");
			CardHolderVerificationMethodResult = json.optString("CardHolderVerificationMethodResult");
			TerminalCapabilities = json.optString("TerminalCapabilities");
			TerminalVerificationResult = json.optString("TerminalVerificationResult");
			IssuerApplicationData = json.optString("IssuerApplicationData");
			Error = json.optString("Error");
		}

		public String Status;
		public String TransactionStatusInformation;
		public String CardHolderVerificationMethodResult;
		public String TerminalCapabilities;
		public String TerminalVerificationResult;
		public String IssuerApplicationData;
		public String Error;
	}

	public static class NPaySwipe
	{
		public NPaySwipe(JSONObject json) throws JSONException
		{
			PAN = json.optString("PAN");
			Track2 = json.optString("Track2");
			ExpiryMonth = json.optString("ExpiryMonth");
			ExpiryYear = json.optString("ExpiryYear");
			DeviceSerialNumber = json.optString("DeviceSerialNumber");
			DeviceMake = json.optString("DeviceMake");
			PinBlock = json.optString("PinBlock");
			KeySerialNumber = json.optString("KeySerialNumber");
			AccountType = json.optString("AccountType");
			DisplayAmount = json.optString("DisplayAmount");
			Error = json.optString("Error");

			AuthorisationRequestCryptogram = json.optString("AuthorisationRequestCryptogram");
			ApplicationIdentifier = json.optString("ApplicationIdentifier");
			ApplicationInterchangeProfile = json.optString("ApplicationInterchangeProfile");
			CardSequenceNumber = json.optString("CardSequenceNumber");
			ApplicationTransactionCounter = json.optString("ApplicationTransactionCounter");
			ApplicationVersion = json.optString("ApplicationVersion");
			CardHolderVerificationMethodResult = json.optString("CardHolderVerificationMethodResult");
			CryptogramInformationData = json.optString("CryptogramInformationData");
			IssuerApplicationData = json.optString("IssuerApplicationData");
			TerminalCapabilities = json.optString("TerminalCapabilities");
			TerminalType = json.optString("TerminalType");
			TerminalVerificationResult = json.optString("TerminalVerificationResult");
			UnpredictableNumber = json.optString("UnpredictableNumber");
		}

		public String PAN;
		public String Track2;
		public String ExpiryMonth;
		public String ExpiryYear;
		public String DeviceSerialNumber;
		public String DeviceMake;
		public String PinBlock;
		public String KeySerialNumber;
		public String AccountType;
		public String DisplayAmount;
		public String Error;

		public String AuthorisationRequestCryptogram;
		public String ApplicationIdentifier;
		public String ApplicationInterchangeProfile;
		public String CardSequenceNumber;
		public String ApplicationTransactionCounter;
		public String ApplicationVersion;
		public String CardHolderVerificationMethodResult;
		public String CryptogramInformationData;
		public String IssuerApplicationData;
		public String TerminalCapabilities;
		public String TerminalType;
		public String TerminalVerificationResult;
		public String UnpredictableNumber;

	}

	private static String toHttpQueryString(JSONObject json) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		Iterator<Object> keys = json.keys();
		String key;
		while (keys.hasNext())
		{
			key = keys.next().toString();
			sb.append('&').append(key).append('=').append(URLEncoder.encode(json.getString(key), "UTF-8"));
		}
		return sb.length() > 0 ? '?' + sb.toString().substring(1) : "";
	}

	public static JSONObject GetJSON(String command, JSONObject json) throws Exception
	{
		if (json == null)
			json = new JSONObject();
		json.put("output", "json");
		json.put("callback", command);
		json.put("action", command);

		InputStream in = new java.net.URL("http", "localhost", 9014, "//" + toHttpQueryString(json)).openStream();
		ByteArrayOutputStream returned = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer, 0, buffer.length)) != -1)
			returned.write(buffer, 0, len);

		String result = returned.toString("UTF-8");
		if (result.startsWith(command + "(") && result.endsWith(");"))
			return new JSONObject(result.substring(command.length() + 1, result.length() - 2)).getJSONObject("nPay");
		throw new Exception("Could not parse return value: " + result);
	}

	public static boolean IsNPayOnline() throws Exception
	{
		JSONObject parameters = new JSONObject();
		parameters.put("DeviceTimeout", "2");

		NPayPing nPayPing = new NPayPing(GetJSON("ping", parameters));
		if (nPayPing.Error.length() > 0)
			throw new Exception(nPayPing.Error);
		return nPayPing.Pong;
	}

	public static NPaySwipe SwipeCard(String track2sessionkey, String currency, String amount, String cashAmount, String transactionType,
		String confirmTransaction) throws Exception
	{
		JSONObject parameters = new JSONObject();
		parameters.put("DeviceTimeout", "90");
		parameters.put("AcceptPinCard", "true");
		parameters.put("AcceptSignatureCard", "true");
		parameters.put("AcceptSmartCard", "true");
		parameters.put("Track2SessionKey", track2sessionkey);
		parameters.put("Currency", currency);
		parameters.put("Amount", amount);
		parameters.put("ConfirmTransaction", confirmTransaction);
		int amountInt = (amount == null) ? 0 : Integer.parseInt(amount);
		int cashAmountInt = (cashAmount == null) ? 0 : Integer.parseInt(cashAmount);
		int purchaseAmount = amountInt - cashAmountInt;
		parameters.put("PurchaseAmount", purchaseAmount + "");
		if (cashAmount != null && !cashAmount.equals(""))
			parameters.put("CashbackAmount", cashAmount);
		if (transactionType != null)
		{
			parameters.put("TransactionType", transactionType);
		}
		parameters.put("HotCard", "false");
		parameters.put("Budget", "false");
		parameters.put("VelocityAmount", "0");
		parameters.put("FloorLimit", "0");

		NPaySwipe nPaySwipe = new NPaySwipe(GetJSON("swipe", parameters));
		if (nPaySwipe.Error.length() > 0)
			throw new Exception(nPaySwipe.Error);
		return nPaySwipe;
	}

	public static NPayEMVComplete EMVCompleteTransaction(String responseReceived, String authorisationResponseCode, String issuerAuthenticationData,
		String issuerScriptTemplate1, String issuerScriptTemplate2) throws Exception
	{
		JSONObject parameters = new JSONObject();
		parameters.put("ResponseRecieved", responseReceived);
		parameters.put("AuthorisationResponseCode", authorisationResponseCode);
		parameters.put("IssuerAuthenticationData", issuerAuthenticationData);
		parameters.put("IssuerScriptTemplate1", issuerScriptTemplate1);
		parameters.put("IssuerScriptTemplate2", issuerScriptTemplate2);

		NPayEMVComplete nPayEMV = new NPayEMVComplete(GetJSON("emv", parameters));
		if (nPayEMV.Error.length() > 0)
			throw new Exception(nPayEMV.Error);
		return nPayEMV;
	}

	public static void PrintResult(Enterprise e) throws Exception
	{
		if (e.getResultStatus() == ResultStatus.UNSUCCESSFUL)
			throw new Exception("Unsuccesful results are not printed");

		JSONObject parameters = new JSONObject();
		parameters.put("Category", "Transaction");
		parameters.put("MerchantName", e.getTag("MerchantName"));
		parameters.put("MerchantUSN", e.getTag("MerchantUSN"));
		parameters.put("ResultStatus", Integer.toString(e.getResultStatus().getValue()));
		parameters.put("DottedPan", e.getTag("PAN"));
		parameters.put("ExpiryMonth", e.getTag("ExpiryDate").substring(0, 2));
		parameters.put("ExpiryYear", e.getTag("ExpiryDate").substring(2));
		parameters.put("AccountType", e.getTag("AccountType"));
		parameters.put("TransactionTypeDescription", "SALE");
		parameters.put("DisplayTransactionDateTime", e.getTag("AcquirerDate") + " " + e.getTag("AcquirerTime"));
		parameters.put("DisplayTransactionAmount", e.getTag("DisplayAmount"));
		parameters.put("AuthorisationCode", e.getTag("AuthorisationCode"));
		parameters.put("Acquirer", e.getTag("Acquirer"));
		parameters.put("AcquirerReference", e.getTag("AcquirerReference"));
		parameters.put("DeviceSerialNumber", e.getTag("DeviceSerialNumber"));

		NPayPrint nPayPrint = new NPayPrint(GetJSON("print", parameters));
		if (nPayPrint.Error.length() > 0)
			throw new Exception(nPayPrint.Error);
	}
}
