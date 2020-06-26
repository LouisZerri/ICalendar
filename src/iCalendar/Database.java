package iCalendar;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
    private String user = "root";
    private String password = "";
	private java.sql.Connection dbConnect = null;
	private java.sql.Statement dbStatement = null;
	
	public Database(String user, String password) 
	{
        this.user = user;
        this.password = password;
	}
	
	public Boolean connect() {
 
        try {
			Class.forName("com.mysql.jdbc.Driver");
			this.dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/java",this.user,this.password);
			this.dbStatement = this.dbConnect.createStatement();
            return true;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return true;
   
    }
	
	public ResultSet exec(String sql) {
		
            ResultSet rs;
			try {
				rs = this.dbStatement.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return null;
    
	}
	
	public ResultSet execute(String sql) {

        ResultSet rs;
		try {
			rs = this.dbStatement.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            
        return null;
    }
	
	public void close() {

        try {
			this.dbStatement.close();
			this.dbConnect.close();
            this.dbConnect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
	
	public void insertLine(String id_event, String date_event, String objet, String lieu, String heure_deb, String heure_fin)
    {
    	if (this.connect()) {
    		
    		try {
				this.dbStatement.executeUpdate("INSERT INTO calendrier "
												+ "(id_event, date_event, objet, lieu, heure_deb, heure_fin) "
												+ "VALUES ('"+ id_event +"', '"+ date_event+"', '"+ objet +"', '"+ lieu +"','"+ heure_deb+"', '"+ heure_fin +"') "
												+ "ON DUPLICATE KEY UPDATE id_calendrier = id_calendrier+1;");				
				System.out.println("Ligne inserée avec succès");
    		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            
    	} else {
            System.out.println("Mysql connection failed !!!");
        }
    	
        this.close();
    }
	
	public void afficheLigne()
	{
		Database db = new Database("root", "");
		
		if (db.connect()) 
		{
			ResultSet rs = db.execute("SELECT * FROM calendrier");
	        if (rs != null) 
	        {
	        	try 
	        	{
	        		while (rs.next())
	        		{
	        			System.out.println("idCalendrier : " + rs.getString("id_calendrier")+"\n");
					    System.out.println("idEvent : " + rs.getString("id_event")+"\n");
					    System.out.println("DateEvent : " + rs.getString("date_event")+"\n");
					    System.out.println("Objet : " + rs.getString("objet")+"\n");
					    System.out.println("Lieu : " + rs.getString("lieu")+"\n");
					    System.out.println("Heure début : " + rs.getString("heure_deb")+"\n");
					    System.out.println("Heure fin : " + rs.getString("heure_fin")+"\n");
					}
				} 
	        	catch (SQLException e) 
	        	{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    
	    } 
		else 
		{
			System.out.println("Mysql connection failed !!!");
		}
	}
}
