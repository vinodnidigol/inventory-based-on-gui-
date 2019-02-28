package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import junit.extensions.ActiveTestSuite;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DayBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private final JPanel panel_1 = new JPanel();

	/**
	 * Launch the application.
	 */
	String s1 ;
	String s2 ;
	String s3 ;
	String s4 ;
	String s5 ;
	String s6 ;
	String s7 ;
	String s8 ;
	String s9 ;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_7;

	JTextField textField;
	private JTextField textField_1;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_8;
	private JTextField textField_9;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayBill frame = new DayBill();
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
	public DayBill() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 433);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		JLabel lblTransporterName = new JLabel("TransPorter Name :");
		lblTransporterName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.WHITE);
		
		 JComboBox comboBox_4 = new JComboBox();
	        
	        JComboBox comboBox_5 = new JComboBox();
	        
		
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
				comboBox_4.addItem(transportername);
				System.out.println(transportername);
				 
				String vechileNumber = rs.getString("vechilenumber");
				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JLabel lblTruckNumber = new JLabel("Truck Number :");
		lblTruckNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	
		
		JLabel lblKfilDeliveryChallan = new JLabel("KFIL Delivery Challan No. and Date :");
		lblKfilDeliveryChallan.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblEwayBillNo = new JLabel("E-Way Bill No. :");
		lblEwayBillNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		 JDateChooser dateChooser = new JDateChooser();
        
        JLabel lblChallan = new JLabel("Challan :");
        lblChallan.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JDateChooser dateChooser_1 = new JDateChooser();
		
		
      
        
        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setBackground(Color.WHITE);
        comboBox_2.addItem("ORIGINAL FOR CONSIGNEE");
        comboBox_2.addItem("DUPLICATE FOR TRANSPORTER");
        comboBox_2.addItem("TRIPLICATE FOR ASSESSEE");
        
        
 JComboBox comboBox_3 = new JComboBox();
        
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
				comboBox_3.addItem(partname);
				System.out.println(partname);
				 
			//	String vechileNumber = rs.getString("vechilenumber");
			//	comboBox_1.addItem(vechileNumber);
			}
			

			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}

        JCheckBox checkBox = new JCheckBox("FET");
        checkBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField.setEnabled(false);
        		if(checkBox.isSelected()) {
        			textField.setEnabled(true);
        		}
        	}
        });
        checkBox.setForeground(Color.DARK_GRAY);
        checkBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox.setBackground(new Color(204, 204, 255));
        
        textField = new JTextField();
        textField.setEnabled(false);
        textField.setColumns(10);
        
        JCheckBox checkBox_1 = new JCheckBox("RSB");
        checkBox_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_1.setEnabled(false);
        		if(checkBox_1.isSelected()) {
        			textField_1.setEnabled(true);
        		}
        	}
        });
        checkBox_1.setForeground(Color.DARK_GRAY);
        checkBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_1.setBackground(new Color(204, 204, 255));
        
        textField_1 = new JTextField();
        textField_1.setEnabled(false);
        textField_1.setColumns(10);
        
        JCheckBox checkBox_2 = new JCheckBox("PNT");
        checkBox_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_15.setEnabled(false);
        		if(checkBox_2.isSelected()) {
        			textField_15.setEnabled(true);
        		}
        	}
        });
        checkBox_2.setForeground(Color.DARK_GRAY);
        checkBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_2.setBackground(new Color(204, 204, 255));
        
        textField_15 = new JTextField();
        textField_15.setEnabled(false);
        textField_15.setColumns(10);
        
        JCheckBox checkBox_3 = new JCheckBox("AVG");
        checkBox_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_16.setEnabled(false);
        		if(checkBox_3.isSelected()) {
        			textField_16.setEnabled(true);
        		}
        	}
        });
        checkBox_3.setForeground(Color.DARK_GRAY);
        checkBox_3.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_3.setBackground(new Color(204, 204, 255));
        
        textField_16 = new JTextField();
        textField_16.setEnabled(false);
        textField_16.setColumns(10);
        
        JCheckBox checkBox_4 = new JCheckBox("JOLT");
        checkBox_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_17.setEnabled(false);
        		if(checkBox_4.isSelected()) {
        			textField_17.setEnabled(true);
        		}
        	}
        });
        checkBox_4.setForeground(Color.DARK_GRAY);
        checkBox_4.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_4.setBackground(new Color(204, 204, 255));
        
        textField_17 = new JTextField();
        textField_17.setEnabled(false);
        textField_17.setColumns(10);
        
        JCheckBox checkBox_5 = new JCheckBox("DC/WJ");
        checkBox_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_18.setEnabled(false);
        		if(checkBox_5.isSelected()) {
        			textField_18.setEnabled(true);
        		}
        	}
        });
        checkBox_5.setForeground(Color.DARK_GRAY);
        checkBox_5.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_5.setBackground(new Color(204, 204, 255));
        
        textField_18 = new JTextField();
        textField_18.setEnabled(false);
        textField_18.setColumns(10);
        
        JCheckBox checkBox_6 = new JCheckBox("R/W");
        checkBox_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_19.setEnabled(false);
        		if(checkBox_6.isSelected()) {
        			textField_19.setEnabled(true);
        		}
        	}
        });
        checkBox_6.setForeground(Color.DARK_GRAY);
        checkBox_6.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_6.setBackground(new Color(204, 204, 255));
        
        textField_19 = new JTextField();
        textField_19.setEnabled(false);
        textField_19.setColumns(10);
        
        JCheckBox checkBox_7 = new JCheckBox("PSB");
        checkBox_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		textField_20.setEnabled(false);
        		if(checkBox_7.isSelected()) {
        			textField_20.setEnabled(true);
        		}
        	}
        });
        checkBox_7.setForeground(Color.DARK_GRAY);
        checkBox_7.setFont(new Font("Tahoma", Font.BOLD, 12));
        checkBox_7.setBackground(new Color(204, 204, 255));
        
        textField_20 = new JTextField();
        textField_20.setEnabled(false);
        textField_20.setColumns(10);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
      
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 204, 255));
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSubmit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		DayBill day1 = new DayBill();
        		day1.textField.getText();
        		
        		
        		if(checkBox.isSelected()) {
        	 s1=	textField.getText();
        	System.out.println(s1);
        	} else {
        		s1 = "0";
        		System.out.println(s1);
        	}
        		if(checkBox_1.isSelected()) {
               	 s2=	textField_1.getText();
               	System.out.println(s2);
               	} else {
               		s2 = "0";
               		System.out.println(s2);
               	}
        		if(checkBox_2.isSelected()) {
               	 s3=	textField_15.getText();
               	System.out.println(s3);
               	} else {
               		s3 = "0";
               		System.out.println(s3);
               	}
        		if(checkBox_3.isSelected()) {
               	 s4=	textField_16.getText();
               	System.out.println(s4);
               	} else {
               		s4 = "0";
               		System.out.println(s4);
               	}
        		if(checkBox_4.isSelected()) {
               	 s5=	textField_17.getText();
               	System.out.println(s5);
               	} else {
               		s5 = "0";
               		System.out.println(s5);
               	}
        		if(checkBox_5.isSelected()) {
               	 s6=	textField_18.getText();
               	System.out.println(s6);
               	} else {
               		s6 = "0";
               		System.out.println(s6);
               	}
        		if(checkBox_6.isSelected()) {
                  	 s7=	textField_19.getText();
                  	System.out.println(s7);
                  	} else {
                  		s7 = "0";
                  		System.out.println(s7);
                  	}
        		if(checkBox_7.isSelected()) {
                  	 s8=	textField_20.getText();
                  	System.out.println(s8);
                  	} else {
                  		s8 = "0";
                  		System.out.println(s8);
                  	}
//        		if(chckbxReject.isSelected()) {
//                  	 s9=	textField_4.getText();
//                  	System.out.println(s9);
//                  	} else {
//                  		s9 = "0";
//                  		System.out.println(s9);
//                  	}
        		s9 = "0";
//        		
    			DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        		try {
    				Driver dr = new com.mysql.jdbc.Driver();
    				DriverManager.registerDriver(dr);
    				
    				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
    				java.sql.Connection con = DriverManager.getConnection(url);
    				
    				  int exit = JOptionPane.showConfirmDialog(null, " Do You Want Print Report ","Print", JOptionPane.YES_NO_OPTION);
    					
    					if(exit ==0) {
    						
    						JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Blank_A4.jrxml");
    						String sql ="select * from poupdater";
    						JRDesignQuery q = new JRDesignQuery();
    						q.setText(sql);
    						jd.setQuery(q);
    						
    					
    						JasperReport jr = JasperCompileManager.compileReport(jd);
    						Map<String, Object>	params = new HashMap<String, Object>();
    						params.put("challanno", textField_7.getText());
    						params.put("challantype", comboBox_2.getSelectedItem().toString());
    						params.put("disdate", df.format(dateChooser.getDate()));
    						params.put("goodsname", comboBox_3.getSelectedItem().toString());
    						params.put("identi", textField_3.getText());
    						params.put("totalqty", textField_8.getText());
    						params.put("transporter", comboBox_4.getSelectedItem().toString());
    						params.put("vehicleno", comboBox_5.getSelectedItem().toString());
    						params.put("kfilno", textField_2.getText());
    						params.put("kfildate", df.format(dateChooser_1.getDate()));
    						params.put("eway", textField_4.getText());
    						
    						double d1 = Double.parseDouble(textField_9.getText());
    						params.put("taxablevalue", d1);
    						JasperPrint j = JasperFillManager.fillReport(jr,params,con);
    					//	JasperViewer.viewReport(j,false);
    						panel.removeAll();
    						panel.setLayout(new BorderLayout());
    						panel.repaint();
    						panel.add(new JRViewer(j));
    						panel.revalidate();
    					
    					}
    	  		
    	    			
    				
    			java.sql.Statement	stmt = con.createStatement();
    			
    			String query = "insert into deliverychallan values('"+textField_7.getText()+"','"+df.format(dateChooser.getDate())
    			+"','"+comboBox_3.getSelectedItem().toString()+"','"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"
    			+s6+"','"+s7+"','"+s8+"','"+s9+"','"+comboBox_5.getSelectedItem().toString()+"','"+textField_2.getText()+"','"
    			+df.format(dateChooser_1.getDate())+"','"+textField_4.getText()+"','"+comboBox_4.getSelectedItem().toString()+"','"+textField_8.getText()+"','"+textField_9.getText()+"')";
       
    			stmt.execute(query);
    			

              
        		} catch (Exception e) {
					System.out.println(e.toString());
				}
        		
               
				
        	}
        });
        
        JLabel lblDescriptionOfThe = new JLabel("Description Of The Goods :");
        lblDescriptionOfThe.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblIdentificationMarks = new JLabel("Identification Marks & Numbers, If Any :");
        lblIdentificationMarks.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        
       
        
        JLabel lblDate_1 = new JLabel("Date :");
        lblDate_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel_1.setBackground(new Color(204, 204, 255));
        
        JLabel lblQuantity = new JLabel("Quantity (Numbers/Weight/Litre) :\r\n");
        lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
        contentPane.setLayout(new CardLayout(0, 0));
        contentPane.add(panel_1, "name_261150904155258");
        
        JLabel lblTransporterName_1 = new JLabel("Transporter Name :");
        lblTransporterName_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblVehicleNumber = new JLabel("Vehicle Number :");
        lblVehicleNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblKfilDeliveryChallan_1 = new JLabel("KFIL Delivery Challan No. and Date :");
        lblKfilDeliveryChallan_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        
       
        JLabel lblEwayBillNo_1 = new JLabel("E-way Bill No. :");
        lblEwayBillNo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        
        JLabel lblDeliveryChallanNo = new JLabel("Delivery Challan No. :");
        
        textField_7 = new JTextField();
        textField_7.setColumns(10);
        
        textField_8 = new JTextField();
        textField_8.setColumns(10);
        
        JLabel lblNo = new JLabel("In Numbers");
        lblNo.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JLabel lblTaxableValue = new JLabel("Taxable Value :");
        lblTaxableValue.setFont(new Font("Tahoma", Font.BOLD, 12));
        
      
        
        JLabel lblInRupees = new JLabel("In Rupees");
        lblInRupees.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
        	}
        });
        
       
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGap(10)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(11)
        							.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(btnCancel)
        							.addGap(69)
        							.addComponent(lblChallan, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        							.addGap(10)
        							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblDeliveryChallanNo, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        							.addGap(14)
        							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
        							.addGap(33)
        							.addComponent(lblDate_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        							.addGap(9)
        							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblDescriptionOfThe)
        							.addGap(10)
        							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(246)
        							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblIdentificationMarks)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblNo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(69)
        							.addComponent(checkBox_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(checkBox_2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(checkBox_3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(checkBox_4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(checkBox_5)
        							.addGap(2)
        							.addComponent(checkBox_6, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(checkBox_7, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(3)
        							.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblTransporterName_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
        							.addGap(2)
        							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addComponent(lblVehicleNumber, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        								.addGroup(gl_panel_1.createSequentialGroup()
        									.addGap(221)
        									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
        								.addComponent(lblKfilDeliveryChallan_1, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
        							.addGap(10)
        							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblEwayBillNo_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(99)
        							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
        								.addComponent(textField_9, Alignment.LEADING)
        								.addComponent(textField_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lblInRupees))))
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblTaxableValue)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 11, Short.MAX_VALUE)
        			.addGap(0))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(11)
        			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        				.addGroup(gl_panel_1.createSequentialGroup()
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        							.addComponent(btnSubmit)
        							.addComponent(btnCancel))
        						.addComponent(lblChallan, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(6)
        							.addComponent(lblDeliveryChallanNo))
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(3)
        							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblDate_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(4)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblDescriptionOfThe, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(4)
        							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(10)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(1)
        							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblIdentificationMarks))
        					.addGap(5)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        					.addGap(1)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(checkBox_1)
        						.addComponent(checkBox_2)
        						.addComponent(checkBox_3)
        						.addComponent(checkBox_4)
        						.addComponent(checkBox_5)
        						.addComponent(checkBox_6)
        						.addComponent(checkBox_7))
        					.addGap(7)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblTransporterName_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(2)
        							.addComponent(lblVehicleNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(11)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblKfilDeliveryChallan_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        						.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        					.addGap(6)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_panel_1.createSequentialGroup()
        							.addGap(2)
        							.addComponent(lblEwayBillNo_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
        						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblTaxableValue)
        						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblInRupees))))
        			.addContainerGap())
        		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
        			.addContainerGap(159, Short.MAX_VALUE)
        			.addComponent(checkBox)
        			.addGap(202))
        );
        panel_1.setLayout(gl_panel_1);
        
       
        contentPane.add(lblTransporterName, "name_261150952542994");
        contentPane.add(comboBox, "name_261151000403083");
        contentPane.add(lblTruckNumber, "name_261151040269618");
        contentPane.add(comboBox_1, "name_261151083282442");
        contentPane.add(lblKfilDeliveryChallan, "name_261151119421855");
        contentPane.add(textField_5, "name_261151152064146");
        contentPane.add(lblEwayBillNo, "name_261151243165660");
        contentPane.add(textField_6, "name_261151283902743");
        contentPane.add(lblDate, "name_261151317088543");
        
      
		
	}
}

