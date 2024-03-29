package domein;

import javafx.scene.image.ImageView;

import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class Ontwikkelingskaart {

	/** Hieronder staan de attributen van de klasse Ontwikkelingskaart */
	private String kleur;
	private int niveau;
	private int prestigepunten;
	private int prijsWit;
	private int prijsBlauw;
	private int prijsGroen;
	private int prijsRood;
	private int prijsZwart;
	private int id;

	/** Dit is de constructor van Ontwikkelingskaart */
	public Ontwikkelingskaart(String kleur, int niveau, int prestigepunten, int prijsWit, int prijsBlauw, int prijsGroen, int prijsRood, int prijsZwart,int id) {
		this.kleur = kleur;
		this.niveau = niveau;
		this.prestigepunten = prestigepunten;
		this.prijsWit = prijsWit;
		this.prijsBlauw = prijsBlauw;
		this.prijsGroen = prijsGroen;
		this.prijsRood = prijsRood;
		this.prijsZwart = prijsZwart;
		this.id = id;
	}

	/** Hieronder staan de getters en setters die in de klasse Ontwikkelingskaart gebruikt zijn */
	public String getKleur() {
		return kleur;
	}

	public int getNiveau() {
		return niveau;
	}

	public int getPrestigepunten() {
		return prestigepunten;
	}

	public int getPrijsWit() {
		return prijsWit;
	}

	public int getPrijsBlauw() {
		return prijsBlauw;
	}

	public int getPrijsGroen() {
		return prijsGroen;
	}

	public int getPrijsRood() {
		return prijsRood;
	}

	public int getPrijsZwart() {
		return prijsZwart;
	}

	public int getId() {
		return this.id;
	}

	public ImageView getAfbeelding(){
		switch (this.id){
			case 1->{
				return new ImageView("images/KaartN1/kaart1.png");
			}
			case 2->{
				return new ImageView("images/KaartN1/kaart2.png");
			}
			case 3->{
				return new ImageView("images/KaartN1/kaart3.png");
			}
			case 4->{
				return new ImageView("images/KaartN1/kaart4.png");
			}
			case 5->{
				return new ImageView("images/KaartN1/kaart5.png");
			}
			case 6->{
				return new ImageView("images/KaartN1/kaart6.png");
			}
			case 7->{
				return new ImageView("images/KaartN1/kaart7.png");
			}
			case 8->{
				return new ImageView("images/KaartN1/kaart8.png");
			}
			case 9->{
				return new ImageView("images/KaartN1/kaart9.png");
			}
			case 10->{
				return new ImageView("images/KaartN1/kaart10.png");
			}
			case 11->{
				return new ImageView("images/KaartN1/kaart11.png");
			}
			case 12->{
				return new ImageView("images/KaartN1/kaart12.png");
			}
			case 13->{
				return new ImageView("images/KaartN1/kaart13.png");
			}
			case 14->{
				return new ImageView("images/KaartN1/kaart14.png");
			}
			case 15->{
				return new ImageView("images/KaartN1/kaart15.png");
			}
			case 16->{
				return new ImageView("images/KaartN1/kaart16.png");
			}
			case 17->{
				return new ImageView("images/KaartN1/kaart17.png");
			}
			case 18->{
				return new ImageView("images/KaartN1/kaart18.png");
			}
			case 19->{
				return new ImageView("images/KaartN1/kaart19.png");
			}
			case 20->{
				return new ImageView("images/KaartN1/kaart20.png");
			}
			case 21->{
				return new ImageView("images/KaartN1/kaart21.png");
			}
			case 22->{
				return new ImageView("images/KaartN1/kaart22.png");
			}
			case 23->{
				return new ImageView("images/KaartN1/kaart23.png");
			}
			case 24->{
				return new ImageView("images/KaartN1/kaart24.png");
			}
			case 25->{
				return new ImageView("images/KaartN1/kaart25.png");
			}
			case 26->{
				return new ImageView("images/KaartN1/kaart26.png");
			}
			case 27->{
				return new ImageView("images/KaartN1/kaart27.png");
			}
			case 28->{
				return new ImageView("images/KaartN1/kaart28.png");
			}
			case 29->{
				return new ImageView("images/KaartN1/kaart29.png");
			}
			case 30->{
				return new ImageView("images/KaartN1/kaart30.png");
			}
			case 31->{
				return new ImageView("images/KaartN1/kaart31.png");
			}
			case 32->{
				return new ImageView("images/KaartN1/kaart32.png");
			}
			case 33->{
				return new ImageView("images/KaartN1/kaart33.png");
			}
			case 34->{
				return new ImageView("images/KaartN1/kaart34.png");
			}
			case 35->{
				return new ImageView("images/KaartN1/kaart35.png");
			}
			case 36->{
				return new ImageView("images/KaartN1/kaart36.png");
			}
			case 37->{
				return new ImageView("images/KaartN1/kaart37.png");
			}
			case 38->{
				return new ImageView("images/KaartN1/kaart38.png");
			}
			case 39->{
				return new ImageView("images/KaartN1/kaart39.png");
			}
			case 40->{
				return new ImageView("images/KaartN1/kaart40.png");
			}
			case 41->{
				return new ImageView("images/KaartN2/kaart41.png");
			}
			case 42->{
				return new ImageView("images/KaartN2/kaart42.png");
			}
			case 43->{
				return new ImageView("images/KaartN2/kaart43.png");
			}
			case 44->{
				return new ImageView("images/KaartN2/kaart44.png");
			}
			case 45->{
				return new ImageView("images/KaartN2/kaart45.png");
			}
			case 46->{
				return new ImageView("images/KaartN2/kaart46.png");
			}
			case 47->{
				return new ImageView("images/KaartN2/kaart47.png");
			}
			case 48->{
				return new ImageView("images/KaartN2/kaart48.png");
			}
			case 49->{
				return new ImageView("images/KaartN2/kaart49.png");
			}
			case 50->{
				return new ImageView("images/KaartN2/kaart50.png");
			}
			case 51->{
				return new ImageView("images/KaartN2/kaart51.png");
			}
			case 52->{
				return new ImageView("images/KaartN2/kaart52.png");
			}
			case 53->{
				return new ImageView("images/KaartN2/kaart53.png");
			}
			case 54->{
				return new ImageView("images/KaartN2/kaart54.png");
			}
			case 55->{
				return new ImageView("images/KaartN2/kaart55.png");
			}
			case 56->{
				return new ImageView("images/KaartN2/kaart56.png");
			}
			case 57->{
				return new ImageView("images/KaartN2/kaart57.png");
			}
			case 58->{
				return new ImageView("images/KaartN2/kaart58.png");
			}
			case 59->{
				return new ImageView("images/KaartN2/kaart59.png");
			}
			case 60->{
				return new ImageView("images/KaartN2/kaart60.png");
			}
			case 61->{
				return new ImageView("images/KaartN2/kaart61.png");
			}
			case 62->{
				return new ImageView("images/KaartN2/kaart62.png");
			}
			case 63->{
				return new ImageView("images/KaartN2/kaart63.png");
			}
			case 64->{
				return new ImageView("images/KaartN2/kaart64.png");
			}
			case 65->{
				return new ImageView("images/KaartN2/kaart65.png");
			}
			case 66->{
				return new ImageView("images/KaartN2/kaart66.png");
			}
			case 67->{
				return new ImageView("images/KaartN2/kaart67.png");
			}
			case 68->{
				return new ImageView("images/KaartN2/kaart68.png");
			}
			case 69->{
				return new ImageView("images/KaartN2/kaart69.png");
			}
			case 70->{
				return new ImageView("images/KaartN2/kaart70.png");
			}
			case 71->{
				return new ImageView("images/KaartN3/kaart71.png");
			}
			case 72->{
				return new ImageView("images/KaartN3/kaart72.png");
			}
			case 73->{
				return new ImageView("images/KaartN3/kaart73.png");
			}
			case 74->{
				return new ImageView("images/KaartN3/kaart74.png");
			}
			case 75->{
				return new ImageView("images/KaartN3/kaart75.png");
			}
			case 76->{
				return new ImageView("images/KaartN3/kaart76.png");
			}
			case 77->{
				return new ImageView("images/KaartN3/kaart77.png");
			}
			case 78->{
				return new ImageView("images/KaartN3/kaart78.png");
			}
			case 79->{
				return new ImageView("images/KaartN3/kaart79.png");
			}
			case 80->{
				return new ImageView("images/KaartN3/kaart80.png");
			}
			case 81->{
				return new ImageView("images/KaartN3/kaart81.png");
			}
			case 82->{
				return new ImageView("images/KaartN3/kaart82.png");
			}
			case 83->{
				return new ImageView("images/KaartN3/kaart83.png");
			}
			case 84->{
				return new ImageView("images/KaartN3/kaart84.png");
			}
			case 85->{
				return new ImageView("images/KaartN3/kaart85.png");
			}
			case 86->{
				return new ImageView("images/KaartN3/kaart86.png");
			}
			case 87->{
				return new ImageView("images/KaartN3/kaart87.png");
			}
			case 88->{
				return new ImageView("images/KaartN3/kaart88.png");
			}
			case 89->{
				return new ImageView("images/KaartN3/kaart89.png");
			}
			case 90->{
				return new ImageView("images/KaartN3/kaart90.png");
			}

		}
		return null;
	}

}