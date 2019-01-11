package com.API;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Scanner;
//import java.util.Set;

import com.Bean.GoogAPIBean;

public class NASDAQRetrieval {
	
	public static GoogAPIBean hoja (String[] sym, String symbol)
	{
		GoogAPIBean res=new GoogAPIBean();
			String name="name";
			// String symbol="t";
			 String live="l_fix";
			 String perchange="cp";
			 String preclose="pcls_fix";
			 String high="hi ";
			 String low="lo ";
			 String high52="hi52";
			 String low52="lo52";
			 
			 int temp_name=-1;
				int temp_live=-1;
				int temp_perchange=-1;
				int temp_preclose=-1;
				
				int temp_high=-1;
				//int temp_h2=-1;
				
				int temp_low=-1;
				//int temp_h3=-1;
				
				int temp_high52=-1;
				//int temp_h4=-1;
				
				int temp_low52=-1;
				
				
				for (int i = 0; i < sym.length; i++) {
					sym[i]=sym[i].replaceAll("[\n\r]", "");
					//System.out.println(cot[i]);
					if(sym[i].contains(name))
			        {
		        		temp_name=i;
			        }
					if(sym[i].contains(live))
			        {
		        		temp_live=i;
			        }
					if(sym[i].contains(perchange))
			        {
		        		temp_perchange=i;
			        }
					if(sym[i].contains(preclose))
			        {
		        		temp_preclose=i;
			        }
					if(sym[i].contains(high))
			        {
		        		temp_high=i;
			        }
					if(sym[i].contains(low))
			        {
		        		temp_low=i;
			        }
					if(sym[i].contains(high52))
			        {
		        		temp_high52=i;
			        }
					if(sym[i].contains(low52))
			        {
		        		temp_low52=i;
			        }
					

				}
				String res_name=(sym[temp_name].substring(sym[temp_name].indexOf(":")+2 ));
				String res_live=(sym[temp_live].substring(sym[temp_live].indexOf(":")+2));
				String res_perchange=(sym[temp_perchange].substring(sym[temp_perchange].indexOf(":")+2));
				String res_preclose=(sym[temp_preclose].substring(sym[temp_preclose].indexOf(":")+2));
				
				String m1=(sym[temp_high]);
				String res_high=m1.substring(m1.indexOf(":")+2);
				
				String m2=(sym[temp_low]);
				String res_low=m2.substring(m2.indexOf(":")+2);
				
				String m3=(sym[temp_high52]);
				String res_high52=m3.substring(m3.indexOf(":")+2);
				
				String res_low52=sym[temp_low52].substring(sym[temp_low52].indexOf(":")+2 );
				
				
				res.setStockName(res_name);
				res.setStockSymbol(symbol);
				res.setCurrentPrice(Double.parseDouble(res_live));
				res.setChange(Double.parseDouble(res_perchange));
				res.setLastChanged(Double.parseDouble(res_preclose));
				res.setBuyingPrice(Double.parseDouble(res_high));
				res.setSellingPrice(Double.parseDouble(res_low));
				res.setHigh52(Double.parseDouble(res_high52));
				res.setLow52(Double.parseDouble(res_low52));
				res.setMarketType("NASDAQ");
				
			
				
		
		return res;
	}

	
	public static ArrayList<GoogAPIBean> returnNASDAQ (){
		// TODO Auto-generated method stub
		 ArrayList<GoogAPIBean> nasdaq=new ArrayList<>();
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter username: ");
		final String uname ="user";
		//System.out.println("Enter password: ");
		final String pass = "pasword";
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
			url = new URL(
					"http://www.google.com/finance/info?infotype=infoquoteall&q=NASDAQ:MSFT,AAPL,GOOG,ADBE,TSLA,REDF,QCOM,NVDA,CTSH,YHOO");
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

					String[] cot = masala.split("\"id\"");
					
					 //String[] sym={"MSFT","APPL","GOOG","ADBE","TSLA","REDF","QCOM","NVDA","CTSH","YHOO"};
					// String temp=null;
					// GoogAPIBean g=null;
					
					 String[] msft=null;
					 String[] appl=null;
					 String[] goog=null;
					 String[] adbe=null;
					 String[] tsla=null;
					 String[] redf=null;
					 String[] qcom=null;
					 String[] nvda=null;
					 String[] ctsh=null;
					 String[] yhoo=null;
					 
					 for(int k=0;k<cot.length;k++)
					 {
						 cot[k]=cot[k].replace("\"", "");
						 cot[k]=cot[k].replace("(\\r|\\n)", "");
						 if(cot[k].contains("MSFT"))
						 {
							 msft= cot[k].split(",");
						 }
						 if(cot[k].contains("AAPL"))
						 {
							 appl= cot[k].split(",");
						 }
						 if(cot[k].contains("GOOG"))
						 {
							 goog= cot[k].split(",");
						 }
						 if(cot[k].contains("ADBE"))
						 {
							 adbe= cot[k].split(",");
						 }
						 if(cot[k].contains("TSLA"))
						 {
							 tsla= cot[k].split(",");
						 }
						 if(cot[k].contains("REDF"))
						 {
							 redf= cot[k].split(",");
						 }
						 if(cot[k].contains("QCOM"))
						 {
							 qcom= cot[k].split(",");
						 }
						 if(cot[k].contains("NVDA"))
						 {
							 nvda= cot[k].split(",");
						 }
						 if(cot[k].contains("CTSH"))
						 {
							 ctsh= cot[k].split(",");
						 }
						 if(cot[k].contains("YHOO"))
						 {
							 yhoo= cot[k].split(",");
						 }
					 }
					 
					 
					 GoogAPIBean s1=hoja(msft, "MSFT");
					 GoogAPIBean s2=hoja(appl, "APPL");
					 GoogAPIBean s3=hoja(goog, "GOOG");
					 GoogAPIBean s4=hoja(adbe, "ADBE");
					 GoogAPIBean s5=hoja(tsla, "TSLA");
					 GoogAPIBean s6=hoja(redf, "REDF");
					 GoogAPIBean s7=hoja(qcom, "QCOM");
					 GoogAPIBean s8=hoja(nvda, "NVDA");
					 GoogAPIBean s9=hoja(ctsh, "CTSH");
					 GoogAPIBean s10=hoja(yhoo, "YHOO");
					 
					 nasdaq.add(s1);
					 nasdaq.add(s2);
					 nasdaq.add(s3);
					 nasdaq.add(s4);
					 nasdaq.add(s5);
					 nasdaq.add(s6);
					 nasdaq.add(s7);
					 nasdaq.add(s8);
					 nasdaq.add(s9);
					 nasdaq.add(s10);
					 
					 System.out.println(nasdaq.size());
					 
					 
					 
		

		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return nasdaq;

	}

}
