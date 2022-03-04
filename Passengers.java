import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Passengers {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField TelephoneNumber1;
	private JTextField Surname1;
	private JTextField EmailAddress1;
	private JTextField FirstName1;
	private JTextField textField_2;
	private JComboBox DepartingSeat1;
	private JComboBox NumberOfBags1;
	private JComboBox ReturningSeat1;

	private String maxBags[] = {"Select Baggage Amount","0","1","2","3","4","5","6","7","8","9"};
	private String departSeat[] = {"Select a Seat","1A","6A","11A"};
	private String returnSeat[] = {"Select a Seat","1A","6A","11A"};

	private int telenum;
	private String bagSelected;
	private String departingSeat;
	private String returningSeat;
	private int passengers = 2;

	/**
	 * Launch the application.
	 */
//	Code from here are based on the Window Builder (design for UI).
	public static void main(String[] args) {
//		For loop to make this program appear 3 times.
		for (int i= 0;i<3; i++) {
		EventQueue.invokeLater(new Runnable() { 
			
			public void run() {
				try {
					Passengers window = new Passengers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
	}

	/**
	 * Create the application.
	 */
	public Passengers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	This is a Absolute Layout frame which allows to have freedom when positioning components but also can cause an issue in the future if components are resized later on.
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 1300, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//		Header Label located at the top to show the home page.
		JLabel HeaderLabel = new JLabel("Passenger");
		HeaderLabel.setForeground(Color.BLACK);
		HeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HeaderLabel.setFont(new Font("Calibri", Font.PLAIN, 40));
		HeaderLabel.setBounds(0, 19, 1284, 38);
		frame.getContentPane().add(HeaderLabel);

//		Description text located at the top below the Header Label.
		JLabel Description = new JLabel("Please fill in your information to generate your ticket number. If failed to do so you will not proceed forward.");
		Description.setForeground(Color.BLACK);
		Description.setHorizontalAlignment(SwingConstants.CENTER);
		Description.setFont(new Font("Calibri", Font.PLAIN, 18));
		Description.setBounds(0, 53, 1284, 42);
		frame.getContentPane().add(Description);

//		Logo image located at the top left corner
		JLabel Logo = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Brunel University Logo.jpg"));
		Logo.setIcon(img);
		Logo.setBounds(10, 10, 94, 100);
		frame.getContentPane().add(Logo);

//		Label for First Name.
		JLabel FirstName = new JLabel("First Name :");
		FirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		FirstName.setFont(new Font("Calibri", Font.BOLD, 18));
		FirstName.setBounds(10, 150, 160, 30);
		frame.getContentPane().add(FirstName);
//		TestField to allow users to enter their First Name.
		FirstName1 = new JTextField();
		FirstName1.setHorizontalAlignment(SwingConstants.LEFT);
		FirstName1.setFont(new Font("Calibri", Font.PLAIN, 18));
		FirstName1.setColumns(10);
		FirstName1.setBounds(180, 150, 300, 30);
		frame.getContentPane().add(FirstName1);

//		Label for Surname.
		JLabel Surname = new JLabel("Surname :");
		Surname.setHorizontalAlignment(SwingConstants.RIGHT);
		Surname.setFont(new Font("Calibri", Font.BOLD, 18));
		Surname.setBounds(804, 150, 160, 30);
		frame.getContentPane().add(Surname);
//		TestField to allow users to enter their Surname.
		Surname1 = new JTextField();
		Surname1.setHorizontalAlignment(SwingConstants.LEFT);
		Surname1.setFont(new Font("Calibri", Font.PLAIN, 18));
		Surname1.setColumns(10);
		Surname1.setBounds(974, 150, 300, 30);
		frame.getContentPane().add(Surname1);		

//		Label for Date of Birth.
		JLabel DateOfBirth = new JLabel("Date of Birth :");
		DateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		DateOfBirth.setFont(new Font("Calibri", Font.BOLD, 18));
		DateOfBirth.setBounds(10, 270, 160, 30);
		frame.getContentPane().add(DateOfBirth);
//		JDateChooser to allow users to select their Date of Birth from a calendar.
		JDateChooser DateOfBirth1 = new JDateChooser();
		DateOfBirth1.setFont(new Font("Calibri", Font.PLAIN, 18));
		DateOfBirth1.setBounds(180, 270, 300, 30);
		frame.getContentPane().add(DateOfBirth1);

//		Label for Telephone Number.
		JLabel TelephoneNumber = new JLabel("Telephone Number :");
		TelephoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		TelephoneNumber.setFont(new Font("Calibri", Font.BOLD, 18));
		TelephoneNumber.setBounds(804, 270, 160, 30);
		frame.getContentPane().add(TelephoneNumber);
//		TestField to allow users to enter their Telephone Number.
		TelephoneNumber1 = new JTextField();
		TelephoneNumber1.setHorizontalAlignment(SwingConstants.LEFT);
		TelephoneNumber1.setFont(new Font("Calibri", Font.PLAIN, 18));
		TelephoneNumber1.setColumns(10);
		TelephoneNumber1.setBounds(974, 270, 300, 30);
		frame.getContentPane().add(TelephoneNumber1);

//		Label for Email Address.
		JLabel EmailAddress = new JLabel("Email Address :");
		EmailAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		EmailAddress.setFont(new Font("Calibri", Font.BOLD, 18));
		EmailAddress.setBounds(10, 390, 160, 30);
		frame.getContentPane().add(EmailAddress);
//		TestField to allow users to enter their Email Address.
		EmailAddress1 = new JTextField();
		EmailAddress1.setHorizontalAlignment(SwingConstants.LEFT);
		EmailAddress1.setFont(new Font("Calibri", Font.PLAIN, 18));
		EmailAddress1.setColumns(10);
		EmailAddress1.setBounds(180, 390, 300, 30);
		frame.getContentPane().add(EmailAddress1);		

//		Label for Number of Bags.
		JLabel NumberOfBags = new JLabel("Number of Bags :");
		NumberOfBags.setHorizontalAlignment(SwingConstants.RIGHT);
		NumberOfBags.setFont(new Font("Calibri", Font.BOLD, 18));
		NumberOfBags.setBounds(804, 390, 160, 30);
		frame.getContentPane().add(NumberOfBags);
//		JComboBox to allow users to enter their Number of Bags.
		JComboBox comboBox;
		NumberOfBags1 = new JComboBox();
		NumberOfBags1.setEditable(true);
		NumberOfBags1.setFont(new Font("Calibri", Font.PLAIN, 18));
		NumberOfBags1.setBounds(974, 390, 300, 30);
		NumberOfBags1.addItem ("Select Baggage Amount");
		NumberOfBags1.addItem ("0");
		NumberOfBags1.addItem ("1");
		NumberOfBags1.addItem ("2");
		NumberOfBags1.addItem ("3");
		NumberOfBags1.addItem ("4");
		NumberOfBags1.addItem ("5");
		NumberOfBags1.addItem ("6");
		NumberOfBags1.addItem ("7");
		NumberOfBags1.addItem ("8");
		NumberOfBags1.addItem ("9");
		frame.getContentPane().add(NumberOfBags1);

//		Label for Departing Seat.
		JLabel DepartingSeat = new JLabel("Departing Seat :");
		DepartingSeat.setHorizontalAlignment(SwingConstants.RIGHT);
		DepartingSeat.setFont(new Font("Calibri", Font.BOLD, 18));
		DepartingSeat.setBounds(10, 510, 160, 30);
		frame.getContentPane().add(DepartingSeat);
//		JComoBox to allow users to enter their Departing Seat.
		JComboBox comboBox_1;
		DepartingSeat1 = new JComboBox();
		DepartingSeat1.setEditable(true);
		DepartingSeat1.setFont(new Font("Calibri", Font.PLAIN, 18));
		DepartingSeat1.setBounds(180, 510, 300, 30);
		DepartingSeat1.addItem ("Select a Seat");
		DepartingSeat1.addItem ("1A");
		DepartingSeat1.addItem ("6A");
		DepartingSeat1.addItem ("11A");
		frame.getContentPane().add(DepartingSeat1);		

//		Label for Returning Seat.
		JLabel ReturningSeat = new JLabel("Returning Seat :");
		ReturningSeat.setHorizontalAlignment(SwingConstants.RIGHT);
		ReturningSeat.setFont(new Font("Calibri", Font.BOLD, 18));
		ReturningSeat.setBounds(804, 510, 160, 30);
		frame.getContentPane().add(ReturningSeat);
//		JComboBox to allow users to enter their Returning Seat.
		JComboBox comboBox1;
		ReturningSeat1 = new JComboBox();
		ReturningSeat1.setEditable(true);
		ReturningSeat1.setFont(new Font("Calibri", Font.PLAIN, 18));
		ReturningSeat1.setBounds(974, 510, 300, 30);
		ReturningSeat1.addItem ("Select a Seat");
		ReturningSeat1.addItem ("1A");
		ReturningSeat1.addItem ("6A");
		ReturningSeat1.addItem ("11A");
		frame.getContentPane().add(ReturningSeat1);

//		JLabel for the bottom of the page.
		JLabel BottomLabel = new JLabel("© Brunel City London Airport");
		BottomLabel.setForeground(Color.BLACK);
		BottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BottomLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		BottomLabel.setBounds(0, 708, 1284, 42);
		frame.getContentPane().add(BottomLabel);

//		JButton for the Submit.
//	 	USER INTERFACE CODE FINISHES HERE!
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try 
				{
					String teleno = TelephoneNumber1.getText();
					bagSelected = (String) NumberOfBags1.getSelectedItem();
					departingSeat = (String) DepartingSeat1.getSelectedItem();
					returningSeat = (String) ReturningSeat1.getSelectedItem();
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//					String dateOfBirth = dateFormat.format(DateOfBirth1.getDate().toString());
					boolean passed = checkdataentered(FirstName1.getText(),Surname1.getText(),DateOfBirth1,EmailAddress1.getText(),teleno,bagSelected, departingSeat, returningSeat);
					if(passed == true)
					{

							Random r = new Random();

// 		This code below is for Ticket Number only if the user has entered all the correct details then a Ticket Number will be generated.
							long number = r.longs(10000000,100000000).findFirst().getAsLong();	
							JOptionPane.showMessageDialog(null,"Ticket Number: "+number);
							frame.setVisible(false);
							if(passengers-1 != 0) {
								passengers-=1;
								initialize();
							} else {
								frame.dispose();
							}
					}
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,"Please make sure all the data is entered");
				}
			}
		}
				);
		Submit.setFont(new Font("Calibri", Font.BOLD, 24));
		Submit.setBounds(550, 600, 200, 50);
		frame.getContentPane().add(Submit);

	}

//	Validation that if all entered details meets the required format.
	public boolean checkdataentered(String firstName, String surname, JDateChooser dateOfBirth1, String emailAddress, String telephoneNumber, String numberofBags, String departingSeats, String returningSeats)
	{

		boolean pass = true;

//		If user does not fill out First Name text field then a error message will appear.
		if(firstName.isBlank())
		{
			JOptionPane.showMessageDialog(null,"Please enter your First Name.");
			pass = false;
		}
//		If user does not fill out a valid First Name that should be at least 3 characters long then a warning message will appear.
		else if (!firstName.matches("[a-z A-Z]{3,}"))
		{
			JOptionPane.showMessageDialog(null,"Please enter a valid First Name.");
			pass = false;
		}

//			If user does not fill out Surname text field then a error message will appear.	
			else
				if(surname.isBlank())
			{
				JOptionPane.showMessageDialog(null,"Please enter your Surname.");
				pass = false;
			}
//			If user does not fill out a valid Surname that should be at least 3 characters long then a warning message will appear.
			else if (!surname.matches("[a-z A-Z]{3,}"))
			{
				JOptionPane.showMessageDialog(null,"Please enter a valid Surname.");
				pass = false;
			}

//			If user does not select an Date of Birth then a error message will appear.
			else 
				if (dateOfBirth1.getDate() == null)
			{
				System.out.println(dateOfBirth1.getDate());
				JOptionPane.showMessageDialog(null," Please select a Date Of Birth.");
				pass = false;
			}
//			If user enters a future date for Date of Birth then it will not work and a warning message will appear.
			else if (dateOfBirth1.getDate().after(new Date()))
			{
				System.out.println(dateOfBirth1.getDate());
				JOptionPane.showMessageDialog(null," Future dates cannot be accepted.");
				pass = false;
			}

//			If user does not enter a Telephone Number then a error message will appear.
			else
				if(telephoneNumber.isBlank())
				{
					JOptionPane.showMessageDialog(null,"Please enter your Telephone Number.");
					pass = false;
				}
//			If user enter a Telephone Number which is more or less then 11 digits then a warning message will appear.		
				else if (!telephoneNumber.matches("[0-9]{11}"))
				{
					JOptionPane.showMessageDialog(null,"Please enter 11 digits Telephone Number.");
					pass = false;
				}

//			If user does not fill out Email Address text field then a error message will appear.
				else
					if(emailAddress.isBlank())
					{
						JOptionPane.showMessageDialog(null,"Please enter your Email Address.");
						pass = false;
					}		
//			If user does not fill out a valid Email Address that includes '@' then a warning message will appear.
					else if (!emailAddress.matches("[a-z A-Z 0-9.!#$'*+/=?{|}~^-]+@[a-z A-Z 0-9.-]+$"))
					{
						JOptionPane.showMessageDialog(null," Please enter a valid Email Address that includes '@'.");
						pass = false;
					}

//			If user does not select Number of Bag then a error message will appear.			
					else 
						if(numberofBags =="Select Baggage Amount")
						{
							JOptionPane.showMessageDialog(null,"Please select amount of baggage.");
							pass = false;
						}
//			If user enters different amount of bags apart from 0 to 9 then a warning message will appear. 
						else if (!numberofBags.matches("[0-9]"))
						{
							JOptionPane.showMessageDialog(null," Please enter a valid amount of baggage from 0-9.");
							pass = false;
						}

//			If user does not select a Departing Seat then a error message will appear.			
						else 
							if(departingSeats =="Select a Seat")
							{
								JOptionPane.showMessageDialog(null,"Please select a seat for Departing Seat.");
								pass = false;
							}
//			If user enters a different seat number for Departing Seat from the one provided then a warning error will appear.
							else if (!departingSeats.matches("[1-6-11]+[A]"))
							{
								JOptionPane.showMessageDialog(null," Please select a valid seat provided for Departing Seat.");
								pass = false;
							}

//			If user does not select a Returning Seat then a error message will appear.		
							else 
								if (returningSeats =="Select a Seat")
							{
								JOptionPane.showMessageDialog(null,"Please select a seat for Returning Seat.");
								pass = false;
							}
//			If user enters a different seat number for Returning Seat from the one provided then a warning error will appear.
							else if (!returningSeats.matches("[1-6-11]+[A]"))
							{
								JOptionPane.showMessageDialog(null," Please select a valid seat provided for Returning Seat.");
								pass = false;
							}

		return pass;
	}

	private boolean dateOfBirth1() {
		return false;
	}
}
