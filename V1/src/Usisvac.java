package usisavanje;

import java.awt.Color;
import java.awt.Graphics;

public class Usisvac extends Figura {
	
	// unutrasnji ugao trougla
	private static double ugao = 2 * Math.PI / 3;
	private Color boja;
	private int pomeraj;
	

	public Usisvac(int x, int y) {
		setX(x);
		setY(y);
		this.r = 15;
		this.boja = Color.RED;
		this.pomeraj = 7;
	}
	
	public int getPomeraj() {
		return (int) this.r/2;
	}
	
	public void pomeriX(int i) {
		setX(getX() + getPomeraj() * i);
	}
	
	public void pomeriY(int i) {
		setY(getY() + getPomeraj() * i);
	}
	
	@Override
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(boja);

//		g.translate(getX(), getY());
		int[] x = { getX(), getX() - (int) (Math.sqrt(3) * r / 2), getX() + (int) (Math.sqrt(3) * r / 2) };
		int[] y = { getY() - r, getY() + r / 2, getY() + r / 2 };

		/*
		 * int[] x = {200,215,185}; int[] y = {100,130,130}; double trenutniUgao = 0;
		 */
		/*
		 * for (int i = 0; i < 3; i++) { x[i] = (int) (this.getR() *
		 * Math.cos(trenutniUgao)); y[i] = (int) (this.getR() * Math.sin(trenutniUgao));
		 * trenutniUgao += ugao; }
		 */
		g.fillPolygon(x, y, 3);
		g.setColor(prevColor);		
	}

}
