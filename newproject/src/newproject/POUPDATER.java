package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class POUPDATER extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POUPDATER frame = new POUPDATER();
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
	DefaultTableModel getdata() {
		 
		 df.addColumn("PO Number");
		 df.addColumn("PO Date");
		 df.addColumn("HSN Code");
		 df.addColumn("SAC Code");
		
		 
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			String sql = "select * from  poupdater;";
			
			
			try {
				
				Connection conn = (Connection) DriverManager.getConnection(url);
				Statement st = (Statement) conn.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next()) {
					String a = rs.getString("ponumber");
					String b = rs.getString("podate");
					String c = rs.getString("hsncode");
					String d = rs.getString("saccode");
					
					
					
					String [] rowdata = {a,b,c,d};
				
					df.addRow(rowdata);
			
					
					
				}
				} catch (Exception e) {
					// TODO: handle exception
				}
		return df; 
	 }
	
	public POUPDATER() {
		setTitle("PO Updater");
		setIconImage(Toolkit.getDefaultToolkit().getImage(POUPDATER.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_61996410136569");
		
		JLabel lblPo = new JLabel("PO Number :");
		lblPo.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPoDate = new JLabel("PO Date :");
		lblPoDate.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JLabel lblHsnCode = new JLabel("HSN Code :");
		lblHsnCode.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("Button.background"));
		
		
		JLabel lblSacCode = new JLabel("SAC Code :");
		lblSacCode.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setIcon(new ImageIcon(POUPDATER.class.getResource("/must_have_icon_set/Save/Save_24x24.png")));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Driver dr;
				try {
					dr = new com.mysql.jdbc.Driver();
				
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			String query ;
			query = "update poupdater set ponumber ='"+textField.getText()+"'";
		    stmt.execute(query);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				try {
					dr = new com.mysql.jdbc.Driver();
				
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			
			String query ;
			query = "update poupdater set podate ='"+df.format(dateChooser.getDate())+"'";
		    stmt.execute(query);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					dr = new com.mysql.jdbc.Driver();
				
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			String query ;
			query = "update poupdater set hsncode ='"+textField_2.getText()+"'";
		    stmt.execute(query);
				}catch (Exception e) {
					// TODO: handle exception
				}
			
				try {
					dr = new com.mysql.jdbc.Driver();
				
				DriverManager.registerDriver(dr);
				
				String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
				java.sql.Connection con =  DriverManager.getConnection(url);
				
			java.sql.Statement	stmt = con.createStatement();
			
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			String query ;
			query = "update poupdater set saccode ='"+textField_3.getText()+"'";
		    stmt.execute(query);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		mntmSave.setForeground(Color.WHITE);
		mntmSave.setBackground(new Color(102, 51, 51));
		mntmSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmSave);
		
		JMenuItem mntmCancel = new JMenuItem("Cancel");
		mntmCancel.setIcon(new ImageIcon(POUPDATER.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(POUPDATER.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		mntmExit.setForeground(Color.WHITE);
		mntmExit.setBackground(new Color(102, 51, 51));
		mntmExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(mntmExit);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		df = (DefaultTableModel) table.getModel();
		df.setRowCount(0);
		df.setColumnCount(0);
		table.setModel(getdata());
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 51, 51));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 51, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPo)
					.addGap(10)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblHsnCode, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblPoDate)
					.addGap(31)
					.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblSacCode)
					.addGap(4)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPo)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHsnCode)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPoDate)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSacCode)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addGap(6))
		);
		panel_2.setLayout(null);
		
		JLabel lblPoupdate = new JLabel("P.O.Update");
		lblPoupdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPoupdate.setForeground(Color.WHITE);
		lblPoupdate.setBackground(new Color(102, 51, 51));
		lblPoupdate.setBounds(10, 0, 160, 23);
		panel_2.add(lblPoupdate);
		panel_1.setLayout(null);
		
		JLabel lblViewInformation = new JLabel("View Information");
		lblViewInformation.setBounds(10, 0, 322, 24);
		lblViewInformation.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblViewInformation.setForeground(Color.WHITE);
		lblViewInformation.setBackground(new Color(102, 51, 51));
		panel_1.add(lblViewInformation);
		panel.setLayout(gl_panel);
	}
}
