 package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JSpinnerDateEditor;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
		setTitle("Reports");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Report.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_277505315439967");
		
		JLabel lblSelectDateFrom = new JLabel("Select Date From");
		lblSelectDateFrom.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JDateChooser dateChooser_1 = new JDateChooser();
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 135, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(new Color(102, 51, 51));
		toolBar.setBackground(UIManager.getColor("Button.background"));
		
		
		
		JPanel panel_19 = new JPanel();
		contentPane.add(panel_19, "name_1037076017513395");
		panel_19.setBackground(new Color(204, 204, 153));
		
		JLabel label_5 = new JLabel("");
		
		JLabel label_6 = new JLabel("Select Date From :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_16 = new JDateChooser();
		
		JLabel label_7 = new JLabel("TO ");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_17 = new JDateChooser();
		
		JToolBar toolBar_9 = new JToolBar();
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		
		JMenuItem menuItem_25 = new JMenuItem("Get Report");
		menuItem_25.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String Abc ="/Reports/Re_Landscape.jrxml"	;
				InputStream in = null ;
				try { 
			
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
	        		in =this.getClass().getResourceAsStream(Abc);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
			     //	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Re_Landscape.jrxml");
					JasperDesign jd = JRXmlLoader.load(in);
					
//				 


//					

					String sql = "select parttype.partname as itemname,"
							+ "(SELECT COALESCE(in1.qty ,0))as ReceivedStock ,"
							+ " (SELECT COALESCE(outs.outqty ,0)) as DispatchQty ,"
							+ "(SELECT COALESCE(num.nu1 ,0)) as NotProcessCha   ,"
							+ "(SELECT COALESCE(num.open , 0)) as opst,"
							+ "(SELECT COALESCE(thismonth.open1 , 0)) as opst1 , "
							+ "thismonth.thismon as monthcha "
							+ "from parttype  " + 
							
							"left join"
							
							+ " (select sum(inword.tqty) as qty,inword.itemnamein as name from inword"
							+ " where kfildate between '"+df1.format(dateChooser_16.getDate())+"' "
									+ "and '"+df1.format(dateChooser_17.getDate())+"' group by inword.itemnamein  )" + 
							" in1 on in1.name = parttype.partname" + 
							
							" left join "
							
							+ "(select sum(outword.totalqty) as outqty , outword.itemname as outs from outword"
							+ " where outdate between '"+df1.format(dateChooser_16.getDate())+"' "
									+ "and '"+df1.format(dateChooser_17.getDate())+"' group by outword.itemname ) " + 
							"outs on outs.outs = parttype.partname"
							
							+ " left join " +     
							
							"(select sum(inword.tqty) as open , group_concat(inword.kfilchano) as nu1  ,inword.itemnamein as na1 "
							+ "from inword where kfildate between " + 
							"date_sub('"+df1.format(dateChooser_16.getDate())+"', INTERVAL  4 MONTH)" + 
							" and date_sub('"+df1.format(dateChooser_17.getDate())+"' , INTERVAL 1 MONTH) and inword.kfilchano not in (select outword.inwordno from outword) group by inword.itemnamein ) " + 
							"num on num.na1 =parttype.partname "
							
							+ " left join "
							
							+ "(select sum(inword.tqty) as open1 , group_concat(inword.kfilchano) as thismon,"
							+ "inword.itemnamein as thisname from inword where kfildate between "
							+ "date_sub('"+df1.format(dateChooser_16.getDate())+"' , INTERVAL  4 MONTH) and '"+df1.format(dateChooser_17.getDate())+"' "
							+ "and inword.kfilchano not in (select outword.inwordno from outword) group by inword.itemnamein)"
							+ " thismonth on thismonth.thisname= parttype.partname"
							 ;
					
					
					
//					String sql ="select  inword.* , outword.* from inword,outword where (kfildate>='"+df1.format(dateChooser_16.getDate())+"' and kfildate<='"+df1.format(dateChooser_17.getDate())+"') and (outdate>='" + 
//												df1.format(dateChooser_16.getDate())+ 
//												"' and outdate<='"+df1.format(dateChooser_17.getDate())+"') and kfilchano != inwordno and itemnamein = itemname order by itemnamein";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_18.removeAll();
					panel_18.setLayout(new BorderLayout());
					panel_18.repaint();
					panel_18.add(new JRViewer(j));
					panel_18.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		menuItem_25.setForeground(Color.WHITE);
		menuItem_25.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_25.setBackground(new Color(102, 51, 51));
		toolBar_9.add(menuItem_25);
		
		JMenuItem menuItem_26 = new JMenuItem("Cancel");
		menuItem_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_26.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_26.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_26.setForeground(Color.WHITE);
		menuItem_26.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_26.setBackground(new Color(102, 51, 51));
		toolBar_9.add(menuItem_26);
		
		JMenuItem menuItem_27 = new JMenuItem("Exit");
		menuItem_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_27.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_27.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_27.setForeground(Color.WHITE);
		menuItem_27.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_27.setBackground(new Color(102, 51, 51));
		toolBar_9.add(menuItem_27);
		GroupLayout gl_panel_19 = new GroupLayout(panel_19);
		gl_panel_19.setHorizontalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addComponent(label_5)
				.addComponent(toolBar_9, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser_16, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_17, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(panel_18, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(6))
		);
		gl_panel_19.setVerticalGroup(
			gl_panel_19.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_19.createSequentialGroup()
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addComponent(label_5)
						.addComponent(toolBar_9, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_19.createSequentialGroup()
							.addGap(17)
							.addComponent(label_6, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(dateChooser_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addGroup(gl_panel_19.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_19.createSequentialGroup()
									.addGap(19)
									.addComponent(dateChooser_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_18, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
					.addGap(6))
		);
		panel_19.setLayout(gl_panel_19);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_1, "name_218719842074422");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_4, "name_83232596173880");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_8, "name_360178461494885");
		
		
		JMenuItem mntmPartList = new JMenuItem("Get Report");
		mntmPartList.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmPartList.setForeground(Color.WHITE);
		mntmPartList.setBackground(new Color(102, 51, 51));
		mntmPartList.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmPartList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection	con = null;
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String Abc ="/Reports/Report_A4_Landscape.jrxml";
			//	InputStream in1 = null ;
				try { 
					
				
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					InputStream in1 =this.getClass().getResourceAsStream(Abc);
			//		InputStream in = new FileInputStream("//src//Report_A4_Landscape.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Report_A4_Landscape.jrxml");
			     	JasperDesign jd = JRXmlLoader.load(in1);
					String sql ="select * from outword  where (outdate>='"+df.format(dateChooser.getDate())+"' and outdate<='"+df.format(dateChooser_1.getDate())+"') order by itemname,"
							+ " outdate ";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					System.out.println(df.format(dateChooser.getDate()));
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					params.put("DATE", dateChooser.getDate());
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
					
					panel_2.removeAll();
					panel_2.setLayout(new BorderLayout());
					panel_2.repaint();
					panel_2.add(new JRViewer(j));
					panel_2.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_6, "name_130399658707878");
		
		JMenuBar menuBar_1 = new JMenuBar();
		toolBar.add(menuBar_1);
		
		JMenu mnReports_1 = new JMenu("Reports");
		menuBar_1.add(mnReports_1);
		
		JMenuItem mntmPartWiseList = new JMenuItem("Part Wise List");
		mntmPartWiseList.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmPartWiseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmPartWiseList);
		
		JSeparator separator_7 = new JSeparator();
		mnReports_1.add(separator_7);
		
		JMenuItem mntmTonnageWise_1 = new JMenuItem("Tonnage Wise ");
		mntmTonnageWise_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmTonnageWise_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				contentPane.add(panel_4);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmTonnageWise_1);
		
		JSeparator separator_8 = new JSeparator();
		mnReports_1.add(separator_8);
		
		JMenuItem mntmProcessWiseList_1 = new JMenuItem("Process Wise List");
		mntmProcessWiseList_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmProcessWiseList_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				contentPane.add(panel_1);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		
		JMenuItem mntmInwordTonnage = new JMenuItem("Inword tonnage");
		mntmInwordTonnage.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmInwordTonnage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_8);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmInwordTonnage);
		
		JSeparator separator_28 = new JSeparator();
		mnReports_1.add(separator_28);
		mnReports_1.add(mntmProcessWiseList_1);
		
		JSeparator separator_10 = new JSeparator();
		mnReports_1.add(separator_10);
		
		JMenuItem mntmGstinBill_1 = new JMenuItem("GSTIN Bill");
		mntmGstinBill_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmGstinBill_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_6);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		mnReports_1.add(mntmGstinBill_1);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_12, "name_165145205020174");
		
		JMenuItem mntmItemPurchaseDetails = new JMenuItem("item Purchase Details");
		mntmItemPurchaseDetails.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmItemPurchaseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_12);
				contentPane.repaint();
				contentPane.revalidate();
				
			}
		});
		
		JSeparator separator_29 = new JSeparator();
		mnReports_1.add(separator_29);
		mnReports_1.add(mntmItemPurchaseDetails);
		
		JSeparator separator_30 = new JSeparator();
		mnReports_1.add(separator_30);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_14, "name_213219049590014");
		
		JMenuItem mntmConsumptionByEmployee = new JMenuItem("Consumption By Employee");
		mntmConsumptionByEmployee.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmConsumptionByEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_14);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmConsumptionByEmployee);
		
		JSeparator separator_11 = new JSeparator();
		mnReports_1.add(separator_11);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_16, "name_231557768245797");
		
		
		JMenuItem mntmDayWiseConsumption = new JMenuItem("Day Wise Consumption");
		mntmDayWiseConsumption.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmDayWiseConsumption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_16);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmDayWiseConsumption);
		
		JSeparator separator_32 = new JSeparator();
		mnReports_1.add(separator_32);
		
		JMenuItem mntmStockReport = new JMenuItem("Stock Report");
		mntmStockReport.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmStockReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(panel_19);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmStockReport);
		
		JSeparator separator_31 = new JSeparator();
		mnReports_1.add(separator_31);
		
		JMenuItem mntmCancel_2 = new JMenuItem("Cancel");
		mntmCancel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m1 = new Main();
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				m1.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel_20 = new JPanel();
		JMenuItem mntmPaintedQuantity = new JMenuItem("Painted Quantity");
		mntmPaintedQuantity.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmPaintedQuantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_20);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmPaintedQuantity);
		
		JSeparator separator_1 = new JSeparator();
		mnReports_1.add(separator_1);
		
		JPanel panel_22 = new JPanel();
		
		JMenuItem mntmPaintReconcillation = new JMenuItem("Paint Reconcillation");
		mntmPaintReconcillation.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmPaintReconcillation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_22);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmPaintReconcillation);
		
		JSeparator separator_2 = new JSeparator();
		mnReports_1.add(separator_2);
		
		JPanel panel_24 = new JPanel();
		
		JMenuItem mntmNotProcessingItems = new JMenuItem("Not Processing Items");
		mntmNotProcessingItems.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmNotProcessingItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel_24);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnReports_1.add(mntmNotProcessingItems);
		
		JSeparator separator = new JSeparator();
		mnReports_1.add(separator);
		mntmCancel_2.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_16x16.png")));
		mnReports_1.add(mntmCancel_2);
		
		JSeparator separator_12 = new JSeparator();
		mnReports_1.add(separator_12);
		
		JMenuItem mntmClose = new JMenuItem("Close ");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m1 = new Main();
				m1.setVisible(true);
				m1.setExtendedState(m1.MAXIMIZED_BOTH);
				dispose();
			}
		});
		mntmClose.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Stop/Stop_16x16.png")));
		mnReports_1.add(mntmClose);
		
		JSeparator separator_13 = new JSeparator();
		mnReports_1.add(separator_13);
		
		JMenuItem mntmExit_2 = new JMenuItem("Exit");
		mntmExit_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		mntmExit_2.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_16x16.png")));
		mnReports_1.add(mntmExit_2);
		toolBar.add(mntmPartList);
		
		JMenuItem mntmCancel = new JMenuItem("Cancel");
		mntmCancel.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main m1 = new Main();
			m1.setExtendedState(m1.MAXIMIZED_BOTH);
			m1.setVisible(true);
			dispose();
			}
		});
		mntmCancel.setForeground(Color.WHITE);
		mntmCancel.setBackground(new Color(102, 51, 51));
		mntmCancel.setFont(new Font("Arial Black", Font.BOLD, 14));
		toolBar.add(mntmCancel);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
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
		mntmExit.setFont(new Font("Arial Black", Font.PLAIN, 14));
		toolBar.add(mntmExit);
		
		JLabel label_2 = new JLabel("Vk32 Product");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
								.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblSelectDateFrom, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(73)
							.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(toolBar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(72)
							.addComponent(lblSelectDateFrom)
							.addGap(11)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.addItem("details wise");
		comboBox.addItem("Total wise");
		
		JLabel label = new JLabel("Select Date From");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JDateChooser dateChooser_2 = new JDateChooser();
		
		JLabel label_1 = new JLabel("To");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JDateChooser dateChooser_3 = new JDateChooser();
		
		JToolBar toolBar_2 = new JToolBar();
		toolBar_2.setRollover(true);
		toolBar_2.setBackground(UIManager.getColor("Button.background"));
		
		JLabel lblVkProducts = new JLabel("Vk32 Product");
		lblVkProducts.setIcon(new ImageIcon("E:\\cad\\mxpHQ6bg123.png"));
		
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(dateChooser_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblVkProducts)
									.addGap(10))
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(dateChooser_2, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(61)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(toolBar_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(toolBar_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(76)
							.addComponent(lblVkProducts, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
							.addGap(11)))
					.addGap(0))
		);
		
		JMenuItem mntmGetReport = new JMenuItem("Get Report");
		mntmGetReport.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmGetReport.setHorizontalAlignment(SwingConstants.LEFT);
		mntmGetReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if(comboBox.getSelectedItem().equals("details wise")) {
					Connection	con = null;
					String a1 = "/Reports/panel2_1.jrxml";
					InputStream in = null ;
					try { 
						
					//	Driver dr = new com.mysql.jdbc.Driver();
					//	DriverManager.registerDriver(dr);
						
						Class.forName("com.mysql.jdbc.Driver");			
						String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
						con = DriverManager.getConnection(url); 
						in = this.getClass().getResourceAsStream(a1);
						JasperDesign jd = JRXmlLoader.load(in);
			//			InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\panel2_1.jrxml");
					//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/panel2_1.jrxml");
						String sql ="select parttype.* , outword.* from parttype,outword where (outdate>='"
						+df.format(dateChooser_2.getDate())+"' and outdate<='"+df.format(dateChooser_3.getDate())+"') and partname = itemname order by partname ";
						JRDesignQuery q = new JRDesignQuery();
						q.setText(sql);
						jd.setQuery(q);
						
					
						JasperReport jr = JasperCompileManager.compileReport(jd);
						Map<String, Object>	params = new HashMap<String, Object>();
						params.put("DATE", dateChooser_2.getDate());
						JasperPrint j = JasperFillManager.fillReport(jr,params,con);
					//	JasperViewer.viewReport(j,false);
//						
						panel_3.removeAll();
						panel_3.setLayout(new BorderLayout());
						panel_3.repaint();
						panel_3.add(new JRViewer(j));
						panel_3.revalidate();
						
						
						con.close();
					
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					}
					if(comboBox.getSelectedItem().equals("Total wise")) {
						
						Connection	con = null;
						String a1 = "/Reports/Totalwise_A4.jrxml" ;
						InputStream in = null ;
						
						try { 
							
						//	Driver dr = new com.mysql.jdbc.Driver();
						//	DriverManager.registerDriver(dr);
							
							Class.forName("com.mysql.jdbc.Driver");			
							String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
						
							con = DriverManager.getConnection(url); 
							in = this.getClass().getResourceAsStream(a1);
							JasperDesign jd = JRXmlLoader.load(in);
						//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Totalwise_A4.jrxml");
						//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Totalwise_A4.jrxml");
							String sql ="select parttype.* , outword.* from parttype,outword where (outdate>='"+df.format(dateChooser_2.getDate())+"' and outdate<='"+df.format(dateChooser_3.getDate())+"') and partname = itemname";
							JRDesignQuery q = new JRDesignQuery();
							q.setText(sql);
							jd.setQuery(q);
							
						
							JasperReport jr = JasperCompileManager.compileReport(jd);
							Map<String, Object>	params = new HashMap<String, Object>();
							params.put("month", dateChooser_2.getDate()) ;
							JasperPrint j = JasperFillManager.fillReport(jr,params,con);
						//	JasperViewer.viewReport(j,false);
//							
							panel_3.removeAll();
							panel_3.setLayout(new BorderLayout());
							panel_3.repaint();
							panel_3.add(new JRViewer(j));
							panel_3.revalidate();
							
							
							con.close();
						
						} catch (Exception e) {
							System.out.println(e.toString());
						}
					}
			}
		});
		mntmGetReport.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmGetReport.setBackground(new Color(102, 51, 51));
		mntmGetReport.setForeground(Color.WHITE);
		toolBar_2.add(mntmGetReport);
		
		JMenuItem menuItem_2 = new JMenuItem("Cancel");
		menuItem_2.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_2.setForeground(Color.WHITE);
		menuItem_2.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_2.setBackground(new Color(102, 51, 51));
		toolBar_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Exit");
		menuItem_3.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_3.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
        int exit = JOptionPane.showConfirmDialog(null, "Really Do You  Want Exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_3.setForeground(Color.WHITE);
		menuItem_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		menuItem_3.setBackground(new Color(102, 51, 51));
		toolBar_2.add(menuItem_3);
		panel_1.setLayout(gl_panel_1);
		
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setBackground(UIManager.getColor("Button.background"));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		
		JDateChooser dateChooser_5 = new JDateChooser();
		
		JMenuItem mntmOk = new JMenuItem("Get Report");
		mntmOk.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmOk.setHorizontalAlignment(SwingConstants.LEFT);
		mntmOk.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmOk.setForeground(Color.WHITE);
		mntmOk.setBackground(new Color(102, 51, 51));
		mntmOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 ="/Reports/Tonnege_A4.jrxml" ;
				InputStream in = null ;
				
				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.regis0terDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd =JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Tonnege_A4.jrxml");
					String sql ="select parttype.* , outword.* from parttype,outword where (outdate>='"+df.format(dateChooser_4.getDate())+"' and outdate<='"+df.format(dateChooser_5.getDate())+"')"
							+ " and partname = itemname order by outdate";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_5.removeAll();
					panel_5.setLayout(new BorderLayout());
					panel_5.repaint();
					panel_5.add(new JRViewer(j));
					panel_5.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		toolBar_1.add(mntmOk);
		
		JLabel lblSelectDateFrom_1 = new JLabel("Select date From :");
		lblSelectDateFrom_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JLabel lblTo_1 = new JLabel("To :");
		lblTo_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser_4, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(43)
							.addComponent(lblTo_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(dateChooser_5, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectDateFrom_1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
					.addGap(10))
				.addComponent(toolBar_1, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(toolBar_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(47)
							.addComponent(lblSelectDateFrom_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooser_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lblTo_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(dateChooser_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
					.addGap(11))
		);
		
		
		JMenuItem mntmCancel_4 = new JMenuItem("Cancel");
		mntmCancel_4.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		mntmCancel_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmCancel_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmCancel_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmCancel_4.setForeground(Color.WHITE);
		mntmCancel_4.setBackground(new Color(102, 51, 51));
		toolBar_1.add(mntmCancel_4);
		
		JMenuItem mntmExit_4 = new JMenuItem("Exit");
		mntmExit_4.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		mntmExit_4.setHorizontalAlignment(SwingConstants.LEFT);
		mntmExit_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		mntmExit_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmExit_4.setForeground(Color.WHITE);
		mntmExit_4.setBackground(new Color(102, 51, 51));
		toolBar_1.add(mntmExit_4);
		panel_4.setLayout(gl_panel_4);
		
		
		
		JLabel lblInvoiceNo = new JLabel("Invoice No. :");
		lblInvoiceNo.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JDateChooser dateChooser_6 = new JDateChooser();
		
		JLabel lblHsnsacCode = new JLabel("HSN/SAC Code :");
		lblHsnsacCode.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JComboBox comboBox_1 = new JComboBox();
		
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from poupdater";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String partname =rs.getString("hsncode");
				String partname1 =rs.getString("saccode");
				
				
				comboBox_1.addItem(partname);
				comboBox_1.addItem(partname1);
				
				//System.out.println(hsncode);
				 
			//	String vechileNumber = rs.getString("vechilenumber");
			//	comboBox_1.addItem(vechileNumber);
			}
			

			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		
		JToolBar toolBar_3 = new JToolBar();
		toolBar_3.setBackground(UIManager.getColor("Button.background"));
		
		JLabel label_3 = new JLabel("");
		
		JLabel lblSelectDateFrom_2 = new JLabel("Select Date From :");
		lblSelectDateFrom_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JDateChooser dateChooser_7 = new JDateChooser();
		
		JLabel lblTo_2 = new JLabel("To :");
		lblTo_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		
		JDateChooser dateChooser_8 = new JDateChooser();
		
		JLabel lblLodingAndUnloading = new JLabel("Loding And Unloading Charges :");
		lblLodingAndUnloading.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty :");
		lblQty.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblRateper = new JLabel("Rate /Per :");
		lblRateper.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JMenuItem mntmGetBill = new JMenuItem("Get Bill");
		mntmGetBill.setHorizontalAlignment(SwingConstants.LEFT);
		mntmGetBill.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmGetBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				Connection	con = null;
				String a1  = "/Reports/mont.jrxml" ;
				InputStream in = null ;
				
				try { 
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
				    in  = this.getClass().getResourceAsStream(a1);
			     	JasperDesign jd  = JRXmlLoader.load(in);
		//			InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\panel2_1.jrxml");
			//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/mont.jrxml");
					String sql ="select parttype.*  , outword.* , poupdater.* from parttype, outword,poupdater"
							+ " where(outdate>='"+df.format(dateChooser_7.getDate())+"' and outdate<='"+df.format(dateChooser_8.getDate())+"') and  partname = itemname";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					
					params.put("invoiceno", textField.getText());
					System.out.println(textField.getText());
					DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
      				params.put("printdate",df1.format( dateChooser_6.getDate()));
					params.put("hsn", comboBox_1.getSelectedItem().toString());
					params.put("Qty", Double.parseDouble(textField_1.getText()));	
					params.put("Rate",Double.parseDouble(textField_2.getText()));
					
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_7.removeAll();
					panel_7.setLayout(new BorderLayout());
					panel_7.repaint();
					panel_7.add(new JRViewer(j));
					panel_7.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		mntmGetBill.setForeground(Color.WHITE);
		mntmGetBill.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmGetBill.setBackground(new Color(102, 51, 51));
		toolBar_3.add(mntmGetBill);
		
		JMenuItem menuItem_11 = new JMenuItem("Cancel");
		menuItem_11.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_11.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_11.setForeground(Color.WHITE);
		menuItem_11.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_11.setBackground(new Color(102, 51, 51));
		toolBar_3.add(menuItem_11);
		
		JMenuItem menuItem_12 = new JMenuItem("Exit");
		menuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_12.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_12.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_12.setForeground(Color.WHITE);
		menuItem_12.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_12.setBackground(new Color(102, 51, 51));
		toolBar_3.add(menuItem_12);
		panel_7.setLayout(null);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(lblHsnsacCode)
							.addGap(4)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(8)
							.addComponent(lblSelectDateFrom_2))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(label_3)
							.addGap(10)
							.addComponent(dateChooser_7, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTo_2))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(10)
							.addComponent(dateChooser_8, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(10)
							.addComponent(lblLodingAndUnloading, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(10)
							.addComponent(lblQty, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(10)
							.addComponent(lblRateper)
							.addGap(10)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(lblInvoiceNo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addComponent(lblDate)
							.addGap(4)
							.addComponent(dateChooser_6, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addGap(10))
				.addComponent(toolBar_3, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(toolBar_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInvoiceNo)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGap(2)
									.addComponent(lblDate))
								.addComponent(dateChooser_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(lblHsnsacCode)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblSelectDateFrom_2)
							.addGap(6)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGap(11)
									.addComponent(label_3))
								.addComponent(dateChooser_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addComponent(lblTo_2)
							.addGap(6)
							.addComponent(dateChooser_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLodingAndUnloading, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGap(4)
									.addComponent(lblQty, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGap(3)
									.addComponent(lblRateper))
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
					.addGap(11))
		);
		panel_6.setLayout(gl_panel_6);
		
		
		
		JToolBar toolBar_4 = new JToolBar();
		

		JScrollPane scrollPane = new JScrollPane();
		
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel_9);
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 311, Short.MAX_VALUE)
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGap(0, 216, Short.MAX_VALUE)
		);
		panel_9.setLayout(gl_panel_9);
		
		JDateChooser dateChooser_9 = new JDateChooser();
		
		JDateChooser dateChooser_10 = new JDateChooser();
		
		JLabel lblSelectDateFrom_3 = new JLabel("Select Date from :");
		lblSelectDateFrom_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JLabel lblTo_3 = new JLabel("TO :");
		lblTo_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_4, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTo_3, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_9, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
						.addComponent(dateChooser_10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblSelectDateFrom_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(toolBar_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(23)
							.addComponent(lblSelectDateFrom_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(dateChooser_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblTo_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(dateChooser_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
					.addGap(11))
		);
		
		JMenuItem mntmGetReport_1 = new JMenuItem("Get Report");
		mntmGetReport_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmGetReport_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmGetReport_1.setForeground(Color.WHITE);
		mntmGetReport_1.setBackground(new Color(102, 51, 51));
		mntmGetReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1  = "/Reports/inword_A4.jrxml";
				InputStream in = null ;				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/inword_A4.jrxml");
			//		String sql ="select parttype.* ,inword.* from parttype ,inword where partname= itemname ";
					String sql ="select parttype.* , inword.* from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"')"
							+ " and partname = itemnamein order by kfildate";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_9.removeAll();
					panel_9.setLayout(new BorderLayout());
					panel_9.repaint();
					panel_9.add(new JRViewer(j));
					panel_9.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		toolBar_4.add(mntmGetReport_1);
		
		JMenuItem menuItem_15 = new JMenuItem("Cancel");
		menuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_15.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_15.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_15.setForeground(Color.WHITE);
		menuItem_15.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_15.setBackground(new Color(102, 51, 51));
		toolBar_4.add(menuItem_15);
		
		JMenuItem menuItem_16 = new JMenuItem("Exit");
		menuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_16.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_16.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_16.setForeground(Color.WHITE);
		menuItem_16.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_16.setBackground(new Color(102, 51, 51));
		toolBar_4.add(menuItem_16);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_10, "name_365764285556617");
		
		JLabel label_4 = new JLabel("");
		
		JLabel lblSelectDateFrom_4 = new JLabel("Select Date From :");
		lblSelectDateFrom_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_11 = new JDateChooser();
		
		JLabel lblTo_4 = new JLabel("TO ");
		lblTo_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_12 = new JDateChooser();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(panel_11);
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 317, Short.MAX_VALUE)
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGap(0, 221, Short.MAX_VALUE)
		);
		panel_11.setLayout(gl_panel_11);
		
		JToolBar toolBar_5 = new JToolBar();
		
		JMenuItem mntmOk_1 = new JMenuItem("Get Report");
		mntmOk_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmOk_1.setBackground(new Color(102, 51, 51));
		mntmOk_1.setForeground(Color.WHITE);
		mntmOk_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		mntmOk_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/inword_A4.jrxml";
				InputStream in = null ;
				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/Reports/inword_A4.jrxml");
				//	String sql ="select parttype.* , inword.*   from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"') and partname = itemname";
					String sql ="select parttype.* , inword.* from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"') and partname = itemname";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_9.removeAll();
					panel_9.setLayout(new BorderLayout());
					panel_9.repaint();
					panel_9.add(new JRViewer(j));
					panel_9.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		toolBar_5.add(mntmOk_1);
		
		JMenuItem menuItem_17 = new JMenuItem("Cancel");
		menuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_17.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_17.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_17.setForeground(Color.WHITE);
		menuItem_17.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_17.setBackground(new Color(102, 51, 51));
		toolBar_5.add(menuItem_17);
		
		JMenuItem menuItem_18 = new JMenuItem("Exit");
		menuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_18.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_18.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_18.setForeground(Color.WHITE);
		menuItem_18.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_18.setBackground(new Color(102, 51, 51));
		toolBar_5.add(menuItem_18);
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_5, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addComponent(label_4)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(10)
							.addComponent(dateChooser_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTo_4, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(10)
							.addComponent(dateChooser_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSelectDateFrom_4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addComponent(toolBar_5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addGroup(gl_panel_10.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(22)
							.addComponent(lblSelectDateFrom_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(dateChooser_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(lblTo_4, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(dateChooser_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_10.createSequentialGroup()
							.addGap(6)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_10.setLayout(gl_panel_10);
		
		
		
		JToolBar toolBar_6 = new JToolBar();
		

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBorder(null);
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 323, Short.MAX_VALUE)
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 206, Short.MAX_VALUE)
		);
		panel_13.setLayout(gl_panel_13);
		
		JLabel lblFromDate = new JLabel("Select  Date from :");
		lblFromDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_13 = new JDateChooser();
		
		JLabel lblTo_5 = new JLabel("To :");
		lblTo_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_14 = new JDateChooser();
		
		
		JMenuItem menuItem_10 = new JMenuItem("Get Report");
		menuItem_10.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/Purchase.jrxml" ;
				InputStream in  = null ;
				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
			//		JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/Purchase.jrxml");
					String sql ="select purchaseinfo2.* , purchaseinfo1.*  from purchaseinfo2,purchaseinfo1"
							+ " where (pdate>='"+df1.format(dateChooser_13.getDate())+"' and pdate<='"+df1.format(dateChooser_14.getDate())+"') "
							+ "and challanno = challanno1";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_13.removeAll();
					panel_13.setLayout(new BorderLayout());
					panel_13.repaint();
					panel_13.add(new JRViewer(j));
					panel_13.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		menuItem_10.setForeground(Color.WHITE);
		menuItem_10.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_10.setBackground(new Color(102, 51, 51));
		toolBar_6.add(menuItem_10);
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_6, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser_13, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTo_5, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_14, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFromDate, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addComponent(toolBar_6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(13)
							.addComponent(lblFromDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(dateChooser_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTo_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_12.createSequentialGroup()
									.addGap(18)
									.addComponent(dateChooser_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(panel_13, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
					.addGap(11))
		);
		
		JMenuItem menuItem_23 = new JMenuItem("Cancel");
		menuItem_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_23.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_23.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_23.setForeground(Color.WHITE);
		menuItem_23.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_23.setBackground(new Color(102, 51, 51));
		toolBar_6.add(menuItem_23);
		
		JMenuItem menuItem_24 = new JMenuItem("Exit");
		menuItem_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_24.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_24.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_24.setForeground(Color.WHITE);
		menuItem_24.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_24.setBackground(new Color(102, 51, 51));
		toolBar_6.add(menuItem_24);
		panel_12.setLayout(gl_panel_12);
		
		
		
		JToolBar toolBar_7 = new JToolBar();
		
		JLabel lblEmployeeName = new JLabel("Employee Name :");
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.WHITE);
		try {
			Driver dr = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(dr);
			
			String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
			java.sql.Connection con =  DriverManager.getConnection(url);
			String query = "select * from employeeinfo";
		    PreparedStatement	stmt = con.prepareStatement(query);
		     ResultSet rs= stmt.executeQuery();
			
			while(rs.next()) {
				String transportername =rs.getString("empname");
				comboBox_2.addItem(transportername);
				System.out.println(transportername);
				 
//				String vechileNumber = rs.getString("vechilenumber");
//				comboBox_5.addItem(vechileNumber);
			}
			
		
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.toString());
				System.out.println(e1);
			}
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_7, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmployeeName, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addComponent(toolBar_7, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addGroup(gl_panel_14.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_14.createSequentialGroup()
							.addGap(9)
							.addComponent(lblEmployeeName, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
					.addGap(11))
		);
		
		JMenuItem menuItem_13 = new JMenuItem("Get Report");
		menuItem_13.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/useiteminfo_A4.jrxml" ;
				InputStream in = null ;
				
				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
					
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/useiteminfo_A4.jrxml");
					String sql ="select iteminfo.* , useiteminfo.*  from iteminfo,useiteminfo where useiteminfo.empname like '"+comboBox_2.getSelectedItem().toString()+"'"
							+ "and iteminfo.itemname = useiteminfo.itemname " ;
							//+ " where (pdate>='"+df1.format(dateChooser_13.getDate())+"' and pdate<='"+df1.format(dateChooser_14.getDate())+"') "
						//	+ "and challanno = challanno1";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_15.removeAll();
					panel_15.setLayout(new BorderLayout());
					panel_15.repaint();
					panel_15.add(new JRViewer(j));
					panel_15.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		menuItem_13.setForeground(Color.WHITE);
		menuItem_13.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_13.setBackground(new Color(102, 51, 51));
		toolBar_7.add(menuItem_13);
		
		JMenuItem menuItem_21 = new JMenuItem("Cancel");
		menuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_21.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_21.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_21.setForeground(Color.WHITE);
		menuItem_21.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_21.setBackground(new Color(102, 51, 51));
		toolBar_7.add(menuItem_21);
		
		JMenuItem menuItem_22 = new JMenuItem("Exit");
		menuItem_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_22.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_22.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_22.setForeground(Color.WHITE);
		menuItem_22.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_22.setBackground(new Color(102, 51, 51));
		toolBar_7.add(menuItem_22);
		panel_14.setLayout(gl_panel_14);
		
		
		JToolBar toolBar_8 = new JToolBar();
		
		JDateChooser dateChooser_15 = new JDateChooser();
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		
		
		JMenuItem menuItem_14 = new JMenuItem("Get Report");
		menuItem_14.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/daywise_A4.jrxml" ;
				InputStream in  = null ;
				try { 
					
				//	Driver dr = new com.mysql.jdbc.Driver();
				//	DriverManager.registerDriver(dr);
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/daywise_A4.jrxml");
					String sql ="select iteminfo.* , useiteminfo.*  from iteminfo,useiteminfo"
							+ " where (date>='"+df1.format(dateChooser_15.getDate())+"' ) "
							+ "and iteminfo.itemname = useiteminfo.itemname";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_17.removeAll();
					panel_17.setLayout(new BorderLayout());
					panel_17.repaint();
					panel_17.add(new JRViewer(j));
					panel_17.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			}
		});
		menuItem_14.setForeground(Color.WHITE);
		menuItem_14.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_14.setBackground(new Color(102, 51, 51));
		toolBar_8.add(menuItem_14);
		
		JLabel lblSelectDate = new JLabel("Select Date :");
		lblSelectDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel_16 = new GroupLayout(panel_16);
		gl_panel_16.setHorizontalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser_15, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelectDate, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_17, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addGap(10))
				.addComponent(toolBar_8, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel_16.setVerticalGroup(
			gl_panel_16.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_16.createSequentialGroup()
					.addComponent(toolBar_8, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_16.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_16.createSequentialGroup()
							.addGap(30)
							.addComponent(lblSelectDate, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(dateChooser_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_17, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
					.addGap(11))
		);
		
		JMenuItem menuItem_19 = new JMenuItem("Cancel");
		menuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_19.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_19.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_19.setForeground(Color.WHITE);
		menuItem_19.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_19.setBackground(new Color(102, 51, 51));
		toolBar_8.add(menuItem_19);
		
		JMenuItem menuItem_20 = new JMenuItem("Exit");
		menuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_20.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_20.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_20.setForeground(Color.WHITE);
		menuItem_20.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_20.setBackground(new Color(102, 51, 51));
		toolBar_8.add(menuItem_20);
		panel_16.setLayout(gl_panel_16);
		
		
		panel_20.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_20, "name_585558239365448"); 
		
		JToolBar toolBar_10 = new JToolBar();
		
		JDateChooser dateChooser_18 = new JDateChooser();
		JDateChooser dateChooser_19 = new JDateChooser();
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		
		JMenuItem menuItem = new JMenuItem("Get Report");
		menuItem.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/paintedQty.jrxml";
				InputStream in = null ;
				try { 
					
				
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/paintedQty.jrxml");
				//	String sql ="select parttype.* , inword.*   from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"') and partname = itemname";
					String sql ="select pntnorms.pntcast as item ,"
							+ "pntnorms.pnt as pnt ,"
							+ "pntnorms.thinner as thinner," + 
							"pntnorms.pntnorms as pntn,"
							+ "pntnorms.thinnernorms as thinnern,"
							+ "(SELECT COALESCE( inword.tqty,0)) as ttqty  from pntnorms left join "
							+ "(select sum(outword.pnt1) as tqty,outword.itemname as name from outword"
							+ " where (outdate>='"+df1.format(dateChooser_18.getDate())+"' and outdate<='"+df1.format(dateChooser_19.getDate())+"') group by outword.itemname ) inword on inword.name=  pntnorms.pntcast ";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					params.put("DATE",dateChooser_18.getDate());
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_21.removeAll();
					panel_21.setLayout(new BorderLayout());
					panel_21.repaint();
					panel_21.add(new JRViewer(j));
					panel_21.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		menuItem.setForeground(Color.WHITE);
		menuItem.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem.setBackground(new Color(102, 51, 51));
		toolBar_10.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Cancel");
		menuItem_1.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_1.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_1.setForeground(Color.WHITE);
		menuItem_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_1.setBackground(new Color(102, 51, 51));
		toolBar_10.add(menuItem_1);
		
		JMenuItem menuItem_4 = new JMenuItem("Exit");
		menuItem_4.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
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
		menuItem_4.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_4.setBackground(new Color(102, 51, 51));
		toolBar_10.add(menuItem_4);
		
		JLabel label_8 = new JLabel("Select Date From :");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		JLabel label_9 = new JLabel("TO ");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	
		
		
		GroupLayout gl_panel_21 = new GroupLayout(panel_21);
		gl_panel_21.setHorizontalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGap(0, 317, Short.MAX_VALUE)
				.addGap(0, 317, Short.MAX_VALUE)
		);
		gl_panel_21.setVerticalGroup(
			gl_panel_21.createParallelGroup(Alignment.LEADING)
				.addGap(0, 221, Short.MAX_VALUE)
				.addGap(0, 221, Short.MAX_VALUE)
		);
		panel_21.setLayout(gl_panel_21);
		GroupLayout gl_panel_20 = new GroupLayout(panel_20);
		gl_panel_20.setHorizontalGroup(
			gl_panel_20.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_10, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_20.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_20.createParallelGroup(Alignment.LEADING, false)
						.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_18, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(dateChooser_19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_21, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_20.setVerticalGroup(
			gl_panel_20.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_20.createSequentialGroup()
					.addComponent(toolBar_10, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_20.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_20.createSequentialGroup()
							.addGap(26)
							.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_18, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_19, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_20.createSequentialGroup()
							.addGap(11)
							.addComponent(panel_21, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
					.addContainerGap())
		);
		panel_20.setLayout(gl_panel_20);
		
		
		panel_22.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_22, "name_774847983997409");
		
		JToolBar toolBar_11 = new JToolBar();
		
		JLabel label_10 = new JLabel("Select Date From :");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_20 = new JDateChooser();
		
		JLabel label_11 = new JLabel("TO ");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_21 = new JDateChooser();
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		GroupLayout gl_panel_23 = new GroupLayout(panel_23);
		gl_panel_23.setHorizontalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 345, Short.MAX_VALUE)
				.addGap(0, 345, Short.MAX_VALUE)
		);
		gl_panel_23.setVerticalGroup(
			gl_panel_23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 292, Short.MAX_VALUE)
				.addGap(0, 292, Short.MAX_VALUE)
		);
		panel_23.setLayout(gl_panel_23);
		GroupLayout gl_panel_22 = new GroupLayout(panel_22);
		gl_panel_22.setHorizontalGroup(
			gl_panel_22.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_22.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_22.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser_20, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_21, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_23, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addGap(11))
				.addComponent(toolBar_11, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
		);
		gl_panel_22.setVerticalGroup(
			gl_panel_22.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_22.createSequentialGroup()
					.addComponent(toolBar_11, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_22.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_22.createSequentialGroup()
							.addGap(15)
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_20, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_21, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_23, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JMenuItem menuItem_5 = new JMenuItem("Get Report");
		menuItem_5.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/paintStock.jrxml";
				InputStream in = null ;
				try { 
					
				
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/paintStock.jrxml");
				//	String sql ="select parttype.* , inword.*   from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"') and partname = itemname";
					String sql ="select  pntnorms.pntcast  as item ,"
							+ " (SELECT COALESCE(inword.tqty,0)) as castQty ,"
							+ "pntnorms.pnt as pnt,"
							+ "pntnorms.pntnorms as pntnorms,"
							+ "(SELECT COALESCE(paintin.qtty,0)) as receivedst ,"
							+ "(SELECT COALESCE(op.qtty-opening.tqty *pntnorms.pntnorms,0))   as openstockpnt ,"
							+ "(SELECT COALESCE(pntnorms.pntnorms*inword.tqty,0)) as pntconsumption,"
							+ "(SELECT COALESCE(paintin1.qttty,0)) as receivedstthinner ,"
							+ "pntnorms.thinner as thinner,"
							+ "(SELECT COALESCE(op1.qttty -opening.tqty *pntnorms.thinnernorms,0))  as openstockthinner ,"
							+ "pntnorms.thinnernorms as thinnernorms ,"
							
							+ "(SELECT COALESCE(pntnorms.thinnernorms*inword.tqty,0)) as thinconsumption "
						
							+ "from pntnorms left join "
							+ "(select sum(inword.pnt) as tqty ,inword.itemnamein as name from inword where (kfildate>='"+df1.format(dateChooser_20.getDate())+"' and kfildate<='"+df1.format(dateChooser_21.getDate())+"')"
							+ "group by inword.itemnamein )inword on inword.name=  pntnorms.pntcast left outer join (select sum(paintinword.tqty) as qtty,paintinword.itemnamein as pntcast "
							+ "from paintinword where (kfildate>='"+df1.format(dateChooser_20.getDate())+"' and kfildate<='"+df1.format(dateChooser_21.getDate())+"')group by paintinword.itemnamein)  paintin on paintin.pntcast = pntnorms.pnt left outer join"
							+ "(select sum(paintinword.tqty) as qttty,paintinword.itemnamein as pntcast1 from paintinword where (kfildate>= '"+df1.format(dateChooser_20.getDate())+"' and kfildate<='"+df1.format(dateChooser_21.getDate())+"') "
							+ "group by paintinword.itemnamein) paintin1 on paintin1.pntcast1 = pntnorms.thinner left outer join "
							+ "(select sum(inword.pnt) as tqty,inword.itemnamein as name from inword where kfildate between "
							+ "date_sub('"+df1.format(dateChooser_20.getDate())+"', INTERVAL 4 MONTH) and date_sub('"+df1.format(dateChooser_21.getDate())+"' , INTERVAL 1 MONTH)group by inword.itemnamein ) "
							+ "opening on opening.name=  pntnorms.pntcast left outer join (select sum(paintinword.tqty) as qtty,paintinword.itemnamein as pntcast "
							+ "from paintinword where kfildate between date_sub('"+df1.format(dateChooser_20.getDate())+"', INTERVAL 4 MONTH) and date_sub('"+df1.format(dateChooser_21.getDate())+"' , INTERVAL 1 MONTH) group by "
							+ "paintinword.itemnamein) op on op.pntcast = pntnorms.pnt left outer join (select sum(paintinword.tqty) as qttty,paintinword.itemnamein as pntcast1 "
							+ "from paintinword where kfildate between date_sub('"+df1.format(dateChooser_20.getDate())+"', INTERVAL 4 MONTH) and date_sub('"+df1.format(dateChooser_21.getDate())+"' , INTERVAL 1 MONTH) group by "
							+ "paintinword.itemnamein) op1 on op1.pntcast1 = pntnorms.thinner;";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				 
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					params.put("DATE",dateChooser_20.getDate());
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_23.removeAll();
					panel_23.setLayout(new BorderLayout());
					panel_23.repaint();
					panel_23.add(new JRViewer(j));
					panel_23.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				
			}
		});
		menuItem_5.setForeground(Color.WHITE);
		menuItem_5.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_5.setBackground(new Color(102, 51, 51));
		toolBar_11.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Cancel");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_6.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_6.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_6.setForeground(Color.WHITE);
		menuItem_6.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_6.setBackground(new Color(102, 51, 51));
		toolBar_11.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Exit");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_7.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_7.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_7.setForeground(Color.WHITE);
		menuItem_7.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_7.setBackground(new Color(102, 51, 51));
		toolBar_11.add(menuItem_7);
		panel_22.setLayout(gl_panel_22);
		
		
		panel_24.setBackground(new Color(204, 204, 153));
		contentPane.add(panel_24, "name_215007132273519");
		
		JDateChooser dateChooser_22 = new JDateChooser();
		
		JLabel label_12 = new JLabel("Select Date From :");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooser_23 = new JDateChooser();
		
		JLabel label_13 = new JLabel("TO ");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		GroupLayout gl_panel_25 = new GroupLayout(panel_25);
		gl_panel_25.setHorizontalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGap(0, 321, Short.MAX_VALUE)
				.addGap(0, 321, Short.MAX_VALUE)
		);
		gl_panel_25.setVerticalGroup(
			gl_panel_25.createParallelGroup(Alignment.LEADING)
				.addGap(0, 292, Short.MAX_VALUE)
				.addGap(0, 292, Short.MAX_VALUE)
		);
		panel_25.setLayout(gl_panel_25);
		
		JToolBar toolBar_12 = new JToolBar();
		
		JMenuItem menuItem_8 = new JMenuItem("Get Report");
		menuItem_8.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Text Document/Text Document_24x24.png")));
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				Connection	con = null;
				String a1 = "/Reports/NotProc.jrxml";
				InputStream in = null ;
				try { 
					
				
					
					Class.forName("com.mysql.jdbc.Driver");			
					String url ="jdbc:mysql://localhost:3306/inventory?user=j2ee&password=j2ee";
					con = DriverManager.getConnection(url); 
					in = this.getClass().getResourceAsStream(a1);
					JasperDesign jd = JRXmlLoader.load(in);
				//	InputStream in = new FileInputStream("C:\\Users\\sukrutha\\eclipse-workspace\\newproject\\src\\Tonnege_A4.jrxml");
				//	JasperDesign jd = JRXmlLoader.load(new File("").getAbsolutePath()+"/src/NotProc.jrxml");
				//	String sql ="select parttype.* , inword.*   from parttype,inword where (kfildate>='"+df1.format(dateChooser_9.getDate())+"' and kfildate<='"+df1.format(dateChooser_10.getDate())+"') and partname = itemname";
					String sql ="select kfilchano,itemnamein,tqty from inventory.inword where kfildate" + 
							" between date_sub('"+df1.format(dateChooser_22.getDate())+"' , INTERVAL  4 MONTH)" + 
							"and '"+df1.format(dateChooser_23.getDate())+"' and inword.kfilchano not in " + 
							"(select outword.inwordno from inventory.outword) order by itemnamein ";
					JRDesignQuery q = new JRDesignQuery();
					q.setText(sql);
					jd.setQuery(q);
					
				
					JasperReport jr = JasperCompileManager.compileReport(jd);
					Map<String, Object>	params = new HashMap<String, Object>();
					params.put("DATE",dateChooser_22.getDate());
					JasperPrint j = JasperFillManager.fillReport(jr,params,con);
				//	JasperViewer.viewReport(j,false);
//					
					panel_25.removeAll();
					panel_25.setLayout(new BorderLayout());
					panel_25.repaint();
					panel_25.add(new JRViewer(j));
					panel_25.revalidate();
					
					
					con.close();
				
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		});
		menuItem_8.setForeground(Color.WHITE);
		menuItem_8.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_8.setBackground(new Color(102, 51, 51));
		toolBar_12.add(menuItem_8);
		
		JMenuItem menuItem_9 = new JMenuItem("Cancel");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				contentPane.add(panel);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		menuItem_9.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Cancel/Cancel_24x24.png")));
		menuItem_9.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_9.setForeground(Color.WHITE);
		menuItem_9.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_9.setBackground(new Color(102, 51, 51));
		toolBar_12.add(menuItem_9);
		
		JMenuItem menuItem_28 = new JMenuItem("Exit");
		menuItem_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuItem_28.setIcon(new ImageIcon(Report.class.getResource("/must_have_icon_set/Remove/Remove_24x24.png")));
		menuItem_28.setHorizontalAlignment(SwingConstants.LEFT);
		menuItem_28.setForeground(Color.WHITE);
		menuItem_28.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuItem_28.setBackground(new Color(102, 51, 51));
		toolBar_12.add(menuItem_28);
		GroupLayout gl_panel_24 = new GroupLayout(panel_24);
		gl_panel_24.setHorizontalGroup(
			gl_panel_24.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar_12, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
				.addGroup(gl_panel_24.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_24.createParallelGroup(Alignment.LEADING)
						.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_22, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooser_23, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(panel_25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(11))
		);
		gl_panel_24.setVerticalGroup(
			gl_panel_24.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_24.createSequentialGroup()
					.addComponent(toolBar_12, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_panel_24.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_24.createSequentialGroup()
							.addGap(15)
							.addComponent(label_12, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_22, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(dateChooser_23, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(11))
		);
		panel_24.setLayout(gl_panel_24);
		
		
		
		
		
		
		
		
	}
}
