package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class jfNhaCungCap extends JFrame {

	private JPanel contentPane;
	private JLabel lblMNhCung;
	private JLabel lblTnNhCung;
	private JLabel lblNgiLinH;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfNhaCungCap frame = new jfNhaCungCap();
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
		setBounds(100, 100, 538, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblMNhCung());
		contentPane.add(getLblTnNhCung());
		contentPane.add(getLblNgiLinH());
		contentPane.add(getLblSinThoi());
		contentPane.add(getLblaCh());
		contentPane.add(getTextField());
		contentPane.add(getTextField_1());
		contentPane.add(getTextField_2());
		contentPane.add(getTextField_3());
		contentPane.add(getTextField_4());
		contentPane.add(getBtnNewButton());
		contentPane.add(getBtnNewButton_1());
		contentPane.add(getBtnNewButton_2());
		contentPane.add(getList());
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
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(138, 7, 128, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(138, 32, 221, 20);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(138, 57, 221, 20);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(138, 82, 128, 20);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setBounds(138, 109, 272, 20);
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Th\u00EAm");
			btnNewButton.setBounds(423, 16, 89, 38);
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Xo\u00E1");
			btnNewButton_1.setBounds(423, 55, 89, 38);
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("S\u1EEDa");
			btnNewButton_2.setBounds(423, 94, 89, 38);
		}
		return btnNewButton_2;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(10, 136, 502, 114);
		}
		return list;
	}
}
