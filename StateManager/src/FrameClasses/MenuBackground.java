package FrameClasses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MenuBackground {

	public static  BufferedImage[] allImages = new BufferedImage[899];
	public int currentImage = 0;

	public int getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(int currentImage) {
		this.currentImage = currentImage;
	}

	public MenuBackground() 
	{
		
			for(int i = 0;i < allImages.length ; i++ )
			{
			String s  = "res\\background\\Frame-"+(i+1)+".jpg";
			System.out.println(s);
				try {
					allImages[i] = ImageIO.read(new File(s));
				} catch (IOException e) {
					System.err.println("Failed to load Background Image");
				}
			
			}
		
	}

}