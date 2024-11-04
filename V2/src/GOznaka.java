package vodovod;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GOznaka extends Exception {
	
	public GOznaka() {
		super("Nemoguce izabrati ovaj kvadrat");
	}
	
	/*
	 * menuBar se dodaje Frejmu preko frejm.setMenuBar menuItem moze
	 * setAction/Label/Shortcut ->string akcionekomande za obradu dogadjaja default
	 * jednak labeli menu izveden iz menuItem, PADAJUCI meni, sadrzi druge MenuIteme
	 * menu se dodaje u menuBar chechkBoxMenuItem -> dugme sa dva stanja/stiklirano
	 * prozor -> menuBar -> menu -> menuItem //kreiranje pa traka.add(meni) menuItem
	 * -> menu -> menuBar -> prozor //dodavanje npr prozor.setMenuBar(traka) ACTION
	 * EVENT za menije: meni.addActionListener(osluskivac) public void
	 * actionPreformed (ActionEvent e) imeMenija.addActionListener(this); .. public
	 * void actionPerformed(ActionEvent e) { String komanda = e.getActionCommand();
	 * if (komanda.equals("Kraj")) dispose(); else { izborIzMenija = "Izabrali ste "
	 * + komanda + "."; repaint(); } } dugme primer: dugme.addActionListener((ae) ->
	 * { if (tipCevi != null && kanalizacija.getIzabrani() != null) {
	 * kanalizacija.dodajCev(kanalizacija.getIzabrani(), tipCevi); } });
	 * 
	 * dijalog - prozor za komunikaciju sa korisnikom; modalni - nema prebacivanja
	 * fokusa ili nemodalni; public Dialog(Frame roditelj, String naslov, Bool
	 * modalni); moze da se otovri preko setVisible, ne da se unisti;
	 * 
	 * panel - sluzi za organizaciju komponenti; moze da sadrzi dugmad ili druge
	 * panele; BorderLayout.GDEseNalazi; Flow -> sa leva na desno; Border
	 * standradno; Card dobar za tabove; Grid - resetka;
	 * 
	 * labela - staticki tekst prozor.add(labela,layout);labela.setAligment; checBox
	 * je polje za potvrdu ili radio dugme ako je u grupi radioGroup; koristi ITEM
	 * Event!; primer:levoDesno.addItemListener(e -> tipCevi = "LevoDesno");
	 * panel.add(checkBox), ako radio, prvo u chechBoxGroup preko KONSTRUKTORA
	 * cB(label,GRUPA,false);
	 * 
	 * list (vise redova selektovano) vs choice (1 izbor) je padajuca lista; dodaju
	 * se u panele, pa panel u prozor; koriste ITEM Listener, public void
	 * itemStateChanged(ItemEvent e);
	 * 
	 * textField, textArea txt polje/viselinijsko i koriste ACTION listener public
	 * void actionPreformed(ActionEvent e); moze da se stav alternativni
	 * karakter(echo) i getText() i setEditable();
	 * 
	 * primer tajmer; public class Timer extends Thread {
	 * 
	 * private Label label; private int s, m; private boolean work;
	 * 
	 * public Timer(Label label) { this.label = label; }
	 * 
	 * public void run() { try { while(!isInterrupted()) {
	 * 
	 * synchronized (this) { while(!work){ wait(); } }
	 * 
	 * label.setText(toString()); label.revalidate(); sleep(1000); s++; if (s % 60
	 * == 0) { m++; s = 0; } } } catch(InterruptedException e) {} }
	 * 
	 * public synchronized void go() { work = true; notify(); }
	 * 
	 * public synchronized void pause() { work = false; }
	 * 
	 * public synchronized void reset() { m = s = 0; }
	 * 
	 * @Override public String toString() { return String.format("%02d:%02d", m, s);
	 * }
	 * 
	 * } --------------- primer niti; private Thread thread; private boolean radi =
	 * false; konstuktor: thread = new Thread(this); thread.start(); public void
	 * pokreni() { radi = true; scena.repaint(); }
	 * 
	 * public synchronized void zavrsi() { if (thread != null) { thread.interrupt();
	 * } } public synchronized void zaustavi() { if (thread == null) { return; }
	 * thread.interrupt(); try { thread.join(); thread = null; } catch
	 * (InterruptedException e) { } }
	 * 
	 * @Override public void run() { try { while (!thread.isInterrupted()) { if
	 * (radi) { pomeriFiguru(dX, dY); } if (figuraIzasla()) { unistiFiguru();
	 * zavrsi();
	 * 
	 * }
	 * 
	 * Thread.sleep(sleepTime); } } catch (InterruptedException e) { } }
	 * 	scena.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scena.getIgrac().ispaliLopticu();
            }
        });
        scena.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
//			if (!scena.radi()) {
				int x = e.getX();
				int y = e.getY();
				super.mouseReleased(e);}}
	 */

}
