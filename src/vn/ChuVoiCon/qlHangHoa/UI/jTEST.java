package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import vn.ChuVoiCon.qlHangHoa.BUS.chi_tiet_phieu_nhapBUS;
import vn.ChuVoiCon.qlHangHoa.BUS.nhap_khoBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_phieu_nhap;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.currentUser;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jTEST extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtMaPhieu;
	private JTextField txtNgayLap;
	private JTextField txtNhanVien;
	private JButton btnLap;
	private JScrollPane scrollPane;
	private JTable tbCTPN;
	private JScrollPane scrollPane_1;
	private JTable tbSanPham;
	private JPanel panel_3;
	private JButton btnHuy;
	private JButton btnXoa;
	private JTable tbDanhSachPhieu;
	private JScrollPane scrollPane_2;
	private JPanel panel_5;
	private JRadioButton rdbFull;
	private JRadioButton rdbNotDel;
	private JRadioButton rdbDeleted;
	private JButton btnHuyPhieu;
	private DefaultTableModel modelDanhSachPhieu;
	
	private nhap_khoBUS nkb=new nhap_khoBUS();
	private chi_tiet_phieu_nhapBUS ctb=new chi_tiet_phieu_nhapBUS();
	
	private int act=1;
	
	private ButtonGroup Group;
	private DefaultTableModel modelSP;
	private DefaultTableModel modelCTPN;
	private JPanel panelSua;
	private JLabel lblMSnPhm;
	private JLabel lblNewLabel;
	private JLabel lblSLng;
	private JLabel lblnGi;
	private JTextField txtSL;
	private JTextField txtDG;
	private JLabel lblMaSP;
	private JLabel lblTenSP;
	private JLabel lblThnhTin;
	private JLabel lblThTien;
	private JButton btnSua;
	private JButton btnAdd;
	
	Date today=new Date(System.currentTimeMillis());
	SimpleDateFormat timeFormat= new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	private currentUser cru=new currentUser();
	private JLabel lblTngTin;
	private JTextField txtTongTien;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jTEST frame = new jTEST();
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
	public jTEST() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getTabbedPane_1());
		loadDanhSachSP();
		getGroup();
		loadDanhSach();
		panelSua.setVisible(false);
		txtNgayLap.setText(timeFormat.format(today.getTime()));
//		txtNhanVien.setText(cru.getNv().getTen_nhan_vien());
	}
	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Nhập Phiếu", null, getPanel_8(), null);
			tabbedPane.addTab("Danh sách Phiếu", null, getPanel_1_1(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanel_8() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("default:grow"),
					ColumnSpec.decode("default:grow"),},
				new RowSpec[] {
					RowSpec.decode("top:170px"),
					RowSpec.decode("fill:default"),
					RowSpec.decode("bottom:56px"),}));
			panel.add(getPanel_2_1(), "1, 1, 2, 1, fill, fill");
			panel.add(getScrollPane_1(), "1, 2, fill, fill");
			panel.add(getScrollPane(), "2, 2, fill, fill");
			panel.add(getPanel_3(), "1, 3, 2, 1, fill, fill");
		}
		return panel;
	}
	private JPanel getPanel_1_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
			panel_1.add(getScrollPane_2());
			panel_1.add(getPanel_5());
		}
		return panel_1;
	}
	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getPanel_4());
			panel_2.add(getPanelSua());
			panel_2.add(getBtnLap());
			panel_2.add(getBtnHuy());
		}
		return panel_2;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(null);
			panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(10, 0, 300, 161);
			panel_4.add(getLabel());
			panel_4.add(getLabel_1());
			panel_4.add(getLabel_2());
			panel_4.add(getTxtMaPhieu());
			panel_4.add(getTxtNgayLap());
			panel_4.add(getTxtNhanVien());
		}
		return panel_4;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Mã phiếu");
			label.setBounds(39, 29, 59, 14);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Ngày lập");
			label_1.setBounds(38, 54, 60, 14);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Nhân Viên");
			label_2.setBounds(39, 79, 59, 14);
		}
		return label_2;
	}
	private JTextField getTxtMaPhieu() {
		if (txtMaPhieu == null) {
			txtMaPhieu = new JTextField();
			txtMaPhieu.setEnabled(false);
			txtMaPhieu.setColumns(10);
			txtMaPhieu.setBounds(112, 26, 140, 20);
		}
		return txtMaPhieu;
	}
	private JTextField getTxtNgayLap() {
		if (txtNgayLap == null) {
			txtNgayLap = new JTextField();
			txtNgayLap.setEnabled(false);
			txtNgayLap.setColumns(10);
			txtNgayLap.setBounds(112, 51, 140, 20);
		}
		return txtNgayLap;
	}
	private JTextField getTxtNhanVien() {
		if (txtNhanVien == null) {
			txtNhanVien = new JTextField();
			txtNhanVien.setEnabled(false);
			txtNhanVien.setColumns(10);
			txtNhanVien.setBounds(112, 76, 140, 20);
		}
		return txtNhanVien;
	}
	private JButton getBtnLap() {
		if (btnLap == null) {
			btnLap = new JButton("Lập");
			btnLap.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
							int idnew = nkb.Add(getDataInput());
							if (idnew > 0) {
								JOptionPane.showMessageDialog(null,
										"Lập Phiếu thành công");
								setDataInput(nkb.getData(idnew));
							}
						} catch (SQLException e){
							e.getStackTrace();
					
					}
					
				}
			});
			btnLap.setEnabled(false);
			btnLap.setBounds(317, 24, 79, 47);
		}

		return btnLap;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTbCTPN());
		}
		return scrollPane;
	}
	private JTable getTbCTPN(){
		if (tbCTPN == null) {
			tbCTPN = new JTable();
			tbCTPN.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnAdd.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
					int soluong=1;
					int index=tbCTPN.getSelectedRow();
					Object ob[]=new Object[]{tbCTPN.getValueAt(index, 0),tbCTPN.getValueAt(index, 1),tbCTPN.getValueAt(index, 2),tbCTPN.getValueAt(index, 3)};
					lblMaSP.setText(ob[0]+"");
					lblTenSP.setText(ob[1]+"");
					txtSL.setText(ob[2]+"");
					txtDG.setText(ob[3]+"");
				}
			});
			tbCTPN.setModel(getModelCTPN());
			tbCTPN.setDefaultEditor(Object.class, null);
		}
		return tbCTPN;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTbSanPham());
		}
		return scrollPane_1;
	}
	private JTable getTbSanPham() {
		if (tbSanPham == null) {
			tbSanPham = new JTable();
			tbSanPham.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					panelSua.setVisible(true);
					btnAdd.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					int soluong=1;
					int index=tbSanPham.getSelectedRow();
					Object ob[]=new Object[]{tbSanPham.getValueAt(index, 0),tbSanPham.getValueAt(index, 1),soluong};
					lblMaSP.setText(ob[0]+"");
					lblTenSP.setText(ob[1]+"");
					txtSL.setText("1");
					txtDG.setText("0");
					lblThTien.setText("0");
				}
			});
			tbSanPham.setModel(getModelSP());
			tbSanPham.setDefaultEditor(Object.class, null);
		}
		return tbSanPham;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
						.addContainerGap(411, Short.MAX_VALUE)
						.addComponent(getLblTngTin(), GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getTxtTongTien(), GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGap(223))
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
						.addGap(22)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLblTngTin())
							.addComponent(getTxtTongTien(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(14, Short.MAX_VALUE))
			);
			panel_3.setLayout(gl_panel_3);
		}
		return panel_3;
	}
	private JButton getBtnHuy() {
		if (btnHuy == null) {
			btnHuy = new JButton("Hủy");
			btnHuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(txtMaPhieu.getText().compareTo("")==0){
						while(getTbCTPN().getRowCount()>0){
							modelCTPN.removeRow(0);
						}
					}else
						if(nkb.Del(Integer.parseInt(txtMaPhieu.getText()))==1){
							JOptionPane.showMessageDialog(null, "Hủy Thành Công");
						}
				}
			});
			btnHuy.setEnabled(false);
			btnHuy.setBounds(317, 82, 79, 47);
		}
		return btnHuy;
	}
	private JButton getBtnXoa() {
		if (btnXoa == null) {
			btnXoa = new JButton("Xóa");
			btnXoa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tbCTPN.getSelectedRow();
					modelCTPN.removeRow(index);
					lblMaSP.setText("Chưa có");
					lblTenSP.setText("Chưa có");
					txtSL.setText("1");
					txtDG.setText("0");
					lblThTien.setText("0");
					btnAdd.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					if(tbCTPN.getRowCount()==0){
						btnLap.setEnabled(false);
						btnHuy.setEnabled(false);
					}
				}
			});
			btnXoa.setEnabled(false);
			btnXoa.setBounds(278, 92, 89, 31);
		}
		return btnXoa;
	}
	private JTable getTbDanhSachPhieu() {
		if (tbDanhSachPhieu == null) {
			tbDanhSachPhieu = new JTable();
			tbDanhSachPhieu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index=tbDanhSachPhieu.getSelectedRow();
					String ma=tbDanhSachPhieu.getValueAt(index, 1).toString();
					getTabbedPane_1().setSelectedIndex(1);
					
				}
			});
			tbDanhSachPhieu.setModel(getModelDanhSachPhieu());
		}
		return tbDanhSachPhieu;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTbDanhSachPhieu());
		}
		return scrollPane_2;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getRdbFull());
			panel_5.add(getRdbNotDel());
			panel_5.add(getRdbDeleted());
			panel_5.add(getBtnHuyPhieu());
		}
		return panel_5;
	}
	private JRadioButton getRdbFull() {
		if (rdbFull == null) {
			rdbFull = new JRadioButton("Xem tất cả");
			rdbFull.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent arg0) {
					act=0;
					loadDanhSach();
					btnHuyPhieu.setEnabled(true);
				}
			});
			rdbFull.setBounds(31, 7, 109, 23);
		}
		return rdbFull;
	}
	private JRadioButton getRdbNotDel() {
		if (rdbNotDel == null) {
			rdbNotDel = new JRadioButton("Phiếu chưa huỷ");
			rdbNotDel.setSelected(true);
			rdbNotDel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					act=1;
					loadDanhSach();
					btnHuyPhieu.setEnabled(true);
				}
			});
			rdbNotDel.setBounds(168, 7, 109, 23);
		}
		return rdbNotDel;
	}
	private JRadioButton getRdbDeleted() {
		if (rdbDeleted == null) {
			rdbDeleted = new JRadioButton("Phiếu đã hủy");
			rdbDeleted.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					act=-1;
					loadDanhSach();
					btnHuyPhieu.setEnabled(false);
				}
			});
			rdbDeleted.setBounds(311, 7, 109, 23);
		}
		return rdbDeleted;
	}
	private JButton getBtnHuyPhieu() {
		if (btnHuyPhieu == null) {
			btnHuyPhieu = new JButton("Hủy Phiếu");
			btnHuyPhieu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tbDanhSachPhieu.getSelectedRow();
					int ma=Integer.parseInt(tbDanhSachPhieu.getValueAt(index, 0).toString());
					if(nkb.Del(ma)==1){
						JOptionPane.showMessageDialog(null, "Huy Thanh Cong");
					}
				}
			});
			btnHuyPhieu.setBounds(672, 7, 109, 23);
		}
		return btnHuyPhieu;
	}
	/**
	 * @wbp.nonvisual location=146,329
	 */
	private DefaultTableModel getModelDanhSachPhieu() {
		if (modelDanhSachPhieu == null) {
			modelDanhSachPhieu = new DefaultTableModel();
			String colsname[]={"Mã Phiếu Nhập", "Ngày Nhập","Nhân Viên Nhập","Trạng Thái"};
			modelDanhSachPhieu.setColumnIdentifiers(colsname);
		}
		return modelDanhSachPhieu;
	}
	
	private void loadDanhSach(){
		while (getModelDanhSachPhieu().getRowCount() > 0) {
			getModelDanhSachPhieu().removeRow(0);
		}
	
		for (phieu_nhap a : nkb.getDSEX(act)) {
			Object ob[] = new Object[] { a.getMa_phieu_nhap(), a.getNgay_lap(),
					a.getId_nv(),a.getNgay_huy()==null?"Còn tồn tại": "Đã xóa" };
			modelDanhSachPhieu.addRow(ob);
		}

	}
	
	private void loadDanhSachSP(){
		while (getModelSP().getRowCount() > 0) {
			getModelSP().removeRow(0);
		}
		for (chi_tiet_san_pham a : ctb.getDSSP()) {
			Object ob[] = new Object[] { a.getId_sp(), a.getTen_sp()};
			getModelSP().addRow(ob);
		}

	}
	/**
	 * @wbp.nonvisual location=72,459
	 */
	private ButtonGroup getGroup() {
		if (Group == null) {
			Group = new ButtonGroup();
			Group.add(getRdbDeleted());
			Group.add(getRdbFull());
			Group.add(getRdbNotDel());
		}
		return Group;
	}
	/**
	 * @wbp.nonvisual location=76,329
	 */
	private DefaultTableModel getModelSP() {
		if (modelSP == null) {
			modelSP = new DefaultTableModel();
			String colsname[]={"Mã sản phẩm", "tên sản phẩm"};
			modelSP.setColumnIdentifiers(colsname);
		}
		return modelSP;
	}
	/**
	 * @wbp.nonvisual location=276,329
	 */
	private DefaultTableModel getModelCTPN() {
		if (modelCTPN == null) {
			modelCTPN = new DefaultTableModel();
			String colsname[]={"Mã sản phẩm", "tên sản phẩm","Số lượng","Đơn giá","Thành Tiền"};
			modelCTPN.setColumnIdentifiers(colsname);
		}
		return modelCTPN;
	}
	private JPanel getPanelSua() {
		if (panelSua == null) {
			panelSua = new JPanel();
			panelSua.setBounds(406, 0, 391, 161);
			panelSua.setLayout(null);
			panelSua.add(getLblMSnPhm());
			panelSua.add(getLblNewLabel());
			panelSua.add(getLblSLng());
			panelSua.add(getLblnGi());
			panelSua.add(getTxtSL());
			panelSua.add(getTxtDG());
			panelSua.add(getLblMaSP());
			panelSua.add(getLblTenSP());
			panelSua.add(getLblThnhTin());
			panelSua.add(getLblThTien());
			panelSua.add(getButton_1_1());
			panelSua.add(getBtnXoa());
			panelSua.add(getBtnAdd());
		}
		return panelSua;
	}
	private JLabel getLblMSnPhm() {
		if (lblMSnPhm == null) {
			lblMSnPhm = new JLabel("Mã sản phẩm");
			lblMSnPhm.setBounds(10, 11, 89, 14);
		}
		return lblMSnPhm;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Tên sản phẩm");
			lblNewLabel.setBounds(10, 39, 89, 14);
		}
		return lblNewLabel;
	}
	private JLabel getLblSLng() {
		if (lblSLng == null) {
			lblSLng = new JLabel("Số lượng");
			lblSLng.setBounds(10, 71, 89, 14);
		}
		return lblSLng;
	}
	private JLabel getLblnGi() {
		if (lblnGi == null) {
			lblnGi = new JLabel("Đơn giá (1 đơn vị)");
			lblnGi.setBounds(10, 100, 106, 14);
		}
		return lblnGi;
	}
	private JTextField getTxtSL() {
		if (txtSL == null) {
			txtSL = new JTextField();
			txtSL.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if(kiemTraNumber(txtSL.getText()) && kiemTraNumber(txtDG.getText())){
						int slg=Integer.parseInt(txtSL.getText());
						double dg=Double.parseDouble(txtDG.getText());
						lblThTien.setText(slg*dg+"");
					}
					else
						lblThTien.setText("Nhập sai!");
				}
			});
			txtSL.setText("1");
			txtSL.setBounds(119, 68, 76, 20);
			txtSL.setColumns(10);
		}
		return txtSL;
	}
	
	private boolean kiemTraNumber(String s){
		 Pattern pattern = Pattern.compile("\\d*"); 
	     Matcher matcher = pattern.matcher(s); 
	     if (matcher.matches()) { 
	         return true;
	     }
	     return false;
	}
	
	private JTextField getTxtDG() {
		if (txtDG == null) {
			txtDG = new JTextField();
			txtDG.setText("0");
			txtDG.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					if(kiemTraNumber(txtSL.getText()) && kiemTraNumber(txtDG.getText())){
						int slg=Integer.parseInt(txtSL.getText());
						double dg=Double.parseDouble(txtDG.getText());
						lblThTien.setText(slg*dg+"");
					}
					else
						lblThTien.setText("Nhập sai!");
				}
			});
			
			txtDG.setColumns(10);
			txtDG.setBounds(119, 97, 76, 20);
		}
		return txtDG;
	}
	private JLabel getLblMaSP() {
		if (lblMaSP == null) {
			lblMaSP = new JLabel("Chưa có");
			lblMaSP.setBounds(119, 11, 76, 14);
		}
		return lblMaSP;
	}
	private JLabel getLblTenSP() {
		if (lblTenSP == null) {
			lblTenSP = new JLabel("Chưa có");
			lblTenSP.setBounds(119, 39, 149, 14);
		}
		return lblTenSP;
	}
	private JLabel getLblThnhTin() {
		if (lblThnhTin == null) {
			lblThnhTin = new JLabel("Thành tiền");
			lblThnhTin.setBounds(10, 136, 67, 14);
		}
		return lblThnhTin;
	}
	private JLabel getLblThTien() {
		if (lblThTien == null) {
			lblThTien = new JLabel("0");
			lblThTien.setBounds(119, 136, 149, 14);
		}
		return lblThTien;
	}
	private JButton getButton_1_1() {
		if (btnSua == null) {
			btnSua = new JButton("Sửa");
			btnSua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index=tbCTPN.getSelectedRow();
					Object a=txtSL.getText();
					Object c=txtDG.getText();
					Object b=lblThTien.getText();
					modelCTPN.setValueAt(a, index, 2);
					modelCTPN.setValueAt(b, index, 3);
					modelCTPN.setValueAt(c, index, 4);
				}
			});
			btnSua.setEnabled(false);
			btnSua.setBounds(278, 55, 89, 31);
		}
		return btnSua;
	}
	
	private boolean kiemTraTable(String s){
		for(int i=0;i<tbCTPN.getRowCount();i++){
			String ma=tbCTPN.getValueAt(i, 0).toString();
			String ten=tbCTPN.getValueAt(i, 1).toString();
			if(ma.compareTo(s)==0){
				return true;
			}
		}
		return false;
	}
	
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Thêm");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(!kiemTraTable(lblMaSP.getText())){
						if(lblMaSP.getText().compareTo("Chưa có")!=0){
						Object ob[]=new Object[]{lblMaSP.getText(),lblTenSP.getText(),txtSL.getText(),txtDG.getText(),lblThTien.getText()};
						modelCTPN.addRow(ob);
						btnLap.setEnabled(true);
						btnHuy.setEnabled(true);
						tinhTT();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Sản phẩm đã nằm trong phiếu!");
					}
					lblMaSP.setText("Chưa có");
					lblTenSP.setText("Chưa có");
					txtSL.setText("1");
					txtDG.setText("0");
					lblThTien.setText("0");
				}
			});
			btnAdd.setBounds(278, 22, 89, 31);
		}
		return btnAdd;
	}
	
	private phieu_nhap getDataInput() {
		phieu_nhap r = new phieu_nhap();
//		r.setId_nv(currentUser.getNv().getId());
		r.setId_nv(1);
		ArrayList<chi_tiet_phieu_nhap> ct = new ArrayList<chi_tiet_phieu_nhap>();
		DefaultTableModel model = (DefaultTableModel) getTbCTPN().getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			chi_tiet_phieu_nhap t = new chi_tiet_phieu_nhap();
			t.setMa_san_pham(model.getValueAt(i, 0).toString());
			t.setDon_gia(Double.parseDouble(model.getValueAt(i, 4).toString()));
			t.setSo_luong(Integer.parseInt(model.getValueAt(i,3).toString()));
			ct.add(t);
		}
		r.setCt_nhap_kho(ct);
		return r;
	}
	
	private void setDataInput(phieu_nhap t) {
		txtMaPhieu.setText(t.getMa_phieu_nhap() + "");
		txtNgayLap.setText(t.getNgay_lap().toString());
		txtNhanVien.setText(t.getNv().getTen_nhan_vien());
		tbSanPham.setEnabled(false);
		btnXoa.setEnabled(false);
		btnHuy.setEnabled(t.getNgay_huy() == null ? true : false);

		DefaultTableModel model = (DefaultTableModel) getTbCTPN().getModel();
		while (model.getRowCount() > 0)
			model.removeRow(0);
		double tt = 0;
		for (chi_tiet_phieu_nhap item : t.getCt_nhap_kho()) {
			Object[] cthditem = new Object[] { item.getMa_san_pham(),item.getCtsp().getTen_sp(),
					item.getSo_luong(),item.getDon_gia(), item.getDon_gia() * item.getSo_luong() };
			model.addRow(cthditem);
			tt += item.getDon_gia() * item.getSo_luong();
		}
	}
	
	private void tinhTT() {
		double tt = 0;
		for (int i = 0; i < tbCTPN.getRowCount(); i++) {
			int sl = Integer.parseInt(tbCTPN.getValueAt(i, 3).toString());
			double dg = Double.parseDouble(tbCTPN.getValueAt(i, 4)
					.toString());
			tt += sl * dg;
		}
		txtTongTien.setText(tt + "");
	}
	private JLabel getLblTngTin() {
		if (lblTngTin == null) {
			lblTngTin = new JLabel("Tổng Tiền:");
		}
		return lblTngTin;
	}
	private JTextField getTxtTongTien() {
		if (txtTongTien == null) {
			txtTongTien = new JTextField();
			txtTongTien.setEnabled(false);
			txtTongTien.setColumns(10);
		}
		return txtTongTien;
	}
}
