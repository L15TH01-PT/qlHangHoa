package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import vn.ChuVoiCon.qlHangHoa.BUS.nhap_khoBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.currentUser;
import vn.ChuVoiCon.qlHangHoa.DLL.phieu_nhap;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;

public class jfPhieuNhapKho extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelPNK;

	nhap_khoBUS nkb = new nhap_khoBUS();
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnDel;
	private JLabel lblMa;
	private JRadioButton rdbtnFull;
	private JRadioButton rdbtnNotDel;
	private JRadioButton rdbtnDeleted;
	private int act = 1;
	private ButtonGroup buttonGroup;

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
	 * 
	 * @throws SQLException
	 */
	public jfPhieuNhapKho() throws SQLException {
		setTitle("Phi\u1EBFu \u0110\u00E3 Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getTextField());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnDel());
		contentPane.add(getLblMa());
		contentPane.add(getRdbtnFull());
		contentPane.add(getRdbtnNotDel());
		contentPane.add(getRdbtnDeleted());
		getButtonGroup();
		showDSPhieu();
	}

	public void showDSPhieu() {
		while (getModelPNK().getRowCount() > 0) {
			modelPNK.removeRow(0);
		}
		for (phieu_nhap a : nkb.getDSPhieu(act)) {
			Object ob[] = new Object[] { a.getMa_phieu_nhap(), a.getNgay_lap(),
					a.getId_nv() };
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
			String colsname[] = { "Mã phiếu nhập", "Ngày lập",
					"Nhân viên nhập phiếu" };
			modelPNK.setColumnIdentifiers(colsname);
		}
		return modelPNK;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(10, 177, 86, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int manv = Integer.parseInt(textField.getText());
					if (nkb.addPhieu(manv)) {
						JOptionPane.showMessageDialog(null, "Them thanh cong");
						showDSPhieu();
					}

				}
			});
			btnNewButton.setBounds(104, 177, 89, 23);
		}
		return btnNewButton;
	}

	private JButton getBtnDel() {
		if (btnDel == null) {
			btnDel = new JButton("Del");
			btnDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (getTable().getSelectedRowCount() > 0) {
						int index = table.getSelectedRow();
						int ma = Integer.parseInt(table.getValueAt(index, 0)
								.toString());
						lblMa.setText(ma + "");
						if (nkb.delPhieu(ma)) {
							JOptionPane.showMessageDialog(null,
									"Xoa thanh cong");
							showDSPhieu();
						}
					}
				}
			});
			btnDel.setBounds(203, 177, 89, 23);
		}
		return btnDel;
	}

	private JLabel getLblMa() {
		if (lblMa == null) {
			lblMa = new JLabel("lblMa");
			lblMa.setBounds(342, 180, 46, 14);
		}
		return lblMa;
	}

	private JRadioButton getRdbtnFull() {
		if (rdbtnFull == null) {
			rdbtnFull = new JRadioButton("Full");
			rdbtnFull.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					act = 0;
					showDSPhieu();
				}
			});
			rdbtnFull.setBounds(430, 35, 109, 23);
		}
		return rdbtnFull;
	}

	private JRadioButton getRdbtnNotDel() {
		if (rdbtnNotDel == null) {
			rdbtnNotDel = new JRadioButton("Not Del");
			rdbtnNotDel.setSelected(true);
			rdbtnNotDel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					act = 1;
					showDSPhieu();
				}
			});
			rdbtnNotDel.setBounds(430, 71, 109, 23);
		}
		return rdbtnNotDel;
	}

	private JRadioButton getRdbtnDeleted() {
		if (rdbtnDeleted == null) {
			rdbtnDeleted = new JRadioButton("Deleted");
			rdbtnDeleted.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					act = -1;
					showDSPhieu();
				}
			});
			rdbtnDeleted.setBounds(430, 106, 109, 23);
		}
		return rdbtnDeleted;
	}

	/**
	 * @wbp.nonvisual location=432,209
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getRdbtnFull());
			buttonGroup.add(getRdbtnNotDel());
			buttonGroup.add(getRdbtnDeleted());
		}
		return buttonGroup;
	}
}
