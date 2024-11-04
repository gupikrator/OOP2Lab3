package usisavanje;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Scena extends Canvas implements Runnable {

	private SkupFigura figure;
	private Color boja = Color.GRAY;
	private long sleepTime = 50;
	private Thread thread;
	private Usisvac u;
	private boolean radi = false;

	public Scena() {
		this.setBackground(boja);
		this.figure = new SkupFigura();
		this.u = new Usisvac(200,120);
		this.setSize(400, 400);
		figure.dodajFiguru(u);
		System.out.println("dodat u na x: " + u.getX() + ", y: " + u.getY());
		thread = new Thread(this);
		thread.start();
	}

	// sinhronizacione metode vezane za rad niti
	public void pokreni() {
		radi = true;
		this.repaint();
	}

	public Boolean radi() {
		return radi;
	}

	public void pauzirajIliPokreni() {
		radi = !radi;
		repaint();
	}

	public void nastavi() {
		radi = true;
		notify();
	}

	public synchronized void zavrsi() {
		if (thread != null) {
			thread.interrupt();
		}
	}
	//

	// metode koje definisu sta nit radi
	public void pomeri() {
		System.out.println("POMMERAM");
		if (figure.brojFigura() < 2) {
			radi = false;
			return;
		}
		Figura zrtva = null;
		double minD = Double.MAX_VALUE;
		
		figure.postaviPrvuTekucom();
		if (figure.dohvatiTekucu() instanceof Usisvac) {
			Usisvac u = (Usisvac)figure.dohvatiTekucu();
		}
		while (figure.postojiSledeca()) {
			figure.postaviSledecu();
			double d = u.rastojanjeCentara(figure.dohvatiTekucu());
			if (d < minD) {
				minD = d;
				System.out.println("novi min!  " + minD);
				zrtva = figure.dohvatiTekucu();
			}
		}
		if (zrtva != null) {
			int pomeraj = u.getPomeraj();
			if (u.preklapaFiguru(zrtva)) {
				figure.izbaciFiguru(zrtva);
			}
			else if(Math.abs(u.getX() - zrtva.getX()) > pomeraj) {
				u.setX(u.getX() + (zrtva.getX() > u.getX() ? pomeraj : -pomeraj));
			}
			else if(Math.abs(u.getY() - zrtva.getY()) > pomeraj) {
				u.setY(u.getY() + (zrtva.getY() > u.getY() ? pomeraj : -pomeraj));
			}
		}
		repaint();

	}

	public void dodajFiguru(Figura f) {
		if (figure.brojFigura() == 0) {
			figure.dodajFiguru(f);
//			revalidate();
			return;
		}
		figure.postaviPrvuTekucom();
		boolean preklapa = figure.dohvatiTekucu().preklapaFiguru(f);
		System.out.println(preklapa);
		if (!preklapa) System.out.println(figure.dohvatiTekucu().getClass());
		while (figure.postojiSledeca() && !preklapa) {
			figure.postaviSledecu();
			preklapa = figure.dohvatiTekucu().preklapaFiguru(f);
		}
		if (!preklapa && stajeCela(f)) {
			figure.dodajFiguru(f);
			repaint();
		}
		
		if (figure.brojFigura() == 2) {
			radi = true;
		}

//		figure.dodajFiguru(f);
	}
	
	public boolean stajeCela(Figura f) {
		return (f.getX() - f.getR() >= 0) && (f.getX() + f.getR() <= getWidth()) && (f.getY() - f.getR() >= 0) && (f.getY() + f.getR() <= getHeight());
	}
 
	private void crtaj() {
		if (figure.brojFigura() == 0) {
			return;
		}
		figure.postaviPrvuTekucom();
		while (figure.postojiSledeca()) {
			figure.dohvatiTekucu().paint(getGraphics());
			figure.postaviSledecu();
		}
		figure.dohvatiTekucu().paint(getGraphics());
	}

	@Override
	public void paint(Graphics g) {
		crtaj();
		/*
		 * if(!radi) { g.setFont(new Font("Comic Sans ms",Font.BOLD,40));
		 * g.drawString("PAUZA", 175, 180); }
		 */
	}

	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				if (radi) {
					System.out.println("SAD CU DA POMERIM");
					pomeri();
				}
				Thread.sleep(sleepTime);			
			}
		} catch (InterruptedException e) {
		}
	}

}
