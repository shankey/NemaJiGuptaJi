package gift.bean;

import java.util.List;



public class DetailPageBean {
	
	Integer age;
	Float startPrice;
	Float endPrice;
	String occasion;
	String gender;
	String relation;
	Integer firstResult;
	Integer maxResults;
	
	
	
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Float startPrice) {
		this.startPrice = startPrice;
	}
	public Float getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Float endPrice) {
		this.endPrice = endPrice;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

}
