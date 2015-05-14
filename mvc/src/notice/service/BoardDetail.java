package notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeBean;
import notice.model.NoticeDao;

public class BoardDetail implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		ActionForward res = new ActionForward();
		
		res.setPath("BoardDetail");
		
		
		NoticeDao dao = new NoticeDao();
		dao.addCount(request.getParameter("id"));
		NoticeBean data = (NoticeBean )dao.BoardDetail(request.getParameter("id"));
		
		data.setContent(data.getContent().replaceAll("\r\n", "<br>"));
		
		request.setAttribute("data", data);
		
		return res;
	}
}
