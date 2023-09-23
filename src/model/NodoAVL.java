package model;

public class NodoAVL {
	private int nodoHeight;
	private Book book;
	private NodoAVL left;
	private NodoAVL right;

	NodoAVL(Book book) {
		this.book = book;
		nodoHeight = 1;
	}

	public int getNodoHeight() {
		return nodoHeight;
	}

	public void setNodoHeight(int nodoHeight) {
		this.nodoHeight = nodoHeight;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public NodoAVL getLeft() {
		return left;
	}

	public void setLeft(NodoAVL left) {
		this.left = left;
	}

	public NodoAVL getRight() {
		return right;
	}

	public void setRight(NodoAVL right) {
		this.right = right;
	}



}
