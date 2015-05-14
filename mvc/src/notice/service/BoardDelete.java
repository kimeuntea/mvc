package notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeDao;

public class BoardDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		ActionForward res = new ActionForward();
		
		res.setPath("BoardList.bo?page="+request.getParameter("page"));
		res.setRedirect(true);
		
		NoticeDao dao = new NoticeDao();
		
		String dirName = "/up";
		String path = request.getRealPath(dirName);
		path = "C:\\Program Files (x86)\\programing\\jsp10\\mvc\\WebContent"+dirName;
		
		dao.BoardDelete(request.getParameter("id"), path);
		
		
		
		
		return res;
	}
}
