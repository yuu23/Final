package f.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import f.bean.fCharacterBean;
import f.dao.FinalDao2;
import f.dao.fDAOException;

@WebServlet("/fListServlet")
public class fListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			// パラメータの解析
			String action = request.getParameter("characterList");
			// モデルのDAOを生成
			FinalDao2 dao2 = new FinalDao2(); // DBへの接続
			// パラメータなしの場合は全レコード表示
			if(action == null || action.length() == 0) {
				List<fCharacterBean> list2 = dao2.findAll();
				// Listをリクエストスコープに入れてJSPへフォワードする
				request.setAttribute("characterList", list2);
				gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");
			}
		}catch (fDAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request,response,"/WEB-INF/fErrInput.jsp");
		}
	}
		protected void gotoPage(HttpServletRequest request,
				HttpServletResponse response,String page) throws ServletException,
				IOException{
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
