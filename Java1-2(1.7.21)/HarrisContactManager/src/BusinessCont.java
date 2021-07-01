import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class BusinessCont extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_3_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblNewLabel_3_4;
	private JLabel lblBusinessContacts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusinessCont frame = new BusinessCont();
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
	public BusinessCont() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 632, 179);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		dbConn d=new dbConn();
		
		btnNewButton = new JButton("Update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
			}
		});
		btnNewButton.setBounds(538, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(29, 44, 65, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(29, 75, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setBounds(49, 106, 45, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Address Line 1:");
		lblNewLabel_3.setBounds(10, 137, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(104, 134, 114, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 103, 114, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 72, 114, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(104, 41, 114, 20);
		contentPane.add(textField_3);
		
		lblNewLabel_3_1 = new JLabel("Address Line 2:");
		lblNewLabel_3_1.setBounds(228, 44, 103, 14);
		contentPane.add(lblNewLabel_3_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(341, 41, 120, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(341, 72, 120, 20);
		contentPane.add(textField_5);
		
		lblNewLabel_3_2 = new JLabel("City:");
		lblNewLabel_3_2.setBounds(279, 75, 52, 14);
		contentPane.add(lblNewLabel_3_2);
		
		lblNewLabel_3_3 = new JLabel("Postcode:");
		lblNewLabel_3_3.setBounds(254, 106, 77, 14);
		contentPane.add(lblNewLabel_3_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(341, 103, 120, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(341, 134, 120, 20);
		contentPane.add(textField_7);
		
		lblNewLabel_3_4 = new JLabel("Business Phone:");
		lblNewLabel_3_4.setBounds(231, 137, 100, 14);
		contentPane.add(lblNewLabel_3_4);
		
		lblBusinessContacts = new JLabel("Harris & Sons Ltd. - Business Contacts");
		lblBusinessContacts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBusinessContacts.setBounds(167, 0, 326, 28);
		contentPane.add(lblBusinessContacts);
	}

}
