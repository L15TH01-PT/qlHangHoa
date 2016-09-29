package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class jfKho extends JInternalFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNhnVin;
	private JLabel lblSLng;
	private JLabel lblnGi;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_1;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnLpPhiu;
	private JButton btnHyPhiu;
	private JButton btnDanhSch;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
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
	public jfKho() {
		setTitle("Phi\u1EBFu Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getBtnLpPhiu());
		contentPane.add(getBtnHyPhiu());
		contentPane.add(getBtnDanhSch());
		contentPane.add(getBtnNewButton());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 300, 150);
			panel.setLayout(null);
			panel.add(getLblNhnVin());
			panel.add(getLblSLng());
			panel.add(getLblnGi());
			panel.add(getTextField());
			panel.add(getTextField_1());
			panel.add(getTextField_2());
		}
		return panel;
	}
	private JLabel getLblNhnVin() {
		if (lblNhnVin == null) {
			lblNhnVin = new JLabel("M\u00E3 phi\u1EBFu");
			lblNhnVin.setBounds(39, 29, 59, 14);
		}
		return lblNhnVin;
	}
	private JLabel getLblSLng() {
		if (lblSLng == null) {
			lblSLng = new JLabel("Ng\u00E0y l\u1EADp");
			lblSLng.setBounds(38, 54, 60, 14);
		}
		return lblSLng;
	}
	private JLabel getLblnGi() {
		if (lblnGi == null) {
			lblnGi = new JLabel("Nh\u00E2n Vi\u00EAn");
			lblnGi.setBounds(39, 79, 59, 14);
		}
		return lblnGi;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setEnabled(false);
			textField.setBounds(112, 26, 140, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEnabled(false);
			textField_1.setColumns(10);
			textField_1.setBounds(112, 51, 140, 20);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEnabled(false);
			textField_2.setColumns(10);
			textField_2.setBounds(112, 76, 140, 20);
		}
		return textField_2;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "D\u1EEF Li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 167, 438, 281);
			panel_1.setLayout(null);
			panel_1.add(getScrollPane());
			panel_1.add(getScrollPane_1());
		}
		return panel_1;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
		}
		return table_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 23, 149, 247);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(169, 24, 259, 246);
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}
	private JButton getBtnLpPhiu() {
		if (btnLpPhiu == null) {
			btnLpPhiu = new JButton("L\u1EADp Phi\u1EBFu");
			btnLpPhiu.setBounds(336, 35, 112, 40);
		}
		return btnLpPhiu;
	}
	private JButton getBtnHyPhiu() {
		if (btnHyPhiu == null) {
			btnHyPhiu = new JButton("H\u1EE7y Phi\u1EBFu");
			btnHyPhiu.setBounds(180, 450, 130, 23);
		}
		return btnHyPhiu;
	}
	private JButton getBtnDanhSch() {
		if (btnDanhSch == null) {
			btnDanhSch = new JButton("Danh s\u00E1ch");
			btnDanhSch.setBounds(336, 86, 112, 40);
		}
		return btnDanhSch;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Xóa 1 Sản phẩm");
			btnNewButton.setBounds(324, 450, 124, 23);
		}
		return btnNewButton;
	}
}
