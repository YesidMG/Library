package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import View.Viewelements.MyButton;

public class Menu_Panel extends JPanel {

	private int h,w;
	private MyButton addButton;
	private MyButton listButton;
	private MyButton searchAndDeleteButton;

	public Menu_Panel(int x, int y, int width, int height, ActionListener listener) {
		w=width;
		h=height;
		this.setBackground(Color.WHITE); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		addButton = new MyButton("Add Book",20 ,new Color(240,207,161), new Color(255,216,147), new Color(131,83,70) , (int)(w*0.3), (int)(h*0.28), (int)(w*0.4), (int)(h*0.1)); 
		addButton.addActionListener(listener);
		addButton.setActionCommand("goToAddBook");
		this.add(addButton);
		
		searchAndDeleteButton = new MyButton("Search / Delete Book",20 ,new Color(240,207,161), new Color(255,216,147), new Color(131,83,70) , (int)(w*0.3), (int)(h*0.39), (int)(w*0.4), (int)(h*0.1)); 
		searchAndDeleteButton.addActionListener(listener);
		searchAndDeleteButton.setActionCommand("goToSearchBook");
		this.add(searchAndDeleteButton);

		listButton = new MyButton("List Books",20, new Color(240,207,161), new Color(255,216,147), new Color(131,83,70) , (int)(w*0.3), (int)(h*0.5), (int)(w*0.4), (int)(h*0.1)); 
		listButton.addActionListener(listener);
		listButton.setActionCommand("goToListBook");
		this.add(listButton);
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		super.paintComponent(g2);
		ImageIcon ic= new ImageIcon("images/biblioteca.jpeg");
		Icon icon= new ImageIcon(ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)) ;
		icon.paintIcon(this, g2, 0, 0);
		g2.setColor(Color.white);
		g2.fillRect((int)(w*0.25), (int)(h*0.25), (int)(w*0.5), (int)(h*0.5));	
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.black);
		g2.drawRect((int)(w*0.25), (int)(h*0.25), (int)(w*0.5), (int)(h*0.5));
	}
}
