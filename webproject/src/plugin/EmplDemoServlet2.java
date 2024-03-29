package plugin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.Employee;

@WebServlet("/emplDemoServlet2")
public class EmplDemoServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmplDemoServlet2() {
		super();
	}

	   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws ServletException, IOException {

		      EmpDAO dao = new EmpDAO();
		      List<Employee> list = dao.getEmployeeList();

		      int totalCnt = list.size();
		      int cnt = 0;
		      // 사원번호, 이름, 이메일, 연락처, 입사일자, 급여
		      // { "draw" : 1, "recordsTotal": 57, "recordsFiltered": 57, "data": [
		      // [...],[...],[...],[...] ] }
		      String json = "[";
		      for (Employee emp : list) {
		         json += "[\"" + emp.getEmployeeId() + "\","//
		               + "\"" + emp.getFirstName() + "\","//
		               + "\"" + emp.getEmail() + "\","//
		               + "\"" + emp.getPhoneNumber() + "\","//
		               + "\"" + emp.getHireDate() + "\","//
		               + "\"" + emp.getSalary() + "\""//
		               + "]";
		         if (++cnt != totalCnt) { //마지막 데이터가 아니면 ,로 구분
		            json += ",";
		         }
		      }
		      json += "]";

		      response.getWriter().print(json);
		   }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}