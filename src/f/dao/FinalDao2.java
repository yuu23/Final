package f.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinalDao2 {
	public List<String> findAll(){
		PreparedStatement st = null;
		ResultSet rs = null;

	try {
		// 2.DBから名前とパス取得
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost/final?serverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";

			Connection con = DriverManager.getConnection(url,user,pass);

			// SQL文の作成
			String sql = "SELECT * FROM characters";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			List<String> list2 = new ArrayList<String>();
			while(rs.next()) {
				String no = rs.getString("no"); // コードのカラム名
				String name = rs.getString("name");
				String job = rs.getString("job");
				String ability = rs.getString("ability");
				list2.add(no);
				list2.add(name);
				list2.add(job);
				list2.add(ability);
			}
			return list2;
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
}
