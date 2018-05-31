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
			// キャラクター一覧をListとして返す
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
			// Noと値の指定
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

	public List<fCharacterBean> findByNo(int leNo) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQLの実行
			String sql = "SELECT * FROM characters WHERE no =?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// Noのセット
			st.setInt(1,leNo);
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
			// キャラクター一覧をListとして返す
			return list2;
		}catch(Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの操作に失敗しました");
		}finally {
			try{
				// リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new fDAOException("リソースの開放に失敗しました");
			}
		}
	}

	public List<fCharacterBean> editFindByNo(int leNo2) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQLの実行
			String sql = "SELECT * FROM characters WHERE no =?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// 値段のセット
			st.setInt(1,leNo2);
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
			// キャラクター一覧をListとして返す
			return list2;
		}catch(Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの操作に失敗しました");
		}finally {
			try{
				// リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
				throw new fDAOException("リソースの開放に失敗しました");
			}
		}
	}

	@SuppressWarnings("resource")
	public List<fCharacterBean>fEditCharacter(String no,String name,String job,String ability,String image) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			// SQL文の作成
			String sql = "UPDATE characters SET name=?,job=?,ability=?,image=? WHERE no=?";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql);
			// Noと値の指定
			st.setString(1, name);
			st.setString(2, job);
			st.setString(3, ability);
			st.setString(4, image);
			st.setString(5,  no);
			// SQLの実行
			st.executeUpdate();

			String sql2 = "SELECT * FROM characters";
			// PreparedStatementオブジェクトの取得
			st = con.prepareStatement(sql2);
			// SQLの実行
			rs = st.executeQuery();
			// 結果の取得および表示
			List<fCharacterBean> list2 = new ArrayList<fCharacterBean>();
			while(rs.next()) {
				String no1 = rs.getString("no"); // コードのカラム名
				String name1 = rs.getString("name");
				String job1 = rs.getString("job");
				String ability1 = rs.getString("ability");
				String image1 = rs.getString("image");
				fCharacterBean bean = new fCharacterBean(no1,name1,job1,ability1,image1);
				list2.add(bean);
			}

			return list2;
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


	public List<fCharacterBean> sortNo(boolean isAscending) throws fDAOException{
		if(con == null)
			getConnection();

		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			// SQL文の作成
			String sql;
			// ソートキーの指定
			if(isAscending)
				sql = "SELECT * FROM characters ORDER BY no";
			else
				sql = "SELECT * FROM characters ORDER BY no desc";
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
			// キャラクター一覧をListとして返す
			return list2;
		}catch (Exception e) {
			e.printStackTrace();
			throw new fDAOException("レコードの操作に失敗しました");
		}finally {
			try {
				// リソースの開放
				if(rs != null)rs.close();
				if(st != null)st.close();
				close();
			}catch(Exception e) {
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
