package newproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class LOgin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LOgin frame = new LOgin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LOgin() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LOgin.class.getResource("/vk112.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 302);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setIcon(new ImageIcon(LOgin.class.getResource("/must_have_icon_set/Key/Key_32x32.png")));
		lblUserLogin.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblUserLogin.setBounds(547, 11, 177, 39);
		contentPane.add(lblUserLogin);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setIcon(new ImageIcon(LOgin.class.getResource("/must_have_icon_set/User/User_24x24.png")));
		lblUserName.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblUserName.setBounds(517, 86, 110, 26);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key==10) {
					passwordField.requestFocus();
				}
			}
		});
		textField.setBounds(637, 89, 134, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PassWord :");
		lblPassword.setIcon(new ImageIcon(LOgin.class.getResource("/must_have_icon_set/Key/Key_24x24.png")));
		lblPassword.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblPassword.setBounds(517, 129, 110, 26);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(637, 132, 134, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("admin")&& passwordField.getText().equals("admin")) {
					Main m1 = new Main();
					m1.setExtendedState(m1.MAXIMIZED_BOTH);
					m1.setVisible(true);
					dispose();
				}
						
			}
		});
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 10));
		btnLogin.setBounds(594, 179, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblVkTechnologies = new JLabel("Vk32 Technologies & Services");
		lblVkTechnologies.setVerticalAlignment(SwingConstants.BOTTOM);
		lblVkTechnologies.setForeground(new Color(204, 204, 153));
		lblVkTechnologies.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblVkTechnologies.setHorizontalAlignment(SwingConstants.CENTER);
		lblVkTechnologies.setBounds(0, 186, 548, 77);
		contentPane.add(lblVkTechnologies);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(LOgin.class.getResource("/vk112.png")));
		label.setBounds(10, 57, 538, 134);
		contentPane.add(label);
	}
}
