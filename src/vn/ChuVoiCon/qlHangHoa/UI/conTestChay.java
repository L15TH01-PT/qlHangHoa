package vn.ChuVoiCon.qlHangHoa.UI;

import vn.ChuVoiCon.qlHangHoa.DAO.DemoConnect;

public class conTestChay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DemoConnect con = new DemoConnect();
		for (String data : con.getDS()) {
			System.out.println(data);
		}
		System.out.println("-------------");
		String t = "Nhảm quá";
		System.out.println(con.add(t));
		System.out.println(con.getData(t));
		String t2= "Quá nhảm";
		System.out.println(con.edit(t,t2));
		System.out.println(con.getData(t));
		System.out.println(con.getData(t2));
		System.out.println(con.delete(t2));
		System.out.println(con.getData(t2));
	}

}
