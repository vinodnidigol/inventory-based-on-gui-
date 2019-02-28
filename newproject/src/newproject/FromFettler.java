package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FromFettler extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FromFettler frame = new FromFettler();
					frame.setExtendedState(frame.MAXIMIZED_BOTH);
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
	public FromFettler() {
		setTitle("RECEIVED FROM FETTLER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FromFettler.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1120, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_1458291291795716");
		
		JLabel lblPaint = new JLabel("Paint /Thinner:");
		lblPaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblFettlerCompanyName = new JLabel("FETTLER Name :");
		lblFettlerCompanyName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblQty = new JLabel(" Qty. :\r\n");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDcNo = new JLabel("Dc No. :");
		lblDcNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("RED OXIDE");
		comboBox.addItem("QD THINNER");
		comboBox.addItem("DOWN GLOW");
		comboBox.addItem("TAFE CHARCOAL GREY PAINT");
		comboBox.addItem("TAFE THINNER");
		comboBox.addItem("APPG");
		comboBox.addItem("NC THINNER");
		comboBox.addItem("KOEL GREEN PAINT");
		comboBox.addItem("KOEL THINNER");
		comboBox.addItem("QD SELAR BLACK");
		comboBox.addItem("ZINCHROMITE");
		comboBox.addItem("STEEL GREY");
		comboBox.addItem("BLUE PAINT");
		comboBox.addItem("LIGHT GREEN PAINT");
		comboBox.addItem("APOXY GREY");
		comboBox.addItem("APOXY THINNER");
		comboBox.addItem("M&M CH GREY-KNP");
		comboBox.addItem("M&M CH GREY THINNER-KNP");
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DETAILS OF PAINT AND THINNER", "FETTLER", "QTY", "DATE", "DC NO."
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(177);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel df = (DefaultTableModel) table.getModel();
				 DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				 
				 df.addRow(new Object[]  {comboBox.getSelectedItem().toString(),textField_2.getText()	,textField_3.getText()
						 ,df1.format(dateChooser.getDate()),textField_4.getText()});
			}
		});
		
		JToolBar toolBar = new JToolBar();
		
		JDateChooser dateChooser_1 = new JDateChooser();
		JPanel panel_2 = new JPanel();
		
		JMenuItem mntmPrint = new JMenuItem("PRINT");
		mntmPrint.setIcon(new ImageIcon(FromFettler.class.getResource("/must_have_icon_set/Print/Print_24x24.png")));
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Abc ="/Reports/internal.jrxml"	;
				InputStream in = null ;
			try {
		//		JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/internal.jrxml");
				in =this.getClass().getResourceAsStream(Abc);
				JasperReport j1 = JasperCompileManager.compileReport(in);
				DefaultTableModel m1 = (DefaultTableModel) table.getModel();
				Map<String, Object>	params = new HashMap<String, Object>();
//				
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				params.put("a", dateChooser_1.getDate());
				JasperPrint jp = JasperFillManager.fillReport(j1, params,new JRTableModelDataSource(m1));
			//	JasperViewer.viewReport(jp,false);
				panel_2.removeAll();
				panel_2.setLayout(new BorderLayout());
				panel_2.repaint();
				panel_2.add(new JRViewer(jp));
				panel_2.revalidate();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		mntmPrint.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mntmPrint.setForeground(Color.WHITE);
		mntmPrint.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmPrint);
		
		JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.setIcon(new ImageIcon(FromFettler.class.getResource("/must_have_icon_set/Log Out/Log Out_24x24.png")));
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		mntmBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mntmBack.setForeground(Color.WHITE);
		mntmBack.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		
		JLabel lblReceivedFromFettler = new JLabel("RECEIVED FROM FETTLER\r\n");
		lblReceivedFromFettler.setForeground(Color.WHITE);
		lblReceivedFromFettler.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblReceivedFromFettler.setBackground(new Color(102, 51, 51));
		lblReceivedFromFettler.setBounds(10, 0, 230, 27);
		panel_1.add(lblReceivedFromFettler);
		
		JLabel label = new JLabel("MONTH :-");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		scrollPane_1.setViewportView(panel_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 602, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPaint, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(57)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFettlerCompanyName, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblQty, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDcNo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPaint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label)))
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFettlerCompanyName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQty, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(lblDcNo, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAdd))
							.addGap(26)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
	}
}
