package gift.dao;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
	
	GiftDAO giftDAO = new GiftDAO();
	
	private static DAOFactory daoFactory = new DAOFactory();
	
	Map<String, Object> daoMap = new HashMap<String, Object>();
	
	static{
		daoFactory.getDaoMap().put(GiftDAO.class.getName(), daoFactory.getGiftDAO());
	}

	public static Object getDAO(String daoName){
		return daoFactory.getDaoMap().get(daoName);
	}
	
	public GiftDAO getGiftDAO() {
		return giftDAO;
	}

	public void setGiftDAO(GiftDAO giftDAO) {
		this.giftDAO = giftDAO;
	}

	public Map<String, Object> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, Object> daoMap) {
		this.daoMap = daoMap;
	}

}
