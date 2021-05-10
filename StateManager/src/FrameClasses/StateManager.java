package FrameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;

import States.*;
import client.TowerWarsGrid;

public class StateManager {
	
	//ein Object für previous state erstellen und das überprüfen.
	
	private ArrayList<State> allStates;
	private State currentState;
	private GameFrame gameFrame;
	private State latestState;
	
	private State localMultiPlayer;
	private State joinOnlineMultiPlayer;
	private State createOnlineMultiPlayer;
	private State mainMenu;
	private State playMenu;
	private State victoryScreen;
	private State loosingScreen;
	
	
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
		joinOnlineMultiPlayer = new JoinOnlineMultiPlayer(gameFrame);
		createOnlineMultiPlayer = new CreateOnlineMultiPlayer(gameFrame);
		victoryScreen = new VictoryScreen(gameFrame);
		loosingScreen = new LoosingScreen(gameFrame);
		
		
		allStates.add(localMultiPlayer);
		allStates.add(mainMenu);
		allStates.add(playMenu);
		allStates.add(createOnlineMultiPlayer);
		allStates.add(joinOnlineMultiPlayer);
		allStates.add(loosingScreen);
		allStates.add(victoryScreen);
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
//		startCurrentState();
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