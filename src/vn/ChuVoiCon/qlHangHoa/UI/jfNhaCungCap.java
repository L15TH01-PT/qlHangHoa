package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class jfNhaCungCap extends JFrame {

	private JPanel contentPane;
	private JLabel lblMNhCung;
	private JLabel lblTnNhCung;
	private JLabel lblNgiLinH;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtNguoiLienHe;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JList listNCC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfNhaCungCap frame = new jfNhaCungCap();
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
	public jfNhaCungCap() {
		setTitle("Nh\u1EADp Li\u1EC7u Nh\u00E0 Cung C\u1EA5p");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMNhCung());
		contentPane.add(getLblTnNhCung());
		contentPane.add(getLblNgiLinH());
		contentPane.add(getLblSinThoi());
		contentPane.add(getLblaCh());
		contentPane.add(getTxtMaNCC());
		contentPane.add(getTxtTenNCC());
		contentPane.add(getTxtNguoiLienHe());
		contentPane.add(getTxtSoDT());
		contentPane.add(getTxtDiaChi());
		contentPane.add(getBtnThem());
		contentPane.add(getBtnXoa());
		contentPane.add(getBtnSua());
		contentPane.add(getListNCC());
	}

	private JLabel getLblMNhCung() {
		if (lblMNhCung == null) {
			lblMNhCung = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
			lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMNhCung.setBounds(12, 9, 116, 14);
		}
		return lblMNhCung;
	}
	private JLabel getLblTnNhCung() {
		if (lblTnNhCung == null) {
			lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
			lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTnNhCung.setBounds(12, 34, 116, 14);
		}
		return lblTnNhCung;
	}
	private JLabel getLblNgiLinH() {
		if (lblNgiLinH == null) {
			lblNgiLinH = new JLabel("Ng\u01B0\u1EDDi Li\u00EAn H\u1EC7");
			lblNgiLinH.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNgiLinH.setBounds(12, 59, 91, 14);
		}
		return lblNgiLinH;
	}
	private JLabel getLblSinThoi() {
		if (lblSinThoi == null) {
			lblSinThoi = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
			lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSinThoi.setBounds(12, 84, 93, 14);
		}
		return lblSinThoi;
	}
	private JLabel getLblaCh() {
		if (lblaCh == null) {
			lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9 NCC");
			lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblaCh.setBounds(12, 111, 91, 14);
		}
		return lblaCh;
	}
	private JTextField getTxtMaNCC() {
		if (txtMaNCC == null) {
			txtMaNCC = new JTextField();
			txtMaNCC.setBounds(138, 7, 128, 20);
			txtMaNCC.setColumns(10);
		}
		return txtMaNCC;
	}
	private JTextField getTxtTenNCC() {
		if (txtTenNCC == null) {
			txtTenNCC = new JTextField();
			txtTenNCC.setBounds(138, 32, 325, 20);
			txtTenNCC.setColumns(10);
		}
		return txtTenNCC;
	}
	private JTextField getTxtNguoiLienHe() {
		if (txtNguoiLienHe == null) {
			txtNguoiLienHe = new JTextField();
			txtNguoiLienHe.setBounds(138, 57, 221, 20);
			txtNguoiLienHe.setColumns(10);
		}
		return txtNguoiLienHe;
	}
	private JTextField getTxtSoDT() {
		if (txtSoDT == null) {
			txtSoDT = new JTextField();
			txtSoDT.setBounds(138, 82, 221, 20);
			txtSoDT.setColumns(10);
		}
		return txtSoDT;
	}
	private JTextField getTxtDiaChi() {
		if (txtDiaChi == null) {
			txtDiaChi = new JTextField();
			txtDiaChi.setBounds(138, 109, 325, 20);
			txtDiaChi.setColumns(10);
		}
		return txtDiaChi;
	}
	private JButton getBtnThem() {
		if (btnThem == null) {
			btnThem = new JButton("Th\u00EAm");
			btnThem.setBounds(473, 10, 89, 38);
		}
		return btnThem;
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xo\u00E1");
			btnXoa.setBounds(473, 49, 89, 38);
		}
		return btnXoa;
	}
	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.setBounds(473, 88, 89, 38);
		}
		return btnSua;
	}
	private JList getListNCC() {
		if (listNCC == null) {
			listNCC = new JList();
			listNCC.setBounds(10, 136, 569, 193);
		}
		return listNCC;
	}
}
