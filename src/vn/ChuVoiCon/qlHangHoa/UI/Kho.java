package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Kho extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kho frame = new Kho();
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
	public Kho() {
		setTitle("KHO H\u00C0NG H\u00D3A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnThmSnPhm = new JButton("Th\u00EAm S\u1EA3n ph\u1EA9m m\u1EDBi");
		btnThmSnPhm.setBounds(10, 217, 127, 23);
		contentPane.add(btnThmSnPhm);
		
		JButton btnNewButton = new JButton("Nh\u1EADp h\u00E0ng h\u00F3a");
		btnNewButton.setBounds(142, 217, 153, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chi ti\u1EBFt nh\u1EADp");
		btnNewButton_1.setBounds(302, 217, 122, 23);
		contentPane.add(btnNewButton_1);
	}
}
