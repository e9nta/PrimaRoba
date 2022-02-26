import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int tileSize = 48;
	final int screenWidth = 26*tileSize; //1248
	final int screenHeigth = 16*tileSize; // 768
	BufferedImage image;
	
	public Panel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
		this.setDoubleBuffered(true);
		this.setBackground(Color.GRAY);
		
		
		

	}
	
public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		draw(g2);
		//g2.dispose();
	}
	
	public void draw(Graphics2D g) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/player/re4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 92, 92, 48, 48, null);
	}
}
