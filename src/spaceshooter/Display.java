package spaceshooter;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import spaceshooter.input.KeyManager;

public class Display {
	JFrame frame;
	Canvas canvas;
	int width, height;
	public Display(String title,int width, int height) {
		this.width = width;
		this.height = height;
		frame = new JFrame(title);;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
		canvas = new Canvas();
		canvas.setSize(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT);
		canvas.setFocusable(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(canvas);
		System.out.println(JFrame.MAXIMIZED_HORIZ);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);
	}
	public Canvas getCanvas(){
		return this.canvas;
	}
	public Dimension getDimension(){
		return new Dimension(width, height);
	}
	public JFrame getFrame(){
		return frame;
	}
}
