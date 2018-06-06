package br.ufsc.cco.Controle;

import br.ufsc.cco.request.Request;

public class Main {
	
	public static void main(String[] args) {
		Request req = new Request();
		ControladorRequests.getInstance().request("");
	}
}
