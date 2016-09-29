package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.chi_tiet_hoa_donDAO;
import vn.ChuVoiCon.qlHangHoa.DAO.hoa_donDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class hoa_donBUS {
	private hoa_donDAO hdDAO;

	public hoa_donBUS() {
		hdDAO = new hoa_donDAO();
	}

	public ArrayList<hoa_don> getDS() {
		try {
			return hdDAO.getDS();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<hoa_don> getDSEX(int s) {
		try {
			return hdDAO.getDSEX(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<hoa_don> getDS(int id_nv) {
		try {
			return hdDAO.getDS(id_nv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public hoa_don getData(int ma_hoa_don) {
		try {
			return hdDAO.getData(ma_hoa_don);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int Add(hoa_don hd) {
		try {
			return hdDAO.Insert(hd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int Del(int ma_hoa_don) {
		try {
			return hdDAO.Delete(ma_hoa_don);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
