package annette.godtland.fallingbricks;

import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class FileIO {
	
	public static Clip playClip(Object requestor, String fileName) {
		Clip clip = null;
		try{
			URL url = requestor.getClass().getResource(fileName);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		}
		catch (IOException e) {
			String message = "File " + fileName + " could not be opened. ";
			JOptionPane.showMessageDialog(null, message);
		}
		catch ( UnsupportedAudioFileException e) {
			String message = "File " + fileName + " is not a valid audio file type.";
			JOptionPane.showMessageDialog(null, message);+
		}
		catch (LineUnavailableException e){
			String message = "Resources not available to open file " + fileName + " at this time.";
			JOptionPane.showMessageDialog(null, message);
		}
		return clip;
	}
	
	public static BufferedImage readImageFile(Object requestor, String fileName) {
		BufferedImage image = null;
		try {
			InputStream input = requestor.getClass().getResourceAsStream(fileName);
			image = ImageIO.read(input);
		}
		catch (IOException e){
			String message = "The image file " + fileName + " could not be opened.";
			JOptionPane.showMessageDialog(null, message);
		}
		return image;	
	}	
	
}
