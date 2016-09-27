
package vn.ChuVoiCon.qlHangHoa.UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import vn.ChuVoiCon.qlHangHoa.BUS.NhanVienBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FormDangNhap extends JFrame {

	private JPanel contentPane;
	private JLabel lblngNhp;
	private JLabel lblNewLabel;
	private JTextField txtUser;
	private JPasswordField txtPassWord;
	private JLabel lblMtKhu;
	private JButton btnDangNhap;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	NhanVienBUS nvb = new NhanVienBUS();
	private JButton btnThoat;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDangNhap frame = new FormDangNhap();
					frame.setVisible(true);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormDangNhap() {
		setTitle("\u0110\u0103ng Nh\u1EADp");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblngNhp());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxtUser());
		contentPane.add(getTxtPassWord());
		contentPane.add(getLblMtKhu());
		contentPane.add(getBtnDangNhap());
		contentPane.add(getLblTime());
		contentPane.add(getBtnThoat());
		
	}
	private JLabel getLblngNhp() {
		if (lblngNhp == null) {
			lblngNhp = new JLabel("\u0110\u0103ng Nh\u1EADp");
			lblngNhp.setFont(new Font("Cambria Math", Font.BOLD, 20));
			lblngNhp.setForeground(Color.BLACK);
			lblngNhp.setBackground(Color.BLACK);
			lblngNhp.setBounds(153, 11, 129, 58);
		}
		return lblngNhp;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("T\u00E0i Kho\u1EA3n");
			lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			lblNewLabel.setBounds(73, 81, 80, 18);
		}
		return lblNewLabel;
	}
	private JTextField getTxtUser() {
		if (txtUser == null) {
			txtUser = new JTextField();
			txtUser.setBounds(153, 80, 146, 20);
			txtUser.setColumns(10);
		}
		return txtUser;
	}
	private JPasswordField getTxtPassWord() {
		if (txtPassWord == null) {
			txtPassWord = new JPasswordField();
			txtPassWord.setBounds(153, 129, 146, 20);
		}
		return txtPassWord;
	}
	private JLabel getLblMtKhu() {
		if (lblMtKhu == null) {
			lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
			lblMtKhu.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			lblMtKhu.setBounds(73, 132, 67, 14);
		}
		return lblMtKhu;
	}
	
	private JButton getBtnDangNhap() {
		if (btnDangNhap == null) {
			btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
			btnDangNhap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String user = txtUser.getText();
					String pass=String.valueOf(txtPassWord.getPassword());					
//					ArrayList<NhanVien> ds = nvb.getDSNV();
					NhanVien nv = nvb.getNV(user);
//					for (NhanVien nv : ds) {
//						if (user.equals(nv.getMa_nhan_vien()) && pass.equals(nv.getMat_khau())) {
//							FormMainNhanVien fmNhanVien = new FormMainNhanVien(txtUser.getText());
//							fmNhanVien.setVisible(true);
//							setVisible(false);					
//						}else{
////							JOptionPane.showMessageDialog(null, "ThÃ´ng tin khÃ´ng Ä‘Ãºng, vui lÃ²ng kiá»ƒm tra láº¡i");
//							txtPassWord.setText("");
//							txtUser.setText("");
//							JOptionPane.showMessageDialog(null, user);
//							JOptionPane.showMessageDialog(null, pass);
//						}
//						break;					
//					}
					if (user.equals(nv.getMa_nhan_vien()) && pass.equals(nv.getMat_khau())) {
						FormMainNhanVien fmNhanVien = new FormMainNhanVien(txtUser.getText());
						fmNhanVien.setVisible(true);
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Thông tin không chính xác. Xin vui lòng nhập lại.");
						txtPassWord.setText("");
						txtUser.setText("");
						}
					}
			});
			btnDangNhap.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			btnDangNhap.setBounds(73, 177, 111, 23);
		}
		return btnDangNhap;
	}
	private JLabel getLblTime() {
		if (lblTime == null) {
			lblTime = new JLabel("New label");
			lblTime.setBounds(378, 236, 46, 14);
		}
		return lblTime;
	}
	private JButton getBtnThoat() {
		if (btnThoat == null) {
			btnThoat = new JButton("Thoát");
			btnThoat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false); //you can't see me!
					dispose(); //Destroy the JFrame object
				}
			});
			btnThoat.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			btnThoat.setBounds(208, 177, 111, 23);
		}
		return btnThoat;
	}
}
