package domein;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EdelsteenficheRepository {

    /** UC1: Deze methode gaat edelsteenfiches toevoegen aan een stack op basis van de kleur. De hoeveelheid
     * edelsteenfiches wordt weer bepaald door het aantal spelers dat meedoen aan het spel */

    private int aantalSpelers(int aantalSpelers){
        int aantalFiches;

        if (aantalSpelers == 2) {
            aantalFiches = 4;
        } else if (aantalSpelers == 3) {
            aantalFiches = 5;
        } else {
            aantalFiches = 7;
        }
        return aantalFiches;
    }
    public Stack<Edelsteenfiche> maakEdelsteenficheWit(int aantalSpelers) {
        Stack<Edelsteenfiche> edelsteenFiches = new Stack<>();

        for (int i = 0; i < aantalSpelers(aantalSpelers); i++) {
            edelsteenFiches.push(new Edelsteenfiche("wit"));
        }
        return edelsteenFiches;
    }

    public Stack<Edelsteenfiche> maakEdelsteenficheBlauw(int aantalSpelers) {
        Stack<Edelsteenfiche> edelsteenFiches = new Stack<>();

        for (int i = 0; i < aantalSpelers(aantalSpelers); i++) {
            edelsteenFiches.push(new Edelsteenfiche("blauw"));
        }
        return edelsteenFiches;
    }

    public Stack<Edelsteenfiche> maakEdelsteenficheGroen(int aantalSpelers) {
        Stack<Edelsteenfiche> edelsteenFiches = new Stack<>();

        for (int i = 0; i < aantalSpelers(aantalSpelers); i++) {
            edelsteenFiches.push(new Edelsteenfiche("groen"));
        }
        return edelsteenFiches;
    }

    public Stack<Edelsteenfiche> maakEdelsteenficheRood(int aantalSpelers) {
        Stack<Edelsteenfiche> edelsteenFiches = new Stack<>();

        for (int i = 0; i < aantalSpelers(aantalSpelers); i++) {
            edelsteenFiches.push(new Edelsteenfiche("rood"));
        }
        return edelsteenFiches;
    }

    public Stack<Edelsteenfiche> maakEdelsteenficheZwart(int aantalSpelers) {
        Stack<Edelsteenfiche> edelsteenFiches = new Stack<>();

        for (int i = 0; i < aantalSpelers(aantalSpelers); i++) {
            edelsteenFiches.push(new Edelsteenfiche("zwart"));
        }
        return edelsteenFiches;
    }
}
