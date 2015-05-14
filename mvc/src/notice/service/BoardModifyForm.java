package notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeDao;

public class BoardModifyForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		ActionForward res = new ActionForward();
		
		res.setPath("BoardModifyForm");
		
		
		NoticeDao dao = new NoticeDao();
		Object data = dao.BoardDetail(request.getParameter("id"));
		
		request.setAttribute("data", data);
		
		
		
		return res;
	}
}
