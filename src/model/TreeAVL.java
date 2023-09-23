package model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class TreeAVL {
	ArrayList<Book> showBooks;
	NodoAVL center;
	NodoAVL medicine;
	NodoAVL facultad;
	NodoAVL agroindustrial;
	NodoAVL sede_sogamoso;

	NodoAVL root;



	/******************************* INSERSION **********************************/
	public void inser(String sectional, Book book) {
		switch (sectional) {
		case "Center": {
			center = insertrAVL(center, book, "Center");
			break;
		}
		case "Medicine": {
			medicine = insertrAVL(medicine, book,"Medicine");
			break;
		}
		case "Faculty": {
			facultad = insertrAVL(facultad, book, "Faculty");
			break;
		}
		case "Agroindustrial": {
			agroindustrial = insertrAVL(agroindustrial, book, "Agroindustrial");
			break;
		}
		case "Sogamoso sectional": {
			sede_sogamoso = insertrAVL(sede_sogamoso, book,"Sogamoso sectional");
			break;
		}
		}
	}

	private NodoAVL insertrAVL(NodoAVL nodo, Book book, String nodeName) {
		if (nodo == null) {
			return (new NodoAVL(book));
		}
		//		Book existinName
		Book compare= searchName(book.getTitle(),book.getVolume(),nodeName);
		if(compare!=null && !compare.getIsbnCode().equals(book.getIsbnCode())) {
			return nodo;
		}

		int code=toNumber(book.getIsbnCode());

		if (code < toNumber(nodo.getBook().getIsbnCode())) {
			nodo.setLeft(insertrAVL(nodo.getLeft(), book, nodeName));
		}else if (code > toNumber(nodo.getBook().getIsbnCode())) {
			nodo.setRight(insertrAVL(nodo.getRight(), book, nodeName));
		}else {
			if(comparteToBook(book, nodo.getBook())) {
				nodo.getBook().setAmount(nodo.getBook().getAmount()+book.getAmount());
			}
			return nodo;
		}

		nodo.setNodoHeight(1 +  max(getnodoHeight(nodo.getLeft()), getnodoHeight(nodo.getRight())));
		int fe = getBalanceFactor(nodo);

		if (fe > 1 && code < toNumber(nodo.getLeft().getBook().getIsbnCode())) {
			return rightRotate(nodo);
		}
		if (fe < -1 && code > toNumber(nodo.getRight().getBook().getIsbnCode())) {
			return leftRotate(nodo);
		}
		if (fe > 1 && code > toNumber(nodo.getLeft().getBook().getIsbnCode())) {
			nodo.setLeft(leftRotate(nodo.getLeft()));
			return rightRotate(nodo);
		}
		if (fe < -1 && code < toNumber(nodo.getRight().getBook().getIsbnCode())) {
			nodo.setRight(rightRotate(nodo.getRight()));
			return leftRotate(nodo);
		}
		return nodo;
	}


	/******************************* BUSQUEDA **********************************/

	public Book searchCode(String code, String node) {
		switch (node) {
		case "Center": {
			return searchCodeAVL(center, code);
		}
		case "Medicine": {
			return searchCodeAVL(medicine, code);			
		}
		case "Faculty": {
			return searchCodeAVL(facultad, code);		
		}
		case "Agroindustrial": {
			return searchCodeAVL(agroindustrial, code);
		}
		case "Sogamoso sectional": {
			return searchCodeAVL(sede_sogamoso, code);
		}
		default:
			return null;
		}
	}
	private Book searchCodeAVL(NodoAVL nodo, String code) {
		if (nodo == null) {
			return null;
		} else if (toNumber(code) == toNumber(nodo.getBook().getIsbnCode())) {
			return nodo.getBook();
		} else if (toNumber(code) < toNumber(nodo.getBook().getIsbnCode())) {
			return searchCodeAVL(nodo.getLeft(), code);
		} else {
			return searchCodeAVL(nodo.getRight(), code);
		}
	}

	public Book searchName(String name,int volume, String node) {
		return searchNameAVL(node, name, volume);
	}
	private Book searchNameAVL(String node, String nameBook, int volume) {
		ArrayList<Book> search= inOrder(node);
		if(search==null) {
			return null;
		}
		else {
			for(Book book:search) {
				if(unifiTitle(book.getTitle()).equals(unifiTitle(nameBook))&& book.getVolume()==volume) {
					return book;
				}	
			}
			return null;
		}

	}




	/**************************** ELIMINACION **********************************/

	public void delete(String code) {
		root = deleteAVL(root, code);
	}

	private NodoAVL deleteAVL(NodoAVL nodo, String code) {
		if (nodo == null)
			return nodo;
		int key=toNumber(code);
		if (key < toNumber(nodo.getBook().getIsbnCode())){
			nodo.setLeft(deleteAVL(nodo.getLeft(), code));
		}else if (key > toNumber(nodo.getBook().getIsbnCode())){
			nodo.setRight(deleteAVL(nodo.getRight(), code));
		}else {
			if ((nodo.getLeft() == null) || (nodo.getRight() == null)) {
				NodoAVL temp = null;
				if (temp == nodo.getLeft()) {
					temp = nodo.getRight();
				}else {
					temp = nodo.getLeft();
				}
				if (temp == null) {
					nodo = null;
				}else{
					nodo = temp;
				}
			}else {
				NodoAVL temp = getNodoWithMaximunValue(nodo.getLeft());
				nodo.setBook(temp.getBook());
				nodo.setLeft( deleteAVL(nodo.getLeft(), temp.getBook().getIsbnCode()));;
			}
		}

		if (nodo == null)
			return nodo;
		nodo.setNodoHeight(max(getnodoHeight(nodo.getLeft()), getnodoHeight(nodo.getRight())) + 1);

		int fe = getBalanceFactor(nodo);
		if (fe > 1 && getBalanceFactor(nodo.getLeft()) >= 0) {
			return rightRotate(nodo);
		}
		if (fe < -1 && getBalanceFactor(nodo.getRight()) <= 0) {
			return leftRotate(nodo);
		}
		if (fe > 1 && getBalanceFactor(nodo.getLeft()) < 0) {
			nodo.setLeft(leftRotate(nodo.getLeft()));;
			return rightRotate(nodo);
		}
		if (fe < -1 && getBalanceFactor(nodo.getRight()) > 0) {
			nodo.setRight(rightRotate(nodo.getRight()));
			return leftRotate(nodo);
		}
		return nodo;
	}


	/****************************** ROTACIONES *********************************/

	private NodoAVL rightRotate(NodoAVL nodo) {
		NodoAVL nuevaRaiz = nodo.getLeft();
		NodoAVL temp = nuevaRaiz.getRight();

		nuevaRaiz.setRight(nodo);
		nodo.setLeft(temp);

		nodo.setNodoHeight(max(getnodoHeight(nodo.getLeft()), getnodoHeight(nodo.getRight())) + 1);
		nuevaRaiz.setNodoHeight(max(getnodoHeight(nuevaRaiz.getLeft()), getnodoHeight(nuevaRaiz.getRight())) + 1);

		return nuevaRaiz;
	}

	private NodoAVL leftRotate(NodoAVL nodo) {
		NodoAVL nuevaRaiz = nodo.getRight();
		NodoAVL temp = nuevaRaiz.getLeft();

		nuevaRaiz.setLeft(nodo);
		nodo.setRight(temp);

		nodo.setNodoHeight(max(getnodoHeight(nodo.getLeft()), getnodoHeight(nodo.getRight())) + 1);
		nuevaRaiz.setNodoHeight(max(getnodoHeight(nuevaRaiz.getLeft()), getnodoHeight(nuevaRaiz.getRight())) + 1);

		return nuevaRaiz;
	}


	/******************************** MOSTRAR **********************************/

	public ArrayList<Book> inOrder(String tree) {
		ArrayList<Book> resultado = new ArrayList<>();
		NodoAVL showNode=null;
		switch (tree) {
		case "Center": {
			showNode=center;
			break;
		}
		case "Medicine": {
			showNode=medicine;
			break;
		}
		case "Faculty": {
			showNode=facultad;
			break;
		}
		case "Agroindustrial": {
			showNode=agroindustrial;
			break;
		}
		case "Sogamoso sectional": {
			showNode=sede_sogamoso;
			break;
		}
		}
		inOrder(showNode, resultado);
		return resultado;
	}

	private void inOrder(NodoAVL tree, ArrayList<Book> resultado) {
		if (tree != null) {
			inOrder(tree.getLeft(), resultado);
			resultado.add(tree.getBook());
			inOrder(tree.getRight(), resultado);
		}
		else {
			resultado=null;
		}
	}


	/****************************** OTROS METODOS *********************************/

	public int toNumber(String code) {
		String num = code.replace("-", "");
		return Integer.parseInt(num);
	}

	public String unifiTitle(String title) {
		return title.replaceAll("\\s","").toLowerCase();
	}




	/****************************** AUXILIARES *********************************/

	private int getnodoHeight(NodoAVL nodo) {
		if (nodo == null) {
			return 0;}
		return nodo.getNodoHeight();
	}

	private int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private int getBalanceFactor(NodoAVL nodo) {
		if (nodo == null) {
			return 0;}
		return getnodoHeight(nodo.getLeft()) - getnodoHeight(nodo.getRight());
	}

	private NodoAVL getNodoWithMaximunValue(NodoAVL node) {
		NodoAVL current = node;
		while (current.getRight() != null){
			current = current.getRight();}
		return current;
	}

	public boolean comparteToBook(Book book1, Book book2) {
		if(book1.getIsbnCode().equals(book2.getIsbnCode()) && book1.getTitle().equals(book2.getTitle()) && book1.getVolume()==book2.getVolume()
				&& book1.getPages()==book2.getPages() && book1.getAuthor().getName().equals(book2.getAuthor().getName()) && book2.getAuthor().getLastName().equals(book2.getAuthor().getLastName())) {
			return true;
		}else {
			return false;
		}
	}
	/****************************** SETTERS AND GETTERS *********************************/

	public NodoAVL getRoot() {
		return root;
	}

	public void setRoot(NodoAVL root) {
		this.root = root;
	}

	public NodoAVL getCenter() {
		return center;
	}

	public void setCenter(NodoAVL center) {
		this.center = center;
	}

	public NodoAVL getMedicine() {
		return medicine;
	}

	public void setMedicine(NodoAVL medicine) {
		this.medicine = medicine;
	}

	public NodoAVL getFacultad() {
		return facultad;
	}

	public void setFacultad(NodoAVL facultad) {
		this.facultad = facultad;
	}

	public NodoAVL getAgroindustrial() {
		return agroindustrial;
	}

	public void setAgroindustrial(NodoAVL agroindustrial) {
		this.agroindustrial = agroindustrial;
	}

	public NodoAVL getSede_sogamoso() {
		return sede_sogamoso;
	}

	public void setSede_sogamoso(NodoAVL sede_sogamoso) {
		this.sede_sogamoso = sede_sogamoso;
	}

}
