package spaceshooter.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import spaceshooter.gfx.Assets;

public class EnemyShip extends Creature{
	public EnemyShip(int x, int y, int healty, int speed) {
		super(x, y, Assets.enemyShipImage, healty, speed, new Rectangle(x,y,Assets.enemyShipImage.getWidth(),Assets.enemyShipImage.getHeight()));
		
	}
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.fill(rectangle);
	}
	

}
