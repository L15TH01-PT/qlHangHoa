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
import vn.ChuVoiCon.qlHangHoa.DLL.nhap_kho;

public class Kho extends JFrame {

	private JPanel contentPane;
	private JTable tbKho;
	/**
	 * @wbp.nonvisual location=26,339
	 */
	private final DefaultTableModel modelKho = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kho frame = new Kho();
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
	public Kho() {
		nhap_khoBUS nk=new nhap_khoBUS();
		setTitle("KHO H\u00C0NG H\u00D3A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 192);
		contentPane.add(scrollPane);
		
		tbKho = new JTable();
		scrollPane.setViewportView(tbKho);
		tbKho.setModel(modelKho);
		String colname[]= {"Mã phiếu", "Ngày lập", "Nhân viên nhập"};
		modelKho.setColumnIdentifiers(colname);
		
		JButton btnNhapKho = new JButton("Nh\u1EADp h\u00E0ng h\u00F3a");
		btnNhapKho.setBounds(10, 217, 153, 23);
		contentPane.add(btnNhapKho);
		
		JButton btnChiTiet = new JButton("Chi ti\u1EBFt nh\u1EADp");
		btnChiTiet.setBounds(173, 217, 122, 23);
		contentPane.add(btnChiTiet);
		
		JButton btnXaPhiu = new JButton("X\u00F3a phi\u1EBFu");
		btnXaPhiu.setBounds(302, 217, 122, 23);
		contentPane.add(btnXaPhiu);
		
		for (nhap_kho a : nk.getDS()) {
			String value[]={a.getMa_phieu_nhap()+"",a.getNgay_lap()+"",a.getId_nv()+""};
			modelKho.addRow(value);
		}
		
	}
	
	private void loadData(){
		
	}
}
