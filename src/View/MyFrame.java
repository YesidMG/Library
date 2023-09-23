package View;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;



public class MyFrame extends JFrame {

	private Panel_1 menu;
	private Panel_2 agree;
	private Panel_3 list;
	private Panel_4 search;
	private Panel_5 delete;

	public MyFrame(ActionListener listener) {
		super("Matriz");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 700);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.initComponets(listener);
		this.revalidate();
		this.repaint();
	}

	private void initComponets( ActionListener listener) {
//		menu = new Panel_1(0,0, this.getWidth(),this.getHeight(), listener);
//		this.add(menu);
		
//		agree = new Panel_2(0,0, this.getWidth(),this.getHeight(), listener);
//		this.add(agree);
		
//		list = new Panel_3(0,0, this.getWidth(),this.getHeight(), listener);
//		this.add(list);
		
//		search = new Panel_4(0,0, this.getWidth(),this.getHeight(), listener);
//		this.add(search);
		
		delete = new Panel_5(0,0, this.getWidth(),this.getHeight(), listener);
		this.add(delete);
	}
	
	
	

}
