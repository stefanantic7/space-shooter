package spaceshooter.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.midi.Soundbank;


public class KeyManager implements KeyListener {

	
	
	public static boolean keys[] = new boolean[255];
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
