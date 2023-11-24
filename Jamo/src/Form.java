import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldUserName;
	private JTextField textFieldPassword;
	private JTextField textFieldConPassword;
	private JTextField textFieldEmail;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	
	
	private void resetForm() {
	    textFieldName.setText("");
	    textFieldUserName.setText("");
	    textFieldPassword.setText("");
	    textFieldConPassword.setText("");
	    textFieldEmail.setText("");
	    textFieldPhone.setText("");
	    textFieldAddress.setText("");
	}

	private void closeForm() {
	        System.exit(0); 
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 594);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(112, 63, 74, 19);
		contentPane.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(200, 57, 337, 30);
		contentPane.add(textFieldName);
		
		JButton btnRegister = new JButton("Submit");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/james","root","jackspurs");
					String sql = "INSERT INTO form_1(name,Username,Password,ConPassword,Email,Phone,Address)VALUES(?,?,?,?,?,?,?)";
					PreparedStatement pr = con.prepareStatement(sql);
					pr.setString(1, textFieldName.getText());
					pr.setString(2, textFieldUserName.getText());
					pr.setString(3, textFieldPassword.getText());
					pr.setString(4, textFieldConPassword.getText());
					pr.setString(5, textFieldEmail.getText());
					pr.setString(6, textFieldPhone.getText());
					pr.setString(7, textFieldAddress.getText());
					
					int count = pr.executeUpdate();
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "Record added successfully");
						con.close();
					}else {
						JOptionPane.showMessageDialog(null, "No record added");
						con.close();
					}
					
				} catch (Exception e1) {
					
				}
			}
		});
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegister.setBounds(200, 468, 108, 35);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Register Form");
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 22));
		lblNewLabel.setBounds(28, 11, 171, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("UserName:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(84, 110, 102, 19);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(200, 104, 337, 30);
		contentPane.add(textFieldUserName);
		
		JLabel lblNewLabel_1_2 = new JLabel("Password:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(84, 161, 102, 19);
		contentPane.add(lblNewLabel_1_2);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(200, 155, 337, 30);
		contentPane.add(textFieldPassword);
		
		JLabel lblNewLabel_1_3 = new JLabel("Confirm Password:");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(28, 211, 158, 19);
		contentPane.add(lblNewLabel_1_3);
		
		textFieldConPassword = new JTextField();
		textFieldConPassword.setColumns(10);
		textFieldConPassword.setBounds(200, 205, 337, 30);
		contentPane.add(textFieldConPassword);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(112, 267, 74, 19);
		contentPane.add(lblNewLabel_1_4);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(200, 261, 337, 30);
		contentPane.add(textFieldEmail);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone:");
		lblNewLabel_1_5.setForeground(Color.BLACK);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(112, 334, 74, 19);
		contentPane.add(lblNewLabel_1_5);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(200, 328, 337, 30);
		contentPane.add(textFieldPhone);
		
		JLabel lblNewLabel_1_6 = new JLabel("Address:");
		lblNewLabel_1_6.setForeground(Color.BLACK);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(112, 397, 74, 19);
		contentPane.add(lblNewLabel_1_6);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(200, 391, 337, 30);
		contentPane.add(textFieldAddress);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(318, 468, 91, 35);
		contentPane.add(btnReset);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeForm();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(434, 468, 91, 35);
		contentPane.add(btnClose);
	}
}
