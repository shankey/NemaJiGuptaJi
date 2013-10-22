package gift.paapi;

import gift.dao.DAOFactory;
import gift.dao.GiftDAO;
import gift.model.GiftAsinDetail;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import javax.ejb.Asynchronous;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.springframework.scheduling.annotation.AsyncResult;


public class SyncAsinDetail {
	
	ExecutorService executor = Executors.newFixedThreadPool(5);

	GiftDAO dao = (GiftDAO) DAOFactory.getDAO(GiftDAO.class.getName());
	
	
    void syncAsinDetails(final List<String> asinList) throws InterruptedException
    {

        FutureTask<String> future = new FutureTask<String>(
                new Callable<String>()
                {
                    public String call()
                    {

						for (String asin : asinList) {
							PAAPIWrapper paapiWrapper = PAAPIWrapper.getPAAPIWrapper();
							GiftAsinDetail asinDetail = paapiWrapper.callPAAPI(asin);
							asinDetail.setAsin(asin);
							asinDetail.setTimeStamp(new Date());

							
							dao.saveGiftAsinDetail(asinDetail);
						}
                    	
                    	return null;
                    }
                    
                });
        executor.execute(future);
    }
}
