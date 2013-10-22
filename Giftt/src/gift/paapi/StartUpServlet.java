package gift.paapi;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8523992021391203515L;
	
	public void init() throws ServletException
    {
		TimerTask task = new CronJob();
		 
    	Timer timer = new Timer();
    	timer.schedule(task, 1000,1000);
    	System.out.println("Main ends here");
    }
	
}