import java.util.Random;

public class TicketNumber {
		private long number;
			
		public TicketNumber(NoInit tag)
		{
			number = -1;
		}

		public TicketNumber()
		{
			Random r = new Random();
			number = 10000000 + (r.nextLong() % 9999999);				
		}
		
		
		public long GetNumber() {return number;}
}
