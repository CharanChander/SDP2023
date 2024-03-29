
package CUI;

import domein.DomeinController;
import domein.Taal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SplendorApp 
{	
	private DomeinController dc;
	Taal keuze = new Taal();

	private boolean nogSpeler = true;
	public SplendorApp(DomeinController dc){
		this.dc =dc;
		dc.maakNieuwSpel();
	}
	
	public void start() 
	{
		Scanner scanner = new Scanner(System.in);
		String naam;
		int geboortejaar;
		boolean invoer = true;
		
		do {
			try {
				invoer = false;
				System.out.println(keuze.getBundleTaal().getString("naam"));
				naam = scanner.next();
				System.out.println(keuze.getBundleTaal().getString("geboortejaar"));
				geboortejaar = scanner.nextInt();
				dc.registreerGegevens(naam, geboortejaar);
				invoer = true;
				System.out.printf(keuze.getBundleTaal().getString("registratie_succesvol"), naam, geboortejaar);

			} catch (InputMismatchException ie) {
				System.err.println(keuze.getBundleTaal().getString("fout_geboortejaar"));
				scanner.nextLine();

			} catch (Exception e) {
				System.err.println(keuze.getBundleTaal().getString(e.getMessage()));
				scanner.nextLine();

		    }
			
			/*catch (RuntimeException re)
			{
				System.err.println(keuze.getBundleTaal().getString("bestaand"));
				scanner.nextLine();
			}*/


			
		} while (!invoer || !dc.isEindeRegistratie());
		if(dc.isEindeRegistratie()&& nogSpeler) {
			meerDan2();
		}else{
			System.out.printf(keuze.getBundleTaal().getString("stand_spelers"), dc.aantalSpelers());
		}

	}

	public void meerDan2() {
		String jaNee;
		Scanner s = new Scanner(System.in);
		do{
			System.out.println(keuze.getBundleTaal().getString("toevoegen"));
			jaNee = s.next();
			if(jaNee.toLowerCase().equals(keuze.getBundleTaal().getString("ja"))){
				nogSpeler = true;
				start();
			}else if(jaNee.toLowerCase().equals(keuze.getBundleTaal().getString("nee"))){
				nogSpeler = false;
				System.out.printf(keuze.getBundleTaal().getString("stand_spelers"), dc.aantalSpelers());
			}else {
				System.out.println(keuze.getBundleTaal().getString("ja_nee"));
				meerDan2();
		}}while(dc.aantalSpelers() <4 && nogSpeler);

	}
	
	
}