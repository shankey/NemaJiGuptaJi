package gift.bao;

import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CategoryDetailBAO {
	
	
	public void execute(){
		GiftDAO giftDAO = new GiftDAO();
		List<GiftCategory> li = giftDAO.getGiftCategory(null, null, null, "M", null, null, null, null);
		System.out.println(li);
		List<String> asinList = extractAsinList(li);
		List<GiftAsinDetail> asinDetailList = giftDAO.getAsinDetailListByAsin(asinList);
		
		System.out.println(asinDetailList);
		
	}
	
	private List<String> extractAsinList(List<GiftCategory> li){
		List<String> asinList = new ArrayList<String>();
		for(GiftCategory asinDetail : li){
			asinList.add(asinDetail.getAsin());
		}
		
		return asinList;
	}
	

}
