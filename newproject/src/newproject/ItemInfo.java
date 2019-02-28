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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ItemInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
					ItemInfo frame = new ItemInfo();
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
		 
		 df.addColumn("No.");
		 df.addColumn("Store Name");
		 df.addColumn("itemname");
	//	 df.addColumn("alise name.");
	//	 df.addColumn("FEET");
	//	 df.addColumn("Measure");
	//	 df.addColumn("Item Rate");
	//	 df.addColumn("Opening Stock");
//		 df.addColumn("dc");
//		 df.addColumn("rw");
//		 df.addColumn("psb");
//		 df.addColumn("jolt");
//		 df.addColumn("vehicle No.");
//		 df.addColumn("EwayBill");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  iteminfo where Storename like '%"+textField_4.getText()+"%' ";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a2 =rs.getString("id");
					String a =rs.getString("Storename");
					String a1 =rs.getString("itemname");
				//	String b =rs.getString("itemname");
					String c =rs.getString("alisename");
					String d =rs.getString("measure");
					String e =rs.getString("itemrate");
					String f =rs.getString("openingstock");
					
					 
					String [] rowdata = {a2,a,a1,c,d,e,f};
					
			
					df.addRow(rowdata);
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.toString());
				}
		return df; 
	 }
	
	public ItemInfo() {
		setTitle("Item Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemInfo.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 603, 41);
		contentPane.add(toolBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 72, 328, 23);
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(144, 173, 152, 21);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("quantity");
		comboBox_1.addItem("peice");
		comboBox_1.addItem("liter");
		comboBox_1.addItem("Meter");
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df1 = new SimpleDateFormat("dd-MM-YYYY");
				
				
					
					String query = "insert into iteminfo(Storename,itemname,alisename,measure,itemrate,openingstock) "
							+ " values('"+comboBox.getSelectedItem().toString()+"','"+textField.getText()+"','"+textField_1.getText()
							+"','"+comboBox_1.getSelectedItem().toString()+"','"+textField_2.getText()+"','"+textField_3.getText()
							+"') ";
					
					stmt.execute(query);
					
					JOptionPane.showMessageDialog(null, "data added");
					df = (DefaultTableModel) table.getModel();
					df.setRowCount(0);
					df.setColumnCount(0);
					table.setModel(getdata());
					
				
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}

			}
		});
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Edit");
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_1.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  iteminfo  where id like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
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
						 challanno =rs.getString("itemname");
						 storename =rs.getString("alisename");
						 Grossamount =rs.getString("measure");
						 itemname =rs.getString("itemrate");
						 openingstock =rs.getString("openingstock");
				
											
					}
					
					comboBox.setSelectedItem(pdate);
					textField.setText(challanno);
					textField_1.setText(storename);
					comboBox_1.setSelectedItem(Grossamount);
					textField_2.setText(itemname);
					textField_3.setText(openingstock);
			//		java.util.Date dispatchdate =  new SimpleDateFormat("dd-MM-YYYY").parse((String)pdate);
			//		dateChooser.setDate(dispatchdate);
			//		textField.setText(challanno);
				//	comboBox.setSelectedItem(storename);
				//	textField_8.setText(Grossamount);
					
				  System.out.println(pdate+challanno+storename+Grossamount+itemname+openingstock);
			//	openingstock = Integer.parseInt(transportername1);
			//		System.out.println(openingstock);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
//				df = (DefaultTableModel) table.getModel();
//				df.setRowCount(0);
//				df.setColumnCount(0);
		//		table.setModel(getdata2());
			}
		});
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Delete");
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from iteminfo where id='"+id+"'";
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
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
				
				      
			     String query = "update iteminfo set Storename='"+comboBox.getSelectedItem()+"',itemname='"+textField.getText()+"',alisename = '"+textField_1.getText()+"' ,measure = '"+comboBox_1.getSelectedItem()
			     +"',itemrate = '"+textField_2.getText()
				    +"',openingstock = '"+textField_3.getText()+"' where id='"+table.getValueAt(table.getSelectedRow(), 0)+"'  ";
				      stmt.execute(query);
				    
					
					
				
					
				
					JOptionPane.showMessageDialog(null, "data updated");
					
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JMenuItem mntmClear = new JMenuItem("Clear");
		mntmClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				
			}
		});
		mntmClear.setHorizontalAlignment(SwingConstants.LEFT);
		mntmClear.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmClear.setForeground(Color.WHITE);
		mntmClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		mntmClear.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmClear);
		
		JMenuItem menuItem_4 = new JMenuItem("Search");
		menuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_4.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		menuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_5.setIcon(new ImageIcon(ItemInfo.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_5);
		
		JLabel lblStoreName = new JLabel("Store Name :");
		lblStoreName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStoreName.setBounds(10, 72, 124, 22);
		contentPane.add(lblStoreName);
		
		
		
		JLabel lblItemName = new JLabel("Item Name :");
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItemName.setBounds(10, 105, 124, 22);
		contentPane.add(lblItemName);
		
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
		textField.setBounds(144, 106, 328, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAliseName = new JLabel("Alise Name :");
		lblAliseName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAliseName.setBounds(10, 139, 124, 22);
		contentPane.add(lblAliseName);
		
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
		textField_1.setBounds(144, 140, 328, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMeasureIn = new JLabel("Measure in:");
		lblMeasureIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMeasureIn.setBounds(10, 172, 124, 22);
		contentPane.add(lblMeasureIn);
		
		
		
		JLabel lblItemRate = new JLabel("Item Rate :");
		lblItemRate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblItemRate.setBounds(10, 205, 124, 22);
		contentPane.add(lblItemRate);
		
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
		textField_2.setBounds(144, 205, 152, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOpeningStock = new JLabel("Opening Stock :");
		lblOpeningStock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOpeningStock.setBounds(10, 238, 124, 22);
		contentPane.add(lblOpeningStock);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					textField.requestFocus();
				}
			}
		});
		textField_3.setBounds(144, 238, 152, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 280, 603, 31);
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
		label_1.setBounds(187, 0, 184, 31);
		panel.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(381, 7, 157, 20);
		panel.add(textField_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 322, 583, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 41, 603, 23);
		contentPane.add(panel_1);
		
		JLabel lblItemInformation = new JLabel("Item Information");
		lblItemInformation.setForeground(Color.WHITE);
		lblItemInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblItemInformation.setBounds(10, 0, 168, 23);
		panel_1.add(lblItemInformation);
		
		JLabel lblNos = new JLabel("Nos");
		lblNos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNos.setBounds(317, 238, 46, 22);
		contentPane.add(lblNos);
	}
}
