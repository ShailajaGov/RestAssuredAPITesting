package pojo;

import java.util.List;

public class Data {
	
	private List<Line> lines;
	private boolean enableFcc;
	private String parentMtn;
	
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public boolean getEnableFcc() {
		return enableFcc;
	}
	public void setEnableFcc(boolean enableFcc) {
		this.enableFcc = enableFcc;
	}
	public String getParentMtn() {
		return parentMtn;
	}
	public void setParentMtn(String parentMtn) {
		this.parentMtn = parentMtn;
	}
	

}
