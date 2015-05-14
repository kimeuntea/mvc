package notice.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.di.Action;
import notice.di.ActionForward;

/**
 * Servlet implementation class F_controller
 */
@WebServlet("/F_controller")
public class F_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public F_controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
    	String requestURI = request.getRequestURI();
    	
    	String contextPath = request.getContextPath();
    	
    	String command = requestURI.substring(
    			contextPath.length()+1, requestURI.length()-3);
    	
    	ActionForward forward = null;
    	
    	try {
    		
    		ArrayList<String> nonClass = new ArrayList<String>();
    		
    		nonClass.add("BoardWriteForm");
    		
    		
    		if(!nonClass.contains(command))
    		{
				Action service = 
						(Action)Class.forName("notice.service."+command).newInstance();
				
				forward = service.execute(request, response);
    		}else{
    			forward = new ActionForward();
    			forward.setPath(command);
    		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(forward != null)
    	{
    		if(forward.isRedirect())
    		{
    			response.sendRedirect(forward.getPath());
    			
    		}else{
    			RequestDispatcher dispatcher = 
    					request.getRequestDispatcher("view/"+forward.getPath()+".jsp");
    			
    			dispatcher.forward(request, response);
    		}
    	}
    	
	}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

}
