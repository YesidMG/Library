package model;

public class TreeAVL {
	NodoAVL root;

	public void clearAll() {
		root = null;
	}

	/******************************* INSERSION **********************************/
	public void inser(Book book) {
		root = insertrAVL(root, book);
	}

	private NodoAVL insertrAVL(NodoAVL nodo, Book book) {
		if (nodo == null) {
			return (new NodoAVL(book));
		}
		int code=toNumber(book.getIsbnCode());

		if (code < toNumber(nodo.getBook().getIsbnCode())) {
			nodo.setLeft(insertrAVL(nodo.getLeft(), book));
		}else if (code > toNumber(nodo.getBook().getIsbnCode())) {
			nodo.setRight(insertrAVL(nodo.getRight(), book));
		}else {
			nodo.getBook().setAmount(nodo.getBook().getAmount()+1);
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


	//---búsqueda de un elemento en el AVL
	public void buscar(String code) {
		if(BuscaEnAVL(root, code)) {
			System.out.println("Existe");
		}else {
			System.out.println("No Existe");
		}
	}

	//Búsqueda recursiva en un AVL
	private boolean BuscaEnAVL(NodoAVL nodo, String code) {
		if (nodo == null) {
			return false;
		} else if (toNumber(code) == toNumber(nodo.getBook().getIsbnCode())) {
			return true;
		} else if (toNumber(code) < toNumber(nodo.getBook().getIsbnCode())) {
			return BuscaEnAVL(nodo.getLeft(), code);
		} else {
			return BuscaEnAVL(nodo.getRight(), code);
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

	public void showTreeAVL() {
		System.out.println("Arbol AVL");
		showTree(root, 0);
	}

	private void showTree(NodoAVL nodo, int depth) {
		if (nodo.getRight() != null) {
			showTree(nodo.getRight(), depth + 1);
		}
		for (int i = 0; i < depth; i++) {
			System.out.print("    ");
		}
		System.out.println("(" + nodo.getBook().toString() + ")");
		if (nodo.getLeft() != null) {
			showTree(nodo.getLeft(), depth + 1);
		}
	}

	public String inOrder(NodoAVL tree) {
		if(tree==null) {
			return "";
		}
		String resultado = "";
		resultado += inOrder(tree.getLeft());
		resultado += tree.getBook().toString() + ", ";
		resultado += inOrder(tree.getRight());
		return resultado;
	}

	public String preOrder(NodoAVL tree) {
		if(tree==null) {
			return "";
		}
		String resultado = "";
		resultado += tree.getBook().toString() + ", ";
		resultado += preOrder(tree.getLeft());
		resultado += preOrder(tree.getRight());
		return resultado;
	}

	public String postOrder(NodoAVL tree) {
		if(tree==null) {
			return "";
		}
		String resultado = "";
		resultado += postOrder(tree.getLeft());
		resultado += postOrder(tree.getRight());
		resultado += tree.getBook().toString() + ", ";
		return resultado;
	}

	/****************************** OTROS METODOS *********************************/

	public int toNumber(String code) {
		String num = code.replace("-", "");
		return Integer.parseInt(num);
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

	public NodoAVL getRoot() {
		return root;
	}

	public void setRoot(NodoAVL root) {
		this.root = root;
	}
}
