package Jeu;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import Jeu.Regle;

class RegleTest {
	
	Regle regle = new Regle();

	@Test
	void LireRegletest() {
		
	File fichierTxt = new File("/TextRegle/Regle.JPG");
	assertFalse(regle.LireRegle(fichierTxt).equals("txt"));
	
	fichierTxt = new File("/TextRegle/Regle.JPEG");
	assertFalse(regle.LireRegle(fichierTxt).equals("txt"));
	
	fichierTxt = new File("/TextRegle/Regle");
	assertFalse(regle.LireRegle(fichierTxt).equals("txt"));
	
	}

}
