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
import java.awt.Choice;

public class FormMainNhanVien extends JFrame {

	private JPanel contentPane;

	private static String currentUser;
	private JScrollPane scrollPane;
	private JTable tbleNhanVien;
	private DefaultTableModel NhanVienModel;
	private JLabel lblXinCho;
	private JLabel lblU;
	private JButton btnThemNV;
	private JLabel lblNewLabel;
	private JLabel lblPhngBan;
	private Choice choice;
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
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPhngBan());
		contentPane.add(getChoice());
		if (!(currentUser.equals("Admin"))) {
			btnThemNV.setEnabled(false);
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(28, 94, 200, 413);
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
	 * @wbp.nonvisual location=57,19
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Danh S\u00E1ch NH\u00E2n Vi\u00EAn");
			lblNewLabel.setBounds(47, 22, 103, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblPhngBan() {
		if (lblPhngBan == null) {
			lblPhngBan = new JLabel("Ph\u00F2ng ban");
			lblPhngBan.setBounds(10, 48, 60, 14);
		}
		return lblPhngBan;
	}
	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(76, 47, 89, 20);
		}
		return choice;
	}
}
