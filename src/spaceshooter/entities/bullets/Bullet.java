package spaceshooter.entities.bullets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Bullet {
	protected int x, y;
	protected int speed, damage;
	protected BufferedImage image;
	protected Rectangle rectangle;
	public Bullet(int x, int y, int speed, int damage, BufferedImage image, Rectangle rectangle) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
		this.image = image;
		this.rectangle = rectangle;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public Rectangle getRectangle(){
		return this.rectangle;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
}
