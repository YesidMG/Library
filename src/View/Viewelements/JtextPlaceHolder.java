package View.Viewelements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JtextPlaceHolder extends JTextField implements FocusListener {

	private String placeholder;
	private boolean showingPlaceholder;
	private Color colorFount;

	public JtextPlaceHolder(String placeholder, int x, int y ,int widht, int height, Color colorFount, Color background) {
		super();
		this.colorFount=colorFount;
		this.setBorder(null);
		this.setBounds(x,y,widht,height);
		this.setBackground(background);
		this.placeholder = placeholder;
		this.showingPlaceholder = true;
		this.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (this.showingPlaceholder) {
			this.setText(null);
			this.setForeground(colorFount);
			this.showingPlaceholder = false;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (this.getText().equals("")) {
			this.setText(this.placeholder);
			this.setForeground(Color.GRAY);
			this.showingPlaceholder = true;
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.showingPlaceholder) {
			g.setColor(Color.GRAY);
			this.setForeground(Color.GRAY);
			this.setText("  "+this.placeholder);
		}    
	}
}

