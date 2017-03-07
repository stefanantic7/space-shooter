package spaceshooter.states;

import java.awt.Graphics;

public abstract class State {
	private static State currentState;
	public static  State getCurrentState(){
		return currentState;
	}
	public static void setCurrentState(State s){
		currentState = s;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
}
