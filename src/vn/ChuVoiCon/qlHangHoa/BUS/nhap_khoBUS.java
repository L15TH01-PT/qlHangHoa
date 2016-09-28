package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.phieu_nhapDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.nhap_kho;


public class nhap_khoBUS {
	private phieu_nhapDAO data;
	
	public nhap_khoBUS(){
		data=new phieu_nhapDAO();
	}
	
	public ArrayList<nhap_kho> getDS() {
		try {
			return data.getDS();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<nhap_kho> getDS(int id_nv) {
		try {
			return data.getDS(id_nv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public nhap_kho getData(int ma_phieu_nhap) {
		try {
			return data.getData(ma_phieu_nhap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int Add(nhap_kho nk) {
		try {
			return data.Insert(nk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int Del(nhap_kho nk) {
		try {
			return data.Delete(nk);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
