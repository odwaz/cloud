ackage com.iveri.client.example.transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import iveri.common.router.miura.api.MiuraDriver;
import iveri.common.router.miura.test.BluetoothProvider;
import iveri.common.router.miura.test.SocketProvider;
import iveri.common.router.mobilepos.MobilePosCallBack;
import iveri.common.router.mobilepos.exception.MobilePosException;
import iveri.common.router.mobilepos.util.ParameterKey;
import iveri.common.util.json.JSONObject;

public class MiuraHelper implements MobilePosCallBack
{
	private MiuraDriver driver = null;
	private BluetoothProvider bluetoothProvider = null;
	private SocketProvider socketProvider = null;
	
	public MiuraDriver CreateBluetoothConnection(String jsonProperties) throws IOException, InterruptedException, MobilePosException
	{
		String url = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DiscoveryAgent da = LocalDevice.getLocalDevice().getDiscoveryAgent();
		RemoteDevice[] rds = da.retrieveDevices(DiscoveryAgent.PREKNOWN);
		System.out.println("\nAvailable bluetooth devices...\n");
		for (int i = 0; i < rds.length; i++)
		{
			RemoteDevice rd  = rds[i];
			try {						
				System.out.println((i+1) + ". " + rd.getFriendlyName(false));						
			} catch (IOException e) {
				continue;
			}
		}
		boolean correct = false;
		RemoteDevice device = rds[0];
		while (!correct)
		{
			System.out.println();
			System.out.print("Select device : ");
			try
			{
				String selected = br.readLine().trim();
				int num = Integer.parseInt(selected);
				if (num > 0 && num <= rds.length)
				{
					correct = true;
					device = rds[num - 1];
				}
			}
			catch (Exception ex)
			{
				System.out.println("Invalid selection!");
			}
		}
		url = "btspp://" + device.getBluetoothAddress() + ":1";
		bluetoothProvider = new BluetoothProvider(url);
		
		//Instantiate the driver
		driver = new MiuraDriver(this, bluetoothProvider, jsonProperties);
		return driver;
	}
	
	public void CloseBluetoothConnection()
	{
		bluetoothProvider.closeCurrentConnection(0);
		bluetoothProvider = null;
	}

	public MiuraDriver CreateSocketConnection(String jsonProperties) throws MobilePosException
	{
		socketProvider = new SocketProvider("0.0.0.0", Integer.valueOf(Configuration.getWifiPort()));	
		
		//Instantiate the driver
		driver = new MiuraDriver(this, socketProvider, jsonProperties);
		return driver;
	}
	
	public void CloseSocketConnection()
	{
		socketProvider.closeCurrentSocket(0);
		socketProvider = null;
	}

	@Override
	public void callBackMethod(String json)
	{
		try
		{
			JSONObject jsonObject = new JSONObject(json);
			System.out.println("Device Status: " + jsonObject.get(ParameterKey.StatusDescription));
		}
		catch (Exception x)
		{
			x.printStackTrace();
		}
	}

	@Override
	public InputStream callBackFileData(String name)
	{		
		return EnterpriseTransaction.getBINInputStream();
	}

	@Override
	public void callBackFileData(String name, InputStream stream)
	{
		// TODO Auto-generated method stub
		
	}	
}
