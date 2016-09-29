package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import vn.ChuVoiCon.qlHangHoa.BUS.nhap_khoBUS;

public class jrPhieuNhap extends JFrame {

	private JPanel contentPane;
	private JTable tbPhieu;
	private JTable tbChiTiet;
	private nhap_khoBUS nkb=new nhap_khoBUS(); 
	/**
	 * @wbp.nonvisual location=106,109
	 */
	private final DefaultTableModel modelPhieu = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=466,99
	 */
	private final DefaultTableModel modelChiTiet = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jrPhieuNhap frame = new jrPhieuNhap();
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
	public jrPhieuNhap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 343, 143);
		contentPane.add(scrollPane);
		
		tbPhieu = new JTable();
		scrollPane.setViewportView(tbPhieu);
		tbPhieu.setModel(modelPhieu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 11, 440, 144);
		contentPane.add(scrollPane_1);
		
		tbChiTiet = new JTable();
		scrollPane_1.setViewportView(tbChiTiet);
		tbChiTiet.setModel(modelChiTiet);
		
		JButton btnLpPhiu = new JButton("L\u1EADp phi\u1EBFu");
		btnLpPhiu.setBounds(10, 164, 89, 23);
		contentPane.add(btnLpPhiu);
		
		JButton btnHyPhiu = new JButton("H\u1EE7y Phi\u1EBFu");
		btnHyPhiu.setBounds(107, 164, 104, 23);
		contentPane.add(btnHyPhiu);
	}

}
