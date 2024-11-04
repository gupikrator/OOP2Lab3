package vodovod;

import java.awt.Graphics;

public class DoleGoreCev extends Cev {
	
	public DoleGoreCev() {
		super();
	}

	@Override
	public void nacrtajUnutrasnjost(Graphics g) {
		 g.fillRect(getWidth() / 4, 0, getWidth() / 2, getHeight());
		
	}

	@Override
	public void nacrtajIviceUsmerenje(Graphics g) {
//		System.out.println("nesto sipogresi.. ili ne?");
		g.drawLine(getWidth() / 2, getHeight()/4, getWidth() / 2,3* getHeight()/4);
        g.drawLine(getWidth() / 4, 0, getWidth() / 4, getHeight());
        g.drawLine(3 * getWidth() / 4, 0, 3 * getWidth() / 4, getHeight());
        int[] xPoints = {getWidth() / 2 - 4, getWidth() / 2, getWidth() / 2 + 4};
        int[] yPoints = {getHeight()/4+10, getHeight()/4, getHeight()/4 +10};
        g.fillPolygon(xPoints, yPoints, 3);
		
	}

}
