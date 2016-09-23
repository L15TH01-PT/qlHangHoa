package vn.ChuVoiCon.qlHangHoa.DAO;

public class modelTest {
	private int  id;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public modelTest() {
		super();
	}
	public modelTest(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
}
