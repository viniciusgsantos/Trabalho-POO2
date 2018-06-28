package br.ufsc.cco.Controle;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.TimerTask;

import br.ufsc.cco.objects.RequestsURL;

public class ControladorRequests extends TimerTask {
	
	public static final int BANCO_DO_BRASIL = 0;
	public static final int PETROBRAS = 1;
	public static final int VALE = 2;
	public static final int GOOGLE = 3;
	public static final int SANTANDER = 4;
	
	private RequestsURL requests;
	
	private static ControladorRequests instance;
	
	private ControladorRequests() {
		requests = new RequestsURL();
	}
	
	public String request(int ativo) throws IllegalArgumentException {
		String jsonResponse;
		switch(ativo) {
		case 0:
			jsonResponse = requestIntraday(requests.getParamsBB());
			break;
		case 1:
			jsonResponse = requestIntraday(requests.getParamsPETR());
			break;
		case 2:
			jsonResponse = requestIntraday(requests.getParamsVALE());
			break;
		case 3:
			jsonResponse = requestIntraday(requests.getParamsGOOG());
			break;
		case 4:
			jsonResponse = requestIntraday(requests.getParamsSAN());
			break;
		default:
			throw new IllegalArgumentException("Ativo inválido");
		}
		return jsonResponse;
	}
	
	private String requestIntraday(String params) throws NullPointerException {
		try {
			URL url = new URL("https://www.alphavantage.co/query?" + params);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			
			InputStreamReader isr = new InputStreamReader(connection.getInputStream());
			Scanner scanner = new Scanner(isr);
			StringBuilder builder = new StringBuilder();
			
			while(scanner.hasNextLine()) {
				builder.append("\n" + scanner.nextLine());
			}
			
			System.out.println("Requisitou");
			scanner.close();
			return builder.toString();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void run() {
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(1);
				boolean acessou = true;
				do {
					try {
						request(BANCO_DO_BRASIL);
					} catch(NullPointerException e) {
						acessou = false;
					}
				} while(!acessou);
			}
			
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(2);
				boolean acessou = true;
				do {
					try {
						request(GOOGLE);
					} catch(NullPointerException e) {
						acessou = false;
					}
				} while(!acessou);
			}
			
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(3);
				boolean acessou = true;
				do {
					try {
						request(PETROBRAS);
					} catch(NullPointerException e) {
						acessou = false;
					}
				} while(!acessou);
			}
			
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(4);
				boolean acessou = true;
				do {
					try {
						request(VALE);
					} catch(NullPointerException e) {
						acessou = false;
					}
				} while(!acessou);
				this.interrupt();
			}
			
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				System.out.println(5);
				boolean acessou = true;
				do {
					try {
						request(SANTANDER);
					} catch(NullPointerException e) {
						acessou = false;
					}
				} while(!acessou);
			}
			
		}.start();
		
	}
	
	public static ControladorRequests getInstance() {
		if(instance == null) {
			instance = new ControladorRequests();
		}
		return instance;
	}

}
