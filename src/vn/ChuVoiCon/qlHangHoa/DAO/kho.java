package vn.ChuVoiCon.qlHangHoa.DAO;

public class kho extends Connect {
	private String ma_sp;
	private String ma_loai;
	private int tonkho;
	private boolean trangthai;
	
	// -- Constructor --
	public kho() {
		super();
	}

	public kho(String ma_sp, String ma_loai, int tonkho, boolean trangthai) {
		super();
		this.ma_sp = ma_sp;
		this.ma_loai = ma_loai;
		this.tonkho = tonkho;
		this.trangthai = trangthai;
	}

	// -- Getter & Setter --
	public String getMa_sp() {
		return ma_sp;
	}

	public void setMa_loai(String ma_loai) {
		this.ma_loai = ma_loai;
	}

	public int getTonkho() {
		return tonkho;
	}

	public void setTonkho(int tonkho) {
		this.tonkho = tonkho;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	
	
	
}
