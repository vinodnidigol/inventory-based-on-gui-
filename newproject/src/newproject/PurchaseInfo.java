package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class PurchaseInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseInfo frame = new PurchaseInfo();
					frame.setLocationRelativeTo(null);
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
	int a1 =0;
	
//	DefaultTableModel df = new DefaultTableModel();
	DefaultTableModel getdata2() {
		
		 df.addColumn(" Item Name");
		 df.addColumn("Qty");
	    df.addColumn("Rate");
     	 df.addColumn("Amount");
	try {
		Driver dr = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(dr);
		
		String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
		java.sql.Connection con =  DriverManager.getConnection(url);
		String query = "select * from  purchaseinfo2  where challanno1 like '"+table_1.getValueAt(table_1.getSelectedRow(), 1)+"' ";
	    PreparedStatement	stmt = con.prepareStatement(query);
	     ResultSet rs= stmt.executeQuery();
	     String pdate = null ;
	     String challanno = null ;
	     String storename = null ;
	     String Grossamount = null ;
	    
		while(rs.next()) {
			 pdate =rs.getString("itemname");
			 challanno =rs.getString("qty");
			 storename =rs.getString("rate");
	     	 Grossamount =rs.getString("amt");
	    
	     String [] r1 = {pdate,challanno,storename,Grossamount } ;
	     	 
	     	 
	   //  	DefaultTableModel model = new DefaultTableModel();
 			df.addRow(r1);;
 			
		
	     	 
		}
		
//		 for(int i = 0;i<table.getRowCount();i++) {
//	     	 
//     		 for(int j=0;j<table.getColumnCount();j++) {
//     			DefaultTableModel model = new DefaultTableModel();
//     			model.setColumnIdentifiers(ob);
                
//     		 }
//     	 }
		
	  System.out.println(pdate+challanno+storename+Grossamount);

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.toString());
			System.out.println(e1);
		}
	return df;
	
	}
	
	DefaultTableModel getdata() {
		 
		 df.addColumn(" P date");
		 df.addColumn("Challan No.");
	 //    df.addColumn("Store Name.");
	//	 df.addColumn("FEET");
		 df.addColumn("GrossAmount");
	//	 df.addColumn("email");
	//	 df.addColumn("Open Bal");
//		 df.addColumn("dc");
//		 df.addColumn("rw");
//		 df.addColumn("psb");
//		 df.addColumn("jolt");
//		 df.addColumn("vehicle No.");
//		 df.addColumn("EwayBill");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  purchaseinfo1  where challanno like '%"+textField_9.getText()+"%' ";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a =rs.getString("pdate");
					String a1 =rs.getString("challanno");
				//	String b =rs.getString("itemname");
					String c =rs.getString("storename");
					String d =rs.getString("Grossamount");
			//		String e =rs.getString("emailid");
			//		String f =rs.getString("openingbal");
					
					 
					String [] rowdata = {a,a1,c,d};
					
			
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	DefaultTableModel getdata1() {
		
		String challanno = (String) table_1.getValueAt(table_1.getSelectedRow(), 1);
		String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
		String sql = "select * from  purchaseinfo1  where challanno like '%"+challanno+"%' ";
		
		
		try {
			
			Connection conn = (Connection) DriverManager.getConnection(url);
			Statement st = (Statement) conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String a =rs.getString("pdate");
				String a1 =rs.getString("challanno");
			//	String b =rs.getString("itemname");
				String c =rs.getString("storename");
				String d =rs.getString("Grossamount");
		//		String e =rs.getString("emailid");
		//		String f =rs.getString("openingbal");
				
				 
				String [] rowdata = {a,a1,c,d};
				
				textField.setText(a1);
		
				df.addRow(rowdata);
				
				
			}
			} catch (Exception e) {
				
				System.out.println(e.toString());
			}
		return df;  
		
	}
	
	
	public PurchaseInfo() {
		setTitle("Purchase Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PurchaseInfo.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 754, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 738, 40);
		contentPane.add(toolBar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(118, 73, 131, 20);
		contentPane.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(118, 133, 248, 27);
		contentPane.add(comboBox);
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from Storeinfo";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("Storename");
				comboBox.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				
					
					String query = "insert into purchaseinfo1 "
							+ " values('"+df.format(dateChooser.getDate())+"','"+textField.getText()
							+"','"+comboBox.getSelectedItem().toString()
							+"','"+textField_8.getText()+"') ";
					
					stmt.execute(query);
					
					JOptionPane.showMessageDialog(null, "data added");
					
				
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				for(int i = 0;i<table.getRowCount();i++) {
				      String item = (String) table.getValueAt(i, 0);
				      String qty = table.getValueAt(i, 1).toString();
				      String rate = table.getValueAt(i, 2).toString();
				      String amount = table.getValueAt(i, 3).toString();
				      
					
					String query = "insert into purchaseinfo2 "
							+ " values('"+item+"','"+qty
							+"','"+rate
							+"','"+amount+"','"+textField.getText()+"') ";
					
					stmt.execute(query);
				}
					JOptionPane.showMessageDialog(null, "data added");
					
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				
				 int i2 = 0;
				 int i1 = 0;
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = null ;
					 
					for(int i = 0;i<table.getRowCount();i++) {
						  String item = (String) table.getValueAt(i, 0);
						  String qty = (String) table.getValueAt(i, 1);
							
					 query = "select * from iteminfo where  itemname like'%"+item+"%'";
					
				    PreparedStatement	stmt = con.prepareStatement(query);
					
				     ResultSet rs= stmt.executeQuery();
			//	     int i2 = 0;
					while(rs.next()) {
						String transportername =rs.getString("openingstock");
						 i1 = Integer.parseInt(transportername);
						// i2+=i1 ;
					
						}
					
					i1+= Integer.parseInt((String)table.getValueAt(i, 1)); 
					String sql = "update iteminfo set openingstock ='"+i1+"' where itemname like '"+item+"'";
					System.out.println(item+","+i1);
					stmt.execute(sql);
					}
				
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				
				
				
				
			}
		});
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Edit");
		menuItem_1.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  purchaseinfo1  where challanno like '"+table_1.getValueAt(table_1.getSelectedRow(), 1)+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
					while(rs.next()) {
						 pdate =rs.getString("pdate");
						 challanno =rs.getString("challanno");
						 storename =rs.getString("storename");
						 Grossamount =rs.getString("Grossamount");
						
				
											
					}
					java.util.Date dispatchdate =  new SimpleDateFormat("yyyy-MM-dd").parse((String)pdate);
					dateChooser.setDate(dispatchdate);
					textField.setText(challanno);
					comboBox.setSelectedItem(storename);
					textField_8.setText(Grossamount);
					
				  System.out.println(pdate+challanno+storename+Grossamount);
			//	openingstock = Integer.parseInt(transportername1);
			//		System.out.println(openingstock);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata2());
				
			}
		});
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JMenuItem mntmUpdate = new JMenuItem("Update\r\n");
		mntmUpdate.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				for(int i = 0;i<table.getRowCount();i++) {
				      String item = (String) table.getValueAt(i, 0);
				      String qty = table.getValueAt(i, 1).toString();
				      String rate = table.getValueAt(i, 2).toString();
				      String amount = table.getValueAt(i, 3).toString();
				      
				      String query = "update purchaseinfo2 set qty='"+qty+"',rate='"+rate+"',amt = '"+amount+"' where challanno1='"+table_1.getValueAt(table_1.getSelectedRow(), 1)+"' and itemname ='"+item+"'  ";
				      stmt.execute(query);
				      System.out.println(item); 
				     System.out.println(qty); 
				     System.out.println(rate); 
				     System.out.println(amount); 
					
					
				
					
				}
					JOptionPane.showMessageDialog(null, "data updated");
					
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		
		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(118, 171, 248, 27);
		contentPane.add(comboBox_1);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				dateChooser.setDate(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
			}
		});
		mntmClear.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmClear.setForeground(Color.WHITE);
		mntmClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmClear.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmClear);
		
		JMenuItem menuItem_4 = new JMenuItem("Search");
		menuItem_4.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table_1.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_1.setModel(getdata());
			}
		});
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Exit");
		menuItem_5.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_5);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(29, 73, 78, 19);
		contentPane.add(lblDate);
		
		
		
		JLabel lblChallanNo = new JLabel("Challan No. :");
		lblChallanNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChallanNo.setBounds(29, 103, 78, 19);
		contentPane.add(lblChallanNo);
		
		textField_9 = new JTextField();
		textField_9.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table_1.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table_1.setModel(getdata());
				
			}
		});
		textField_9.setBounds(576, 43, 141, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_1.requestFocus();
				}
			}
		});
		textField.setBounds(118, 103, 131, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStoreName = new JLabel("Store Name :");
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStoreName.setBounds(29, 133, 98, 27);
		contentPane.add(lblStoreName);
		
		
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItemName.setBounds(29, 171, 78, 27);
		contentPane.add(lblItemName);
		
		
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from iteminfo";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("itemname");
				comboBox_1.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(29, 212, 78, 19);
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_2.requestFocus();
				}
			}
		});
		textField_1.setBounds(118, 212, 131, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRate = new JLabel("Rate :");
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRate.setBounds(29, 242, 78, 14);
		contentPane.add(lblRate);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_5.requestFocus();
				}
			}
		});
		textField_2.setBounds(118, 240, 131, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 338, 386, 127);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item Name", "Qty", "Rate", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(409, 88, 319, 528);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		df = (DefaultTableModel) table_1.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table_1.setModel(getdata());
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 40, 738, 23);
		contentPane.add(panel);
		
		JLabel lblPurchaseInformation = new JLabel("Purchase Information");
		lblPurchaseInformation.setForeground(Color.WHITE);
		lblPurchaseInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPurchaseInformation.setBounds(10, 0, 168, 23);
		panel.add(lblPurchaseInformation);
		
		JLabel lblEnterChallanNo = new JLabel("Enter Challan No. To Search :");
		lblEnterChallanNo.setForeground(Color.WHITE);
		lblEnterChallanNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterChallanNo.setBounds(387, 0, 184, 23);
		panel.add(lblEnterChallanNo);
		
		JLabel label_1 = new JLabel("View Information");
		label_1.setBounds(409, 66, 154, 19);
		contentPane.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				
				int Cal = Integer.parseInt(textField_1.getText())*Integer.parseInt(textField_2.getText());
			
				df.addRow(new Object[]  {comboBox_1.getSelectedItem().toString(),textField_1.getText(),textField_2.getText(),Cal});
				
			}
		});
		button.setBackground(new Color(204, 204, 153));
		button.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Stock Index Down/Stock Index Down_16x16.png")));
		button.setBounds(118, 298, 38, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(204, 204, 153));
		button_1.setIcon(new ImageIcon(PurchaseInfo.class.getResource("/must_have_icon_set/Stock Index Up/Stock Index Up_16x16.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				try {
					if(row != -1) {
						int model = table.convertRowIndexToModel(row);
						DefaultTableModel model1 = (DefaultTableModel) table.getModel() ;
						model1.removeRow(model);
					}
		
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		button_1.setBounds(160, 298, 38, 29);
		contentPane.add(button_1);
		
		JLabel lblGrossAmount = new JLabel("Gross Amount :");
		lblGrossAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrossAmount.setBounds(147, 476, 117, 27);
		contentPane.add(lblGrossAmount);
		//int a1 =0;
		textField_5 = new JTextField();
		
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_6.requestFocus();
				}
			}
		});
		textField_5.setBounds(270, 476, 131, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblExcicevattax = new JLabel("Excice\\vat\\Tax :");
		lblExcicevattax.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExcicevattax.setBounds(147, 514, 118, 27);
		contentPane.add(lblExcicevattax);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_7.requestFocus();
				}
			}
		});
		textField_6.setBounds(270, 514, 131, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblDiscount = new JLabel("Discount :");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiscount.setBounds(147, 552, 117, 22);
		contentPane.add(lblDiscount);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_8.requestFocus();
				}
			}
		});
		textField_7.setBounds(270, 547, 131, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("Total Amount :");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalAmount.setBounds(147, 585, 117, 31);
		contentPane.add(lblTotalAmount);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_8.setBounds(270, 585, 131, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		
	}
}
