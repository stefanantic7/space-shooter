package spaceshooter.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import spaceshooter.Handler;
import spaceshooter.entities.bullets.Bullet;
import spaceshooter.entities.bullets.RedLaser;
import spaceshooter.gfx.Assets;

public class EnemyShip extends Creature{
	
	private ArrayList<Bullet> lasers = new ArrayList<>();
	private Timer timer;
	private TimerTask myTask;
	public EnemyShip(int x, int y, int healty, int speed) {
		super(x, y, Assets.enemyShipImage, healty, speed, new Rectangle(x,y,Assets.enemyShipImage.getWidth(),Assets.enemyShipImage.getHeight()));
		
	}
	
	public Rectangle getRectangle(){
		return this.rectangle;
	}
	
	public int getY(){
		return y;
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
