package vn.ChuVoiCon.qlHangHoa.Model;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DemoConnect extends baseModel<modelTest, Integer> {
	public DemoConnect() {

	}

	@Override
	String getProcGetAll() {
		// TODO Auto-generated method stub
		return "testGetAll()";
	}

	@Override
	String getProcGetData() {
		// TODO Auto-generated method stub
		return "testGetData(?)";
	}

	@Override
	String getProcInsert() {
		// TODO Auto-generated method stub
		return "testInsert(?,?)";
	}

	@Override
	String getProcUpdate() {
		// TODO Auto-generated method stub
		return "testUpdate(?)";
	}

	@Override
	protected modelTest convertData(ResultSet rs) throws SQLException {
		modelTest r = new modelTest();
		r.setId(rs.getInt("id"));
		r.setText(rs.getString("text"));
		return r;
	}

	@Override
	protected void addIDParmater(CallableStatement cstm, Integer id)
			throws SQLException {
		cstm.setInt(1, id);
	}

	@Override
	protected void addAllParmater(CallableStatement cstm, modelTest data)
			throws SQLException {
		cstm.setInt(1, data.getId());
		cstm.setString(2, data.getText());
	}
	@Override
	public int add(modelTest data)
	{

		int r = 0;
		try {
			CallableStatement cstm = getCallableStatement(getProcInsert());
			cstm.registerOutParameter(1, java.sql.Types.INTEGER);
			cstm.setString(2, data.getText());
			r = cstm.executeUpdate();
			data.setId(cstm.getInt(1));
			cstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	// public ArrayList<String> getDS() {
	// ArrayList<String> r = new ArrayList<String>();
	// try {
	// ResultSet rs = executeQuery("SELECT text FROM test");
	// while (rs.next()) {
	// r.add(rs.getString("text"));
	// }
	// rs.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// }
	// return r;
	// }
	//
	// public String getData(String id) {
	// String r = null;
	// try {
	// PreparedStatement ps =
	// getPreparedStatement("SELECT text FROM test where text = ?");
	// ps.setString(1, id);
	// ResultSet rs = executeQuery(ps);
	// while (rs.next()) {
	// r = rs.getString("text");
	// break;
	// }
	// rs.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// }
	// return r;
	// }
	//
	// public int add(String data) {
	// try {
	// PreparedStatement ps =
	// getPreparedStatement("INSERT INTO test VALUE (?)");
	// ps.setString(1, data);
	// return executeUpdate(ps);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return 0;
	// }
	//
	// public int edit(String id,String data) {
	// try {
	// PreparedStatement ps =
	// getPreparedStatement("UPDATE test SET text = ? WHERE text = ?");
	// ps.setString(1, data);
	// ps.setString(2, id);
	// return executeUpdate(ps);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return 0;
	// }
	//
	// public int delete(String id) {
	// try {
	// PreparedStatement ps =
	// getPreparedStatement("DELETE FROM test WHERE text = ?");
	// ps.setString(1, id);
	// return executeUpdate(ps);
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return 0;
	// }
}
