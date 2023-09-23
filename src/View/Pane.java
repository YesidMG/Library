package View;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Pane extends JPanel {

	
	public Pane( int x,int y,int width,int heigth, Dimension dimension) {
		this.setBounds(0,0, width, heigth);
		this.setPreferredSize(dimension);
		this.setLayout(null);
	}
}
