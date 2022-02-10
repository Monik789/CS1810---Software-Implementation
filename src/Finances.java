
public class Finances {
	
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