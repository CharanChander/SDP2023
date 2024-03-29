package persistentie;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domein.Speler;

public class Mapper 
{

	private static final String INSERT_SPELER = " INSERT INTO ID400089_g71.Speler (naam, geboortejaar)" + "VALUES (?; ?)";
	
	public void voegSpelerToe(Speler speler)
	{
	try (
		Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
		PreparedStatement query = conn.prepareStatement(INSERT_SPELER)) {
		query.setString(1, speler.getNaam());
		query.setInt(2, speler.getGeboortejaar());
		query.executeUpdate();
		
	}
	
	catch (SQLException ex)
	{
		throw new RuntimeException(ex);
	}
 }

	public List<Speler> geefSpelers()
	{
		List<Speler> spelers = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
				PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400089_g71.Speler");
				ResultSet rs = query.executeQuery()) {
				
				while (rs.next())
				{
					String naam = rs.getString("naam");
					int geboortejaar = rs.getInt("geboortejaar");
					spelers.add(new Speler(naam, geboortejaar));
				}
	} 
	
	catch (SQLException ex)
	{
		throw new RuntimeException(ex);
	}
	
	return spelers;
}
	
	public Speler geefSpeler(String naam, int geboortejaar)
	{
		Speler speler = null;
		
		 try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
	                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID400089_g71.Speler WHERE naam = ? AND geboortejaar = ?")) {
	            query.setString(1, naam);
	            query.setInt(2, geboortejaar);
	            try (ResultSet rs = query.executeQuery()) {
	                if (rs.next()) {
	                    String naamString = rs.getString("naam");
	                    int geboortejaarInt = rs.getInt("geboortejaar");

	                    speler = new Speler(naamString, geboortejaarInt);
	                }
	            }
	        } catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }

	        return speler;
	    }
}