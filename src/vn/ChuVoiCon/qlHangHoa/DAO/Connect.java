package vn.ChuVoiCon.qlHangHoa.DAO;

import java.util.ResourceBundle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private static Connection con;

	private void khoiTao() {
		String driver = ResourceBundle.getBundle("db").getString("driver");
		String server = ResourceBundle.getBundle("db").getString("server");
		String user = ResourceBundle.getBundle("db").getString("user");
		String pass = ResourceBundle.getBundle("db").getString("pass");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(server, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected Connection getConnection() throws SQLException {
		if (con == null)
			khoiTao();
		return con;
	}

	protected void close() throws SQLException {
		if(!getConnection().isClosed())
			getConnection().close();
	}
// để s/d dc sql, phải get statement
	protected Statement getStatement() throws SQLException {
		return getConnection().createStatement();
	}
// get statement là 1 dạng lấy ra DL
	protected Statement getStatement(int arg0, int arg1) throws SQLException {
		return getConnection().createStatement(arg0, arg1);
	}

	protected boolean execute(String sqlQuery) throws SQLException {
		Statement st = getStatement();
		boolean r = st.execute(sqlQuery);
		st.close();
		return r;
	}
// thực truy vấn CSDL
	protected ResultSet executeQuery(String sqlQuery) throws SQLException {
		return getStatement().executeQuery(sqlQuery);
	}

	protected ResultSet executeQuery(String sqlQuery, int arg0, int arg1)
			throws SQLException {
		return getStatement(arg0, arg1).executeQuery(sqlQuery);
	}

//	Trả về số dòng bị ảnh hưởng
	protected int executeUpdate(String sqlQuery) throws SQLException {
		Statement st = getStatement();
		int r = st.executeUpdate(sqlQuery);
		st.close();
		return r;
	}
// khi truyền vào tham số 
	protected PreparedStatement getPreparedStatement(String sqlQuery)
			throws SQLException {
		return con.prepareStatement(sqlQuery);
	}

	protected PreparedStatement getPreparedStatement(String sqlQuery, int arg0,
			int arg1) throws SQLException {
		return con.prepareStatement(sqlQuery, arg0, arg1);
	}

	protected boolean execute(PreparedStatement pstm) throws SQLException {
		boolean r = pstm.execute();
		pstm.close();
		return r;
	}

	protected ResultSet executeQuery(PreparedStatement pstm)
			throws SQLException {
		return pstm.executeQuery();
	}

	protected int executeUpdate(PreparedStatement pstm) throws SQLException {
		int r = pstm.executeUpdate();
		pstm.close();
		return r;
	}

	// private String driver;
	// private String server;
	// private String user;
	// private String pass;
	//
	// public String getDriver() {
	// return driver;
	// }
	// public void setDriver(String driver) {
	// this.driver = driver;
	// }
	// public String getServer() {
	// return server;
	// }
	// public void setServer(String server) {
	// this.server = server;
	// }
	// public String getUser() {
	// return user;
	// }
	// public void setUser(String user) {
	// this.user = user;
	// }
	// public String getPass() {
	// return pass;
	// }
	// public void setPass(String pass) {
	// this.pass = pass;
	// }
	// public Connect(String driver, String server, String user, String pass) {
	// super();
	// this.driver = driver;
	// this.server = server;
	// this.user = user;
	// this.pass = pass;
	// }
	// public Connect() {
	// super();
	// }
	// @Override
	// public String toString() {
	// return "Connect [driver=" + driver + ", server=" + server + ", user="
	// + user + ", pass=" + pass + "]";
	// }

	// public void connectDB(){
	// this.driver = ResourceBundle.getBundle("db").getString(getDriver());
	// this.server = ResourceBundle.getBundle("db").getString(getServer());
	// this.user = ResourceBundle.getBundle("db").getString(getUser());
	// this.pass = ResourceBundle.getBundle("db").getString(getPass());
	//
	// }

}
