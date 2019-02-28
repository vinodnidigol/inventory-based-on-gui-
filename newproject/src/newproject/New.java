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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class New extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New frame = new New();
				//	frame.setExtendedState(frame.MAXIMIZED_BOTH);
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
	private JTextField textField_10;
	DefaultTableModel getdata() {
		 
		 df.addColumn("Part Name");
		 
		 df.addColumn("FEET");
		 df.addColumn("RSB");
		 df.addColumn("PNT");
		 df.addColumn("AVG");
		 df.addColumn("JOLT");
		 df.addColumn("DC/WJ");
		 df.addColumn("RW");
		 df.addColumn("PSB");
		
		 df.addColumn("Part Weight");
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  parttype where partname like '%"+textField_10.getText()+"%'   ;";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a = rs.getString("partname");
					String d = rs.getString("fet11");
					String e = rs.getString("rsb11");
					String f = rs.getString("pnt11");
					String g = rs.getString("avge11");
					String h = rs.getString("jolt11");
					String i = rs.getString("dc11");
					String j = rs.getString("rw11");
					String k =rs.getString("psb11");
					String l = rs.getString("partweight");
					
					
					
					String [] rowdata = {a,d,e,f,g,h,i,j,k,l};
				
					df.addRow(rowdata);
			
					
					
				}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
		return df; 
	 }
	
	public New() {
		setTitle("Part Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage(New.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_433088645015717");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 776, 36);
		toolBar.setBackground(UIManager.getColor("Button.background"));
		
		JLabel lblPartName = new JLabel("Part Name :");
		lblPartName.setBounds(6, 78, 76, 23);
		lblPartName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 37, 776, 30);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setLayout(null);
		
		JLabel lblProductDetails = new JLabel("Part Details");
		lblProductDetails.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblProductDetails.setForeground(Color.WHITE);
		lblProductDetails.setBackground(new Color(102, 51, 51));
		lblProductDetails.setBounds(10, 0, 561, 30);
		panel_1.add(lblProductDetails);
		
		JLabel lblEnterProductName = new JLabel("Enter Product Name To Search :");
		lblEnterProductName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterProductName.setForeground(Color.WHITE);
		lblEnterProductName.setBackground(new Color(102, 51, 51));
		lblEnterProductName.setBounds(348, 0, 223, 30);
		panel_1.add(lblEnterProductName);
		
		textField_10 = new JTextField();
		textField_10.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		textField_10.setBounds(581, 0, 185, 29);
		panel_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_9.requestFocus();
				}
			}
		});
		textField.setBounds(92, 80, 182, 20);
		textField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("FET");
		checkBox.setBounds(6, 125, 67, 20);
		checkBox.setBackground(new Color(204, 204, 153));
		checkBox.setSelected(false);
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_1 = new JCheckBox("RSB");
		checkBox_1.setBounds(6, 148, 67, 23);
		checkBox_1.setBackground(new Color(204, 204, 153));
		checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_2 = new JCheckBox("PNT");
		checkBox_2.setBounds(6, 174, 67, 23);
		checkBox_2.setBackground(new Color(204, 204, 153));
		checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_3 = new JCheckBox("AVG");
		checkBox_3.setBounds(6, 200, 67, 23);
		checkBox_3.setBackground(new Color(204, 204, 153));
		checkBox_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_4 = new JCheckBox("JOLT");
		checkBox_4.setBounds(6, 226, 67, 23);
		checkBox_4.setBackground(new Color(204, 204, 153));
		checkBox_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_5 = new JCheckBox("DC/WJ");
		checkBox_5.setBounds(6, 252, 67, 23);
		checkBox_5.setBackground(new Color(204, 204, 153));
		checkBox_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_6 = new JCheckBox("R/W");
		checkBox_6.setBounds(6, 278, 67, 23);
		checkBox_6.setBackground(new Color(204, 204, 153));
		checkBox_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JCheckBox checkBox_7 = new JCheckBox("PSB");
		checkBox_7.setBounds(6, 304, 67, 23);
		checkBox_7.setBackground(new Color(204, 204, 153));
		checkBox_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSave.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		mntmSave.setForeground(Color.WHITE);
		mntmSave.setBackground(new Color(102, 51, 51));
		mntmSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Driver dr;
				try {
					dr = new com.mysql.jdbc.Driver();
				
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			
			DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
			
			String query ="insert into parttype(partname,fet11,rsb11,pnt11,avge11,jolt11,dc11,rw11,psb11,partweight )"
					+ " values('"+textField.getText()+"','"+Double.parseDouble(textField_1.getText())+"','"+Double.parseDouble(textField_2.getText())+"','"
					+Double.parseDouble(textField_3.getText())+"','"+Double.parseDouble(textField_4.getText())+"','"+Double.parseDouble(textField_5.getText())+"','"+Double.parseDouble(textField_6.getText())
					+"','"+Double.parseDouble(textField_7.getText())+"','"+Double.parseDouble(textField_8.getText())+"','"+Double.parseDouble(textField_9.getText())+"')" ;
			
			stmt.execute(query);
			
			JOptionPane.showMessageDialog(null, "data added");
		
			
			
			} catch (Exception e) {
				System.out.println(e.toString());
			}
				df = (DefaultTableModel) table.getModel();
				df.setColumnCount(0);
				df.setRowCount(0);
				table.setModel(getdata());
			}	
			
		});
		toolBar.add(mntmSave);
		
//		JMenuItem mntmModify = new JMenuItem("Modify");
//		mntmModify.setForeground(Color.WHITE);
//		mntmModify.setBackground(new Color(102, 102, 255));
//		mntmModify.setFont(new Font("Arial Black", Font.BOLD, 14));
//		mntmModify.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				
//				Driver dr;
//				try {
//					dr = new com.mysql.jdbc.Driver();
//				
//				DriverManager.registerDriver(dr);
//				
//				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
//				java.sql.Connection con =  DriverManager.getConnection(url);
//				
//			java.sql.Statement	stmt = con.createStatement();
//			
//			
//			DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
//			
//			String query ;
//			
//			if (checkBox.isSelected()) {
//				
//				
//		         query = "update parttype set partname ='"+textField.getText()+"'";
//				
//					stmt.execute(query);
//				}	
//				if (checkBox_1.isSelected()) {
//					
//			         query = "update parttype set fet1 ='"+textField_1.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_2.isSelected()) {
//					
//			         query = "update productdetails set pnt1 ='"+textField_2.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_3.isSelected()) {
//					
//			         query = "update productdetails set avvg1 ='"+textField_3.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_4.isSelected()) {
//					
//			         query = "update productdetails set jolt1 ='"+textField_4.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_5.isSelected()) {
//					
//			         query = "update productdetails set dc1 ='"+textField_5.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_6.isSelected()) {
//					
//			         query = "update productdetails set rw1 ='"+textField_6.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				if (checkBox_7.isSelected()) {
//					
//			         query = "update productdetails set psb1 ='"+textField_7.getText()+"'";
//					
//						stmt.execute(query);
//					}	
//				
//					JOptionPane.showMessageDialog(null, "data added");
//			
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//		toolBar.add(mntmModify);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDelete.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
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
    			
    			String query = "delete from parttype where partname='"+id+"'";
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
		
		JMenuItem mntmGetData = new JMenuItem("Edit");
		mntmGetData.setHorizontalAlignment(SwingConstants.LEFT);
		mntmGetData.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		mntmGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  parttype  where partname like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String itemname = null ;
				     String openingstock = null ;
				     String dc11 = null ;
				     String rw11 = null ;
				     String psb11 = null ;
				     String partweight = null ;
				   
					while(rs.next()) {
				     	 pdate =rs.getString("partname");
						 challanno =rs.getString("fet11");
						 storename =rs.getString("rsb11");
						 Grossamount =rs.getString("pnt11");
						 itemname =rs.getString("avge11");
						 openingstock =rs.getString("jolt11");
						 dc11 =rs.getString("dc11");
						 rw11 =rs.getString("rw11");
						 psb11 =rs.getString("psb11");
						 partweight =rs.getString("partweight");
				
											
					}
					
					
				
			    	textField.setText(pdate);
			    	textField_1.setText(challanno);
			    	textField_2.setText(storename);
			    	textField_3.setText(Grossamount);
			    	textField_4.setText(itemname);
			    	textField_5.setText(openingstock);
			    	textField_6.setText(dc11);
			    	textField_7.setText(rw11);
			    	textField_8.setText(psb11);
			    	textField_9.setText(partweight);
			    	
			
				  System.out.println(pdate+challanno+storename+Grossamount+itemname+openingstock);
			
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
				
				
			}
		});
		mntmGetData.setBackground(new Color(102, 51, 51));
		mntmGetData.setForeground(Color.WHITE);
		mntmGetData.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmGetData);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
			//	java.sql.Statement	stmt = con.createStatement();
			//	String query = "select * from  storeinfo  where storename like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				
			     String query = "update parttype set partname='"+textField.getText()+"',fet11='"+textField_1.getText()
			     +"',rsb11 = '"+textField_2.getText()+"' ,pnt11 = '"+textField_3.getText()
			     +"',avge11 = '"+textField_4.getText()
				    +"',jolt11 = '"+textField_5.getText()+"',dc11 = '"+textField_6.getText()+"',rw11 = '"+textField_7.getText()
				    +"',psb11 = '"+textField_8.getText()+"',partweight = '"+textField_9.getText()
				    +"' where partname like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				 PreparedStatement	stmt = con.prepareStatement(query);
			     stmt.execute(query);
				    
			
					JOptionPane.showMessageDialog(null, "data updated");
					
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		mntmDelete.setForeground(Color.WHITE);
		mntmDelete.setBackground(new Color(102, 51, 51));
		mntmDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmDelete);
		
		JMenuItem mntmCancel = new JMenuItem("Clear");
		mntmCancel.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCancel.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
			}
		});
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmExit.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		
		JMenuItem menuItem = new JMenuItem("Search");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem.setIcon(new ImageIcon(New.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		mntmExit.setForeground(Color.WHITE);
		mntmExit.setBackground(new Color(102, 51, 51));
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmExit);
		
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_2.requestFocus();
				}
			}
		});
		textField_1.setBounds(88, 126, 86, 19);
		textField_1.setBackground(Color.WHITE);
	//	textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_3.requestFocus();
				}
			}
		});
		textField_2.setBounds(88, 150, 86, 20);
	//	textField_2.setEnabled(false);
		textField_2.setColumns(10);
		
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
		textField_3.setBounds(88, 176, 86, 20);
	//	textField_3.setEnabled(false);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_5.requestFocus();
				}
			}
		});
		textField_4.setBounds(88, 202, 86, 20);
	//	textField_4.setEnabled(false);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_6.requestFocus();
				}
			}
		});
		textField_5.setBounds(88, 228, 86, 20);
	//	textField_5.setEnabled(false);
		textField_5.setColumns(10);
		
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
		textField_6.setBounds(88, 254, 86, 20);
	//	textField_6.setEnabled(false);
		textField_6.setColumns(10);
		
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
		textField_7.setBounds(88, 280, 86, 20);
	//	textField_7.setEnabled(false);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_8.setBounds(88, 306, 86, 20);
	//	textField_8.setEnabled(false);
		textField_8.setColumns(10);
		
		JLabel lblPartWeight = new JLabel("Part Weight :");
		lblPartWeight.setBounds(284, 78, 85, 23);
		lblPartWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if(key==10) {
					textField_1.requestFocus();
				}
			}
		});
		textField_9.setBounds(372, 80, 86, 20);
		textField_9.setColumns(10);
		
		JLabel lblKg = new JLabel("K.G");
		lblKg.setBounds(468, 79, 25, 20);
		lblKg.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 126, 584, 199);
		
		table = new JTable();
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		scrollPane.setViewportView(table);
		
		
		panel.setLayout(null);
		panel.add(textField);
		panel.add(lblPartName);
		panel.add(checkBox);
		panel.add(checkBox_1);
		panel.add(textField_2);
		panel.add(checkBox_2);
		panel.add(textField_3);
		panel.add(checkBox_3);
		panel.add(textField_4);
		panel.add(checkBox_4);
		panel.add(textField_5);
		panel.add(checkBox_5);
		panel.add(textField_6);
		panel.add(checkBox_6);
		panel.add(textField_7);
		panel.add(checkBox_7);
		panel.add(textField_8);
		panel.add(lblPartWeight);
		panel.add(textField_9);
		panel.add(lblKg);
		panel.add(textField_1);
		panel.add(toolBar);
		panel.add(panel_1);
		panel.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 51, 51));
		panel_2.setBounds(182, 102, 594, 23);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblViewInformation = new JLabel("View Information");
		lblViewInformation.setForeground(Color.WHITE);
		lblViewInformation.setBackground(new Color(102, 51, 51));
		lblViewInformation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblViewInformation.setBounds(10, 0, 151, 23);
		panel_2.add(lblViewInformation);
		
		JLabel label = new JLabel("Product Rate");
		label.setBounds(6, 102, 92, 23);
		panel.add(label);
		label.setForeground(new Color(0, 0, 0));
		label.setBackground(new Color(204, 204, 153));
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
	}
}
