package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JList;

public class jfChiTietSanPham extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtMaSP;
	private JComboBox cboMaLSP;
	private JComboBox cboMaNCC;
	private JLabel lblTnSnPhm;
	private JLabel lblThngBoHnh;
	private JLabel lblNiDungSn;
	private JTextField txtTenSP;
	private JTextField txtBaoHanh;
	private JTextPane txtpNoiDung;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnNhapLai;
	private JList listHangHoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfChiTietSanPham frame = new jfChiTietSanPham();
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
	public jfChiTietSanPham() {
		setTitle("Ch\u01B0\u01A1ng Tr\u00ECnh Qu\u1EA3n L\u00FD H\u00E0ng Ho\u00E1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTxtMaSP());
		contentPane.add(getCboMaLSP());
		contentPane.add(getCboMaNCC());
		contentPane.add(getLblTnSnPhm());
		contentPane.add(getLblThngBoHnh());
		contentPane.add(getLblNiDungSn());
		contentPane.add(getTxtTenSP());
		contentPane.add(getTxtBaoHanh());
		contentPane.add(getTxtpNoiDung());
		contentPane.add(getBtnThem());
		contentPane.add(getBtnXoa());
		contentPane.add(getBtnSua());
		contentPane.add(getBtnNhapLai());
		contentPane.add(getListHangHoa());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("M\u00E3 S\u1EA3n Ph\u1EA9m");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(10, 11, 85, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("M\u00E3 LSP");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(230, 11, 46, 14);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("M\u00E3 NCC");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(413, 11, 46, 14);
		}
		return lblNewLabel_2;
	}
	private JTextField getTxtMaSP() {
		if (txtMaSP == null) {
			txtMaSP = new JTextField();
			txtMaSP.setBounds(94, 9, 119, 20);
			txtMaSP.setColumns(10);
		}
		return txtMaSP;
	}
	private JComboBox getCboMaLSP() {
		if (cboMaLSP == null) {
			cboMaLSP = new JComboBox();
			cboMaLSP.setBounds(279, 9, 119, 20);
		}
		return cboMaLSP;
	}
	private JComboBox getCboMaNCC() {
		if (cboMaNCC == null) {
			cboMaNCC = new JComboBox();
			cboMaNCC.setBounds(469, 9, 144, 20);
		}
		return cboMaNCC;
	}
	private JLabel getLblTnSnPhm() {
		if (lblTnSnPhm == null) {
			lblTnSnPhm = new JLabel("T\u00EAn S\u1EA3n Ph\u1EA9m");
			lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTnSnPhm.setBounds(10, 36, 85, 14);
		}
		return lblTnSnPhm;
	}
	private JLabel getLblThngBoHnh() {
		if (lblThngBoHnh == null) {
			lblThngBoHnh = new JLabel("Th\u00E1ng B\u1EA3o H\u00E0nh");
			lblThngBoHnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblThngBoHnh.setBounds(10, 61, 100, 14);
		}
		return lblThngBoHnh;
	}
	private JLabel getLblNiDungSn() {
		if (lblNiDungSn == null) {
			lblNiDungSn = new JLabel("N\u1ED9i Dung S\u1EA3n Ph\u1EA9m");
			lblNiDungSn.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNiDungSn.setBounds(10, 86, 130, 14);
		}
		return lblNiDungSn;
	}
	private JTextField getTxtTenSP() {
		if (txtTenSP == null) {
			txtTenSP = new JTextField();
			txtTenSP.setBounds(104, 34, 509, 20);
			txtTenSP.setColumns(10);
		}
		return txtTenSP;
	}
	private JTextField getTxtBaoHanh() {
		if (txtBaoHanh == null) {
			txtBaoHanh = new JTextField();
			txtBaoHanh.setBounds(114, 59, 162, 20);
			txtBaoHanh.setColumns(10);
		}
		return txtBaoHanh;
	}
	private JTextPane getTxtpNoiDung() {
		if (txtpNoiDung == null) {
			txtpNoiDung = new JTextPane();
			txtpNoiDung.setBounds(10, 104, 603, 130);
		}
		return txtpNoiDung;
	}
	private JButton getBtnThem() {
		if (btnThem == null) {
			btnThem = new JButton("Th\u00EAm");
			btnThem.setBounds(62, 245, 89, 23);
		}
		return btnThem;
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xo\u00E1");
			btnXoa.setBounds(195, 245, 89, 23);
		}
		return btnXoa;
	}
	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.setBounds(339, 245, 89, 23);
		}
		return btnSua;
	}
	private JButton getBtnNhapLai() {
		if (btnNhapLai == null) {
			btnNhapLai = new JButton("Nh\u1EADp L\u1EA1i");
			btnNhapLai.setBounds(477, 245, 89, 23);
		}
		return btnNhapLai;
	}
	private JList getListHangHoa() {
		if (listHangHoa == null) {
			listHangHoa = new JList();
			listHangHoa.setBounds(10, 279, 603, 227);
		}
		return listHangHoa;
	}
}
