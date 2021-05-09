package FrameClasses;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

import States.MenuBackground;

public class GameFrame extends JFrame{
	
	
	public static final int WIDTH = 800, HEIGHT = 700;
	private Canvas canvas;
	private Dimension size = new Dimension(WIDTH, HEIGHT);
	//managers
	public StateManager stateManager;
	
	public static MenuBackground menuBackground;
	public Container container1;
	private MouseManager mouseManager;
	
	public GameFrame()
	{
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		canvas = new Canvas();
		
		canvas.setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		add(canvas);
		canvas.createBufferStrategy(3);
		container1 = getContentPane();
		container1.add(canvas);
		pack();

		
		initialise();
	}

	private void initialise() {
		menuBackground = new MenuBackground();
		this.mouseManager = new MouseManager();
		this.addMouseListener(mouseManager);
		this.addMouseMotionListener(mouseManager);
		canvas.addMouseListener(mouseManager);
		canvas.addMouseMotionListener(mouseManager);
		stateManager = new StateManager(this);
		stateManager.setCurrentState("MainMenu");
		stateManager.startCurrentState();
		
	}

	
	@Override
	public void paint(Graphics g)
	{
		
	}
	public Canvas getCanvas()
	{
		return canvas;
	}
	public MouseManager getMouseManager()
	{
		return mouseManager;
	}

	
	public static void main(String[] args) {
		new GameFrame();
	}

	
}