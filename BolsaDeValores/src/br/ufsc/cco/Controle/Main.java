package br.ufsc.cco.Controle;

import br.ufsc.cco.telas.TelaPrincipal;

public class Main {
	
	public static void main(String[] args) {
		String json = ControladorRequests.getInstance().request(ControladorRequests.BANCO_DO_BRASIL);
		ModuloAnalitico ma = new ModuloAnalitico();
		double media = ma.getSMA(json);
		double ultimoFechamento = ma.getLastClose(json);
		System.out.println("SMA: " + media);
		System.out.println("close: " + ultimoFechamento);
		
		String json1 = ControladorRequests.getInstance().request(ControladorRequests.GOOGLE);
		double media1 = ma.getSMA(json1);
		double ultimoFechamento1 = ma.getLastClose(json1);
		System.out.println("SMA: " + media1);
		System.out.println("close: " + ultimoFechamento1);
		
		String json2 = ControladorRequests.getInstance().request(ControladorRequests.PETROBRAS);
		double media2 = ma.getSMA(json2);
		double ultimoFechamento2 = ma.getLastClose(json2);
		System.out.println("SMA: " + media2);
		System.out.println("close: " + ultimoFechamento2);
		
		String json3 = ControladorRequests.getInstance().request(ControladorRequests.SANTANDER);
		double media3 = ma.getSMA(json3);
		double ultimoFechamento3 = ma.getLastClose(json3);
		System.out.println("SMA: " + media3);
		System.out.println("close: " + ultimoFechamento3);
		
		String json4 = ControladorRequests.getInstance().request(ControladorRequests.VALE);
		double media4 = ma.getSMA(json4);
		double ultimoFechamento4 = ma.getLastClose(json4);
		System.out.println("SMA: " + media4);
		System.out.println("close: " + ultimoFechamento4);
		
		TelaPrincipal tela = new TelaPrincipal("Titulo");
		tela.setVisible(true);
	}
}
