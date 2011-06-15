package net.sitina.automata.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.sitina.automata.SavanahCell;


public class Automata extends JFrame {

	private static final long serialVersionUID = 5385200080671559943L;

	private PlaygroundPanel panel = new PlaygroundPanel(100, 100, SavanahCell.class);
	
	private RefreshThread refreshThread = new RefreshThread(this, 100);
	
	public static void main(String[] args) {
        JFrame window = new Automata();
        window.setVisible(true);
    }
	
	public Automata() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel content = new JPanel();
        content.setLayout(new BorderLayout(1, 1));
        content.add(panel, BorderLayout.CENTER);
		
        setContentPane(content);
        
        setTitle("Automata");
        setLocationRelativeTo(null);
        
		pack();
		
		refreshThread.start();
	}

	@Override
	public void repaint() {
		panel.refresh();
		super.repaint();
	}	
	
}