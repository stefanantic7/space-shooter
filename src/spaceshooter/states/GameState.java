package spaceshooter.states;

import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State{

	@Override
	public void tick() {
	
	}
	

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 100, 500);
	}

}
