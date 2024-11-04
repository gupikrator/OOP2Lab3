package vodovod;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Cev extends Kvadrat {

	public Cev() {
		super(new Color(170,170,170), true);	
	}
	
	public abstract void nacrtajUnutrasnjost(Graphics g);
	public abstract void nacrtajIviceUsmerenje(Graphics g);
	
	@Override
	public void paint(Graphics g) {
		System.out.println("crtam cev..");
		Color prevColor = g.getColor();
		g.setColor(new Color(204,204,204));
		nacrtajUnutrasnjost(g);
		g.setColor(Color.BLACK);
		nacrtajIviceUsmerenje(g);
		if(oznacen) {
			g.setColor(Color.RED);
			g.drawRect(0,0,getWidth() - 1, getHeight()-1);
			}
		g.setColor(prevColor);
		g.setColor(prevColor);
	}

}
