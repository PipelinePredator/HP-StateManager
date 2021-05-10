package States;

import java.awt.BorderLayout;

import Button.MenuButton;
import FrameClasses.GameFrame;
import FrameClasses.State;
import client.TowerWarsGrid;
import client.LocalMultiPlayer;


public class LocalMultiPlayerState extends State {
	LocalMultiPlayerState localMultiPlayer;
	GameFrame gameFrame;
	LocalMultiPlayer gameGrid1;
	LocalMultiPlayer gameGrid2;

	
	public LocalMultiPlayerState(GameFrame gameFrame) {
		super("LocalMultiPlayer", gameFrame);
		this.gameFrame = gameFrame;

	}
	public void initialize()
	{
		gameFrame.getContentPane().removeAll();
		
		gameGrid1 = new LocalMultiPlayer(1);
		gameGrid2 = new LocalMultiPlayer(2);
		gameFrame.setSize(LocalMultiPlayer.WIDTH*2, LocalMultiPlayer.HEIGHT);
		gameFrame.getContentPane().add(gameGrid1);
		gameFrame.getContentPane().add(gameGrid2);
		gameGrid1.show();
		gameFrame.repaint();
		System.out.println("ContenPane added");

	}
	
	public void finalize()
	{
		gameFrame.getContentPane().removeAll();
		gameGrid1 = null;
		gameGrid2 = null;
		gameFrame.getContentPane().add(gameFrame.getCanvas());//see if not needed
	}
	@Override
	public void render()
	{
		//should do nothing or else this will result in errors
	}
	@Override
	public void update()
	{
		
	}
	@Override
	public void start()
	{
		System.out.println("GameState started");
		initialize();

		
	}
	@Override 
	public void stop()
	{
		
	}
	
	
	
}