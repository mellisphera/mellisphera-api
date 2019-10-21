/* Copyright 2018-present Mellisphera
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */ 



package com.mellisphera;
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
