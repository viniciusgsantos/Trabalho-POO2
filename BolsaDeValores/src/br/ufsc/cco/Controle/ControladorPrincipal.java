package br.ufsc.cco.Controle;

import java.util.Timer;

import br.ufsc.cco.telas.TelaPrincipal;

public class ControladorPrincipal {
	
	private static ControladorPrincipal instance;
	private Timer timer;
	private static TelaPrincipal tela;
	private ModuloAnalitico ma;
	
	private ControladorPrincipal() {
		timer = new Timer();
		tela = new TelaPrincipal();
		ma = new ModuloAnalitico();
	}
	
	public void init() {
		
		monitorar();
	}
	
	public void monitorar() {
		tela.setVisible(true);
		new Thread("monitoramento") {
			@Override
			public void run() {
				timer.scheduleAtFixedRate(ControladorRequests.getInstance(), 3, 5 * 1000);
			}
		}.start();
	}
	
	public ModuloAnalitico getModuloAnalitico()  {
		return ma;
	}
	
	public static ControladorPrincipal getInstance() {
		if(instance == null) {
			instance = new ControladorPrincipal();
		}
		return instance;
	}
}
