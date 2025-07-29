package coffee;

class library implements java.io.Serializable{
	private int id;
	private String bookname;
	private String authname;
	public void setid(int id) {
		this.id = id;
	}
	public void setname(String booname) {
		bookname = booname;
	}
	public void setauthor(String authorname) {
		authname = authorname;
	}
	public int getid() {
		return id;
	}
	public String getname() {
		return bookname;
	}
	public String authname() {
		return authname;
	}
}


public class JavaBean {

	public static void main(String[] args) {
		library a = new library();
		a.setid(1);
		a.setname("java");
		a.setauthor("goslin");
		System.out.println("the id is: "+a.getid());
		System.out.println("the book name is: "+ a.getname());
		System.out.println("the book name is: "+ a.authname());
	}

}
