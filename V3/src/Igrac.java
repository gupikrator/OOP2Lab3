package igrica;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends AktivnaFigura {
	
	public Igrac(Scena s, double x, double y) {
		super(s, x, y);
		this.boja = Color.BLUE;
		this.oznaka = 'I';
		this.sleepTime = 10;
		this.sirina = 50;
		this.visina = 10;
//		this.x = s.getWidth()/2;
//		this.y = s.getHeight() - 20;
		
	}

	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}
	
	public void ispaliLopticu() {
		Loptica l = new Loptica(scena, x, y -10);
		l.pokreni();
	}
	
	@Override
	public void pomeriFiguru(int pomakX, int pomakY) {
		this.x += pomakX;
		if (this.x - sirina/2 < 0) {
			this.x = sirina / 2;
		}
		else if (this.x + sirina / 2 > scena.getWidth()) {
			x = scena.getWidth() - sirina/2;
		}
		scena.repaint();
	}


	@Override
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(boja);
		g.fillRect((int)x - sirina/2, (int)y - visina/2, sirina, visina);
		g.setColor(prevColor);
		
	}

}
