package net.sitina.automata.gui;

import net.sitina.automata.cell.SavannahCell;

import javax.swing.*;
import java.awt.*;

public class Automata extends JFrame {

    private static final long serialVersionUID = 5385200080671559943L;

    private PlaygroundPanel panel = new PlaygroundPanel(200, 150, SavannahCell.class);

    private RefreshThread refreshThread = new RefreshThread(this, 10);

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
        pack();

        setLocationRelativeTo(null);
        refreshThread.start();
    }

    @Override
    public void repaint() {
		panel.refresh();
	}

}