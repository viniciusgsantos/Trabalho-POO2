package br.ufsc.cco.threads;

import br.ufsc.cco.controle.ControladorRequests;
import java.util.TimerTask;

/**
 *
 * @author adri
 */
public class RequestTimerTask extends TimerTask {

    @Override
    public void run() {
        ControladorRequests.getInstance().requestInThreads();
    }
    
}
