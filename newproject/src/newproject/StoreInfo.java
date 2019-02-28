package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
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

public class StoreInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					StoreInfo frame = new StoreInfo();
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
	//	df.addColumn("Id");
		 df.addColumn("Store Name");
		 df.addColumn("Address");
	//	 df.addColumn("city.");
	//	 df.addColumn("FEET");
		 df.addColumn("Phone No.");
	//	 df.addColumn("email");
	//	 df.addColumn("Open Bal");
//		 df.addColumn("dc");
//		 df.addColumn("rw");
//		 df.addColumn("psb");
//		 df.addColumn("jolt");
//		 df.addColumn("vehicle No.");
//		 df.addColumn("EwayBill");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  storeinfo where Storename like '%"+textField_6.getText()+"%' ";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a =rs.getString("Storename");
					String a1 =rs.getString("Address");
				//	String b =rs.getString("id");
				//	String c =rs.getString("cityname");
					String d =rs.getString("phoneno");
			//		String e =rs.getString("emailid");
			//		String f =rs.getString("openingbal");
					
					 
					String [] rowdata = {a,a1,d};
					
			
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	
	public StoreInfo() {
		setTitle("Store Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(StoreInfo.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 623, 37);
		contentPane.add(toolBar);
		
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
		textArea.setBounds(143, 107, 361, 52);
		contentPane.add(textArea);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSave.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
				
				
					
					String query = "insert into Storeinfo "
							+ " values('"+textField.getText()+"','"+textArea.getText()
							+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()
							+"','"+textField_5.getText()+"') ";
					
					stmt.execute(query);
					
					JOptionPane.showMessageDialog(null, "data added");
					
				
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmSave.setForeground(Color.WHITE);
		mntmSave.setBackground(new Color(102, 51, 51));
		mntmSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmSave);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmEdit.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  storeinfo  where storename like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String itemname = null ;
				     String openingstock = null ;
					while(rs.next()) {
				     	 pdate =rs.getString("Storename");
						 challanno =rs.getString("Address");
						 storename =rs.getString("cityname");
						 Grossamount =rs.getString("phoneno");
						 itemname =rs.getString("emailid");
						 openingstock =rs.getString("openingbal");
				
											
					}
					
					textField.setText(pdate);
					textArea.setText(challanno);
					textField_2.setText(storename);
					textField_3.setText(Grossamount);
					textField_4.setText(itemname);
					textField_5.setText(openingstock);
					
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
		mntmEdit.setForeground(Color.WHITE);
		mntmEdit.setBackground(new Color(102, 51, 51));
		mntmEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmEdit);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
                    
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
			//	java.sql.Statement	stmt = con.createStatement();
			//	String query = "select * from  storeinfo  where storename like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				
			     String query = "update Storeinfo set Storename='"+textField.getText()+"',address='"+textArea.getText()+"',cityname = '"+textField_2.getText()+"' ,phoneno = '"+textField_3.getText()
			     +"',emailid = '"+textField_4.getText()
				    +"',openingbal = '"+textField_5.getText()+"' where storename like '%"+id+"%' ";
				 PreparedStatement	stmt = con.prepareStatement(query);
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
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDelete.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
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
    			
    			String query = "delete from storeinfo where storename='"+id+"'";
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
		mntmDelete.setForeground(Color.WHITE);
		mntmDelete.setBackground(new Color(102, 51, 51));
		mntmDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmDelete);
		
		JMenuItem mntmCancel = new JMenuItem("Clear");
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textArea.setText(null);
			}
		});
		mntmCancel.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCancel.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSearch.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
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
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmExit.setIcon(new ImageIcon(StoreInfo.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit.setForeground(Color.WHITE);
		mntmExit.setBackground(new Color(102, 51, 51));
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmExit);
		
		JLabel lblStoreName = new JLabel("Store Name :");
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStoreName.setBounds(10, 76, 116, 20);
		contentPane.add(lblStoreName);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textArea.requestFocus();
				}
			}
		});
		textField.setBounds(143, 77, 361, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(10, 107, 116, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCityName = new JLabel("City Name :");
		lblCityName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCityName.setBounds(10, 173, 116, 20);
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
		textField_2.setBounds(143, 170, 361, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No. :");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhoneNo.setBounds(10, 205, 116, 22);
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
		textField_3.setBounds(143, 207, 361, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Email - ID :");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmailId.setBounds(10, 238, 116, 20);
		contentPane.add(lblEmailId);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField_5.requestFocus();
				}
			}
		});
		textField_4.setBounds(143, 238, 361, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOpeningBalance = new JLabel("Opening Balance :");
		lblOpeningBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOpeningBalance.setBounds(10, 274, 116, 14);
		contentPane.add(lblOpeningBalance);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_5.setBounds(143, 269, 157, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 299, 623, 31);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblViewInformation = new JLabel("View Information");
		lblViewInformation.setForeground(Color.WHITE);
		lblViewInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblViewInformation.setBounds(10, 0, 154, 31);
		panel.add(lblViewInformation);
		
		JLabel lblEnterStoreName = new JLabel("Enter Store Name To Search :");
		lblEnterStoreName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterStoreName.setForeground(Color.WHITE);
		lblEnterStoreName.setBounds(262, 1, 184, 31);
		panel.add(lblEnterStoreName);
		
		textField_6 = new JTextField();
		textField_6.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		
		textField_6.setBounds(456, 7, 157, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 341, 603, 120);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 153));
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 38, 623, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStoreInformation = new JLabel("Store Information");
		lblStoreInformation.setForeground(Color.WHITE);
		lblStoreInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblStoreInformation.setBounds(10, 0, 168, 25);
		panel_1.add(lblStoreInformation);
		
		
	}
}
