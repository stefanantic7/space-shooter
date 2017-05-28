package spaceshooter;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Display {
	private JFrame frame;
	private Canvas canvas;
	private Dimension screenSize;
	private int scale;
	public Display(String title,int  scale) {
		this.scale = scale;
		frame = new JFrame(title);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screenSize.width, screenSize.height);
		canvas = new Canvas();
		canvas.setSize(screenSize.width, screenSize.height);
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
	public double getScale(){
		return scale;
	}
	public Dimension getDimension(){
		return new Dimension(screenSize.width/scale, screenSize.height/scale);
	}
	public JFrame getFrame(){
		return frame;
	}
}
