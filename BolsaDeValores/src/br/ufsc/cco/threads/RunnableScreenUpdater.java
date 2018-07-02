package br.ufsc.cco.threads;

import java.util.Timer;

public class RunnableScreenUpdater implements Runnable {
    
    private final Timer timer;
    
    public RunnableScreenUpdater() {
        timer = new Timer();
    }
    
    @Override
    public void run() {
        timer.scheduleAtFixedRate(new UpdateScreenTimerTask(), 18, 10 * 1000);
    }
    
    public void pause() {
        timer.cancel();
    }
    
}
