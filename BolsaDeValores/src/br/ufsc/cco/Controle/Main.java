package br.ufsc.cco.Controle;

public class Main {
	
	public static void main(String[] args) {
		String json = ControladorRequests.getInstance().request(ControladorRequests.BANCO_DO_BRASIL);
		ModuloAnalitico ma = new ModuloAnalitico();
		double media = ma.getSMA(json);
		double ultimoFechamento = ma.getLastClose(json);
		System.out.println("SMA: " + media);
		System.out.println("close: " + ultimoFechamento);
	}
}
