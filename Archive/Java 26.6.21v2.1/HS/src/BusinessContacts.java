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
		setBounds(100, 100, 631, 417);
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
		
		JButton businessbackbtn = new JButton("Back");
		businessbackbtn.setBounds(0, 0, 64, 23);
		contentPane.add(businessbackbtn);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(10, 85, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea businessfnametxb = new JTextArea();
		businessfnametxb.setBounds(69, 85, 144, 22);
		contentPane.add(businessfnametxb);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setBounds(12, 115, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JTextArea businesslnametxb = new JTextArea();
		businesslnametxb.setBounds(69, 110, 144, 22);
		contentPane.add(businesslnametxb);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(10, 165, 38, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JTextArea businessemailtxb = new JTextArea();
		businessemailtxb.setBounds(39, 160, 174, 22);
		contentPane.add(businessemailtxb);
		
		JLabel lblNewLabel_1_3 = new JLabel("Business Telephone:");
		lblNewLabel_1_3.setBounds(10, 140, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JTextArea businessphonetxb = new JTextArea();
		businessphonetxb.setBounds(110, 135, 103, 22);
		contentPane.add(businessphonetxb);
		
		dbConn D=new dbConn();
		JButton businessupdatebtn = new JButton("Refresh/Update");
		businessupdatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String f=businessfnametxb.getText();
				String l=businesslnametxb.getText();
				String p=businessphonetxb.getText();
				String em=businessemailtxb.getText();
				String addr1=businessaddrline1.getText();
				String addr2=businessaddrline2.getText();
				String city=businesscitytxb.getText();
				String postcode=businesspostcodetxb.getText();
				String id=BusinessContactsTable.getValueAt(PersonalContactsTable.getSelectedRow(), 0).toString();
				d.UpdateBusines(f, l, p, em, addr1, addr2, city, postcode, id);
				BusinessContactsTable.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
			}
			
		});
		businessupdatebtn.setBounds(491, 94, 109, 23);
		contentPane.add(businessupdatebtn);
		
		JButton businessaddnewbtn = new JButton("Add New");
		businessaddnewbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String f=businessfnametxb.getText();
				String l=businesslnametxb.getText();
				String p=businessphonetxb.getText();
				String em=businessemailtxb.getText();
				String addr1=businessaddrline1.getText();
				String addr2=businessaddrline2.getText();
				String city=businesscitytxb.getText();
				String postcode=businesspostcodetxb.getText();
			    d.InsertPersonal(f, l, em, addr1, addr2, city, postcode, busphone, id);
				BusinessContactsTable.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
			}
		});
		businessaddnewbtn.setBounds(491, 65, 109, 23);
		contentPane.add(businessaddnewbtn);
		
		JButton businessdeletebtn = new JButton("Delete");
		businessdeletebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(), 0).toString();
				d.DeleteBusiness(id);
				BusinessContactsTable.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
			}
		});
		businessdeletebtn.setBounds(491, 124, 109, 23);
		contentPane.add(businessdeletebtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 190, 590, 177);
		contentPane.add(scrollPane);
		
		BusinessContactsTable = new JTable();
		BusinessContactsTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				businessfnametxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),1).toString());
				businesslnametxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),2).toString());
				businessphonetxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),3).toString());
				businessemailtxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),4).toString());
				businessaddrline1txb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),5).toString());
				businessaddrline2txb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),6).toString());
				businesscitytxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),7).toString());
				businesspostcodetxb.setText(BusinessContactsTable.getValueAt(BusinessContactsTable.getSelectedRow(),8).toString());

			}
		});
		scrollPane.setViewportView(BusinessContactsTable);
		
		JLabel lblNewLabel_1_4 = new JLabel("Address Line 1:");
		lblNewLabel_1_4.setBounds(224, 82, 74, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JTextArea businessaddrline1txb = new JTextArea();
		businessaddrline1txb.setBounds(301, 80, 180, 22);
		contentPane.add(businessaddrline1txb);
		
		JTextArea businessaddrline2txb = new JTextArea();
		businessaddrline2txb.setBounds(301, 110, 180, 22);
		contentPane.add(businessaddrline2txb);
		
		JTextArea businesscitytxb = new JTextArea();
		businesscitytxb.setBounds(251, 135, 230, 22);
		contentPane.add(businesscitytxb);
		
		JTextArea businesspostcodetxb = new JTextArea();
		businesspostcodetxb.setBounds(301, 160, 180, 22);
		contentPane.add(businesspostcodetxb);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Postcode:");
		lblNewLabel_1_2_1.setBounds(242, 165, 56, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("City:");
		lblNewLabel_1_3_1.setBounds(224, 137, 29, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address Line 2:");
		lblNewLabel_1_1_1.setBounds(226, 112, 74, 14);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
