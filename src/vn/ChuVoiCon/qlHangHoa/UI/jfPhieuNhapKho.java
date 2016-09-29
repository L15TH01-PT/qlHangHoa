package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import vn.ChuVoiCon.qlHangHoa.BUS.nhap_khoBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.nhap_kho;

public class jfPhieuNhapKho extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelPNK;

	nhap_khoBUS nkb=new nhap_khoBUS();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfPhieuNhapKho frame = new jfPhieuNhapKho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public jfPhieuNhapKho() throws SQLException {
		setTitle("Phi\u1EBFu \u0110\u00E3 Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		showDSPhieu();
	}
	
	public void showDSPhieu() throws SQLException{
		for(nhap_kho a : nkb.getDS()){
			Object ob[] =new Object[]{a.getMa_phieu_nhap(),a.getNgay_lap(),a.getId_nv()};
			modelPNK.addRow(ob);
		}
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setModel(getModelPNK());
		}
		return table;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 155);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	/**
	 * @wbp.nonvisual location=66,119
	 */
	private DefaultTableModel getModelPNK() {
		if (modelPNK == null) {
			modelPNK = new DefaultTableModel();
			String colsname[]={"Mã phiếu nhập","Ngày lập","Nhân viên nhập phiếu"};
			modelPNK.setColumnIdentifiers(colsname);
		}
		return modelPNK;
	}
}
