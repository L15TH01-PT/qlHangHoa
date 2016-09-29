package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;
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

		public ArrayList<NhanVien> getDSNV() {
			ArrayList<NhanVien> arrNhanVien = new ArrayList<NhanVien>();
			try {
				// ResultSet rs =
				// executeQuery("select * from nhan_vien where id ="+1);
				// PreparedStatement ps =
				// getPreparedStatement("select * from nhan_vien where id =?");
				// ps.setInt(1, 1);
				PreparedStatement ps = getPreparedStatement("select * from nhan_vien");
				ResultSet rs = executeQuery(ps);
				while (rs.next()) {
					NhanVien nv = new NhanVien();
					nv.setId(rs.getInt("id"));
					nv.setMa_nhan_vien(rs.getString("ma_nhan_vien"));
					nv.setTen_nhan_vien(rs.getString("ho_nhan_vien"));
					nv.setHo_nhan_vien(rs.getString("ten_nhan_vien"));
					nv.setPhai(rs.getBoolean("phai"));
					nv.setNgay_sinh(rs.getDate("ngay_sinh"));
					nv.setLuong(rs.getInt("luong"));
					nv.setDia_chi(rs.getString("dia_chi"));
					nv.setMa_phong_ban(rs.getInt("ma_phong_ban"));
					nv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
					nv.setTrang_thai(rs.getByte("trang_thai"));
					nv.setDien_thoai(rs.getString("dien_thoai"));
					nv.setMat_khau(rs.getString("mat_khau"));
					nv.setTrang_thai(rs.getInt("trang_thai"));
					arrNhanVien.add(nv);

				}
				rs.close();
				ps.close();
				return arrNhanVien;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public ArrayList<nhap_kho> getPhieu() {
			ArrayList<nhap_kho> arrNhapKho = new ArrayList<nhap_kho>();
			try {
				PreparedStatement ps = getPreparedStatement("select * from phieu_nhap");
			
				ResultSet rs = executeQuery(ps);
				if (rs.next()) {
					nhap_kho nk=new nhap_kho();
					nk.setMa_phieu_nhap(rs.getInt(1));
					nk.setNgay_lap(rs.getDate(2));
					nk.setId_nv(rs.getInt(3));
					nk.setNgay_huy(rs.getDate(4));
					arrNhapKho.add(nk);
				}
				rs.close();
				ps.close();
				return arrNhapKho;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

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
