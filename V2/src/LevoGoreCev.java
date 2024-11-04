package vodovod;

import java.awt.Graphics;

public class LevoGoreCev extends Cev {

	public LevoGoreCev() {
		super();
	}

	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		g.fillRect(0, getHeight() / 4, 3 * getWidth() / 4, getHeight() / 2);
		g.fillRect(getWidth() / 4, 0, getWidth() / 2, 3*getHeight()/4);
	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
		//uokviri
		g.drawLine(0, getHeight() / 4, getWidth() / 4, getHeight() / 4);
		g.drawLine(getWidth() / 4, getHeight() / 4, getWidth() / 4, 0);
		g.drawLine(0, 3*getHeight() / 4, 3*getWidth() / 4,3* getHeight() / 4);
		g.drawLine(3*getWidth() / 4,3* getHeight() / 4,3* getWidth() / 4, 0);
		// za strelu..
		g.drawLine(getWidth()/4, getHeight() / 2, getWidth() /2 , getHeight() / 2);
		g.drawLine(getWidth() /2 , getHeight() / 2, getWidth() / 2, getHeight() / 4);
        int[] xPoints = {getWidth() / 2 - 4, getWidth() / 2, getWidth() / 2 + 4};
        int[] yPoints = {getHeight()/4+10, getHeight()/4, getHeight()/4 +10};
        g.fillPolygon(xPoints, yPoints, 3);
	}

}
