package annette.godtland.fallingbricks;

import javax.sound.sampled.Clip;

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
