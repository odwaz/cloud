package com.iveri.client.example.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu
{
	public enum MenuAction
	{
		AuthManual,
		AuthNpay,
		AuthMiura,
		DebitManual,
		DebitNpay,
		DebitMiura,
		DebitFollowUp,
		DebitTokenMerchantRef,
		DebitTokenTranIndex,
		DebitTokenMsisdn,
		CreditManual,
		CreditNpay,
		CreditMiura,
		CreditFollowUp,
		CreditTokenMerchantRef,
		CreditTokenTranIndex,
		VoidMerchantTrace,
		VoidRequestID,
		AdditionalAirline,
		AdditionalCybersource,
		ReprintLastMiuraTransaction,
		SystemLog,
		None,
		Back,
		Exit
	}

	public enum MenuItem
	{
		Main("Menu", 0, "0", "-1", MenuAction.None),

		Auth("Authorisation", 1, "1", "Main", MenuAction.None),
		Debit("Debit/Sale", 1, "2", "Main", MenuAction.None),
		Credit("Credit/Refund", 1, "3", "Main", MenuAction.None),
		Void("Void", 1, "4", "Main", MenuAction.None),
		Additional("Additional Data", 1, "5", "Main", MenuAction.None),
		ReprintLastMiuraTransaction("ReprintLastMiuraTransaction", 1, "6", "Main", MenuAction.ReprintLastMiuraTransaction),
		SystemLog("System Log", 1, "7", "Main", MenuAction.SystemLog),

		AuthManual("Manual", 2, "1", "Auth", MenuAction.AuthManual),
		AuthNpay("NPay", 2, "2", "Auth", MenuAction.AuthNpay),
		AuthMiura("Miura", 2, "3", "Auth", MenuAction.AuthMiura),

		DebitManual("Manual", 2, "1", "Debit", MenuAction.DebitManual),
		DebitNpay("NPay", 2, "2", "Debit", MenuAction.DebitNpay),
		DebitToken("Token", 2, "3", "Debit", MenuAction.None),
		DebitFollowUp("Follow Up", 2, "4", "Debit", MenuAction.DebitFollowUp),
		DebitMiura("Miura", 2, "5", "Debit", MenuAction.DebitMiura),

		CreditManual("Manual", 2, "1", "Credit", MenuAction.CreditManual),
		CreditNpay("NPay", 2, "2", "Credit", MenuAction.CreditNpay),
		CreditToken("Token", 2, "3", "Credit", MenuAction.None),
		CreditFollowUp("Follow Up", 2, "4", "Credit", MenuAction.CreditFollowUp),
		CreditMiura("Miura", 2, "5", "Credit", MenuAction.CreditMiura),

		VoidMerchantTrace("Merchant Trace", 2, "1", "Void", MenuAction.VoidMerchantTrace),
		VoidRequestID("Request ID", 2, "2", "Void", MenuAction.VoidRequestID),

		Airline("Airline", 2, "1", "Additional", MenuAction.AdditionalAirline),
		Cybersource("Cybersource", 2, "2", "Additional", MenuAction.AdditionalCybersource),

		DebitTokenMerchantRef("Merchant Reference", 3, "1", "DebitToken", MenuAction.DebitTokenMerchantRef),
		DebitTokenTranIndex("Transaction Index", 3, "2", "DebitToken", MenuAction.DebitTokenTranIndex),
		DebitTokenMsisdn("MSISDN", 3, "3", "DebitToken", MenuAction.DebitTokenMsisdn),

		CreditTokenMerchantRef("Merchant Reference", 3, "1", "CreditToken", MenuAction.CreditTokenMerchantRef),
		CreditTokenTranIndex("Transaction Index", 3, "2", "CreditToken", MenuAction.CreditTokenTranIndex),	

		
		Back("Back", 0, "B", "Back", MenuAction.Back),
		Exit("Exit", 0, "X", "Exit", MenuAction.Exit);

		private String display;
		private int level;
		private String option;
		private String parent;
		private MenuAction action;

		private MenuItem(String display, int level, String option, String parent, MenuAction action)
		{
			this.display = display;
			this.level = level;
			this.option = option;
			this.parent = parent;
			this.action = action;
		}

		public String getDisplay()
		{
			return display;
		}

		public int getLevel()
		{
			return level;
		}

		public String getOption()
		{
			return option;
		}

		public String getParent()
		{
			return parent;
		}

		public MenuAction getAction()
		{
			return action;
		}

		public static MenuItem getMenuItem(String name)
		{
			for (MenuItem item : MenuItem.values())
			{
				if (item.name().equalsIgnoreCase(name))
					return item;
			}
			return MenuItem.Main;
		}

		public static ArrayList<MenuItem> displayMenuItems(int level, String parent)
		{
			ArrayList<MenuItem> list = new ArrayList<MenuItem>();
			String title = getMenuItem(parent).getDisplay();
			System.out.println(title);
			for (int i = 0; i < title.length(); i++)
				System.out.print("-");
			System.out.println();
			for (MenuItem item : MenuItem.values())
			{
				if (item.getLevel() == level && item.getParent().equalsIgnoreCase(parent))
				{
					System.out.println("[" + item.getOption() + "] " + item.getDisplay());
					list.add(item);
				}
			}
			if (level != 1)
			{
				System.out.println("[B] Back");
				list.add(MenuItem.Back);
			}
			System.out.println("[X] Exit");
			list.add(MenuItem.Exit);
			return list;
		}

	}

	public Menu()
	{
	}

	public static MenuAction displayMenu()
	{
		int level = 1;
		String parent = "Main";
		MenuItem selected = MenuItem.Auth;
		String defaultOption = "1";
		while (true)
		{
			System.out.println("\n");
			ArrayList<MenuItem> list = MenuItem.displayMenuItems(level, parent);
			if (level == 1)
				defaultOption = "1";
			String input = getInput("Choice", defaultOption);
			boolean validInput = false;
			//			defaultOption = input;
			for (MenuItem item : list)
			{
				if (item.getOption().equalsIgnoreCase(input))
				{
					selected = item;
					defaultOption = item.getOption();
					validInput = true;
				}
			}
			if (!validInput)
			{
				System.out.println("invalid choice.");
				continue;
			}
			switch (selected.getAction())
			{
			case None:
				level++;
				parent = selected.name();
				break;
			case Back:
				level--;
				parent = MenuItem.getMenuItem(list.get(0).getParent()).getParent();
				break;
			case Exit:
				return MenuAction.Exit;
			default:
				return selected.getAction();
			}
		}

	}

	public static String getInput(String action, String defaultValue)
	{
		System.out.println();
		if (defaultValue == null)
			System.out.print(action);
		else
			System.out.print(action + "[" + defaultValue + "] : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			String choice = br.readLine().trim();
			if (choice.equals(""))
				choice = defaultValue;
			return choice;
		}
		catch (IOException e)
		{
			System.out.println("Invalid " + action + "!");
		}
		return "X";
	}

}
