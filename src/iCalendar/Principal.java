package iCalendar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class Principal {

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		// TODO Auto-generated method stub
		Gson json = new Gson();
		Database bdd = new Database("root", "");
		Evenement[] event = json.fromJson(new FileReader("C:\\Users\\lzerr\\eclipse-workspace\\iCalendar\\bin\\iCalendar\\fichier.json"), Evenement[].class);
		bdd.connect();
		for(int i = 0; i < event.length; i++)
		{
			//bdd.insertLine(event[i].getID(), event[i].getDateEvent(), event[i].getObjet(), event[i].getLieu(), event[i].getStr_Hdeb(), event[i].getStr_Hfin());
		}
		
		GenerateIcs ics = new GenerateIcs();
		ics.generateFile();
		
	}

}
