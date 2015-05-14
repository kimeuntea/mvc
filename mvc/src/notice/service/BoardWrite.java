package notice.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.di.Action;
import notice.di.ActionForward;
import notice.model.NoticeBean;
import notice.model.NoticeDao;

public class BoardWrite implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		ActionForward res = new ActionForward();
		
		String dirName = "/up";
		String path = request.getRealPath(dirName);
		path = "C:\\Program Files (x86)\\programing\\jsp10\\mvc\\WebContent"+dirName;
		int size = 10*1024*1024;
		
		try {
			MultipartRequest mm = new MultipartRequest(
					request,
					path,
					size,
					"euc-kr",
					new DefaultFileRenamePolicy()
					);
			
			NoticeBean bean = new NoticeBean();
			
			bean.setTitle(mm.getParameter("title"));
			bean.setPname(mm.getParameter("pname"));
			bean.setContent(mm.getParameter("content"));
			bean.setUpfile(mm.getFilesystemName("upfile"));
			NoticeDao dao = new NoticeDao();
			
			int id = dao.BoardWrite(bean);
			
			
			
			res.setPath("BoardDetail.bo?id="+id);
			
			res.setRedirect(true);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return res;
	}
}
