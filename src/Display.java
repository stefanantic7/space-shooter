package spaceshooter;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	JFrame frame;
	Canvas canvas;
	//
	public Display(String title,int width, int height) {
		frame = new JFrame(title);;
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setFocusable(false);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	public Canvas getCanvas(){
		return this.canvas;
	}
}
