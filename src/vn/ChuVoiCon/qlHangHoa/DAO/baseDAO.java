package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class baseDAO<T,T2> extends Connect {	
	protected abstract T convertData(ResultSet rs) throws SQLException;
	protected abstract void addIDParmater(CallableStatement cstm, T2 id) throws SQLException;
	protected abstract void addAllParmaterWithoutID(CallableStatement cstm, T data) throws SQLException;
	protected abstract void addAllParmater(CallableStatement cstm, T data) throws SQLException;

	protected ArrayList<T> getDS(CallableStatement cstm) {
		ArrayList<T> r = null;
		try {
			ResultSet rs = cstm.executeQuery();
			r = new ArrayList<T>();
			while (rs.next()) {
				r.add(convertData(rs));
			}
			rs.close();
			cstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	protected int callProcWithData(String procedure, T data) {
		int r = 0;
		try {
			CallableStatement cstm = getCallableStatement(procedure);
			addAllParmater(cstm, data);
			r = cstm.executeUpdate();
			cstm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
}
