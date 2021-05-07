package fileBoard;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileModifyServlet")
public class FileModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileModifyServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = "c:/tmp";

		ServletContext sc = this.getServletContext();
		path = sc.getRealPath("upload");

		MultipartRequest multi = //
				new MultipartRequest(request, //
						path, 8 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration en = multi.getFileNames();
		String author = multi.getParameter("author");
		String title = multi.getParameter("title");
		String num = multi.getParameter("num");
		String fileN = null;

		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String fileName = multi.getFilesystemName(name);
			fileN = fileName;
			System.out.println("name: " + name + "fileName: " + fileName);
		}
		// 입력 후 저장된 값 가져오기.
		FileDAO dao = new FileDAO();
		FileVO vo = new FileVO();
		vo.setAuthor(author);
		vo.setFileName(fileN);
		vo.setTitle(title);
		vo.setNum(Integer.parseInt(num));

		// 가져온 값을 json 형식 생성 {"retCode":"Fail"} 이런 형식
		JSONObject obj = new JSONObject();
		if (dao.updateFile(vo)) {
			obj.put("retCode", "Success");
		} else {
			obj.put("retCode", "Fail");
		}
		response.getWriter().print(obj);
	}

}
