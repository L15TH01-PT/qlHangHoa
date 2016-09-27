package vn.ChuVoiCon.qlHangHoa.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class jfNhapKho extends JFrame {

	private JPanel contentPane;
	private JTextField txtSL;
	private JTextField txtDG;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfNhapKho frame = new jfNhapKho();
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
	public jfNhapKho() {
		setTitle("Nh\u1EADp Kho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChnSnPhmr = new JLabel("Ch\u1ECDn s\u1EA3n ph\u1EA9m:");
		lblChnSnPhmr.setBounds(10, 11, 96, 14);
		contentPane.add(lblChnSnPhmr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 148, 182);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblNhpSLng = new JLabel("Nh\u1EADp s\u1ED1 l\u01B0\u1EE3ng:");
		lblNhpSLng.setBounds(248, 72, 77, 14);
		contentPane.add(lblNhpSLng);
		
		txtSL = new JTextField();
		txtSL.setBounds(327, 69, 70, 20);
		contentPane.add(txtSL);
		txtSL.setColumns(10);
		
		JLabel lblNhpnGi = new JLabel("Nh\u1EADp \u0111\u01A1n gi\u00E1:");
		lblNhpnGi.setBounds(420, 72, 77, 14);
		contentPane.add(lblNhpnGi);
		
		txtDG = new JTextField();
		txtDG.setColumns(10);
		txtDG.setBounds(502, 69, 104, 20);
		contentPane.add(txtDG);
		
		JButton btnAdd = new JButton("Th\u00EAm v\u00E0o phi\u1EBFu");
		btnAdd.setBounds(382, 128, 126, 23);
		contentPane.add(btnAdd);
		
		JLabel lblSnPhm = new JLabel("S\u1EA3n ph\u1EA9m:");
		lblSnPhm.setBounds(248, 36, 60, 14);
		contentPane.add(lblSnPhm);
		
		JLabel lblChaChn = new JLabel("ch\u01B0a ch\u1ECDn");
		lblChaChn.setBounds(327, 36, 70, 14);
		contentPane.add(lblChaChn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 239, 498, 125);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnNhpKho = new JButton("Nh\u1EADp kho");
		btnNhpKho.setBounds(517, 236, 112, 23);
		contentPane.add(btnNhpKho);
		
		JButton btnXaSp = new JButton("X\u00F3a SP \u0111\u00E3 ch\u1ECDn");
		btnXaSp.setBounds(517, 270, 112, 23);
		contentPane.add(btnXaSp);
	}
}
