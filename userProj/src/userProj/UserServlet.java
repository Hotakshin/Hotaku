package userProj;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// json 데이터 ... DAO : 전체리스트 메소드
				// [{},{},{}]
				// JSONObject, JSONArray
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				UserDAO dao = new UserDAO();
				List<UserVO> list = dao.getUserList();
				JSONArray ary = new JSONArray();
				for(UserVO vo : list) {
					JSONObject obj = new JSONObject();
					obj.put("user_id", vo.getUser_id());
					obj.put("user_name", vo.getUser_name());
					obj.put("user_pass", vo.getUser_pass());
					obj.put("user_phone", vo.getUser_phone());
					obj.put("user_gender", vo.getUser_gender());
					ary.add(obj);
				}
				response.getWriter().print(ary);
			}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MultipartRequest multi = new MultipartRequest(request, "c:/tmp", 8*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		UserVO vo = new UserVO();
		UserDAO dao = new UserDAO();
		
		String user_id = multi.getParameter("user_id");
		String user_name = multi.getParameter("user_name");
		String user_pass = multi.getParameter("user_pass");
		String user_phone = multi.getParameter("user_phone");
		String user_gender = multi.getParameter("user_gender");
		System.out.println(multi.getParameter("user_id"));
		
	
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setUser_pass(user_pass);
		vo.setUser_phone(user_phone);
		vo.setUser_gender(user_gender);
		
		UserVO uvo = dao.getInsertUser(vo);
		
		JSONObject obj = new JSONObject();
		obj.put("user_id", uvo.getUser_id());
		obj.put("user_name", uvo.getUser_name());
		obj.put("user_pass", uvo.getUser_pass());
		obj.put("user_phone", uvo.getUser_phone());
		obj.put("user_gender", uvo.getUser_gender());
	
		
		response.getWriter().print(obj);
		
		
	}

}