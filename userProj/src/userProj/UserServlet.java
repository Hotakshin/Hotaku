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
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");
		String user_phone = request.getParameter("user_phone");
		String user_gender = request.getParameter("user_gender");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		vo.setUser_name(user_name);
		vo.setUser_pass(user_pass);
		vo.setUser_phone(user_phone);
		vo.setUser_gender(user_gender);
		
		UserDAO dao = new UserDAO();
		dao.getInsertUser(vo);
		
	}

}
