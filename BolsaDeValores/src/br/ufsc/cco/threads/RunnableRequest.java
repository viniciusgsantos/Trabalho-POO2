package br.ufsc.cco.threads;

import java.util.Timer;

public class RunnableRequest implements Runnable {

	private final Timer timer;

	public RunnableRequest() {
		timer = new Timer();
	}

	@Override
	public void run() {
		timer.scheduleAtFixedRate(new RequestTimerTask(), 3, 60 * 1000);
	}

	public void pause() {
		timer.cancel();
	}

}
