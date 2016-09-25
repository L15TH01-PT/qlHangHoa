package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class FormMainNhanVien extends JFrame {

	private JPanel contentPane;

	private static String currentUser;
	private JScrollPane scrollPane;
	private JTable tbleNhanVien;
	private DefaultTableModel NhanVienModel;
	private JLabel lblXinCho;
	private JLabel lblU;
	private JButton btnThemNV;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					FormMainNhanVien frame = new FormMainNhanVien(currentUser);
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
	public FormMainNhanVien(String a) {
		setTitle("Qu\u1EA3n l\u00FD Nh\u00E2n Vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblXinCho());
		contentPane.add(getLblU());
		currentUser = a;
		lblU.setText(currentUser+"!");
		contentPane.add(getBtnThemNV());
		if (!(currentUser.equals("Admin"))) {
			btnThemNV.setEnabled(false);
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 47, 200, 413);
			scrollPane.setViewportView(getTbleNhanVien());
		}
		return scrollPane;
	}
	private JTable getTbleNhanVien() {
		if (tbleNhanVien == null) {
			tbleNhanVien = new JTable();
			
			
		}
		return tbleNhanVien;
	}
	/**
	 * @wbp.nonvisual location=77,59
	 */
	private DefaultTableModel getNhanVienModel() {
		if (NhanVienModel == null) {
			NhanVienModel = new DefaultTableModel();
		}
		return NhanVienModel;
	}
	private JLabel getLblXinCho() {
		if (lblXinCho == null) {
			lblXinCho = new JLabel("Xin ch\u00E0o: ");
			lblXinCho.setBounds(464, 17, 60, 14);
		}
		return lblXinCho;
	}
	private JLabel getLblU() {
		if (lblU == null) {
			lblU = new JLabel("");
			lblU.setBackground(Color.BLUE);
			lblU.setBounds(534, 17, 82, 14);
		}
		return lblU;
	}
	private JButton getBtnThemNV() {
		if (btnThemNV == null) {
			btnThemNV = new JButton("Th\u00EAm");
			btnThemNV.setBounds(254, 44, 89, 23);
		}
		return btnThemNV;
	}
}
