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
import javax.swing.JScrollBar;

public class LoaiSanPham extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtMaLSP;
	private JTextField txtTenLSP;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JList listLoaiSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoaiSanPham frame = new LoaiSanPham();
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
	public LoaiSanPham() {
		setTitle("B\u1EA3ng Nh\u1EADp Li\u1EC7u Lo\u1EA1i S\u1EA3n Ph\u1EA9m");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getTxtMaLSP());
		contentPane.add(getTxtTenLSP());
		contentPane.add(getBtnThem());
		contentPane.add(getBtnXoa());
		contentPane.add(getBtnSua());
		contentPane.add(getListLoaiSP());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("M\u00E3 lo\u1EA1i s\u1EA3n ph\u1EA9m");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(22, 15, 123, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("T\u00EAn lo\u1EA1i s\u1EA3n ph\u1EA9m");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(22, 44, 123, 14);
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtMaLSP() {
		if (txtMaLSP == null) {
			txtMaLSP = new JTextField();
			txtMaLSP.setBounds(141, 13, 123, 20);
			txtMaLSP.setColumns(10);
		}
		return txtMaLSP;
	}
	private JTextField getTxtTenLSP() {
		if (txtTenLSP == null) {
			txtTenLSP = new JTextField();
			txtTenLSP.setBounds(141, 42, 249, 20);
			txtTenLSP.setColumns(10);
		}
		return txtTenLSP;
	}
	private JButton getBtnThem() {
		if (btnThem == null) {
			btnThem = new JButton("Th\u00EAm");
			btnThem.setBounds(32, 79, 89, 23);
		}
		return btnThem;
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xo\u00E1");
			btnXoa.setBounds(162, 79, 89, 23);
		}
		return btnXoa;
	}
	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.setBounds(289, 79, 89, 23);
		}
		return btnSua;
	}
	private JList getListLoaiSP() {
		if (listLoaiSP == null) {
			listLoaiSP = new JList();
			listLoaiSP.setBounds(22, 113, 368, 103);
		}
		return listLoaiSP;
	}
}
