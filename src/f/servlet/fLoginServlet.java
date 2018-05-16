package f.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import f.dao.FinalDao;

@WebServlet("/fLoginServlet")
public class fLoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			// actionリクエストパラメータの読み込み
			String action = request.getParameter("action");
			if(action.equals("login")){ // ログイン時
			// ログイン時はユーザー名とパスワードを取得
			// パラメータのエラーチェックは省略
			String userId = request.getParameter("userId");
			String pw = request.getParameter("pw");

			FinalDao dao = new FinalDao();
			List<String> list = dao.findAll();

			String dbUserId = null;
			String dbPw = null;

			dbUserId = list.get(0);
			dbPw = list.get(1);

			if(dbUserId.equals(userId) && dbPw.equals(pw)) {
				// セッション情報を生成
				HttpSession session = request.getSession();
				// ログイン済みの属性を設定
				session.setAttribute("isLogin", "true");
				RequestDispatcher rd = request.getRequestDispatcher("/fMypage.jsp"); // fMypage.jspにフォワード
				rd.forward(request,response);
			} else{
				RequestDispatcher rd = request.getRequestDispatcher("/fLogin.jsp"); // fLogin.jspにフォワード
				rd.forward(request,response);
			}
		} else if(action.equals("logout")){ // ログアウト時
			// すでに作成されているセッション領域を取得。新しくは作成しない
			HttpSession session = request.getSession(false);
			if(session != null) {
				// セッション領域を無効
				session.invalidate();
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログアウトしました</h1>");
			}
		}
		out.println("<a href='/Final/fLogin.jsp'>戻る</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
