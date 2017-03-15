package spaceshooter.entities.bullets;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javafx.scene.shape.Rectangle;
import spaceshooter.gfx.Assets;

public class GreenLaser extends Bullet{
	
	public GreenLaser(int x, int y, int speed, int damage) {
		super(x,y,speed,damage,Assets.greenLaserImage,new java.awt.Rectangle(x, y, Assets.greenLaserImage.getWidth(), Assets.greenLaserImage.getHeight()));
	}
	public void setImage(BufferedImage image){
		this.image = image;
	}
	@Override
	public void tick() {
		y=y-speed;
		rectangle.y-=speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.fill(rectangle);
	}
	
}
