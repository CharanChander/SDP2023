package domein;

import java.time.LocalDate;
import java.util.*;

public class Speler {

	/** Hieronder staan de attributen van de klasse Speler */

	private static LocalDate currentDate = LocalDate.now();
	private String naam;
	private int geboortejaar;
	private static final int HUIDIG_JAARTAL = currentDate.getYear();
	private int aantalPrestigepunten = 0;
	private Stack<Ontwikkelingskaart> ontwikkelingskaarten;
	private List<Edele> edelen;
	private Stack<Edelsteenfiche> aantalWitFiche;
	private Stack<Edelsteenfiche> aantalBlauwFiche;
	private Stack<Edelsteenfiche> aantalGroenFiche;
	private Stack<Edelsteenfiche> aantalRoodFiche;
	private Stack<Edelsteenfiche> aantalZwartFiche;
	private int aantalWitPunten=0;
	private int aantalBlauwPunten=0;
	private int aantalGroenPunten=0;
	private int aantalRoodPunten=0;
	private int aantalZwartPunten=0;
	private Map<Edelsteenfiche, Integer> Edelsteenfiches;
	private int aantalKaartTypeWit = 0;
	private int aantalKaartTypeBlauw = 0;
	private int aantalKaartTypeGroen = 0;
	private int aantalKaartTypeRood = 0;
	private int aantalKaartTypeZwart = 0;
	private boolean isAanBeurt = false;
	private boolean isStartSpeler = false;


	/** Dit is de constructor van Speler */
	public Speler(String naam, int geboortejaar){
		setNaam(naam);
		setGeboortejaar(geboortejaar);
		this.ontwikkelingskaarten = new Stack<>();
		this.edelen = new ArrayList<>();
		this.aantalWitFiche = new Stack<>();
		this.aantalBlauwFiche = new Stack<>();
		this.aantalGroenFiche = new Stack<>();
		this.aantalRoodFiche = new Stack<>();
		this.aantalZwartFiche = new Stack<>();
		this.Edelsteenfiches = new HashMap<>();

	}

	/** UC4: Deze methode gaat ontwikkelingskaarten toevoegen aan de spelervoorraad */
	public void voegKaartToe(Ontwikkelingskaart kaart){
		this.ontwikkelingskaarten.add(kaart);
		if (kaart.getKleur().equalsIgnoreCase("wit")){
			aantalKaartTypeWit++;
			verhoogWitPunten(1);
		} else if (kaart.getKleur().equalsIgnoreCase("blauw")) {
			aantalKaartTypeBlauw++;
			verhoogBlauwPunten(1);
		} else if (kaart.getKleur().equalsIgnoreCase("groen")) {
			aantalKaartTypeGroen++;
			verhoogGroenPunten(1);
		} else if (kaart.getKleur().equalsIgnoreCase("rood")){
			aantalKaartTypeRood++;
			verhoogRoodPunten(1);
		} else if (kaart.getKleur().equalsIgnoreCase("zwart")) {
			aantalKaartTypeZwart++;
			verhoogZwartPunten(1);
		}else{
			throw new IllegalArgumentException("fout_kaart");
		}
	}

	/** UC4: Deze methode gaat edelsteenfiches toevoegen aan de spelervoorraad */ 
	public void voegFichesToe(Edelsteenfiche fiche) {
		if (fiche.getKleur().equalsIgnoreCase("wit")) {
			aantalWitFiche.add(fiche);
			verhoogWitPunten(1);
		} else if (fiche.getKleur().equalsIgnoreCase("blauw")) {
			aantalBlauwFiche.add(fiche);
			verhoogBlauwPunten(1);
		} else if (fiche.getKleur().equalsIgnoreCase("groen")) {
			aantalGroenFiche.add(fiche);
			verhoogGroenPunten(1);
		} else if (fiche.getKleur().equalsIgnoreCase("rood")) {
			aantalRoodFiche.add(fiche);
			verhoogRoodPunten(1);
		} else if (fiche.getKleur().equalsIgnoreCase("zwart")) {
			aantalZwartFiche.add(fiche);
			verhoogZwartPunten(1);
		}else{
			throw new IllegalArgumentException("fout_kleur");
		}
	}

	/** Hieronder staan de getters en setters die in de klasse Speler gebruikt zijn */
	public int getAantalFiches(){
		return aantalWitFiche.size() + aantalBlauwFiche.size() + aantalGroenFiche.size() + aantalRoodFiche.size() + aantalZwartFiche.size();
	}

	public String getNaam() {
		return this.naam;
	}

	public void setNaam(String naam) {
		boolean is1eLetterGeldig = false;
		boolean isWoordGeldig = false;
		is1eLetterGeldig = Character.isLetter(naam.charAt(0));

		for (int i = 0; i < naam.length(); i++) {
			char c = naam.charAt(i);
			isWoordGeldig = Character.isLetterOrDigit(c) || c == ' ' || c == '_';
		}

		if(is1eLetterGeldig && isWoordGeldig) {
			this.naam = naam;
		}else {
			throw new IllegalArgumentException("naam_ongeldig");
		}
	}

	public int getGeboortejaar() {
		return this.geboortejaar;
	}

	public void setGeboortejaar(int geboortejaar){
		if(HUIDIG_JAARTAL - geboortejaar < 6 || geboortejaar < 1930) {
			throw new IllegalArgumentException("fout_geboortejaar2");
		}else {
			this.geboortejaar = geboortejaar;
		}
	}

	public int getAantalPrestigepunten() {
		return this.aantalPrestigepunten;
	}

	public void verhoogPrestigePunten(int punten) {
		if (punten < 0) {
			throw new IllegalArgumentException("fout_punten");
		}else {
			this.aantalPrestigepunten += punten;
		}
	}

	public Stack<Ontwikkelingskaart> getOntwikkelingskaarten(){
		return this.ontwikkelingskaarten;
	}

	public List<Edele> getEdelen(){
		return this.edelen;
	}

	public void voegEdelenToe(Edele edele) {
		this.edelen.add(edele);
	}

	public Map<Edelsteenfiche, Integer> getEdelsteenfiches() {
		setEdelsteenfiches();
		return this.Edelsteenfiches;
	}

	public void setEdelsteenfiches() {
		this.Edelsteenfiches.put(new Edelsteenfiche("Wit"), aantalWitFiche.size());
		this.Edelsteenfiches.put(new Edelsteenfiche("blauw"), aantalBlauwFiche.size());
		this.Edelsteenfiches.put(new Edelsteenfiche("groen"), aantalGroenFiche.size());
		this.Edelsteenfiches.put(new Edelsteenfiche("rood"), aantalRoodFiche.size());
		this.Edelsteenfiches.put(new Edelsteenfiche("zwart"), aantalZwartFiche.size());
	}


	public int getAantalKaartTypeBlauw(){
		return this.aantalKaartTypeBlauw;
	}

	public int getAantalKaartTypeGroen(){
		return this.aantalKaartTypeGroen;
	}

	public int getAantalKaartTypeRood(){
		return this.aantalKaartTypeRood;
	}

	public int getAantalKaartTypeWit(){
		return this.aantalKaartTypeWit;
	}

	public int getAantalKaartTypeZwart(){
		return this.aantalKaartTypeZwart;
	}

	public boolean isAanBeurt() {
		return this.isAanBeurt;
	}

	public void setAanBeurt(boolean jaNeen) {
		this.isAanBeurt = jaNeen;
	}

	public void setStartSpeler(boolean jaNeen) {
		this.isStartSpeler = jaNeen;
	}

	public boolean isStartSpeler()
	{
		return this.isStartSpeler;
	}

	public int getAantalWitPunten(){
		return this.aantalWitPunten;
	}

	public void verhoogWitPunten(int punten){
		this.aantalWitPunten += punten;
	}

	public void verlaagWitPunten(int punten){
		this.aantalWitPunten -= punten;
	}

	public int getAantalBlauwPunten(){
		return this.aantalBlauwPunten;
	}

	public void verhoogBlauwPunten(int punten){
		this.aantalBlauwPunten += punten;
	}

	public void verlaagBlauwPunten(int punten){
		this.aantalBlauwPunten -= punten;
	}

	public int getAantalGroenPunten(){
		return this.aantalGroenPunten;
	}

	public void verhoogGroenPunten(int punten){
		this.aantalGroenPunten += punten;
	}

	public void verlaagGroenPunten(int punten){
		this.aantalGroenPunten -= punten;
	}

	public int getAantalRoodPunten(){
		return this.aantalRoodPunten;
	}

	public void verhoogRoodPunten(int punten){
		this.aantalRoodPunten += punten;
	}

	public void verlaagRoodPunten(int punten){
		this.aantalRoodPunten -= punten;
	}

	public int getAantalZwartPunten(){
		return this.aantalZwartPunten;
	}

	public void verhoogZwartPunten(int punten){
		this.aantalZwartPunten += punten;
	}

	public void verlaagZwartPunten(int punten){
		this.aantalZwartPunten -= punten;
	}

	public int getAantalWitFiches(){
		return aantalWitFiche.size();
	}

	public void verhoogWitFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalWitFiche.add(new Edelsteenfiche("wit"));
		}
	}

	public void verlaagWitFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalWitFiche.pop();
		}
	}

	public Stack<Edelsteenfiche> getWitFiche(){
		return this.aantalWitFiche;
	}

	public int getAantalBlauwFiches(){
		return aantalBlauwFiche.size();
	}

	public void verhoogBlauwFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalBlauwFiche.add(new Edelsteenfiche("blauw"));
		}
	}

	public void verlaagBlauwFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalBlauwFiche.pop();
		}
	}

	public Stack<Edelsteenfiche> getBlauwFiche(){
		return this.aantalBlauwFiche;
	}

	public int getAantalGroenFiches(){
		return aantalGroenFiche.size();
	}

	public void verhoogGroenFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalGroenFiche.add(new Edelsteenfiche("groen"));
		}
	}

	public void verlaagGroenFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalGroenFiche.pop();
		}
	}

	public Stack<Edelsteenfiche> getGroenFiche(){
		return this.aantalGroenFiche;
	}

	public int getAantalRoodFiches(){
		return aantalRoodFiche.size();
	}

	public void verhoogRoodFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalRoodFiche.add(new Edelsteenfiche("rood"));
		}
	}

	public void verlaagRoodFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalRoodFiche.pop();
		}
	}

	public Stack<Edelsteenfiche> getRoodFiche(){
		return this.aantalRoodFiche;
	}

	public int getAantalZwartFiches(){
		return aantalZwartFiche.size();
	}

	public void verhoogZwartFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalZwartFiche.add(new Edelsteenfiche("zwart"));
		}
	}

	public void verlaagZwartFiches(int aantal){
		for(int i = 0; i < aantal; i++){
			aantalZwartFiche.pop();
		}
	}

	public Stack<Edelsteenfiche> getZwartFiche(){
		return this.aantalZwartFiche;
	}

}

