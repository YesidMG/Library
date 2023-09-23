package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.Viewelements.JtextPlaceHolder;
import View.Viewelements.MyButton;

public class Panel_2 extends JPanel {

	private int h,w;
	private MyButton addButton, cancelButton;
	private JLabel title, nameBookTitle,authorTitle, codeTitle, nameAuthorTitle, lastNameAuthorTitle, volumeTitle, pageTitle, campusTitle, sectionalTitle;
	private JtextPlaceHolder nameBook, volume, code, pages, nameAuthor, lastNameAuthor;
	private JComboBox<String> campus, sectional;

	public Panel_2(int x, int y, int width, int height, ActionListener listener) {
		w=width;
		h=height;
		this.setBackground(Color.WHITE); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		title = new JLabel("Add Book");
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
		this.add(campus);
		
		sectionalTitle = new JLabel("Select de campus:");
		sectionalTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sectionalTitle.setBounds((int) (w*0.5), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		this.add(sectionalTitle);
		
		String []sectionalsTunja = {"Medicine","Central"};
		sectional = new JComboBox<>(sectionalsTunja);
		sectional.setBounds((int) (w*0.68), (int) (h*0.35), (int) (w*0.18), (int) (h*0.04));
		this.add(sectional);
		
		nameBookTitle = new JLabel("Title of the book:");
		nameBookTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nameBookTitle.setBounds((int) (w*0.125), (int) (h*0.41), (int) (w*0.18), (int) (h*0.04));
		this.add(nameBookTitle);
		
		nameBook = new JtextPlaceHolder("Here the name of the book", (int) (w*0.3), (int) (h*0.41), (int) (w*0.25), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(nameBook);
		
		volumeTitle = new JLabel("Volume:");
		volumeTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		volumeTitle.setBounds((int) (w*0.6), (int) (h*0.41), (int) (w*0.18), (int) (h*0.04));
		this.add(volumeTitle);
		
		volume = new JtextPlaceHolder("Ex 1", (int) (w*0.75), (int) (h*0.41), (int) (w*0.08), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(volume);
		
		codeTitle = new JLabel("Code ISBN:");
		codeTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		codeTitle.setBounds((int) (w*0.125), (int) (h*0.46), (int) (w*0.18), (int) (h*0.04));
		this.add(codeTitle);
		
		code = new JtextPlaceHolder("Ex 000-000-00000-0-0", (int) (w*0.3), (int) (h*0.46), (int) (w*0.25), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(code);
		
		pageTitle = new JLabel("Page numbers:");
		pageTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pageTitle.setBounds((int) (w*0.6), (int) (h*0.46), (int) (w*0.18), (int) (h*0.04));
		this.add(pageTitle);
		
		pages = new JtextPlaceHolder("Ex 30", (int) (w*0.75), (int) (h*0.46), (int) (w*0.08), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(pages);
		
		authorTitle = new JLabel("Author");
		authorTitle.setFont(new Font("Times New Roman", Font.BOLD, 17));
		authorTitle.setBounds((int) (w*0.4), (int) (h*0.525), (int) (w*0.2), (int) (h*0.04));
		authorTitle.setBackground(new Color(233,208,158));
		authorTitle.setOpaque(true);
		authorTitle.setHorizontalAlignment(JLabel.CENTER);
		this.add(authorTitle);
		
		nameAuthorTitle = new JLabel("Name:");
		nameAuthorTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		nameAuthorTitle.setBounds((int) (w*0.125), (int) (h*0.58), (int) (w*0.18), (int) (h*0.04));
		this.add(nameAuthorTitle);
		
		nameAuthor = new JtextPlaceHolder("Name or names", (int) (w*0.2), (int) (h*0.58), (int) (w*0.25), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(nameAuthor);
		
		lastNameAuthorTitle = new JLabel("Last name:");
		lastNameAuthorTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNameAuthorTitle.setBounds((int) (w*0.5), (int) (h*0.58), (int) (w*0.18), (int) (h*0.04));
		this.add(lastNameAuthorTitle);
		
		lastNameAuthor = new JtextPlaceHolder("Surname or surnames", (int) (w*0.625), (int) (h*0.58), (int) (w*0.25), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
		this.add(lastNameAuthor);
		
		addButton = new MyButton("Agree Book",20 ,new Color(240,207,161), new Color(255,216,147), new Color(131,83,70) , (int)(w*0.17), (int)(h*0.65), (int)(w*0.3), (int)(h*0.08)); 
		this.add(addButton);
		
		cancelButton = new MyButton("Cancell",20 ,new Color(240,207,161), new Color(255,216,147), new Color(131,83,70) , (int)(w*0.53), (int)(h*0.65), (int)(w*0.3), (int)(h*0.08)); 
		this.add(cancelButton);
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
	
	

	


}
