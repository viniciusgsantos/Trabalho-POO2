package br.ufsc.cco.threads;

import br.ufsc.cco.controle.ControladorDeTela;
import java.util.TimerTask;

public class UpdateScreenTimerTask extends TimerTask {

	@Override
	public void run() {
		ControladorDeTela.getInstance().updateScreen();
	}

}
