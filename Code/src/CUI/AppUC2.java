package CUI;

import domein.DomeinController;
import domein.Taal;

import java.util.Scanner;

public class AppUC2
{
	DomeinController dc;
	Taal keuze = new Taal();

	public void start()
	{
		SelecteerTaal();
	}
	
	public AppUC2(DomeinController dc)
	{
		this.dc = dc;
	}
	
	public void SelecteerTaal()
	{
		Scanner scanner = new Scanner(System.in);
	while(true)
	{
		try {
			System.out.println(keuze.getBundleTaal().getString("TaalKeuzeCUI"));
			int taal = scanner.nextInt();
			keuze.setTaal(taal);
			
			
			if (taal > 2 || taal <= 0)
			{
				throw new IllegalArgumentException(keuze.getBundleTaal().getString("fout_taal"));
				
			}
		break;
		}catch (NumberFormatException e)
		{
			System.out.println(keuze.getBundleTaal().getString("fout_taal2"));
		
	    }catch (IllegalArgumentException e)
		{
		System.out.println(e.getMessage());
		
		}
	}
	}
}