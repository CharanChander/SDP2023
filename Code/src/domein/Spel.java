package domein;

import javafx.scene.control.Alert;

import java.util.*;

public class Spel {

	/** Hieronder staan de attributen die in de klasse Spel gebruikt zijn */
	private List<Speler> spelers;
	private Stack<Edelsteenfiche> ficheWit;
	private Stack<Edelsteenfiche> ficheBlauw;
	private Stack<Edelsteenfiche> ficheGroen;
	private Stack<Edelsteenfiche> ficheRood;
	private Stack<Edelsteenfiche> ficheZwart;
	private List<Edele> edelen;
	private Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau1;
	private Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau2;
	private Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau3;
	List<Speler> volgordeSpelers;
	private Speler huidigeSpeler;
	private boolean isEindeBeurt;

	/** Dit is de constructor van Spel */
	public Spel() {
		this.spelers = new ArrayList<>();
		this.ficheWit = new Stack<>();
		this.ficheBlauw = new Stack<>();
		this.ficheGroen = new Stack<>();
		this.ficheRood = new Stack<>();
		this.ficheZwart = new Stack<>();
		this.edelen = new ArrayList<>();
		this.ontwikkelingskaartenNiveau1 = new Stack<>();
		this.ontwikkelingskaartenNiveau2 = new Stack<>();
		this.ontwikkelingskaartenNiveau3 = new Stack<>();
		this.volgordeSpelers = new ArrayList<>();
		this.isEindeBeurt = false;
	}

	/** UC1: Deze methode gaat aangeven of de registratie is afgelopen of niet */
	public boolean isEindeRegistratie() {
		return this.spelers.size() >= 2;
	}

	/** UC1: Deze methode gaat de speler toevoegen aan het spel */
	public void voegToeAanLijst(Speler sp) throws Exception {
		boolean isToegevoegd = false;
		for (Speler s : this.spelers) {
			if (s.getNaam().equals(sp.getNaam())) {
				isToegevoegd = true;
			}
		}
		if (!isToegevoegd) {
			this.spelers.add(sp);
		} else {
			throw new Exception("Speler_Al_Toegevoegd");
		}
	}

	/** UC1: Deze methode gaat het aantal spelers teruggeven */
	public int aantalSpelers() {
		return this.spelers.size();
	}

	/**
	 * UC2: Deze methode voegt de startspeler, de edelsteenfiches, de edelen en de ontwikkelingskaarten
	 * met hun niveau toe aan het spel
	 */
	public void speelSpel(Stack<Edelsteenfiche> fichesWit,
						  Stack<Edelsteenfiche> fichesBlauw,
						  Stack<Edelsteenfiche> fichesGroen,
						  Stack<Edelsteenfiche> fichesRood,
						  Stack<Edelsteenfiche> fichesZwart,
						  List<Edele> edelen,
						  Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau1,
						  Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau2,
						  Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau3) {
		setFichesWit(fichesWit);
		setFichesBlauw(fichesBlauw);
		setFichesGroen(fichesGroen);
		setFichesRood(fichesRood);
		setFichesZwart(fichesZwart);
		setEdelen(edelen);
		setOntwikkelingskaartenNiveau1(ontwikkelingskaartenNiveau1);
		setOntwikkelingskaartenNiveau2(ontwikkelingskaartenNiveau2);
		setOntwikkelingskaartenNiveau3(ontwikkelingskaartenNiveau3);
		startSpeler();
		bepaalVolgordeSpeler();
	}


	/**
	 * UC2: Deze methode gaat kijken of het spel geïndigd is door te kijken of een speler(s)
	 * het maximum aantal prestigepunten heeft bereikt
	 */
	public boolean isEindeSpel() {
		return bepaalWinnaars().size() > 0;
	}

	/**
	 * UC1: Deze methode gaat kijken welke speler mag beginnen aan het spel. De methode gaat eerst kijken
	 * of er een jongste speler is. Als er meerdere spelers even oud zijn gaan ze kijken naar de langste
	 * gebruikersnaam. Als die ook gelijk is wordt de speler genomen van wie de gebruikersnaam na omgekeerd
	 * alfabetisch het eerste voorkomt
	 */
	public void startSpeler() {
		Speler startSpeler = null;
		Speler speler1 = this.spelers.get(0);
		Speler speler2 = this.spelers.get(1);

		switch (aantalSpelers()) {
			case 2 -> {
				startSpeler = Vergelijk(startSpeler, speler1, speler2);
			}
			case 3 -> {
				Speler speler3 = this.spelers.get(2);
				List<Speler> kant1 = new ArrayList<>();
				kant1.add(speler1);
				kant1.add(speler2);

				startSpeler = Vergelijk(startSpeler, speler1, speler2);

				if (vergelijkJaar(startSpeler, speler3) == speler3) {
					startSpeler = speler3;
				} else if (vergelijkJaar(startSpeler, speler3) == null) {
					if (vergelijkNaam(startSpeler, speler3) == speler3) {
						startSpeler = speler3;
					}else if(vergelijkNaam(startSpeler, speler3) == null){
						if (vergelijkNaamOmgekeerd(startSpeler, speler3) == speler3) {
							startSpeler = speler3;
						}
					}

				}

			}
			case 4 -> {
				Speler speler3 = this.spelers.get(2);
				Speler speler4 = this.spelers.get(3);
				List<Speler> kant1 = new ArrayList<>();
				kant1.add(speler1);
				kant1.add(speler2);
				List<Speler> kant2 = new ArrayList<>();
				kant2.add(speler3);
				kant2.add(speler4);

				startSpeler = Vergelijk(startSpeler, speler1, speler2);

				for (Speler speler : kant2) {
					if (vergelijkJaar(startSpeler, speler) == speler) {
						startSpeler = speler;
					} else if (vergelijkJaar(startSpeler, speler) == null) {
						if (vergelijkNaam(startSpeler, speler) == speler) {
							startSpeler = speler;
						}else if(vergelijkNaam(startSpeler, speler) == null){
							if (vergelijkNaamOmgekeerd(startSpeler, speler) == speler) {
								startSpeler = speler;
							}
						}

					}
				}
			}
		}
		setStartSpeler(startSpeler);
		setHuidigeSpeler(startSpeler);
	}

	private Speler Vergelijk(Speler startSpeler, Speler speler1, Speler speler2) {
		if (vergelijkJaar(speler1, speler2) == speler1) {
			startSpeler = speler1;
		} else if (vergelijkJaar(speler1, speler2) == speler2) {
			startSpeler = speler2;
		} else {
			if (vergelijkNaam(speler1, speler2) == speler1) {
				startSpeler = speler1;
			} else if (vergelijkNaam(speler1, speler2) == speler2) {
				startSpeler = speler2;
			} else {
				if (vergelijkNaamOmgekeerd(speler1, speler2) == speler1) {
					startSpeler = speler1;
				} else if (vergelijkNaamOmgekeerd(speler1, speler2) == speler2) {
					startSpeler = speler2;
				}
			}

		}
		return startSpeler;
	}

	public Speler vergelijkJaar (Speler speler1, Speler speler2){
			if (speler1.getGeboortejaar() > speler2.getGeboortejaar()) {
				return speler1;
			} else if (speler1.getGeboortejaar() < speler2.getGeboortejaar()) {
				return speler2;
			}
			return null;
		}
		
		public Speler vergelijkNaam(Speler speler1, Speler speler2){
			if (speler1.getNaam().length() > speler2.getNaam().length()) {
				return speler1;
			} else if (speler1.getNaam().length() < speler2.getNaam().length()) {
				return speler2;
			}
			return null;
		}

		public Speler vergelijkNaamOmgekeerd(Speler speler1, Speler speler2){
			if (new StringBuilder(speler1.getNaam()).reverse().toString().compareTo(new StringBuilder(speler2.getNaam()).reverse().toString()) < 0) {
				return speler1;
			} else if (new StringBuilder(speler1.getNaam()).reverse().toString().compareTo(new StringBuilder(speler2.getNaam()).reverse().toString()) > 0) {
				return speler2;
			}
			return null;
		}

		/** UC2: Deze methode gaat de winnaar van het spel bepalen. De methode gaat eerst kijken of er spelers
		 * het maximum aantal prestigepunten heeft bereikt. Als dit er maar 1 is, wordt deze weergegeven. Als
		 * dit er meer dan 2 zijn dan worden deze toegevoegd aan een nieuwe lijst en wordt er gekeken naar wie
		 * het minste ontwikkelingskaarten heeft */
		public List<Speler> bepaalWinnaars () {
			List<Speler> winnaars = new ArrayList<>();

			int maxPrestigePunten = 15;
			int minOntwikkelingskaarten = Integer.MAX_VALUE;

			for (Speler speler : this.spelers) {
				if (speler.getAantalPrestigepunten() > maxPrestigePunten || speler.getAantalPrestigepunten() == maxPrestigePunten) {
					winnaars.add(speler);
				}
			}
			if (winnaars.size() == 1) {
				return winnaars;
			} else {
				for (Speler winnaar : winnaars) {
					if (winnaar.getOntwikkelingskaarten().size() < minOntwikkelingskaarten) {
						minOntwikkelingskaarten = winnaar.getOntwikkelingskaarten().size();
					}
				}
				List<Speler> finaleWinnaars = new ArrayList<>();
				for (Speler winnaar : winnaars) {
					if (winnaar.getOntwikkelingskaarten().size() == minOntwikkelingskaarten) {
						finaleWinnaars.add(winnaar);
					}
				}
				return finaleWinnaars;
			}
		}

		/** UC3: Deze methode gaat bepalen in welke volgorde dat de spelers mogen spelen in het spel*/
		public void bepaalVolgordeSpeler () {
			List<Speler> volgordeSpelers = new ArrayList<>();
			Speler startSpeler = null;

			for (Speler speler : this.spelers) {
				if (speler.isStartSpeler()) {
					startSpeler = speler;
				}
			}
			volgordeSpelers.add(startSpeler);
			for (Speler speler : this.spelers) {
				if (speler != startSpeler) {
					volgordeSpelers.add(speler);
				}
			}
			setVolgordeSpelers(volgordeSpelers);
		}

		/** UC4: Deze methode gaat de speler edelsteenfiches laten nemen. Hier hangt het af van de hoeveelheid
		 * dat deze wilt nemen. Bij een keuze van 2 edelsteenfiches gaan we kijken of er nog genoeg edelsteenfiches
		 * in het spel op de tafel ligt en het moet van dezelfde kleur zijn. Bij een keuze van 3 edelsteenfiches
		 * wordt er gekeken of deze van 3 verschillende kleuren zijn. De edelsteenfiches worden dan verwijderd van
		 * de spelvoorraad en toegevoegd aan de spelervoorraad */
		public void neemFiches (List < Edelsteenfiche > fiches) throws Exception {
			setEindeBeurt(false);
			if (fiches.size() == 2) {
				if ((Objects.equals(fiches.get(0).getKleur().toLowerCase(), fiches.get(1).getKleur().toLowerCase()))) {
					if (meerDan2(fiches.get(0))) {
						voegFicheToe(fiches.get(0));
						voegFicheToe(fiches.get(1));
						maxFiches();
					} else{
						throw new Exception("teweinigfiches");
					}
				} else {
					throw new IllegalArgumentException("zelfdekleur");
				}
			} else if (fiches.size() == 3) {
				if (!Objects.equals(fiches.get(0).getKleur(), fiches.get(1).getKleur()) && !Objects.equals(fiches.get(0).getKleur(), fiches.get(2).getKleur()) && !Objects.equals(fiches.get(1).getKleur(), fiches.get(2).getKleur())) {
					voegFicheToe(fiches.get(0));
					voegFicheToe(fiches.get(1));
					voegFicheToe(fiches.get(2));
					maxFiches();
				} else {
					throw new IllegalArgumentException("anderetypefiches");
				}
			} else {
				throw new IllegalArgumentException("2of3fichesnemen");
			}
			setEindeBeurt(true);
			volgendeSpeler();
		}


		/*public void neemFiches (List<Edelsteenfiche> fiches ) throws Exception
		{
			int poging = 3;
			boolean	succes = false;
			while ( poging > 0 && !succes) {
				try {
					neemFiches(fiches);
					succes = true;
				} catch (Exception e) {
					Alert aError = new Alert(Alert.AlertType.ERROR);
					aError.setTitle("Error Fiches");
					aError.setHeaderText("Error Fiches");
					aError.setContentText("Error Te Weinig Fiches" + e.getMessage());
					aError.show();
					poging--;

			}
		}
		*/


		/** UC1: Deze methode gaat kijken of er genoeg edelsteenfiches op de stapel in het spel ligt */
		private boolean meerDan2 (Edelsteenfiche fiche){
			switch (fiche.getKleur().toLowerCase()) {
				case "wit" -> {
					return this.ficheWit.size() >= 4;
				}
				case "blauw" -> {
					return this.ficheBlauw.size() >= 4;
				}
				case "groen" -> {
					return this.ficheGroen.size() >= 4;
				}
				case "rood" -> {
					return this.ficheRood.size() >= 4;
				}
				case "zwart" -> {
					return this.ficheZwart.size() >= 4;
				}

			}
			return true;
		}

		/** UC1: Deze methode gaat de edelsteenfiches die de speler gekozen heeft toevoegen aan de voorraad van de speler*/
		private void voegFicheToe (Edelsteenfiche fiche){
			switch (fiche.getKleur().toLowerCase()) {
				case "wit" -> {
					this.huidigeSpeler.voegFichesToe(fiche);
					this.ficheWit.pop();
				}
				case "blauw" -> {
					this.huidigeSpeler.voegFichesToe(fiche);
					this.ficheBlauw.pop();
				}
				case "groen" -> {
					this.huidigeSpeler.voegFichesToe(fiche);
					this.ficheGroen.pop();
				}
				case "rood" -> {
					this.huidigeSpeler.voegFichesToe(fiche);
					this.ficheRood.pop();
				}
				case "zwart" -> {
					this.huidigeSpeler.voegFichesToe(fiche);
					this.ficheZwart.pop();
				}
			}
		}

		/** UC4: Deze methode gaat kijken of de speler niet meer dan 10 edelsteenfiches liggen heeft in zijn
		 * voorraad */
		public void maxFiches () throws Exception {
			if (this.huidigeSpeler.getAantalFiches() > 10) {
				geefFichesTerug();
				throw new Exception("maxfiches");
			}
		}

		private Map<Edelsteenfiche,Integer> geefFichesTerug () {
			return this.huidigeSpeler.getEdelsteenfiches();
		}

		/** UC3: Deze methode gaat kijken naar de ontwikkelingskaarten in de spelervoorraad. Als deze voldoet
		 * aan de voorwaarden van de edele kan de speler er 1 kiezen en wordt deze verwijderd uit de spelvoorraad
		 * en toegevoegd aan de spelervoorraad */
		public void koopEdele (Edele edele) throws Exception {
			setEindeBeurt(false);
			if (edele.getPrijsBlauw() <= this.huidigeSpeler.getAantalKaartTypeBlauw()
					&& edele.getPrijsGroen() <= this.huidigeSpeler.getAantalKaartTypeGroen()
					&& edele.getPrijsRood() <= this.huidigeSpeler.getAantalKaartTypeRood()
					&& edele.getPrijsZwart() <= this.huidigeSpeler.getAantalKaartTypeZwart()) {
				this.huidigeSpeler.voegEdelenToe(edele);
				this.edelen.remove(edele);
			} else {
				throw new Exception("tearm");
			}
			setEindeBeurt(true);
			volgendeSpeler();
		}

		/** UC4: Deze methode gaat kijken naar het aantal edelsteenfiches en de aantal bonussen in de spelervoorraad.
		 * Als deze voldoet aan de voorwaarden van een ontwikkelingskaart op het spelbord kan de speler deze kopen.
		 * Deze ontwikkelingskaart wordt dan verwijderd van de spelvoorraad en vervangen door een nieuwe ontwikkelingskaart
		 * De ontwikkelingskaart wordt ook toegevoegd aan de spelervoorraad */
		public void koopKaart (Ontwikkelingskaart kaart) throws Exception {
			setEindeBeurt(false);
			if (kaart.getKleur().equalsIgnoreCase("wit")) {
				if (this.huidigeSpeler.getAantalWitPunten() >= kaart.getPrijsWit()&&
				this.huidigeSpeler.getAantalZwartPunten() >= kaart.getPrijsZwart()&&
				this.huidigeSpeler.getAantalBlauwPunten() >= kaart.getPrijsBlauw()&&
				this.huidigeSpeler.getAantalRoodPunten() >= kaart.getPrijsRood()&&
				this.huidigeSpeler.getAantalGroenPunten() >= kaart.getPrijsGroen()) {
					int aantal = kaart.getPrijsWit() - this.huidigeSpeler.getAantalKaartTypeWit();
					this.huidigeSpeler.voegKaartToe(kaart);
					this.huidigeSpeler.verhoogPrestigePunten(kaart.getPrestigepunten());
					this.huidigeSpeler.verlaagWitPunten(aantal);
					this.huidigeSpeler.verhoogWitPunten(1);
					this.huidigeSpeler.verlaagWitFiches(aantal);
					verwijderKaart(kaart);
					while (aantal != 0) {
						this.ficheWit.push(new Edelsteenfiche("Wit"));
						aantal--;
					}
				} else {
					throw new Exception("nietgenoegfiches");
				}
			} else if (kaart.getKleur().equalsIgnoreCase("blauw")) {
				if (this.huidigeSpeler.getAantalWitPunten() >= kaart.getPrijsWit()&&
						this.huidigeSpeler.getAantalZwartPunten() >= kaart.getPrijsZwart()&&
						this.huidigeSpeler.getAantalBlauwPunten() >= kaart.getPrijsBlauw()&&
						this.huidigeSpeler.getAantalRoodPunten() >= kaart.getPrijsRood()&&
						this.huidigeSpeler.getAantalGroenPunten() >= kaart.getPrijsGroen()) {
					int aantal = kaart.getPrijsBlauw() - this.huidigeSpeler.getAantalKaartTypeBlauw();
					this.huidigeSpeler.voegKaartToe(kaart);
					this.huidigeSpeler.verhoogPrestigePunten(kaart.getPrestigepunten());
					this.huidigeSpeler.verlaagBlauwPunten(aantal);
					this.huidigeSpeler.verhoogBlauwPunten(1);
					this.huidigeSpeler.verlaagBlauwFiches(aantal);
					verwijderKaart(kaart);
					while (aantal != 0) {
						this.ficheBlauw.push(new Edelsteenfiche("Blauw"));
						aantal--;
					}
				} else {
					throw new Exception("nietgenoegfiches");
				}
			} else if (kaart.getKleur().equalsIgnoreCase("Groen")) {
				if (this.huidigeSpeler.getAantalWitPunten() >= kaart.getPrijsWit()&&
						this.huidigeSpeler.getAantalZwartPunten() >= kaart.getPrijsZwart()&&
						this.huidigeSpeler.getAantalBlauwPunten() >= kaart.getPrijsBlauw()&&
						this.huidigeSpeler.getAantalRoodPunten() >= kaart.getPrijsRood()&&
						this.huidigeSpeler.getAantalGroenPunten() >= kaart.getPrijsGroen()) {
					int aantal = kaart.getPrijsGroen() - this.huidigeSpeler.getAantalKaartTypeGroen();
					this.huidigeSpeler.voegKaartToe(kaart);
					this.huidigeSpeler.verhoogPrestigePunten(kaart.getPrestigepunten());
					this.huidigeSpeler.verlaagGroenPunten(aantal);
					this.huidigeSpeler.verhoogGroenPunten(1);
					this.huidigeSpeler.verlaagGroenFiches(aantal);
					verwijderKaart(kaart);
					while (aantal != 0) {
						this.ficheGroen.push(new Edelsteenfiche("Groen"));
						aantal--;
					}

				} else {
					throw new Exception("nietgenoegfiches");
				}
			} else if (kaart.getKleur().equalsIgnoreCase("rood")) {
				if (this.huidigeSpeler.getAantalWitPunten() >= kaart.getPrijsWit()&&
						this.huidigeSpeler.getAantalZwartPunten() >= kaart.getPrijsZwart()&&
						this.huidigeSpeler.getAantalBlauwPunten() >= kaart.getPrijsBlauw()&&
						this.huidigeSpeler.getAantalRoodPunten() >= kaart.getPrijsRood()&&
						this.huidigeSpeler.getAantalGroenPunten() >= kaart.getPrijsGroen()) {
					int aantal = kaart.getPrijsRood() - this.huidigeSpeler.getAantalKaartTypeRood();
					this.huidigeSpeler.voegKaartToe(kaart);
					this.huidigeSpeler.verhoogPrestigePunten(kaart.getPrestigepunten());
					this.huidigeSpeler.verlaagRoodPunten(aantal);
					this.huidigeSpeler.verhoogRoodPunten(1);
					this.huidigeSpeler.verlaagRoodFiches(aantal);
					verwijderKaart(kaart);
					while (aantal != 0) {
						this.ficheRood.push(new Edelsteenfiche("Rood"));
						aantal--;
					}

				} else {
					throw new Exception("nietgenoegfiches");
				}
			} else if (kaart.getKleur().equalsIgnoreCase("zwart")) {
				if (this.huidigeSpeler.getAantalWitPunten() >= kaart.getPrijsWit()&&
						this.huidigeSpeler.getAantalZwartPunten() >= kaart.getPrijsZwart()&&
						this.huidigeSpeler.getAantalBlauwPunten() >= kaart.getPrijsBlauw()&&
						this.huidigeSpeler.getAantalRoodPunten() >= kaart.getPrijsRood()&&
						this.huidigeSpeler.getAantalGroenPunten() >= kaart.getPrijsGroen()) {
					int aantal = kaart.getPrijsZwart() - this.huidigeSpeler.getAantalKaartTypeZwart();
					this.huidigeSpeler.voegKaartToe(kaart);
					this.huidigeSpeler.verhoogPrestigePunten(kaart.getPrestigepunten());
					this.huidigeSpeler.verlaagZwartPunten(aantal);
					this.huidigeSpeler.verhoogZwartPunten(1);
					this.huidigeSpeler.verlaagZwartFiches(aantal);
					verwijderKaart(kaart);
					while (aantal != 0) {
						this.ficheZwart.push(new Edelsteenfiche("Zwart"));
						aantal--;
					}

				} else {
					throw new Exception("nietgenoegfiches");
				}
			}
			setEindeBeurt(true);
			volgendeSpeler();

		}

		/** UC4: Deze methode gaat de ontwikkelingskaart van het spelbord verwijderen als een speler deze gekocht heeft */
	private void verwijderKaart(Ontwikkelingskaart kaart) {
			switch (kaart.getNiveau()){
				case 1 ->{
					this.ontwikkelingskaartenNiveau1.remove(kaart);
				}
				case 2 ->{
					this.ontwikkelingskaartenNiveau2.remove(kaart);
				}
				case 3 ->{
					this.ontwikkelingskaartenNiveau3.remove(kaart);
				}
			}
	}

	/** UC2: Deze methode gaat de huidige speler vervangen met de volgende speler als zijn beurt om is */
	public void volgendeSpeler(){
		int index = volgordeSpelers.indexOf(this.huidigeSpeler);
		this.huidigeSpeler.setAanBeurt(false);
		if (index != getSpelers().size()-1){
			this.huidigeSpeler = volgordeSpelers.get(index+1);
		}else{
			this.huidigeSpeler = volgordeSpelers.get(0);
		}
		this.huidigeSpeler.setAanBeurt(true);
	}


		/** Hieronder staan de getters en setters die in de klasse Spel gebruikt zijn */

		public Speler getHuidigeSpeler () {
			return this.huidigeSpeler;
		}

		public void setHuidigeSpeler (Speler speler){
			this.huidigeSpeler = speler;
			speler.setAanBeurt(true);
		}


		public void setStartSpeler (Speler speler){
			speler.setStartSpeler(true);
		}

		private void setEdelen (List < Edele > edelen) {
			this.edelen = edelen;
		}

		public List<Edele> getEdelen () {
			return this.edelen;
		}


		public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau1 () {
			return this.ontwikkelingskaartenNiveau1;
		}

		public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau2 () {
			return this.ontwikkelingskaartenNiveau2;
		}

		public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau3 () {
			return this.ontwikkelingskaartenNiveau3;
		}

		public void setOntwikkelingskaartenNiveau1 (Stack < Ontwikkelingskaart > ontwikkelingskaartenNiveau1) {
			this.ontwikkelingskaartenNiveau1 = ontwikkelingskaartenNiveau1;
		}

		public void setOntwikkelingskaartenNiveau2 (Stack < Ontwikkelingskaart > ontwikkelingskaartenNiveau2) {
			this.ontwikkelingskaartenNiveau2 = ontwikkelingskaartenNiveau2;
		}

		public void setOntwikkelingskaartenNiveau3 (Stack < Ontwikkelingskaart > ontwikkelingskaartenNiveau3) {
			this.ontwikkelingskaartenNiveau3 = ontwikkelingskaartenNiveau3;
		}

		public List<Speler> getSpelers () {
			return this.spelers;
		}

		public Stack<Ontwikkelingskaart> getOntwikkelingskaartenSpeler (Speler speler){
			return speler.getOntwikkelingskaarten();
		}

		public List<Speler> getVolgordeSpelers () {
			return this.volgordeSpelers;
		}
		public void setVolgordeSpelers (List < Speler > volgordeSpelers) {
			this.volgordeSpelers = volgordeSpelers;
		}

		public boolean isEindeBeurt () {
			return this.isEindeBeurt;
		}
		public void setEindeBeurt ( boolean eindeBeurt){
			this.isEindeBeurt = eindeBeurt;
		}

		public Stack<Edelsteenfiche> getFichesZwart () {
			return this.ficheZwart;
		}

		private void setFichesZwart (Stack < Edelsteenfiche > fichesZwart) {
			this.ficheZwart = fichesZwart;
		}

		public Stack<Edelsteenfiche> getFichesRood () {
			return this.ficheRood;
		}
		private void setFichesRood (Stack < Edelsteenfiche > fichesRood) {
			this.ficheRood = fichesRood;
		}

		public Stack<Edelsteenfiche> getFichesGroen () {
			return this.ficheGroen;
		}
		private void setFichesGroen (Stack < Edelsteenfiche > fichesGroen) {
			this.ficheGroen = fichesGroen;
		}

		public Stack<Edelsteenfiche> getFichesBlauw () {
			return this.ficheBlauw;
		}
		private void setFichesBlauw (Stack < Edelsteenfiche > fichesBlauw) {
			this.ficheBlauw = fichesBlauw;
		}

		public Stack<Edelsteenfiche> getFichesWit () {
			return this.ficheWit;
		}

		private void setFichesWit (Stack < Edelsteenfiche > fichesWit) {
			this.ficheWit = fichesWit;
		}

		public void geefFicheTerug(Edelsteenfiche fiche){
			if (fiche.getKleur().equalsIgnoreCase("wit")) {
				ficheWit.add(fiche);
				this.huidigeSpeler.verlaagWitFiches(1);
			} else if (fiche.getKleur().equalsIgnoreCase("blauw")) {
				ficheBlauw.add(fiche);
				this.huidigeSpeler.verlaagBlauwFiches(1);
			} else if (fiche.getKleur().equalsIgnoreCase("groen")) {
				ficheGroen.add(fiche);
				this.huidigeSpeler.verlaagGroenFiches(1);
			} else if (fiche.getKleur().equalsIgnoreCase("rood")) {
				ficheRood.add(fiche);
				this.huidigeSpeler.verlaagRoodFiches(1);
			} else if (fiche.getKleur().equalsIgnoreCase("zwart")) {
				ficheZwart.add(fiche);
				this.huidigeSpeler.verlaagZwartFiches(1);
			}else{
				throw new IllegalArgumentException("fout_kleur");
			}
		}


}

