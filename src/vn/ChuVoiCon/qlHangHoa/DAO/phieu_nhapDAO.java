package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.nhap_kho;

public class phieu_nhapDAO extends Connect {
	// Collum name sql
		private final String ma_phieu_nhap = "ma_phieu_nhap";
		private final String ngay_lap = "ngay_lap";
		private final String id_nv = "id_nv";
		private final String ngay_huy = "ngay_huy";
		// Action
		private final String procGetAll = "khoGetALL()";
		private final String procGetAllNV = "nhap_khoGetALLNV(?)";
		private final String procGetData = "nhap_khoGetData(?)";
		private final String procInsert = "nhap_khoInsert(?,?,?,?)";
		private final String procSetHuy = "nhap_khoSetHuy(?)";
		
		protected nhap_kho convertData(ResultSet rs) throws SQLException {
			nhap_kho r = new nhap_kho();
			r.setMa_phieu_nhap(rs.getInt(ma_phieu_nhap));
			r.setNgay_lap(rs.getDate(ngay_lap));
			r.setId_nv(rs.getInt(id_nv));
			r.setNgay_huy(rs.getDate(ngay_huy));
			return r;
		}

		protected void addIDParmater(CallableStatement cstm, int id)
				throws SQLException {
			cstm.setInt(1, id);
		}

		protected void addAllParmater(CallableStatement cstm, nhap_kho data)
				throws SQLException {
			cstm.setInt(1, data.getMa_phieu_nhap());
			cstm.setDate(2, data.getNgay_lap());
			cstm.setDate(3, data.getNgay_huy());
			cstm.setInt(4, data.getId_nv());
			
		}
		protected ArrayList<nhap_kho> getDS(CallableStatement cstm) throws SQLException {
			ResultSet rs = cstm.executeQuery();
			ArrayList<nhap_kho> r = new ArrayList<nhap_kho>();
			while (rs.next()) {
				r.add(convertData(rs));
			}
			rs.close();
			cstm.close();
			return r;
		}
		
		protected nhap_kho getData(CallableStatement cstm) throws SQLException {
			ResultSet rs = cstm.executeQuery();
			nhap_kho r = null;
			if (rs.next()) {
				r = convertData(rs);
			}
			rs.close();
			cstm.close();
			return r;
		}
		
		protected int callProcWithData(String procedure, nhap_kho data) throws SQLException {
			CallableStatement cstm = getCallableStatement(procedure);
			addAllParmater(cstm, data);
			int r = 0;
			r = cstm.executeUpdate();
			cstm.close();
			return r;
		}

		public ArrayList<nhap_kho> getDS() throws SQLException {
			CallableStatement cstm = getCallableStatement(procGetAll);
			return getDS(cstm);
		}

		public ArrayList<nhap_kho> getDS(int id_nv) throws SQLException {
			CallableStatement cstm = getCallableStatement(procGetAllNV);
			cstm.setInt(1, id_nv);
			return getDS(cstm);
		}

		public nhap_kho getData(int ma_phieu_nhap) throws SQLException {
			CallableStatement cstm = null;
			cstm = getCallableStatement(procGetData);
			cstm.setInt(1, ma_phieu_nhap);
			return getData(cstm);
		}

		public int Insert(nhap_kho nk) throws SQLException {
			CallableStatement cstm = getCallableStatement(procInsert);
			cstm.setInt(1, nk.getMa_phieu_nhap());
			cstm.registerOutParameter(2,  java.sql.Types.DATE);
			cstm.registerOutParameter(3, null);
			cstm.setInt(4, nk.getId_nv());
			int r = cstm.executeUpdate();
			cstm.close();
			return r;
		}

		public int Delete(nhap_kho nk) throws SQLException {
			CallableStatement cstm = getCallableStatement(procSetHuy);
			addIDParmater(cstm, nk.getMa_phieu_nhap());
			//cstm.setDate(2, hd.getNgay_huy());
			return executeUpdate(cstm);
		}
}
