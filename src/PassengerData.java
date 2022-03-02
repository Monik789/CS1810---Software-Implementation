import java.util.Date;

public class PassengerData
{
	public class Name
	{
		public String firstName = new String();
		public String lastName = new String();
	}
	public class MoneyData
	{
		public double Food;
		public double Shops;
		public double Ticket;
	}
	
	public Name name = new Name();
	Date dob = new Date();
	public int luggageCount;
	public String returnSeat = new String();
	public String departureSeat = new String();	
	public Flight returnFlight = new Flight();
	public Flight departureFlight = new Flight();
	public MoneyData moneySpent = new MoneyData();
	public TicketNumber ticketNumber = new TicketNumber(new NoInit());
}
