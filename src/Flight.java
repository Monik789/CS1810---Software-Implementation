import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

	FlightData flight = new FlightData();
	
	LocalTime arrivalTime;
	LocalTime departingTime;
	
	double delay; 
	ArrayList<TicketNumber> seats = new ArrayList<TicketNumber>();
}