package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class jfHoaDon extends JInternalFrame {

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
	private JTable tbChiTiet;
	private JScrollPane scrollPane_1;
	private JTable tbSanPham;
	private JPanel panel_3;
	private JButton button_3;
	private JTable table_2;
	private JScrollPane scrollPane_2;
	private JPanel panel_5;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JLabel lblTnKhchHng;
	private JTextField txtTenKhachHang;
	private JButton btnHuy;

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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getTabbedPane_1());
	}
	private JTabbedPane getTabbedPane_1() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.addTab("New tab", null, getPanel_8(), null);
			tabbedPane.addTab("New tab", null, getPanel_1_1(), null);
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
					RowSpec.decode("top:200px"),
					RowSpec.decode("fill:default"),
					RowSpec.decode("bottom:60px"),}));
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
			panel_2.add(getBtnLap());
			panel_2.add(getButton_1_1());
		}
		return panel_2;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_4.setBounds(10, 10, 500, 178);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[] {38, 0, 200, 0};
			gbl_panel_4.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
			gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
			panel_4.setLayout(gbl_panel_4);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.NORTH;
			gbc_label.fill = GridBagConstraints.HORIZONTAL;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 1;
			panel_4.add(getLabel(), gbc_label);
			GridBagConstraints gbc_txtMaPhieu = new GridBagConstraints();
			gbc_txtMaPhieu.anchor = GridBagConstraints.NORTH;
			gbc_txtMaPhieu.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMaPhieu.insets = new Insets(0, 0, 5, 5);
			gbc_txtMaPhieu.gridx = 2;
			gbc_txtMaPhieu.gridy = 1;
			panel_4.add(getTxtMaPhieu(), gbc_txtMaPhieu);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.NORTH;
			gbc_label_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 2;
			panel_4.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_txtNgayLap = new GridBagConstraints();
			gbc_txtNgayLap.anchor = GridBagConstraints.NORTH;
			gbc_txtNgayLap.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtNgayLap.insets = new Insets(0, 0, 5, 5);
			gbc_txtNgayLap.gridx = 2;
			gbc_txtNgayLap.gridy = 2;
			panel_4.add(getTxtNgayLap(), gbc_txtNgayLap);
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.NORTH;
			gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 1;
			gbc_label_2.gridy = 3;
			panel_4.add(getLabel_2(), gbc_label_2);
			GridBagConstraints gbc_txtNhanVien = new GridBagConstraints();
			gbc_txtNhanVien.insets = new Insets(0, 0, 5, 5);
			gbc_txtNhanVien.fill = GridBagConstraints.BOTH;
			gbc_txtNhanVien.gridx = 2;
			gbc_txtNhanVien.gridy = 3;
			panel_4.add(getTxtNhanVien(), gbc_txtNhanVien);
			GridBagConstraints gbc_lblTnKhchHng = new GridBagConstraints();
			gbc_lblTnKhchHng.anchor = GridBagConstraints.EAST;
			gbc_lblTnKhchHng.insets = new Insets(0, 0, 5, 5);
			gbc_lblTnKhchHng.gridx = 1;
			gbc_lblTnKhchHng.gridy = 4;
			panel_4.add(getLblTnKhchHng(), gbc_lblTnKhchHng);
			GridBagConstraints gbc_txtTenKhachHang = new GridBagConstraints();
			gbc_txtTenKhachHang.insets = new Insets(0, 0, 5, 5);
			gbc_txtTenKhachHang.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTenKhachHang.gridx = 2;
			gbc_txtTenKhachHang.gridy = 4;
			panel_4.add(getTxtTenKhachHang(), gbc_txtTenKhachHang);
		}
		return panel_4;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Mã phiếu");
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Ngày lập");
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Nhân Viên");
		}
		return label_2;
	}
	private JTextField getTxtMaPhieu() {
		if (txtMaPhieu == null) {
			txtMaPhieu = new JTextField();
			txtMaPhieu.setEnabled(false);
			txtMaPhieu.setColumns(10);
		}
		return txtMaPhieu;
	}
	private JTextField getTxtNgayLap() {
		if (txtNgayLap == null) {
			txtNgayLap = new JTextField();
			txtNgayLap.setEnabled(false);
			txtNgayLap.setColumns(10);
		}
		return txtNgayLap;
	}
	private JTextField getTxtNhanVien() {
		if (txtNhanVien == null) {
			txtNhanVien = new JTextField();
			txtNhanVien.setEnabled(false);
			txtNhanVien.setColumns(10);
		}
		return txtNhanVien;
	}
	private JButton getBtnLap() {
		if (btnLap == null) {
			btnLap = new JButton("Lập Phiếu");
			btnLap.setBounds(525, 10, 166, 79);
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
			tbChiTiet.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "Th\u00E0nh ti\u1EC1n"
				}
			) {
				Class[] columnTypes = new Class[] {
					Object.class, Object.class, String.class, Double.class, Integer.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, true, true
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
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
			tbSanPham.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n v\u1ECB t\u00EDnh"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, Object.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tbSanPham.getColumnModel().getColumn(0).setPreferredWidth(111);
			tbSanPham.getColumnModel().getColumn(1).setPreferredWidth(338);
			tbSanPham.getColumnModel().getColumn(2).setPreferredWidth(154);
		}
		return tbSanPham;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			GroupLayout gl_panel_3 = new GroupLayout(panel_3);
			gl_panel_3.setHorizontalGroup(
				gl_panel_3.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap(545, Short.MAX_VALUE)
						.addComponent(getButton_3())
						.addGap(25))
			);
			gl_panel_3.setVerticalGroup(
				gl_panel_3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_3.createSequentialGroup()
						.addContainerGap()
						.addComponent(getButton_3(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(41))
			);
			panel_3.setLayout(gl_panel_3);
		}
		return panel_3;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("Xóa 1 Sản phẩm");
		}
		return button_3;
	}
	private JTable getTable_2() {
		if (table_2 == null) {
			table_2 = new JTable();
		}
		return table_2;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane_2 == null) {
			scrollPane_2 = new JScrollPane();
			scrollPane_2.setViewportView(getTable_2());
		}
		return scrollPane_2;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getRdbtnNewRadioButton());
			panel_5.add(getRdbtnNewRadioButton_1());
		}
		return panel_5;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("New radio button");
			rdbtnNewRadioButton.setBounds(31, 7, 109, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
			rdbtnNewRadioButton_1.setBounds(168, 7, 109, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JLabel getLblTnKhchHng() {
		if (lblTnKhchHng == null) {
			lblTnKhchHng = new JLabel("Tên khách hàng");
		}
		return lblTnKhchHng;
	}
	private JTextField getTxtTenKhachHang() {
		if (txtTenKhachHang == null) {
			txtTenKhachHang = new JTextField();
			txtTenKhachHang.setColumns(10);
		}
		return txtTenKhachHang;
	}
	private JButton getButton_1_1() {
		if (btnHuy == null) {
			btnHuy = new JButton("Hủy phiếu");
			btnHuy.setBounds(525, 109, 166, 79);
		}
		return btnHuy;
	}
}

