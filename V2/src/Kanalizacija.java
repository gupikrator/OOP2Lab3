package vodovod;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class Kanalizacija extends Panel {
	
	private int redovi;
	private int kolone;
	private ArrayList<Kvadrat> kvadrati = new ArrayList<>();
	private Kvadrat izabraniKvadrat;
	private int indeksIzabranog;
	
	public Kanalizacija(int r, int k) {
		super(new GridLayout(r, k, 2, 2));
		this.redovi = r;
		this.kolone = k;
		for (int i = 0; i < redovi*kolone; i++) {
			Kvadrat z = new Zid();
			kvadrati.add(z);
			this.add(z);
		}
	}
	
	public Kvadrat getIzabrani() {
		return izabraniKvadrat;
	}
	
	public void izaberiKvadrat(Kvadrat k) throws GOznaka {
		for (Kvadrat kvadrat: kvadrati) {
			if (k.equals(kvadrat)) {
				indeksIzabranog = kvadrati.indexOf(k);
				break;
			}
		}
		if (izabraniKvadrat != null) {
			izabraniKvadrat.ukloniOznaku();
			izabraniKvadrat.repaint();
		}
		
		izabraniKvadrat = k;
		izabraniKvadrat.postaviOznaku();
		izabraniKvadrat.repaint();
//		izabraniKvadrat.setBackground(Color.RED);
		System.out.println("Kvadrat " + indeksIzabranog +"  izabran");
	}
	
	public void dodajCev(Kvadrat k, String tipCevi) {
		if (izabraniKvadrat == null) {
			System.out.println("glup sam");
			return;
		}
		//dodaj da ovo bude cev koja treba?
		switch (tipCevi) {
		case "LevoDesno":
			kvadrati.set(indeksIzabranog, new LevoDesnoCev());
			break;
		case "GoreDole":
			kvadrati.set(indeksIzabranog, new GoreDoleCev());
			break;
		case "DoleGore":
			kvadrati.set(indeksIzabranog, new DoleGoreCev());
			break;
		case "LevoDole":
			kvadrati.set(indeksIzabranog, new LevoDoleCev());
			break;
		case "LevoGore":
			kvadrati.set(indeksIzabranog, new LevoGoreCev());
			break;
		case "GoreDesno":
			kvadrati.set(indeksIzabranog, new GoreDesnoCev());
			break;
		case "DoleDesno":
			kvadrati.set(indeksIzabranog, new DoleDesnoCev());
			break;
			 
		}
		System.out.println("stavio, sad ce da crta");
		removeAll();
		for (Kvadrat kvadrat: kvadrati) {
			add(kvadrat);
		}
		revalidate();
	}

}
