package br.ufsc.cco.request;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {
	
	public String request(String params) {
		try {
			URL url = new URL("https://www.alphavantage.co/query?" + params);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			System.out.println("Resposta: " + connection.getResponseMessage());
			System.out.println("Status: " + connection.getResponseCode());
			return "" + connection.getResponseCode();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
