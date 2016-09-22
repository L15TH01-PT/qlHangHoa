package vn.ChuVoiCon.qlHangHoa.Model;

import java.util.ResourceBundle;

public class Connect {

	private String driver;
	private String server;
	private String user;
	private String pass;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Connect(String driver, String server, String user, String pass) {
		super();
		this.driver = driver;
		this.server = server;
		this.user = user;
		this.pass = pass;
	}
	public Connect() {
		super();
	}
	@Override
	public String toString() {
		return "Connect [driver=" + driver + ", server=" + server + ", user="
				+ user + ", pass=" + pass + "]";
	}

	public void connectDB(){
		this.driver = ResourceBundle.getBundle("db").getString(getDriver());
		this.server = ResourceBundle.getBundle("db").getString(getServer());
		this.user = ResourceBundle.getBundle("db").getString(getUser());
		this.pass = ResourceBundle.getBundle("db").getString(getPass());
		
	}

}
