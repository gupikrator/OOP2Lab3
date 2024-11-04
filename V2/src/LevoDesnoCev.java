package vodovod;

import java.awt.Color;
import java.awt.Graphics;

public class LevoDesnoCev extends Cev {

	public LevoDesnoCev() {
		super();
	}

	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		g.fillRect(0, getHeight() / 4, getWidth(), getHeight() / 2);
		System.out.println("EVO CRTAM CUDNU CEV");
	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
		g.drawLine(getWidth()/4, getHeight() / 2, 3 * getWidth()/4, getHeight() / 2);
        g.drawLine(0, getHeight() / 4, getWidth(), getHeight() / 4);
        g.drawLine(0, 3 * getHeight() / 4, getWidth(), 3 * getHeight() / 4);
        int[] xPoints = {3 * getWidth()/4, 3 * getWidth()/4 +10, 3 * getWidth()/4};
        int[] yPoints = {getHeight() / 2 - 4, getHeight() / 2, getHeight() / 2 + 4};
        g.fillPolygon(xPoints, yPoints, 3);
		
	}

	
}
