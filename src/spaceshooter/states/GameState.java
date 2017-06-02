package spaceshooter.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import spaceshooter.Handler;
import spaceshooter.entities.Entity;
import spaceshooter.entities.bullets.Bullet;
import spaceshooter.entities.bullets.RedLaser;
import spaceshooter.entities.creatures.EnemyShip;
import spaceshooter.entities.creatures.Player;
import spaceshooter.gfx.Assets;
import spaceshooter.input.KeyManager;

public class GameState extends State{
	private Handler handler;
	private Player player;
	private BufferedImage background;
	private ArrayList<EnemyShip> enemies = new ArrayList<>();
	private Timer timer;
	private TimerTask enemyTask;
	private TimerTask laserTask;
	private ArrayList<Bullet> lasers = new ArrayList<>();
	public static int rank=0;
	public GameState(Handler handler) {
		background = Assets.background;
		this.handler = handler;
		player = new Player(handler,handler.getFrameDimension().width/2-Assets.playerImage.getWidth()/2, handler.getFrameDimension().height-100, 100,13);
		handler.getDisplay().getFrame().addKeyListener(new KeyManager());
		timer = new Timer();
        enemyTask = new TimerTask() {
            @Override
            public void run() {
        		enemies.add(new EnemyShip(Handler.rand(0, handler.getFrameDimension().width-Assets.enemyShipImage.getWidth()), 100, 100, 5));
            }
        };
        laserTask = new TimerTask() {
			
			@Override
			public void run() {          
				lasers.add(new RedLaser(Handler.rand(0, handler.getFrameDimension().width-Assets.redLaserImage.getWidth()), 0,5, 7));
			}
		};
        timer.schedule(enemyTask, 0,1000);
        timer.schedule(laserTask, 0,700);
	}
	public Player getPlayer(){
		return player;
	}
	public ArrayList<EnemyShip> getEnemies(){
		return enemies;
	}
	@Override
	public void tick() {
		if(player!=null){
			player.tick();
		}
		for(int i=0;i<enemies.size();i++){
			EnemyShip enemy = enemies.get(i);
			
			if(enemy.getY()>handler.getFrameDimension().height){
				--i;
				enemies.remove(enemy);
				continue;
				
			}
			if(player!=null && player.getRectangle().intersects(enemy.getRectangle())){
				player = new Player(handler,handler.getFrameDimension().width/2-Assets.playerImage.getWidth()/2, handler.getFrameDimension().height-100, 100,13);
				System.out.println("sece");
				--rank;
			}
			enemy.tick();
		}
		for(int i=0; i<lasers.size();i++){
			Bullet laser = lasers.get(i);
			if(laser.getY()>handler.getFrameDimension().getHeight()){
				--i;
				lasers.remove(laser);
				continue;
			}
			if(player.getRectangle().intersects(laser.getRectangle())){
				player = new Player(handler,handler.getFrameDimension().width/2-Assets.playerImage.getWidth()/2, handler.getFrameDimension().height-100, 100,13);
				System.out.println("sece");
				--rank;
				--i;

				lasers.remove(laser);
				continue;
			}
			laser.tick();
		}

	}
	
	int a=500;
	@Override
	public void render(Graphics g) {

		
		g.drawImage(background, 0, 0, handler.getFrameDimension().width , handler.getFrameDimension().height, null);
		if(player!=null){
			player.render(g);
		}
		for(int i=0;i<enemies.size();i++){
			EnemyShip enemy = enemies.get(i);
			enemy.render(g);
		}
		for(int i=0;i<lasers.size();i++){
			lasers.get(i).render(g);
		}
		
		int fontSize = 20;
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
	     
	    g.setColor(Color.red);
	    
	    g.drawString(""+rank, 10, 20);
//		Rectangle r=new Rectangle(0, 0, 100, 100);
//		Rectangle r2 = new Rectangle(a, 50, 100, 100);
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.fill(r);
//		g2d.setColor(Color.red);
//		if(!r.intersects(r2.getX()-1, r2.getY()-1, r2.getWidth(), r2.getHeight())){
//			if(!r.intersects(r2.getX()-1-13, r2.getY()-1, r2.getWidth(), r2.getHeight()))
//				a=a-13;
//			else{
//				int speed =13;
//				for(int i=1;i<speed;i++){
//					speed = speed - i;
//					if(!r.intersects(r2.getX()-1-speed, r2.getY()-1, r2.getWidth(), r2.getHeight()))
//						a=a-speed;
//				}
//				
//			}
//			
//		}
//		g2d.fill(r2);
		
	}

}
