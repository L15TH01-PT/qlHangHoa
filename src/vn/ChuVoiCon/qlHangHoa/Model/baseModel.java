package vn.ChuVoiCon.qlHangHoa.Model;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class baseModel<T,T2> extends Connect {
	abstract String getProcGetAll();
	abstract String getProcGetData();
	abstract String getProcInsert();
	abstract String getProcUpdate();
	
	protected abstract T convertData(ResultSet rs) throws SQLException;

	protected abstract void addIDParmater(CallableStatement cstm, T2 id) throws SQLException;
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
	
	public ArrayList<T> getDS() {
		ArrayList<T> r = null;
		try {
			CallableStatement cstm = getCallableStatement(getProcGetAll());
			r = getDS(cstm);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public T getData(T2 id) {
		T r = null;
		try {
			CallableStatement cstm = getCallableStatement(getProcGetData());
			addIDParmater(cstm, id);
			ResultSet rs = cstm.executeQuery();
			while (rs.next()) {
				r = convertData(rs);
				break;
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
	
	public int add(T data){
		return callProcWithData(getProcInsert(),data);
	}
	public int edit(T data){
		return callProcWithData(getProcUpdate(),data);
	}
}
