package com.apiwatch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class HttpsGetRequest{
	
		final static String URL = "https://ipapi.co/";
	    public static final String REQUEST_METHOD = "GET";
	    public static final int READ_TIMEOUT = 15000;
	    public static final int CONNECTION_TIMEOUT = 15000;
	    
		private HttpURLConnection connection = null;
		private String ip =null;
		
		public HttpsGetRequest() {
		}
		
		public void setIp(String ip) {
			this.ip = ip;
		}
		
		public String getLocation() {
			URL url = null;
			String inputLine;
			StringBuilder sb = null;
			String resultat = "";
			try {
				url = new URL(HttpsGetRequest.URL+this.ip+"/json");
				this.connection = (HttpURLConnection) url.openConnection();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			catch (IOException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			finally {
				if(url != null) {
					try {
						this.connection.setRequestMethod(REQUEST_METHOD);
						this.connection.setReadTimeout(READ_TIMEOUT);
						this.connection.setConnectTimeout(CONNECTION_TIMEOUT);
						this.connection.connect();
						InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
						BufferedReader reader = new BufferedReader(streamReader);
						sb = new StringBuilder();
						while((inputLine = reader.readLine())!= null) {
							sb.append(inputLine);
						}
						resultat = sb.toString();
						reader.close();
						streamReader.close();
					}
					catch(IOException e) {
						System.err.println(e.getMessage());
					}
				}
			}
			return resultat;
			
		}
}
