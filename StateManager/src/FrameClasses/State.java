package FrameClasses;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

public abstract class State  implements Runnable {

	protected boolean running = false;
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
		
		running =true;
		thread = new Thread(this);
		thread.start();
		System.out.println("started " + stateName);
	}
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		try {
			thread.join(100);//makes the thread die but not imediately
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running = false;
		System.out.println("stopped" +stateName);
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
		System.out.println("runningof " + stateName+"  done");	
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