package notice.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeDao;

public class BoardList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int limit = 3;
		int pageLimit = 4;
		
		int page = 1;
		
		if(request.getParameter("page")!=null)
			page = Integer.parseInt(request.getParameter("page"));
		
		
		ActionForward res = new ActionForward();
		
		res.setPath("BoardList");
		
		
		NoticeDao dao = new NoticeDao();
		
		int total = dao.getCount();
		
		int maxPage = total/limit;
		
		if(total%limit!=0)
			maxPage++;
		
		int startPage = (page-1)/pageLimit*pageLimit+1;
		int endPage = startPage+pageLimit -1;
		
		if(endPage>maxPage)
			endPage=maxPage;
		
		Object data = dao.BoardList(page, limit);
		
		request.setAttribute("data", data);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);
		request.setAttribute("pageLimit", pageLimit);
		request.setAttribute("limit", limit);
		
		System.out.println("BoardList.execute() 들어왔다");
		
		return res;
	}
}
