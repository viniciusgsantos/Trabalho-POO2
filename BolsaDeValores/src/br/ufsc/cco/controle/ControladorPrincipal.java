package br.ufsc.cco.controle;

import br.ufsc.cco.util.ModuloAnalitico;
import br.ufsc.cco.objects.Ativo;
import br.ufsc.cco.objects.NomeDeAtivo;
import br.ufsc.cco.objects.Situacao;

import br.ufsc.cco.threads.RunnableRequest;
import br.ufsc.cco.threads.RunnableScreenUpdater;
import java.awt.Color;

public class ControladorPrincipal {

	private static ControladorPrincipal instance;
	private RunnableRequest runRequest;
	private RunnableScreenUpdater runScreen;
	private Thread threadRequest;
	private Thread threadUpdateScreen;
	private final ModuloAnalitico ma;
	private boolean monitorando;

	private ControladorPrincipal() {
		ma = new ModuloAnalitico();
		monitorando = false;
	}

	public void init() {
		inicializarDados();
		ControladorDeTela.getInstance().getTela().setVisible(true);
	}

	private void inicializarDados() {
		Ativo[] ativos = new Ativo[5];

		Ativo bb = new Ativo(NomeDeAtivo.BANCO_DO_BRASIL.nome);
		bb.setUpdated(false);

		Ativo petrobras = new Ativo(NomeDeAtivo.PETROBRAS.nome);
		petrobras.setUpdated(false);

		Ativo vale = new Ativo(NomeDeAtivo.VALE.nome);
		vale.setUpdated(false);

		Ativo google = new Ativo(NomeDeAtivo.GOOGLE.nome);
		google.setUpdated(false);

		Ativo san = new Ativo(NomeDeAtivo.SANTANDER.nome);
		san.setUpdated(false);

		ativos[0] = google;
		ativos[1] = bb;
		ativos[2] = san;
		ativos[3] = petrobras;
		ativos[4] = vale;

		ControladorDeDados.getInstance().adicionarAtivos(ativos);
	}

	public void monitorar() {
		if (!monitorando) {
			runRequest = new RunnableRequest();
			runScreen = new RunnableScreenUpdater();
			threadRequest = new Thread(runRequest, "requests");
			threadUpdateScreen = new Thread(runScreen, "screen-updater");
			threadRequest.start();
			threadUpdateScreen.start();
		} else if (monitorando) {
			runRequest.pause();
			runScreen.pause();
			threadRequest.interrupt();
			threadUpdateScreen.interrupt();
		}
		ControladorDeTela.getInstance().setMonitoramento();
		monitorando = !monitorando;
	}

	public void updateData(String nomeAtivo, String updatedDataJson) {
		double sma = ma.getSMA(updatedDataJson);
		double close = ma.getLastClose(updatedDataJson);

		Ativo ativo = ControladorDeDados.getInstance().getAtivo(nomeAtivo);
		if (ativo.getClose() - ativo.getSma() < 0 && close - sma > 0) {
			ativo.setSituacao(Situacao.DEU_COMPRA.mensagem);
		} else if (ativo.getClose() - ativo.getSma() > 0 && close - sma < 0) {
			ativo.setSituacao(Situacao.DEU_VENDA.mensagem);
		} else {
			ativo.setSituacao(Situacao.ESTAVEL.mensagem);
		}

		if (ativo.getClose() - close > 0) {
			ativo.setColor(Color.RED);
		} else if (ativo.getClose() - close < 0) {
			ativo.setColor(Color.GREEN);
		} else {
			ativo.setColor(Color.WHITE);
		}

		ativo.setClose(close);
		ativo.setSma(sma);
		ativo.setUpdated(true);
	}

	public static ControladorPrincipal getInstance() {
		if (instance == null) {
			instance = new ControladorPrincipal();
		}
		return instance;
	}
}
