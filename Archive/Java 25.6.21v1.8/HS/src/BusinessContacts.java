import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BusinessContacts extends JFrame {

	private JPanel contentPane;
	private JTable businesscontactstable;
	private JTable BusinessContactsTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessContacts frame = new BusinessContacts();
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
	public BusinessContacts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Harris & Sons Consulting LTD.");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(79, 11, 280, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblBusinessContacts = new JLabel("Business Contacts");
		lblBusinessContacts.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblBusinessContacts.setBounds(146, 43, 145, 39);
		contentPane.add(lblBusinessContacts);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(0, 0, 64, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(30, 90, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(89, 90, 78, 22);
		contentPane.add(textArea_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setBounds(177, 90, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(234, 85, 78, 22);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(234, 133, 38, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(265, 131, 216, 22);
		contentPane.add(textArea_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Business Telephone:");
		lblNewLabel_1_3.setBounds(29, 133, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(129, 131, 103, 22);
		contentPane.add(textArea_1_1);
		
		dbConn D=new dbConn();
		JButton btnNewButton_1 = new JButton("Refresh/Update");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				businesscontactstable.setModel(DbUtils.resultSetToTableModel(D.GetAllBusiness()));
			}
		});
		btnNewButton_1.setBounds(491, 94, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add New");
		btnNewButton_1_1.setBounds(491, 65, 109, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.setBounds(491, 124, 109, 23);
		contentPane.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 182, 525, 144);
		contentPane.add(scrollPane);
		
		BusinessContactsTable = new JTable();
		scrollPane.setViewportView(BusinessContactsTable);
	}
}
