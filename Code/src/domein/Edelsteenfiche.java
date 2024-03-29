package domein;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Edelsteenfiche {

	/** Hieronder staan de attributen van de klasse Edelsteenfiche */
	private String kleur;
	private DomeinController dc;

	/** Dit is de constructor van Edelsteenfiche */
	public Edelsteenfiche(String kleur) {
		setKleur(kleur);
	}

	/** Hieronder staan de getters en setters die in de klasse Edelsteenfiche gebruikt zijn */
	public String getKleur() {
		return this.kleur;
	}

	public void setKleur(String kleur) {
		this.kleur = kleur;
	}

	public ImageView getAfbeelding(){
		switch (this.kleur.toLowerCase()){
			case "wit" -> {
				return new ImageView("/images/Fiches/FicheWit.png");
			}
			case "blauw" -> {
				return new ImageView("/images/Fiches/FicheBlauw.png");
			}
			case "groen" -> {
				return new ImageView("/images/Fiches/FicheGroen.png");
			}
			case "rood" -> {
				return new ImageView("/images/Fiches/FicheRood.png");
			}
			case "zwart" -> {
			return new ImageView("/images/Fiches/FicheZwart.png");
			}

		}return null;
	}
}


