package domein;

import java.util.List;

import persistentie.SpelerMapper;

public class SpelerRepository 
{
	private SpelerMapper spelerMapper;
	
	public SpelerRepository()
	{
		spelerMapper = new SpelerMapper();
	}
	
	/** UC1: Deze methode gaat zeggen of de speler in de database bestaat of niet */
	public boolean bestaatSpeler(String naam, int geboortejaar)
	{
		return spelerMapper.bestaatSpeler(naam, geboortejaar);
	}
	
}
