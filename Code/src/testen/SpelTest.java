package testen;

import domein.*;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpelTest {

	@Test
	void voegToeAanLijst_GeldigeInvoer_SpelerToegevoegd() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan",2003);
		assertEquals("Charan",dc.getSpelers().get(0).getNaam());
	}

	@Test
	void voegToeAanLijst_SpelerBestaatAl_SpelerWordtNietToegevoegd() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan",2003);
		assertEquals(1,dc.getSpelers().size());
	}

	@Test
	void startSpeler_JongereSpeler_JongsteSpelerIsStart() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2001);
		Speler speler2 = new Speler("Test2", 2000);
		Speler speler3 = new Speler("Test3", 2003);
		Speler speler4 = new Speler("Test4", 2002);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.voegToeAanLijst(speler3);
		spel.voegToeAanLijst(speler4);
		spel.startSpeler();
		assertTrue(speler3.isStartSpeler());
		assertFalse(speler1.isStartSpeler());
		assertFalse(speler2.isStartSpeler());
		assertFalse(speler4.isStartSpeler());
		assertEquals(speler3,spel.getHuidigeSpeler());
		assertTrue(speler3.isAanBeurt());

	}

	@Test
	void startSpeler_AlfabetischeNaam_JuisteSpelerIsStart() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Charan", 2003);
		Speler speler2 = new Speler("Renzoo", 2003);
		Speler speler3 = new Speler("Matisse", 2002);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.voegToeAanLijst(speler3);
		spel.startSpeler();
		assertTrue(speler1.isStartSpeler());
		assertFalse(speler2.isStartSpeler());
		assertFalse(speler3.isStartSpeler());
		assertEquals(speler1,spel.getHuidigeSpeler());
		assertTrue(speler1.isAanBeurt());

	}

	@Test
	void startSpeler_LangereNaam_LangsteNaamStart() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test22", 2000);
		Speler speler3 = new Speler("Test3", 2000);
		Speler speler4 = new Speler("Test4", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.voegToeAanLijst(speler3);
		spel.voegToeAanLijst(speler4);
		spel.startSpeler();
		assertTrue(speler2.isStartSpeler());
		assertFalse(speler1.isStartSpeler());
		assertFalse(speler3.isStartSpeler());
		assertFalse(speler4.isStartSpeler());
		assertEquals(speler2,spel.getHuidigeSpeler());
	}

	@Test
	void startSpeler_AlfabetischNaam_AlfabetischeNaamStart() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Testa", 2000);
		Speler speler2 = new Speler("Testb", 2000);
		Speler speler3 = new Speler("Testc", 2000);
		Speler speler4 = new Speler("Testd", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.voegToeAanLijst(speler3);
		spel.voegToeAanLijst(speler4);
		spel.startSpeler();
		assertTrue(speler1.isStartSpeler());
		assertEquals(speler1,spel.getHuidigeSpeler());
		assertFalse(speler2.isStartSpeler());
		assertFalse(speler2.isAanBeurt());
		assertFalse(speler3.isStartSpeler());
		assertFalse(speler3.isAanBeurt());
		assertFalse(speler4.isStartSpeler());
		assertFalse(speler4.isAanBeurt());
	}

	@Test
	void bepaalWinnaars_GeenWinnaars_WinnaarsIsLeeg() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan",2003);
		dc.registreerGegevens("Renzo",2003);
		dc.registreerGegevens("Johan",1990);
		dc.registreerGegevens("Matisse",2002);
		dc.speelSpel();
		assertEquals(0,dc.getWinnaars().size());
	}

	@Test
	void bepaalWinnaars_EenWinnaar_WinnaarsBevatEenSpeler() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test2", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		speler1.verhoogPrestigePunten(15);
		spel.bepaalWinnaars();
		assertEquals(speler1,spel.bepaalWinnaars().get(0));
		assertEquals(1,spel.bepaalWinnaars().size());
	}

	@Test
	void bepaalWinnaars_TweeWinnaars_WinnaarsBevat2Spelers() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test2", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		speler1.verhoogPrestigePunten(15);
		speler2.verhoogPrestigePunten(15);
		spel.bepaalWinnaars();
		assertEquals(speler1,spel.bepaalWinnaars().get(0));
		assertEquals(speler2,spel.bepaalWinnaars().get(1));
		assertEquals(2,spel.bepaalWinnaars().size());
	}

	@Test
	void bepaalVolgordeSpeler_1steSpelerEerst_VolgordeIsCorrect() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Charan", 2001);
		Speler speler2 = new Speler("Renzo", 2000);
		Speler speler3 = new Speler("Johan", 2000);
		Speler speler4 = new Speler("Matisse", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.voegToeAanLijst(speler3);
		spel.voegToeAanLijst(speler4);
		spel.startSpeler();
		spel.bepaalVolgordeSpeler();
		assertEquals("Charan",spel.getVolgordeSpelers().get(0).getNaam());
		assertEquals("Renzo",spel.getVolgordeSpelers().get(1).getNaam());
		assertEquals("Johan",spel.getVolgordeSpelers().get(2).getNaam());
		assertEquals("Matisse",spel.getVolgordeSpelers().get(3).getNaam());
		assertTrue(spel.getVolgordeSpelers().get(0).isStartSpeler());
		assertFalse(spel.getVolgordeSpelers().get(1).isStartSpeler());
		assertFalse(spel.getVolgordeSpelers().get(2).isStartSpeler());
		assertFalse(spel.getVolgordeSpelers().get(3).isStartSpeler());
	}

	@Test
	void neemFiches_TeVeelFiches_WerptException() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan", 2003);
		dc.registreerGegevens("Renzo", 2003);
		dc.speelSpel();
		List<Edelsteenfiche> fiches = new ArrayList<>();
		fiches.add(new Edelsteenfiche("blauw"));
		fiches.add(new Edelsteenfiche("blauw"));
		fiches.add(new Edelsteenfiche("blauw"));
		fiches.add(new Edelsteenfiche("blauw"));
		assertThrows(IllegalArgumentException.class, ()-> dc.neemFiches(fiches));
	}

	@Test
	void neemFiches_TeWeinigFiches_WerptException() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		spel.voegToeAanLijst(speler1);
		List<Edelsteenfiche> fiches = new ArrayList<>();
		fiches.add(new Edelsteenfiche("blauw"));
		assertThrows(IllegalArgumentException.class, ()-> spel.neemFiches(fiches));
	}

	@Test
	void neemFiches_GeldigAantalFiches_FichesToegevoegd() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan", 2003);
		dc.registreerGegevens("Renzo", 2003);
		dc.speelSpel();
		List<Edelsteenfiche> fiches = new ArrayList<>();
		fiches.add(new Edelsteenfiche("blauw"));
		fiches.add(new Edelsteenfiche("blauw"));
		dc.neemFiches(fiches);
		Speler speler1 = dc.getSpelers().get(0);
		Speler speler2 = dc.getSpelers().get(1);
		assertEquals(2,speler1.getAantalFiches());
		assertEquals(0,speler2.getAantalFiches());
		assertEquals(2,dc.getFicheBlauw().size());

	}

	@Test
	void maxFiches_MeerDanMaximum_WerptException() throws Exception {
		DomeinController dc = new DomeinController();
		dc.maakNieuwSpel();
		dc.registreerGegevens("Charan", 2003);
		dc.registreerGegevens("Renzo", 2003);
		dc.speelSpel();

	}

	@Test
	void koopEdele_HeeftNietGenoegBonussen_WerptException() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test2", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.startSpeler();
		spel.bepaalVolgordeSpeler();
		assertThrows(Exception.class,()->spel.koopEdele(new Edele(1, 1, 1, 1, 1, 1,1)));
	}

	@Test
	void koopEdele_HeeftGenoegBonussen_EdeleToegevoegd() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test2", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		speler1.voegFichesToe(new Edelsteenfiche("blauw"));
		speler1.voegFichesToe(new Edelsteenfiche("blauw"));
		speler1.voegKaartToe(new Ontwikkelingskaart("Blauw", 1, 1, 0, 2, 0,0,0,1));
		spel.startSpeler();
		spel.bepaalVolgordeSpeler();
		spel.koopEdele(new Edele(1, 1, 0, 1, 0, 0,0));
		assertEquals(1,speler1.getEdelen().size());

	}

	@Test
	void koopKaart_HeeftNietGenoegFiches_WerptException() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Test1", 2000);
		Speler speler2 = new Speler("Test2", 2000);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.startSpeler();
		spel.bepaalVolgordeSpeler();
		assertThrows(Exception.class,()->spel.koopKaart(new Ontwikkelingskaart("blauw", 1, 1, 1, 1, 1,1, 1,1)));

	}

	@Test
	void koopKaart_HeeftGenoegFiches_KaartToegevoegd() throws Exception {
		Spel spel = new Spel();
		Speler speler1 = new Speler("Charan", 2003);
		Speler speler2 = new Speler("Renzo", 2003);
		spel.voegToeAanLijst(speler1);
		spel.voegToeAanLijst(speler2);
		spel.startSpeler();
		spel.bepaalVolgordeSpeler();
		speler1.voegFichesToe(new Edelsteenfiche("blauw"));
		spel.koopKaart(new Ontwikkelingskaart("blauw", 1, 1, 0, 1, 0,0, 0,1));
		assertEquals(1,speler1.getOntwikkelingskaarten().size());
		assertEquals(0,speler1.getAantalFiches());
		assertEquals(1,speler1.getAantalPrestigepunten());

	}

}

