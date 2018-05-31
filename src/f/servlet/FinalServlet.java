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

@WebServlet("/FinalServlet")
public class FinalServlet extends HttpServlet {
	// private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			// パラメータの解析
			String action = request.getParameter("action");
			// モデルのDAOを生成
			FinalDao2 dao2 = new FinalDao2();// DBへの接続
			// パラメータなしの場合は全レコード表示
			if(action == null || action.length() == 0) {
				List<fCharacterBean> list2 = dao2.findAll();
				// Listをリクエストスコープに入れてJSPへフォワードする
				request.setAttribute("characterList", list2);
				gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");

			// add
			}else if(action.equals("add")) {

				// 入力された情報を変数に格納
				String no = request.getParameter("no");
				String name = request.getParameter("name");
				String job = request.getParameter("job");
				String ability = request.getParameter("ability");
				String image = request.getParameter("image");

				// 上記の変数をdao2に送り、DBに、入力された情報が追加された
				dao2.fAddCharacter(no,name,job,ability,image);

				// 情報を追加後、全レコード表示
				List<fCharacterBean> list2 = dao2.findAll();

				// Listをリクエストスコープに入れてJSPへフォワードする
				request.setAttribute("characterList", list2);
				gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");


			// delete
			}else if(action.equals("delete")) {
					int no = Integer.parseInt(request.getParameter("no"));
					dao2.deleteByPrimaryKey(no);
					// 削除後、全レコードを表示
					List<fCharacterBean> list2 = dao2.findAll();
					// Listをリクエストスコープに入れてJSPへフォワードする
					request.setAttribute("characterList", list2);
					gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");


			// search
			}else if(action.equals("search")) {
					int no = Integer.parseInt(request.getParameter("no"));
					List<fCharacterBean> list2 = dao2.findByNo(no);
					// Listをリクエストスコープに入れてJSPへフォワードする
					request.setAttribute("characterList", list2);
					gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");


			// edit(search)
			}else if(action.equals("editSearch")) {
					int editNo = Integer.parseInt(request.getParameter("editNo"));
					List<fCharacterBean> list2 = dao2.editFindByNo(editNo);
					// Listをリクエストスコープに入れてJSPへフォワードする
					request.setAttribute("characterList", list2);
					gotoPage(request,response,"/WEB-INF/fEdit.jsp");


			// edit
			}else if(action.equals("edit")) {
				String name = request.getParameter("name");
				String job = request.getParameter("job");
				String ability = request.getParameter("ability");
				String image = request.getParameter("image");
				String no = request.getParameter("no");


				// 追加後、全レコード表示
				List<fCharacterBean> list2 = dao2.fEditCharacter(no,name,job,ability,image);
				// Listをリクエストスコープに入れてJSPへフォワードする
				request.setAttribute("characterList", list2);
				gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");

			// sort
			}else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<fCharacterBean> list2;
				if(key.equals("no_asc"))
					list2 = dao2.sortNo(true);
				else
					list2 = dao2.sortNo(false);
				// Listをリクエストスコープに入れてJSPへフォワードする
				request.setAttribute("characterList", list2);
				gotoPage(request,response,"/WEB-INF/fCharacterList.jsp");

			}else {
				request.setAttribute("message","正しく操作してください");
				gotoPage(request,response,"/WEB-INF/errInternal.jsp");
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
