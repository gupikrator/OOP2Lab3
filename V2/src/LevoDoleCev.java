package vodovod;

import java.awt.Graphics;

public class LevoDoleCev extends Cev {

	public LevoDoleCev() {
		super();
	}
	
	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		 g.fillRect(0, getHeight() / 4, 3 * getWidth() / 4, getHeight() / 2);
	     g.fillRect(getWidth() / 4, getHeight() / 4, getWidth() / 2, 3 * getHeight() / 4);
		
	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
		// daj da uokvirimo cev
		g.drawLine(0, getHeight() / 4, 3 * getWidth() / 4, getHeight() / 4);
        g.drawLine(3 * getWidth() / 4, getHeight() / 4, 3*getWidth()/4 , getHeight());
        g.drawLine(0, 3 *getHeight() / 4, getWidth()/4, 3 *getHeight() / 4);
        g.drawLine(getWidth()/4, 3 *getHeight() / 4, getWidth()/4, getHeight());
        // sad za strelicu
        g.drawLine(getWidth()/4, getHeight() / 2, getWidth()/2, getHeight()/2);
        g.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, 3*getHeight()/4);
        int[] xPoints = {getWidth() / 2 - 4, getWidth() / 2, getWidth() / 2 + 4};
        int[] yPoints = {3*getHeight()/4 - 10, 3*getHeight()/4, 3*getHeight()/4 - 10};
        g.fillPolygon(xPoints, yPoints, 3);
	}

}
