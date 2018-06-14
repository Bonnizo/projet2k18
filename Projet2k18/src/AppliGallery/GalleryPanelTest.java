package AppliGallery;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class GalleryPanelTest {
	
	GalleryPanel gallery = new GalleryPanel(null, null);

	@Test
	void getFileExtension() {
		File picture = new File("/Photo/antler-antler-carrier-fallow-deer-hirsch.jpg");
		assertTrue(gallery.getFileExtension(picture).equals("jpg"));
		
		picture = new File("/Photo/cat-pet-animal-domestic-104827.jpeg");
		assertTrue(gallery.getFileExtension(picture).equals("jpeg"));
		
		picture = new File("/Photo/cat-pet-animal-domestic-104827");
		assertTrue(gallery.getFileExtension(picture).equals(""));
	}

}
