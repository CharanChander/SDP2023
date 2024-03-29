package testen;

import domein.Speler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpelerTest {
	
	@Test
	void setNaam_GeldigeInvoer_naamAangepast(){
		assertEquals("Test _",new Speler("Test _",2000).getNaam());
		
	}
	
	@Test
	void setNaam_EersteLetterGeenLetter_WerptException() {
		assertThrows(IllegalArgumentException.class, ()->new Speler("_ Test",2000));
	}
	
	@Test
	void setNaam_SpeciaalTeken_WerptException() {
		assertThrows(IllegalArgumentException.class, ()->new Speler("Test_ +",2000));
	}
	
	@Test
	void setGeboortejaar_GeldigJaar_GeboortejaarAangepast() {
		assertEquals(2000,new Speler("Test_ ",2000).getGeboortejaar());
	}
	
	@Test
	void setGeboortejaar_teOud_WerptException() {
		assertThrows(IllegalArgumentException.class, ()-> new Speler("Test_ ",1900));
	}
	
	@Test
	void setGeboortejaar_teJong_WerptException() {
		assertThrows(IllegalArgumentException.class, ()-> new Speler("Test_ ",2022));
	}

}
