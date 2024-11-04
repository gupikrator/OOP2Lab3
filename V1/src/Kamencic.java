package usisavanje;

import java.awt.Color;
import java.awt.Graphics;

public class Kamencic extends Figura {

	private Color boja;
		
	public Kamencic(int x, int y) {
		setX(x);
		setY(y);
		this.r = 5;
		this.boja = Color.BLACK;
//		System.out.println("kamencic npravljen");
	}

	@Override
	public void paint(Graphics g) {
		Color prevColor = g.getColor();
		g.setColor(boja);
		g.fillOval(getX() - r, getY()-r, 2*r, 2*r);
		System.out.println("crtam kamencic na " + (getX() - r));
//		g.fillOval(275,290, 10, 10);
		g.setColor(prevColor);		
	}

}
