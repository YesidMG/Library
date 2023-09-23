package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Book;
import model.TreeAVL;

public class Controll implements ActionListener {

	private TreeAVL tree;



	public Controll() {
		tree = new TreeAVL();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	public static void main(String[] args) {
		new Controll();
	}

}
