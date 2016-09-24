package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class baseDAO<T,T2> extends Connect {	
	protected abstract T convertData(ResultSet rs) throws SQLException;
	protected abstract void addIDParmater(CallableStatement cstm, T2 id) throws SQLException;
	protected abstract void addAllParmater(CallableStatement cstm, T data) throws SQLException;

	protected ArrayList<T> getDS(CallableStatement cstm) throws SQLException {
		ResultSet rs = cstm.executeQuery();
		ArrayList<T> r = new ArrayList<T>();
		while (rs.next()) {
			r.add(convertData(rs));
		}
		rs.close();
		cstm.close();
		return r;
	}
	
	protected T getData(CallableStatement cstm) throws SQLException {
		ResultSet rs = cstm.executeQuery();
		T r = null;
		if (rs.next()) {
			r = convertData(rs);
		}
		rs.close();
		cstm.close();
		return r;
	}
	
	protected int callProcWithData(String procedure, T data) throws SQLException {
		CallableStatement cstm = getCallableStatement(procedure);
		addAllParmater(cstm, data);
		int r = 0;
		r = cstm.executeUpdate();
		cstm.close();
		return r;
	}
}
