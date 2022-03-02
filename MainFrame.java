import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	protected JTextField textField;
	protected JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Restaurant ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(300, 300, 1200, 700);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Passenger Full Name:");
		lblNewLabel.setBounds(924, 11, 136, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(1064, 6, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ticket Number:");
		lblNewLabel_1.setBounds(959, 38, 101, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(1064, 33, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Order");
		btnNewButton.setBounds(1077, 62, 117, 29);
		btnNewButton.addActionListener(new Algorithms());
		contentPane.add(btnNewButton);
		

		
		JLabel lblNewLabel_2 = new JLabel("Restaurant");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel_2.setBounds(512, 31, 176, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Breakfast");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel_3.setBounds(191, 157, 136, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lunch");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel_4.setBounds(556, 161, 87, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dinner");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 28));
		lblNewLabel_5.setBounds(895, 157, 101, 34);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Egg & Crumpets");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(182, 193, 160, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("BLT Sandwich");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(532, 198, 136, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Cheeseburger & Chips");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(835, 196, 222, 24);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Jam & Toast");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(200, 295, 123, 26);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Vegetarian Breakfast");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(159, 406, 205, 29);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Full English Breakfast");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(156, 521, 212, 29);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Chicken Bake");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(532, 295, 136, 26);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Fried Fish Fingers");
		lblNewLabel_13.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_13.setBounds(512, 406, 176, 29);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Omlette");
		lblNewLabel_14.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(561, 522, 77, 26);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Hand-Battered Cod");
		lblNewLabel_15.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_15.setBounds(852, 300, 188, 21);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Steak & Chips");
		lblNewLabel_16.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_16.setBounds(879, 409, 133, 26);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Buttermilk Chicken");
		lblNewLabel_17.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_17.setBounds(852, 524, 188, 26);
		contentPane.add(lblNewLabel_17);
		
		JButton btnNewButton_1 = new JButton("Previous");
		btnNewButton_1.setBounds(0, 645, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setBounds(1083, 645, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_18 = new JLabel("All meals are served with a soft drink, tea or coffee");
		lblNewLabel_18.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_18.setBounds(428, 650, 343, 16);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Scrambled eggs with toasted Crumpets.");
		lblNewLabel_19.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_19.setForeground(Color.BLUE);
		lblNewLabel_19.setBounds(163, 218, 198, 13);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Bacon, Lettuce and Tomato sandwich. Contains mayonnaise.");
		lblNewLabel_20.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_20.setForeground(Color.BLUE);
		lblNewLabel_20.setBounds(451, 216, 298, 16);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("30 day aged prime beef burger patty, Monterey Jack");
		lblNewLabel_21.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_21.setForeground(Color.BLUE);
		lblNewLabel_21.setBounds(818, 216, 256, 16);
		contentPane.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Chicken breast pieces in a creamy white sauce wrapped");
		lblNewLabel_22.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_22.setForeground(Color.BLUE);
		lblNewLabel_22.setBounds(463, 319, 273, 16);
		contentPane.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Deep-fried cod pieces served with mushy peas or baked");
		lblNewLabel_23.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_23.setForeground(Color.BLUE);
		lblNewLabel_23.setBounds(463, 434, 273, 16);
		contentPane.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("This healthy baked omelette with classic fry up ingredients.");
		lblNewLabel_24.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_24.setForeground(Color.BLUE);
		lblNewLabel_24.setBounds(455, 550, 290, 16);
		contentPane.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("This full English\nbreakfast could be topped up with baked beans.");
		lblNewLabel_25.setForeground(Color.BLUE);
		lblNewLabel_25.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_25.setBounds(102, 550, 319, 16);
		contentPane.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Mexican breakfast that’ll keep you going all morning.");
		lblNewLabel_26.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_26.setForeground(Color.BLUE);
		lblNewLabel_26.setBounds(131, 434, 261, 16);
		contentPane.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Nice and light Hartley’s Strawberry Jam and Toast.");
		lblNewLabel_27.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_27.setForeground(Color.BLUE);
		lblNewLabel_27.setBounds(137, 319, 250, 16);
		contentPane.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Triple-cooked chunky chips, tartare sauce, minted");
		lblNewLabel_28.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_28.setForeground(Color.BLUE);
		lblNewLabel_28.setBounds(821, 321, 250, 16);
		contentPane.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Ribeye 12 Oz Bursting with flavour, recommended");
		lblNewLabel_29.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_29.setForeground(Color.BLUE);
		lblNewLabel_29.setBounds(821, 436, 250, 16);
		contentPane.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("Boneless half chicken, sweetcorn purée, dauphinoise");
		lblNewLabel_30.setForeground(Color.BLUE);
		lblNewLabel_30.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_30.setBounds(815, 552, 261, 16);
		contentPane.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("Served with\nbutter on the side.");
		lblNewLabel_31.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_31.setForeground(Color.BLUE);
		lblNewLabel_31.setBounds(187, 230, 149, 16);
		contentPane.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("beans. Includes a side of chunky chips.");
		lblNewLabel_32.setForeground(Color.BLUE);
		lblNewLabel_32.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_32.setBounds(506, 449, 188, 16);
		contentPane.add(lblNewLabel_32);
		
		JLabel lblNewLabel_33 = new JLabel("in puff pastry.");
		lblNewLabel_33.setForeground(Color.BLUE);
		lblNewLabel_33.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_33.setBounds(566, 333, 68, 16);
		contentPane.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("potato, broccoli, chicken dripping gravy.");
		lblNewLabel_34.setForeground(Color.BLUE);
		lblNewLabel_34.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_34.setBounds(847, 568, 198, 16);
		contentPane.add(lblNewLabel_34);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(654, 354, 34, 26);
		contentPane.add(spinner);
		
		JLabel lblNewLabel_35 = new JLabel("medium. Served with a portion of Chips.");
		lblNewLabel_35.setForeground(Color.BLUE);
		lblNewLabel_35.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_35.setBounds(847, 451, 198, 16);
		contentPane.add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("crushed peas.");
		lblNewLabel_36.setForeground(Color.BLUE);
		lblNewLabel_36.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_36.setBounds(912, 333, 68, 16);
		contentPane.add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("special recipe burger sauce.");
		lblNewLabel_37.setForeground(Color.BLUE);
		lblNewLabel_37.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNewLabel_37.setBounds(878, 230, 136, 16);
		contentPane.add(lblNewLabel_37);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(654, 253, 34, 26);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(654, 469, 34, 26);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(654, 589, 34, 26);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(284, 253, 34, 26);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(289, 354, 34, 26);
		contentPane.add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(293, 469, 34, 26);
		contentPane.add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(293, 589, 34, 26);
		contentPane.add(spinner_7);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(984, 253, 34, 26);
		contentPane.add(spinner_8);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(978, 354, 34, 26);
		contentPane.add(spinner_9);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(978, 469, 34, 26);
		contentPane.add(spinner_10);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(978, 589, 34, 26);
		contentPane.add(spinner_11);
		
		JLabel lblNewLabel_38 = new JLabel("£5.50");
		lblNewLabel_38.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_38.setBounds(220, 258, 52, 16);
		contentPane.add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("£2.50");
		lblNewLabel_39.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_39.setBounds(220, 358, 52, 16);
		contentPane.add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("£6.99");
		lblNewLabel_40.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_40.setBounds(220, 473, 52, 16);
		contentPane.add(lblNewLabel_40);
		
		JLabel lblNewLabel_41 = new JLabel("£8.50");
		lblNewLabel_41.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_41.setBounds(220, 593, 52, 16);
		contentPane.add(lblNewLabel_41);
		
		JLabel lblNewLabel_42 = new JLabel("£5.99");
		lblNewLabel_42.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_42.setBounds(555, 258, 52, 16);
		contentPane.add(lblNewLabel_42);
		
		JLabel lblNewLabel_43 = new JLabel("£2.00");
		lblNewLabel_43.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_43.setBounds(556, 358, 52, 16);
		contentPane.add(lblNewLabel_43);
		
		JLabel lblNewLabel_44 = new JLabel("£4.50");
		lblNewLabel_44.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_44.setBounds(556, 473, 52, 16);
		contentPane.add(lblNewLabel_44);
		
		JLabel lblNewLabel_45 = new JLabel("£3.50");
		lblNewLabel_45.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_45.setBounds(556, 593, 52, 16);
		contentPane.add(lblNewLabel_45);
		
		JLabel lblNewLabel_46 = new JLabel("£9.99");
		lblNewLabel_46.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_46.setBounds(895, 258, 52, 16);
		contentPane.add(lblNewLabel_46);

		JLabel lblNewLabel_47 = new JLabel("£8.99");
		lblNewLabel_47.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_47.setBounds(895, 358, 49, 16);
		contentPane.add(lblNewLabel_47);
		
		JLabel lblNewLabel_48 = new JLabel("£14.99");
		lblNewLabel_48.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_48.setBounds(895, 473, 62, 16);
		contentPane.add(lblNewLabel_48);
		
		JLabel lblNewLabel_49 = new JLabel("£10.99");
		lblNewLabel_49.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_49.setBounds(895, 593, 52, 16);
		contentPane.add(lblNewLabel_49);
		
		//Calculate total cost
		
		
		float a = 5.50f;
		float b = 2.50f;
		float c = 6.99f;
		float d = 8.50f;
		float e = 5.99f;
		float f = 2.00f;
		float g = 4.50f;
		float h = 3.50f;
		float i = 9.99f;
		float j = 8.99f;
		float k = 14.99f;
		
		System.out.println(a * (int) spinner_1.getValue());
		System.out.println(b * (int) spinner_2.getValue());
		System.out.println(c * (int) spinner_3.getValue());
		System.out.println(d * (int) spinner_4.getValue());
		System.out.println(e * (int) spinner_5.getValue());
		System.out.println(f * (int) spinner_6.getValue());
		System.out.println(g * (int) spinner_7.getValue());
		System.out.println(h * (int) spinner_8.getValue());
		System.out.println(i * (int) spinner_9.getValue());
		System.out.println(j * (int) spinner_10.getValue());
		System.out.println(k * (int) spinner_11.getValue());
		
		
		
		/*
		int a = (int) spinner_1.getValue();
		int b = (int) spinner_2.getValue();
		int c = (int) spinner_3.getValue();
		int d = (int) spinner_4.getValue();
		int e = (int) spinner_5.getValue();
		int f = (int) spinner_6.getValue();
		int g = (int) spinner_7.getValue();
		int h = (int) spinner_8.getValue();
		int i = (int) spinner_9.getValue();
		int j = (int) spinner_10.getValue();
		int k = (int) spinner_11.getValue();
		*/
		//System.out.println(a+b+c+d+e+f+g+h+i+j+k);
	}
}
