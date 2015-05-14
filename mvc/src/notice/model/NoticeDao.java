package notice.model;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class NoticeDao {

	Connection con =null;
	PreparedStatement psmt =null;
	ResultSet rs = null;
	String sql="";
	
	
	public NoticeDao() {
		// TODO Auto-generated constructor stub
		try {
			Context init = new InitialContext();
			DataSource ds = 
					(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
			
			con = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int getCount()
	{
		
		
		sql = "select count(*) from notice";
		
		try {
			psmt = con.prepareStatement(sql);
			
			
			rs = psmt.executeQuery();
			
			rs.next();	
			
			return rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	
	}
	
	public Object BoardList(int page, int limit)
	{
		ArrayList<NoticeBean> res = new ArrayList<NoticeBean>();
		
		int start = (page-1)*limit+1;
		int end = start + limit - 1; 
		
		sql = " select * from "
				+ "(select rownum rid, tt.*  from "
				+ "(select * from notice order by id desc) tt ) "
				+ "where rid >= ? and rid <= ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, start);
			psmt.setInt(2, end);
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				NoticeBean bb = new NoticeBean();
				
				bb.setId(rs.getInt("id"));
				bb.setGid(rs.getInt("gid"));
				bb.setSeq(rs.getInt("seq"));
				bb.setRef(rs.getInt("ref"));
				bb.setCnt(rs.getInt("cnt"));
				bb.setReg_date(rs.getDate("reg_date"));
				bb.setPname(rs.getString("pname"));
				bb.setTitle(rs.getString("title"));
				
				res.add(bb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		
		return res;
	}
	
	public void addCount(String id)
	{
		sql = "update notice set cnt = cnt +1 where id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(id));
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	public Object BoardDetail(String id)
	{
		NoticeBean bb = null;
		
		sql = "select * from notice where id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(id));
			rs = psmt.executeQuery();
			
			if(rs.next())
			{
				bb=new NoticeBean();
				bb.setId(rs.getInt("id"));
				bb.setGid(rs.getInt("gid"));
				bb.setSeq(rs.getInt("seq"));
				bb.setRef(rs.getInt("ref"));
				bb.setCnt(rs.getInt("cnt"));
				bb.setReg_date(rs.getDate("reg_date"));
				bb.setPname(rs.getString("pname"));
				bb.setTitle(rs.getString("title"));
				bb.setContent(rs.getString("content"));
				bb.setUpfile(rs.getString("upfile"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		
		return bb;
	}
	
	
	
	public int BoardWrite(NoticeBean bean)
	{
		
		int id = 1;
		
		sql = "select max(id) from notice";
		
		try {
			psmt = con.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next())
			{
				id = rs.getInt(1)+1;
			}
			
			
			sql = "insert into notice "
					+ "(id, gid, seq, ref, reg_date, cnt, pname, title, content, upfile) "
					+ "values (? ,?, ?, ?, sysdate, ?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, id);
			psmt.setInt(2, id);
			psmt.setInt(3, 0);
			psmt.setInt(4, 0);
			psmt.setInt(5, -1);
			psmt.setString(6,bean.getPname());
			psmt.setString(7,bean.getTitle());
			psmt.setString(8,bean.getContent());
			psmt.setString(9,bean.getUpfile());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
		
		return id;
	}
	
	
	public void FileDelete(String id, String path)
	{

		sql = "select * from notice where id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(id));
			rs = psmt.executeQuery();
			
			rs.next();
			
			String fileName = rs.getString("upfile");
			
			if(fileName != null && !fileName.equals("") && !fileName.equals("null"))
			{
				String delFile = path+"/"+fileName;
				
				File ff = new File(delFile);
				
				if(ff.exists())
					ff.delete();
				
				sql = "update notice set upfile = '' where id = ?";
				psmt = con.prepareStatement(sql);
				
				psmt.setInt(1, Integer.parseInt(id));
				psmt.executeUpdate();
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}
	
	
	public void BoardDelete(String id, String path)
	{
		FileDelete(id, path);
		sql = "delete from notice where id = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(id));
			psmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
		
	}
	
	
	
	
	public void BoardModify(NoticeBean bean)
	{
		
		
		
		try {
			
			
			sql = "update notice set "
					+ "title = ? , "
					+ "pname = ? , "
					+ "content = ? "
					+ "where id = ? ";
			
			psmt = con.prepareStatement(sql);
			
			psmt.setString(1,bean.getTitle());
			psmt.setString(2,bean.getPname());
			psmt.setString(3,bean.getContent());
			psmt.setInt(4, bean.getId());
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	
	public void close()
	{
		if(rs!=null) try{ rs.close();}catch(Exception e){}
		if(psmt!=null) try{ psmt.close();}catch(Exception e){}
		if(con!=null) try{ con.close();}catch(Exception e){}
	}
}
