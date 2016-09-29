package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import vn.ChuVoiCon.qlHangHoa.BUS.NhaCungCapBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.loai_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.nha_cung_cap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class jfNhaCungCap extends JInternalFrame {
	
	private ArrayList<nha_cung_cap> arrNCC=new ArrayList<nha_cung_cap>();
	NhaCungCapBUS nccb=new NhaCungCapBUS();

	private JPanel contentPane;
	private JLabel lblMNhCung;
	private JLabel lblTnNhCung;
	private JLabel lblNgiLinH;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtNguoiLienHe;
	private JTextField txtSoDT;
	private JTextField txtDiaChi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JScrollPane scrollPane;
	private DefaultTableModel dtmNCC;
	private JTable tableNCC;

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
	public jfNhaCungCap() {
		setTitle("Nh\u1EADp Li\u1EC7u Nh\u00E0 Cung C\u1EA5p");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMNhCung());
		contentPane.add(getLblTnNhCung());
		contentPane.add(getLblNgiLinH());
		contentPane.add(getLblSinThoi());
		contentPane.add(getLblaCh());
		contentPane.add(getTxtMaNCC());
		contentPane.add(getTxtTenNCC());
		contentPane.add(getTxtNguoiLienHe());
		contentPane.add(getTxtSoDT());
		contentPane.add(getTxtDiaChi());
		contentPane.add(getBtnThem());
		contentPane.add(getBtnXoa());
		contentPane.add(getBtnSua());
		contentPane.add(getScrollPane());
		
		arrNCC=nccb.getDSNCC();
		for (nha_cung_cap nccap : arrNCC){
			Object data[]=new Object[]{
					nccap.getId_ncc(),nccap.getTen_ncc(),
					nccap.getNguoi_lien_he(),nccap.getDien_thoai(),nccap.getDia_chi()
			};
			dtmNCC.addRow(data);
		}
	}

	private JLabel getLblMNhCung() {
		if (lblMNhCung == null) {
			lblMNhCung = new JLabel("M\u00E3 Nh\u00E0 Cung C\u1EA5p");
			lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMNhCung.setBounds(12, 9, 116, 14);
		}
		return lblMNhCung;
	}
	private JLabel getLblTnNhCung() {
		if (lblTnNhCung == null) {
			lblTnNhCung = new JLabel("T\u00EAn Nh\u00E0 Cung C\u1EA5p");
			lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTnNhCung.setBounds(12, 34, 116, 14);
		}
		return lblTnNhCung;
	}
	private JLabel getLblNgiLinH() {
		if (lblNgiLinH == null) {
			lblNgiLinH = new JLabel("Ng\u01B0\u1EDDi Li\u00EAn H\u1EC7");
			lblNgiLinH.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNgiLinH.setBounds(12, 59, 91, 14);
		}
		return lblNgiLinH;
	}
	private JLabel getLblSinThoi() {
		if (lblSinThoi == null) {
			lblSinThoi = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i");
			lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSinThoi.setBounds(12, 84, 93, 14);
		}
		return lblSinThoi;
	}
	private JLabel getLblaCh() {
		if (lblaCh == null) {
			lblaCh = new JLabel("\u0110\u1ECBa Ch\u1EC9 NCC");
			lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblaCh.setBounds(12, 111, 91, 14);
		}
		return lblaCh;
	}
	private JTextField getTxtMaNCC() {
		if (txtMaNCC == null) {
			txtMaNCC = new JTextField();
			txtMaNCC.setBounds(138, 7, 128, 20);
			txtMaNCC.setColumns(10);
		}
		return txtMaNCC;
	}
	private JTextField getTxtTenNCC() {
		if (txtTenNCC == null) {
			txtTenNCC = new JTextField();
			txtTenNCC.setBounds(138, 32, 325, 20);
			txtTenNCC.setColumns(10);
		}
		return txtTenNCC;
	}
	private JTextField getTxtNguoiLienHe() {
		if (txtNguoiLienHe == null) {
			txtNguoiLienHe = new JTextField();
			txtNguoiLienHe.setBounds(138, 57, 221, 20);
			txtNguoiLienHe.setColumns(10);
		}
		return txtNguoiLienHe;
	}
	private JTextField getTxtSoDT() {
		if (txtSoDT == null) {
			txtSoDT = new JTextField();
			txtSoDT.setBounds(138, 82, 221, 20);
			txtSoDT.setColumns(10);
		}
		return txtSoDT;
	}
	private JTextField getTxtDiaChi() {
		if (txtDiaChi == null) {
			txtDiaChi = new JTextField();
			txtDiaChi.setBounds(138, 109, 325, 20);
			txtDiaChi.setColumns(10);
		}
		return txtDiaChi;
	}
	private JButton getBtnThem() {
		if (btnThem == null) {
			btnThem = new JButton("Th\u00EAm");
			btnThem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String a=txtMaNCC.getText();
					String b=txtTenNCC.getText();
					String c=txtNguoiLienHe.getText();
					String d=txtSoDT.getText();
					String e=txtDiaChi.getText();
					nccb.addNCC(a,b,c,d,e);
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					getJTable();
				}
			});
			btnThem.setBounds(473, 10, 89, 38);
		}
		return btnThem;
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xo\u00E1");
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tableNCC.getSelectedRow();
					if(index!=-1){
						String a=tableNCC.getValueAt(index, 0).toString();	
						Object[] message = {null, "Thông Báo", null, "Bạn có muốn xoá không?"};
					    Object[] options = { "Yes", "No" };
					    int n = JOptionPane.showOptionDialog(new JFrame(),
					            message, "",
					            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					            options, options[1]);
					    if(n == JOptionPane.OK_OPTION){ 
					    	nccb.deleteNCC(a);
							String b="";							
							txtMaNCC.setText(b);
							txtTenNCC.setText(b);
							txtNguoiLienHe.setText(b);
							txtSoDT.setText(b);
							txtDiaChi.setText(b);
							JOptionPane.showMessageDialog(null, "Xoá thành công");
					    }
					    if(n == JOptionPane.NO_OPTION){ 
					    }						
						getJTable();
					}
				}
			});
			btnXoa.setBounds(473, 49, 89, 38);
		}
		return btnXoa;
	}
	private JButton getBtnSua() {
		if (btnSua == null) {
			btnSua = new JButton("S\u1EEDa");
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tableNCC.getSelectedRow();
					if(index!=-1){
						String a=txtMaNCC.getText();
						String b=txtTenNCC.getText();
						String c=txtNguoiLienHe.getText();
						String d=txtSoDT.getText();
						String e=txtDiaChi.getText();
						nccb.editNCC(a,b,c,d,e);
						JOptionPane.showMessageDialog(null, "Sửa thành công");
						getJTable();						
					}
				}
			});
			btnSua.setBounds(473, 88, 89, 38);
		}
		return btnSua;
	}
	private void getJTable(){
		arrNCC=nccb.getDSNCC();
		while(getDtmNCC().getRowCount() > 0)
		{
			getDtmNCC().removeRow(0);
		}
		for (nha_cung_cap nccap : arrNCC){
			Object data[]=new Object[]{
					nccap.getId_ncc(),nccap.getTen_ncc(),
					nccap.getNguoi_lien_he(),nccap.getDien_thoai(),nccap.getDia_chi()
			};
			getDtmNCC().addRow(data);
		}
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 135, 569, 194);
			scrollPane.setViewportView(getTableNCC());
		}
		return scrollPane;
	}
	/**
	 * @wbp.nonvisual location=337,49
	 */
	private DefaultTableModel getDtmNCC() {
		if (dtmNCC == null) {
			dtmNCC = new DefaultTableModel();
			
			dtmNCC.addColumn("Mã NCC");
			dtmNCC.addColumn("Tên Nhà Cung Cấp");
			dtmNCC.addColumn("Người Liên Hệ");
			dtmNCC.addColumn("Số Điện Thoại");
			dtmNCC.addColumn("Địa Chỉ Công ty");
		}
		return dtmNCC;
	}
	private JTable getTableNCC() {
		if (tableNCC == null) {
			tableNCC = new JTable();
			tableNCC.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index=tableNCC.getSelectedRow();
					if(index!=-1){
						txtMaNCC.setText(tableNCC.getValueAt(index, 0).toString());
						txtTenNCC.setText(tableNCC.getValueAt(index, 1).toString());
						txtNguoiLienHe.setText(tableNCC.getValueAt(index, 2).toString());
						txtSoDT.setText(tableNCC.getValueAt(index, 3).toString());
						txtDiaChi.setText(tableNCC.getValueAt(index, 4).toString());
					}
				}
			});
			
			tableNCC.setModel(getDtmNCC());
			tableNCC.getColumnModel().getColumn(0).setMaxWidth(120);
		}
		return tableNCC;
	}
}
