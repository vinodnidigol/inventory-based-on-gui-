package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
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

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	
	DefaultTableModel df = new DefaultTableModel();
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
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
	private JTextField textField_24;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_12;
	private JTextField textField_23;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTable table_1;
	private JTextField textField_36;
	private JTextField textField_37;
	
	
	DefaultTableModel getdata() {
		 
		 df.addColumn("inword No.");
		 df.addColumn("in Date");
		 df.addColumn("itemname.");
		 df.addColumn("FEET");
		 df.addColumn("RSB");
		 df.addColumn("PNT");
		 df.addColumn("AVG");
		 df.addColumn("dc");
		 df.addColumn("rw");
		 df.addColumn("psb");
		 df.addColumn("jolt");
		 df.addColumn("vehicle No.");
		 df.addColumn("EwayBill");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  inword";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a =rs.getString("kfilchano");
					String a1 =rs.getString("kfildate");
					String b =rs.getString("itemname");
					String c =rs.getString("fet");
					String d =rs.getString("rsb");
					String e =rs.getString("pnt");
					String f =rs.getString("avge");
					String g =rs.getString("dc");
					String h =rs.getString("rw");
					String i =rs.getString("psb");
					String j =rs.getString("jolt");
					String k =rs.getString("vehicleno");
					String l =rs.getString("ewaybill");
					 
					String [] rowdata = {a,a1,b,c,d,e,f,g,h,i,j,k,l};
					
			
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	DefaultTableModel getdata1() {
		
		
		 df.addColumn("outword No.");
		 df.addColumn("Dispatch Date");
		 df.addColumn("inword No.");
		 df.addColumn("itemname");
		 df.addColumn("RSB");
		 df.addColumn("PNT");
		 df.addColumn("AVG");
		 df.addColumn("JOLT");
		 df.addColumn("DC/WJ");
		 df.addColumn("RW");
		 df.addColumn("PSB");
		 df.addColumn("REJECT");
		 df.addColumn("Vehicle No.");
		 df.addColumn("KFIL Challan No.");
		 df.addColumn("KFIL Date");
		 df.addColumn("E-Way BILL");
//		 df.addColumn("Total Qty");
//		 df.addColumn("Transporter Name");
//		 df.addColumn("Taxable Value");
		 
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from outword where outwordno like '%"+textField_5.getText()+"%'";
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
	
	
	public Edit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		contentPane.add(panel, "name_909418185015834");
		JDateChooser dateChooser = new JDateChooser();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_1, "name_909425124867271");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		
		JMenuItem mntmGetData = new JMenuItem("Get Data");
		mntmGetData.setBackground(new Color(102, 102, 255));
		mntmGetData.setForeground(Color.WHITE);
		mntmGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		
		
		mntmGetData.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmGetData);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.setBackground(new Color(51, 102, 255));
		mntmEdit.setForeground(Color.WHITE);
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				contentPane.add(panel_1);
				contentPane.repaint();
				contentPane.revalidate();
				
				
//				
//			//	int fet  = Integer.parseInt(textField_25.getText());
//				int index  = table.getSelectedRow() ;
//				String id  = table.getValueAt(index, 0).toString();
//				
//				try {
//    				Driver dr = new com.mysql.jdbc.Driver();
//    				DriverManager.registerDriver(dr);
//    				
//    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
//    				java.sql.Connection con = DriverManager.getConnection(url);
//    				
//    			java.sql.Statement	stmt = con.createStatement();
//    		//	String deliverychallana = textField_25.getText();
//    		String query = "update  deliverychallan set  fet='"+"' where challanno='"+id+"'";
//    //   System.out.println(textField_25.getText());
//    			stmt.execute(query);
//    			
//        		} catch (Exception e) {
//					System.out.println(e.toString());
//				}
//				df = (DefaultTableModel) table.getModel();
//				df.setRowCount(0);
//				df.setColumnCount(0);
//				table.setModel(getdata());
				
			}
		});
		mntmEdit.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmEdit);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setBackground(new Color(51, 102, 255));
		mntmDelete.setForeground(Color.WHITE);
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
		
		mntmDelete.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmDelete);
		
		JMenuItem mntmCancel = new JMenuItem("Cancel");
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		mntmCancel.setBackground(new Color(51, 102, 255));
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		mntmExit.setBackground(new Color(51, 102, 255));
		mntmExit.setForeground(Color.WHITE);
		mntmExit.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmExit);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addComponent(toolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JComboBox comboBox_11 = new JComboBox();
		
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
				comboBox_11.addItem(transportername);
				System.out.println(transportername);
				 
				
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		comboBox_11.setBackground(Color.WHITE);
		String challanno = null ;
		panel.setLayout(gl_panel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String challanno = table.getValueAt(table.getSelectedRow(), 0).toString();
				Date dispatchdate = null;
				Date kfildate = null ;
				try {
					dispatchdate = new SimpleDateFormat("dd-MM-YYYY").parse((String)table.getValueAt(table.getSelectedRow(), 1));
				//	kfildate = new SimpleDateFormat("dd-MM-YYYY").parse((String)table.getValueAt(table.getSelectedRow(), 14));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String itemname = table.getValueAt(table.getSelectedRow(), 2).toString();
				String feet = table.getValueAt(table.getSelectedRow(), 3).toString();
				String rsb = table.getValueAt(table.getSelectedRow(), 4).toString();
				String pnt = table.getValueAt(table.getSelectedRow(), 5).toString();
				String avg = table.getValueAt(table.getSelectedRow(), 6).toString();
				String jolt = table.getValueAt(table.getSelectedRow(), 7).toString();
				String dcwj = table.getValueAt(table.getSelectedRow(), 8).toString();
				String rw = table.getValueAt(table.getSelectedRow(), 9).toString();
				String psb = table.getValueAt(table.getSelectedRow(), 10).toString();
				String reject = table.getValueAt(table.getSelectedRow(), 11).toString();
				String vehicleno = table.getValueAt(table.getSelectedRow(), 12).toString();
				//String kfilchallanno = table.getValueAt(table.getSelectedRow(), 13).toString();
//				
//				String ewaybilll = table.getValueAt(table.getSelectedRow(), 15).toString();
//				String transportername = table.getValueAt(table.getSelectedRow(), 17).toString();
//				String qty = table.getValueAt(table.getSelectedRow(), 16).toString();
//				String taxvalue = table.getValueAt(table.getSelectedRow(), 18).toString();
				
				
				textField.setText(challanno);
				dateChooser.setDate(dispatchdate);
				textField_2.setText(itemname);
				textField_4.setText(feet);
				textField_5.setText(rsb);
				textField_6.setText(pnt);
				textField_7.setText(avg);
				textField_8.setText(jolt);
				textField_9.setText(dcwj);
				textField_10.setText(rw);
				textField_11.setText(psb);
				textField_1.setText(reject);
				textField_24.setText(vehicleno);
				
				
				
		//		textField_24.setText(ewaybilll);
				
			//	comboBox_11.getModel().setSelectedItem(transportername);
				
				

				
			}
		});
		
		
		JLabel label = new JLabel("Delivery Challan No. :");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("Date :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel label_4 = new JLabel("Description Of The Goods :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 153));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Quantity ( Numbers/Weight/Litre) :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JCheckBox checkBox = new JCheckBox("FET");
		checkBox.setBounds(6, 23, 50, 23);
		checkBox.setBackground(new Color(204, 204, 153));
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_1 = new JCheckBox("RSB");
		checkBox_1.setBounds(87, 23, 51, 23);
		checkBox_1.setBackground(new Color(204, 204, 153));
		checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_2 = new JCheckBox("PNT");
		checkBox_2.setBounds(168, 23, 51, 23);
		checkBox_2.setBackground(new Color(204, 204, 153));
		checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_3 = new JCheckBox("JOLT");
		checkBox_3.setBounds(6, 80, 72, 20);
		checkBox_3.setBackground(new Color(204, 204, 153));
		checkBox_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_4 = new JCheckBox("AVG");
		checkBox_4.setBounds(249, 23, 53, 23);
		checkBox_4.setBackground(new Color(204, 204, 153));
		checkBox_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_5 = new JCheckBox("DC/WJ\r\n");
		checkBox_5.setBounds(87, 80, 72, 20);
		checkBox_5.setBackground(new Color(204, 204, 153));
		checkBox_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_6 = new JCheckBox("R/W");
		checkBox_6.setBounds(168, 80, 72, 20);
		checkBox_6.setBackground(new Color(204, 204, 153));
		checkBox_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JCheckBox checkBox_7 = new JCheckBox("PSB");
		checkBox_7.setBounds(249, 80, 72, 20);
		checkBox_7.setBackground(new Color(204, 204, 153));
		checkBox_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_4 = new JTextField();
		textField_4.setBounds(6, 53, 48, 20);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(87, 53, 48, 20);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(168, 53, 48, 20);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(249, 53, 48, 20);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(6, 110, 48, 20);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(87, 110, 48, 20);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(168, 110, 48, 20);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(249, 110, 48, 20);
		textField_11.setColumns(10);
		
		JLabel label_6 = new JLabel("TransPorter Name :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		
		JLabel label_7 = new JLabel("Truck Number :");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		
		JLabel label_8 = new JLabel("KFIL Delivery Challan No. and Date :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		
		JLabel label_9 = new JLabel("E-Way Bill No. :");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		
		JLabel label_10 = new JLabel("TransPorter Name :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		
		JLabel label_11 = new JLabel("Truck Number :");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		
		JLabel label_12 = new JLabel("KFIL Delivery Challan No. and Date :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		
		JLabel label_13 = new JLabel("E-Way Bill No. :");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		
		JLabel label_14 = new JLabel("TransPorter Name :");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(Color.WHITE);
		
		JLabel label_15 = new JLabel("Truck Number :");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBackground(Color.WHITE);
		
		JLabel label_16 = new JLabel("KFIL Delivery Challan No. and Date :");
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		
		JLabel label_17 = new JLabel("E-Way Bill No. :");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		
		JLabel label_18 = new JLabel("TransPorter Name :");
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBackground(Color.WHITE);
		
		JLabel label_19 = new JLabel("Truck Number :");
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBackground(Color.WHITE);
		
		JLabel label_20 = new JLabel("KFIL Delivery Challan No. and Date :");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		
		JLabel label_21 = new JLabel("E-Way Bill No. :");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		
		JLabel label_22 = new JLabel("TransPorter Name :");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBackground(Color.WHITE);
		
		JLabel label_23 = new JLabel("Truck Number :");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBackground(Color.WHITE);
		
		JLabel label_24 = new JLabel("KFIL Delivery Challan No. and Date :");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		
		JDateChooser dateChooser_6 = new JDateChooser();
		
		JLabel label_25 = new JLabel("E-Way Bill No. :");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		
		JLabel label_27 = new JLabel("TransPorter Name :");
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JLabel lblVehicleNumber = new JLabel("Vehicle Number  :\r\n");
		lblVehicleNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JLabel label_30 = new JLabel("E-Way Bill No. :");
		label_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		
		JLabel label_31 = new JLabel("Challan :");
		label_31.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JComboBox comboBox_13 = new JComboBox();
		comboBox_13.setBackground(Color.WHITE);
		comboBox_13.addItem("ORIGINAL FOR CONSIGNEE");
        comboBox_13.addItem("DUPLICATE FOR TRANSPORTER");
        comboBox_13.addItem("TRIPLICATE FOR ASSESSEE");
        
        JToolBar toolBar_2 = new JToolBar();
        toolBar_2.setForeground(new Color(153, 204, 255));
        toolBar_2.setBackground(new Color(153, 204, 255));
        
        JMenuItem mntmOk = new JMenuItem("Ok");
        mntmOk.setForeground(Color.WHITE);
        mntmOk.setFont(new Font("Arial Black", Font.BOLD, 14));
        mntmOk.setBackground(new Color(204, 102, 51));
        mntmOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
				//	int fet  = Integer.parseInt(textField_25.getText());
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    		//	String deliverychallana = textField_25.getText();
    		String query = "update  inword set  kfilchano='"+textField.getText()+"',kfildate='"+df.format(dateChooser.getDate())
    		+"',itemname='"+textField_2.getText()+"',fet='"+textField_4.getText()
    		+"',rsb='"+textField_5.getText()+"',pnt='"+textField_6.getText()+"',avge='"
    		+textField_7.getText()+"',dc='"+textField_8.getText()+"',rw='"+textField_9.getText()+"',psb='"+textField_10.getText()
    		+"',jolt='"+textField_11.getText()+"',vehicleno='"+textField_1.getText()
    		+"',ewaybill='"+textField_24.getText()+"'  where kfilchano='"+id+"'";
    	
    			stmt.execute(query);
    	
    			
        		} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				
        	}
        });
        toolBar_2.add(mntmOk);
        
        JMenuItem mntmCancel_2 = new JMenuItem("Cancel");
        mntmCancel_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
        	}
        });
        mntmCancel_2.setForeground(Color.WHITE);
        mntmCancel_2.setFont(new Font("Arial Black", Font.BOLD, 14));
        mntmCancel_2.setBackground(new Color(204, 102, 51));
        toolBar_2.add(mntmCancel_2);
        
        JMenuItem mntmExit_2 = new JMenuItem("Exit");
        mntmExit_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
        	}
        });
        mntmExit_2.setForeground(Color.WHITE);
        mntmExit_2.setFont(new Font("Arial Black", Font.BOLD, 14));
        mntmExit_2.setBackground(new Color(204, 102, 51));
        toolBar_2.add(mntmExit_2);
        panel_3.setLayout(null);
        panel_3.add(textField_4);
        panel_3.add(textField_5);
        panel_3.add(textField_6);
        panel_3.add(checkBox);
        panel_3.add(checkBox_1);
        panel_3.add(checkBox_2);
        panel_3.add(checkBox_4);
        panel_3.add(checkBox_3);
        panel_3.add(checkBox_5);
        panel_3.add(checkBox_6);
        panel_3.add(checkBox_7);
        panel_3.add(textField_7);
        panel_3.add(textField_8);
        panel_3.add(textField_9);
        panel_3.add(textField_10);
        panel_3.add(textField_11);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addComponent(toolBar_2, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        			.addGap(99)
        			.addComponent(comboBox_13, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label)
        			.addGap(39)
        			.addComponent(textField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_1)
        			.addGap(130)
        			.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_4)
        			.addGap(4)
        			.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_27)
        			.addGap(50)
        			.addComponent(comboBox_11, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(lblVehicleNumber, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
        			.addGap(51)
        			.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(13)
        			.addComponent(label_30)
        			.addGap(75)
        			.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_22)
        			.addGap(21)
        			.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_23)
        			.addGap(46)
        			.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_24)
        			.addGap(21)
        			.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(dateChooser_6, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_25)
        			.addGap(7)
        			.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_18)
        			.addGap(21)
        			.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_19)
        			.addGap(46)
        			.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_20)
        			.addGap(21)
        			.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(dateChooser_5, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_21)
        			.addGap(7)
        			.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_14)
        			.addGap(21)
        			.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_15)
        			.addGap(46)
        			.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_16)
        			.addGap(21)
        			.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(dateChooser_4, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_17)
        			.addGap(7)
        			.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_10)
        			.addGap(21)
        			.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_11)
        			.addGap(46)
        			.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_12)
        			.addGap(21)
        			.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(dateChooser_3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(2)
        			.addComponent(label_13)
        			.addGap(7)
        			.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_6)
        			.addGap(21)
        			.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_7)
        			.addGap(46)
        			.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_8)
        			.addGap(21)
        			.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(dateChooser_2, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(12)
        			.addComponent(label_9)
        			.addGap(7)
        			.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addComponent(toolBar_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addGap(24)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_31, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(comboBox_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(9)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(1)
        					.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(10)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(1)
        					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        				.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(label_4))
        				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(8)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
        			.addGap(6)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(label_27))
        				.addComponent(comboBox_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(lblVehicleNumber))
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(label_30))
        				.addComponent(textField_24, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(456)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_22)
        				.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_23)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_24)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_21, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(dateChooser_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(1)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_25)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_22, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(126)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_18)
        				.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_19)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_20)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(dateChooser_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(1)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_21)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(128)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_14)
        				.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_15)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_16)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(dateChooser_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(1)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_17)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(144)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_10)
        				.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_11)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_12)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(dateChooser_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(1)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_13)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(126)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_6)
        				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(5)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_7)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_8)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(dateChooser_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(1)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(label_9)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(2)
        					.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );
        panel_1.setLayout(gl_panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(204, 204, 153));
        contentPane.add(panel_2, "name_295311470461051");
        panel_2.setLayout(null);
        
        JLabel label_2 = new JLabel("Delivery Challan No. :");
        label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_2.setBounds(10, 77, 148, 19);
        panel_2.add(label_2);
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(160, 77, 172, 20);
        panel_2.add(textField_3);
        
        JLabel label_3 = new JLabel("Date :");
        label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_3.setBounds(10, 107, 46, 14);
        panel_2.add(label_3);
        
        JDateChooser dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(160, 101, 172, 20);
        panel_2.add(dateChooser_1);
        
        JLabel label_5 = new JLabel("InWord No. :");
        label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_5.setBounds(10, 132, 91, 19);
        panel_2.add(label_5);
        
        textField_12 = new JTextField();
        textField_12.setColumns(10);
        textField_12.setBounds(160, 133, 172, 20);
        panel_2.add(textField_12);
        
        JLabel label_26 = new JLabel("Description Of The Goods :");
        label_26.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_26.setBounds(10, 162, 161, 19);
        panel_2.add(label_26);
        
        JLabel label_28 = new JLabel("Identification Marks and Numbers,If Any :");
        label_28.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_28.setBounds(10, 192, 238, 19);
        panel_2.add(label_28);
        
        textField_23 = new JTextField();
        textField_23.setColumns(10);
        textField_23.setBounds(246, 191, 86, 20);
        panel_2.add(textField_23);
        
        JLabel label_29 = new JLabel("Taxable Value :");
        label_29.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_29.setBounds(10, 218, 91, 19);
        panel_2.add(label_29);
        
        textField_25 = new JTextField();
        textField_25.setColumns(10);
        textField_25.setBounds(160, 217, 172, 20);
        panel_2.add(textField_25);
        
        JLabel label_32 = new JLabel("Transporter Name :");
        label_32.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_32.setBounds(10, 246, 122, 19);
        panel_2.add(label_32);
        
        JComboBox comboBox_12 = new JComboBox();
        comboBox_12.setBounds(160, 245, 172, 20);
        panel_2.add(comboBox_12);
        
        JLabel label_33 = new JLabel("Truck Number :");
        label_33.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_33.setBounds(10, 271, 91, 19);
        panel_2.add(label_33);
        
        textField_26 = new JTextField();
        textField_26.setColumns(10);
        textField_26.setBounds(160, 270, 172, 20);
        panel_2.add(textField_26);
        
        JLabel label_34 = new JLabel("Qty . :");
        label_34.setFont(new Font("Tahoma", Font.BOLD, 11));
        label_34.setBounds(10, 302, 67, 19);
        panel_2.add(label_34);
        
        textField_27 = new JTextField();
        textField_27.setColumns(10);
        textField_27.setBounds(79, 301, 79, 20);
        panel_2.add(textField_27);
        
        JPanel panel_4 = new JPanel();
        panel_4.setLayout(null);
        panel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Quantity ( Numbers/Weight/Litre) :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_4.setBackground(new Color(204, 204, 153));
        panel_4.setBounds(10, 327, 430, 136);
        panel_2.add(panel_4);
        
        textField_28 = new JTextField();
        textField_28.setColumns(10);
        textField_28.setBounds(6, 53, 48, 20);
        panel_4.add(textField_28);
        
        textField_29 = new JTextField();
        textField_29.setColumns(10);
        textField_29.setBounds(87, 53, 48, 20);
        panel_4.add(textField_29);
        
        textField_30 = new JTextField();
        textField_30.setColumns(10);
        textField_30.setBounds(168, 53, 48, 20);
        panel_4.add(textField_30);
        
        JCheckBox checkBox_8 = new JCheckBox("FET");
        checkBox_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_8.setBackground(new Color(204, 204, 153));
        checkBox_8.setBounds(6, 23, 50, 23);
        panel_4.add(checkBox_8);
        
        JCheckBox checkBox_9 = new JCheckBox("RSB");
        checkBox_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_9.setBackground(new Color(204, 204, 153));
        checkBox_9.setBounds(87, 23, 51, 23);
        panel_4.add(checkBox_9);
        
        JCheckBox checkBox_10 = new JCheckBox("PNT");
        checkBox_10.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_10.setBackground(new Color(204, 204, 153));
        checkBox_10.setBounds(168, 23, 51, 23);
        panel_4.add(checkBox_10);
        
        JCheckBox checkBox_11 = new JCheckBox("AVG");
        checkBox_11.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_11.setBackground(new Color(204, 204, 153));
        checkBox_11.setBounds(249, 23, 51, 23);
        panel_4.add(checkBox_11);
        
        JCheckBox checkBox_12 = new JCheckBox("JOLT");
        checkBox_12.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_12.setBackground(new Color(204, 204, 153));
        checkBox_12.setBounds(6, 80, 72, 20);
        panel_4.add(checkBox_12);
        
        JCheckBox checkBox_13 = new JCheckBox("DC/WJ\r\n");
        checkBox_13.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_13.setBackground(new Color(204, 204, 153));
        checkBox_13.setBounds(87, 80, 72, 20);
        panel_4.add(checkBox_13);
        
        JCheckBox checkBox_14 = new JCheckBox("R/W");
        checkBox_14.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_14.setBackground(new Color(204, 204, 153));
        checkBox_14.setBounds(168, 80, 72, 20);
        panel_4.add(checkBox_14);
        
        JCheckBox checkBox_15 = new JCheckBox("PSB");
        checkBox_15.setFont(new Font("Tahoma", Font.BOLD, 11));
        checkBox_15.setBackground(new Color(204, 204, 153));
        checkBox_15.setBounds(249, 80, 72, 20);
        panel_4.add(checkBox_15);
        
        textField_31 = new JTextField();
        textField_31.setColumns(10);
        textField_31.setBounds(249, 53, 48, 20);
        panel_4.add(textField_31);
        
        textField_32 = new JTextField();
        textField_32.setColumns(10);
        textField_32.setBounds(6, 110, 48, 20);
        panel_4.add(textField_32);
        
        textField_33 = new JTextField();
        textField_33.setColumns(10);
        textField_33.setBounds(87, 110, 48, 20);
        panel_4.add(textField_33);
        
        textField_34 = new JTextField();
        textField_34.setColumns(10);
        textField_34.setBounds(168, 110, 48, 20);
        panel_4.add(textField_34);
        
        textField_35 = new JTextField();
        textField_35.setColumns(10);
        textField_35.setBounds(249, 110, 48, 20);
        panel_4.add(textField_35);
        
        JCheckBox chckbxReject = new JCheckBox("Reject");
        chckbxReject.setBackground(new Color(204, 204, 153));
        chckbxReject.setFont(new Font("Tahoma", Font.BOLD, 11));
        chckbxReject.setBounds(324, 23, 72, 23);
        panel_4.add(chckbxReject);
        
        textField_37 = new JTextField();
        textField_37.setBounds(318, 53, 48, 20);
        panel_4.add(textField_37);
        textField_37.setColumns(10);
        
        JToolBar toolBar_1 = new JToolBar();
        toolBar_1.setBounds(0, 0, 607, 44);
        panel_2.add(toolBar_1);
        
        JMenuItem mntmOk_1 = new JMenuItem("ok");
        mntmOk_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
				//	int fet  = Integer.parseInt(textField_25.getText());
				int index  = table_1.getSelectedRow() ;
				String id  = table_1.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    		//	String deliverychallana = textField_25.getText();
    		String query = "update  outword set  outwordno='"+textField_3.getText()+"',outdate='"+df.format(dateChooser_1.getDate())
    		+"',inwordno='"+textField_12.getText()+"',itemname='"+textField_36.getText()+"',taxablevalue='"+textField_25.getText()
    		+"',vehicleno='"+textField_26.getText()+"',totalqty='"+textField_27.getText()+"',fet1='"+textField_28.getText()
    		+"',rsb1='"+textField_29.getText()+"',pnt1='"+textField_30.getText()+"',avge1='"
    		+textField_31.getText()+"',jolt1='"+textField_32.getText()+"',dcwj1='"+textField_33.getText()+"',rw1='"+textField_34.getText()
    		+"',psb1='"+textField_35.getText()+"',rej1='"+textField_37.getText()
    		+"'  where outwordno='"+id+"'";
    	
    			stmt.execute(query);
    	
    			
        		} catch (Exception e1) {
					System.out.println(e1.toString());
				}
        	}
        });
        toolBar_1.add(mntmOk_1);
        
        JMenuItem mntmCancel_1 = new JMenuItem("Cancel");
        mntmCancel_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		Main m1 = new Main();
        		m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
        	}
        });
        toolBar_1.add(mntmCancel_1);
        
        JMenuItem mntmExit_1 = new JMenuItem("Exit");
        mntmExit_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
        	}
        });
        toolBar_1.add(mntmExit_1);
        
        textField_36 = new JTextField();
        textField_36.setBounds(160, 161, 172, 20);
        panel_2.add(textField_36);
        textField_36.setColumns(10);
        
        JPanel panel_5 = new JPanel();
        contentPane.add(panel_5, "name_295645950444992");
        
        JToolBar toolBar_3 = new JToolBar();
        
        JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_5);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		toolBar.add(mntmNewMenuItem);
        
        JMenuItem menuItem_1 = new JMenuItem("Edit");
        menuItem_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		contentPane.removeAll();
				contentPane.add(panel_2);
				contentPane.repaint();
				contentPane.revalidate();
        	}
        });
        menuItem_1.setForeground(Color.WHITE);
        menuItem_1.setFont(new Font("Arial Black", Font.BOLD, 14));
        menuItem_1.setBackground(new Color(51, 102, 255));
        toolBar_3.add(menuItem_1);
        
        JMenuItem menuItem_2 = new JMenuItem("Delete");
        menuItem_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {int index  = table_1.getSelectedRow() ;
			String id  = table_1.getValueAt(index, 0).toString();
			
			try {
				Driver dr = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con = DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			String query = "delete from outword where outwordno='"+id+"'";
   System.out.println(id);
			stmt.execute(query);
			
			df = (DefaultTableModel) table_1.getModel();
			df.setRowCount(0);
			df.setColumnCount(0);
			
    		} catch (Exception e) {
				System.out.println(e.toString());
			}
			df = (DefaultTableModel) table_1.getModel();
			df.setRowCount(0);
			table_1.setModel(getdata());
		
        		
        	}
        });
        menuItem_2.setForeground(Color.WHITE);
        menuItem_2.setFont(new Font("Arial Black", Font.BOLD, 14));
        menuItem_2.setBackground(new Color(51, 102, 255));
        toolBar_3.add(menuItem_2);
        
        JMenuItem menuItem_3 = new JMenuItem("Cancel");
        menuItem_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Main m1 = new Main();
        		m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
        	}
        });
        menuItem_3.setForeground(Color.WHITE);
        menuItem_3.setFont(new Font("Arial Black", Font.BOLD, 14));
        menuItem_3.setBackground(new Color(51, 102, 255));
        toolBar_3.add(menuItem_3);
        
        JMenuItem menuItem_4 = new JMenuItem("Exit");
        menuItem_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
        	}
        });
        menuItem_4.setForeground(Color.WHITE);
        menuItem_4.setFont(new Font("Arial Black", Font.BOLD, 14));
        menuItem_4.setBackground(new Color(51, 102, 255));
        toolBar_3.add(menuItem_4);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        
        table_1 = new JTable();
        table_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		String challanno = table_1.getValueAt(table_1.getSelectedRow(), 0).toString();
				Date dispatchdate = null;
				Date kfildate = null ;
				try {
					dispatchdate = new SimpleDateFormat("dd-MM-YYYY").parse((String)table_1.getValueAt(table_1.getSelectedRow(), 1));
				//	kfildate = new SimpleDateFormat("dd-MM-YYYY").parse((String)table.getValueAt(table.getSelectedRow(), 14));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String itemname = table_1.getValueAt(table_1.getSelectedRow(), 2).toString();
				String feet = table_1.getValueAt(table_1.getSelectedRow(), 3).toString();
				String rsb = table_1.getValueAt(table_1.getSelectedRow(), 4).toString();
				String pnt = table_1.getValueAt(table_1.getSelectedRow(), 5).toString();
				String avg = table_1.getValueAt(table_1.getSelectedRow(), 6).toString();
				String jolt = table_1.getValueAt(table_1.getSelectedRow(), 7).toString();
				String dcwj = table_1.getValueAt(table_1.getSelectedRow(), 8).toString();
				String rw = table_1.getValueAt(table_1.getSelectedRow(), 9).toString();
				String psb = table_1.getValueAt(table_1.getSelectedRow(), 10).toString();
				String reject = table_1.getValueAt(table_1.getSelectedRow(), 11).toString();
				String vehicleno = table_1.getValueAt(table_1.getSelectedRow(), 12).toString();
				String kfilchallanno = table_1.getValueAt(table_1.getSelectedRow(), 13).toString();
//				
				String ewaybilll = table_1.getValueAt(table_1.getSelectedRow(), 14).toString();
				String transportername = table_1.getValueAt(table_1.getSelectedRow(), 15).toString();
				
				textField_3.setText(challanno);
				dateChooser_1.setDate(dispatchdate);
				textField_12.setText(itemname);
				textField_36.setText(feet);
				textField_25.setText(rsb);
				textField_26.setText(pnt);
				textField_27.setText(avg);
				textField_28.setText(jolt);
				textField_29.setText(dcwj);
				textField_30.setText(rw);
				textField_31.setText(psb);
				textField_32.setText(reject);
				textField_33.setText(vehicleno);
				textField_34.setText(kfilchallanno);
				textField_35.setText(ewaybilll);
				textField_37.setText(transportername);
				
        	}
        });
        scrollPane_1.setViewportView(table_1);
        df = (DefaultTableModel) table_1.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table_1.setModel(getdata1());
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
					.addGap(10))
				.addComponent(toolBar_3, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
					.addGap(11))
				.addComponent(toolBar_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
		);
		panel_5.setLayout(gl_panel_5);
	}
}
