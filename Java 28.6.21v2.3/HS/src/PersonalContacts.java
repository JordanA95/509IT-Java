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
	private JTable personalcontactstable;
	private JTable PersonalContactsTable;

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
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(9, 92, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea personalfnametxb = new JTextArea();
		personalfnametxb.setBounds(68, 92, 144, 22);
		contentPane.add(personalfnametxb);
		
		JTextArea personallnametxb = new JTextArea();
		personallnametxb.setBounds(68, 117, 144, 22);
		contentPane.add(personallnametxb);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setBounds(11, 122, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Personal Telephone:");
		lblNewLabel_1_3.setBounds(9, 147, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JTextArea personalphonetxb = new JTextArea();
		personalphonetxb.setBounds(109, 142, 103, 22);
		contentPane.add(personalphonetxb);
		
		JTextArea personalemailtxb = new JTextArea();
		personalemailtxb.setBounds(38, 167, 174, 22);
		contentPane.add(personalemailtxb);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(9, 172, 38, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Postcode:");
		lblNewLabel_1_2_1.setBounds(241, 172, 56, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JTextArea personalpostcodetxb = new JTextArea();
		personalpostcodetxb.setBounds(300, 167, 180, 22);
		contentPane.add(personalpostcodetxb);
		
		JTextArea personalcitytxb = new JTextArea();
		personalcitytxb.setBounds(250, 142, 230, 22);
		contentPane.add(personalcitytxb);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("City:");
		lblNewLabel_1_3_1.setBounds(223, 144, 29, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address Line 2:");
		lblNewLabel_1_1_1.setBounds(225, 119, 74, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JTextArea personaladdrline2txb = new JTextArea();
		personaladdrline2txb.setBounds(300, 117, 180, 22);
		contentPane.add(personaladdrline2txb);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address Line 1:");
		lblNewLabel_1_4.setBounds(223, 89, 74, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JTextArea personaladdrline1txb = new JTextArea();
		personaladdrline1txb.setBounds(300, 87, 180, 22);
		contentPane.add(personaladdrline1txb);
		
		JButton personalbackbtn = new JButton("Back");
		personalbackbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		personalbackbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		personalbackbtn.setBounds(0, 0, 64, 23);
		contentPane.add(personalbackbtn);
		dbConn d=new dbConn();
		
		dbConn D=new dbConn();
		JButton personalupdatebtn = new JButton("Update");
		personalupdatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String f=personalfnametxb.getText();
				String l=personallnametxb.getText();
				String p=personalphonetxb.getText();
				String em=personalemailtxb.getText();
				String addr1=personaladdrline1txb.getText();
				String addr2=personaladdrline2txb.getText();
				String city=personalcitytxb.getText();
				String postcode=personalpostcodetxb.getText();
				String perphone=personalphonetxb.getText();
				String id=PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(), 0).toString();
				D.UpdatePersonal(f, l, p, em, addr1, addr2, city, postcode, perphone, id);
				PersonalContactsTable.setModel(DbUtils.resultSetToTableModel(D.GetAllPersonal()));
			}
			
		});
		personalupdatebtn.setBounds(490, 87, 109, 23);
		contentPane.add(personalupdatebtn);
		
		JButton personalnewbtn = new JButton("Add New");
		personalnewbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String f=personalfnametxb.getText();
				String l=personallnametxb.getText();
				String em=personalemailtxb.getText();
				String addr1=personaladdrline1txb.getText();
				String addr2=personaladdrline2txb.getText();
				String city=personalcitytxb.getText();
				String postcode=personalpostcodetxb.getText();
				String perphone=personalphonetxb.getText();
			    D.AddPersonal(f, l, em, addr1, addr2, city, postcode, perphone);
			    PersonalContactsTable.setModel(DbUtils.resultSetToTableModel(D.GetAllPersonal()));
			}
		});
		personalnewbtn.setBounds(490, 56, 109, 23);
		contentPane.add(personalnewbtn);
		
		JButton personaldeletebtn = new JButton("Delete");
		personaldeletebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(), 0).toString();
				D.DeletePersonal(id);
				PersonalContactsTable.setModel(DbUtils.resultSetToTableModel(D.GetAllPersonal()));
			}
		});
		personaldeletebtn.setBounds(490, 121, 109, 23);
		contentPane.add(personaldeletebtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		scrollPane.setBounds(31, 200, 568, 165);
		contentPane.add(scrollPane);
		
		PersonalContactsTable = new JTable();
		PersonalContactsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				personalfnametxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),1).toString());
				personallnametxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),2).toString());
				personalphonetxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),3).toString());
				personalemailtxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),4).toString());
				personaladdrline1txb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),5).toString());
				personaladdrline2txb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),6).toString());
				personalcitytxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),7).toString());
				personalpostcodetxb.setText(PersonalContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(),8).toString());
			}
		});
		scrollPane.setViewportView(PersonalContactsTable);
		
		JButton refreshbtn = new JButton("Refresh Table");
		refreshbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonalContactsTable.setModel(DbUtils.resultSetToTableModel(D.GetAllPersonal()));
			}
		});
		refreshbtn.setBounds(490, 11, 109, 23);
		contentPane.add(refreshbtn);
		
	}
}
