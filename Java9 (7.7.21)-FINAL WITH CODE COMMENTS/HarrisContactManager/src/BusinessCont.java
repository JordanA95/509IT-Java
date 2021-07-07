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
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BusinessCont extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton refreshbtn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField busaddresslineonetxb;
	private JTextField busemailtxb;
	private JTextField buslastnametxb;
	private JTextField busfirstnametxb;
	private JLabel lblNewLabel_3_1;
	private JTextField busaddresslinetwotxb;
	private JTextField buscitytxb;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JTextField buspostcodetxb;
	private JTextField busphonetxb;
	private JLabel lblNewLabel_3_4;
	private JLabel lblBusinessContacts;
	private JButton updateselectedbtn;
	private JButton saveselectedbtn;
	private JButton deleteselectedbtn;
	private JButton addnewbtn;
	private JButton savenewbtn;
	boolean updatemode=true;
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
		setBounds(100, 100, 715, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		
		/*Set Statuslbl text to -. Declare new JTable. Initiate the GetAllBusiness stored procedure. Initiate DbConn.*/
		JLabel Statuslbl = new JLabel("-");
		dbConn d=new dbConn();
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
		
		/*When a record is clicked in the table, populate the textboxes with the values of that record.*/
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				busfirstnametxb.setText(table.getValueAt(table.getSelectedRow(),1).toString());
				buslastnametxb.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				busemailtxb.setText(table.getValueAt(table.getSelectedRow(),3).toString());
				busaddresslineonetxb.setText(table.getValueAt(table.getSelectedRow(),4).toString());
				busaddresslinetwotxb.setText(table.getValueAt(table.getSelectedRow(),5).toString());
				buscitytxb.setText(table.getValueAt(table.getSelectedRow(),6).toString());
				buspostcodetxb.setText(table.getValueAt(table.getSelectedRow(),7).toString());
				busphonetxb.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		/*Declare refreshbtn button and Cancel button.*/
		refreshbtn = new JButton("Refresh");
		saveselectedbtn = new JButton("Cancel Updating");
		
		/*When Cancel button clicked, reset the textboxes.*/
		saveselectedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(true);
				saveselectedbtn.setEnabled(false);
				savenewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(true);
				refreshbtn.setEnabled(true);
			}
		});
		saveselectedbtn.setEnabled(false);
		deleteselectedbtn = new JButton("Delete Selected");
		addnewbtn = new JButton("Add New");
		savenewbtn = new JButton("Save");
		savenewbtn.setEnabled(false);
		updateselectedbtn = new JButton("Update Selected");
		
		/*When Refresh button clicked, use the GetAllBusiness stored procedure to repopulate the table with the values in the database.*/
		refreshbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
			}
		});
		
		lblNewLabel = new JLabel("First Name:");
		
		lblNewLabel_1 = new JLabel("Last Name:");
		
		lblNewLabel_2 = new JLabel("Email:");
		
		lblNewLabel_3 = new JLabel("Address Line 1:");
		
		/*Declare textboxes and set them to disabled. Declare lables and their text value.*/
		busaddresslineonetxb = new JTextField();
		busaddresslineonetxb.setColumns(10);
		busaddresslineonetxb.setEnabled(false);
		
		busemailtxb = new JTextField();
		busemailtxb.setColumns(10);
		busemailtxb.setEnabled(false);
		
		buslastnametxb = new JTextField();
		buslastnametxb.setColumns(10);
		buslastnametxb.setEnabled(false);
		
		busfirstnametxb = new JTextField();
		busfirstnametxb.setColumns(10);
		busfirstnametxb.setEnabled(false);
		
		lblNewLabel_3_1 = new JLabel("Address Line 2:");
		
		busaddresslinetwotxb = new JTextField();
		busaddresslinetwotxb.setColumns(10);
		busaddresslinetwotxb.setEnabled(false);
		
		buscitytxb = new JTextField();
		buscitytxb.setColumns(10);
		buscitytxb.setEnabled(false);
		
		lblNewLabel_3_2 = new JLabel("City:");
		
		lblNewLabel_3_3 = new JLabel("Postcode:");
		
		buspostcodetxb = new JTextField();
		buspostcodetxb.setColumns(10);
		buspostcodetxb.setEnabled(false);
		
		busphonetxb = new JTextField();
		busphonetxb.setColumns(10);
		busphonetxb.setEnabled(false);
		
		lblNewLabel_3_4 = new JLabel("Business Phone:");
		
		lblBusinessContacts = new JLabel("Harris & Sons Ltd. - Business Contacts");
		lblBusinessContacts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		/*When updateselectedbtn button clicked, set the textboxes enabled and buttons enabled ready for updating. Set Statuslbl text to Update Contact.*/
		updateselectedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				busfirstnametxb.setEnabled(true);
				buslastnametxb.setEnabled(true);
				busemailtxb.setEnabled(true);
				busaddresslineonetxb.setEnabled(true);
				busaddresslinetwotxb.setEnabled(true);
				buscitytxb.setEnabled(true);
				buspostcodetxb.setEnabled(true);
				busphonetxb.setEnabled(true);
				saveselectedbtn.setEnabled(true);
				updateselectedbtn.setEnabled(false);
				addnewbtn.setEnabled(false);
				savenewbtn.setEnabled(true);
				deleteselectedbtn.setEnabled(false);
				refreshbtn.setEnabled(false);
				updatemode=true;
				Statuslbl.setText("Update Contact");
			}
		});
		
		/*Button to delete a contact by initiating the DeleteBusiness stored procedure, then updating the table. Empty all textbox values.*/
		deleteselectedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=table.getValueAt(table.getSelectedRow(), 0).toString();
				d.DeleteBusiness(id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				busfirstnametxb.setText("");
				buslastnametxb.setText("");
				busemailtxb.setText("");
				busaddresslineonetxb.setText("");
				busaddresslinetwotxb.setText("");
				buscitytxb.setText("");
				buspostcodetxb.setText("");
				busphonetxb.setText("");
			}
		});
		
		/*Add New button clicked sets the form up for adding a new contact by enabling the textboxes and relevant buttons. update mode set to false as it is setting up to add a contact, not update.*/
		addnewbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				savenewbtn.setEnabled(true);
				busfirstnametxb.setEnabled(true);
				buslastnametxb.setEnabled(true);
				busemailtxb.setEnabled(true);
				busaddresslineonetxb.setEnabled(true);
				busaddresslinetwotxb.setEnabled(true);
				buscitytxb.setEnabled(true);
				buspostcodetxb.setEnabled(true);
				busphonetxb.setEnabled(true);
				updateselectedbtn.setEnabled(false);
				saveselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(false);
				refreshbtn.setEnabled(false);
				updatemode=false;
				Statuslbl.setText("Add New Contact");
			}
		});
		/*Set the textboxes to enabled and set up the buttons for adding a new contact. Set Statuslbl to Add New Contact.*/
		addnewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				busfirstnametxb.setEnabled(true);
				buslastnametxb.setEnabled(true);
				busemailtxb.setEnabled(true);
				busaddresslineonetxb.setEnabled(true);
				busaddresslinetwotxb.setEnabled(true);
				buscitytxb.setEnabled(true);
				buspostcodetxb.setEnabled(true);
				busphonetxb.setEnabled(true);
				updateselectedbtn.setEnabled(false);
				saveselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(false);
				refreshbtn.setEnabled(false);
				updatemode=false;
				Statuslbl.setText("Add New Contact");
			}
		});
		
		savenewbtn.addMouseListener(new MouseAdapter() {
			@Override
			
			/*When savenewbtn button clicked, if updatemode is true, then the form will be set up for updating and UpdateBusiness stored procedure is run.*/
			public void mouseClicked(MouseEvent e) {
				if(!(busfirstnametxb.getText().isEmpty()|| buslastnametxb.getText().isEmpty() || busemailtxb.getText().isEmpty() || busaddresslineonetxb.getText().isEmpty() || busaddresslinetwotxb.getText().isEmpty() || buscitytxb.getText().isEmpty() || buspostcodetxb.getText().isEmpty() || busphonetxb.getText().isEmpty()))
				{
				/*If updatemode is true, then the form will be set up to update an existing contact, and UpdateBusiness stored procedure is run.*/
				if (updatemode == true)
				{
				String f=busfirstnametxb.getText();
				String l=buslastnametxb.getText();
				String em=busemailtxb.getText();
				String addr1=busaddresslineonetxb.getText();
				String addr2=busaddresslinetwotxb.getText();
				String city=buscitytxb.getText();
				String postcode=buspostcodetxb.getText();
				String bustel=busphonetxb.getText();
				String id=table.getValueAt(table.getSelectedRow(), 0).toString();
				System.out.println("Update");
				d.UpdateBusiness(f, l, em, addr1, addr2, city, postcode, bustel, id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				}
				/*If updatemode is false, then the form will be set up to add a new contact, and AddBusiness stored procedure is run.*/
				else
				{
					String f=busfirstnametxb.getText();
					String l=buslastnametxb.getText();
					String em=busemailtxb.getText();
					String addr1=busaddresslineonetxb.getText();
					String addr2=busaddresslinetwotxb.getText();
					String city=buscitytxb.getText();
					String postcode=buspostcodetxb.getText();
					String bustel=busphonetxb.getText();
					d.AddBusiness(f, l, em, addr1, addr2, city, postcode, bustel);
					table.setModel(DbUtils.resultSetToTableModel(d.GetAllBusiness()));
				}
				/*After AddBusiness or UpdateBusiness stored procedure is run, all textboxes are cleared and disabled. All buttons enabled are reset.*/
				updateselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(true);
				saveselectedbtn.setEnabled(false);
				savenewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(true);
				refreshbtn.setEnabled(true);
				busfirstnametxb.setText("");
				buslastnametxb.setText("");
				busemailtxb.setText("");
				busaddresslineonetxb.setText("");
				busaddresslinetwotxb.setText("");
				buscitytxb.setText("");
				buspostcodetxb.setText("");
				busphonetxb.setText("");
				busfirstnametxb.setEnabled(false);
				buslastnametxb.setEnabled(false);
				busemailtxb.setEnabled(false);
				busaddresslineonetxb.setEnabled(false);
				busaddresslinetwotxb.setEnabled(false);
				buscitytxb.setEnabled(false);
				buspostcodetxb.setEnabled(false);
				busphonetxb.setEnabled(false);
				}
				/*If a textbox is empty, a message will display informing the user that they must populate all textboxes before adding or updating a contact.*/
				else JOptionPane.showMessageDialog(null, "One or more contact details are missing, please fill out all textboxes");
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buslastnametxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(buscitytxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(saveselectedbtn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(savenewbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(busemailtxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addComponent(busaddresslineonetxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buspostcodetxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(busphonetxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(deleteselectedbtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(refreshbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
					.addGap(52))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(162)
							.addComponent(lblBusinessContacts, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Statuslbl, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(busfirstnametxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(busaddresslinetwotxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(updateselectedbtn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addnewbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBusinessContacts, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Statuslbl)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(busfirstnametxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_1))
						.addComponent(busaddresslinetwotxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(updateselectedbtn)
								.addComponent(addnewbtn))))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(buslastnametxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_2))
						.addComponent(buscitytxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(saveselectedbtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(savenewbtn)))
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_2))
								.addComponent(busemailtxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_3))
								.addComponent(busaddresslineonetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_3)
							.addGap(17)
							.addComponent(lblNewLabel_3_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(buspostcodetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(busphonetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(deleteselectedbtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(refreshbtn)))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(1))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
