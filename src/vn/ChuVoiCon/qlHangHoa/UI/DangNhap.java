package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DangNhap extends JFrame {

	private JPanel contentPane;
	private JLabel lblngNhp;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblMtKhu;
	private JButton btnngNhp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap frame = new DangNhap();
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
	public DangNhap() {
		setTitle("\u0110\u0103ng Nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblngNhp());
		contentPane.add(getLblNewLabel());
		contentPane.add(getTextField());
		contentPane.add(getPasswordField());
		contentPane.add(getLblMtKhu());
		contentPane.add(getBtnngNhp());
	}
	private JLabel getLblngNhp() {
		if (lblngNhp == null) {
			lblngNhp = new JLabel("\u0110\u0103ng Nh\u1EADp");
			lblngNhp.setFont(new Font("Cambria Math", Font.BOLD, 20));
			lblngNhp.setForeground(Color.BLACK);
			lblngNhp.setBackground(Color.BLACK);
			lblngNhp.setBounds(153, 11, 129, 58);
		}
		return lblngNhp;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("T\u00E0i Kho\u1EA3n");
			lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			lblNewLabel.setBounds(73, 81, 80, 18);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(153, 80, 146, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(153, 129, 146, 20);
		}
		return passwordField;
	}
	private JLabel getLblMtKhu() {
		if (lblMtKhu == null) {
			lblMtKhu = new JLabel("M\u1EADt Kh\u1EA9u");
			lblMtKhu.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			lblMtKhu.setBounds(73, 132, 67, 14);
		}
		return lblMtKhu;
	}
	private JButton getBtnngNhp() {
		if (btnngNhp == null) {
			btnngNhp = new JButton("\u0110\u0103ng nh\u1EADp");
			btnngNhp.setFont(new Font("Cambria Math", Font.PLAIN, 15));
			btnngNhp.setBounds(153, 176, 111, 23);
		}
		return btnngNhp;
	}
}
