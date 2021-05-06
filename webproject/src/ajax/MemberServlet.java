package ajax;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBCon;

@WebServlet("/jquery/memberServlet.do") //실제 주소
public class MemberServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MemberServlet() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      //select
	      response.setContentType("text/html;charset=UTF-8");
	      
	      String sql = "select * from member";
	      Connection conn = DBCon.getConnect();
	      PreparedStatement psmt = null;
	      ResultSet rs = null;
	      
	      String json = "[";
	      try {
	         psmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	         rs = psmt.executeQuery();
	         while(rs.next()) {
	            String memId = rs.getString(1);
	            String memName = rs.getString(2);
	            String memAge = rs.getString(3);
	            json += "{\"Id\": \""+memId//
	                  +"\",\"name\": \""+memName//
	                  +"\",\"age\": \""+memAge//
	                  +"\"}";
	            if(!rs.isLast()) {
	               json += ",";   
	            }
	            
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         if(rs!=null) {
	            try {
	               rs.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         if(psmt != null) {
	            try {
	               psmt.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	         if(conn != null){
	            try {
	               conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	      json += "]";
	      
	      response.getWriter().print(json);
	   }
      // 조회 결과를 json 형식으로 변환 [
         //                      {"id":1,"name":"hong","age":20}
         //                      {"id":1,"name":"hong","age":20}
         //                      {"id":1,"name":"hong","age":20}]
         
      // 결과를 response.getWriter().print(); 출력
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      String p1 = request.getParameter("m_id");
      String p2 = request.getParameter("m_name");
      String p3 = request.getParameter("m_age");
      
      Connection conn = DBCon.getConnect();
      PreparedStatement psmt = null;
      String sql = "insert into member values(?,?,?)";
      try {
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, p1);
         psmt.setString(2, p2);
         psmt.setString(3, p3);
         int r = psmt.executeUpdate();
         System.out.println(r + "건 입력 완료");
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         if(psmt != null)
            try {
               psmt.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
         if(conn != null)
            try {
               conn.close();
            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            }
      }
      response.getWriter().print("<h2>정상적으로 입력되었습니다</h2>");
      
   }

}