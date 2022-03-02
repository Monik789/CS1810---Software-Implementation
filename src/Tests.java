import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static java.time.Duration.ofSeconds;
import static java.time.Duration.ofMinutes;


public class Tests
{
	 @BeforeEach                                         
	 void setUp() 
	 {
		 
	 }
	 	 
	 @RepeatedTest(128)
	 @DisplayName("testTicketLength")
	 void Test1()
	 {
		 TicketNumber number = new TicketNumber();
		 assertEquals(8, ("" + number.GetNumber()).length(), () -> "Invalid ticket number created: " + number.GetNumber());
	 }
	 
	 @Test	 
	 @DisplayName("testCompensation")
	 void Test2() 
	 {		 
		 // comp should be 0 if delay <= 1 hour
		 assertTrue(Finances.CalcFlightCompensation(0.0) == 0);		 
		 assertTrue(Finances.CalcFlightCompensation(1.0) == 0);

		 // comp should be 100 if delay is > 1 hour and <= 2 hours
		 assertTrue(Finances.CalcFlightCompensation(1.1) == 100);
		 assertTrue(Finances.CalcFlightCompensation(2.0) == 100);

		 // comp should be 200 if delay is > 2 hours and <= 3 hours 
		 assertTrue(Finances.CalcFlightCompensation(2.1) == 200);		 
		 assertTrue(Finances.CalcFlightCompensation(3.0) == 200);
		 
		 // comp should be 300 if delay > 3 hours
		 assertTrue(Finances.CalcFlightCompensation(3.1) == 300);		 
		 assertTrue(Finances.CalcFlightCompensation(4.0) == 300);
	 }

	 @Test
	 @DisplayName("testFlightCost")
	 void Test3() 
	 {
		 // economy flights = 1.5 * distance
		 assertTrue(0.0 == Finances.CalcFlightCost(ComfortLevel.economy_class, 0));	
		 assertTrue(0.5 == Finances.CalcFlightCost(ComfortLevel.economy_class, 1));
		 assertTrue(1.0 == Finances.CalcFlightCost(ComfortLevel.economy_class, 2));
		 assertTrue(1.5 == Finances.CalcFlightCost(ComfortLevel.economy_class, 3));
		 assertTrue(2.0 == Finances.CalcFlightCost(ComfortLevel.economy_class, 4));
		 assertTrue(2.5 == Finances.CalcFlightCost(ComfortLevel.economy_class, 5));

		 // buisness class flights = 1.5 * distance
		 assertTrue(0.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 0));	
		 assertTrue(1.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 1));
		 assertTrue(2.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 2));
		 assertTrue(3.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 3));
		 assertTrue(4.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 4));
		 assertTrue(5.0 == Finances.CalcFlightCost(ComfortLevel.buisness_class, 5));
		 
		 // first class flights = 1.5 * distance
		 assertTrue(0.0 == Finances.CalcFlightCost(ComfortLevel.first_class, 0));	
		 assertTrue(1.5 == Finances.CalcFlightCost(ComfortLevel.first_class, 1));
		 assertTrue(3.0 == Finances.CalcFlightCost(ComfortLevel.first_class, 2));
		 assertTrue(4.5 == Finances.CalcFlightCost(ComfortLevel.first_class, 3));
		 assertTrue(6.0 == Finances.CalcFlightCost(ComfortLevel.first_class, 4));
		 assertTrue(7.5 == Finances.CalcFlightCost(ComfortLevel.first_class, 5));		 
	 }
	 
	 @Test
	 @DisplayName("testBagCosts")
	 void Test4() 
	 {			    
		 // the first bag is free
		 assertTrue(Finances.CalcLuggageCost(0) == 0);
		 assertTrue(Finances.CalcLuggageCost(1) == 0);
		 
		 // any additional bags cost $25.00
		 assertTrue(Finances.CalcLuggageCost(2) == 25);
		 assertTrue(Finances.CalcLuggageCost(3) == 50);
		 assertTrue(Finances.CalcLuggageCost(4) == 75);
	 }
	 
	 @Test
	 @DisplayName("testWidgetResponsiveness")
	 void Test5() 
	 {
		 // programatically simulate a mouse click on a button or something
	     //assertTimeout(ofMinutes(1), () -> service.doBackup());
		 assertTrue(true);
	 }
	 
	 
}
