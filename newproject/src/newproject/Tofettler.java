package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
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

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Tofettler extends JFrame {

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
					Tofettler frame = new Tofettler();
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
	public Tofettler() {
		setTitle("GIVEN TO  FETTLER");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tofettler.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1242, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_1459084591000522");
		
		JLabel label_3 = new JLabel("Company Name :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel(" Qty. :\r\n");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_6 = new JLabel("Date :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel label_7 = new JLabel("Dc No. :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("Paint /Thinner:");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel df = (DefaultTableModel) table.getModel();
				 DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				 
				 df.addRow(new Object[]  {comboBox.getSelectedItem().toString(),textField_2.getText()	,textField_3.getText()
						 ,df1.format(dateChooser.getDate()),textField_4.getText()});
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DETAILS OF PAINT AND THINNER", "FETTLER", "QTY", "DATE", "DC NO."
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(176);
		scrollPane.setViewportView(table);
		
		JToolBar toolBar = new JToolBar();
		
		JDateChooser dateChooser_1 = new JDateChooser();
		JPanel panel_2 = new JPanel();
		
		JMenuItem menuItem = new JMenuItem("PRINT");
		menuItem.setIcon(new ImageIcon(Tofettler.class.getResource("/must_have_icon_set/Print/Print_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Abc ="/Reports/internal.jrxml"	;
				InputStream in = null ;
			try {
		//		JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/EXTRANAL.jrxml");
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
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("BACK");
		menuItem_1.setIcon(new ImageIcon(Tofettler.class.getResource("/must_have_icon_set/Log Out/Log Out_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		
		JLabel lblGivenToFettler = new JLabel("GIVEN TO FETTLER\r\n");
		lblGivenToFettler.setForeground(Color.WHITE);
		lblGivenToFettler.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGivenToFettler.setBackground(new Color(102, 51, 51));
		lblGivenToFettler.setBounds(10, 0, 230, 27);
		panel_1.add(lblGivenToFettler);
		
		JLabel lblMonth = new JLabel("MONTH :-");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		
		
		scrollPane_1.setViewportView(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("Contact :9380665986");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_1.setBackground(new Color(102, 51, 51));
		
		JLabel label_2 = new JLabel("VK32 Technologies & Services\r\n");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		label_2.setBackground(new Color(102, 51, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(128)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1216, Short.MAX_VALUE)
				.addComponent(separator, GroupLayout.PREFERRED_SIZE, 526, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 552, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(357)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(128)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(413)
					.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(128)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(128)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(356)
					.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(130)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(614)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(79)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(138)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(476)
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(169)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(197)
							.addComponent(button))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(198)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(79)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(139)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(199)
							.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(243)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(113)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(168)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(83)
							.addComponent(lblMonth))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(80)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}
}
