package igrica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Scena extends Canvas {
	
	private ArrayList<Figura> figure;
	private int redoviC;
	private int koloneC;
	private Igrac igrac;
	private int indeksUdarene;
	
	public Scena(int r, int k) {
		figure = new ArrayList<>();
		this.setBackground(Color.WHITE);
		this.setSize(400,400);
		redoviC = r;
		koloneC = k;
		for (int i = 0; i < redoviC*koloneC; i++) {
			int x = getWidth()/koloneC * ((i+1)%koloneC);
			int y = getHeight()/6/redoviC * ((i+1)%redoviC);
//			System.out.println(x + " je x, a y je " + y);
			Cigla c = new Cigla(this, x, y);
		}
		Igrac plej = new Igrac(this, getWidth()/2, getHeight() - 20);
		this.igrac = plej;
//		Loptica l = new Loptica(this, getWidth()/2, getHeight() - 30);
	}
	
	public Igrac getIgrac() {
		return igrac;
	}
	
	public int getIndeksUdarene() {
		return indeksUdarene;
	}
	
	public int getRedoviC() {
		return redoviC;
	}
	
	public int getKoloneC() {
		return koloneC;
	}
	
	public int udaraL(Loptica l) {
		int t = 0;
		if (l.y < getHeight() - 40 && l.y > getHeight()/3) {
			return 0;
		}
		for (Figura f: figure) {
			int i = l.udara(f);
			if(i > 0) {
				if (f instanceof Cigla && ((Cigla) f).pogodjena()) {
					return 0;
				}
				indeksUdarene = figure.indexOf(f);
				t = i;
				break;
			}
		}
		return t;
	}
	
	public synchronized void dodajFiguru(Figura f) {
		figure.add(f);
//		System.out.println("Dodata cigla sa x: " + f.getX() + " i y:" + f.getY() +" i id: " + f.id);
		repaint();
	}
	
	public synchronized void ukloniFiguru(Figura f) {
		figure.remove(f);
		if (f instanceof AktivnaFigura) {
			((AktivnaFigura) f).zavrsi();
		}
		repaint();
	}
	
	public Figura dohvatiFiguru(int i) {
		if (figure.size() > i) {
			return figure.get(i);
		}
		return null;
	}
	
	public void zaustaviSveFigure() {
		for (Figura figura : figure) {
			if (figura instanceof AktivnaFigura) {
				((AktivnaFigura) figura).zaustavi();
			}
		}
	}
	
	public void paint(Graphics g) {
		if (figure.size() == 0) {
			return;
		}
		synchronized (this) {
            for (Figura f : figure) {
                f.paint(g);
            }
        }
	}
}
