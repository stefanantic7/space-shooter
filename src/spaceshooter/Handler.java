package spaceshooter;

import java.awt.Dimension;
import java.util.ArrayList;

import spaceshooter.entities.creatures.EnemyShip;

public class Handler {
	private Game game;
	private Display display;
	public Handler(Game game, Display display) {
		this.game = game;
		this.display = display;
	}
	public Game getGame(){
		return game;
	}
	public Display getDisplay(){
		return display;
	}
	public Dimension getFrameDimension(){
		return display.getDimension();
	}
	public ArrayList<EnemyShip> getEnemies(){
		return game.getGameState().getEnemies();
	}
	
}
