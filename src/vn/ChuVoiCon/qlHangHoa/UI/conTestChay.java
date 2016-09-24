package vn.ChuVoiCon.qlHangHoa.UI;

import vn.ChuVoiCon.qlHangHoa.BUS.hoa_donBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

public class conTestChay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DemoConnect con = new DemoConnect();
		// for (modelTest data : con.getDS()) {
		// System.out.println(data.getId()+":"+data.getText());
		// }
		// System.out.println("-------------");
		// modelTest t = new modelTest(10,"Nhảm quá");
		// con.add(t);
		// System.out.println(t.getId()+":"+t.getText());

		hoa_donBUS xl = new hoa_donBUS();
//		for (hoa_don item : xl.getDS(1)) {
//			System.out.println(item.getMa_hoa_don() + ":"
//					+ item.getNgay_lap().toString());
//		}
		 hoa_don a = new hoa_don();
		 a.setTen_khach_hang("ABC");
		 a.setId_nv(1);
		 a.setGhi_chu("Test thử");
		 xl.Add(a);
		 //System.out.println(a.getMa_hoa_don()+":"+a.getNgay_lap().toString());
		 hoa_don b = xl.getData(a.getMa_hoa_don());
		 System.out.println(b.getMa_hoa_don()+":"+b.getNgay_lap().toString());
		 xl.Del(a);
	}

}
