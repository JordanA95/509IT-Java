import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactManager {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManager window = new ContactManager();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton PersonalContactbtn = new JButton("Personal Contacts");
		PersonalContactbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PersonalContactbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonalContacts pc=new PersonalContacts();
				pc.setVisible(true);
			}
		});
		PersonalContactbtn.setBounds(261, 141, 119, 50);
		frame.getContentPane().add(PersonalContactbtn);
		
		JButton BusinessContactbtn = new JButton("Business Contacts");
		BusinessContactbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BusinessContactbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BusinessContacts pc=new BusinessContacts();
				pc.setVisible(true);
			}
		});
		BusinessContactbtn.setBounds(100, 141, 119, 50);
		frame.getContentPane().add(BusinessContactbtn);
		
		JLabel lblNewLabel = new JLabel("Harris & Sons Consulting LTD.");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(100, 11, 280, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblContactManagement = new JLabel("Contact Management");
		lblContactManagement.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblContactManagement.setBounds(145, 49, 173, 39);
		frame.getContentPane().add(lblContactManagement);
	}
}
