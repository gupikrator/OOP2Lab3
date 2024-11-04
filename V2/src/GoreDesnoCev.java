package vodovod;

import java.awt.Graphics;

public class GoreDesnoCev extends Cev {
	
	public GoreDesnoCev() {
		super();
	}

	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		g.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, 3 * getHeight() / 4);
	    g.fillRect(getWidth() / 4, getHeight() / 4, 3*getWidth() / 4, getHeight() / 2);

	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
		g.drawLine(getWidth() / 4, getHeight()/4, getWidth() / 4, getHeight());
		g.drawLine(getWidth() / 4, getHeight()/4, getWidth(), getHeight()/4);
		g.drawLine(3*getWidth() / 4, 3*getHeight()/4, getWidth(), 3*getHeight()/4);
		g.drawLine(3*getWidth() / 4, getHeight(), 3*getWidth() / 4, 3*getHeight()/4);
		
		g.drawLine(getWidth() / 2, getHeight(), getWidth()/2, getHeight()/2);
		g.drawLine(getWidth()/2, getHeight()/2, 3*getWidth()/4, getHeight()/2);

        int[] xPoints = {3 * getWidth()/4, 3 * getWidth()/4 +10, 3 * getWidth()/4};
        int[] yPoints = {getHeight() / 2 - 4, getHeight() / 2, getHeight() / 2 + 4};
        g.fillPolygon(xPoints, yPoints, 3);
				
	}

}
