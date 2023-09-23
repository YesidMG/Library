package model;

public class Book {
	
	private String isbnCode;
	private String title;
	private int volume;
	private Author author;
	private int pages;
	private int amount;
	
	public Book(String isbnCode,String title, int volume, Author author, int pages, int amount) {
		this.title = title;
		this.isbnCode = isbnCode;
		this.volume = volume;
		this.author = author;
		this.pages = pages;
		this.amount = amount;
	}

	public String getIsbnCode() {
		return isbnCode;
	}

	public void setIsbnCode(String isbnCode) {
		this.isbnCode = isbnCode;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "ISBN CODE: "+isbnCode+
				"\nTITLE: "+title+
				"\nVOLUME: "+volume+
				"\nATHOR: "+author.getName()+" "+author.getLastName()+
				"\nNUM PAGES: "+pages+
				"\nNUMBER OF BOOK AVIABLE: "+amount;
	}
	
	
	
	

}
