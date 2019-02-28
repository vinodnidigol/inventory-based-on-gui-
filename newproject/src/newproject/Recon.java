package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
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

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Recon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recon frame = new Recon();
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
	public Recon() {
		setTitle("PAINT RECONCILLATION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Recon.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1098, 548);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_23386328466928");
		
		JToolBar toolBar = new JToolBar();
		
		JPanel panel_2 = new JPanel();
		JDateChooser dateChooser = new JDateChooser();
		
		JMenuItem mntmPrint = new JMenuItem("PRINT");
		mntmPrint.setIcon(new ImageIcon(Recon.class.getResource("/must_have_icon_set/Print/Print_24x24.png")));
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Abc ="/Reports/Recons.jrxml"	;
				InputStream in = null ;
			try {
		//		JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Recons.jrxml");
				in =this.getClass().getResourceAsStream(Abc);
				JasperReport j1 = JasperCompileManager.compileReport(in);
				DefaultTableModel m1 = (DefaultTableModel) table.getModel();
				Map<String, Object>	params = new HashMap<String, Object>();
//				
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				params.put("a", dateChooser.getDate());
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
		mntmPrint.setForeground(Color.WHITE);
		mntmPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmPrint.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmPrint);
		
		JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.setIcon(new ImageIcon(Recon.class.getResource("/must_have_icon_set/Log Out/Log Out_24x24.png")));
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		mntmBack.setForeground(Color.WHITE);
		mntmBack.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mntmBack.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmBack);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setLayout(null);
		
		JLabel lblPaintReconcillationBy = new JLabel("PAINT RECONCILLATION BY FETTLER");
		lblPaintReconcillationBy.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPaintReconcillationBy.setForeground(Color.WHITE);
		lblPaintReconcillationBy.setBounds(10, 0, 279, 27);
		panel_1.add(lblPaintReconcillationBy);
		
		JLabel lblDetailsOfPaint = new JLabel("Details of Paint And Thinner :");
		lblDetailsOfPaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblOpeningBalance = new JLabel("opening Balance :");
		lblOpeningBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblReceivedQty = new JLabel("Received Qty :");
		lblReceivedQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblFromFettlerQty = new JLabel("From Fettler Qty :");
		lblFromFettlerQty.setBackground(new Color(204, 204, 153));
		lblFromFettlerQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblToFettlerQty = new JLabel("To Fettler Qty :");
		lblToFettlerQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblClosingBalance = new JLabel("Closing Balance :");
		lblClosingBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblActualConsumption = new JLabel("Actual Consumption :");
		lblActualConsumption.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblConsumptionAsPer = new JLabel("Consumption As Per Norms :");
		lblConsumptionAsPer.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
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
				"pnt&thinner", "opening bal", "received", "from fettler", "to fettler", "clsing bal", "actual cons", "cons per norms"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblMonth = new JLabel("MONTH :-");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		scrollPane_1.setViewportView(panel_2);
		
		JButton btnAdd = new JButton("ADD ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 DefaultTableModel df = (DefaultTableModel) table.getModel();
				 DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				 
				 df.addRow(new Object[]  {comboBox.getSelectedItem().toString(),textField.getText(),textField_1.getText(),textField_2.getText()	,textField_3.getText()
						 ,textField_4.getText(),textField_5.getText(),textField_6.getText()});
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDetailsOfPaint, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblOpeningBalance, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblReceivedQty, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblFromFettlerQty, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblToFettlerQty, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblClosingBalance, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblActualConsumption, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblConsumptionAsPer, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(34)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDetailsOfPaint, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(4)
									.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOpeningBalance, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblReceivedQty, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFromFettlerQty, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblToFettlerQty, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblClosingBalance, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblActualConsumption, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(4)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConsumptionAsPer, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAdd))
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))
					.addGap(11))
		);
		panel.setLayout(gl_panel);
	}
}
