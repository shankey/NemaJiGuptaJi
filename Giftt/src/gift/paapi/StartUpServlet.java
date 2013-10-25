package gift.paapi;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class StartupServlet
 */
@WebServlet("/StartupServlet")
public class StartUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Logger LOG = Logger.getLogger(StartUpServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartUpServlet() {
        super();
        TimerTask task = new CronJob();
		 
    	Timer timer = new Timer();
    	timer.schedule(task, 1000,1000);
    	LOG.info("StartupServlet ends here");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
