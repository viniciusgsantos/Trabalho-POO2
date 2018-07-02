package br.ufsc.cco.controle;

import br.ufsc.cco.objects.NomeDeAtivo;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import br.ufsc.cco.objects.RequestsURL;

public class ControladorRequests {
	
	private final RequestsURL requests;
	
	private static ControladorRequests instance;
	
	private ControladorRequests() {
		requests = new RequestsURL();
	}
	
	public String request(int ativo) throws NullPointerException, IOException {
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
	
	private String requestIntraday(String params) throws NullPointerException, IOException {
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
				builder.append("\n").append(scanner.nextLine());
			}
			
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
	
	public void requestInThreads() {
		
		new Thread() {
			@Override
			public void run() {
				boolean acessou = true;
				do {
					try {
						String response = request(NomeDeAtivo.BANCO_DO_BRASIL.id);
                                                ControladorPrincipal.getInstance().updateData(NomeDeAtivo.BANCO_DO_BRASIL.nome, response);
					} catch(NullPointerException e) {
						acessou = false;
					} catch(IOException e) {
                                                acessou = false;
                                        }
				} while(!acessou);
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				boolean acessou = true;
				do {
					try {
						String response = request(NomeDeAtivo.PETROBRAS.id);
                                                ControladorPrincipal.getInstance().updateData(NomeDeAtivo.PETROBRAS.nome, response);
					} catch(NullPointerException e) {
						acessou = false;
					} catch(IOException e) {
                                                acessou = false;
                                        }
				} while(!acessou);
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				boolean acessou = true;
				do {
					try {
						String response = request(NomeDeAtivo.VALE.id);
                                                ControladorPrincipal.getInstance().updateData(NomeDeAtivo.VALE.nome, response);                                                
					} catch(NullPointerException e) {
						acessou = false;
					} catch(IOException e){
                                                acessou = false;
                                        }
				} while(!acessou);
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				boolean acessou = true;
				do {
					try {
						String response = request(NomeDeAtivo.GOOGLE.id);
                                                ControladorPrincipal.getInstance().updateData(NomeDeAtivo.GOOGLE.nome, response);                                                
					} catch(NullPointerException e) {
						acessou = false;
					} catch(IOException e) {
                                            acessou = false;
                                        }
				} while(!acessou);
				this.interrupt();
			}
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				boolean acessou = true;
				do {
					try {
						String response = request(NomeDeAtivo.SANTANDER.id);
                                                ControladorPrincipal.getInstance().updateData(NomeDeAtivo.SANTANDER.nome, response);                                                
					} catch(NullPointerException e) {
						acessou = false;
					} catch(IOException e) {
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
