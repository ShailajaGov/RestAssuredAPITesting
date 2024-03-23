package pojo;

import java.util.List;

public class Line {
	
	private String path;
	private String  action;
	private String mtn;
	private Plan plan;
	private List<Feature>  addFeatures;
	private List<Feature> removeFeatures;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getMtn() {
		return mtn;
	}
	public void setMtn(String mtn) {
		this.mtn = mtn;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public List<Feature> getAddFeatures() {
		return addFeatures;
	}
	public void setAddFeatures(List<Feature> addFeatures) {
		this.addFeatures = addFeatures;
	}
	public List<Feature> getRemoveFeatures() {
		return removeFeatures;
	}
	public void setRemoveFeatures(List<Feature> removeFeatures) {
		this.removeFeatures = removeFeatures;
	}
	
	
	

}
