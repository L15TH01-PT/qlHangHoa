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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jfMain extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNhanVien;
	private JMenu mnSanPham;
	private JMenu mnHoaDon;
	private JMenu mnKho;
	private JMenuItem mntmLoaiSP;
	private JMenuItem mntmNhaCungCap;
	private JMenuItem mntmChiTietSP;
	private JInternalFrame internalFrame;

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
	public jfMain() {
		if(currentUser.getNv() == null)
		{
			System.exit(0);
//			FormDangNhap frame = new FormDangNhap();
//			frame.setVisible(true);
//			return;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		//contentPane.add(getInternalFrame());
		// if(currentUser.getNv() == null)
		// {
		// FormDangNhap ifdn = new FormDangNhap();
		// ifdn.show();
		// }
	}

	private void callNewFrame(JInternalFrame newFrame){
		contentPane.remove(getInternalFrame());
		getInternalFrame().dispose();
		internalFrame = newFrame;
		contentPane.add(internalFrame);
		internalFrame.setVisible(true);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNhanVien());
			menuBar.add(getMnSanPham());
			menuBar.add(getMnHoaDon());
			menuBar.add(getMnKho());
		}
		return menuBar;
	}

	private JMenu getMnNhanVien() {
		if (mnNhanVien == null) {
			mnNhanVien = new JMenu("Nhân viên");
			mnNhanVien.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					callNewFrame(new FormMainNhanVien());
				}
			});
		}
		return mnNhanVien;
	}

	private JMenu getMnSanPham() {
		if (mnSanPham == null) {
			mnSanPham = new JMenu("Sản phẩm");
			mnSanPham.add(getMntmChiTietSP());
			mnSanPham.add(getMntmLoaiSP());
			mnSanPham.add(getMntmNhaCungCap());
		}
		return mnSanPham;
	}

	private JMenu getMnHoaDon() {
		if (mnHoaDon == null) {
			mnHoaDon = new JMenu("Hóa đơn");
			mnHoaDon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					callNewFrame(new jfHoaDon());
				}
			});
		}
		return mnHoaDon;
	}

	private JMenu getMnKho() {
		if (mnKho == null) {
			mnKho = new JMenu("Kho");
			mnKho.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					callNewFrame(new jfKho());
				}
			});
		}
		return mnKho;
	}

	private JMenuItem getMntmLoaiSP() {
		if (mntmLoaiSP == null) {
			mntmLoaiSP = new JMenuItem("Loại sản phẩm");
			mntmLoaiSP.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
					callNewFrame(new jfLoaiSanPham());
			    }
			});
		}
		return mntmLoaiSP;
	}

	private JMenuItem getMntmNhaCungCap() {
		if (mntmNhaCungCap == null) {
			mntmNhaCungCap = new JMenuItem("Nhà cung cấp");
			mntmNhaCungCap.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
					callNewFrame(new jfNhaCungCap());
			    }
			});
		}
		return mntmNhaCungCap;
	}

	private JMenuItem getMntmChiTietSP() {
		if (mntmChiTietSP == null) {
			mntmChiTietSP = new JMenuItem("Chi tiết sản phẩm");
			mntmChiTietSP.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
					callNewFrame(new jfChiTietSanPham());
			    }
			});
		}
		return mntmChiTietSP;
	}

	private JInternalFrame getInternalFrame() {
		if (internalFrame == null) {
			internalFrame = new JInternalFrame();
			internalFrame.setVisible(true);
		}
		return internalFrame;
	}
}
