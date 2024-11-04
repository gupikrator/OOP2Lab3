package vodovod;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kvadrat extends Canvas {
	
	private int sirina;
	private int visina;
	protected Color boja;
	protected boolean oznacen = false;
	protected boolean moguceOznaciti;
	
	public Kvadrat(Color boja, boolean moguceOznaciti) {
		this.sirina = 75;
		this.visina = 75;
		this.boja = boja;
		this.moguceOznaciti = moguceOznaciti;
		this.setBackground(boja);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					((Kanalizacija) getParent()).izaberiKvadrat(Kvadrat.this);
				} catch (GOznaka e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public boolean mozeSeOznaciti() {
		return moguceOznaciti;
	}
	
	public boolean jeOznacen() {
		return oznacen;
	}
	
	public void postaviOznaku() throws GOznaka {
		if (!moguceOznaciti) throw new GOznaka();
		oznacen = true;
	}
	
	public void ukloniOznaku() {
		oznacen = false;
		System.out.println("vise nisam izabran");
	}
	
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(this.boja);
		this.setBackground(boja);
		if(oznacen) {
			g.setColor(Color.RED);
			g.drawRect(0,0,getWidth() - 1, getHeight()-1);
			}
		g.setColor(prevColor);
	}

	
}
