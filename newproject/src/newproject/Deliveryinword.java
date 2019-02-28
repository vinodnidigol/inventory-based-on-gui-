package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.InputStream;

import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Deliveryinword extends JFrame {

	private static final String JCheckBox = null;
	protected static final int ActionEvent = 0;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	
	String s1 ="0" ;
	String s2 ="0";
	String s3 ="0";
	String s4 ="0";
	String s5 ="0";
	String s6 ="0";
	String s7 ="0";
	String s8 ="0";
	String s9 ="0";
	String s10 ="0" ;
	String s11 ="0";
	String s12 ="0";
	String s13 ="0";
	String s14 ="0";
	String s15 ="0";
	String s16 ="0";
	String s17 ="0";
	String s18 ="0";
	String c1 = "0" ;
	String c2 = "0" ;
	String c3 = "0" ;
	String c4 = "0" ;
	String c5 = "0" ;
	String c6 = "0" ;
	String c7 = "0" ;
	String c8 = "0" ;
	String c9 = "0" ;
	String c10 = "0" ;
	 String pdate = null ;
     String challanno = null ;
     String storename = null ;
     String Grossamount = null ;
     String itemname = null ;
     String openingstock = null ;
     String avge = null ;
     String dc = null ;
     String rw = null ;
     String psb = null ;
     String jolt = null ;
     String vehicleno = null ;
     String eway = null ;
     String tqty = null ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deliveryinword frame = new Deliveryinword();
				//	frame.getContentPane().add(arg0)
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
	DefaultTableModel df ;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTable table_2;
	private JTextField textField_12;
	private JTable table_3;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	String date ;
	String k ;
	String b ;

	DefaultTableModel getdata() {
		
		
		 df.addColumn("Challan No.");
		 df.addColumn("Item Name");
//		 df.addColumn("Annexure No.");
//		 df.addColumn("FEET");
//		 df.addColumn("RSB");
//		 df.addColumn("PNT");
//		 df.addColumn("AVG");
//		 df.addColumn("JOLT");
//		 df.addColumn("DC/WJ");
//		 df.addColumn("RW");
//		 df.addColumn("PSB");
//		 df.addColumn("REJECT");
//		 df.addColumn("Vehicle No.");
//		 df.addColumn("KFIL Challan No.");
//		 df.addColumn("KFIL Date");
//		 df.addColumn("E-Way BILL");
//		 df.addColumn("Total Qty");
//		 df.addColumn("Transporter Name");
//		 df.addColumn("Taxable Value");
		 
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from inword where kfilchano like '%"+textField_9.getText()+"%'";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String a =rs.getString("kfilchano");
				 date =rs.getString("kfildate");
				 b =rs.getString("itemnamein");
				String c =rs.getString("fet");
				String d =rs.getString("rsb");
				String e =rs.getString("pnt");
				String f =rs.getString("avge");
				String g =rs.getString("dc");
				String h =rs.getString("rw");
				String i =rs.getString("psb");
				String j =rs.getString("jolt");
				 k =rs.getString("ewaybill");
				 
				String [] rowdata = {a,b,date,c,d,e,f,g,h,i,j,k};
				
				df.addRow(rowdata);
				
				
			

			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		
		return df;}
	
	DefaultTableModel getdata1() {
		
		
		 df.addColumn("outword No.");
		 df.addColumn("Dispatch Date");
		 df.addColumn("inword No.");
		 df.addColumn("itemname");
//		 df.addColumn("RSB");
//		 df.addColumn("PNT");
//		 df.addColumn("AVG");
//		 df.addColumn("JOLT");
//		 df.addColumn("DC/WJ");
//		 df.addColumn("RW");
//		 df.addColumn("PSB");
//		 df.addColumn("REJECT");
//		 df.addColumn("Vehicle No.");
//		 df.addColumn("KFIL Challan No.");
//		 df.addColumn("KFIL Date");
//		 df.addColumn("E-Way BILL");
//		 df.addColumn("Total Qty");
//		 df.addColumn("Transporter Name");
//		 df.addColumn("Taxable Value");
		 
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from outword where outwordno like '%"+textField_22.getText()+"%'";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String a =rs.getString("outwordno");
				String b =rs.getString("outdate");
				String c =rs.getString("inwordno");
				String d =rs.getString("itemname");
				String e =rs.getString("taxablevalue");
				String f =rs.getString("vehicleno");
				String g =rs.getString("totalqty");
				String h =rs.getString("fet1");
				String i =rs.getString("rsb1");
				String j =rs.getString("pnt1");
				String k =rs.getString("avge1");
				String l =rs.getString("jolt1");
				String m =rs.getString("dcwj1");
				String n =rs.getString("rw1");
				String o =rs.getString("psb1");
				String p =rs.getString("rej1");
				
				 
				String [] rowdata = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p};
				
				df.addRow(rowdata);
				
				
			

			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		
		return df;}
	
	DefaultTableModel getdata2() {
		
		
		 df.addColumn("Challan No.");
		 df.addColumn("Date");
		 df.addColumn("Item Name");
//		 df.addColumn("FEET");
//		 df.addColumn("RSB");
//		 df.addColumn("PNT");
//		 df.addColumn("AVG");
//		 df.addColumn("JOLT");
//		 df.addColumn("DC/WJ");
//		 df.addColumn("RW");
//		 df.addColumn("PSB");
//		 df.addColumn("REJECT");
//		 df.addColumn("Vehicle No.");
//		 df.addColumn("KFIL Challan No.");
//		 df.addColumn("KFIL Date");
//		 df.addColumn("E-Way BILL");
//		 df.addColumn("Total Qty");
//		 df.addColumn("Transporter Name");
//		 df.addColumn("Taxable Value");
//		 
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from inword where kfilchano like '%"+textField_21.getText()+"%'";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String a =rs.getString("kfilchano");
				String a1 =rs.getString("kfildate");
				String b =rs.getString("itemnamein");
				String c =rs.getString("fet");
				String d =rs.getString("rsb");
				String e =rs.getString("pnt");
				String f =rs.getString("avge");
				String g =rs.getString("dc");
				String h =rs.getString("rw");
				String i =rs.getString("psb");
				String j =rs.getString("jolt");
				 
				String [] rowdata = {a,a1,b,c,d,e,f,g,h,i,j};
				
				df.addRow(rowdata);
				
				
			

			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		
		return df;}
	
	public Deliveryinword() {
		setTitle("Delivery Inword/Outword");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Deliveryinword.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 822, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_819854380760");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 796, 41);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		dateChooser.setBounds(108, 125, 218, 20);
		

		JPanel panel_2 = 
				new JPanel();
		panel_2.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_2, "name_11483927761239");
		String l1 ="0";
		panel.setLayout(null);
		panel.add(toolBar);
		
		JLabel lblKfilChallanNo = new JLabel("KFIL Challan No. :");
		lblKfilChallanNo.setBounds(10, 97, 94, 14);
		lblKfilChallanNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 51, 51));
		panel_4.setBounds(0, 43, 796, 29);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblOutWord = new JLabel("Out Word");
		lblOutWord.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblOutWord.setForeground(Color.WHITE);
		lblOutWord.setBackground(new Color(102, 51, 51));
		lblOutWord.setBounds(10, 0, 140, 29);
		panel_4.add(lblOutWord);
		
		JLabel lblEnterChallanNo = new JLabel("Enter Challan No. To Search :");
		lblEnterChallanNo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterChallanNo.setForeground(Color.WHITE);
		lblEnterChallanNo.setBackground(new Color(102, 51, 51));
		lblEnterChallanNo.setBounds(383, 0, 214, 29);
		panel_4.add(lblEnterChallanNo);
		
		
		textField_22 = new JTextField();
		textField_22.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table_2.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_2.setModel( getdata1());
			}
		});
		textField_22.setBounds(600, 5, 186, 22);
		panel_4.add(textField_22);
		textField_22.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_12.requestFocus();
				}
			}
		});
		textField.setBounds(108, 94, 218, 20);
		textField.setColumns(10);
		
		JLabel lblKfilDate = new JLabel("KFIL Date :");
		lblKfilDate.setBounds(10, 125, 60, 14);
		lblKfilDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		JLabel lblDescripitionOfThe = new JLabel("Descripition Of The Goods :");
		lblDescripitionOfThe.setBounds(10, 151, 150, 14);
		lblDescripitionOfThe.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Select Item");
		comboBox.setBounds(170, 151, 156, 22);
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from parttype";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String partname =rs.getString("partname");
				comboBox.addItem(partname);
				System.out.println(partname);
				 
			//	String vechileNumber = rs.getString("vechilenumber");
			//	comboBox_1.addItem(vechileNumber);
			}
			

			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JLabel lblQuantitynumbersweightlitre = new JLabel("Quantity (Numbers/Weight/Litre ) :");
		lblQuantitynumbersweightlitre.setBounds(10, 185, 199, 14);
		lblQuantitynumbersweightlitre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTransporterName = new JLabel("Transporter Name :");
		lblTransporterName.setBounds(10, 322, 109, 14);
		lblTransporterName.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblVehicleNo = new JLabel("Vehicle No. :");
		lblVehicleNo.setBounds(10, 348, 66, 14);
		lblVehicleNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEwayBill = new JLabel("E-Way Bill :");
		lblEwayBill.setBounds(10, 376, 61, 14);
		lblEwayBill.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_4.requestFocus();
				}
			}
		});
		textField_3.setBounds(130, 345, 196, 20);
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("Select Name");
		comboBox_1.setBounds(130, 319, 196, 20);
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from transporterdetils";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("TransporterName");
				comboBox_1.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_4.setBounds(130, 376, 196, 20);
		textField_4.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 51, 51));
		panel_3.setBounds(0, 43, 796, 27);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblIn = new JLabel("In Word");
		lblIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblIn.setForeground(Color.WHITE);
		lblIn.setBackground(new Color(102, 51, 51));
		lblIn.setBounds(10, 0, 117, 27);
		panel_3.add(lblIn);
		
		JLabel lblSearch = new JLabel("Enter Challan No. To Search :");
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setBackground(new Color(102, 51, 51));
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSearch.setBounds(351, 0, 201, 27);
		panel_3.add(lblSearch);
		
		
		textField_21 = new JTextField();
		textField_21.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata2());
			}
		});
	
		textField_21.setBounds(562, 5, 218, 20);
		panel_3.add(textField_21);
		textField_21.setColumns(10);
		
		
		
		JMenuItem mntmSave = 	new JMenuItem("Save");
		mntmSave.setSelected(true);
		mntmSave.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				 java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "insert into inword values('"+Integer.parseInt(textField.getText())+"','"+df1.format(dateChooser.getDate())
    			+"','"+comboBox.getSelectedItem().toString()+"','"+Integer.parseInt(s1)+"','"+Integer.parseInt(s2)+"','"
    					+Integer.parseInt(s3)+"','"+Integer.parseInt(s4)+"','"+Integer.parseInt(s5)+"','"
    			+Integer.parseInt(s6)+"','"+Integer.parseInt(s7)+"','"+Integer.parseInt(s8)+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textField_12.getText()+"')";
       
    			stmt.execute(query);
    			
    			JOptionPane.showMessageDialog(null, "data saved");
    			df = (DefaultTableModel) table.getModel();
    			df.setRowCount(0);
    			df.setColumnCount(0);
    			table.setModel(getdata2());
              
        		} catch (Exception e) {
        			System.out.println(e.toString());
					JOptionPane.showMessageDialog(null, e.toString());
				}
        		
			}
		});
		mntmSave.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSave.setForeground(Color.WHITE);
		mntmSave.setBackground(new Color(102, 51, 51));
		mntmSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmSave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Process", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 228, 316, 80);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_3.requestFocus();
				}
			}
		});
		textField_12.setBounds(219, 184, 107, 20);
		panel.add(textField_12);
		textField_12.setColumns(10);
		
		JCheckBox chckbxFet = new JCheckBox("FET");
		chckbxFet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxFet.isSelected()) {
					
				s1 =	textField_12.getText();
				} else {
					s1 = "0";
				}
					
			}
		});
		chckbxFet.setBounds(6, 19, 52, 23);
		panel_1.add(chckbxFet);
		
		JCheckBox chckbxRsb = new JCheckBox("RSb");
		chckbxRsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                if(chckbxRsb.isSelected()) {
					
				s2 =	textField_12.getText();
				} else {
					s2 = "0";
				}
			}
		});
		chckbxRsb.setBounds(82, 19, 52, 23);
		panel_1.add(chckbxRsb);
		
		JCheckBox chckbxPnt = new JCheckBox("PNT");
		chckbxPnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(chckbxPnt.isSelected()) {
						
					s3 =	textField_12.getText();
					} else {
						s3 = "0";
					}
			}
		});
		chckbxPnt.setBounds(158, 19, 52, 23);
		panel_1.add(chckbxPnt);
		
		JCheckBox chckbxAvg = new JCheckBox("AVG");
		chckbxAvg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxAvg.isSelected()) {
					
				s4 =	textField_12.getText();
				} else {
					s4 = "0";
				}
			}
		});
		chckbxAvg.setBounds(234, 19, 52, 23);
		panel_1.add(chckbxAvg);
		
		JCheckBox chckbxDcwj = new JCheckBox("DC/WJ");
		chckbxDcwj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxDcwj.isSelected()) {
					
				s5 =	textField_12.getText();
				} else {
					s5 = "0";
				}
			}
		});
		chckbxDcwj.setBounds(6, 45, 66, 23);
		panel_1.add(chckbxDcwj);
		
		JCheckBox chckbxRw = new JCheckBox("R/W");
		chckbxRw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxRw.isSelected()) {
					
				s6 = 	textField_12.getText();
				} else {
					s6 = "0";
				}
			}
		});
		chckbxRw.setBounds(82, 45, 66, 23);
		panel_1.add(chckbxRw);
		
		JCheckBox chckbxPsb = new JCheckBox("PSB");
		chckbxPsb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPsb.isSelected()) {
					
				s7 =	textField_12.getText();
				} else {
					s7 = "0";
				}
			}
		});
		chckbxPsb.setBounds(158, 45, 66, 23);
		panel_1.add(chckbxPsb);
		
		JCheckBox chckbxJolt = new JCheckBox("JOLT");
		chckbxJolt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxJolt.isSelected()) {
					
				s8 =	textField_12.getText();
				} else {
					s8 = "0";
				}
			}
		});
		chckbxJolt.setBounds(234, 45, 66, 23);
		panel_1.add(chckbxJolt);
		
		
		
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBounds(0, 0, 796, 43);
		
	
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.setSelected(true);
		mntmEdit.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  inword  where kfilchano like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				    
				     
					while(rs.next()) {
				     	 pdate =rs.getString("kfilchano");
						 challanno =rs.getString("kfildate");
						 storename =rs.getString("itemnamein");
						 Grossamount =rs.getString("fet");
						 itemname =rs.getString("rsb");
						 openingstock =rs.getString("pnt");
						 avge = rs.getString("avge");
						 dc = rs.getString("dc");
						 rw = rs.getString("rw");
						 psb = rs.getString("psb");
						 jolt = rs.getString("jolt");
						 vehicleno = rs.getString("vehicleno");
						 eway = rs.getString("ewaybill");
				        tqty = rs.getString("tqty");
											
					}
					
					
					
					java.util.Date dispatchdate =  new SimpleDateFormat("yyyy-MM-dd").parse((String)challanno);
			    	dateChooser.setDate(dispatchdate);
			    	comboBox.setSelectedItem(storename);
			    	textField.setText(pdate);
			    	textField_3.setText(vehicleno);
			    	textField_12.setText(tqty);
			    
			    	int abc = Integer.parseInt(Grossamount);
			    	if(abc>0) {
			        chckbxFet.setSelected(true);
					}
			    	int abc1 = Integer.parseInt(itemname);
			    	if(abc1>0) {
			    		chckbxRsb.setSelected(true);
					}
			    	int abc2 = Integer.parseInt(openingstock);
			    	if(abc2>0) {
			    		chckbxPnt.setSelected(true);
					}
			    	int abc3 = Integer.parseInt(avge);
			    	if(abc3>0) {
			        chckbxAvg.setSelected(true);
					}
			    	int abc4 = Integer.parseInt(dc);
			    	if(abc4>0) {
			    		chckbxDcwj.setSelected(true);
					}
			    	int abc5 = Integer.parseInt(rw);
			    	if(abc5>0) {
			    		chckbxRw.setSelected(true);
					}
			    	int abc6 = Integer.parseInt(psb);
			    	if(abc6>0) {
			        chckbxPsb.setSelected(true);
					}
			    	int abc7 = Integer.parseInt(jolt);
			    	if(abc7>0) {
			        chckbxJolt.setSelected(true);
					}
			    	
			    	
			    	
			    	
			    	
			    	
			 //   	comboBox_1.setSelectedItem(itemname);
			  //  	textArea.setText(openingstock);
//			    	df = (DefaultTableModel) table.getModel();
//					df.setRowCount(0);
//					df.setColumnCount(0);
//					table.setModel(getdata());
				  System.out.println(pdate+challanno+storename+Grossamount+itemname+openingstock);
			
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		
		mntmEdit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEdit.setForeground(Color.WHITE);
		mntmEdit.setBackground(new Color(102, 51, 51));
		mntmEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmEdit);
		
		JMenuItem mntmUpdate = new JMenuItem("Update\r\n");
		mntmUpdate.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				String fet ;
				String rsb ;
				String pnt ;
				String avg ;
				String dc ;
				String rw ;
				String psb ;
				String jolt ;
				if(chckbxFet.isSelected()) {
					
					fet =	textField_12.getText();
					} else {
						fet = "0";
					}
				if(chckbxRsb.isSelected()) {
					
					rsb =	textField_12.getText();
					} else {
						rsb = "0";
					}
				if(chckbxPnt.isSelected()) {
					
					pnt =	textField_12.getText();
					} else {
						pnt = "0";
					}
				if(chckbxAvg.isSelected()) {
					
					avg =	textField_12.getText();
					} else {
						avg = "0";
					}
				if(chckbxDcwj.isSelected()) {
					
					dc =	textField_12.getText();
					} else {
						dc = "0";
					}
				if(chckbxRw.isSelected()) {
					
					rw =	textField_12.getText();             
					} else {
						rw = "0";
					}
				if(chckbxPsb.isSelected()) {
					
					psb =	textField_12.getText();
					} else {
						psb = "0";
					}
				if(chckbxJolt.isSelected()) {
					
					jolt =	textField_12.getText();
					} else {
						jolt = "0";
					}
				
			//	      System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			     String query = "update inword set kfilchano='"+textField.getText()+"',kfildate = '"+df1.format(dateChooser.getDate())
			     +"',itemnamein ='"+comboBox.getSelectedItem().toString()+"',fet='"+fet+"',rsb='"
			    		 +rsb+"',pnt ='"+pnt+"',avge= '"+avg+"',dc = '"+dc+"',rw='"+rw+"',psb='"+psb
			    		 +"',jolt='"+jolt+"',vehicleno='"+textField_3.getText()+"',ewaybill='"+textField_4.getText()
			    		 +"',tqty='"+textField_12.getText()+"' where kfilchano='"+id+"'";
				      stmt.execute(query);
				    
					
					
				
					
				
					JOptionPane.showMessageDialog(null, "data updated");
					
					df = (DefaultTableModel) table.getModel();
					df.setRowCount(0);
					df.setColumnCount(0);
					table.setModel(getdata2());
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		
	
		
		JMenuItem mntmCancel = new JMenuItem("Clear");
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_12.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				dateChooser.setDate(null);
				chckbxFet.setSelected(false);
				chckbxRsb.setSelected(false);
				chckbxPnt.setSelected(false);
				chckbxAvg.setSelected(false);
				chckbxRw.setSelected(false);
				chckbxDcwj.setSelected(false);
				chckbxPsb.setSelected(false);
				chckbxJolt.setSelected(false);
				
				
			}
		});
		mntmCancel.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from inword where kfilchano='"+id+"'";
       System.out.println(id);
    			stmt.execute(query);
    			
    			df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
    			
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				table.setModel(getdata());
			}
		});
		mntmDelete.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		mntmDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDelete.setForeground(Color.WHITE);
		mntmDelete.setBackground(new Color(102, 51, 51));
		mntmDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmDelete);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		mntmSearch.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSearch.setForeground(Color.WHITE);
		mntmSearch.setBackground(new Color(102, 51, 51));
		mntmSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmSearch);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		mntmExit.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmExit.setForeground(Color.WHITE);
		mntmExit.setBackground(new Color(102, 51, 51));
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmExit);
		panel.add(lblKfilChallanNo);
		panel.add(lblKfilDate);
		panel.add(dateChooser);
		panel.add(textField);
		panel.add(lblDescripitionOfThe);
		panel.add(comboBox);
		panel.add(lblQuantitynumbersweightlitre);
		panel.add(lblVehicleNo);
		panel.add(textField_3);
		panel.add(lblTransporterName);
		panel.add(lblEwayBill);
		panel.add(textField_4);
		panel.add(comboBox_1);
		Boolean challanno1 ;
		
		
		
		
		JLabel lblChallanType = new JLabel("Challan Type :");
		lblChallanType.setBounds(10, 127, 112, 19);
		lblChallanType.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(160, 126, 172, 20);
		 comboBox_2.addItem("ORIGINAL FOR CONSIGNEE");
	     comboBox_2.addItem("DUPLICATE FOR TRANSPORTER");
	     comboBox_2.addItem("TRIPLICATE FOR ASSESSEE");
		
		JLabel lblDeliveryChallanNo = new JLabel("Delivery Challan No. :");
		lblDeliveryChallanNo.setBounds(10, 157, 148, 19);
		lblDeliveryChallanNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_5 = new JTextField();
		textField_5.setBounds(160, 157, 172, 20);
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_9.requestFocus();
				}
			}
		});
		textField_5.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(10, 187, 46, 14);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBounds(160, 181, 172, 20);
		
		JLabel lblDescriptionOfThe = new JLabel("Description Of The Goods :");
		lblDescriptionOfThe.setBounds(10, 242, 161, 19);
		lblDescriptionOfThe.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(160, 241, 172, 20);
	//	comboBox_3.addItem("Select");
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from parttype";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
		//     int partweight = 0 ;
			while(rs.next()) {
				String partname =rs.getString("partname");
			//	 partweight =rs.getInt("partweight");
				comboBox_3.addItem(partname);
				System.out.println(partname);
				 
			//	String vechileNumber = rs.getString("vechilenumber");
			//	comboBox_1.addItem(vechileNumber);
			}
	//		System.out.println(partweight);
	//		 int weight =Integer.parseInt( textField_10.getText())*partweight ;
		//	 textField_11.setText(String.valueOf(weight));

			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}

		comboBox_3.setSelectedItem(b);
		 
		JLabel lblIdentificationMarksAnd = new JLabel("Identification Marks and Numbers,If Any :");
		lblIdentificationMarksAnd.setBounds(10, 272, 238, 19);
		lblIdentificationMarksAnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_7.requestFocus();
				}
			}
		});
		textField_6.setBounds(246, 271, 86, 20);
		textField_6.setColumns(10);
		
		JLabel lblTaxableValue = new JLabel("Taxable Value :");
		lblTaxableValue.setBounds(10, 298, 91, 19);
		lblTaxableValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_8.requestFocus();
				}
			}
		});
		textField_7.setBounds(160, 297, 172, 20);
		textField_7.setColumns(10);
		
		
		
		JLabel lblTransporterName_1 = new JLabel("Transporter Name :");
		lblTransporterName_1.setBounds(10, 326, 122, 19);
		lblTransporterName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(160, 325, 172, 20);
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from transporterdetils";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("TransporterName");
				comboBox_4.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		JLabel lblTruckNumber = new JLabel("Truck Number :");
		lblTruckNumber.setBounds(10, 351, 91, 19);
		lblTruckNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_10.requestFocus();
				}
			}
		});
		textField_8.setBounds(160, 350, 172, 20);
		textField_8.setColumns(10);
		
		JLabel lblInwordNo = new JLabel("InWord No. :");
		lblInwordNo.setBounds(10, 212, 91, 19);
		lblInwordNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_6.requestFocus();
				}
			}
		});
		textField_9.setBounds(160, 213, 88, 20);
		textField_9.setColumns(10);
		
		JLabel lblTotalQty = new JLabel("Qty . :");
		lblTotalQty.setBounds(160, 381, 39, 19);
		lblTotalQty.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_5.requestFocus();
				}
			}
		});
		textField_10.setBounds(253, 381, 79, 20);
		textField_10.setColumns(10);
		
		
		
		JButton btnFind = new JButton("Find");
		btnFind.setBounds(253, 212, 79, 20);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				df = (DefaultTableModel) table_3.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel( getdata());
				
			}
		});
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(382, 96, 404, 251);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		df = (DefaultTableModel) table_2.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table_2.setModel( getdata1());
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(382, 358, 404, 150);
		
		table_3 = new JTable();
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String itemname = table_3.getValueAt(table_3.getSelectedRow(), 0).toString();
				String feet = table_3.getValueAt(table_3.getSelectedRow(), 1).toString();
				textField_9.setText(itemname);
				comboBox_3.setSelectedItem(feet);
			}
		});
		scrollPane_3.setViewportView(table_3);
		df = (DefaultTableModel) table_3.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table_3.setModel( getdata());
		
		JCheckBox chckbxFet_1 = new JCheckBox("fet");
		chckbxFet_1.setBounds(10, 407, 67, 19);
		chckbxFet_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxFet_1.isSelected()) {
					textField_1.setEnabled(true);
				
					}
			}
		});
		chckbxFet_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxRsb_1 = new JCheckBox("RSB");
		chckbxRsb_1.setBounds(85, 407, 58, 23);
		chckbxRsb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                if(chckbxRsb_1.isSelected()) {
                	textField_13.setEnabled(true);
					;
					}
			}
		});
		chckbxRsb_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxRw_1 = new JCheckBox("R/W");
		chckbxRw_1.setBounds(85, 458, 58, 20);
		chckbxRw_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxRw_1.isSelected()) {
					textField_18.setEnabled(true);
					
					}
			}
		});
		chckbxRw_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("PAINT");
		chckbxNewCheckBox_1.setBounds(157, 407, 60, 23);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(chckbxNewCheckBox_1.isSelected()) {
					 textField_14.setEnabled(true);
					
						}
			}
		});
		chckbxNewCheckBox_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxAvg_1 = new JCheckBox("AVG");
		chckbxAvg_1.setBounds(241, 405, 58, 23);
		chckbxAvg_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxAvg_1.isSelected()) {
					textField_15.setEnabled(true);
					
					}
			}
		});
		chckbxAvg_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxJolt_1 = new JCheckBox("JOLT");
		chckbxJolt_1.setBounds(318, 405, 58, 23);
		chckbxJolt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                 if(chckbxJolt_1.isSelected()) {
                	 textField_16.setEnabled(true);
					
					}
			}
		});
		chckbxJolt_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxDcwj_1 = new JCheckBox("DC/WJ");
		chckbxDcwj_1.setBounds(10, 458, 73, 20);
		chckbxDcwj_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               if(chckbxDcwj_1.isSelected()) {
            	   textField_17.setEnabled(true);
					
					}
			}
		});
		chckbxDcwj_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxPsb_1 = new JCheckBox("PSB");
		chckbxPsb_1.setBounds(157, 460, 58, 20);
		chckbxPsb_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_19.setEnabled(false);
				 if(chckbxPsb_1.isSelected()) {
					 textField_19.setEnabled(true);
						
						}
			}
		});
		chckbxPsb_1.setBackground(new Color(204, 204, 153));
		
		JCheckBox chckbxReject = new JCheckBox("REJECT");
		chckbxReject.setBounds(241, 458, 97, 20);
		chckbxReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxReject.isSelected()) {
					textField_20.setEnabled(true);
				//	s18 =	textField_20.getText();
					System.out.println(s18);
					} 
			}
		});
		chckbxReject.setBackground(new Color(204, 204, 153));
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Outword\r\n");
		btnNewButton.setBackground(new Color(204, 204, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_2);
				contentPane.repaint();
				contentPane.revalidate();

			}
		});
		btnNewButton.setBounds(10, 419, 316, 54);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 94, 436, 414);
		panel.add(scrollPane);
		
		table = new JTable();
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata2());
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel( getdata2());
		
		
		
	
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxFet_1.isSelected()) {
		        	 s10=	textField_1.getText();
		        	System.out.println(s1);
		        	} else {
		        		s10 = "0";
		        		System.out.println(s1);
		        	}
		        		if(chckbxRsb_1.isSelected()) {
		               	 s11=	textField_13.getText();
		               	System.out.println(s2);
		               	} else {
		               		s11 = "0";
		               		System.out.println(s2);
		               	}
		        		if(chckbxNewCheckBox_1.isSelected()) {
		               	 s12=	textField_14.getText();
		               	System.out.println(s3);
		               	} else {
		               		s12 = "0";
		               		System.out.println(s3);
		               	}
		        		if(chckbxAvg_1.isSelected()) {
		               	 s13=	textField_15.getText();
		               	System.out.println(s4);
		               	} else {
		               		s13 = "0";
		               		System.out.println(s4);
		               	}
		        		if(chckbxJolt_1.isSelected()) {
		               	 s14=	textField_16.getText();
		               	System.out.println(s5);
		               	} else {
		               		s14 = "0";
		               		System.out.println(s5);
		               	}
		        		if(chckbxDcwj_1.isSelected()) {
		               	 s15=	textField_17.getText();
		               	System.out.println(s6);
		               	} else {
		               		s15 = "0";
		               		System.out.println(s6);
		               	}
		        		if(chckbxRw_1.isSelected()) {
		                  	 s16=	textField_18.getText();
		                  	System.out.println(s7);
		                  	} else {
		                  		s16 = "0";
		                  		System.out.println(s7);
		                  	}
		        		if(chckbxPsb_1.isSelected()) {
		                  	 s17=	textField_19.getText();
		                  	System.out.println(s8);
		                  	} else {
		                  		s17 = "0";
		                  		System.out.println(s8);
		                  	}
		        		if(chckbxReject.isSelected()) {
		                  	 s18=	textField_20.getText();
		                  	System.out.println(s9);
		                  	} else {
		                  		s18 = "0";
		                  		System.out.println(s9);
		                  	}
				
				
				System.out.println(s10+s11+s12+s13+s14+s15+s16+s17+s18+c10);
				
				
				

				
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				int exit = JOptionPane.showConfirmDialog(null, " Do You Want Print Report ","Print", JOptionPane.YES_NO_OPTION);
					
					if(exit ==0) {
						String a11 = "/Reports/Blank_A4.jrxml";
						InputStream in = null ;
						in  = this.getClass().getResourceAsStream(a11);
						JasperDesign jd = JRXmlLoader.load(in);
					//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Blank_A4.jrxml");
						String sql ="select * from poupdater";
						JRDesignQuery q = new JRDesignQuery();
						q.setText(sql);
						jd.setQuery(q);
						
					
						JasperReport jr = JasperCompileManager.compileReport(jd);
						Map<String, Object>	params = new HashMap<String, Object>();
						params.put("challanno", textField_5.getText());
						params.put("challantype", comboBox_2.getSelectedItem().toString());
						params.put("disdate", df1.format(dateChooser_1.getDate()));
						params.put("goodsname", comboBox_3.getSelectedItem().toString());
						params.put("identi", textField_6.getText());
						params.put("totalqty", textField_10.getText());
						params.put("transporter", comboBox_4.getSelectedItem().toString());
						params.put("vehicleno",textField_8.getText());
						params.put("kfilno", textField_9.getText());
						params.put("kfildate",date);
						params.put("FET", textField_1.getText());
						params.put("RSB", textField_13.getText());
						params.put("PNT", textField_14.getText());
						params.put("AVG", textField_15.getText());
						params.put("JOLT", textField_16.getText());
						params.put("DC", textField_17.getText());
						params.put("RW", textField_18.getText());
						params.put("PSB", textField_19.getText());
						params.put("REJ", textField_20.getText());
					
						int tQty = Integer.parseInt(textField_10.getText());
						int rej = Integer.parseInt(textField_20.getText()) ;
						
						int finok = tQty-rej ;
						
						params.put("finok", finok);
						
						
						double d1 = Double.parseDouble(textField_7.getText());
						params.put("taxablevalue", d1);
						JasperPrint j = JasperFillManager.fillReport(jr,params,con);
					//	JasperViewer.viewReport(j,false);
						
						JFrame frame = new JFrame() ;
						frame.getContentPane().add(new JRViewer(j) );
						frame.pack();
						frame.setVisible(true);
//						frame.removeAll();
//						frame.setLayout(new BorderLayout());
//						frame.repaint();
//						frame.add(new JRViewer(j));
//						frame.revalidate();
					
					}
    				
    				 java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "insert into outword values('"+textField_5.getText()+"','"+df1.format(dateChooser_1.getDate())+"','"+textField_9.getText()
    			+"','"+comboBox_3.getSelectedItem().toString()+"','"+textField_7.getText()+"','"+textField_8.getText()+"','"+textField_10.getText()+"','"+s10+"','"+s11+"','"+s12+"','"+s13+"','"
    			+s14+"','"+s15+"','"+s16+"','"+s17+"','"+s18+"')";
       
    			stmt.execute(query);
    			

    			df = (DefaultTableModel) table_2.getModel();
    			df.setRowCount(0);
    			df.setColumnCount(0);
    			table_2.setModel( getdata1());
        		} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
		menuItem.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar_1.add(menuItem);
		
		
		
		
		JMenuItem menuItem_1 = new JMenuItem("Edit");
		menuItem_1.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  outword  where outwordno like '"+table_2.getValueAt(table_2.getSelectedRow(), 0)+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String tax = null ;
				     String vehicle = null ;
				     String total = null ;
				     String fet1 = null ;
				     String rsb1 = null ;
				     String pnt1 = null ;
				     String avg1 = null ;
				     String jolt1 = null ;
				     String dc1 = null ;
				     String rw1 = null ;
				     String psb1 = null ;
				     String rej1 = null ;
					while(rs.next()) {
						 pdate =rs.getString("outwordno");
						 challanno =rs.getString("outdate");
						 storename =rs.getString("inwordno");
						 Grossamount =rs.getString("itemname");
						 tax = rs.getString("taxablevalue");
						 vehicle = rs.getString("vehicleno");
						 total =rs.getString("totalqty");
						 fet1 = rs.getString("fet1");
						 rsb1 = rs.getString("rsb1");
						 pnt1 = rs.getString("pnt1");
						 avg1 = rs.getString("avge1");
						 jolt1 = rs.getString("jolt1");
						 dc1 = rs.getString("dcwj1");
						 rw1 =rs.getString("rw1");
						 psb1 =rs.getString("psb1");
						 rej1 =rs.getString("rej1");
					}
					textField_5.setText(pdate);
					java.util.Date dispatchdate =  new SimpleDateFormat("yyyy-MM-dd").parse((String)challanno);
			
					dateChooser_1.setDate(dispatchdate);
					textField.setText(challanno);
					textField_9.setText(storename);
					comboBox_3.setSelectedItem(Grossamount);
					textField_7.setText(tax);
					textField_8.setText(vehicle);
					textField_10.setText(total);
					textField_1.setText(fet1);
					textField_13.setText(rsb1);
					textField_14.setText(pnt1);
					textField_15.setText(avg1);
					textField_16.setText(jolt1);
					textField_17.setText(dc1);
					textField_18.setText(rw1);
					textField_19.setText(psb1);
					textField_20.setText(rej1);
				  System.out.println(pdate+challanno+storename+Grossamount);
			
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar_1.add(menuItem_1);
		
		JMenuItem mntmUpdate_1 = new JMenuItem("Update");
		mntmUpdate_1.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				
				 //     System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			     String query = "update outword set outwordno='"+textField_5.getText()+"',outdate='"+df1.format(dateChooser_1.getDate())
			     +"',inwordno='"+textField_9.getText()+"',itemname='"+comboBox_3.getSelectedItem().toString()
			    	+"',taxablevalue='"+textField_7.getText()+"',totalqty='"+textField_10.getText()+"',vehicleno='"+textField_8.getText()
			    	+"',fet1='"+textField_1.getText()+"', rsb1='"+textField_13.getText()
			    	+"',pnt1='"+textField_14.getText()+"',avge1='"+textField_15.getText()
			    	+"',jolt1='"+textField_16.getText()+"',dcwj1='"+textField_17.getText()
			    	+"',rw1='"+textField_18.getText()+"',psb1='"+textField_19.getText()
			    	+"',rej1='"+textField_20.getText()+"' where outwordno='"+table_2.getValueAt(table_2.getSelectedRow(), 0)+"'";
				      stmt.execute(query);
				    
					
					
				
					
				
					JOptionPane.showMessageDialog(null, "data updated");
					
					
					df = (DefaultTableModel) table_2.getModel();
					df.setRowCount(0);
					df.setColumnCount(0);
					table_2.setModel( getdata1());
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				df = (DefaultTableModel) table_2.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_2.setModel( getdata1());
			}
		});
		mntmUpdate_1.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate_1.setForeground(Color.WHITE);
		mntmUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate_1.setBackground(new Color(102, 51, 51));
		toolBar_1.add(mntmUpdate_1);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				dateChooser_1.setDate(null);
		//		comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				comboBox_4.setSelectedItem(null);
				textField_1.setText(null);
				textField_13.setText(null);
				textField_14.setText(null);
				textField_15.setText(null);
				textField_16.setText(null);
				textField_17.setText(null);
				textField_18.setText(null);
				textField_19.setText(null);
				textField_20.setText(null);
				chckbxFet_1.setSelected(false);
				chckbxRsb_1.setSelected(false);
				chckbxAvg_1.setSelected(false);
				chckbxJolt_1.setSelected(false);
				chckbxPsb_1.setSelected(false);
				chckbxDcwj_1.setSelected(false);
				chckbxRw_1.setSelected(false);
				chckbxNewCheckBox_1.setSelected(false);
				chckbxReject.setSelected(false);
				
				
			}
		});
		mntmClear.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmClear.setHorizontalAlignment(SwingConstants.LEFT);
		mntmClear.setForeground(Color.WHITE);
		mntmClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmClear.setBackground(new Color(102, 51, 51));
		toolBar_1.add(mntmClear);
		
		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = table_2.getSelectedRow() ;
				String id  = table_2.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from outword where outwordno='"+id+"'";
       System.out.println(id);
    			stmt.execute(query);
    			
    			df = (DefaultTableModel) table_2.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_2.setModel( getdata1());
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			}
		});
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Print/Print_24x24.png")));
		mntmPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				int exit = JOptionPane.showConfirmDialog(null, " Do You Want Print Report ","Print", JOptionPane.YES_NO_OPTION);
					
					if(exit ==0) {
						String a11 = "/Reports/Blank_A4.jrxml";
						InputStream in = null ;
						in  = this.getClass().getResourceAsStream(a11);
						JasperDesign jd = JRXmlLoader.load(in);
					//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Blank_A4.jrxml");
						String sql ="select * from poupdater";
						JRDesignQuery q = new JRDesignQuery();
						q.setText(sql);
						jd.setQuery(q);
						
					
						JasperReport jr = JasperCompileManager.compileReport(jd);
						Map<String, Object>	params = new HashMap<String, Object>();
						params.put("challanno", textField_5.getText());
						params.put("challantype", comboBox_2.getSelectedItem().toString());
						params.put("disdate", df.format(dateChooser_1.getDate()));
						params.put("goodsname", comboBox_3.getSelectedItem().toString());
						params.put("identi", textField_6.getText());
						params.put("totalqty", textField_10.getText());
						params.put("transporter", comboBox_4.getSelectedItem().toString());
						params.put("vehicleno",textField_8.getText());
						params.put("kfilno", textField_9.getText());
						params.put("kfildate",date);
						params.put("FET", textField_1.getText());
						params.put("RSB", textField_13.getText());
						params.put("PNT", textField_14.getText());
						params.put("AVG", textField_15.getText());
						params.put("JOLT", textField_16.getText());
						params.put("DC", textField_17.getText());
						params.put("RW", textField_18.getText());
						params.put("PSB", textField_19.getText());
						params.put("REJ", textField_20.getText());
				
						int tQty = Integer.parseInt(textField_10.getText());
					    int rej = Integer.parseInt(textField_20.getText()) ;
					
						int finok = tQty-rej ;
						
						params.put("finok", finok);
						
						double d1 = Double.parseDouble(textField_7.getText());
						params.put("taxablevalue", d1);
						JasperPrint j = JasperFillManager.fillReport(jr,params,con);
					//	JasperViewer.viewReport(j,false);
						
						JFrame frame = new JFrame() ;
						frame.getContentPane().add(new JRViewer(j) );
						frame.pack();
						frame.setVisible(true);
						
					
					}
    				
    				 java.sql.Statement	stmt = con.createStatement();
    			
    			
       
    		
    			

              
        		} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.toString());
				}
			}
		});
		mntmPrint.setHorizontalAlignment(SwingConstants.LEFT);
		mntmPrint.setForeground(Color.WHITE);
		mntmPrint.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmPrint.setBackground(new Color(102, 51, 51));
		toolBar_1.add(mntmPrint);
		menuItem_3.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_3.setBackground(new Color(102, 51, 51));
		toolBar_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Search");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table_2.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_2.setModel( getdata1());
				
			}
		});
		menuItem_4.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Exit");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(Deliveryinword.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar_1.add(menuItem_5);
		panel_2.setLayout(null);
		panel_2.add(toolBar_1);
		panel_2.add(lblChallanType);
		panel_2.add(comboBox_2);
		panel_2.add(lblDeliveryChallanNo);
		panel_2.add(textField_5);
		panel_2.add(lblDate);
		panel_2.add(dateChooser_1);
		panel_2.add(lblDescriptionOfThe);
		panel_2.add(comboBox_3);
		panel_2.add(lblIdentificationMarksAnd);
		panel_2.add(textField_6);
		panel_2.add(lblTaxableValue);
		panel_2.add(textField_7);
		panel_2.add(lblTransporterName_1);
		panel_2.add(comboBox_4);
		panel_2.add(lblTruckNumber);
		panel_2.add(textField_8);
		panel_2.add(lblInwordNo);
		panel_2.add(textField_9);
		panel_2.add(lblTotalQty);
		panel_2.add(textField_10);
		panel_2.add(btnFind);
		panel_2.add(scrollPane_2);
		panel_2.add(scrollPane_3);
		panel_2.add(chckbxFet_1);
		panel_2.add(chckbxRsb_1);
		panel_2.add(chckbxRw_1);
		panel_2.add(chckbxNewCheckBox_1);
		panel_2.add(chckbxAvg_1);
		panel_2.add(chckbxJolt_1);
		panel_2.add(chckbxDcwj_1);
		panel_2.add(chckbxPsb_1);
		panel_2.add(chckbxReject);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 433, 58, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		textField_13 = new JTextField();
		textField_13.setBounds(85, 433, 53, 20);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		textField_13.setEnabled(false);
		
		
		textField_14 = new JTextField();
		textField_14.setBounds(157, 433, 60, 20);
		panel_2.add(textField_14);
		textField_14.setColumns(10);
		textField_14.setEnabled(false);
		
		textField_15 = new JTextField();
		textField_15.setBounds(241, 431, 58, 20);
		panel_2.add(textField_15);
		textField_15.setColumns(10);
		textField_15.setEnabled(false);
		
		textField_16 = new JTextField();
		textField_16.setBounds(318, 431, 51, 20);
		panel_2.add(textField_16);
		textField_16.setColumns(10);
		textField_16.setEnabled(false);
		
		textField_17 = new JTextField();
		textField_17.setBounds(10, 488, 58, 20);
		panel_2.add(textField_17);
		textField_17.setColumns(10);
		textField_17.setEnabled(false);
		
		textField_18 = new JTextField();
		textField_18.setBounds(85, 488, 58, 20);
		panel_2.add(textField_18);
		textField_18.setColumns(10);
		textField_18.setEnabled(false);
		
		textField_19 = new JTextField();
		textField_19.setBounds(157, 488, 58, 20);
		panel_2.add(textField_19);
		textField_19.setColumns(10);
		textField_19.setEnabled(false);
		
		textField_20 = new JTextField();
		textField_20.setBounds(241, 488, 58, 20);
		panel_2.add(textField_20);
		textField_20.setColumns(10);
		textField_20.setEnabled(false);
		
		
	
		
	}
}
