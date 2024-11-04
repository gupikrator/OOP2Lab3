package usisavanje;

import java.util.ArrayList;



public class SkupFigura {
	
	private static int globalID = 0;
	private ArrayList<Figura> figure;
	private int brojFigura;
	private Figura tekuca;
	
	public SkupFigura() {
		this.figure = new ArrayList<>();
		this.brojFigura = 0;
	}
	
	public int brojFigura() {
		return this.brojFigura;
	}
	
	public void dodajFiguru(Figura f) {
		if(!(seNalazi(f))) {
			figure.add(f);
			brojFigura++;
			
			System.out.println("Dodata figura: " + globalID);
			globalID++;
		}
	}
	
	public boolean seNalazi(Figura f) {
		for (Figura figura : figure) {
			if (f.equals(figura)) {
				return true;
			}
		}
		return false;
	}
	
	public void postaviPrvuTekucom() {
		if (brojFigura > 0) {
			this.tekuca = figure.get(0);
		}
	}
	
	public void postaviSledecu() {
		if (postojiSledeca()) {
			this.tekuca = figure.get( figure.indexOf(tekuca)+1 );
		}
	}
	
	public Figura dohvatiTekucu() {
		return this.tekuca;
	}
	
	public boolean postojiSledeca() {
		int i = figure.indexOf(tekuca);
		return i < (brojFigura - 1);
	}
	
	public void isprazni() {
		figure.clear();
	}
	
	public void izbaciFiguru(Figura f) {
		if (seNalazi(f)) {
			figure.remove(f);
			brojFigura--;
		}
	}

}
