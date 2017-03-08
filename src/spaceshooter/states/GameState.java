package spaceshooter.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Rect;

import spaceshooter.Handler;
import spaceshooter.gfx.Assets;

public class GameState extends State{
	private Handler handler;
	
	private BufferedImage background;
	private BufferedImage playerImage;
	public GameState(Handler handler) {
		background = Assets.background;
		playerImage = Assets.playerImage;
		this.handler = handler;
	}
	
	@Override
	public void tick() {
	
	}
	
	
	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, handler.getGame().getDisplay().getDimension().width , handler.getGame().getDisplay().getDimension().height, null);
		g.drawImage(playerImage, handler.getGame().getDisplay().getDimension().width/2-playerImage.getWidth()/2, 600, null);
//		Rectangle r=new Rectangle(0, 0, 100, 100);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.fill(r);
		
	}

}
