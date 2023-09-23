package View;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import model.Book;

public class MyFrame extends JFrame {
	private int actualPane; 
	private String bookselected;
	private Pane pane; 
	private Menu_Panel menu;
	private AddBook_Panel agree;
	private List_Panel list;
	private Search_Delete_Panel search_Delete;

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
		actualPane=0;
		bookselected="";
		pane= new Pane(0, 0, this.getWidth()-14, this.getHeight()-38,new Dimension(this.getWidth()-24, this.getHeight()-40));
		menu = new Menu_Panel(0,0, this.getWidth(),this.getHeight(), listener);
		agree = new AddBook_Panel(0,0, this.getWidth(),this.getHeight(), listener);
		search_Delete = new Search_Delete_Panel(0,0, this.getWidth(),this.getHeight(), listener);
		list = new List_Panel(0,0, this.getWidth(),this.getHeight(), listener, this);
		pane.add(menu);		
		this.add(pane);
	}

	public void goToAddBook () {
		pane.removeAll();
		pane.add(agree);
		actualPane=1;
		this.repaint();
		this.revalidate();
	}
	public void goToSearch_DeleteBook () {
		actualPane=2;
		pane.removeAll();
		pane.add(search_Delete);
		this.repaint();
		this.revalidate();
	}
	public void goToListBook (ArrayList<Book> books, ActionListener listener) {
		actualPane=3;
		pane.removeAll();
		pane.add(list);
		showList(books, listener);
		this.repaint();
		this.revalidate();
	}

	public void backToMenu() {
		agree.clean();
		search_Delete.clean();
		pane.removeAll();
		pane.add(menu);
		this.repaint();
		this.revalidate();
	}

	public void changeSearchForm() {
		search_Delete.searchTipe();
		this.repaint();
		this.revalidate();
	}

	public void changeCampus() {
		switch (actualPane) {
		case 1: {
			agree.changeCampus();
			break;
		}
		case 2: {
			search_Delete.changeCampus();
			break;
		}
		}
		this.repaint();
		this.revalidate();
	}
	
	public void changeCampusList(){
		list.changeCampus();
	}
	
	public String[] newBook() {
		return new String [] {agree.getSectional().getSelectedItem().toString(),agree.getCode().getText(),agree.getNameBook().getText(),
				agree.getVolume().getText(),agree.getNameAuthor().getText(),agree.getLastNameAuthor().getText(), agree.getPages().getText(),
				agree.getAmount().getText()};
	}
	
	public void showList(ArrayList<Book> books, ActionListener listener) {
		list.showList(books, listener);
	}
	public String returnSectionalList(){
		return list.getSectional().getSelectedItem().toString();
	}
	public void ShowSelectedBook(String book) {
		list.showBook(book);
	}
	
	public String returnSectionalSearch_Delete(){
		return list.getSectional().getSelectedItem().toString();
	}
	
	
	

	public String getBookselected() {
		return bookselected;
	}

	public void setBookselected(String bookselected) {
		this.bookselected = bookselected;
	}

	
	

}
