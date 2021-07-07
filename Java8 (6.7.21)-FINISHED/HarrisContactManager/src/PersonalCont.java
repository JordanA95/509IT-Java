import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PersonalCont extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField perfirstnametxb;
	private JTextField perlastnametxb;
	private JTextField peremailtxb;
	private JTextField peraddresslineonetxb;
	private JTextField peraddresslinetwotxb;
	private JTextField percitytxb;
	private JTextField perpostcodetxb;
	private JTextField perphonetxb;
	boolean updatemode=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalCont frame = new PersonalCont();
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
	public PersonalCont() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 390);
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
		
		JLabel Statuslbl = new JLabel("-");
		dbConn d=new dbConn();
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				perfirstnametxb.setText(table.getValueAt(table.getSelectedRow(),1).toString());
				perlastnametxb.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				peremailtxb.setText(table.getValueAt(table.getSelectedRow(),3).toString());
				peraddresslineonetxb.setText(table.getValueAt(table.getSelectedRow(),4).toString());
				peraddresslinetwotxb.setText(table.getValueAt(table.getSelectedRow(),5).toString());
				percitytxb.setText(table.getValueAt(table.getSelectedRow(),6).toString());
				perpostcodetxb.setText(table.getValueAt(table.getSelectedRow(),7).toString());
				perphonetxb.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton refreshbtn = new JButton("Refresh");
		JButton updateselectedbtn = new JButton("Update Selected");
		JButton addnewbtn = new JButton("Add New");
		JButton savenewbtn = new JButton("Save");
		savenewbtn.setEnabled(false);
		JButton deleteselectedbtn = new JButton("Delete Selected");
		JButton saveselectedbtn = new JButton("Cancel Updating");
		
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
		
		refreshbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
			}
		});
		
		perfirstnametxb = new JTextField();
		perfirstnametxb.setColumns(10);
		perfirstnametxb.setEnabled(false);
		
		perlastnametxb = new JTextField();
		perlastnametxb.setColumns(10);
		perlastnametxb.setEnabled(false);
		
		peremailtxb = new JTextField();
		peremailtxb.setColumns(10);
		peremailtxb.setEnabled(false);
		
		peraddresslineonetxb = new JTextField();
		peraddresslineonetxb.setColumns(10);
		peraddresslineonetxb.setEnabled(false);
		
		peraddresslinetwotxb = new JTextField();
		peraddresslinetwotxb.setColumns(10);
		peraddresslinetwotxb.setEnabled(false);
		
		percitytxb = new JTextField();
		percitytxb.setColumns(10);
		percitytxb.setEnabled(false);
		
		perpostcodetxb = new JTextField();
		perpostcodetxb.setColumns(10);
		perpostcodetxb.setEnabled(false);
		
		perphonetxb = new JTextField();
		perphonetxb.setColumns(10);
		perphonetxb.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		
		JLabel lblNewLabel_3 = new JLabel("Address Line 1:");
		
		JLabel lblNewLabel_3_1 = new JLabel("Address Line 2:");
		
		JLabel lblNewLabel_3_2 = new JLabel("City:");
		
		JLabel lblNewLabel_3_3 = new JLabel("Postcode:");
		
		JLabel lblNewLabel_3_4 = new JLabel("Personal Phone:");
		
		JLabel lblPersonalContacts = new JLabel("Harris & Sons Ltd. - Personal Contacts");
		lblPersonalContacts.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		updateselectedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				perfirstnametxb.setEnabled(true);
				perlastnametxb.setEnabled(true);
				peremailtxb.setEnabled(true);
				peraddresslineonetxb.setEnabled(true);
				peraddresslinetwotxb.setEnabled(true);
				percitytxb.setEnabled(true);
				perpostcodetxb.setEnabled(true);
				perphonetxb.setEnabled(true);
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
		
		addnewbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				savenewbtn.setEnabled(true);
				perfirstnametxb.setEnabled(true);
				perlastnametxb.setEnabled(true);
				peremailtxb.setEnabled(true);
				peraddresslineonetxb.setEnabled(true);
				peraddresslinetwotxb.setEnabled(true);
				percitytxb.setEnabled(true);
				perpostcodetxb.setEnabled(true);
				perphonetxb.setEnabled(true);
				updateselectedbtn.setEnabled(false);
				saveselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(false);
				refreshbtn.setEnabled(false);
				updatemode=false;
				Statuslbl.setText("Add New Contact");
			}
		});
		addnewbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		savenewbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!(perfirstnametxb.getText().isEmpty()|| perlastnametxb.getText().isEmpty() || peremailtxb.getText().isEmpty() || peraddresslineonetxb.getText().isEmpty() || peraddresslinetwotxb.getText().isEmpty() || percitytxb.getText().isEmpty() || perpostcodetxb.getText().isEmpty() || perphonetxb.getText().isEmpty()))
				{
				if (updatemode == true)
				{
				String f=perfirstnametxb.getText();
				String l=perlastnametxb.getText();
				String em=peremailtxb.getText();
				String addr1=peraddresslineonetxb.getText();
				String addr2=peraddresslinetwotxb.getText();
				String city=percitytxb.getText();
				String postcode=perpostcodetxb.getText();
				String pertel=perphonetxb.getText();
				String id=table.getValueAt(table.getSelectedRow(), 0).toString();
				d.UpdatePersonal(f, l, em, addr1, addr2, city, postcode, pertel, id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				}
				else
				{
					String f=perfirstnametxb.getText();
					String l=perlastnametxb.getText();
					String em=peremailtxb.getText();
					String addr1=peraddresslineonetxb.getText();
					String addr2=peraddresslinetwotxb.getText();
					String city=percitytxb.getText();
					String postcode=perpostcodetxb.getText();
					String pertel=perphonetxb.getText();
					d.AddPersonal(f, l, em, addr1, addr2, city, postcode, pertel);
					table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				}
				updateselectedbtn.setEnabled(true);
				addnewbtn.setEnabled(true);
				saveselectedbtn.setEnabled(false);
				savenewbtn.setEnabled(false);
				deleteselectedbtn.setEnabled(true);
				refreshbtn.setEnabled(true);
				perfirstnametxb.setText("");
				perlastnametxb.setText("");
				peremailtxb.setText("");
				peraddresslineonetxb.setText("");
				peraddresslinetwotxb.setText("");
				percitytxb.setText("");
				perpostcodetxb.setText("");
				perphonetxb.setText("");
				perfirstnametxb.setEnabled(false);
				perlastnametxb.setEnabled(false);
				peremailtxb.setEnabled(false);
				peraddresslineonetxb.setEnabled(false);
				peraddresslinetwotxb.setEnabled(false);
				percitytxb.setEnabled(false);
				perpostcodetxb.setEnabled(false);
				perphonetxb.setEnabled(false);
				}
				else JOptionPane.showMessageDialog(null, "One or more contact details are missing, please fill out all textboxes");
			}
		});
		
		deleteselectedbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=table.getValueAt(table.getSelectedRow(), 0).toString();
				d.DeletePersonal(id);
				table.setModel(DbUtils.resultSetToTableModel(d.GetAllPersonal()));
				perfirstnametxb.setText("");
				perlastnametxb.setText("");
				peremailtxb.setText("");
				peraddresslineonetxb.setText("");
				peraddresslinetwotxb.setText("");
				percitytxb.setText("");
				perpostcodetxb.setText("");
				perphonetxb.setText("");
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addComponent(lblPersonalContacts, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Statuslbl, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addGap(87))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(46)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(perfirstnametxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(peraddresslinetwotxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(updateselectedbtn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(addnewbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(perlastnametxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(peremailtxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(peraddresslineonetxb, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(60)
									.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(35)
									.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(percitytxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(perpostcodetxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addComponent(perphonetxb, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(saveselectedbtn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(7))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(deleteselectedbtn, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(savenewbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(refreshbtn, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(Statuslbl)
						.addComponent(lblPersonalContacts, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(perfirstnametxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_1))
						.addComponent(peraddresslinetwotxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(updateselectedbtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(addnewbtn)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1)
							.addGap(17)
							.addComponent(lblNewLabel_2)
							.addGap(17)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(perlastnametxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(peremailtxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(peraddresslineonetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_3_2)
							.addGap(17)
							.addComponent(lblNewLabel_3_3)
							.addGap(20)
							.addComponent(lblNewLabel_3_4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(percitytxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(perpostcodetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(perphonetxb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(saveselectedbtn))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(savenewbtn)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(refreshbtn)
								.addComponent(deleteselectedbtn))))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
