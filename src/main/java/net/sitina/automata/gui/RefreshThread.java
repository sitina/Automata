package net.sitina.automata.gui;

public class RefreshThread extends Thread {

    private Automata automata;

    private int refreshInterval = 500;

    public RefreshThread(Automata automata, int interval) {
        this.automata = automata;
        this.refreshInterval = interval;
    }

    public void run() {
        while (true) {
            automata.repaint();
            try {
                sleep(refreshInterval);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

}
