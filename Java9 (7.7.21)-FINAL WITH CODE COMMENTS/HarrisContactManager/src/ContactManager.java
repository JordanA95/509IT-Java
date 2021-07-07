import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setBounds(100, 100, 597, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*When Personal Contact button clicked, a new PersonalCont is initiated and set to visible.*/
		JButton btnNewButton = new JButton("Personal Contact");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PersonalCont pc=new PersonalCont();
				pc.setVisible(true);
			}
		});
		btnNewButton.setBounds(88, 118, 140, 51);
		frame.getContentPane().add(btnNewButton);
		
		/*When Business Contact button clicked, a new BusinessCont is initiated and set to visible.*/
		JButton btnNewButton_1 = new JButton("Business Contact");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BusinessCont pc=new BusinessCont();
				pc.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(358, 118, 140, 51);
		frame.getContentPane().add(btnNewButton_1);
	}
}
