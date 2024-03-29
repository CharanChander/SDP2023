package main;

import CUI.AppUC2;
import CUI.SplendorApp;
import domein.DomeinController;

public class StartUpCUI {

	public static void start() {
	
			DomeinController dc = new DomeinController();
			
			AppUC2 obj = new AppUC2(dc);
			SplendorApp obj2 = new SplendorApp(dc);
			obj.start();
			obj2.start();
			
	}
	
	public static void main(String[] args) {
		start();
	}


}
