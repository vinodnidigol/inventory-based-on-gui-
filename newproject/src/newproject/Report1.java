package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

public class Report1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report1 frame = new Report1();
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
	public Report1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, "name_281807494050318");
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_427566592090984");
		
		JLabel label = new JLabel("Select Date From");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JLabel label_1 = new JLabel("To");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JDateChooser dateChooser_1 = new JDateChooser();
		
		JButton button = new JButton("OK");
		
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(11))
		);
		panel.setLayout(gl_panel);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection	con = null;
				try {
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					InputStream in = new FileInputStream("C:\\Users\\vinod\\Desktop\\New folder (2)\\newproject\\src\\Report1_A4_Landscape.jrxml");
					JasperDesign jd = JRXmlLoader.load(in);
					String sql ="select parttype.* , deliverychallan.* from parttype,deliverychallan ";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
					JasperViewer.viewReport(j,false);
				//	JRViewer jj = new JRViewer(j);
//					panel_2.removeAll();
//					panel_2.setLayout(new BorderLayout());
//					panel_2.repaint();
//					panel_2.add(new JRViewer(j));
//					panel_2.revalidate();
					
					con.close();
				
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		
		
		
	}
}
