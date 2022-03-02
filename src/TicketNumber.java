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
			
			//         (inclusive min,exclusive max)
			number = r.longs(10000000,100000000).findFirst().getAsLong();			
		}
		
		public long GetNumber() {return number;}
}
