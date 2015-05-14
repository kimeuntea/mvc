package notice.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeBean;
import notice.model.NoticeDao;

public class BoardModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("euc-kr");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionForward res = new ActionForward();
		

		NoticeBean bean = new NoticeBean();
		
		bean.setId(Integer.parseInt(request.getParameter("id")));
		bean.setTitle(request.getParameter("title"));
		bean.setPname(request.getParameter("pname"));
		bean.setContent(request.getParameter("content"));
		
		NoticeDao dao = new NoticeDao();
		
		dao.BoardModify(bean);
	
		res.setPath("BoardDetail.bo?id="+bean.getId()+"&page="+request.getParameter("page"));
			
		res.setRedirect(true);
			
		return res;
	}
}
