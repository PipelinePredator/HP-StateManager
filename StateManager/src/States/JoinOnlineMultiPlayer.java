package States;

import FrameClasses.GameFrame;
import FrameClasses.State;
import client.OnlineMultiPlayer;

public class JoinOnlineMultiPlayer extends State {

	OnlineMultiPlayer gameGrid;
	private GameFrame gameFrame;

	public JoinOnlineMultiPlayer( GameFrame gameFrame) {
		super("JoinOnlineMultiPlayer", gameFrame);
		this.gameFrame = gameFrame;
		gameGrid = new OnlineMultiPlayer(1);
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
