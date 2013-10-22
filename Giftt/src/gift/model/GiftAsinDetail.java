package gift.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GIFT_ASIN_DETAIL")
public class GiftAsinDetail {
	
	private Integer id;
	
	private String asin;
	
	private String image;
	
	private Float price;
	
	private String title;
	
	private String detailPage;
	
	private Date timeStamp;

	
	
	@GeneratedValue
	@Column(name="Id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
	@Column(name="ASIN")
	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	@Column(name="IMAGE")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="PRICE")
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) { 
		this.price = price;
	}

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="DETAIL_PAGE")
	public String getDetailPage() {
		return detailPage;
	}

	public void setDetailPage(String detail_page) {
		this.detailPage = detail_page;
	}
	
	@Column(name="LAST_UPDATED")
	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	public String toString(){
		return asin + " " + title + " " + price;
	}
}
