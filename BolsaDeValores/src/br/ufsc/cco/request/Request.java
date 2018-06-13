package br.ufsc.cco.request;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

public class Request {
	
	public String request(String params) {
		try {
			URL url = new URL("https://www.alphavantage.co/query?" + params);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			Scanner scanner = new Scanner(isr);
			StringBuilder builder = new StringBuilder();
			
			while(scanner.hasNextLine()) {
				builder.append("\n" + scanner.nextLine());
			}
			
			String json = builder.toString();
			System.out.println(json);
			Gson gson = new Gson();
			
			scanner.close();
			connection.disconnect();
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
