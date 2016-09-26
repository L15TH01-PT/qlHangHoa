package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Connect {
	private static Connection con;

	private void khoiTao() {
		//ResourceBundle rb = ResourceBundle.getBundle("dbLocal");
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driver = rb.getString("driver");
		String server = rb.getString("server");
		String user = rb.getString("user");
		String pass = rb.getString("pass");
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
		if (!getConnection().isClosed())
			getConnection().close();
	}

	// Statement
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

	// Trả về số dòng bị ảnh hưởng
	protected int executeUpdate(String sqlQuery) throws SQLException {
		Statement st = getStatement();
		int r = st.executeUpdate(sqlQuery);
		st.close();
		return r;
	}

	// PreparedStatement
	// khi truyền vào tham số
	protected PreparedStatement getPreparedStatement(String sqlQuery)
			throws SQLException {
		return getConnection().prepareStatement(sqlQuery);
	}

	protected PreparedStatement getPreparedStatement(String sqlQuery, int arg0,
			int arg1) throws SQLException {
		return getConnection().prepareStatement(sqlQuery, arg0, arg1);
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

	// CallableStatement
	protected CallableStatement getCallableStatement(String procedure)
			throws SQLException {
		return getConnection().prepareCall("{ CALL " + procedure + " }");
	}

	protected boolean execute(CallableStatement cstm) throws SQLException {
		boolean r = cstm.execute();
		cstm.close();
		return r;
	}

	protected ResultSet executeQuery(CallableStatement cstm)
			throws SQLException {
		return cstm.executeQuery();
	}

	protected int executeUpdate(CallableStatement cstm) throws SQLException {
		int r = cstm.executeUpdate();
		cstm.close();
		return r;
	}

}
