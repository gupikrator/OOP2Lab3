package igrica;

public abstract class AktivnaFigura extends Figura implements Runnable {

	private Thread thread;
	protected long sleepTime = 50;
	private boolean radi = false;
	protected int dX;
	protected int dY;
	
	public AktivnaFigura(Scena s, double x, double y) {
		super(s, x, y);
		thread = new Thread(this);
		thread.start();
	}
	
	public void pokreni() {
		radi = true;
		scena.repaint();
	}
	
	public synchronized void zavrsi() {
		if (thread != null) {
			thread.interrupt();
//			System.out.println("ZAVRSAVAM");
		}
	}
	
	public synchronized void zaustavi() {
		if (thread == null) {
			return;
		}
		thread.interrupt();
		try {
			thread.join();
			thread = null;
		} catch (InterruptedException e) {
		}
	}
	
	
	@Override
	public void run() {
		try {
			while (!thread.isInterrupted()) {
				if (radi) {
					pomeriFiguru(dX, dY);				
				}
				if (figuraIzasla()) {
					unistiFiguru();
					zavrsi();

				}
				
				Thread.sleep(sleepTime);			
			}
		} catch (InterruptedException e) {
		}
	}

}
