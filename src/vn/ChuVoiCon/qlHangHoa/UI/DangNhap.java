package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
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

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JLabel lblngNhp;
	private JLabel lblNewLabel;
	private JTextField txtTaiKhoan;
	private JPasswordField txtPassWord;
	private JLabel lblMtKhu;
	private JButton btnDangNhap;
	private JLabel lblTime;

	/**
	 * Launch the application.
	 */
	NhanVienBUS nvb = new NhanVienBUS();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setTitle("\u0110\u0103ng Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblngNhp());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTxtTaiKhoan());
		contentPane.add(getTxtPassWord());
		contentPane.add(getLblMtKhu());
		contentPane.add(getBtnDangNhap());
		contentPane.add(getLblTime());
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
	private JTextField getTxtTaiKhoan() {
		if (txtTaiKhoan == null) {
			txtTaiKhoan = new JTextField();
			txtTaiKhoan.setBounds(153, 80, 146, 20);
			txtTaiKhoan.setColumns(10);
		}
		return txtTaiKhoan;
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
					String user = txtTaiKhoan.getText();
					String pass = txtPassWord.getText();
					
					ArrayList<NhanVien> ds = nvb.getDSNV();
					for (NhanVien nv : ds) {
						txtTaiKhoan.setText(nv.getTen_nhan_vien());
						txtPassWord.setText((nv.getLuong()+""));
						user = nv.getLuong()+"";
						break;
						
					}
					
					JOptionPane.showMessageDialog(null,pass);
				}
			});
			btnDangNhap.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			btnDangNhap.setBounds(153, 176, 111, 23);
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
}
