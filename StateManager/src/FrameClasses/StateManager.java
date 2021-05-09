package FrameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import States.LocalMultiPlayerState;
import States.MainMenu;
import States.PlayMenu;
import client.TowerWarsGrid;

public class StateManager {
	
	//ein Object für previous state erstellen und das überprüfen.
	
	private ArrayList<State> allStates;
	private State currentState;
	private GameFrame gameFrame;
	private State latestState;
	
	private State localMultiPlayer;
	private State hostingMultiplayer;
	private State joiningMultiPlayer;
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
		localMultiPlayer = new LocalMultiPlayerState(gameFrame);
		mainMenu = new MainMenu(gameFrame);
		playMenu = new PlayMenu(gameFrame);
		allStates.add(localMultiPlayer);
		allStates.add(mainMenu);
		allStates.add(playMenu);
		
	}
	
	public void setCurrentState(String stateName) 
	{ 
		for(State state : allStates)
		{
			if(state.getStateName() == stateName)
			{
				currentState = state;
				return;
			}
		}
		startCurrentState();
	}
	
	public void startCurrentState() 
	{
//		gameFrame.add( currentState.getGameFrame().getCanvas());
		currentState.start();
		
	}
	
	public void stopCurrentState() 
	{
//		gameFrame.getContentPane.remove(currentState);
		currentState.stop();
	}
	
	
	
	
}