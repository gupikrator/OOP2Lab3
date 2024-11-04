package igrica;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class IgraLoptica extends Frame {
	
	Scena scena;
	
	public IgraLoptica(Scena scena) {
		this.scena = scena;
		add(scena, BorderLayout.CENTER);
		setBounds(700, 200, 400, 400);
		setResizable(false);
		setTitle("Loptica");
		pack();
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				scena.zaustaviSveFigure();
			}
		});
		
		scena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scena.getIgrac().ispaliLopticu();
            }
        });
		
		scena.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                	scena.getIgrac().pomeriFiguru(-10, 0);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                	scena.getIgrac().pomeriFiguru(10, 0);
                }
            }
        });
		
		scena.requestFocus();

	}
	
	public static void main(String[] args) {
		Scena s = new Scena(3,5);
		IgraLoptica sim = new IgraLoptica(s);
	}

}
