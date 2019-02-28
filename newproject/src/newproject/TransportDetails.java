package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;

public class TransportDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	DefaultTableModel df = new DefaultTableModel();
	private JTextField textField_4;
	DefaultTableModel getdata() {
		 
		 df.addColumn("Transporter Name");
		 df.addColumn("Vehicle Number");
//		 df.addColumn("Driver name");
//		 df.addColumn("Licence Number");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  transporterdetils where transportername like '%"+textField_4.getText()+"%'";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a = rs.getString("Transportername");
					String b = rs.getString("vechilenumber");
					String c = rs.getString("drivername");
					String d = rs.getString("licencenumber");
					
					
					
					String [] rowdata = {a,b,c,d};
				
					df.addRow(rowdata);
			
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
				}
		return df; 
	 }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransportDetails frame = new TransportDetails();
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
	public TransportDetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TransportDetails.class.getResource("/vk112.png")));
		setTitle("Transporter Details\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 710, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTransportCompanyName = new JLabel("Transport Company Name :");
		lblTransportCompanyName.setBounds(15, 86, 175, 20);
		lblTransportCompanyName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		textField.setBounds(200, 87, 229, 20);
		textField.setColumns(10);
		
		JLabel lblTruckNumber = new JLabel("Vehicle Number :");
		lblTruckNumber.setBounds(15, 118, 172, 20);
		lblTruckNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		textField_1.setBounds(200, 118, 229, 20);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 51));
		panel.setBounds(0, 218, 693, 22);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 46, 693, 22);
		contentPane.setLayout(null);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblViewInformation = new JLabel("View Information");
		lblViewInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblViewInformation.setForeground(Color.WHITE);
		lblViewInformation.setBackground(new Color(102, 51, 51));
		lblViewInformation.setBounds(10, 0, 215, 22);
		panel.add(lblViewInformation);
		
		JLabel lblEnterTransporterName = new JLabel("Enter Transporter Name To Search :");
		lblEnterTransporterName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEnterTransporterName.setForeground(Color.WHITE);
		lblEnterTransporterName.setBackground(new Color(102, 51, 51));
		lblEnterTransporterName.setBounds(235, 0, 248, 22);
		panel.add(lblEnterTransporterName);
		
		textField_4 = new JTextField();
		textField_4.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		textField_4.setBounds(493, 1, 190, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDriverName = new JLabel("Driver Name :");
		lblDriverName.setBounds(15, 149, 175, 20);
		lblDriverName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		textField_2.setBounds(200, 149, 229, 20);
		textField_2.setColumns(10);
		
		JLabel lblLicenceNumber = new JLabel("Licence Number :");
		lblLicenceNumber.setBounds(15, 180, 175, 20);
		lblLicenceNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		
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
		textField_3.setBounds(200, 180, 229, 20);
		textField_3.setColumns(10);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(5, 5, 688, 35);
		toolBar.setBackground(UIManager.getColor("Button.background"));
		
		JMenuItem mntmGetData = new JMenuItem("Edit");
		mntmGetData.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		mntmGetData.setHorizontalAlignment(SwingConstants.LEFT);
		mntmGetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  transporterdetils  where transportername like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				     String pdate = null ;
				     String challanno = null ;
				     String storename = null ;
				     String Grossamount = null ;
				     String itemname = null ;
				     String openingstock = null ;
					while(rs.next()) {
				     	 pdate =rs.getString("transportername");
						 challanno =rs.getString("vechilenumber");
						 storename =rs.getString("drivername");
						 Grossamount =rs.getString("licencenumber");
						
				
											
					}
					
					textField.setText(pdate);
					
					textField_1.setText(challanno);
					textField_2.setText(storename);
					textField_3.setText(Grossamount);
					
					
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
		
		JMenuItem mntmAdd = new JMenuItem("Save");
		mntmAdd.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		mntmAdd.setHorizontalAlignment(SwingConstants.LEFT);
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
				java.sql.Statement	stmt = con.createStatement();
				
				
				DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
				
				
					
					String query = "insert into TransporterDetils (TransporterName,vechileNumber,DriverName,LicenceNumber)"
							+ " values('"+textField.getText()+"','"+textField_1.getText()
							+"','"+textField_2.getText()+"','"+textField_3.getText()+"') ";
					
					stmt.execute(query);
					
					JOptionPane.showMessageDialog(null, "data added");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
				
					
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmAdd.setBackground(new Color(102, 51, 51));
		mntmAdd.setForeground(new Color(255, 255, 255));
		mntmAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmAdd);
		mntmGetData.setBackground(new Color(102, 51, 51));
		mntmGetData.setForeground(new Color(255, 255, 255));
		mntmGetData.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmGetData);
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
                    
				try {
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					
			//	java.sql.Statement	stmt = con.createStatement();
			//	String query = "select * from  storeinfo  where storename like '%"+table.getValueAt(table.getSelectedRow(), 0)+"%' ";
				
			     String query = "update TransporterDetils set transportername='"+textField.getText()+"',vechilenumber='"+textField_1.getText()+"',drivername = '"+textField_2.getText()+"' ,licencenumber = '"+textField_3.getText()
			     +"' where transportername like '%"+id+"%' ";
				 PreparedStatement	stmt = con.prepareStatement(query);
			     stmt.execute(query);
				    
			
					JOptionPane.showMessageDialog(null, "data updated");
					
				
					
					} catch (Exception e1) { 
						JOptionPane.showMessageDialog(null, e1.toString());
						System.out.println(e1);
					}
			}
		});
		mntmUpdate.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		mntmUpdate.setForeground(Color.WHITE);
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmUpdate);
		
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
    			
    			String query = "delete from TransporterDetils where transportername='"+id+"'";
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
		mntmDelete.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		mntmDelete.setHorizontalAlignment(SwingConstants.LEFT);
		mntmDelete.setBackground(new Color(102, 51, 51));
		mntmDelete.setForeground(new Color(255, 255, 255));
		mntmDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmDelete);
		
		JMenuItem mntmCancel = new JMenuItem("Clear");
		mntmCancel.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setForeground(new Color(255, 255, 255));
		mntmCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit.setHorizontalAlignment(SwingConstants.LEFT);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  int exit = JOptionPane.showConfirmDialog(null, "Really Do You  Want Exit","Exit", JOptionPane.YES_NO_OPTION);
					
					if(exit ==0) {
						System.exit(0);
					}
			}
		});
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata());
			}
		});
		mntmSearch.setIcon(new ImageIcon(TransportDetails.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		mntmSearch.setHorizontalAlignment(SwingConstants.LEFT);
		mntmSearch.setForeground(Color.WHITE);
		mntmSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmSearch.setBackground(new Color(102, 51, 51));
		toolBar.add(mntmSearch);
		mntmExit.setBackground(new Color(102, 51, 51));
		mntmExit.setForeground(new Color(255, 255, 255));
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 246, 674, 151);
		
		table = new JTable();
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		
		
		
		JLabel lblTransporterDetails = new JLabel("Transporter Details");
		lblTransporterDetails.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTransporterDetails.setForeground(Color.WHITE);
		lblTransporterDetails.setBackground(new Color(102, 51, 51));
		lblTransporterDetails.setBounds(10, 0, 229, 22);
		panel_1.add(lblTransporterDetails);
		contentPane.add(toolBar);
		contentPane.add(lblTransportCompanyName);
		contentPane.add(textField);
		contentPane.add(lblTruckNumber);
		contentPane.add(textField_1);
		contentPane.add(lblDriverName);
		contentPane.add(textField_2);
		contentPane.add(lblLicenceNumber);
		contentPane.add(textField_3);
		contentPane.add(scrollPane);
	}
}
