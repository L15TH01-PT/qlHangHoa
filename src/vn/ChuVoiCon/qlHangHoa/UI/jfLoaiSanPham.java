package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vn.ChuVoiCon.qlHangHoa.BUS.LoaiSanPhamBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfLoaiSanPham extends JFrame {

	private ArrayList<loai_san_pham> arrLSP=new ArrayList<loai_san_pham>();
	LoaiSanPhamBUS lspb=new LoaiSanPhamBUS();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtMaLSP;
	private JTextField txtTenLSP;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JScrollPane scrollPane;
	private JTable tableLSP;
	private DefaultTableModel dtmLSP;
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
	public jfLoaiSanPham() {
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
		contentPane.add(getScrollPane());
		
		arrLSP=lspb.getDSLSP();
		for (loai_san_pham lspham : arrLSP){
			Object data[]=new Object[]{
					lspham.getId_loai(), lspham.getTen_loai()
			};
			dtmLSP.addRow(data);
		}
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
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String a=txtMaLSP.getText();
					String b=txtTenLSP.getText();
					lspb.addLSP(a, b);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					getJTable();
				}
			});
			btnThem.setBounds(32, 79, 89, 23);
		}
		return btnThem;
	}
	private void getJTable(){
		arrLSP=lspb.getDSLSP();
		while(getDtmLSP().getRowCount() > 0)
		{
			getDtmLSP().removeRow(0);
		}
		for (loai_san_pham lspham : arrLSP){
			Object data[]=new Object[]{
					lspham.getId_loai(), lspham.getTen_loai()
			};
			getDtmLSP().addRow(data);
		}
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xo\u00E1");
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tableLSP.getSelectedRow();
					if(index!=-1){
						String a=tableLSP.getValueAt(index, 0).toString();	
						Object[] message = {null, "Thông Báo", null, "Bạn có muốn xoá không?"};
					    Object[] options = { "Yes", "No" };
					    int n = JOptionPane.showOptionDialog(new JFrame(),
					            message, "",
					            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					            options, options[1]);
					    if(n == JOptionPane.OK_OPTION){ 
					    	lspb.deleteLSP(a);
							String b="";							
							txtMaLSP.setText(b);
							txtTenLSP.setText(b);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
					    }
					    if(n == JOptionPane.NO_OPTION){ 
					    }						
						getJTable();
					}
				}
			});
			btnXoa.setBounds(162, 79, 89, 23);
		}
		return btnXoa;
	}
	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tableLSP.getSelectedRow();
					if(index!=-1){
						String a=txtMaLSP.getText();
						String b=txtTenLSP.getText();
						lspb.editLSP(a, b);
						JOptionPane.showMessageDialog(null, "Sửa thành công");
						getJTable();						
					}
				}
			});
			btnSua.setBounds(289, 79, 89, 23);
		}
		return btnSua;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 111, 393, 105);
			scrollPane.setViewportView(getTableLSP());
		}
		return scrollPane;
	}
	private JTable getTableLSP() {
		if (tableLSP == null) {
			tableLSP = new JTable();
			tableLSP.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index=tableLSP.getSelectedRow();
					if(index!=-1){
						txtMaLSP.setText(tableLSP.getValueAt(index, 0).toString());
						txtTenLSP.setText(tableLSP.getValueAt(index, 1).toString());
					}
				}
			});			
			
			tableLSP.setModel(getDtmLSP());
			
			tableLSP.setDefaultEditor(Object.class, null);
//			tableLSP.getColumnModel().getColumn(0).setMinWidth(0);
			tableLSP.getColumnModel().getColumn(0).setMaxWidth(120);
//			tableLSP.getColumnModel().getColumn(0).setWidth(80);			
		}
		return tableLSP;
	}
	/**
	 * @wbp.nonvisual location=307,59
	 */
	private DefaultTableModel getDtmLSP() {
		if (dtmLSP == null) {
			dtmLSP = new DefaultTableModel();
			
			dtmLSP.addColumn("Mã LSP");
			dtmLSP.addColumn("Tên Loại Sản Phẩm");
		}
		return dtmLSP;
	}
}
