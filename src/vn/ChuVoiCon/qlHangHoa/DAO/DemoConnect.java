package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemoConnect extends Connect {
	public ArrayList<String> getDS() {
		ArrayList<String> r = new ArrayList<String>();
		try {
			ResultSet rs = executeQuery("SELECT text FROM test");
			while (rs.next()) {
				r.add(rs.getString("text"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return r;
	}

	public String getData(String id) {
		String r = null;
		try {
			PreparedStatement ps = getPreparedStatement("SELECT text FROM test where text = ?");//
			ps.setString(1, id);
			ResultSet rs = executeQuery(ps);
			while (rs.next()) {
				r = rs.getString("text");
				break;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return r;
	}

	public int add(String data) {
		try {
			PreparedStatement ps = getPreparedStatement("INSERT INTO test VALUE (?)");
			ps.setString(1, data);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int edit(String id,String data) {
		try {
			PreparedStatement ps = getPreparedStatement("UPDATE test SET text = ? WHERE text = ?");
			ps.setString(1, data);
			ps.setString(2, id);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String id) {
		try {
			PreparedStatement ps = getPreparedStatement("DELETE FROM test WHERE text = ?");
			ps.setString(1, id);
			return executeUpdate(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
