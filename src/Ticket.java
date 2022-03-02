
public class Ticket {
	public TicketNumber number = new TicketNumber();
	public PassengerData passenger = new PassengerData();

	public Flight departureFlight = new Flight();
	public Flight returnFlight = new Flight();
	public String departureSeat = new String();
	public String returnSeat = new String();
	
	public Ticket()
	{
		
	}
	public Ticket(Flight f,TicketNumber n,PassengerData p)
	{
		// flight delay
		// flight distance
		
		// passenger name
		// passenger dob
		// ticket number
		
		// seat
		// bags

		// food
		// shops
		
		
		// flight cost -> (seat,flight distance)
		// ticket cost -> (flight cost, flight cost) // departure + return
		// 
		
		// name | dob | ticket number | bags cost | departure + return flight cost | food cost | shop cost | comp | total
		
		
	}
}
