package domein;
import java.util.ResourceBundle;


public class Taal
{
	public static ResourceBundle NL = ResourceBundle.getBundle("resourceBundles.ResourceBundle");
	public static ResourceBundle EN = ResourceBundle.getBundle("resourceBundles.ResourceBundle_EN");
	private static int taal;
	
	
	public Taal()
	{
		
	}
	
	
	public static int getTaal()
	{
		return taal;
	}
	
	public ResourceBundle getBundleTaal()
	{
	
		if (taal==1)
		{
			return NL;
		}
		
		else if (taal == 2)
		{
			return EN;
		}
		return NL;
	}
	
	public void setTaal(int taal)
	{
		if(taal == 1 || taal == 2)
			Taal.taal = taal;
	}
	
	
	
	
}
