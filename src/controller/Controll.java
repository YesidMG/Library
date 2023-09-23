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
		try {
		String source = event.getActionCommand();
		switch (source) {
		
		case "addNewBook": {
			String [] data= frame.newBook();
			if(tree.completeData(data)) {
			if (tree.isNegative(Integer.parseInt(data[3])) || tree.isNegative(Integer.parseInt(data[6])) || tree.isNegative(Integer.parseInt(data[7]))) {
				frame.showError("quantity, pages and volume must be greater than zero", false);
			}else {
			tree.inser(data[0], new Book(data[1], data[2], Integer.parseInt(data[3]), new Author(data[4], data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])));
			frame.showError(tree.getMessageOperation(), tree.getExit());}
			}
			else {
				frame.showError("Complete all information fields", false);
			}
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
			frame.showSearchBook(tree.searchCode(frame.returnSearchCode(), frame.returnSectionalSearch_Delete()));
			break;
		}
		case "searchByName": {
			String [] dataSearch= frame.returnSearchName();
			frame.showSearchBook(tree.searchName(tree.unifiTitle(dataSearch[0]), Integer.parseInt(dataSearch[1]), frame.returnSectionalSearch_Delete()));
			break;
		}
		case "deleteUnities": {
			if(frame.getBookselected()!=null) {
				tree.deleteUnities(frame.returnSectionalSearch_Delete(), frame.getBookselected(), Integer.parseInt(frame.amountToDelete()));
				frame.showSearchBook(tree.searchCode(frame.getBookselected(), frame.returnSectionalSearch_Delete()));
				frame.showError(tree.getMessageOperation(), tree.getExit());}
			else {
			frame.showError("no item selected to delete", false);	
			}
			break;
		}
		case "deleteAll": {
			if(frame.getBookselected()!=null) {
				tree.delete(frame.returnSectionalSearch_Delete(), frame.getBookselected());
				frame.showSearchBook(tree.searchCode(frame.getBookselected(), frame.returnSectionalSearch_Delete()));}
			else {
				frame.showError("no item selected to delete", false);	
				}
			break;
		}
		}
		}catch (Exception e) {
			frame.showError("Error in the data entered", false);
		}

	}
	public static void main(String[] args) {
		new Controll();
	}

}
