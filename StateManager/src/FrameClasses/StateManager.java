package FrameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import States.GameState;
import States.MainMenu;
import States.PlayMenu;
import client.TowerWarsGrid;

public class StateManager {
	
	//ein Object für previous state erstellen und das überprüfen.
	
	private ArrayList<State> allStates;
	private State currentState;
	private GameFrame gameFrame;
	private State latestState;
	
	private State gameState;
	private State mainMenu;
	private State playMenu;
	
	
	public StateManager(GameFrame jFrame)
	{
		this.gameFrame = jFrame;
		allStates = new ArrayList<State>();
		initialiseAllStates();
	}
	
	private void initialiseAllStates()
	{
		gameState = new GameState(gameFrame,new TowerWarsGrid(1,2,false));
		mainMenu = new MainMenu(gameFrame);
		playMenu = new PlayMenu(gameFrame);
		allStates.add(gameState);
		allStates.add(mainMenu);
		allStates.add(playMenu);
		
	}
	
	public void setCurrentState(String stateName) 
	{ 
		System.out.println("iafhadfsas");
//		if(latestState != null && latestState.getStateName() == "GameState")
//		{
//			System.out.println("hallo");
//			((GameState)latestState).finalize();
//		}
//		
		for(State state : allStates)
		{
			if(state.getStateName() == stateName)
			{
				currentState = state;
			}
		}
	}
	
	public void startCurrentState() 
	{
//		gameFrame.add( allStates.get(currentState).getGameFrame().getCanvas());
		currentState.start();
		
	}
	
	public void stopCurrentState() 
	{
//		gameFrame.remove(allStates.get(currentState));
		currentState.stop();
	}
	
	
	
	
}