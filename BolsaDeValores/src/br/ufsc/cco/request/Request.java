package br.ufsc.cco.request;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.ufsc.cco.Controle.ControladorRequests;

public class Request {
	
	public String request(String params) {
		try {
			URL url = new URL("https://www.alphavantage.co/query");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			
			DataOutputStream output = new DataOutputStream(connection.getOutputStream());
			output.writeBytes(params);
			output.flush();
			output.close();
			System.out.println(connection.getResponseCode());
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
