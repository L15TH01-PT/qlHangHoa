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
		String colname[]= {"Mã sản phẩm","Mã loại","Nhà cung cấp","Tên Sản Phẩm","Nội dung", "Bảo hành"};
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
	}
	
	private void loadData(){
		
	}
}
