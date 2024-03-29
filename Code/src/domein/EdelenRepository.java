package domein;

import java.nio.file.StandardWatchEventKinds;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class EdelenRepository {

    /** UC1: Deze methode gaat 10 edelen aanmaken en deze toevoegen aan de stack. Verder gaat deze dan de
     * juiste aantal edelen toevoegen aan het spel op basis van het aantal spelers*/
    public static Stack<Edele> maakEdelen(int aantalSpelers) {
        Stack<Edele> edelen = new Stack<>();

        edelen.add(new Edele(1, 3, 0, 0, 4, 4, 0));
        edelen.add(new Edele(2, 3, 4, 4, 0, 0, 0));
        edelen.add(new Edele(3, 3, 4, 0, 0, 0, 4));
        edelen.add(new Edele(4, 3, 0, 4, 4, 0, 0));
        edelen.add(new Edele(5, 3, 0, 0, 0, 4, 4));
        edelen.add(new Edele(6, 3, 3, 0, 0, 3, 3));
        edelen.add(new Edele(7, 3, 0, 3, 3, 3, 0));
        edelen.add(new Edele(8, 3, 0, 3, 3, 0, 0));
        edelen.add(new Edele(9, 3, 3, 3, 0, 0, 3));
        edelen.add(new Edele(10, 3, 0, 0, 3, 3, 3));

        if (aantalSpelers == 2) {
            Collections.shuffle(edelen);
            Stack<Edele> edelen2 = new Stack<>();
            edelen2.add(edelen.pop());
            edelen2.add(edelen.pop());
            edelen2.add(edelen.pop());

            return edelen2;
        } else if (aantalSpelers == 3) {
            Collections.shuffle(edelen);
            Stack<Edele> edelen3 = new Stack<>();
            edelen3.add(edelen.pop());
            edelen3.add(edelen.pop());
            edelen3.add(edelen.pop());
            edelen3.add(edelen.pop());

            return edelen3;
        } else if (aantalSpelers == 4) {
            Collections.shuffle(edelen);
            Stack<Edele> edelen4 = new Stack<>();
            edelen4.add(edelen.pop());
            edelen4.add(edelen.pop());
            edelen4.add(edelen.pop());
            edelen4.add(edelen.pop());
            edelen4.add(edelen.pop());

            return edelen4;
        }

        return null;

    }
}
