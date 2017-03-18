package spaceshooter.entities.bullets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import spaceshooter.gfx.Assets;

public class RedLaser extends Bullet {

	public RedLaser(int x, int y, int speed, int damage) {
		super(x,y,speed,damage,Assets.redLaserImage,new java.awt.Rectangle(x, y, Assets.redLaserImage.getWidth(), Assets.redLaserImage.getHeight()));
	}
	public void setImage(BufferedImage image){
		this.image = image;
	}
	@Override
	public void tick() {
		y=y+speed;
		rectangle.y+=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.fill(rectangle);
	}

}
