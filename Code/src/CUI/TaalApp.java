package CUI;

import domein.Taal;

import java.util.Scanner;

public class TaalApp 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gelieve een taal te kiezen om verder te gaan (1= NL / 2= EN)");
		int taal = scanner.nextInt();
		
		
		Taal keuze = new Taal();
		System.out.println(keuze.getBundleTaal().getString("test"));
	}
		
		
}

