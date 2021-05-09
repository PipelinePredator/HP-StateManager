package States;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import Button.MenuButton;
import FrameClasses.GameFrame;
import FrameClasses.State;

public class MenuState  extends State{

	private GameFrame gameFrame;
	protected BufferStrategy bufferedStrategy;
	Graphics g;
	
	public int mouseX;
	public int mouseY;
	public boolean leftIsPressed;
	
	private final long BackgroundAnimationSpeed = 20;//the higher the slower
	private long timer = 0;
	long lastTimeMillis = 0;
	protected ArrayList<MenuButton> allButtons = new ArrayList<MenuButton>();
	
	public MenuState(String name, GameFrame gameFrame) {
		super(name, gameFrame);

		this.gameFrame = gameFrame;
		this.bufferedStrategy = super.bufferedStrategy;
	}
	
	
	@Override
	public void update()
	{
		super.update();
		this.mouseX = super.getMouseX();
		this.mouseY = super.getMouseY();
		this.leftIsPressed = super.isLeftIsPressed();
		MouseOverAnyButton();
		timer += System.currentTimeMillis() - lastTimeMillis;
		
		lastTimeMillis = System.currentTimeMillis();
		
		if(timer>= BackgroundAnimationSpeed)
		{
			GameFrame.menuBackground.currentImage++;
			timer = 0;
			if(GameFrame.menuBackground.currentImage>= GameFrame.menuBackground.allImages.length)
			{
				GameFrame.menuBackground.currentImage = 0;
			}
		
		}
	}
	
	@Override
	public void render()
	{
		if(running)
		{
			super.render();
		
			this.g = super.g;
			
			//Draws the Background for all MenuStates 
			g.drawImage(GameFrame.menuBackground.allImages[GameFrame.menuBackground.currentImage], 0, 0, null);
			//draws the title for allStates
		}
		
		
		
		
		
		
	}
	public void MouseOverAnyButton()
	{
		for(MenuButton button : allButtons)
		{
			isMouseOverButton(button);
		}
	}
	public void isMouseOverButton(MenuButton button)
	{
		if(button.getXPosition()<=super.getMouseX()&& super.getMouseX()<=(button.getXPosition()+button.getWidth()) && button.getYPosition()<=super.getMouseY()&& super.getMouseY() <=(button.getYPosition()+button.getHeight()))
		{
			if(!button.isHighlited()) {
				
				button.setHighlited(true);
			}
		}else if(button.isHighlited())
		{
			button.setHighlited(false);
		}
	}
	
	public ArrayList<MenuButton> getAllButtons(){
		return allButtons;
	}
	
	
	

}
