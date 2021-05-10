package States;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Button.EndScreenButton;
import Button.MenuButton;
import FrameClasses.GameFrame;

public class LoosingScreen extends MenuState {



	
	private GameFrame gameFrame;
	private EndScreenButton goToPlayMenuButton;
	private EndScreenButton exitButton;
	private BufferedImage defeatImage;
	
	public LoosingScreen( GameFrame gameFrame) {
		super("LoosingScreen", gameFrame);
		this.gameFrame = gameFrame;
		goToPlayMenuButton = new EndScreenButton("Play", 85, 50, 355, 390, gameFrame.getMouseManager());
		super.allButtons.add(goToPlayMenuButton);
		exitButton = new EndScreenButton("Exit", 85, 50, 355, 480, gameFrame.getMouseManager());
		super.allButtons.add(exitButton);
		try {
			defeatImage = ImageIO.read(new File("res\\gameEnd\\defeat.png"));
		} catch (IOException e) {
			System.err.println("Failed to load victory Image");
		}
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render()
	{
		if(running)
		{
			super.render();
			g = super.g;
			//draw Title
			g.drawImage(defeatImage,150 , 30, null);
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
		
		
	
	}
	@Override
	public void update()
	{
		if(running)
		{
			super.update();
			if(goToPlayMenuButton.isButtonPressed())
			{
				gameFrame.stateManager.stopCurrentState();
				gameFrame.stateManager.setCurrentState("PlayMenu");
				gameFrame.stateManager.startCurrentState();
				
			}
			if(exitButton.isButtonPressed())
			{
					System.exit(0);
			}	
				
		}
		

		
		
	}
}
