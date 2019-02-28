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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class EmployeeInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfo frame = new EmployeeInfo();
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
	DefaultTableModel getdata() {
		 df.addColumn("Employee Id");
		 df.addColumn("Employee Name");
		 df.addColumn("Permanent Address");
		 df.addColumn("Job Type.");
	//	 df.addColumn("FEET");
		 df.addColumn("Employee Status");
	//	 df.addColumn("email");
	//	 df.addColumn("Open Bal");
//		 df.addColumn("dc");
//		 df.addColumn("rw");
//		 df.addColumn("psb");
//		 df.addColumn("jolt");
//		 df.addColumn("vehicle No.");
//		 df.addColumn("EwayBill");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  employeeinfo where id like '%"+textField_8.getText()+"%' ";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a =rs.getString("id");
					String a1 =rs.getString("empname");
		//			String b =rs.getString("gender");
					String c =rs.getString("paddress");
		//			String d =rs.getString("city");
		//			String e =rs.getString("phoneno");
		//			String f =rs.getString("emailid");
		//			String g =rs.getString("caddress");
		//			String h =rs.getString("mobileno");
		//			String i =rs.getString("emptype");
		//			String j =rs.getString("salary");
					String k =rs.getString("jobtype");
		//			String l =rs.getString("jdate");
		//			String m =rs.getString("ldate");
					String n =rs.getString("empstatus");
					
					 
					String [] rowdata = {a,a1,c,k,n};
					
					
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	public EmployeeInfo() {
		setTitle("Employee Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EmployeeInfo.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 939, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 923, 43);
		contentPane.add(toolBar);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 139, 116, 25);
		contentPane.add(comboBox);
		comboBox.addItem("male");
		comboBox.addItem("female");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(783, 105, 130, 23);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("Permanent");
		comboBox_1.addItem("Temporary");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(783, 174, 130, 25);
		contentPane.add(comboBox_2);
		comboBox_2.addItem("full time");
		comboBox_2.addItem("part time");
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(783, 210, 130, 25);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(783, 245, 130, 25);
		contentPane.add(dateChooser_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(783, 285, 130, 25);
		contentPane.add(comboBox_3);
		comboBox_3.addItem("Active");
		comboBox_3.addItem("DeActive");
		
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_2.requestFocus();
				}
			}
		});
		textArea.setBounds(135, 175, 197, 60);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_6.requestFocus();
				}
			}
		});
		textArea_1.setBounds(446, 174, 187, 60);
		contentPane.add(textArea_1);
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				
					
					String query = "insert into employeeinfo(empname,gender,paddress,city,phoneno,emailid,caddress,mobileno,emptype,salary,jobtype,jdate,ldate,empstatus) "
							+ " values('"+textField.getText()+"','"+comboBox.getSelectedItem().toString()+"','"+textArea.getText()
							+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()
							+"','"+textArea_1.getText()+"','"+textField_6.getText()+"','"+comboBox_1.getSelectedItem().toString()+"','"+textField_7.getText()
							+"','"+comboBox_2.getSelectedItem().toString()+"','"+df.format(dateChooser.getDate())+"','"+df.format(dateChooser_1.getDate())
							+"','"+comboBox_3.getSelectedItem().toString()+"') ";
					
					stmt.execute(query);
					
					JOptionPane.showMessageDialog(null, "data added");
					
				
					
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
		menuItem_1.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  employeeinfo  where id like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String itemname = null ;
				     String openingstock = null ;
				     String caddress = null ;
				     String mobileno = null ;
				     String emptype = null ;
				    String salary = null ;
				     String jobtype = null ;
				     String jdate = null ;
				     String ldate = null ;
				     String empstatus = null ;
					while(rs.next()) {
				     	 pdate =rs.getString("empname");
						 challanno =rs.getString("gender");
						 storename =rs.getString("paddress");
						 Grossamount =rs.getString("city");
						 itemname =rs.getString("phoneno");
						 openingstock =rs.getString("emailid");
						 caddress =rs.getString("caddress");
						 mobileno =rs.getString("mobileno");
						 emptype =rs.getString("emptype");
						 salary =rs.getString("salary");
						 jobtype =rs.getString("jobtype");
						 jdate =rs.getString("jdate");
						 ldate =rs.getString("ldate");
						 empstatus =rs.getString("empstatus");
						 comboBox_3.setSelectedItem(empstatus);
				
											
					}
					
					
					java.util.Date dispatchdate =  new SimpleDateFormat("dd-MM-yyyy").parse((String)jdate);
					java.util.Date dispatchdate1 =  new SimpleDateFormat("dd-MM-yyyy").parse((String)ldate);
			   // 	dateChooser.setDate(dispatchdate);
			   // 	comboBox.setSelectedItem(pdate);
			    	comboBox.setSelectedItem(challanno);
			     	textField.setText(pdate);
			     	textArea.setText(storename);
			     	textField_2.setText(Grossamount);
			     	textField_3.setText(itemname);
			     	textField_4.setText(openingstock);
			     	textArea_1.setText(caddress);
			     	textField_6.setText(mobileno);
			     	comboBox_1.setSelectedItem(emptype);
			     	textField_7.setText(salary);
			     	comboBox_2.setSelectedItem(jobtype);
			     	dateChooser.setDate(dispatchdate);
			     	dateChooser_1.setDate(dispatchdate1);
			   
			    	comboBox_1.setSelectedItem(itemname);
			    //	textArea.setText(openingstock);
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
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
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
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				      System.out.println(table.getValueAt(table.getSelectedRow(), 0));
			     String query = "update employeeinfo set empname='"+textField.getText()+"',gender='"+comboBox.getSelectedItem().toString()
			    	+"',paddress = '"+textArea.getText()+"' ,city = '"+textField_2.getText()+"',phoneno = '"+textField_3.getText()
				    +"',emailid = '"+textField_4.getText()+"',caddress = '"+textArea_1.getText()
				    +"',mobileno = '"+textField_6.getText()+"',emptype = '"+comboBox_1.getSelectedItem().toString()
				    +"',salary = '"+textField_7.getText()+"',jobtype = '"+comboBox_2.getSelectedItem().toString()
				    +"',jdate = '"+dateChooser.getDate()+"',ldate = '"+dateChooser_1.getDate()+"',empstatus  = '"+comboBox_3.getSelectedItem().toString()
				    +"'  where id='"+id+"'";
				      stmt.execute(query);
				    
					
					
				
					
				
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
		menuItem_2.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from employeeinfo where id='"+id+"'";
       System.out.println(id);
    			stmt.execute(query);
    			
    			df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
    			
        		} catch (Exception e1) {
					System.out.println(e1.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				table.setModel(getdata());
			}
		});
		
		
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				textArea.setText(null);
				textArea_1.setText(null);
				dateChooser.setDate(null);
				dateChooser_1.setDate(null);
			}
		});
		mntmClear.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmClear.setForeground(Color.WHITE);
		mntmClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmClear.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmClear);
		
		JMenuItem menuItem_4 = new JMenuItem("Search");
		menuItem_4.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
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
		menuItem_5.setIcon(new ImageIcon(EmployeeInfo.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_5);
		
		JLabel lblEmployeeCode = new JLabel("Employee Code :");
		lblEmployeeCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeCode.setBounds(10, 80, 118, 18);
		contentPane.add(lblEmployeeCode);
		
		JLabel lblGenerateAfterSave = new JLabel("Generate After Save .");
		lblGenerateAfterSave.setBounds(135, 80, 197, 18);
		contentPane.add(lblGenerateAfterSave);
		
		JLabel lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeName.setBounds(10, 103, 118, 25);
		contentPane.add(lblEmployeeName);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textArea.requestFocus();
				}
			}
		});
		textField.setBounds(135, 102, 498, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(10, 139, 118, 25);
		contentPane.add(lblGender);
		
		
		
		
		JLabel lblPermanentAddress = new JLabel("Permanent Address :");
		lblPermanentAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPermanentAddress.setBounds(10, 175, 118, 18);
		contentPane.add(lblPermanentAddress);
		
		JLabel lblCityName = new JLabel("City Name :");
		lblCityName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCityName.setBounds(10, 245, 118, 26);
		contentPane.add(lblCityName);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_3.requestFocus();
				}
			}
		});
		textField_2.setBounds(135, 245, 197, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No. :");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNo.setBounds(10, 282, 118, 26);
		contentPane.add(lblPhoneNo);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_4.requestFocus();
				}
			}
		});
		textField_3.setBounds(135, 282, 197, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email ID :");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailId.setBounds(10, 319, 118, 25);
		contentPane.add(lblEmailId);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textArea_1.requestFocus();
				}
			}
		});
		textField_4.setBounds(135, 319, 498, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCorrespondanceAddress = new JLabel("Correspondance\r\n :\r\n");
		lblCorrespondanceAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCorrespondanceAddress.setBounds(338, 177, 98, 25);
		contentPane.add(lblCorrespondanceAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setVerticalAlignment(SwingConstants.TOP);
		lblAddress.setBounds(342, 202, 94, 25);
		contentPane.add(lblAddress);
		
		JLabel lblMobileNo = new JLabel("Mobile No. :");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMobileNo.setBounds(346, 282, 90, 25);
		contentPane.add(lblMobileNo);
		
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
		textField_6.setBounds(443, 282, 190, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEmployeeType = new JLabel("Employee Type :");
		lblEmployeeType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeType.setBounds(657, 102, 116, 26);
		contentPane.add(lblEmployeeType);
		
		
		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSalary.setBounds(657, 144, 116, 20);
		contentPane.add(lblSalary);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_7.setBounds(783, 141, 130, 23);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblJobType = new JLabel("Job Type :");
		lblJobType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJobType.setBounds(657, 175, 116, 25);
		contentPane.add(lblJobType);
		
		
		
		JLabel lblJoiningDate = new JLabel("Joining Date :");
		lblJoiningDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJoiningDate.setBounds(657, 211, 116, 24);
		contentPane.add(lblJoiningDate);
		
		
		
		JLabel lblLeavingDate = new JLabel("Leaving Date :");
		lblLeavingDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeavingDate.setBounds(657, 245, 116, 25);
		contentPane.add(lblLeavingDate);
		
		
		
		JLabel lblEmployeeStatus = new JLabel("Employee Status :");
		lblEmployeeStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeStatus.setBounds(657, 282, 116, 26);
		contentPane.add(lblEmployeeStatus);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 355, 923, 31);
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
		label_1.setBounds(562, 1, 184, 31);
		panel.add(label_1);
		
		textField_8 = new JTextField();
		textField_8.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(756, 7, 157, 20);
		panel.add(textField_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 397, 903, 135);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 44, 923, 25);
		contentPane.add(panel_1);
		
		JLabel lblEmployeeInformation = new JLabel("Employee Information");
		lblEmployeeInformation.setForeground(Color.WHITE);
		lblEmployeeInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmployeeInformation.setBounds(10, 0, 168, 23);
		panel_1.add(lblEmployeeInformation);
		
		
		
		
	}
}
