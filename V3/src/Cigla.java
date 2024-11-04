package igrica;

import java.awt.Color;
import java.awt.Graphics;

public class Cigla extends AktivnaFigura {
	
	private boolean pogodjena = false;

	public Cigla(Scena s, double x, double y) {
		super(s, x, y);
		this.boja = Color.RED;
		this.oznaka = 'C';
		this.dX = 0;
		this.dY = 5;
	}
	
	public void pogodiCiglu() {
		pogodjena = true;
		System.out.println("Pogodjena cigla sa id: " + id);
		pokreni();
	}
	
	public boolean pogodjena() {
		return pogodjena;
	}

	@Override
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(pogodjena ? Color.GRAY : boja);
//		g.fillRect(getX(), getY(), scena.getWidth()/scena.getKoloneC() - 3, scena.getHeight()/4/scena.getRedoviC() - 3);
//		g.fillRect(getX(), getY(),scena.getWidth()/scena.getKoloneC() - 3, 28);
		int s = scena.getWidth()/scena.getKoloneC();
		int v = scena.getHeight()/6/scena.getRedoviC();
		sirina = s - 2;
		visina = v - 2;
		g.fillRect((int)(getX() - s/2 ) + 40 ,(int) (getY() - v/2) + 11, sirina, visina);
//		System.out.println("crtam gornji levi x iz " + (getX() - s/2));
//		System.out.println("crtam gornji levi y iz " + (getY() - v/2));
		g.setColor(prevColor);
	}

}
