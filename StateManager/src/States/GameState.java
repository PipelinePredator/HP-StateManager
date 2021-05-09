package States;

import java.awt.BorderLayout;

import FrameClasses.GameFrame;
import FrameClasses.State;
import client.TowerWarsGrid;


public class GameState extends State {
	TowerWarsGrid gameGrid;
	GameFrame gameFrame;

	
	public GameState( GameFrame gameFrame, TowerWarsGrid gameGrid) {
		super("GameState", gameFrame);
		this.gameGrid = gameGrid;
		this.gameFrame = gameFrame;
//		gameFrame.getContentPane().add(gameGrid);
//		gameGrid.startGame();

//		gameFrame.getContentPane().remove(gameGrid); 
		
		// to remove. getContentPane().remove(); oder removeAll();

	}
	public void initialize()
	{
		
		gameFrame.container1.add(gameGrid);
		gameGrid.show();
		System.out.println("ContenPane added");
		gameGrid.doRun();
	}
	
	public void finalize()
	{
		gameFrame.getContentPane().remove(gameGrid);
		gameGrid.doPause();
		gameGrid = null;
	}
	@Override
	public void render()
	{
	}
	@Override
	public void update()
	{
	}
//	@Override 
//	public void run()
//	{
//		
//	}
	
	@Override
	public void start()
	{
		System.out.println("GameState started");
		initialize();

		
	}
	
	
}