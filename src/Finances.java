import javax.swing.*;

public class Finances {
	
	// if val is within min and max, returns val
	// otherwise returns the closest bound
	private static double Clamp(double min,double max,double val)
	{
		return val > max ? max : val < min? min : val;
	}

	// The cost of 1 checked in bag is free for each passenger, any additional bags will cost £25 per bag.
	private static double CalcLuggageCost(int count)
	{
		return Math.max(1, count) * 25;
	}

	// Total costs
	// of tickets include both the departure and return flight. Economy tickets are equal to 0.5 x flight distance,
	// business class tickets are equal to 1.0 x flight distance and first-class tickets are equal to 1.5 x flight distance
	private static double CalcFlightCost(ComfortLevel passengerComfort,double distance)
	{
		return (1 + passengerComfort.ordinal()) * 0.5 * distance;
	}
	
	// this assumes that the airports are the same between outbound and inbound journeys.
	// depending on the booking implementation, this has a strong likelihood to change.	
	private static double CalcTicketCost(ComfortLevel passengerComfort,double distance)
	{
		return 2 * CalcFlightCost(passengerComfort,distance);
	}
	
	// Compensation is equal to £100 if the flight’s departure is delayed by more than an hour and less than or equal
	// to 2 hours. Compensation is £200 if the delay is more than 2 hours and less than or equal to 3 hours.
	// Compensation is £300 if the delay is more than 3 hours
	private static double CalcFlightCompensation(double delay)
	{
		return 
				delay <= 1 ? 0 : 
				delay <= 2 ? 1 : 
				delay <= 3 ? 2 :
			/*delay > 3*/    3;
	}


	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("My First GUI");		
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.LINE_AXIS));
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800,600);
	    JButton buttonToComponent0 = new JButton("Flight");
	    JButton buttonToComponent1 = new JButton("Seats");
	    JButton buttonToComponent2 = new JButton("Shop");
	    JButton buttonToComponent3 = new JButton("Passengers");
	    JButton buttonToComponent4 = new JButton("Restaurant");
	    JButton buttonToComponent5 = new JButton("Arrival");
	    JButton buttonToComponent6 = new JButton("Departure");
	    
	    frame.getContentPane().add(buttonToComponent0);
	    frame.getContentPane().add(buttonToComponent1);
	    frame.getContentPane().add(buttonToComponent2);
	    frame.getContentPane().add(buttonToComponent3);
	    frame.getContentPane().add(buttonToComponent4);
	    frame.getContentPane().add(buttonToComponent5);
	    frame.getContentPane().add(buttonToComponent6);
	    frame.setVisible(true);		
		
	    
		Result<Integer> demo = new Result<Integer>(5);
		
		if (demo.isError())
			System.out.println("Error! Aborting program!");
		else 
			System.out.println("Hello world!");
		
		Flight singleFlight = new Flight();
		
		singleFlight.flight.sourceName = "Tokyo";
		singleFlight.flight.destinationName = "Budapest";
		singleFlight.flight.distance = 1000.0;
		
		TicketNumber goodPassengerNumber = new TicketNumber();
		TicketNumber badPassengerNumber = new TicketNumber(new NoInit());		
	}
}