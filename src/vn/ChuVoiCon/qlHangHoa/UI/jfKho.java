package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class jfKho extends JFrame {

	private JPanel contentPane;
	private JTable tbSanPham;
	private JTable tbCTPhieu;
	private JTextField txtSL;
	private JTextField txtDG;
	/**
	 * @wbp.nonvisual location=336,159
	 */
	private final DefaultTableModel ModelSanPham = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=326,339
	 */
	private final DefaultTableModel ModelPhieu = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfKho frame = new jfKho();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 6, 794, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLoi = new JLabel("Loại");
		lblLoi.setBounds(10, 45, 46, 14);
		panel.add(lblLoi);
		
		JLabel lblNhCungCp = new JLabel("Nhà cung cấp");
		lblNhCungCp.setBounds(10, 82, 82, 14);
		panel.add(lblNhCungCp);
		
		JComboBox cbxLoai = new JComboBox();
		cbxLoai.setBounds(102, 42, 102, 20);
		panel.add(cbxLoai);
		
		JComboBox cbxNcc = new JComboBox();
		cbxNcc.setBounds(102, 79, 102, 20);
		panel.add(cbxNcc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 29, 556, 222);
		panel.add(scrollPane);
		
		tbSanPham = new JTable();
		scrollPane.setViewportView(tbSanPham);
		
		JButton btnChon = new JButton("Chọn");
		btnChon.setBounds(122, 110, 72, 23);
		panel.add(btnChon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 274, 794, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(231, 11, 452, 116);
		panel_1.add(scrollPane_1);
		
		tbCTPhieu = new JTable();
		scrollPane_1.setViewportView(tbCTPhieu);
		
		JButton btnLap = new JButton("Lập Phiếu");
		btnLap.setBounds(693, 11, 101, 23);
		panel_1.add(btnLap);
		
		JButton btnHuy = new JButton("Hủy Phiếu");
		btnHuy.setBounds(693, 45, 101, 23);
		panel_1.add(btnHuy);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setBounds(10, 15, 46, 14);
		panel_1.add(lblSLng);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setBounds(10, 54, 46, 14);
		panel_1.add(lblnGi);
		
		txtSL = new JTextField();
		txtSL.setBounds(61, 12, 75, 20);
		panel_1.add(txtSL);
		txtSL.setColumns(10);
		
		txtDG = new JTextField();
		txtDG.setColumns(10);
		txtDG.setBounds(61, 46, 75, 20);
		panel_1.add(txtDG);
		
		
	}
}
