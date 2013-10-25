package gift.bean;

import java.util.List;

public class TopNavBean {
	String categoryName;
	List<List<String>> subCategory;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public List<List<String>> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(List<List<String>> subCategory) {
		this.subCategory = subCategory;
	}
	
}
