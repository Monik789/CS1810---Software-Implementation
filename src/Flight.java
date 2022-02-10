import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

	FlightData flight = new FlightData();
	
	LocalTime arrivalTime;
	LocalTime departingTime;
	
	/*	
		I haven't looked at the flight component, but this might be 
		better off as Time instead of double. 
		I'm not sure what the csv file contains though, or of the best approach right now.  
	 */
	double delay; 
	ArrayList<TicketNumber> seats = new ArrayList<TicketNumber>();
}

/*
	a good start for 'Flights' is probably to store an array list of 'Flight' and go from there.
	each flight might also need a list of seats, and which ones are already taken. 
	
*/