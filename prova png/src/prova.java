
import java.awt.Graphics2D;

import javax.swing.JFrame;
public class prova{

	public static void main(String[] args) {
		JFrame window = new JFrame();
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Prima Roba");
				
		Panel panel = new Panel();
		window.add(panel);
		
		window.pack();
		window.setLocationRelativeTo(null);
		
		window.setVisible(true);
		
		panel.repaint();
		
	}

	
	
	
}


