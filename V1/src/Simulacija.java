package usisavanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Simulacija extends Frame {
	
	Scena scena;
	
	public Simulacija(Scena scena) {
		this.scena = scena;
		add(scena, BorderLayout.CENTER);
		
		setBounds(700, 200, 420, 280);
		setBackground(Color.GRAY);
		setResizable(false);
		setTitle("Simulacija");
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				scena.zavrsi();
			}
		});	
	
	scena.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				scena.zavrsi();
				dispose();
			}
			else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				scena.pauzirajIliPokreni();
			}
			super.keyReleased(e);	
		}
	});
	
	scena.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
//			if (!scena.radi()) {
				int x = e.getX();
				int y = e.getY();
				scena.dodajFiguru(new Kamencic(x,y));
				System.out.println("kamencic kliknut na x: " + x + " ,y: " + y);
				super.mouseReleased(e);
//			}
		}
	});
	}

	public static void main(String[] args) {
		Scena s = new Scena();
		Simulacija sim = new Simulacija(s);
	}

}
