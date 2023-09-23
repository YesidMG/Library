package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.text.View;

import View.MyFrame;
import model.Author;
import model.Book;
import model.TreeAVL;


public class Controll implements ActionListener {
	private MyFrame frame ;
	private TreeAVL tree;

	public Controll() {
		frame = new MyFrame(this);
		tree = new TreeAVL();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case "addNewBook": {
			String [] data= frame.newBook();
			tree.inser(data[0], new Book(data[1], data[2], Integer.parseInt(data[3]), new Author(data[4], data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])));
			
//			ArrayList<Book>a= tree.inOrder(data[0]);
//			for(Book b:a) {
//				System.out.println(b.toString());
//			}
			
			break;
		}
		case "goToAddBook": {
			frame.goToAddBook();
			break;
		}
		case "goToSearchBook": {
			frame.goToSearch_DeleteBook();
			break;
		}
		case "goToListBook": {
			frame.goToListBook(tree.inOrder(frame.returnSectionalList()),this);
			break;
		}
		case "returnMenu": {
			frame.backToMenu();
			break;
		}
		case "changeSearchForm": {
			frame.changeSearchForm();
			break;
		}
		case "changeCampus": {
			frame.changeCampus();
			break;
		}
		case "changeCampusList": {
			frame.changeCampusList();
			frame.showList(tree.inOrder(frame.returnSectionalList()), this);
			break;
		}
		case "changeSectionalList": {
			frame.showList(tree.inOrder(frame.returnSectionalList()), this);
			break;
		}
		case "showSelectedBook": {
			frame.ShowSelectedBook(tree.searchCode(frame.getBookselected(), frame.returnSectionalList()).toString());
			break;
		}
		case "searchByCode": {
			System.out.println("code");
			break;
		}
		case "searchByName": {
			
			System.out.println("name");
			break;
		}
		}

	}
	public static void main(String[] args) {
		new Controll();
	}

}
