package domein;

import DTO.SpelDTO;
import DTO.SpelerDTO;

import java.util.List;
import java.util.Stack;

public class DomeinController{

	/** Hieronder staan de attributen die in de klasse DomeinController gebruikt zijn */

	private Spel spel;
	private Taal keuze;
	private SpelerRepository spelerRepository;
	private EdelsteenficheRepository edelsteenficheRepository;
	private EdelenRepository edelenRepository;
	private OntwikkelingskaartRepository ontwikkelingskaartRepository;

	/** Dit is de constructor van DomeinController */
	public DomeinController() {
		keuze = new Taal();
		spelerRepository = new SpelerRepository();
		edelsteenficheRepository = new EdelsteenficheRepository();
		edelenRepository = new EdelenRepository();
		ontwikkelingskaartRepository = new OntwikkelingskaartRepository();
	}

	/**UC1: Eerst wordt het spelobject gemaakt. Hierbij worden de ontwikkelingskaarten
	 * gemaakt en toegevoegd aan het spel */
	public void maakNieuwSpel() {
		spel = new Spel();
	}

	/** UC2: Deze methode maakt het aantal edelsteenfiches en edelen op basis
	 * van het aantal spelers */
	public void speelSpel() {
		Stack<Edelsteenfiche> fichesWit = edelsteenficheRepository.maakEdelsteenficheWit(this.aantalSpelers());
		Stack<Edelsteenfiche> fichesBlauw = edelsteenficheRepository.maakEdelsteenficheBlauw(this.aantalSpelers());
		Stack<Edelsteenfiche> fichesGroen = edelsteenficheRepository.maakEdelsteenficheGroen(this.aantalSpelers());
		Stack<Edelsteenfiche> fichesZwart = edelsteenficheRepository.maakEdelsteenficheZwart(this.aantalSpelers());
		Stack<Edelsteenfiche> fichesRood = edelsteenficheRepository.maakEdelsteenficheRood(this.aantalSpelers());
		List<Edele> edelen = edelenRepository.maakEdelen(this.aantalSpelers());
		Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau1 = ontwikkelingskaartRepository.maakOntwikkelingskaartenNiveau1();
		Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau2 = ontwikkelingskaartRepository.maakOntwikkelingskaartenNiveau2();
		Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau3 = ontwikkelingskaartRepository.maakOntwikkelingskaartenNiveau3();
		spel.speelSpel(fichesWit,fichesBlauw,fichesGroen,fichesRood,fichesZwart, edelen,ontwikkelingskaartenNiveau1, ontwikkelingskaartenNiveau2, ontwikkelingskaartenNiveau3);
	}

	/** UC1: Er bestaat een spelobject. Hier wordt een speler aangemaakt en
	 * de speler wordt gelinkt met het spel */
	public void registreerGegevens(String naam, int geboortejaar) throws Exception {
		Speler test = new Speler(naam, geboortejaar);
		boolean antwoord = spelerRepository.bestaatSpeler(naam,geboortejaar);
		if(antwoord) {
			try {
				spel.voegToeAanLijst(test);
				test = null;
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}
		}else{
			throw new Exception("niet_bestaand");
		}
	}

	/** UC1: Deze methode gaat aangeven of de registratie is afgelopen of niet */
	public boolean isEindeRegistratie() {
		return spel.isEindeRegistratie();
	}

	/** UC1: Deze methode gaat het aantal spelers weergeven */
	public int aantalSpelers(){
		return spel.aantalSpelers();
	}

	/** UC2: Dit is de DTO van Speler */
	public SpelerDTO geefInfoSpelers(Speler s) {
		return new SpelerDTO(s.getNaam(),s.getAantalPrestigepunten(),s.isAanBeurt(),s.isStartSpeler(),s.getOntwikkelingskaarten(),s.getEdelsteenfiches(),s.getEdelen());
		//LIST MAKAN VAN DTO
	}

	/** UC2: Dit is de DTO van Spel */
	public SpelDTO geefInfoSpel(Spel s) {
		return new SpelDTO(s.getEdelen(), s.getOntwikkelingskaartenNiveau1(),s.getOntwikkelingskaartenNiveau2(),s.getOntwikkelingskaartenNiveau3(), s.getFichesWit(),s.getFichesBlauw(),s.getFichesGroen(),s.getFichesRood(),s.getFichesZwart());
	}

	/** Hieronder staan de getters en setters die in de klasse DomeinController gebruikt zijn */
	public List<Speler> getSpelers(){
		return spel.getSpelers();
	}

	public Stack<Ontwikkelingskaart> getOntwikkelingskaartenSpeler(Speler speler)
	{
		return spel.getOntwikkelingskaartenSpeler(speler);
	}

	public void neemFiches(List<Edelsteenfiche> fiches) throws Exception {
		spel.neemFiches(fiches);
	}

	public void maxFiches() throws Exception {
		spel.maxFiches();
	}

	public void koopEdele(Edele edele) throws Exception {
		spel.koopEdele(edele);
	}

	public void koopKaart(Ontwikkelingskaart kaart)throws Exception{
		spel.koopKaart(kaart);
	}

	public Speler getHuidigeSpeler(){
		return spel.getHuidigeSpeler();
	}

	public Stack<Edelsteenfiche> getFicheWit(){
		return spel.getFichesWit();
	}

	public Stack<Edelsteenfiche> getFicheBlauw(){
		return spel.getFichesBlauw();
	}

	public Stack<Edelsteenfiche> getFicheGroen(){
		return spel.getFichesGroen();
	}

	public Stack<Edelsteenfiche> getFicheRood(){
		return spel.getFichesRood();
	}

	public Stack<Edelsteenfiche> getFicheZwart(){
		return spel.getFichesZwart();
	}

	public List<Edele> getEdelen(){
		return spel.getEdelen();
	}

	public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau1(){
		return spel.getOntwikkelingskaartenNiveau1();
	}

	public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau2(){
		return spel.getOntwikkelingskaartenNiveau2();
	}

	public Stack<Ontwikkelingskaart> getOntwikkelingskaartenNiveau3(){
		return spel.getOntwikkelingskaartenNiveau3();
	}

	public List<Speler> getWinnaars(){
		return spel.bepaalWinnaars();
	}

	public boolean isEindeBeurt(){
		return spel.isEindeBeurt();
	}

	/**UC2: Deze methode gaat aangeven of het spel gedaan is of niet */
	public boolean isEindeSpel() {
		return spel.isEindeSpel();
	}

	public void volgendeSpeler() {
		spel.volgendeSpeler();
	}

	public void geefFicheTerug(Edelsteenfiche fiche) {
		spel.geefFicheTerug(fiche);
	}
}