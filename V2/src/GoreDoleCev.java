package vodovod;

import java.awt.Graphics;

public class GoreDoleCev extends Cev {
	
	public GoreDoleCev() {
		super();
	}

	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		g.fillRect(getWidth() / 4, 0, getWidth() / 2, getHeight());
		
	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
		System.out.println("GORE DOLE GAS");
        g.drawLine(getWidth() / 2, getHeight()/4, getWidth() / 2, 3*getHeight()/4);
        g.drawLine(getWidth() / 4, 0, getWidth() / 4, getHeight());
        g.drawLine(3 * getWidth() / 4, 0, 3 * getWidth() / 4, getHeight());
        int[] xPoints = {getWidth() / 2 - 4, getWidth() / 2, getWidth() / 2 + 4};
        int[] yPoints = {3*getHeight()/4 - 10, 3*getHeight()/4, 3*getHeight()/4 - 10};
        g.fillPolygon(xPoints, yPoints, 3);
	}

}
