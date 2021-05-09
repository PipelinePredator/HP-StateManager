package FrameClasses;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class State  implements Runnable {

	private boolean running = false;
	public static BufferStrategy bufferedStrategy;
	private GameFrame gameFrame;
	public Graphics g;
	private  String stateName;
	private Thread thread;
	private int mouseX;
	private int mouseY;
	private boolean leftIsPressed;
	
	public State(String name, GameFrame gameFrame)
	{
		this.stateName = name;
		this.gameFrame = gameFrame;
		State.bufferedStrategy = gameFrame.getCanvas().getBufferStrategy();

	}
	
	public void start()
	{
		
		if(running) {
			System.out.println("thread already running");
			return;
		}
		System.out.println("startted" + stateName);
		running =true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		running = false;
	}

	public boolean isRunning() {
		return running;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}
	public void render()
	{
		g = this.bufferedStrategy.getDrawGraphics();
		
		g.clearRect(0, 0, GameFrame.WIDTH, GameFrame.HEIGHT);
	}

	public  void update()
	{
		mouseX = gameFrame.getMouseManager().getMouseX();
		mouseY = gameFrame.getMouseManager().getMouseY();
		leftIsPressed = gameFrame.getMouseManager().isLeftPressed();
	}

	
	
	
	@Override
	public void run() {
		while(running)
		{
			update();
			render();
		}
		stop();
		
	}

	
	public String getStateName() {
		return stateName;
	}

	public int getMouseX() {
		return mouseX;
	}

	public boolean isLeftIsPressed() {
		return leftIsPressed;
	}

	public int getMouseY() {
		return mouseY;
	}

}