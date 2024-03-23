package pojo;

public class Feature {
	
	private String id;
	private String actionIndicator;
	private String type;
	private int  quantity;
	private String rank ;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActionIndicator() {
		return actionIndicator;
	}
	public void setActionIndicator(String actionIndicator) {
		this.actionIndicator = actionIndicator;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	
}
