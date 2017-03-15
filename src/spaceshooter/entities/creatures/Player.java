package spaceshooter.entities.creatures;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import spaceshooter.Handler;
import spaceshooter.entities.bullets.Bullet;
import spaceshooter.entities.bullets.GreenLaser;
import spaceshooter.gfx.Assets;
import spaceshooter.input.KeyManager;

public class Player extends Creature{

	public static boolean canShoot = true;
	private Handler handler;
	private ArrayList<Bullet> lasers = new ArrayList<>();
	public Player(Handler handler, int x, int y, int healty, int speed) {
		super(x, y,Assets.playerImage, healty, speed, new Rectangle(x,y,Assets.playerImage.getWidth(),Assets.playerImage.getHeight()));

		this.handler = handler;
	}
	
	public Rectangle getRectangle(){
		return this.rectangle;
	}
	
	@Override
	public void tick() {
		image = Assets.playerImage;
		if(KeyManager.keys[KeyEvent.VK_UP]){
			if(y-speed>0){
				y=y-speed;
				rectangle.y -= speed;
			}
		}
		if(KeyManager.keys[KeyEvent.VK_DOWN]){
			if(y+image.getHeight()<handler.getFrameDimension().getHeight()){
				y=y+speed;
				rectangle.y += speed;
			}
		}
		if(KeyManager.keys[KeyEvent.VK_LEFT]){
			image = Assets.playerLeftImage;
			if(x-speed>0){
				x=x-speed;
				rectangle.x -= speed;
			}
		}
		if(KeyManager.keys[KeyEvent.VK_RIGHT]){
			image = Assets.playerRightImage;
			if(x+image.getWidth()<handler.getFrameDimension().getWidth()){
				x=x+speed;	
				rectangle.x +=speed;
			}
			
		}
		if(KeyManager.keys[KeyEvent.VK_SPACE]){
			if(canShoot){
				lasers.add(new GreenLaser(x+image.getWidth()/2-Assets.greenLaserImage.getWidth()/2, y-Assets.greenLaserImage.getHeight(), 5, 10));
				canShoot = false;
			}
			
		}
		loop:
		for(int i=0;i<lasers.size();i++){
			Bullet laser = lasers.get(i);
			laser.tick();
			
			
			if(laser.getY()<0-Assets.greenLaserImage.getHeight() || laser.getX()<0 || laser.getX()>handler.getFrameDimension().getWidth()){
				lasers.remove(i);
				--i;
				continue;
			}
			for(int j=0;j<handler.getEnemies().size();j++){
				EnemyShip e = handler.getEnemies().get(j);
				if(laser.getRectangle().intersects(e.rectangle)){
					((GreenLaser)laser).setImage(Assets.greenLaserShotImage);
					handler.getEnemies().remove(e);
					lasers.remove(i);
					--i;
					--j;
					continue loop;
				}
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
		for(Bullet laser:lasers){
			laser.render(g);
		}
	}



	

}
