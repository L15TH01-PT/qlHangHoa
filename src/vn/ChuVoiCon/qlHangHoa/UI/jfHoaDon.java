package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import vn.ChuVoiCon.qlHangHoa.BUS.ChiTietSanPhamBUS;
import vn.ChuVoiCon.qlHangHoa.BUS.hoa_donBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_hoa_don;
import vn.ChuVoiCon.qlHangHoa.DLL.chi_tiet_san_pham;
import vn.ChuVoiCon.qlHangHoa.DLL.currentUser;
import vn.ChuVoiCon.qlHangHoa.DLL.hoa_don;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.mysql.fabric.xmlrpc.base.Data;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Component;
import javax.swing.JTextArea;

public class jfHoaDon extends JInternalFrame {

	private hoa_donBUS hdb;
	private ChiTietSanPhamBUS ctspb;

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JLabel lblMHan;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField txtMaPhieu;
	private JTextField txtNgayLap;
	private JTextField txtNhanVien;
	private JButton btnLap;
	private JScrollPane scrollPane;
	private JTable tbChiTiet;
	private JScrollPane scrollPane_1;
	private JTable tbSanPham;
	private JPanel panel_3;
	private JButton btnXoaChiTiet;
	private JTable tbDSHoaDon;
	private JScrollPane scrollPane_2;
	private JLabel lblTnKhchHng;
	private JTextField txtTenKhachHang;
	private JButton btnHuy;
	private JPanel panel_5;
	private JRadioButton rboAll;
	private JRadioButton rboChuaHuy;
	private JRadioButton rboDaHuy;
	private ButtonGroup buttonGroup;
	private JButton btnNewButton;
	private JLabel lblTngTin;
	private JTextField txtTongTien;
	private JLabel lblGhiCh;
	private JScrollPane scrollPane_3;
	private JTextArea taGhiChu;

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
	public jfHoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hóa đơn");
		setBounds(100, 100, 881, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getTabbedPane_1());
		getButtonGroup();
		hdb = new hoa_donBUS();
		ctspb = new ChiTietSanPhamBUS();
		getDSHD();
		getDSSP();
	}

	private void getDSHD() {
		int s = 0;
		if (getRboChuaHuy().isSelected())
			s = 1;
		else if (getRboDaHuy().isSelected())
			s = -1;
		DefaultTableModel tbm = (DefaultTableModel) getTbDSHoaDon().getModel();
		// getTbDSHoaDon().removeAll();
		while (tbm.getRowCount() > 0)
			tbm.removeRow(0);

		for (hoa_don item : hdb.getDSEX(s)) {
			Object[] t = new Object[] { item.getMa_hoa_don(),
					item.getNgay_lap(), item.getTen_khach_hang(),
					item.getNv().getTen_nhan_vien(), item.getGhi_chu(),
					item.getNgay_huy() == null ? "" : "X" };
			tbm.addRow(t);
		}
	}

	private void getDSSP() {
		DefaultTableModel tbm = (DefaultTableModel) getTbSanPham().getModel();
		// getTbSanPham().removeAll();
		while (tbm.getRowCount() > 0)
			tbm.removeRow(0);
		for (chi_tiet_san_pham item : ctspb.getDSCTSP()) {
			Object[] t = new Object[] { item.getId_sp(), item.getTen_sp(),
					item.getDon_vi_tinh(), item.getDon_gia() };
			tbm.addRow(t);
		}
	}

	private hoa_don getDataInput() {
		hoa_don r = new hoa_don();
		r.setId_nv(currentUser.getNv().getId());
		r.setTen_khach_hang(getTxtTenKhachHang().getText());
		r.setGhi_chu(getTaGhiChu().getText());
		ArrayList<chi_tiet_hoa_don> ct = new ArrayList<chi_tiet_hoa_don>();
		DefaultTableModel ctmodel = (DefaultTableModel) getTbChiTiet()
				.getModel();
		for (int i = 0; i < ctmodel.getRowCount(); i++) {
			chi_tiet_hoa_don t = new chi_tiet_hoa_don();
			t.setId_sp(ctmodel.getValueAt(i, 0).toString());
			t.setDon_gia(Double
					.parseDouble(ctmodel.getValueAt(i, 3).toString()));
			t.setSo_luong(Integer.parseInt(ctmodel.getValueAt(i, 4).toString()));
			ct.add(t);
		}
		r.setChi_tiet_hoa_dons(ct);
		return r;
	}

	private void clearDataInput() {
		getTxtMaPhieu().setText("");
		txtNgayLap.setText((new Date().toString()));
		txtNhanVien.setText(currentUser.getNv().getTen_nhan_vien());
		txtTenKhachHang.setText("");
		getTaGhiChu().setText("");
		DefaultTableModel tbm = (DefaultTableModel) getTbChiTiet().getModel();
		// getTbDSHoaDon().removeAll();
		while (tbm.getRowCount() > 0)
			tbm.removeRow(0);
		txtTenKhachHang.setEditable(true);
		tbSanPham.setEnabled(true);
		btnXoaChiTiet.setEnabled(true);
		btnHuy.setEnabled(true);
		getTaGhiChu().setEditable(true);
		getTxtTongTien().setText("0");
		try {
			Method m = tbChiTiet.getModel().getClass()
					.getMethod("setCellEditable", int.class, boolean.class);
			m.invoke(tbChiTiet.getModel(), 4, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setDataInput(hoa_don t) {
		txtMaPhieu.setText(t.getMa_hoa_don() + "");
		txtNgayLap.setText(t.getNgay_lap().toString());
		txtNhanVien.setText(t.getNv().getTen_nhan_vien());
		txtTenKhachHang.setText(t.getTen_khach_hang());
		taGhiChu.setText(t.getGhi_chu());
		txtTenKhachHang.setEditable(false);
		tbSanPham.disable();
		btnXoaChiTiet.setEnabled(false);
		getTaGhiChu().setEditable(false);
		btnHuy.setEnabled(t.getNgay_huy() == null ? true : false);
		try {
			Method m = tbChiTiet.getModel().getClass()
					.getMethod("setCellEditable", int.class, boolean.class);
			m.invoke(tbChiTiet.getModel(), 4, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DefaultTableModel model = (DefaultTableModel) getTbChiTiet().getModel();
		while (model.getRowCount() > 0)
			model.removeRow(0);
		double tt = 0;
		for (chi_tiet_hoa_don item : t.getChi_tiet_hoa_dons()) {
			Object[] cthditem = new Object[] { item.getId_sp(),
					item.getSp().getTen_sp(), item.getSp().getDon_vi_tinh(),
					item.getDon_gia(), item.getSo_luong(),
					item.getDon_gia() * item.getSo_luong() };
			model.addRow(cthditem);
			tt += item.getDon_gia() * item.getSo_luong();
		}
		txtTongTien.setText(tt + "");
	}

	private void tinhTT() {
		double tt = 0;
		for (int i = 0; i < tbChiTiet.getRowCount(); i++) {
			int sl = Integer.parseInt(tbChiTiet.getValueAt(i, 4).toString());
			double dg = Double.parseDouble(tbChiTiet.getValueAt(i, 3)
					.toString());
			tt += sl * dg;
		}
		DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		String numberAsString = decimalFormat.format(tt);
		
		txtTongTien.setText(numberAsString);
	}

	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("Chi tiết", null, getPanel_8(), null);
			tabbedPane.addTab("Danh sách", null, getPanel_1_1(), null);
			tabbedPane.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent changeEvent) {
					// TODO Auto-generated method stub
					JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent
							.getSource();
					int index = sourceTabbedPane.getSelectedIndex();
					if (index == 1)
						getDSHD();
				}
			});
		}
		return tabbedPane;
	}

	private JPanel getPanel_8() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("min(400px;default):grow"),
					ColumnSpec.decode("default:grow(2)"), }, new RowSpec[] {
					RowSpec.decode("top:220px"),
					RowSpec.decode("fill:default"),
					RowSpec.decode("bottom:60px"), }));
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
			panel_1.setLayout(new FormLayout(new ColumnSpec[] { ColumnSpec
					.decode("default:grow"), }, new RowSpec[] {
					RowSpec.decode("top:77px"),
					RowSpec.decode("fill:default:grow"), }));
			panel_1.add(getScrollPane_2(), "1, 2, fill, fill");
			panel_1.add(getPanel_5_1(), "1, 1, fill, fill");
		}
		return panel_1;
	}

	private JPanel getPanel_2_1() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getPanel_4());
			panel_2.add(getBtnLap());
			panel_2.add(getButton_1_1());
		}
		return panel_2;
	}

	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"), "",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0,
							0, 0)));
			panel_4.setBounds(10, 10, 644, 200);
			panel_4.setLayout(null);
			panel_4.add(getLblMHan());
			panel_4.add(getTxtMaPhieu());
			panel_4.add(getLabel_1());
			panel_4.add(getTxtNgayLap());
			panel_4.add(getLabel_2());
			panel_4.add(getTxtNhanVien());
			panel_4.add(getLblTnKhchHng());
			panel_4.add(getTxtTenKhachHang());
			panel_4.add(getLblTngTin());
			panel_4.add(getTxtTongTien());
			panel_4.add(getLabel_3());
			panel_4.add(getScrollPane_3());
		}
		return panel_4;
	}

	private JLabel getLblMHan() {
		if (lblMHan == null) {
			lblMHan = new JLabel("Mã hóa đơn");
			lblMHan.setBounds(15, 16, 113, 20);
		}
		return lblMHan;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Ngày lập");
			label_1.setBounds(15, 52, 113, 20);
		}
		return label_1;
	}

	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Nhân Viên");
			label_2.setBounds(15, 88, 113, 20);
		}
		return label_2;
	}

	private JTextField getTxtMaPhieu() {
		if (txtMaPhieu == null) {
			txtMaPhieu = new JTextField();
			txtMaPhieu.setEditable(false);
			txtMaPhieu.setBounds(133, 11, 179, 26);
			txtMaPhieu.setColumns(10);
		}
		return txtMaPhieu;
	}

	private JTextField getTxtNgayLap() {
		if (txtNgayLap == null) {
			txtNgayLap = new JTextField();
			txtNgayLap.setEditable(false);
			txtNgayLap.setBounds(133, 48, 179, 26);
			txtNgayLap.setColumns(10);
			txtNgayLap.setText((new Date().toLocaleString()));
		}
		return txtNgayLap;
	}

	private JTextField getTxtNhanVien() {
		if (txtNhanVien == null) {
			txtNhanVien = new JTextField();
			txtNhanVien.setEditable(false);
			txtNhanVien.setBounds(133, 85, 179, 26);
			txtNhanVien.setColumns(10);
			txtNhanVien.setText(currentUser.getNv().getTen_nhan_vien());
		}
		return txtNhanVien;
	}

	private JButton getBtnLap() {
		if (btnLap == null) {
			btnLap = new JButton("Lập Phiếu");
			btnLap.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (getTxtMaPhieu().getText().compareTo("") == 0) {
						if (getTbChiTiet().getModel().getRowCount() == 0) {
							JOptionPane.showMessageDialog(null,
									"Vui lòng chọn ít nhất 1 sản phẩm");
						} else {
							int idnew = hdb.Add(getDataInput());
							if (idnew > 0) {
								JOptionPane.showMessageDialog(null,
										"Lập Phiếu thành công");
								setDataInput(hdb.getData(idnew));
							}
						}
					} else {
						clearDataInput();
					}
				}
			});
			btnLap.setBounds(669, 10, 166, 79);
		}
		return btnLap;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTbChiTiet());
		}
		return scrollPane;
	}

	private JTable getTbChiTiet() {
		if (tbChiTiet == null) {
			tbChiTiet = new JTable();
			tbChiTiet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbChiTiet
					.setModel(new DefaultTableModel(new Object[][] {},
							new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m",
									"T\u00EAn s\u1EA3n ph\u1EA9m",
									"\u0110\u01A1n v\u1ECB t\u00EDnh",
									"\u0110\u01A1n gi\u00E1",
									"S\u1ED1 l\u01B0\u1EE3ng",
									"Th\u00E0nh ti\u1EC1n" }) {
						Class[] columnTypes = new Class[] { String.class,
								String.class, String.class, Double.class,
								Integer.class, Double.class };

						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}

						boolean[] columnEditables = new boolean[] { false,
								false, false, false, true, false };

						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}

						public void setCellEditable(int column, boolean p) {
							columnEditables[column] = p;
						}
					});
			tbChiTiet.getModel().addTableModelListener(
					new TableModelListener() {

						@Override
						public void tableChanged(TableModelEvent tme) {
							if (tme.getType() == TableModelEvent.UPDATE) {
								if (tme.getColumn() == 4) {
									int rindex = tme.getFirstRow();
									double tt = Double.parseDouble(tbChiTiet
											.getValueAt(rindex, 3).toString())
											* Integer.parseInt(tbChiTiet
													.getValueAt(rindex, 4)
													.toString());
									tbChiTiet.setValueAt(tt, tme.getFirstRow(),
											5);
									tinhTT();
								}
							}
						}
					});
			tbChiTiet.getColumnModel().getColumn(0).setPreferredWidth(110);
			tbChiTiet.getColumnModel().getColumn(0).setMinWidth(110);
			tbChiTiet.getColumnModel().getColumn(1).setPreferredWidth(200);
			tbChiTiet.getColumnModel().getColumn(1).setMinWidth(200);
			tbChiTiet.getColumnModel().getColumn(2).setPreferredWidth(100);
			tbChiTiet.getColumnModel().getColumn(2).setMinWidth(100);
			tbChiTiet.getColumnModel().getColumn(3).setPreferredWidth(100);
			tbChiTiet.getColumnModel().getColumn(3).setMinWidth(100);
			tbChiTiet.getColumnModel().getColumn(4).setPreferredWidth(100);
			tbChiTiet.getColumnModel().getColumn(4).setMinWidth(100);
			tbChiTiet.getColumnModel().getColumn(5).setPreferredWidth(100);
			tbChiTiet.getColumnModel().getColumn(5).setMinWidth(100);
			tbChiTiet.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return tbChiTiet;
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
			tbSanPham.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbSanPham.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m",
							"T\u00EAn s\u1EA3n ph\u1EA9m",
							"\u0110\u01A1n v\u1ECB t\u00EDnh",
							"\u0110\u01A1n gi\u00E1" }) {
				Class[] columnTypes = new Class[] { String.class, String.class,
						String.class, Double.class };

				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}

				boolean[] columnEditables = new boolean[] { false, false,
						false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tbSanPham.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int rindex = tbSanPham.getSelectedRow();
					if (rindex > -1) {
						DefaultTableModel ctmodel = (DefaultTableModel) getTbChiTiet()
								.getModel();
						boolean flag = false;
						for (int i = 0; i < ctmodel.getRowCount(); i++) {
							if (ctmodel.getValueAt(i, 0).equals(
									tbSanPham.getValueAt(rindex, 0))) {
								ctmodel.setValueAt(
										Integer.parseInt(ctmodel.getValueAt(i,
												4).toString()) + 1, i, 4);
								ctmodel.setValueAt(
										Integer.parseInt(ctmodel.getValueAt(i,
												4).toString())
												* Double.parseDouble(ctmodel
														.getValueAt(i, 3)
														.toString()), i, 5);

								flag = true;
								break;
							}
						}
						if (!flag) {
							Object[] cthditem = new Object[] {
									tbSanPham.getValueAt(rindex, 0),
									tbSanPham.getValueAt(rindex, 1),
									tbSanPham.getValueAt(rindex, 2),
									tbSanPham.getValueAt(rindex, 3), 1,
									tbSanPham.getValueAt(rindex, 3) };

							ctmodel.addRow(cthditem);
						}
						tinhTT();
					}
				}
			});
			tbSanPham.getColumnModel().getColumn(0).setPreferredWidth(111);
			tbSanPham.getColumnModel().getColumn(1).setPreferredWidth(338);
			tbSanPham.getColumnModel().getColumn(2).setPreferredWidth(154);
			tbSanPham.getColumnModel().getColumn(3).setPreferredWidth(100);
			tbSanPham.getColumnModel().getColumn(3).setMinWidth(100);
			tbSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return tbSanPham;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(gl_panel_3.createParallelGroup(
					Alignment.TRAILING).addGroup(
					gl_panel_3.createSequentialGroup()
							.addContainerGap(545, Short.MAX_VALUE)
							.addComponent(getBtnXoaChiTiet()).addGap(25)));
			gl_panel_3.setVerticalGroup(gl_panel_3.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel_3
							.createSequentialGroup()
							.addContainerGap()
							.addComponent(getBtnXoaChiTiet(),
									GroupLayout.DEFAULT_SIZE,
									GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(41)));
			panel_3.setLayout(gl_panel_3);
		}
		return panel_3;
	}

	private JButton getBtnXoaChiTiet() {
		if (btnXoaChiTiet == null) {
			btnXoaChiTiet = new JButton("Xóa 1 Sản phẩm");
			btnXoaChiTiet.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					DefaultTableModel mo = (DefaultTableModel) getTbChiTiet()
							.getModel();
					int index = getTbChiTiet().getSelectedRow();
					if (index != 0)
						mo.removeRow(index);
				}
			});
		}
		return btnXoaChiTiet;
	}

	private JTable getTbDSHoaDon() {
		if (tbDSHoaDon == null) {
			tbDSHoaDon = new JTable();
			tbDSHoaDon.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tbDSHoaDon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = tbDSHoaDon.getSelectedRow();
					if (index != -1) {
						hoa_don t = hdb.getData(Integer.parseInt(tbDSHoaDon
								.getValueAt(index, 0).toString()));
						setDataInput(t);

						tabbedPane.setSelectedIndex(0);
					}
				}
			});
			tbDSHoaDon.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
				},
				new String[] {
					"M\u00E3 h\u00F3a \u0111\u01A1n", "Ng\u00E0y l\u1EADp", "T\u00EAn kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn", "Ghi ch\u00FA", "H\u1EE7y"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tbDSHoaDon.getColumnModel().getColumn(0).setPreferredWidth(100);
			tbDSHoaDon.getColumnModel().getColumn(0).setMinWidth(100);
			tbDSHoaDon.getColumnModel().getColumn(1).setPreferredWidth(100);
			tbDSHoaDon.getColumnModel().getColumn(1).setMinWidth(100);
			tbDSHoaDon.getColumnModel().getColumn(2).setPreferredWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(2).setMinWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(3).setPreferredWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(3).setMinWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(4).setPreferredWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(4).setMinWidth(150);
			tbDSHoaDon.getColumnModel().getColumn(5).setPreferredWidth(100);
			tbDSHoaDon.getColumnModel().getColumn(5).setMinWidth(100);
			tbDSHoaDon.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		return tbDSHoaDon;
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTbDSHoaDon());
		}
		return scrollPane_2;
	}

	private JLabel getLblTnKhchHng() {
		if (lblTnKhchHng == null) {
			lblTnKhchHng = new JLabel("Tên khách hàng");
			lblTnKhchHng.setBounds(15, 124, 113, 20);
		}
		return lblTnKhchHng;
	}

	private JTextField getTxtTenKhachHang() {
		if (txtTenKhachHang == null) {
			txtTenKhachHang = new JTextField();
			txtTenKhachHang.setBounds(133, 122, 179, 26);
			txtTenKhachHang.setColumns(10);
		}
		return txtTenKhachHang;
	}

	private JButton getButton_1_1() {
		if (btnHuy == null) {
			btnHuy = new JButton("Hủy phiếu");
			btnHuy.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					if (getTxtMaPhieu().getText().compareTo("") != 0) {
						if (hdb.Del(Integer.parseInt(getTxtMaPhieu().getText())) > 0) {
							JOptionPane.showMessageDialog(null,
									"Phiếu đã được hủy");
						}
					}
					clearDataInput();
				}
			});
			btnHuy.setBounds(669, 109, 166, 79);
		}
		return btnHuy;
	}

	private JPanel getPanel_5_1() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setBorder(new TitledBorder(UIManager
					.getBorder("TitledBorder.border"),
					"Tr\u1EA1ng th\u00E1i h\u00F3a \u0111\u01A1n",
					TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0,
							0)));
			panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
			panel_5.add(getRboAll());
			panel_5.add(getRboChuaHuy());
			panel_5.add(getRboDaHuy());
			panel_5.add(getBtnNewButton());
		}
		return panel_5;
	}

	private JRadioButton getRboAll() {
		if (rboAll == null) {
			rboAll = new JRadioButton("Tất cả");
			rboAll.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					getDSHD();
				}
			});
		}
		return rboAll;
	}

	private JRadioButton getRboChuaHuy() {
		if (rboChuaHuy == null) {
			rboChuaHuy = new JRadioButton("Chưa hủy");
			rboChuaHuy.setSelected(true);
			rboChuaHuy.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					getDSHD();
				}
			});
		}
		return rboChuaHuy;
	}

	private JRadioButton getRboDaHuy() {
		if (rboDaHuy == null) {
			rboDaHuy = new JRadioButton("Đã hủy");
			rboDaHuy.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					getDSHD();
				}
			});
		}
		return rboDaHuy;
	}

	/**
	 * @wbp.nonvisual location=239,579
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getRboAll());
			buttonGroup.add(getRboChuaHuy());
			buttonGroup.add(getRboDaHuy());
		}
		return buttonGroup;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Load lại");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					getDSHD();
				}
			});
			btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		}
		return btnNewButton;
	}

	private JLabel getLblTngTin() {
		if (lblTngTin == null) {
			lblTngTin = new JLabel("Tổng tiền");
			lblTngTin.setBounds(15, 160, 113, 20);
		}
		return lblTngTin;
	}

	private JTextField getTxtTongTien() {
		if (txtTongTien == null) {
			txtTongTien = new JTextField();
			txtTongTien.setEditable(false);
			txtTongTien.setText("0");
			txtTongTien.setColumns(10);
			txtTongTien.setBounds(133, 159, 179, 26);
		}
		return txtTongTien;
	}

	private JLabel getLabel_3() {
		if (lblGhiCh == null) {
			lblGhiCh = new JLabel("Ghi chú");
			lblGhiCh.setBounds(324, 16, 113, 20);
		}
		return lblGhiCh;
	}

	private JScrollPane getScrollPane_3() {
		if (scrollPane_3 == null) {
			scrollPane_3 = new JScrollPane();
			scrollPane_3.setBounds(324, 52, 305, 132);
			scrollPane_3.setViewportView(getTaGhiChu());
		}
		return scrollPane_3;
	}

	private JTextArea getTaGhiChu() {
		if (taGhiChu == null) {
			taGhiChu = new JTextArea();
		}
		return taGhiChu;
	}
}
