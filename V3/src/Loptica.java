package igrica;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Loptica extends AktivnaFigura {
	
	private int r;
	private double pomerajX;
	private double pomerajY;
	int perioda;

	public Loptica(Scena s, double x, double y) {
		super(s, x, y);
		this.boja = Color.GREEN;
		this.oznaka = 'L';
		this.r = 5;
		this.sleepTime = 10;
		Random rnd = new Random();
		//za x [-1,1)
		this.pomerajX = rnd.nextDouble() * 2 - 1;
		//za y [-1,0)
		this.pomerajY = -rnd.nextDouble();
	}
	
	public int udara(Figura f) {
		int t = 0;
		//gornja tacka loptice x, y-r
		if ((int)y - r == (int)f.y + f.visina/2 && (int)x >= (int)f.x - f.sirina/2 && (int)x <= (int)f.x + f.sirina/2) {
			t = 1;
			System.out.println("POGODIO IZNAD");
			return t;
		}
		//leva tacka x - r, y
		else if ((int)x - r == (int)f.x + f.sirina/2 && (int)y >= (int)f.y - f.visina/2 && (int)y <= (int)f.y + f.visina/2) {
			t = 2;
			System.out.println("POGODIO S LEVA");
			return t;
		}
		//desna tacka x + r, y
		else if ((int)x + r == (int)f.x - f.sirina/2 && (int)y >= (int)f.y - f.visina/2 && (int)y <= (int)f.y + f.visina/2){
			t = 3;
			System.out.println("POGODIO S DESNA");
			return t;
		}
		//donja tacka x, y + r
		else if ((int)y + r == (int)f.y - f.visina/2 && (int)x >= (int)f.x - f.sirina/2 && (int)x <= (int)f.x + f.sirina/2) {
			t = 4;
			System.out.println("POGODIO ISPOD");
			return t;
		}
		return t;
	}
	
	@Override
	public void pomeriFiguru(int pomakX, int pomakY) {	

		if (perioda++ % 100 == 0) {
			pomerajX *= 1.1;
			pomerajY *= 1.1;
		}
		if (y + r > scena.getHeight()) {
			unistiFiguru();
		}
		if (x - r < 0  || x + r > scena.getWidth()) {
			pomerajX = -pomerajX;
		}
		if (y - r < 0) {
			pomerajY = -pomerajY;
		}
//		else {
		int t = scena.udaraL(this);

		if (t > 0 && perioda > 1) {
			Figura u = scena.dohvatiFiguru(scena.getIndeksUdarene());
			if (u instanceof Cigla) {
				((Cigla) u).pogodiCiglu();
			}
			switch (t) {
			case 1:
				// pogodila od gore, treba da ide dole
				pomerajY = -pomerajY;
			case 2:
				// pogodila od gore, treba da ide desno
				pomerajX = -pomerajX;
			case 3:
				// pogodila od desno, treba na levo
				pomerajX = -pomerajX;
			case 4:
				// pogodila od dole, treba na gore
				pomerajY = -pomerajY;
			}
//			}
		}
		this.x += pomerajX;
		this.y += pomerajY;
		scena.repaint();
	}

	@Override
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(boja);
		g.fillOval((int)x - r, (int)y-r, 2*r, 2*r);
		g.setColor(prevColor);
	}

}
