package vodovod;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class Aplikacija extends Frame {
	
	private Kanalizacija kanalizacija;
	private String tipCevi;
	
	private void populateWindow() {
		Panel kontrole = new Panel();
		kontrole.setLayout(new GridLayout(0,1));
		
		CheckboxGroup izborCevi =  new CheckboxGroup();
		Checkbox levoDesno = new Checkbox("Levo-Desno", izborCevi,false);
		levoDesno.addItemListener(e -> tipCevi = "LevoDesno");
		Checkbox goreDole = new Checkbox("Gore-Dole", izborCevi,false);
		goreDole.addItemListener(e -> tipCevi = "GoreDole");
		Checkbox doleGore = new Checkbox("Dole-Gore", izborCevi,false);
		doleGore.addItemListener(e -> tipCevi = "DoleGore");
		Checkbox levoDole = new Checkbox("Levo-Dole", izborCevi,false);
		levoDole.addItemListener(e -> tipCevi = "LevoDole");
		Checkbox levoGore = new Checkbox("Levo-Gore", izborCevi,false);
		levoGore.addItemListener(e -> tipCevi = "LevoGore");
		Checkbox goreDesno = new Checkbox("Gore-Desno", izborCevi,false);
		goreDesno.addItemListener(e -> tipCevi = "GoreDesno");
		Checkbox doleDesno = new Checkbox("Dole-Desno", izborCevi,false);
		doleDesno.addItemListener(e -> tipCevi = "DoleDesno");
		
		kontrole.add(levoDesno);
		kontrole.add(goreDole);
		kontrole.add(doleGore);
		kontrole.add(levoDole);
		kontrole.add(levoGore);
		kontrole.add(goreDesno);
		kontrole.add(doleDesno);
		
		Button dodaj = new Button("Dodaj");
		dodaj.addActionListener((ae) -> {
			if (tipCevi != null && kanalizacija.getIzabrani() != null) {
				kanalizacija.dodajCev(kanalizacija.getIzabrani(), tipCevi);
			}
		});
		
		kontrole.add(dodaj);
		add(kontrole, BorderLayout.EAST);
		add(kanalizacija, BorderLayout.CENTER);
	}
	
	public Aplikacija(int r, int k) {
		kanalizacija = new Kanalizacija(r, k);
		setBounds(700, 200, 500, 500);
		setResizable(false);
		setTitle("Cevi");
		
		populateWindow();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Aplikacija(5, 5);	
	}

}
