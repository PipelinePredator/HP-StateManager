package States;

import java.util.concurrent.TimeUnit;

import FrameClasses.GameFrame;
import FrameClasses.State;
import ch.aplu.jgamegrid.GameGrid;
import client.OnlineMultiPlayer;

public class JoinOnlineMultiPlayer extends State {

	OnlineMultiPlayer gameGrid;
	private GameFrame gameFrame;

	public JoinOnlineMultiPlayer( GameFrame gameFrame) {
		super("JoinOnlineMultiPlayer", gameFrame);
		this.gameFrame = gameFrame;
	}
	
	public void initialise()
	{
		gameFrame.getContentPane().removeAll();
		gameGrid = new OnlineMultiPlayer(2);
		gameGrid.setPartnerName("Player");
		gameGrid.getCommunicationComponent().setPartner("Player");
		gameFrame.getContentPane().add(gameGrid);
		gameGrid.show();
		gameFrame.repaint();
	}
	public void finalize(int vicotry)
	{
		stop();
		System.out.println("finalize");
		gameGrid.doPause();
		gameGrid.hide();
		gameGrid.dispose();
		GameGrid.disposeAll();
		gameGrid = null;
		gameFrame.getContentPane().removeAll();
		gameFrame.initialiseANewCanvas();
		
		try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch(vicotry) {
		case 1:
			gameFrame.stateManager.setCurrentState("VicotryScreen");
			gameFrame.stateManager.startCurrentState();
			break;
		case 2: 
			gameFrame.stateManager.setCurrentState("LoosingScreen");
			gameFrame.stateManager.startCurrentState();
			default:
				System.err.println("can't decide if won or lost");
			
		}
		gameFrame.repaint();
	}
	@Override
	public void render()
	{
		//should do nothing or else this will result in errors
	}
	@Override
	public void update()
	{
		if(running )
		{
			switch(gameGrid.checkGameEnd()) 
			{
			case 0:
				return;
			case 1:
				finalize(1);
				break;
			case 2: 
				finalize(2);
				break;
			
			}
		}
		
	
		
	}
	@Override
	public void start()
	{
		
		initialise();
		super.start();
	}
	@Override
	public void stop()
	{
		super.stop();
	}
}
