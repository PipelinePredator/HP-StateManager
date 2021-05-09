package States;

import java.awt.BorderLayout;

import FrameClasses.GameFrame;
import FrameClasses.State;
import client.TowerWarsGrid;


public class LocalMultiPlayer extends State {
	LocalMultiPlayer localMultiPlayer;
	GameFrame gameFrame;
	TowerWarsGrid gameGrid1;
	TowerWarsGrid gameGrid2;

	
	public LocalMultiPlayer(GameFrame gameFrame) {
		super("GameState", gameFrame);
		this.gameFrame = gameFrame;
//		gameFrame.getContentPane().add(gameGrid);
//		gameGrid.startGame();

//		gameFrame.getContentPane().remove(gameGrid); 
		
		// to remove. getContentPane().remove(); oder removeAll();

	}
	public void initialize()
	{
		gameFrame.getContentPane().removeAll();
		gameGrid1 = new TowerWarsGrid(1,2,true);
		gameGrid2 = new TowerWarsGrid(1,2,false);
		gameFrame.repaint();
		System.out.println("ContenPane added");

	}
	
	public void finalize()
	{
//		gameFrame.getContentPane().remove(gameGrid);
//		gameGrid.doPause();
//		gameGrid = null;
	}
	@Override
	public void render()
	{
	}
	@Override
	public void update()
	{
	}
	@Override 
	public void run()
	{
		
	}
	
	@Override
	public void start()
	{
		System.out.println("GameState started");
		initialize();

		
	}
	
	
}