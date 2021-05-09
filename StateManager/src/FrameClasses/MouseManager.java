package FrameClasses;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MouseManager implements MouseListener, MouseMotionListener {

	//the Timer aswel as the Timer task is used so the LeftKlick is disabled after 5milliseconds to ensure no doubleklicks
	private Timer timer = new Timer();
	public class LeftPressedToFalse extends TimerTask{

		@Override
		public void run() {
			leftPressed = false;
			
		}
		
	}
	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	
	public MouseManager(){
		
	}
	
	// Getters
	
	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	// Implemented methods
	
	@Override
	public void mousePressed(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		if(e.getButton() == MouseEvent.BUTTON1)
//			leftPressed = false;
//		else if(e.getButton() == MouseEvent.BUTTON3)
//			rightPressed = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		timer.schedule(new LeftPressedToFalse(), 5);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
