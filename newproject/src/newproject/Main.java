package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

                        	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	
	
	String path=null;
    String filename;
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 356);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 153));
		contentPane.add(panel, "name_260514632578996");
		
		JToolBar toolBar = new JToolBar();
		
		JMenuBar menuBar = new JMenuBar();
		toolBar.add(menuBar);
		
		JMenu mnMaster = new JMenu("Master");
		mnMaster.setForeground(new Color(102, 51, 51));
		mnMaster.setBackground(new Color(102, 51, 51));
		mnMaster.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuBar.add(mnMaster);
		
		JMenuItem mntmDeliverychallan = new JMenuItem("Delivery Challan");
		mntmDeliverychallan.setBackground(UIManager.getColor("Button.background"));
		mntmDeliverychallan.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmDeliverychallan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deliveryinword d1 = new Deliveryinword();
			
				d1.setVisible(true);
			 
			}
		});
		mnMaster.add(mntmDeliverychallan);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Po UpDater");
		mntmNewMenuItem.setBackground(UIManager.getColor("Button.background"));
		mntmNewMenuItem.setIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				POUPDATER P1 = new POUPDATER();
				
				P1.setVisible(true);
				
			}
		});
		
		JSeparator separator = new JSeparator();
		mnMaster.add(separator);
		mnMaster.add(mntmNewMenuItem);
		
		JMenuItem mntmPartDetails = new JMenuItem("Part Details");
		mntmPartDetails.setBackground(UIManager.getColor("Button.background"));
		mntmPartDetails.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Settings/Settings_16x16.png")));
		mntmPartDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				New n1 = new New();
				
				n1.setVisible(true);
				
				
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnMaster.add(separator_1);
		mnMaster.add(mntmPartDetails);
		
		JMenuItem mntmTransporterDetails = new JMenuItem("Transporter Details");
		mntmTransporterDetails.setBackground(UIManager.getColor("Button.background"));
		mntmTransporterDetails.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Globe/Globe_16x16.png")));
		mntmTransporterDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransportDetails t1 = new TransportDetails();
				
				t1.setVisible(true);
			
				
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnMaster.add(separator_2);
		mnMaster.add(mntmTransporterDetails);
		
		JMenuItem mntmReportEditor = new JMenuItem("Employee Information");
		mntmReportEditor.setBackground(UIManager.getColor("Button.background"));
		mntmReportEditor.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/User/User_16x16.png")));
		mntmReportEditor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeInfo e1 = new EmployeeInfo();
				
				e1.setVisible(true);
				
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnMaster.add(separator_3);
		mnMaster.add(mntmReportEditor);
		
		JSeparator separator_4 = new JSeparator();
		mnMaster.add(separator_4);
		
		JMenuItem mntmItemInformation = new JMenuItem("Item Information");
		mntmItemInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ItemInfo i1 = new ItemInfo();
				i1.setVisible(true);
				
			}
		});
		mntmItemInformation.setBackground(UIManager.getColor("Button.background"));
		mntmItemInformation.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Stock Index Up/Stock Index Up_16x16.png")));
		mnMaster.add(mntmItemInformation);
		
		JSeparator separator_5 = new JSeparator();
		mnMaster.add(separator_5);
		
		JMenuItem mntmPurchaseInformation = new JMenuItem("Purchase Information");
		mntmPurchaseInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PurchaseInfo p1 = new PurchaseInfo();
				p1.setVisible(true);
			}
		});
		mntmPurchaseInformation.setBackground(UIManager.getColor("Button.background"));
		mntmPurchaseInformation.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Redo/Redo_16x16.png")));
		mnMaster.add(mntmPurchaseInformation);
		
		JSeparator separator_6 = new JSeparator();
		mnMaster.add(separator_6);
		
		JMenuItem mntmStoreInformation = new JMenuItem("Store Information");
		mntmStoreInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StoreInfo s1 = new StoreInfo();
				s1.setVisible(true);
			}
		});
		mntmStoreInformation.setBackground(UIManager.getColor("Button.background"));
		mntmStoreInformation.setIcon(new ImageIcon(Main.class.getResource("/com/jgoodies/looks/plastic/icons/HomeFolder.gif")));
		mnMaster.add(mntmStoreInformation);
		
		JSeparator separator_7 = new JSeparator();
		mnMaster.add(separator_7);
		
		JMenuItem mntmUseItemInformation = new JMenuItem("Use Item Information");
		mntmUseItemInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UseItemInfo u1 = new  UseItemInfo();
				u1.setVisible(true);
			}
		});
		mntmUseItemInformation.setBackground(UIManager.getColor("Button.background"));
		mntmUseItemInformation.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Open/Open_16x16.png")));
		mnMaster.add(mntmUseItemInformation);
		
		JSeparator separator_8 = new JSeparator();
		mnMaster.add(separator_8);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		
		JMenuItem mntmPaintInword = new JMenuItem("Paint Inword");
		mntmPaintInword.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Text Document/Text Document_16x16.png")));
		mntmPaintInword.setBackground(UIManager.getColor("Button.background"));
		mntmPaintInword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Paint p1 = new Paint();
				p1.setVisible(true);
			}
		});
		
		JMenuItem mntmPaintNorms = new JMenuItem("Paint Norms");
		mntmPaintNorms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PaintNoms p1 = new PaintNoms();
				p1.setVisible(true);
				
			}
		});
		mntmPaintNorms.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Picture/Picture_16x16.png")));
		mnMaster.add(mntmPaintNorms);
		
		JSeparator separator_13 = new JSeparator();
		mnMaster.add(separator_13);
		mnMaster.add(mntmPaintInword);
		
		JSeparator separator_11 = new JSeparator();
		mnMaster.add(separator_11);
		
		JMenu mnNewMenu = new JMenu("paint manully changer");
		mnNewMenu.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Rename/Rename_16x16.png")));
		mnNewMenu.setBackground(UIManager.getColor("Button.background"));
		mnMaster.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("FROM FETTLER");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Rename/Rename_16x16.png")));
		mntmNewMenuItem_1.setBackground(UIManager.getColor("Button.background"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FromFettler f1 = new FromFettler();
				f1.setExtendedState(f1.MAXIMIZED_BOTH);
				f1.setVisible(true);
				
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_9 = new JSeparator();
		mnNewMenu.add(separator_9);
		
		JMenuItem mntmToFettler = new JMenuItem("TO FETTLER");
		mntmToFettler.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Rename/Rename_16x16.png")));
		mntmToFettler.setBackground(UIManager.getColor("Button.background"));
		mntmToFettler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tofettler t1 = new Tofettler();
				t1.setExtendedState(t1.MAXIMIZED_BOTH);
				t1.setVisible(true);
			}
		});
		mnNewMenu.add(mntmToFettler);
		
		JSeparator separator_10 = new JSeparator();
		mnNewMenu.add(separator_10);
		
		JMenuItem mntmPaintReconcillation = new JMenuItem("PAINT RECONCILLATION");
		mntmPaintReconcillation.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Rename/Rename_16x16.png")));
		mntmPaintReconcillation.setBackground(UIManager.getColor("Button.background"));
		mntmPaintReconcillation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Recon r1 = new Recon();
				r1.setExtendedState(r1.MAXIMIZED_BOTH);
				r1.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPaintReconcillation);
		
		JSeparator separator_12 = new JSeparator();
		mnMaster.add(separator_12);
		mntmExit.setBackground(UIManager.getColor("Button.background"));
		mntmExit.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Remove/Remove_16x16.png")));
		mnMaster.add(mntmExit);
		
		JMenuItem mntmReports = new JMenuItem("Reports");
		mntmReports.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Presentation/Presentation_32x32.png")));
		mntmReports.setForeground(Color.WHITE);
		mntmReports.setBackground(new Color(102, 51, 51));
		mntmReports.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Report r1 = new Report();
				r1.setExtendedState(r1.MAXIMIZED_BOTH);
				r1.setVisible(true);
		//		dispose();
			}
		});
		toolBar.add(mntmReports);
		
		JMenuBar menuBar_1 = new JMenuBar();
		toolBar.add(menuBar_1);
		
		JMenuItem mntmDataBackup_1 = new JMenuItem("Data Backup");
		mntmDataBackup_1.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Folder/Folder_32x32.png")));
		mntmDataBackup_1.setForeground(Color.WHITE);
		mntmDataBackup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		        Process p=null;
		        try {
		          
		          
		            Runtime runtime = Runtime.getRuntime();
		            p=runtime.exec("C:/Program Files/MySQL/MySQL Server 5.5/bin/mysqldump.exe -uj2ee -pj2ee --add-drop-database -B inventory -r F:/Backup_data/Inventory_"+date+".sql");
		            
		            int processComplete = p.waitFor();
		            if (processComplete==0) {
		                JOptionPane.showMessageDialog(null,"Backup Created Succuss");
		            }else{
		            	JOptionPane.showMessageDialog(null,"Can't Create backup");
		            }

		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
		});
		mntmDataBackup_1.setBackground(new Color(102, 51, 51));
		mntmDataBackup_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		menuBar_1.add(mntmDataBackup_1);
		
		JMenuItem mntmExit_1 = new JMenuItem("Exit");
		mntmExit_1.setIcon(new ImageIcon(Main.class.getResource("/must_have_icon_set/Remove/Remove_32x32.png")));
		mntmExit_1.setForeground(Color.WHITE);
		mntmExit_1.setBackground(new Color(102, 51, 51));
		mntmExit_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		mntmExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
int exit = JOptionPane.showConfirmDialog(null, "Really Do you  Want exit","Exit", JOptionPane.YES_NO_OPTION);
				
				if(exit ==0) {
					System.exit(0);
				}
			}
		});
		menuBar_1.add(mntmExit_1);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_1.add(menuBar_2);
		
		JLabel lblNewLabel = new JLabel("VK32 Technologies & Services\r\n");
		lblNewLabel.setBackground(new Color(102, 51, 51));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblContact = new JLabel("Contact :9380665986");
		lblContact.setBackground(new Color(102, 51, 51));
		lblContact.setForeground(Color.WHITE);
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 11));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(toolBar, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
				.addComponent(lblContact, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_427241558357491");
	}
}
