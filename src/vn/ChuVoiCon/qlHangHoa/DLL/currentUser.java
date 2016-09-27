package vn.ChuVoiCon.qlHangHoa.DLL;

public class currentUser {
	private static int id = -1;
	private static String tennv;
	private static boolean isAdmin;

	public static boolean isAdmin() {
		return isAdmin;
	}

	public static void setAdmin(boolean isAdmin) {
		currentUser.isAdmin = isAdmin;
	}

	public static String getTennv() {
		return tennv;
	}

	public static void setTennv(String tennv) {
		currentUser.tennv = tennv;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		currentUser.id = id;
	}
	
}
