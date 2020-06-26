package iCalendar;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GenerateIcs {
	
	private String nomfichier = "";
	
	public GenerateIcs()
	{
		this.nomfichier = "calendrier.ics";
	}
	
	public String splitEvent(String dateEvent, String heure)
	{
		String res = "";
		String value = "";
		String new_heure = "";
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time timeValue = null;
		try {
			timeValue = new java.sql.Time(formatter.parse(heure).getTime());
			value = timeValue.toString();
			new_heure = value.replace(":", "");
			res = dateEvent.replace("-", "").substring(0, 9) + new_heure;
			return res;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void generateFile()
	{
		Database bdd = new Database("root", "");
		PrintWriter writer;
		try {
			writer = new PrintWriter(this.nomfichier, "UTF-8");
			writer.println("BEGIN:VCALENDAR");
			writer.println("VERSION:2.0");
			writer.println("PRODID:-//hacksw/handcal//NONSGML v1.0//EN");
			if (bdd.connect()) 
			{
				ResultSet rs = bdd.execute("SELECT date_event, objet, lieu, heure_deb, heure_fin FROM calendrier");
		        if (rs != null) 
		        {
		        	try 
		        	{
		        		while (rs.next())
		        		{
		        			writer.println("BEGIN:VEVENT");
		        			writer.println("SUMMARY:"+rs.getString("objet"));
		        			writer.println("DTSTART;TZID=Europe/Paris:"+splitEvent(rs.getString("date_event"),rs.getString("heure_deb")));
		        			writer.println("DTEND;TZID=Europe/Paris:"+splitEvent(rs.getString("date_event"),rs.getString("heure_fin")));
		        			writer.println("LOCATION:"+rs.getString("lieu"));
		        			writer.println("END:VEVENT");
						}
					} 
		        	catch (SQLException e) 
		        	{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		    
		    }
			writer.println("END:VCALENDAR");
			writer.close();
			System.out.println("Fichier ics créé avec succès");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}