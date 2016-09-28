
package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import vn.ChuVoiCon.qlHangHoa.DLL.currentUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfMain extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfMain frame = new jfMain();
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
	public jfMain() {
//		if(currentUser.getNv() == null)
//			System.exit(1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getButton());
		if(currentUser.getNv() == null)
		{
//			System.exit(1);
			FormDangNhap ifdn = new FormDangNhap();
			ifdn.show();
		}
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Nh\u00E2n vi\u00EAn");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					FormMainNhanVien fnv = new FormMainNhanVien();
					fnv.show();
				}
			});
			btnNewButton.setBounds(10, 57, 89, 23);
		}
		return btnNewButton;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("New button");
			button.setBounds(10, 96, 89, 23);
		}
		return button;
	}
}
