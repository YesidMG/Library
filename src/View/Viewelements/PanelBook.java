package View.Viewelements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import View.MyFrame;
import model.Book;


public class PanelBook extends JPanel {

	private MyFrame frame;
	private String actionComand;
	private JButton listenerButton;
	private JLabel nameBook, volume;

	public PanelBook( int x, int y,int width,int heigth, Book book,String comand ,ActionListener listener, MyFrame frame) {
		this.frame=frame;
		this.actionComand=comand;
		this.setBackground(new Color(240,207,161));
		this.setBounds(x,y, width, heigth);
		this.setOpaque(false);
		this.initComponents(listener, book);
	}

	public void initComponents(ActionListener listener,  Book book) {
		this.setLayout(null);
		listenerButton = new JButton();
		listenerButton.setActionCommand(actionComand);
		listenerButton.addActionListener(listener);

		nameBook= new JLabel(book.getTitle());
		nameBook.setFont(new Font("Times New Roman", Font.BOLD, 14));
		nameBook.setBounds((int) (getWidth()*0.1), (int) (getHeight()*0.1),(int) (getWidth()*0.8), (int) (getHeight()*0.3));
		this.add(nameBook);

		volume= new JLabel("Volume: "+book.getVolume());
		volume.setFont(new Font("Times New Roman", Font.BOLD, 14));
		volume.setBounds((int) (getWidth()*0.1), (int) (getHeight()*0.5),(int) (getWidth()*0.4), (int) (getHeight()*0.3));
		this.add(volume);

		this.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				frame.setBookselected(book.getIsbnCode());
				listenerButton.doClick();
			}
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(255,216,147));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(240,207,161));
			}
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		super.paintComponent(g2);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(this.getBackground());
		g2.fillRoundRect((int) (this.getWidth()*0.01), (int) (this.getHeight()*0.1), (int) (this.getWidth()*0.98), (int) (this.getHeight()*0.88),30,30);

		g2.setColor(new Color(131,83,70));
		g2.setStroke(new BasicStroke(2));
		g2.drawRoundRect(0, 0, getWidth()-2, getHeight()-2, 30, 30);


	}

}
