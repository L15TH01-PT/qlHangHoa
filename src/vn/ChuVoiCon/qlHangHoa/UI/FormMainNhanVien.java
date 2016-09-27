package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import vn.ChuVoiCon.qlHangHoa.BUS.NhanVienBUS;
import vn.ChuVoiCon.qlHangHoa.DLL.NhanVien;
import vn.ChuVoiCon.qlHangHoa.DLL.currentUser;

import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormMainNhanVien extends JFrame {
	private ArrayList<NhanVien> arrNV = new ArrayList<NhanVien>();
	NhanVienBUS nvb = new NhanVienBUS();

	private JPanel contentPane;

	private static String curUser;
	private JScrollPane scrollPane;
	private JTable tbleNhanVien;
	private DefaultTableModel NhanVienModel;
	private JLabel lblXinCho;
	private JLabel lblU;
	private JButton btnThemNV;
	private JLabel lblNewLabel;
	private JLabel lblPhngBan;
	private Choice choice;
	private JButton btnTm;
	private JTextField textField;
	private JLabel lblTnNv;
	private JLabel lblMNhnVin;
	private JLabel lblTnNhnVin;
	private JLabel lblTnNhnVin_1;
	private JLabel lblPhi;
	private JLabel lblaCh;
	private JLabel lblaCh_1;
	private JLabel lblMPhngBan;
	private JLabel lblChcV;
	private JLabel lblTnhTrngNv;
	private JLabel label;
	private JLabel lblSinThoi;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// FormMainNhanVien frame = new FormMainNhanVien(currentUser);
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 */
	public FormMainNhanVien() {
		setTitle("Qu\u1EA3n l\u00FD Nh\u00E2n Vi\u00EAn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "abc",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane());
		contentPane.add(getLblXinCho());
		contentPane.add(getLblU());
		curUser = currentUser.getTennv();
		lblU.setText(curUser + "!");
		contentPane.add(getBtnThemNV());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblPhngBan());
		contentPane.add(getChoice());
		contentPane.add(getBtnTm());
		contentPane.add(getTextField());
		contentPane.add(getLblTnNv());
		contentPane.add(getLblMNhnVin());
		contentPane.add(getLblTnNhnVin());
		contentPane.add(getLblTnNhnVin_1());
		contentPane.add(getLblPhi());
		contentPane.add(getLblaCh());
		contentPane.add(getLblaCh_1());
		contentPane.add(getLblMPhngBan());
		contentPane.add(getLblChcV());
		contentPane.add(getLblTnhTrngNv());
		contentPane.add(getLabel());
		contentPane.add(getLblSinThoi());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_4());
		contentPane.add(getTextField_5());
		contentPane.add(getTextField_6());
		contentPane.add(getTextField_7());
		contentPane.add(getTextField_8());
		contentPane.add(getTextField_9());
		contentPane.add(getTextField_10());
		contentPane.add(getTextField_11());
		if (!(curUser.equals("Admin"))) {
			btnThemNV.setEnabled(false);
			btnThemNV.setVisible(false);
		}
		arrNV = nvb.getDSNV();
		int stt = 0;
		for (NhanVien nvien : arrNV) {
			stt += 1;
			Object data[] = new Object[] { nvien.getId(), stt,
					nvien.getMa_nhan_vien(), nvien.getTen_nhan_vien(),
					nvien.getHo_nhan_vien(), nvien.getMa_phong_ban(),
					nvien.getMa_chuc_vu(), nvien.getTrang_thai() };
			NhanVienModel.addRow(data);
		}
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(9, 123, 422, 291);
			scrollPane.setViewportView(getTbleNhanVien());
		}
		return scrollPane;
	}

	private JTable getTbleNhanVien() {
		if (tbleNhanVien == null) {
			tbleNhanVien = new JTable();
			tbleNhanVien.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int index = tbleNhanVien.getSelectedRow();
					if (index != -1) {
						// int id =
						// Integer.parseInt(tbleNhanVien.getValueAt(index,
						// 0).toString());
						// NhanVien nv = nvb.getNV(id);
						// txtMaNV.setText(tennv);
						// boolean a = (boolean) table.getValueAt(index, 3);
						// if(a){
						// rdoSex.setSelected(true);
						// }else{
						// rdoSex1.setSelected(true);
						// }
					}
				}
			});
			tbleNhanVien.setModel(getNhanVienModel());
			tbleNhanVien.setDefaultEditor(Object.class, null);
			// Hide column
			tbleNhanVien.getColumnModel().getColumn(0).setMinWidth(0);
			tbleNhanVien.getColumnModel().getColumn(0).setMaxWidth(0);
			tbleNhanVien.getColumnModel().getColumn(0).setWidth(0);
		}
		return tbleNhanVien;
	}

	/**
	 * @wbp.nonvisual location=87,19
	 */
	private DefaultTableModel getNhanVienModel() {
		if (NhanVienModel == null) {
			NhanVienModel = new DefaultTableModel();
			NhanVienModel.addColumn("id");
			NhanVienModel.addColumn("STT");
			NhanVienModel.addColumn("Mã NV");
			NhanVienModel.addColumn("Họ NV");
			NhanVienModel.addColumn("Tên NV");
			NhanVienModel.addColumn("Phòng Ban");
			NhanVienModel.addColumn("Chức Vụ");
			NhanVienModel.addColumn("Tình Trạng");

		}
		return NhanVienModel;
	}

	private JLabel getLblXinCho() {
		if (lblXinCho == null) {
			lblXinCho = new JLabel("Xin ch\u00E0o: ");
			lblXinCho.setBounds(839, 11, 60, 14);
		}
		return lblXinCho;
	}

	private JLabel getLblU() {
		if (lblU == null) {
			lblU = new JLabel("");
			// lblU.setBackground(Color.RED);
			lblU.setForeground(Color.RED);
			lblU.setBounds(897, 11, 82, 14);
		}
		return lblU;
	}

	private JButton getBtnThemNV() {
		if (btnThemNV == null) {
			btnThemNV = new JButton("Th\u00EAm");
			btnThemNV.setBounds(238, 17, 89, 23);
		}
		return btnThemNV;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Danh S\u00E1ch Nh\u00E2n Vi\u00EAn");
			lblNewLabel.setForeground(SystemColor.RED);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel.setBounds(52, 98, 157, 14);
		}
		return lblNewLabel;
	}

	private JLabel getLblPhngBan() {
		if (lblPhngBan == null) {
			lblPhngBan = new JLabel("Ph\u00F2ng ban:");
			lblPhngBan.setBounds(9, 23, 67, 14);
		}
		return lblPhngBan;
	}

	private Choice getChoice() {
		if (choice == null) {
			choice = new Choice();
			choice.setBounds(78, 17, 150, 20);
		}
		return choice;
	}

	private JButton getBtnTm() {
		if (btnTm == null) {
			btnTm = new JButton("T\u00ECm");
			btnTm.setBounds(238, 61, 89, 23);
		}
		return btnTm;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(78, 62, 150, 20);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblTnNv() {
		if (lblTnNv == null) {
			lblTnNv = new JLabel("T\u00EAn nv: ");
			lblTnNv.setBounds(9, 57, 60, 30);
		}
		return lblTnNv;
	}

	private JLabel getLblMNhnVin() {
		if (lblMNhnVin == null) {
			lblMNhnVin = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
			lblMNhnVin.setBounds(448, 135, 99, 23);
		}
		return lblMNhnVin;
	}

	private JLabel getLblTnNhnVin() {
		if (lblTnNhnVin == null) {
			lblTnNhnVin = new JLabel("H\u1ECD & t\u00EAn \u0111\u1EC7m");
			lblTnNhnVin.setBounds(448, 169, 99, 23);
		}
		return lblTnNhnVin;
	}

	private JLabel getLblTnNhnVin_1() {
		if (lblTnNhnVin_1 == null) {
			lblTnNhnVin_1 = new JLabel("T\u00EAn Nh\u00E2n Vi\u00EAn");
			lblTnNhnVin_1.setBounds(720, 169, 92, 23);
		}
		return lblTnNhnVin_1;
	}

	private JLabel getLblPhi() {
		if (lblPhi == null) {
			lblPhi = new JLabel("Gi\u1EDBi t\u00EDnh");
			lblPhi.setBounds(448, 203, 99, 23);
		}
		return lblPhi;
	}

	private JLabel getLblaCh() {
		if (lblaCh == null) {
			lblaCh = new JLabel("Ng\u00E0y Sinh");
			lblaCh.setBounds(720, 203, 77, 23);
		}
		return lblaCh;
	}

	private JLabel getLblaCh_1() {
		if (lblaCh_1 == null) {
			lblaCh_1 = new JLabel("\u0110\u1ECBa ch\u1EC9");
			lblaCh_1.setBounds(448, 237, 99, 23);
		}
		return lblaCh_1;
	}

	private JLabel getLblMPhngBan() {
		if (lblMPhngBan == null) {
			lblMPhngBan = new JLabel("Ph\u00F2ng ban");
			lblMPhngBan.setBounds(448, 376, 99, 23);
		}
		return lblMPhngBan;
	}

	private JLabel getLblChcV() {
		if (lblChcV == null) {
			lblChcV = new JLabel("Ch\u1EE9c v\u1EE5");
			lblChcV.setBounds(720, 376, 59, 23);
		}
		return lblChcV;
	}

	private JLabel getLblTnhTrngNv() {
		if (lblTnhTrngNv == null) {
			lblTnhTrngNv = new JLabel("T\u00ECnh tr\u1EA1ng NV");
			lblTnhTrngNv.setBounds(448, 342, 99, 23);
		}
		return lblTnhTrngNv;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("L\u01B0\u01A1ng");
			label.setBounds(720, 342, 59, 23);
		}
		return label;
	}

	private JLabel getLblSinThoi() {
		if (lblSinThoi == null) {
			lblSinThoi = new JLabel(
					"\u0110i\u1EC7n tho\u1EA1i li\u00EAn h\u1EC7");
			lblSinThoi.setBounds(448, 271, 99, 23);
		}
		return lblSinThoi;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(552, 135, 147, 23);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(552, 170, 147, 23);
		}
		return textField_2;
	}

	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(552, 204, 147, 23);
		}
		return textField_3;
	}

	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(552, 238, 422, 23);
		}
		return textField_4;
	}

	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(552, 272, 147, 23);
		}
		return textField_5;
	}

	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(552, 376, 147, 23);
		}
		return textField_6;
	}

	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(552, 342, 147, 23);
		}
		return textField_7;
	}

	private JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(822, 169, 152, 23);
		}
		return textField_8;
	}

	private JTextField getTextField_9() {
		if (textField_9 == null) {
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(822, 203, 152, 23);
		}
		return textField_9;
	}

	private JTextField getTextField_10() {
		if (textField_10 == null) {
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(822, 376, 152, 23);
		}
		return textField_10;
	}

	private JTextField getTextField_11() {
		if (textField_11 == null) {
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(822, 342, 152, 23);
		}
		return textField_11;
	}
}
