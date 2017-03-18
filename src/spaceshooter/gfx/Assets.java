package spaceshooter.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Assets {
	public static BufferedImage background = ImageLoader.loadImage("/textures/Background/starBackground.png");
	public static BufferedImage playerImage = ImageLoader.loadImage("/textures/player.png");
	public static BufferedImage playerShieldImage = ImageLoader.loadImage("/textures/shield.png");
	public static BufferedImage playerLeftImage = ImageLoader.loadImage("/textures/playerLeft.png");
	public static BufferedImage playerRightImage = ImageLoader.loadImage("/textures/playerRight.png");
	public static BufferedImage greenLaserImage = ImageLoader.loadImage("/textures/laserGreen.png");
	public static BufferedImage redLaserImage = ImageLoader.loadImage("/textures/laserRed.png");
	public static BufferedImage greenLaserShotImage = ImageLoader.loadImage("/textures/laserGreenShot.png");
	public static BufferedImage enemyShipImage = ImageLoader.loadImage("/textures/enemyShip.png");
}
