package spaceshooter.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import spaceshooter.Handler;
import spaceshooter.entities.creatures.EnemyShip;
import spaceshooter.entities.creatures.Player;
import spaceshooter.gfx.Assets;
import spaceshooter.input.KeyManager;

public class GameState extends State{
	private Handler handler;
	private Player player;
	private BufferedImage background;
	private ArrayList<EnemyShip> enemies = new ArrayList<>();
	public GameState(Handler handler) {
		background = Assets.background;
		this.handler = handler;
		player = new Player(handler,handler.getFrameDimension().width/2-Assets.playerImage.getWidth()/2, handler.getFrameDimension().height-100, 100,13);
		handler.getDisplay().getFrame().addKeyListener(new KeyManager());
		enemies.add(new EnemyShip(200, 100, 100, 5));
	}
	public Player getPlayer(){
		return player;
	}
	public ArrayList<EnemyShip> getEnemies(){
		return enemies;
	}
	@Override
	public void tick() {
		player.tick();
		for(EnemyShip enemy: enemies){
			enemy.tick();
		}
	}
	
	int a=500;
	@Override
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, handler.getFrameDimension().width , handler.getFrameDimension().height, null);
		player.render(g);
		for(EnemyShip enemy: enemies){
			enemy.render(g);
		}
		
		
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
