package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import View.Viewelements.JtextPlaceHolder;
import View.Viewelements.MyButton;

public class Panel_4 extends JPanel {

	private int h,w;
	private String searchselected;
	private MyButton backToMenuButton, searchButton;
	private JLabel title, campusTitle, sectionalTitle, volumeTitle;
	private JTextArea bookInfo;
	private JtextPlaceHolder nameBook, volume, isbnCode;
	private JComboBox<String> campus, sectional;
	private JRadioButton searchName, searchCode;
	private  ButtonGroup group ;

	public Panel_4(int x, int y, int width, int height, ActionListener listener) {
		w=width;
		h=height;
		this.setBackground(Color.WHITE); 
		this.setLayout(null);
		this.setBounds(x, y, width, height);
		this.initComponents(listener);
	}

	public void initComponents(ActionListener listener) {
		title = new JLabel("Search Book");
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

		searchName = new JRadioButton("Name");
		searchName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		searchName.setBounds((int) (w*0.125), (int) (h*0.4), (int) (w*0.1), (int) (h*0.04));
		searchName.setSelected(true);
		searchName.setOpaque(false);
		searchselected= searchName.getText();
		searchName.repaint();
		searchName.revalidate();

		searchCode = new JRadioButton("ISBN code");
		searchCode.setFont(new Font("Times New Roman", Font.BOLD, 15));
		searchCode.setOpaque(false);
		searchCode.setBounds((int) (w*0.25), (int) (h*0.4), (int) (w*0.18), (int) (h*0.04));

		group = new ButtonGroup();
		group.add(searchName);
		group.add(searchCode);
	

		this.add(searchName);
		this.add(searchCode);

//		nameBook = new JtextPlaceHolder("Name of book", (int) (w*0.125), (int) (h*0.47), (int) (w*0.3), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
//		this.add(nameBook);
//
//		volumeTitle = new JLabel("Volume: ");
//		volumeTitle.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		volumeTitle.setBounds((int) (w*0.125), (int) (h*0.53), (int) (w*0.18), (int) (h*0.04));
//		this.add(volumeTitle);
//
//		volume = new JtextPlaceHolder("1", (int) (w*0.23), (int) (h*0.53), (int) (w*0.05), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
//		this.add(volume);


		isbnCode= new JtextPlaceHolder("000-000-00000-0-0", (int) (w*0.125), (int) (h*0.5), (int) (w*0.3), (int) (h*0.04), Color.BLACK, Color.LIGHT_GRAY);
				this.add(isbnCode);

		bookInfo = new JTextArea();
		bookInfo.setEditable(false);
		bookInfo.setBackground(Color.LIGHT_GRAY);
		bookInfo.setBounds((int) (w*0.5), (int) (h*0.41), (int) (w*0.36), (int) (h*0.3));
		this.add(bookInfo);

		searchButton = new MyButton("Search",20 ,new Color(240,207,161), new Color(255,216,147), Color.BLACK , (int) (w*0.125), (int) (h*0.6), (int) (w*0.35), (int) (h*0.08)); 
		this.add(searchButton);

		backToMenuButton = new MyButton("Back to menu",20 ,new Color(240,207,161), new Color(255,216,147), Color.BLACK , (int) (w*0.03), (int) (h*0.225), (int) (w*0.2), (int) (h*0.06)); 
		this.add(backToMenuButton);

	}

	public void searchTipe() {
		String comparator="";
		for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				comparator=button.getText();
			}
		}

		if (!comparator.equals(searchselected)) {
			if(comparator.equals("Name")) {
				this.remove(isbnCode);
				this.add(nameBook);
				this.add(volumeTitle);
				this.add(volume);
			}else {
				this.remove(nameBook);
				this.remove(volumeTitle);
				this.remove(volume);
			}
			searchselected=comparator;
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






}
