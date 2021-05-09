package States;

import FrameClasses.GameFrame;
import FrameClasses.State;
import client.OnlineMultiPlayer;

public class CreateOnlineMultiPlayer extends State{
	OnlineMultiPlayer gameGrid;
	private GameFrame gameFrame;

	public CreateOnlineMultiPlayer( GameFrame gameFrame) {
		super("CreateOnlineMultiPlayer", gameFrame);
		this.gameFrame = gameFrame;
		
	}
	
	public void initialise()
	{
		gameFrame.getContentPane().removeAll();
		gameGrid = new OnlineMultiPlayer(1);
	}
	@Override
	public void start()
	{
		initialise();
	}

	@Override 
	public void stop()
	{
		
	}
}
