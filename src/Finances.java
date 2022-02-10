
public class Finances {
	
	private static double Clamp(double min,double max,double val)
	{
		// if val is within min and max, returns val
		// otherwise returns the closest bound
		return val > max ? max : val < min? min : val;
	}

	private static double CalcLuggageCost(int count)
	{
		// The cost of 1 checked in bag is free for each passenger, any additional bags will cost £25 per bag.
		return Math.max(1, count) * 25;
	}

	private static double CalcCompensation(double delay)
	{
		// Compensation is equal to £100 if the flight’s departure is delayed by more than an hour and less than or equal
		// to 2 hours. Compensation is £200 if the delay is more than 2 hours and less than or equal to 3 hours.
		// Compensation is £300 if the delay is more than 3 hours
		
		return 
				delay <= 1 ? 0 : 
				delay <= 2 ? 1 : 
				delay <= 3 ? 2 :
			/*delay > 3*/    3;
	}

	
	public static void main(String[] args)
	{
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