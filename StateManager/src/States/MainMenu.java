package States;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Button.MainMenuButton;
import Button.MenuButton;
import FrameClasses.GameFrame;
import FrameClasses.State;
import FrameClasses.StateManager;
import client.Button;

public class MainMenu extends MenuState {
	

	
	MainMenuButton playButton;
	MainMenuButton shopButton;
	MainMenuButton exitButton;
	
	private Font titleFont = new Font("Arial", Font.BOLD, 70);
	private final int titleXPos = 200, titleYPos = 200;
	
	
	private GameFrame gameFrame;
	private Graphics g;

	

	
	
	
	public MainMenu(GameFrame gameFrame) {
		super("MenuState", gameFrame);
		this.gameFrame = gameFrame;
		this.bufferedStrategy = super.bufferedStrategy;

		playButton = new MainMenuButton("Play", 60, 40, 370, 300);
		super.allButtons.add(playButton);
		shopButton = new MainMenuButton("Shop", 70, 40, 365, 370);
		super.allButtons.add(shopButton);
		exitButton = new MainMenuButton("Exit", 60, 40 ,370, 440);
		super.allButtons.add(exitButton);
	}

	



	@Override
	public void render()
	{
		super.render();
		g = super.g;
		//draw Title
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("TowerWars", titleXPos, titleYPos);
		//Draw all Buttons to their according states
		for(MenuButton button: super.allButtons)
		{
			if(button.isHighlited())
			{
				g.drawImage(button.buttons[1], button.getXPosition(), button.getYPosition(),null);
			}else 
			{
				g.drawImage(button.buttons[0], button.getXPosition(), button.getYPosition(),null);
			}
		}
		
		g.dispose();
		bufferedStrategy.show();
		// end the drawing
		
	
	}
	@Override
	public void update()
	{
		super.update();
		

		if(playButton.isHighlited() && super.leftIsPressed)
		{
			gameFrame.stateManager.stopCurrentState();
			gameFrame.stateManager.setCurrentState("PlayMenu");
			gameFrame.stateManager.startCurrentState();
		}
		if(exitButton.isHighlited() &&super.leftIsPressed)
		{
			System.exit(0);
		}

		
	}
	@Override
	public void start()
	{
		super.start();
	}
	
	
	
}