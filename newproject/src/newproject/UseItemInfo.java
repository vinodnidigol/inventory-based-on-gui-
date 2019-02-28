package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class UseItemInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;

	String s1 ="0" ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UseItemInfo frame = new UseItemInfo();
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
	private JTable table;
	DefaultTableModel getdata() {
		 
	    	df.addColumn("id");
		
		 df.addColumn("itemname");
		 df.addColumn("date");
		 df.addColumn("useqty");
		 df.addColumn("employee Name");

		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql1 = "select * from  useiteminfo where itemname like '%"+textField_3.getText()+"%' ";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql1);
				
				while(rs.next()) {
				//	String a =rs.getString("date");
					String a1 =rs.getString("itemname");
					String a =rs.getString("date");
					String b =rs.getString("id");
				//	String c =rs.getString("itemstock");
					String d =rs.getString("useqty");
					String e =rs.getString("empname");
				//	String f =rs.getString("reason");
					
					 
					String [] rowdata = {b,a1,a,d,e};
					
			
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	public UseItemInfo() {
		setTitle("Use Item Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UseItemInfo.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 628, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 612, 42);
		contentPane.add(toolBar);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Select Item");
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
				comboBox.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		int ss = 0 ;
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Driver dr = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				String query = "select * from iteminfo where  itemname like'%"+comboBox.getSelectedItem().toString()+"%'";
			    PreparedStatement	stmt = con.prepareStatement(query);
			     ResultSet rs= stmt.executeQuery();
			     int i2 = 0;
				while(rs.next()) {
					String transportername =rs.getString("openingstock");
					 s1 = transportername;

				//	 i2 = Integer.parseInt(transportername);
//					 i2+=i1 ;
					textField.setText(String.valueOf(transportername));
					System.out.println(transportername);
					 
//					String vechileNumber = rs.getString("vechilenumber");
//					comboBox_5.addItem(vechileNumber);
				}
				
			
				
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString());
					System.out.println(e1);
				}
			}
		});
		comboBox.setBounds(172, 116, 286, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 206, 286, 19);
		contentPane.add(comboBox_1);
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from employeeinfo";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("empname");
				comboBox_1.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(172, 87, 143, 20);
		contentPane.add(dateChooser);
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_1.requestFocus();
				}
			}
		});
		textArea.setBounds(172, 236, 286, 54);
		contentPane.add(textArea);
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
    				Driver dr1 = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr1);
    				
    				String url1 ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con1 = DriverManager.getConnection(url1);
    				
    			java.sql.Statement	stmt1 = con1.createStatement();
    	
    			int s3 =0 ;
    			
    	//		 s3+=i2 ;
    			 String s2 = String.valueOf(s3);
    			 int a1 = Integer.parseInt(textField_1.getText());
    			 int a3 = Integer.parseInt(s1);
    			 int a2 = a3-a1 ;
    		String query1 = "update  iteminfo set  openingstock='"+a2+"' where itemname='"+comboBox.getSelectedItem().toString()+"' ";
    	
    			stmt1.execute(query1);
    			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
    			String query = "insert into useiteminfo(date,itemname,itemstock,useqty,empname,reason) "
						+ " values('"+df1.format(dateChooser.getDate())+"','"+comboBox.getSelectedItem().toString()
						+"','"+textField.getText()
						+"','"+textField_1.getText()+"','"+comboBox_1.getSelectedItem().toString()+"','"+textArea.getText()+"') ";
    			
    			 stmt1.execute(query);
    			 JOptionPane.showMessageDialog(null, "data added");
    			df = (DefaultTableModel) table.getModel();
 				df.setRowCount(0);
 				df.setColumnCount(0);
 				table.setModel(getdata());
        		} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
				
			}
		});
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Edit");
		menuItem_1.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  useiteminfo  where id like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String itemname = null ;
				     String openingstock = null ;
					while(rs.next()) {
				     	 pdate =rs.getString("date");
						 challanno =rs.getString("itemname");
						 storename =rs.getString("itemstock");
						 Grossamount =rs.getString("useqty");
						 itemname =rs.getString("empname");
						 openingstock =rs.getString("reason");
				
											
					}
					
					
					java.util.Date dispatchdate =  new SimpleDateFormat("yyyy-MM-dd").parse((String)pdate);
			    	dateChooser.setDate(dispatchdate);
			    	comboBox.setSelectedItem(challanno);
			   // 	textField.setText(storename);
			    	textField_1.setText(Grossamount);
			    	comboBox_1.setSelectedItem(itemname);
			    	textArea.setText(openingstock);
			    	
				  System.out.println(pdate+challanno+storename+Grossamount+itemname+openingstock);
			
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = (String) table.getValueAt(table.getSelectedRow(),0) ;
				 int useqty = 0 ;
				 int openingstock = 0 ;
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from useiteminfo where id like '"+name+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String transportername = null ;
				     String transportername1 = null ;
				     String transportername2 = null ;
					while(rs.next()) {
						 transportername =rs.getString("itemname");
						 transportername1 =rs.getString("itemstock");
						 transportername2 =rs.getString("useqty");
						
				
											
					}
					System.out.println(transportername+transportername1+transportername2);
				useqty =Integer.parseInt(transportername2);
					System.out.println(useqty);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from iteminfo where id like '"+table.getValueAt(table.getSelectedRow(), 0)+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String transportername = null ;
				     String transportername1 = null ;
				     String transportername2 = null ;
					while(rs.next()) {
						 transportername =rs.getString("itemname");
						 transportername1 =rs.getString("openingstock");
						// transportername2 =rs.getString("useqty");
						
				
											
					}
					
					System.out.println(transportername+transportername1+transportername2);
				openingstock = Integer.parseInt(transportername1);
					System.out.println(openingstock);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			int abc =useqty+openingstock ;
    			System.out.println("update"+useqty);
    			System.out.println("update"+openingstock);
    			System.out.println(abc);
    			String query = "update  iteminfo set openingstock ='"+abc+"' where id='"+table.getValueAt(table.getSelectedRow(), 0)+"'";
    			stmt.execute(query);
    			String query1 = "delete from useiteminfo where id='"+name+"'";
                System.out.println(name);
    			stmt.execute(query1);
    			
    			df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
    			
				JOptionPane.showMessageDialog(null, "Data Deleted");
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
				
			}
		});
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = (String) table.getValueAt(table.getSelectedRow(),0) ;
				 int useqty = 0 ;
				 int openingstock = 0 ;
				 int R1 =0;
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from useiteminfo where id like '"+name+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String transportername = null ;
				     String transportername1 = null ;
				     String transportername2 = null ;
					while(rs.next()) {
						 transportername =rs.getString("itemname");
						 transportername1 =rs.getString("itemstock");
						 transportername2 =rs.getString("useqty");
						
				
						     df = (DefaultTableModel) table.getModel();
							df.setRowCount(0);
							df.setColumnCount(0);
							table.setModel(getdata());	
					}
			//		System.out.println(transportername+transportername1+transportername2);
				useqty =Integer.parseInt(transportername2);
					System.out.println(useqty);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from iteminfo where id like '"+table.getValueAt(table.getSelectedRow(), 0)+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String transportername = null ;
				     String transportername1 = null ;
				     String transportername2 = null ;
					while(rs.next()) {
						 transportername =rs.getString("itemname");
						 transportername1 =rs.getString("openingstock");
					//	 transportername2 =rs.getString("useqty");
						
				
											
					}
					
					System.out.println(transportername+transportername1+transportername2);
				openingstock = Integer.parseInt(transportername1);
					System.out.println(openingstock);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				 if(useqty<Integer.parseInt(textField_1.getText())){
    				R1 =useqty+Integer.parseInt(textField_1.getText());
    				         R1=openingstock-Integer.parseInt(textField_1.getText());
    			} else if(useqty>Integer.parseInt(textField_1.getText())){
    				int a1 =useqty-Integer.parseInt(textField_1.getText());
    				int a2=useqty-Integer.parseInt(textField_1.getText());
    				R1 =openingstock+a2;
    			}
    			System.out.println("checked "+R1);
				
				try {
					DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			int abc =useqty+openingstock ;
    			
    			System.out.println("update"+useqty);
    			System.out.println("update"+openingstock);
    			System.out.println(abc);
    			
    			String query = "update  iteminfo set openingstock ='"+R1+"' where id='"+table.getValueAt(table.getSelectedRow(), 2)+"'";
    			stmt.execute(query);
    			String query1 = "update useiteminfo set date='"+df1.format(dateChooser.getDate())+"',itemname='"+comboBox.getSelectedItem().toString()+"',itemstock = '"+textField.getText()+"' ,useqty = '"+textField_1.getText()
			     +"',empname='"+comboBox_1.getSelectedItem().toString()+"',reason='"+textArea.getText()+"' where id like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
    		//	String query1 = "delete from useiteminfo where id='"+name+"'";
                System.out.println(name);
    			stmt.execute(query1);
    			
    			df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
    			
				JOptionPane.showMessageDialog(null, "Data Updated");
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				table.setModel(getdata());
				
				
				
			}
		});
		mntmUpdate.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dateChooser.setDate(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				textField.setText(null);
				textField_1.setText(null);
				textArea.setText(null);
				
			}
		});
		mntmClear.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmClear.setForeground(Color.WHITE);
		mntmClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmClear.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmClear);
		
		JMenuItem menuItem_4 = new JMenuItem("Search");
		menuItem_4.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Exit");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_5.setIcon(new ImageIcon(UseItemInfo.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_5);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(36, 87, 46, 19);
		contentPane.add(lblDate);
		
		
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItemName.setBounds(36, 117, 101, 19);
		contentPane.add(lblItemName);
		
		
		
		JLabel lblItemStock = new JLabel("Item Stock :");
		lblItemStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItemStock.setBounds(36, 147, 101, 19);
		contentPane.add(lblItemStock);
		
		textField = new JTextField();
		
		
		textField.setEditable(false);
		textField.setBounds(172, 146, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(338, 147, 73, 19);
		contentPane.add(lblQuantity);
		
		JLabel lblUseQuantity = new JLabel("Use Quantity :");
		lblUseQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUseQuantity.setBounds(36, 176, 101, 19);
		contentPane.add(lblUseQuantity);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textArea.requestFocus();
				}
			}
		});
		textField_1.setBounds(172, 175, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterInQuantity = new JLabel("Enter in Quantity");
		lblEnterInQuantity.setBounds(338, 176, 101, 19);
		contentPane.add(lblEnterInQuantity);
		
		JLabel lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmployeeName.setBounds(36, 206, 126, 19);
		contentPane.add(lblEmployeeName);
		
		
		JLabel lblReason = new JLabel("Reason :");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReason.setBounds(36, 236, 101, 19);
		contentPane.add(lblReason);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 300, 612, 31);
		contentPane.add(panel);
		
		JLabel label = new JLabel("View Information");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label.setBounds(10, 0, 154, 31);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Enter Store Name To Search :");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBounds(251, 1, 184, 31);
		panel.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(445, 7, 157, 20);
		panel.add(textField_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 42, 612, 23);
		contentPane.add(panel_1);
		
		JLabel lblUseItemInformation = new JLabel("Use Item Information");
		lblUseItemInformation.setForeground(Color.WHITE);
		lblUseItemInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUseItemInformation.setBounds(10, 0, 168, 23);
		panel_1.add(lblUseItemInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 341, 592, 139);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		
		
	}
}
