package net.sitina.automata.gui;

public class RefreshThread extends Thread {

	private Automata a;
	
	private int refreshInterval = 500;
	
	public RefreshThread(Automata a, int interval) {
		this.a = a;
		this.refreshInterval = interval;
	}
	
	public void run() {
		while (true) {
			a.repaint();
			try {
				sleep(refreshInterval);
			} catch (Exception e) {
                System.err.println(e.getMessage());
            }
		}
	}
	
}
