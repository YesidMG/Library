package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import View.Viewelements.MyButton;
import View.Viewelements.Pane;
import View.Viewelements.PanelBook;
import View.Viewelements.PrincipalScrollPane;
import model.Book;

public class List_Panel extends JPanel {

	private int h,w;
	private Pane pane;
	private PrincipalScrollPane scroll;
	private MyButton backToMenuButton;
	private JLabel title, campusTitle, sectionalTitle;
	private JTextArea bookInfo;
	private JComboBox<String> campus, sectional;
	private MyFrame frame;

	public List_Panel(int x, int y, int width, int height, ActionListener listener, MyFrame frame) {
		w=width;
		h=height;
		this.frame= frame;
		this.setBackground(Color.WHITE); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		title = new JLabel("List Books");
		title.setFont(new Font("Times New Roman", Font.BOLD, 20));
		title.setBounds((int) (w*0.4), (int) (h*0.255), (int) (w*0.2), (int) (h*0.06));
		title.setBackground(new Color(233,208,158));
		title.setOpaque(true);
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title);

		campusTitle = new JLabel("Select de campus:");
		campusTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		campusTitle.setBounds((int) (w*0.125), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		this.add(campusTitle);

		String [] campusUptc = {"Tunja","Sogamoso","Duitama"};
		campus = new JComboBox<>(campusUptc);
		campus.setBounds((int) (w*0.3), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		campus.addActionListener(listener);
		campus.setActionCommand("changeCampusList");
		this.add(campus);

		sectionalTitle = new JLabel("Select de campus:");
		sectionalTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sectionalTitle.setBounds((int) (w*0.5), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		this.add(sectionalTitle);

		String []sectionalsTunja = {"Center","Medicine"};
		sectional = new JComboBox<>(sectionalsTunja);
		sectional.setBounds((int) (w*0.68), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		sectional.addActionListener(listener);
		sectional.setActionCommand("changeSectionalList");
		this.add(sectional);

		bookInfo = new JTextArea();
		bookInfo.setEditable(false);
		bookInfo.setBackground(Color.LIGHT_GRAY);
		bookInfo.setBounds((int) (w*0.5), (int) (h*0.41), (int) (w*0.36), (int) (h*0.3));
		this.add(bookInfo);

		pane= new Pane(0, 0, ((int) (w*0.25)-14), (int) (h*0.3),new Dimension((int) (w*0.25)-8, (int) (h*0.3)));
		pane.setBackground(new Color(255,233,185));

		scroll= new PrincipalScrollPane((int) (w*0.125), (int) (h*0.41), (int) (w*0.36), (int) (h*0.3),pane);
		scroll.revalidate();
		scroll.repaint();
		this.add(scroll);

		this.revalidate();
		this.repaint();

		backToMenuButton = new MyButton("Back to menu",20 ,new Color(240,207,161), new Color(255,216,147), Color.BLACK , (int) (w*0.03), (int) (h*0.225), (int) (w*0.2), (int) (h*0.06)); 
		backToMenuButton.addActionListener(listener);
		backToMenuButton.setActionCommand("returnMenu");
		this.add(backToMenuButton);
	}

	public void showList (ArrayList<Book> books, ActionListener listener) {
		pane.removeAll();
		if (books.size()>0) {
			bookInfo.setText("");
			int i= 0;
			for(Book book:books) {
				pane.add(new PanelBook(0,(int) ((h*(0.1*i))),(int) (w*0.35), (int) (h*0.1), book,"showSelectedBook", listener,frame));
				i++;
			}
			if(i >= 3) {
				pane.setPreferredSize(new Dimension((int) (w*0.25)-8, (int) (h*0.3)+((int) (h*0.1)*(i-3))));
			}
		}else {
			bookInfo.setText("no books to show");}	
		this.revalidate();
		this.repaint();
	}
	public void showBook(String book) {
		bookInfo.setText(book);
	}

	public void changeCampus() {
		String switcher = campus.getSelectedItem().toString();
		switch (switcher) {
		case "Tunja": {
			if(sectional.getItemCount()==2) {
				sectional.removeItemAt(0);
				sectional.addItem("Center");
				sectional.removeItemAt(0);
				sectional.addItem("Medicine");
				sectional.getItemCount();
			}else {
				sectional.addItem("Center");
				sectional.removeItemAt(0);
				sectional.addItem("Medicine");
			}
			break;
		}
		case "Duitama": {
			if(sectional.getItemCount()==2) {
				sectional.removeItemAt(0);
				sectional.addItem("Faculty");
				sectional.removeItemAt(0);
				sectional.addItem("Agroindustrial");
				sectional.getItemCount();
			}else {
				sectional.addItem("Faculty");
				sectional.removeItemAt(0);
				sectional.addItem("Agroindustrial");
			}
			break;
		}
		case "Sogamoso": {
			sectional.addItem("Sogamoso sectional");
			sectional.removeItemAt(0);
			sectional.removeItemAt(0);
			break;
		}
		}
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 =(Graphics2D)g;
		super.paintComponent(g2);
		ImageIcon ic= new ImageIcon("images/biblioteca.jpeg");
		Icon icon= new ImageIcon(ic.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT)) ;
		icon.paintIcon(this, g2, 0, 0);
		g2.setColor(Color.white);
		g2.fillRect((int)(w*0.1), (int)(h*0.25), (int)(w*0.8), (int)(h*0.5));	
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.black);
		g2.drawRect((int)(w*0.1), (int)(h*0.25), (int)(w*0.8), (int)(h*0.5));
	}

	public JComboBox<String> getSectional() {
		return sectional;
	}

}
