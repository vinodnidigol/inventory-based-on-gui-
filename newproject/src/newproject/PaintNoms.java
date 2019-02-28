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
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class PaintNoms extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_5;
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
					PaintNoms frame = new PaintNoms();
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
	DefaultTableModel getdata2() {
		
		
		 df.addColumn("PNT CAST");
		 df.addColumn("PNT");
		 df.addColumn("THINNER");
		 df.addColumn("PNT NORMS");
		 df.addColumn("THINNER NORMS");


		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from pntnorms";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String a =rs.getString("pntcast");
				String a1 =rs.getString("pnt");
				String b =rs.getString("thinner");
				String c =rs.getString("pntnorms");
				String d =rs.getString("thinnernorms");

				
				 
				String [] rowdata = {a,a1,b,c,d};
				
				df.addRow(rowdata);
				
				
			

			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		
		
		return df;}
	
	
	public PaintNoms() {
		setTitle("PAINT NORMS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PaintNoms.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_1457354458947223");
		panel.setLayout(null);
		
		JLabel lblPaintedCasting = new JLabel("Painted Casting :\r\n");
		lblPaintedCasting.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaintedCasting.setBounds(10, 78, 110, 17);
		panel.add(lblPaintedCasting);
		
		JLabel lblPaint = new JLabel("Paint :");
		lblPaint.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaint.setBounds(10, 106, 60, 17);
		panel.add(lblPaint);
		
		JLabel lblThinner = new JLabel("Thinner :\r\n");
		lblThinner.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThinner.setBounds(10, 134, 109, 20);
		panel.add(lblThinner);
		
		JLabel lblPaintNorms = new JLabel("Paint Norms :");
		lblPaintNorms.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPaintNorms.setBounds(10, 165, 109, 17);
		panel.add(lblPaintNorms);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 165, 169, 20);
		panel.add(textField_2);
		
		JLabel lblThinnerNorms = new JLabel("Thinner Norms :");
		lblThinnerNorms.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThinnerNorms.setBounds(10, 196, 109, 20);
		panel.add(lblThinnerNorms);
		
		JLabel lblLtr = new JLabel("Ltr.");
		lblLtr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLtr.setBounds(302, 167, 19, 14);
		panel.add(lblLtr);
		
		JLabel lblMl = new JLabel("\\ml.");
		lblMl.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMl.setBounds(321, 168, 27, 14);
		panel.add(lblMl);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(130, 196, 169, 20);
		panel.add(textField_5);
		
		JLabel label = new JLabel("Ltr.");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(302, 200, 19, 14);
		panel.add(label);
		
		JLabel lblml = new JLabel("\\ml.");
		lblml.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblml.setBounds(321, 199, 27, 14);
		panel.add(lblml);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 532, 41);
		panel.add(toolBar);
		
		JComboBox comboBox_2 = new JComboBox();
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_1 = new JComboBox();
		
		JMenuItem menuItem = new JMenuItem("Save");
		menuItem.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("YYYY-MM-dd");
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				 java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "insert into pntnorms values('"+comboBox_2.getSelectedItem().toString()+
    			"','"+comboBox.getSelectedItem().toString()+"','"+comboBox_1.getSelectedItem().toString()+"','"+textField_2.getText()+"','"+textField_5.getText()+"')";
       
    			stmt.execute(query);
    			
    			JOptionPane.showMessageDialog(null, "data saved");
//    			df = (DefaultTableModel) table.getModel();
//    			df.setRowCount(0);
//    			df.setColumnCount(0);
//    			table.setModel(getdata2());
              
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
		menuItem_1.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Edit/Edit_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					Driver dr = new com.mysql.jdbc.Driver();
					DriverManager.registerDriver(dr);
					
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					java.sql.Connection con =  DriverManager.getConnection(url);
					String query = "select * from  pntnorms  where pntcast = '"+table.getValueAt(table.getSelectedRow(), 0)+"' ";
				    PreparedStatement	stmt = con.prepareStatement(query);
				     ResultSet rs= stmt.executeQuery();
				    
				     
					while(rs.next()) {
				     	 pdate =rs.getString("pntcast");
						 challanno =rs.getString("pnt");
						 storename =rs.getString("thinner");
						
						 vehicleno = rs.getString("pntnorms");
						 eway = rs.getString("thinnernorms");
				      
											
					}
					
					
					
					
					
			    	comboBox.setSelectedItem(challanno);
			    	comboBox_1.setSelectedItem(storename);
			    	comboBox_2.setSelectedItem(pdate);
			    	textField_2.setText(vehicleno);
			    	textField_5.setText(eway);
			    	
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
		
		JMenuItem mntmUpdate = new JMenuItem("UpDate");
		mntmUpdate.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Upload/Upload_24x24.png")));
		mntmUpdate.addActionListener(new ActionListener() {
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
				
				
				DateFormat df = new SimpleDateFormat("YYYY-M-dd");
				  String query = "update pntnorms set pntcast='"+comboBox_2.getSelectedItem().toString()+"',pnt = '"+comboBox.getSelectedItem().toString()
				     +"',thinner ='"+comboBox_1.getSelectedItem().toString()+"',pntnorms='"+textField_2.getText()+"',thinnernorms='"+textField_5.getText()
				    		 +"' where pntcast='"+id+"'";
					      stmt.execute(query);
					    
						JOptionPane.showMessageDialog(null, "data updated");
						
					
						
						} catch (Exception e1) { 
							JOptionPane.showMessageDialog(null, e1.toString());
							System.out.println(e1);
						}
			}
		});
		mntmUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		mntmUpdate.setBackground(new Color(102, 51, 51));
		mntmUpdate.setForeground(Color.WHITE);
		toolBar.add(mntmUpdate);
		
		JMenuItem menuItem_2 = new JMenuItem("Clear");
		menuItem_2.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedItem(null);
		    	comboBox_1.setSelectedItem(null);
		    	comboBox_2.setSelectedItem(null);
		    	textField_2.setText(null);
		    	textField_5.setText(null);
			}
		});
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Delete");
		menuItem_3.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Delete/Delete_24x24.png")));
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index  = table.getSelectedRow() ;
				String id  = table.getValueAt(index, 0).toString();
				
				try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "delete from pntnorms where pntcast='"+id+"'";
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
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_3.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Exit");
		menuItem_4.setIcon(new ImageIcon(PaintNoms.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_4.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_4.setForeground(Color.WHITE);
		menuItem_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar.add(menuItem_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 227, 512, 132);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata2());
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(102, 51, 51));
		panel_1.setBounds(0, 38, 532, 29);
		panel.add(panel_1);
		
		JLabel lblNorms = new JLabel("NORMS");
		lblNorms.setForeground(Color.WHITE);
		lblNorms.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNorms.setBackground(new Color(102, 51, 51));
		lblNorms.setBounds(10, 11, 117, 16);
		panel_1.add(lblNorms);
		
		
		comboBox.setBounds(130, 106, 218, 20);
		panel.add(comboBox);
		comboBox.addItem("RED OXIDE");
		comboBox.addItem("DOWN GLOW");
		comboBox.addItem("TAFE CHARCOAL GREY PAINT");
		comboBox.addItem("APPG");
		comboBox.addItem("KOEL GREEN PAINT");
		comboBox.addItem("QD SELAR BLACK");
		comboBox.addItem("ZINCHROMITE");
		comboBox.addItem("STEEL GREY");
		comboBox.addItem("BLUE PAINT");
		comboBox.addItem("LIGHT GREEN PAINT");
		comboBox.addItem("APOXY GREY");
		comboBox.addItem("M&M CH GREY-KNP");
		
	//	JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(130, 135, 218, 20);
		panel.add(comboBox_1);
		comboBox_1.addItem("QD THINNER");
		comboBox_1.addItem("TAFE THINNER");
		comboBox_1.addItem("NC THINNER");
		comboBox_1.addItem("KOEL THINNER");
		comboBox_1.addItem("APOXY THINNER");
		comboBox_1.addItem("M&M CH GREY THINNER-KNP");
		
		
		comboBox_2.setBounds(130, 75, 218, 20);
		
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
				comboBox_2.addItem(partname);
			//	System.out.println(partname);
				 
			//	String vechileNumber = rs.getString("vechilenumber");
			//	comboBox_1.addItem(vechileNumber);
			}
			

			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		panel.add(comboBox_2);
		
		
	}
}
