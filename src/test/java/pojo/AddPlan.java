package pojo;

public class AddPlan {
	
	private CartInfo cartInfo;
	private Data data;
	private boolean  optPlanSku;
	private boolean isByou;
	
	public CartInfo getCartInfo() {
		return cartInfo;
	}
	public void setCartInfo(CartInfo cartInfo) {
		this.cartInfo = cartInfo;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public boolean isOptPlanSku() {
		return optPlanSku;
	}
	public void setOptPlanSku(boolean optPlanSku) {
		this.optPlanSku = optPlanSku;
	}
	public boolean isByou() {
		return isByou;
	}
	public void setByou(boolean isByou) {
		this.isByou = isByou;
	}
	
	

}
