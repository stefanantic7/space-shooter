package spaceshooter;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javafx.scene.effect.GaussianBlur;
import spaceshooter.input.KeyManager;
import spaceshooter.states.GameState;
import spaceshooter.states.State;

public class Game implements Runnable{
	private Display display;
	private Canvas canvas;
	private BufferStrategy bs;
	private Thread thread;
	private boolean running;
	private State gameState;
	private int width = 700, height=700;
	private Handler handler;
	
	
	
	
	public void start(){
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	private void stop(){
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void init(){
		display = new Display("Space Shooter", width, height);
		canvas = display.getCanvas();
		handler = new Handler(this,display);
		gameState = new GameState(handler);
		State.setCurrentState(gameState);
		
	}
	public GameState getGameState(){
		return (GameState) gameState;
	}
	private void tick(){
		
		State.getCurrentState().tick();
	}
	private void render(){
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			bs = canvas.getBufferStrategy();
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		State.getCurrentState().render(g);
		
		bs.show();
	}
	@Override
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
}
