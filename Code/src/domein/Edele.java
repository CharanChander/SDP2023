package domein;

import javafx.scene.image.ImageView;

public class Edele {

	/** Hieronder staan de attributen van de klasse Edele */
	private int naam;
	private int prestigepunten;
	private int prijsWit;
	private int prijsBlauw;
	private int prijsGroen;
	private int prijsRood;
	private int prijsZwart;
	
	private DomeinController dc;

	/** Dit is de constructor van de Edele */
	public Edele(int naam, int prestigepunten, int prijsWit, int prijsBlauw, int prijsGroen, int prijsRood, int prijsZwart) {
		this.naam = naam;
		this.prestigepunten = prestigepunten;
		this.prijsWit = prijsWit;
		this.prijsBlauw = prijsBlauw;
		this.prijsGroen = prijsGroen;
		this.prijsRood = prijsRood;
		this.prijsZwart = prijsZwart;
	}

	/** Hieronder staan de getters en setters die in de klasse Edele gebruikt zijn */
	public int getNaam() {
		return this.naam;
	}
	
	public int getPrestigepunten() {
		return this.prestigepunten;
	}
	
	public int getPrijsWit() {
		return this.prijsWit;
	}
	
	public int getPrijsBlauw() {
		return this.prijsBlauw;
	}
	
	public int getPrijsGroen() {
		return this.prijsGroen;
	}
	
	public int getPrijsRood() {
		return this.prijsRood;
	}
	
	public int getPrijsZwart() {
		return this.prijsZwart;
	}

	public ImageView getAfbeelding(){
		switch (this.naam) {
			case 1 ->{
				return new ImageView("/images/Edele/edele1.png");
			}
			case 2 ->{
				return new ImageView("/images/Edele/edele2.png");
			}
			case 3 ->{
				return new ImageView("/images/Edele/edele3.png");
			}
			case 4 ->{
				return new ImageView("/images/Edele/edele4.png");
			}
			case 5 ->{
				return new ImageView("/images/Edele/edele5.png");
			}
			case 6 ->{
				return new ImageView("/images/Edele/edele6.png");
			}
			case 7 ->{
				return new ImageView("/images/Edele/edele7.png");
			}
			case 8 ->{
				return new ImageView("/images/Edele/edele8.png");
			}
			case 9 ->{
				return new ImageView("/images/Edele/edele9.png");
			}
			case 10 ->{
				return new ImageView("/images/Edele/edele10.png");
			}

		}
		return null;
	}

}
