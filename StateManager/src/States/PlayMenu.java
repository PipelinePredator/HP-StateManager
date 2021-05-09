package States;

import java.awt.Color;
import java.awt.Font;

import Button.MenuButton;
import Button.PlayButton;
import FrameClasses.GameFrame;
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
		localMulitPlayer = new PlayButton("Local-Mulitplayer", 250, 30, 270, 300);
		super.allButtons.add(localMulitPlayer);
		createOnlineMultiPlayer = new PlayButton("create Online-Mulitplayer", 300, 30, 242, 390);
		super.allButtons.add(createOnlineMultiPlayer);
		joinOnlineMultiPlayer = new PlayButton("join Online-Mulitplayer", 300, 30, 242, 480);
		super.allButtons.add(joinOnlineMultiPlayer);
		backButton = new PlayButton("Back", 60, 40, 1, 1);
		super.allButtons.add(backButton);
	}
	
	@Override
	public void render()
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
	@Override
	public void update() {
		
		super.update();
		if(localMulitPlayer.isHighlited() && super.leftIsPressed)
		{
			gameFrame.stateManager.stopCurrentState();
			gameFrame.stateManager.setCurrentState("GameState");
			gameFrame.stateManager.startCurrentState();
		}
		else if(createOnlineMultiPlayer.isHighlited() &&super.leftIsPressed)
		{
		}
		else if(backButton.isHighlited() && super.leftIsPressed)
		{
			gameFrame.stateManager.stopCurrentState();
			System.out.println("stopped");
			gameFrame.stateManager.setCurrentState("MainMenu");
			System.out.println("set");
			gameFrame.stateManager.startCurrentState();
			System.out.println("started");
		}
	}
}
