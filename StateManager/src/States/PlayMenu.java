package States;

import java.awt.Color;
import java.awt.Font;

import Button.MenuButton;
import Button.PlayButton;
import FrameClasses.GameFrame;
import FrameClasses.MouseManager;
import FrameClasses.State;

public class PlayMenu extends MenuState {

	private GameFrame gameFrame;
	private Font headFont= new Font("TimesRoman", Font.PLAIN, 40);
	private final int headXPos = 210, headYPos = 180;
	
	private PlayButton localMulitPlayer;
	private PlayButton createOnlineMultiPlayer;
	private PlayButton joinOnlineMultiPlayer;
	private PlayButton backButton;
			
	public PlayMenu( GameFrame gameFrame) {
		super("PlayMenu", gameFrame);
		this.gameFrame = gameFrame;
		localMulitPlayer = new PlayButton("Local-Mulitplayer", 250, 30, 270, 300, gameFrame.getMouseManager());
		super.allButtons.add(localMulitPlayer);
		createOnlineMultiPlayer = new PlayButton("create Online-Mulitplayer", 300, 30, 242, 390, gameFrame.getMouseManager());
		super.allButtons.add(createOnlineMultiPlayer);
		joinOnlineMultiPlayer = new PlayButton("join Online-Mulitplayer", 300, 30, 242, 480, gameFrame.getMouseManager());
		super.allButtons.add(joinOnlineMultiPlayer);
		backButton = new PlayButton("Back", 60, 40, 1, 1, gameFrame.getMouseManager());
		super.allButtons.add(backButton);
	}
	
	@Override
	public void render()
	{
		if(running)
		{
			super.render();
			g.setFont(headFont);
			g.setColor(Color.white);
			g.drawString("Choose a playing option",headXPos, headYPos);
			
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
		}
		
		
	}
	@Override
	public void update() {
		
		if(running)
		{
			super.update();
			if(localMulitPlayer.isButtonPressed())
			{
				gameFrame.stateManager.stopCurrentState();
				gameFrame.stateManager.setCurrentState("LocalMultiPlayer");
				gameFrame.stateManager.startCurrentState();
			}
			else if(createOnlineMultiPlayer.isButtonPressed())
			{
				gameFrame.stateManager.stopCurrentState();
				gameFrame.stateManager.setCurrentState("CreateOnlineMultiPlayer");
				gameFrame.stateManager.startCurrentState();
			}
			else if(joinOnlineMultiPlayer.isButtonPressed())
			{
				gameFrame.stateManager.stopCurrentState();
				gameFrame.stateManager.setCurrentState("JoinOnlineMultiPlayer");
				gameFrame.stateManager.startCurrentState();
			}
			else if(backButton.isButtonPressed())
			{
				gameFrame.stateManager.stopCurrentState();
				gameFrame.stateManager.setCurrentState("MainMenu");
				gameFrame.stateManager.startCurrentState();
				
			}
		
		}
	}

}
