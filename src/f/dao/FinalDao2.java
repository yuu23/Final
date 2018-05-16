package f.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import f.bean.fCharacterBean;

public class FinalDao2 {
	private Connection con;

	public FinalDao2() throws fDAOException {
		getConnection();
	}

	public List<fCharacterBean> findAll() throws fDAOException{

		// 下記のif文がtrueなら、「{」がなくても実行される
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "SELECT * FROM characters";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<fCharacterBean> list2 = new ArrayList<fCharacterBean>();
			while(rs.next()) {
				String no = rs.getString("no"); // コードのカラム名
				String name = rs.getString("name");
				String job = rs.getString("job");
				String ability = rs.getString("ability");
				String image = rs.getString("image");
				fCharacterBean bean = new fCharacterBean(no,name,job,ability,image);
				list2.add(bean);
			}
			// 商品一覧をListとして返す
			return list2;
		}catch(Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの取得に失敗しました。");
		}finally { // エラーが起きても絶対実行される
			try {
				// リソースの開放
				if(rs != null)rs.close();
				if(rs != null)st.close();
				close();
			}catch (Exception e) {
				throw new fDAOException("リソースの開放に失敗しました。");
			}
		}
	}

	public int fAddCharacter(String no,String name,String job,String ability,String image) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "INSERT INTO characters(no,name,job,ability,image)VALUES(?,?,?,?,?)";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 商品名と値段の指定
			st.setString(1, no);
			st.setString(2, name);
			st.setString(3, job);
			st.setString(4, ability);
			st.setString(5, image);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new fDAOException("リソースの開放に失敗しました");
			}
		}
	}

	public int deleteByPrimaryKey(int key) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		try {
			// SQL文の作成
			String sql = "DELETE FROM characters WHERE no = ?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 主キーの指定
			st.setInt(1, key);
			// SQLの実行
			int rows = st.executeUpdate();
			return rows;
		}catch(Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(st != null)st.close();
				close();
			}catch (Exception e) {
				throw new fDAOException("リソースの開放に失敗しました");
			}
		}
	}

	private void getConnection() throws fDAOException{
		try {
			// JDBCドライバの登録
			Class.forName("com.mysql.cj.jdbc.Driver");
			// URL、ユーザー名、パスワードの設定
			String url = "jdbc:mysql://localhost/final?serverTimezone=UTC&useSSL=false";
			String user = "student";
			String pass = "himitu";
			// データベースへの接続
			con = DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			throw new fDAOException("接続に失敗しました。");
		}
	}

	private void close() throws SQLException{
		if(con != null) {
			con.close();
			con = null;
		}
	}
}
