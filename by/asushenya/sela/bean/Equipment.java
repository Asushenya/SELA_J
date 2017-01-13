package by.asushenya.sela.bean;

public class Equipment {
	private int id;
	private String title;
	private String kind;
	private float price;
	private int quantity;

	public Equipment(){
		
	}
	public Equipment(String title, String kind, float price, int quantity){
		this.title    = title;
		this.kind     = kind;
		this.price    = price;
		this.quantity = quantity;
	}
	public Equipment(int id, String title, String kind, float price, int quantity){
		this.id       = id;
		this.title    = title;
		this.kind     = kind;
		this.price    = price;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return title;
	}
	public void setName(String name) {
		this.title = name;
	}
	
	public String getKind() {
		return kind;
	}	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public float getCost() {
		return price;
	}
	public void setCost(float cost) {
		this.price = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
