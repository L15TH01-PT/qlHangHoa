package vn.ChuVoiCon.qlHangHoa.BUS;

import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DAO.hoa_donDAO;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class hoa_donBUS {
	private hoa_donDAO data;

	public hoa_donBUS() {
		data = new hoa_donDAO();
	}

	public ArrayList<hoa_don> getDS() {
		try {
			return data.getDS();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<hoa_don> getDS(int id_nv) {
		try {
			return data.getDS(id_nv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public hoa_don getData(long ma_hoa_don) {
		try {
			return data.getData(ma_hoa_don);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int Add(hoa_don hd) {
		try {
			return data.Insert(hd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int Del(hoa_don hd) {
		try {
			return data.Delete(hd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
