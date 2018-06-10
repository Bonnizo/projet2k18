package projet2k18;
import java.io.*;
import java.util.*;
import java.util.logging.*;

/**
 Uses buffering, and abstract base classes. 
 JDK 7+. 
*/
public class ExerciseSerializableNew {

  public static void main(String[] args) {
    //create a Serializable List
	  
	  
	  ArrayList PersonneListe = new ArrayList();
	
	  
	  
	  
	  PersonneInfo arthur = new PersonneInfo("prenom", "prenom", "prenom", "prenom", "prenom");

	  

	  PersonneInfo arthur2 = new PersonneInfo("prenom2","prenom2","prenom2","prenom2","prenom2");
	 

	  PersonneListe.add(arthur);
	  PersonneListe.add(arthur2);
	 
	  
	  
	  try {
		  File text = new File ("SerialisationContact/contact.zer");
		  ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("SerialisationContact/contact.zer"));
		  
		  for(int i=0; i<PersonneListe.size(); i++){
			 os.writeObject(PersonneListe.get(i));
			 
			 }
		  
		  os.close();
	  }
	  catch (FileNotFoundException e) {
		  
		  e.printStackTrace();
	  }catch (IOException e) {
	  e.printStackTrace();
	  
	  }
	  System.out.println("Done writing");
	  try {
		  ObjectInputStream is = new ObjectInputStream(new FileInputStream("SerialisationContact/contact.zer"));
		 
		  for(int i=0; i<PersonneListe.size(); i++){
			  PersonneInfo p = (PersonneInfo) is.readObject();
			  System.out.println("Read name"+ p.prenom + " "+p.nom+" "+p.adresse+" "+p.telephone+" "+p.email);
		  }
		  
		  is.close();
	  }
	  catch (FileNotFoundException e) {
		  
		  e.printStackTrace();
	  }catch (IOException e) {
	  e.printStackTrace();
	  
	  }catch (ClassNotFoundException e) {
		  e.printStackTrace();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
  }
} 