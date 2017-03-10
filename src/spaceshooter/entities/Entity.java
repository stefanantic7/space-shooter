package spaceshooter.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
	protected int x, y;
	protected BufferedImage image;
	public Entity(int x, int y, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.image = image;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
}
