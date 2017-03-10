package spaceshooter.entities.creatures;


import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import spaceshooter.entities.Entity;

public abstract class Creature extends Entity{

	protected int healty, speed;
	protected Rectangle rectangle;
	public Creature(int x, int y, BufferedImage image, int healty,int speed, Rectangle rectangle) {
		super(x, y, image);
		this.speed = speed;
		this.rectangle = rectangle;
	}
	
	
}
