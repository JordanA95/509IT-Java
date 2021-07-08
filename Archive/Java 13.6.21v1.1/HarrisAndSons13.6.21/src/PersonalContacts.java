import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;

public class PersonalContacts extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalContacts frame = new PersonalContacts();
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
	public PersonalContacts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Harris & Sons Consulting LTD.");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel.setBounds(84, 11, 280, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblPersonalContacts = new JLabel("Personal Contacts");
		lblPersonalContacts.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblPersonalContacts.setBounds(156, 46, 145, 39);
		contentPane.add(lblPersonalContacts);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(0, 0, 64, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 237, 335, -126);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 248, 403, -163);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		dbConn d=new dbConn();
		table.setBounds(43, 248, 370, -151);
		contentPane.add(table);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(26, 256, 387, -145);
		contentPane.add(scrollPane_2);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(31, 96, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setBounds(178, 96, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(326, 96, 38, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Personal Telephone:");
		lblNewLabel_1_3.setBounds(30, 139, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(235, 91, 78, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(90, 96, 78, 22);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(361, 96, 216, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(129, 134, 103, 22);
		contentPane.add(textArea_1_1);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
			}
			
		});
		btnNewButton_1.setBounds(488, 149, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
