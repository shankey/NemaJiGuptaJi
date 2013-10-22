package gift.paapi;

import gift.dao.DAOFactory;
import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;
import gift.model.GiftCategory;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

public class CronJob extends TimerTask {
	
	@Override
	public void run() {
		System.out.println("Running Cron");
		GiftDAO dao = (GiftDAO)DAOFactory.getDAO(GiftDAO.class.getName());
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.HOUR_OF_DAY, -6);
			Date date = cal.getTime();
			System.out.println("time check =" + date);
			
			List<GiftCategory> li = dao.getGiftCategoryByUpdatedTime(date);
			if(li==null){
				return;
			}
			
			for(GiftCategory gc : li){
				GiftAsinDetail asinDetail = PAAPIWrapper.getPAAPIWrapper().callPAAPI(gc.getAsin());
				GiftAsinDetail currentObject = dao.getAsinDetail(gc.getAsin(), null, null, null, null);
				if(currentObject != null){
					asinDetail.setId(currentObject.getId());
				}
				
				dao.saveGiftAsinDetail(asinDetail);
				dao.updateAsinCategoryTimeStamp(gc);
				
			}
			if(li.size()==0){
				System.out.println("Sleeping Cron for 5 Minutes");
				Thread.sleep(5 * 60 * 1000);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}