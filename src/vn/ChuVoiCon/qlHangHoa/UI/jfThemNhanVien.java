package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import vn.ChuVoiCon.qlHangHoa.BUS.NhanVienBUS;

import com.toedter.calendar.JDateChooser;

public class jfThemNhanVien extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel label_11;
	private JTextField txtMaNV;
	private JLabel label_12;
	private JTextField txtHoNV;
	private JTextField txtTenNV;
	private JLabel label_13;
	private JLabel label_14;
	private JRadioButton rdoNu;
	private JRadioButton rdoNam;
	private JLabel label_15;
	private JLabel label_16;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JTextField textField_17;
	private JTextField textField_18;
	private JLabel label_20;
	private JLabel label_21;
	private JButton btnThemNV;
	private JComboBox cbo_phongban;
	private JComboBox cbo_chucvu;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfThemNhanVien frame = new jfThemNhanVien();
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
	public jfThemNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnThemNV());
		contentPane.add(getPanel());
		
		ButtonGroup btg = new ButtonGroup();
		btg.add(rdoNam);
		btg.add(rdoNu);
		
		NhanVienBUS nvb = new NhanVienBUS();
		HashMap<Integer, String> hm = new HashMap<>();
		hm = nvb.getAllPhongBan();
		//System.out.println(hm.);
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00EAm Nh\u00E2n Vi\u00EAn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
			panel.setBounds(10, 11, 525, 298);
			panel.setLayout(null);
			panel.add(getLabel_11());
			panel.add(getTxtMaNV());
			panel.add(getLabel_12());
			panel.add(getTxtHoNV());
			panel.add(getTxtTenNV());
			panel.add(getLabel_13());
			panel.add(getLabel_14());
			panel.add(getRdoNu());
			panel.add(getRdoNam());
			panel.add(getLabel_15());
			panel.add(getLabel_16());
			panel.add(getTextField_14());
			panel.add(getTextField_15());
			panel.add(getLabel_17());
			panel.add(getLabel_18());
			panel.add(getLabel_19());
			panel.add(getTextField_17());
			panel.add(getTextField_18());
			panel.add(getLabel_20());
			panel.add(getLabel_21());
			panel.add(getCbo_phongban());
			panel.add(getCbo_chucvu());
			panel.add(getDateChooser());
			
		}
		return panel;
	}
	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("Mã Nhân Viên");
			label_11.setBounds(18, 49, 99, 23);
		}
		return label_11;
	}
	private JTextField getTxtMaNV() {
		if (txtMaNV == null) {
			txtMaNV = new JTextField();
			txtMaNV.setColumns(10);
			txtMaNV.setBounds(122, 49, 141, 23);
		}
		return txtMaNV;
	}
	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("Họ & tên đệm");
			label_12.setBounds(18, 83, 99, 23);
		}
		return label_12;
	}
	private JTextField getTxtHoNV() {
		if (txtHoNV == null) {
			txtHoNV = new JTextField();
			txtHoNV.setColumns(10);
			txtHoNV.setBounds(122, 84, 141, 23);
		}
		return txtHoNV;
	}
	private JTextField getTxtTenNV() {
		if (txtTenNV == null) {
			txtTenNV = new JTextField();
			txtTenNV.setColumns(10);
			txtTenNV.setBounds(370, 83, 141, 23);
		}
		return txtTenNV;
	}
	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("Ngày Sinh");
			label_13.setBounds(290, 117, 77, 23);
		}
		return label_13;
	}
	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("Tên NV");
			label_14.setBounds(290, 83, 92, 23);
		}
		return label_14;
	}
	private JRadioButton getRdoNu() {
		if (rdoNu == null) {
			rdoNu = new JRadioButton("Nữ");
			rdoNu.setBounds(185, 117, 67, 23);
		}
		return rdoNu;
	}
	private JRadioButton getRdoNam() {
		if (rdoNam == null) {
			rdoNam = new JRadioButton("Nam");
			rdoNam.setBounds(123, 117, 60, 23);
		}
		return rdoNam;
	}
	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("Giới tính");
			label_15.setBounds(18, 117, 99, 23);
		}
		return label_15;
	}
	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("Địa chỉ");
			label_16.setBounds(18, 151, 99, 23);
		}
		return label_16;
	}
	private JTextField getTextField_14() {
		if (textField_14 == null) {
			textField_14 = new JTextField();
			textField_14.setColumns(10);
			textField_14.setBounds(122, 152, 389, 23);
		}
		return textField_14;
	}
	private JTextField getTextField_15() {
		if (textField_15 == null) {
			textField_15 = new JTextField();
			textField_15.setColumns(10);
			textField_15.setBounds(122, 186, 141, 23);
		}
		return textField_15;
	}
	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("Điện thoại liên hệ");
			label_17.setBounds(18, 186, 99, 23);
		}
		return label_17;
	}
	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("Tình trạng NV");
			label_18.setBounds(18, 220, 99, 23);
		}
		return label_18;
	}
	private JLabel getLabel_19() {
		if (label_19 == null) {
			label_19 = new JLabel("Phòng ban");
			label_19.setBounds(18, 254, 99, 23);
		}
		return label_19;
	}
	private JTextField getTextField_17() {
		if (textField_17 == null) {
			textField_17 = new JTextField();
			textField_17.setColumns(10);
			textField_17.setBounds(122, 220, 141, 23);
		}
		return textField_17;
	}
	private JTextField getTextField_18() {
		if (textField_18 == null) {
			textField_18 = new JTextField();
			textField_18.setColumns(10);
			textField_18.setBounds(370, 186, 141, 23);
		}
		return textField_18;
	}
	private JLabel getLabel_20() {
		if (label_20 == null) {
			label_20 = new JLabel("Chức vụ");
			label_20.setBounds(290, 220, 59, 23);
		}
		return label_20;
	}
	private JLabel getLabel_21() {
		if (label_21 == null) {
			label_21 = new JLabel("Lương");
			label_21.setBounds(290, 186, 59, 23);
		}
		return label_21;
	}
	private JButton getBtnThemNV() {
		if (btnThemNV == null) {
			btnThemNV = new JButton("Thêm");
			btnThemNV.setBounds(188, 320, 153, 33);
			btnThemNV.setIcon(new ImageIcon("E:\\Programs\\icon\\3xhumed-Mega-Games-Pack-31-Dragon-Age-Origins-new-4.ico"));
		}
		return btnThemNV;
	}
	private JComboBox getCbo_phongban() {
		if (cbo_phongban == null) {
			cbo_phongban = new JComboBox();
			cbo_phongban.setBounds(122, 255, 141, 20);
		}
		return cbo_phongban;
	}
	private JComboBox getCbo_chucvu() {
		if (cbo_chucvu == null) {
			cbo_chucvu = new JComboBox();
			cbo_chucvu.setBounds(370, 221, 141, 20);
		}
		return cbo_chucvu;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("yyyy-MM-dd");
			dateChooser.setBounds(370, 117, 141, 20);
		}
		return dateChooser;
	}
}
