package Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import FrameClasses.GameFrame;
import FrameClasses.MouseManager;

public class MenuButton {
	private String ButtonName;
	private Font buttonFont;
	public BufferedImage[] buttons = new BufferedImage[2];
	private int xPosition, yPosition;
	private int width;
	private int height;
	private MouseManager mouseManager;
	private boolean highlited = false;
	
	
	public MenuButton(String buttonName, int width, int height, int xPosition, int yPosition, Font buttonFont, MouseManager mouseManager) {
		this.buttonFont = buttonFont;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.ButtonName = buttonName;
		this.width = width;
		this.height = height;
		this.mouseManager = mouseManager;
		makeMenuButton(buttonName);
	}

	private void makeMenuButton(String buttonName) {
		buttons[0] = makeMenuButton(Color.WHITE, buttonName);
		buttons[1] = makeMenuButton(Color.yellow, buttonName);
		
	}
	
	private BufferedImage makeMenuButton(Color color, String buttonName)
	{
		BufferedImage menuButton = new BufferedImage(width,height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = menuButton.getGraphics();
		g.setColor(color);
		g.drawRect(0, 0, menuButton.getWidth()-1, menuButton.getHeight()-1);
	   
		// Get the FontMetrics
		FontMetrics metrics = g.getFontMetrics(buttonFont);
	    // Determine the X coordinate for the text
	    int x = (menuButton.getWidth() - metrics.stringWidth(buttonName)) / 2;
	    // Determine the Y coordinate for the text 
	    int y = ((menuButton.getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
	    // Set the font
	    g.setFont(buttonFont);
	    // Draw the String
	    g.drawString(buttonName, x, y);
	    
	    g.dispose();
	    return menuButton;
	
	}
	
	public boolean isButtonPressed() {
		if(xPosition<=mouseManager.getMouseX()&& mouseManager.getMouseX()<=(xPosition+width) && yPosition<=mouseManager.getMouseY()&& mouseManager.getMouseY() <=(yPosition+height)&&mouseManager.isLeftPressed())
		{
			return true;
		}else {
			return false;
		}
	}

	public int getYPosition() {
		return yPosition;
	}

	public int getXPosition() {
		return xPosition;
	}
	public int getWidth()
	{
		return width;
		
	}
	public int getHeight()
	{
		return height;
	}

	public boolean isHighlited() {
		return highlited;
	}

	public void setHighlited(boolean highlited) {
		this.highlited = highlited;
	}
	
	
	
	
}
