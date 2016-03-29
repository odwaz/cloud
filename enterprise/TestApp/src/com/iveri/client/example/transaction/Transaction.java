ackage com.iveri.client.example.transaction;

import iveri.common.router.miura.util.MessageUtil;
import iveri.common.router.mobilepos.util.ParameterKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.iveri.client.example.menu.Menu;
import com.iveri.client.example.menu.Menu.MenuAction;
import com.iveri.client.example.transaction.*;
import com.iveri.enterprise.Enterprise;
import com.iveri.enterprise.ResultException;

public class Transaction
{

	
	private Enterprise previousEnterpriseResponse = null;
	private Document previousWebServiceResponse = null;
	private boolean addAirlineData = false;
	private boolean addCybersourceData = false;
	public static final String LOG_FILE = "mpi.log";

	
	

	
	

	

	
	public void checkAirlineData()
	{
		addAirlineData = checkAdditionalData("Airline Data");
		if (addAirlineData)
			System.out.println("Airline data enabled. Transactions will contain sample Airline data.");
		else
			System.out.println("Airline data disabled. Transactions will not contain sample Airline data.");
	}

	public void checkCybersourceData()
	{
		addCybersourceData = checkAdditionalData("Cybersource Data");
		if (addCybersourceData)
			System.out.println("Cybersource data enabled. Transactions will contain sample Cybersource data.");
		else
			System.out.println("Cybersource data disabled. Transactions will not contain sample Cybersource data.");
	}
	
	
	

	


	
			

	
	

	

	
	private boolean checkAdditionalData(String tag)
	{
		System.out.println();
		while (true)
		{
			System.out.print("Enter E or D to Enable/Disable " + tag + " [D] : ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try
			{
				String choice = br.readLine().trim();
				if (choice.equals(""))
					return false;
				else if (choice.equalsIgnoreCase("E"))
					return true;
				else if (choice.equalsIgnoreCase("D"))
					return false;
				else
					System.out.println("Invalid Input!");
			}
			catch (IOException e)
			{
				System.out.println("Invalid Input!");
			}
		}
	}
}
