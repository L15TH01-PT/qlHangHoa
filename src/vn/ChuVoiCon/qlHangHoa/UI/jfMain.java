
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
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

public class jfMain extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenuItem menuItem;
	private JMenuItem mntmNhSnXut;
	private JMenuItem mntmChiTitSn;

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
		setBounds(100, 100, 1184, 741);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
//		if(currentUser.getNv() == null)
//		{
//			FormDangNhap ifdn = new FormDangNhap();
//			ifdn.show();
//		}
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
			menuBar.add(getMnNewMenu_1());
			menuBar.add(getMnNewMenu_2());
			menuBar.add(getMnNewMenu_3());
		}
		return menuBar;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("Nhân viên");
			mnNewMenu.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FormMainNhanVien jf = new FormMainNhanVien();
					jf.show();
				}
			});
		}
		return mnNewMenu;
	}
	private JMenu getMnNewMenu_1() {
		if (mnNewMenu_1 == null) {
			mnNewMenu_1 = new JMenu("Sản phẩm");
			mnNewMenu_1.add(getMntmChiTitSn());
			mnNewMenu_1.add(getMenuItem());
			mnNewMenu_1.add(getMntmNhSnXut());
		}
		return mnNewMenu_1;
	}
	private JMenu getMnNewMenu_2() {
		if (mnNewMenu_2 == null) {
			mnNewMenu_2 = new JMenu("Hóa đơn");
			mnNewMenu_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return mnNewMenu_2;
	}
	private JMenu getMnNewMenu_3() {
		if (mnNewMenu_3 == null) {
			mnNewMenu_3 = new JMenu("Kho");
			mnNewMenu_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return mnNewMenu_3;
	}
	private JMenuItem getMenuItem() {
		if (menuItem == null) {
			menuItem = new JMenuItem("Loại sản phẩm");
			menuItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return menuItem;
	}
	private JMenuItem getMntmNhSnXut() {
		if (mntmNhSnXut == null) {
			mntmNhSnXut = new JMenuItem("Nhà  sản xuất");
			mntmNhSnXut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return mntmNhSnXut;
	}
	private JMenuItem getMntmChiTitSn() {
		if (mntmChiTitSn == null) {
			mntmChiTitSn = new JMenuItem("Chi tiết sản phẩm");
			mntmChiTitSn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				}
			});
		}
		return mntmChiTitSn;
	}
}
