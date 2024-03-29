package domein;

import java.util.Collections;
import java.util.Stack;

public class OntwikkelingskaartRepository {

    /** UC1: Deze methode gaat ontwikkelingskaarten van niveau 1 toevoegen aan een stack */
    public static Stack<Ontwikkelingskaart> maakOntwikkelingskaartenNiveau1() {
        Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau1 = new Stack<>();

        //Niveau 1
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 1, 0, 4, 0, 0, 0,8));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 1, 0, 1, 2, 1,10));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 1, 0, 0, 0, 2,13));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 0, 0, 1, 3, 1,4));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 3, 0, 0, 0, 0,39));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 2, 0, 1, 0, 2,35));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 2, 1, 0, 0, 0,29));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 0, 0, 3, 0, 0,7));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 2, 0, 0, 2,22));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 0, 0, 0, 3, 0,31));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 1, 0, 0, 1, 3,36));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 0, 2, 1, 0, 0,37));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 2, 0, 2, 0, 0,6));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 1, 1, 0, 1, 1,25));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 1, 1, 1, 1,17));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 2, 2, 0, 1, 0,3));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 1, 3, 1, 0, 0,28));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 1, 2, 1, 1,18));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 2, 2, 0, 1,19));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 3, 0, 0, 0,23));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 1, 1, 1, 1, 0,1));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 3, 1, 0, 0, 1,20));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 0, 0, 2, 1, 0,5));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 0, 1, 0, 2, 2,27));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 0, 0, 0, 0, 3,15));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 2, 1, 1, 0, 1,34));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 1, 1, 0, 1, 2,26));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 0, 1, 3, 1, 0,12));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 1, 0, 2, 2, 0,11));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 1, 0, 0, 4, 0, 0,24));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 1, 0, 0, 0, 0, 4,32));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Groen", 1, 0, 0, 2, 0, 2, 0,30));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 2, 0, 0, 2, 0,38));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 1, 4, 0, 0, 0, 0,40));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 0, 0, 2, 0, 2,14));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 0, 1, 0, 1, 1, 1,9));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Blauw", 1, 1, 0, 0, 0, 4, 0,16));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Rood", 1, 0, 1, 1, 1, 0, 1,33));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Zwart", 1, 0, 1, 2, 1, 1, 0,2));
        ontwikkelingskaartenNiveau1.push(new Ontwikkelingskaart("Wit", 1, 0, 0, 0, 0, 2, 1,21));

        Collections.shuffle(ontwikkelingskaartenNiveau1);

        return ontwikkelingskaartenNiveau1;
    }

    /** UC1: Deze methode gaat ontwikkelingskaarten van niveau 2 toevoegen aan een stack */
    public static Stack<Ontwikkelingskaart> maakOntwikkelingskaartenNiveau2() {
        Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau2 = new Stack<>();
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 2, 5, 0, 0, 0, 0,45));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 1, 3, 2, 2, 0, 0,41));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 1, 0, 3, 0, 2, 3,66));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 1, 2, 3, 0, 0, 2,60));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 2, 0, 0, 1, 4, 2,55));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 1, 2, 3, 0, 3, 0,54));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 1, 3, 0, 2, 3, 0,59));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 2, 2, 0, 0, 1, 4,50));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 2, 0, 0, 0, 0, 5,69));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 2, 3, 0, 0, 0, 5,68));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 1, 0, 2, 3, 0, 3,48));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 1, 2, 0, 0, 2, 3,65));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 3, 0, 0, 6, 0, 0,64));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 2, 1, 4, 2, 0, 0,67));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 2, 0, 5, 0, 0, 0,51));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 2, 0, 5, 3, 0, 0,62));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 2, 4, 2, 0, 0, 1,61));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 2, 0, 0, 0, 5, 0,57));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 3, 6, 0, 0, 0, 0,58));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 2, 0, 1, 4, 2, 0,43));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 3, 0, 6, 0, 0, 0,52));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 2, 0, 0, 5, 3, 0,44));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 1, 0, 0, 3, 2, 2,53));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 1, 0, 2, 2, 3, 0,47));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 1, 3, 0, 3, 0, 2,42));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Groen", 2, 2, 0, 0, 5, 0, 0,63));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Wit", 2, 2, 0, 0, 0, 5, 3,56));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Zwart", 2, 3, 0, 0, 0, 0, 6,46));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Blauw", 2, 2, 5, 3, 0, 0, 0,49));
        ontwikkelingskaartenNiveau2.push(new Ontwikkelingskaart("Rood", 2, 3, 0, 0, 0, 6, 0,70));

        Collections.shuffle(ontwikkelingskaartenNiveau2);

        return ontwikkelingskaartenNiveau2;
    }

    /** UC1: Deze methode gaat ontwikkelingskaarten van niveau 3 toevoegen aan een stack */
    public static Stack<Ontwikkelingskaart> maakOntwikkelingskaartenNiveau3(){
        Stack<Ontwikkelingskaart> ontwikkelingskaartenNiveau3 = new Stack<>();
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Rood", 3, 4, 0, 3, 6, 3, 0,89));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Zwart", 3, 5, 0, 0, 0, 7, 3,74));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Zwart", 3, 4, 0, 0, 3, 6, 3,73));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Groen", 3, 4, 3, 6, 3, 0, 0,85));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Wit", 3, 5, 3, 0, 0, 0, 7,82));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Wit", 3, 3, 0, 3, 3, 5, 3,79));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Rood", 3, 5, 0, 0, 7, 3, 0,90));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Blauw", 3, 3, 3, 0, 3, 3, 5,75));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Groen", 3, 3, 5, 3, 0, 3, 3,83));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Rood", 3, 4, 0, 0, 7, 0, 0,88));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Blauw", 3, 4, 7, 0, 0, 0, 0,76));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Zwart", 3, 4, 0, 0, 0, 7, 0,72));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Wit", 3, 4, 0, 0, 0, 0, 7,80));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Groen", 3, 5, 0, 7, 3, 0, 0,86));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Wit", 3, 4, 3, 0, 0, 3, 6,81));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Blauw", 3, 4, 6, 3, 0, 0, 3,77));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Groen", 3, 4, 0, 7, 0, 0, 0,84));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Zwart", 3, 3, 3, 3, 5, 3, 0,71));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Rood", 3, 3, 3, 5, 3, 0, 3,87));
        ontwikkelingskaartenNiveau3.push(new Ontwikkelingskaart("Blauw", 3, 5, 7, 3, 0, 0, 0,78));

        Collections.shuffle(ontwikkelingskaartenNiveau3);

        return ontwikkelingskaartenNiveau3;
    }
}