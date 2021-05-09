package FrameClasses;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class State  implements Runnable {

	private boolean running = false;
	public BufferStrategy bufferedStrategy;
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
		bufferedStrategy = gameFrame.getCanvas().getBufferStrategy();

	}
	
	public synchronized void start()
	{
		
		if(running) {
			System.out.println("thread already running");
			return;
		}
		System.out.println("started " + stateName);
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
		System.out.println("not runnig animore");
	}

	public boolean isRunning() {
		return running;
	}

	public GameFrame getGameFrame() {
		return gameFrame;
	}
	public void render()
	{
		g = bufferedStrategy.getDrawGraphics();
		
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
		System.out.println("Stopped");	
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