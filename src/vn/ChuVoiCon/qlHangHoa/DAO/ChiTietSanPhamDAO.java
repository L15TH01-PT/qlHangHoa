package vn.ChuVoiCon.qlHangHoa.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;

public class ChiTietSanPhamDAO extends Connect{
	public ArrayList<chi_tiet_san_pham> getDSCTSP(){
		ArrayList<chi_tiet_san_pham> arrCTSP = new ArrayList<chi_tiet_san_pham>();
		try {
			PreparedStatement ps=getPreparedStatement("select *,ten_loai from chi_tiet_san_pham ctsp, loai_san_pham lsp where ctsp.id_loai=lsp.id_loai");
			ResultSet rs=executeQuery(ps);
			while(rs.next()) {
				chi_tiet_san_pham ctsp=new chi_tiet_san_pham();
				ctsp.setId_sp(rs.getString("id_sp"));
				ctsp.setId_loai(rs.getString("id_loai"));
				ctsp.setTen_loai(rs.getString("ten_loai"));
				ctsp.setId_ncc(rs.getString("id_ncc"));
				ctsp.setTen_sp(rs.getString("ten_sp"));
				ctsp.setNoi_dung(rs.getString("noi_dung"));
				ctsp.setBao_hanh(rs.getInt("bao_hanh"));
				ctsp.setDon_vi_tinh(rs.getString("don_vi_tinh"));
				arrCTSP.add(ctsp);
			}
			rs.close();
			ps.close();
			return arrCTSP;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
