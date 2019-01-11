package com.API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


import com.Bean.Forex;
import com.Bean.GoogAPIBean;

public class FOREXRetrieval {
	
	
	
	public static Forex hoja (String s)
	{

		Forex usd1=new Forex();
		System.out.println("INSIDE FUNCtion");
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter username: ");
		final String uname = "user";
		//System.out.println("Enter password: ");
		final String pass = "password";
		System.setProperty("http.proxyHost", "proxy.tcs.com");
		System.setProperty("http.proxyPort", "8080");
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("India.TCS.com\\" + uname,
						pass.toCharArray());
			}
		});

		URLConnection ucon = null;
		URL url = null;
		BufferedReader br = null;

		try {
			// url = new
			// URL("http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab");
			url = new URL(s);
			ucon = url.openConnection();
			ucon.connect();
		}

		catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			 //InputStream in = url.openStream();
				 br = new BufferedReader(new InputStreamReader(
						ucon.getInputStream()));
		
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
		
				while (line != null) {
					sb.append(line);
					sb.append("\n");
					line = br.readLine();
				}
				//CODE FOR RETRIEVAL
				 String masala=sb.toString();
				 masala = masala.trim();
					masala = masala.replace("[", "");
					masala = masala.replace("]", "");
					masala = masala.replace("{", "");
					masala = masala.replace("}", "");
					masala=masala.replace("\"", "");
					 masala=masala.replace("(\\r|\\n)", "");

					String[] cot = masala.split(",");

					String name="Name";
					String rate="Rate";
					String ask="Ask";
					String bid="Bid";
					
					int temp_name=-1;
					int temp_rate=-1;
					int temp_ask=-1;
					int temp_bid=-1;
					
					
					for(int i=0;i<cot.length;i++)
					{
						if(cot[i].contains(name))
						{
							temp_name=i;
						}
						if(cot[i].contains(rate))
						{
							temp_rate=i;
						}
						if(cot[i].contains(ask))
						{
							temp_ask=i;
						}
						if(cot[i].contains(bid))
						{
							temp_bid=i;
						}
					}
					String res_name=(cot[temp_name].substring(cot[temp_name].indexOf(":") +1));
					String res_rate=(cot[temp_rate].substring(cot[temp_rate].indexOf(":") +1));
					String res_ask=(cot[temp_ask].substring(cot[temp_ask].indexOf(":") +1));
					String res_bid=(cot[temp_bid].substring(cot[temp_bid].indexOf(":") +1));
					
					usd1=new Forex();
					usd1.setStockName(res_name);
					usd1.setStockSymbol(res_name);
					usd1.setCurrentPrice(Double.parseDouble(res_rate));
					usd1.setBuyingPrice(Double.parseDouble(res_ask));
					usd1.setSellingPrice(Double.parseDouble(res_bid));
					//System.out.println(usd.getName()+"  "+usd.getRate()+"  "+usd.getAsk()+"  "+usd.getBid());
				
					
					
					
					
					
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return usd1;
	}
	
	public static ArrayList<Forex> returnFOREX ()
	{
		String usdlink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22USDINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String eurolink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22EURINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String gbplink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22GBPINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String audlink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22AUDINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String jpylink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22JPYINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String dirlink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22AEDINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		String sgdlink="http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20(%22SGDINR%22)&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		
		
		Forex usd=hoja(usdlink);
		Forex euro=hoja(eurolink);
		Forex gbp=hoja(gbplink);
		Forex aud=hoja(audlink);
		Forex jpy=hoja(jpylink);
		Forex dir=hoja(dirlink);
		Forex sgd=hoja(sgdlink);
		
		
		
		ArrayList<Forex> forex=new ArrayList<>();
		forex.add(usd);
		forex.add(euro);
		forex.add(gbp);
		forex.add(aud);
		forex.add(jpy);
		forex.add(dir);
		forex.add(sgd);
		
		System.out.println("REtrieved"+forex.size());
		

		
		return forex;
	}

}
