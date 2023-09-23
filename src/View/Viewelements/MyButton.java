package View.Viewelements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {

	private Color borderColor;

	public  MyButton (String text,int sizeFont, Color background_1,Color background_2, Color borderColor,int x, int y,int w,int h ) {
		super(text);

		this.borderColor = borderColor;
		setFont(new Font("Times New Roman", Font.BOLD, sizeFont));
		this.setBounds(x, y, w, h);
		setBorder(BorderFactory.createLineBorder(borderColor));
		setBackground(background_1);
		setFocusPainted(false);
		setContentAreaFilled(false);
		//        setOpaque(true);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(background_2);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(background_1);
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2));
		g2.setColor(getBackground());
		g2.fillRoundRect((int) (this.getWidth()*0.01), (int) (this.getHeight()*0.1), (int) (this.getWidth()*0.98), (int) (this.getHeight()*0.88),40,40);
		g2.setColor(Color.BLACK);	
		g2.setColor(borderColor);
		g2.drawRoundRect((int) (this.getWidth()*0.01), (int) (this.getHeight()*0.1), (int) (this.getWidth()*0.98), (int) (this.getHeight()*0.88),40,40);
		super.paintComponent(g2);
		g2.dispose();
		g.dispose();

	}
}
