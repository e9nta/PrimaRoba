package it.unibs.project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int FPS = 60;
	
	final int tileSize = 48;
	final int screenWidth = 20*tileSize; //1248
	final int screenHeigth = 12*tileSize; // 768
	
	KeyHandler keyHandler = new KeyHandler();
	
	Thread gameThread;
	
	int playerX = 92;
	int playerY = 92;
	int playerSpeed = 3;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setDoubleBuffered(true);
		this.addKeyListener(keyHandler);
		this.setFocusable(true);
		this.setBackground(Color.darkGray);
	}

	public void startGameThread	() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	
	
	/*public void run() {
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while (gameThread != null) {
			
			update();
			repaint();
						
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
				
			} catch (InterruptedException e) {
				e.printStackTrace(); // da gestire meglio 
			}
		}
			
	}*/
	
	public void run () {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		int drawCount = 0;
		int timer = 0;
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / drawInterval;
			timer += currentTime - lastTime;
			lastTime = currentTime;
			
			if(delta >= 1) {
				
				update();
				repaint();
				delta--;
				drawCount ++;
			}
			
			if(timer >= 1000000000) {
				
				System.out.println("FPS: " + drawCount);
				
				timer = 0;
				drawCount = 0;
						
			}
			
		}
	}
	
	public void update() {
		
		if(keyHandler.upPressed == true) {
			playerY -= playerSpeed;
		}
		if(keyHandler.downPressed == true) {
			playerY += playerSpeed;
		}
		if(keyHandler.rightPressed == true) {
			playerX += playerSpeed;
		}
		if(keyHandler.leftPressed == true) {
			playerX -= playerSpeed;
		}
		
	}
	
	/*
	BufferedImage image;
	BufferedImage back = getPlayerImage();
	*/
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		//g2.drawImage(back,playerX, playerY, 48, 48, null);
		g2.dispose();
	}
	
	
	
	/*public BufferedImage getPlayerImage() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/front1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	*/
}
