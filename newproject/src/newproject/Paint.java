package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Paint extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	 String pdate = null ;
     String challanno = null ;
     String storename = null ;
     String Grossamount = null ;
     String itemname = null ;
     String openingstock = null ;
     
     String vehicleno = null ;
     String eway = null ;
     String tqty = null ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint frame = new Paint();
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
	private JTextField textField_4;
	
	DefaultTableModel getdata2() {
		
		
		 df.addColumn("Challan No.");
		 df.addColumn("Date");
		 df.addColumn("Item Name");

		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from paintinword where chano like '%"+textField_4.getText()+"%'";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String a =rs.getString("chano");
				String a1 =rs.getString("kfildate");
				String b =rs.getString("itemnamein");
				
				 
				String [] rowdata = {a,a1,b};
				
				df.addRow(rowdata);
				
				
			

			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		
		return df;}
	
	public Paint() {
		setTitle("PAINT INWORD");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Paint.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 823, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_1456819160933484");
		panel.setLayout(null);
		
		JLabel label = new JLabel("KFIL Challan No. :");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 115, 118, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(138, 113, 218, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("KFIL Date :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 143, 88, 14);
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 45, 796, 27);
		panel.add(panel_1);
		
		JLabel label_7 = new JLabel("In Word");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_7.setBackground(new Color(102, 51, 51));
		label_7.setBounds(10, 0, 117, 27);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Enter Challan No. To Search :");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_8.setBackground(new Color(102, 51, 51));
		label_8.setBounds(351, 0, 201, 27);
		panel_1.add(label_8);
		
		textField_4 = new JTextField();
		textField_4.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata2());
			}
		});
		textField_4.setBounds(554, 5, 232, 22);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		dateChooser.setDateFormatString("d/MM/yyyy");
		dateChooser.setBounds(138, 137, 218, 20);
		panel.add(dateChooser);
		
		JLabel label_2 = new JLabel("Descripition Of The Goods :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 169, 180, 14);
		panel.add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 166, 156, 22);
		panel.add(comboBox);
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
		
		
		JLabel label_3 = new JLabel("Quantity (Numbers/Weight/Litre ) :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(10, 203, 229, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(249, 201, 107, 20);
		panel.add(textField_1);
		
		JLabel label_4 = new JLabel("Transporter Name :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(10, 238, 140, 14);
		panel.add(label_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(160, 236, 196, 20);
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
			//	System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		panel.add(comboBox_1);
		
		JLabel label_5 = new JLabel("Vehicle No. :");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(10, 269, 118, 14);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 267, 196, 20);
		panel.add(textField_2);
		
		JLabel label_6 = new JLabel("E-Way Bill :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(10, 294, 140, 14);
		panel.add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 292, 196, 20);
		panel.add(textField_3);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 797, 41);
		panel.add(toolBar);
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				 java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "insert into Paintinword values('"+Integer.parseInt(textField.getText())+"','"+df1.format(dateChooser.getDate())
    			+"','"+comboBox.getSelectedItem().toString()+"','"+textField_2.getText()+"','"+textField_3.getText()+"','"+textField_1.getText()+"')";
       
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
		menuItem.setSelected(true);
		menuItem.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Edit");
		menuItem_1.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
			
				Driver dr = new com.mysql.jdbc.Driver();
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				String query = "select * from  Paintinword  where chano = '"+table.getValueAt(table.getSelectedRow(), 0)+"' ";
			    PreparedStatement	stmt = con.prepareStatement(query);
			     ResultSet rs= stmt.executeQuery();
			    
			     
				while(rs.next()) {
			     	 pdate =rs.getString("chano");
					 challanno =rs.getString("kfildate");
					 storename =rs.getString("itemnamein");
					
					 vehicleno = rs.getString("vehicleno");
					 eway = rs.getString("ewaybill");
			        tqty = rs.getString("tqty");
										
				}
				
				
				
				
				java.util.Date dispatchdate =  new SimpleDateFormat("yyyy-MM-dd").parse((String)challanno);
		    	dateChooser.setDate(dispatchdate);
		    	comboBox.setSelectedItem(storename);
		    	textField.setText(pdate);
		    	textField_1.setText(tqty);
		    	textField_2.setText(vehicleno);
		    	textField_3.setText(eway);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		menuItem_1.setSelected(true);
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Update\r\n");
		menuItem_2.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				  String query = "update paintinword set chano='"+textField.getText()+"',kfildate = '"+df.format(dateChooser.getDate())
				     +"',itemnamein ='"+comboBox.getSelectedItem().toString()+"',vehicleno='"+textField_2.getText()+"',ewaybill='"+textField_3.getText()
				    		 +"',tqty='"+textField_1.getText()+"' where chano='"+id+"'";
					      stmt.execute(query);
					    
						JOptionPane.showMessageDialog(null, "data updated");
						
					
						
						} catch (Exception e1) { 
							JOptionPane.showMessageDialog(null, e1.toString());
							System.out.println(e1);
						}
			}
		});
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Clear");
		menuItem_3.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dateChooser.setDate(null);
		    	comboBox.setSelectedItem(null);
		    	textField.setText(null);
		    	textField_1.setText(null);
		    	textField_2.setText(null);
		    	textField_3.setText(null);

			
			}
		});
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_3.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Delete");
		menuItem_4.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from paintinword where chano='"+id+"'";
       System.out.println(id);
    			stmt.execute(query);
    			
    			JOptionPane.showMessageDialog(null, "data deleted");
    			
    			df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
    			
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				table.setModel(getdata2());
			}
		});
		menuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Search");
		menuItem_5.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Search/Search_24x24.png")));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				df = (DefaultTableModel) table.getModel();
				df.setRowCount(0);
				df.setColumnCount(0);
				table.setModel(getdata2());
			}
		});
		menuItem_5.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Exit");
		menuItem_6.setIcon(new ImageIcon(Paint.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_6.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_6.setForeground(Color.WHITE);
		menuItem_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_6.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(409, 83, 378, 380);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata2());
		
		
	}
}
