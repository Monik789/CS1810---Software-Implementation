import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.*;


public class Finances {
	
	private static JFrame frame = new JFrame("Brunel City London Airport"); 
	private static JPanel panelContainer = new JPanel();
	private static CardLayout cardLayout = new CardLayout();
	
	/********************* cards **************************/
	private static JPanel flights = new JPanel();
	private static JPanel seats = new JPanel();
	private static JPanel shops = new JPanel();
	private static JPanel passengers = new JPanel();
	private static JPanel finances = new JPanel();
	private static JPanel arrivals = new JPanel();
	private static JPanel departures = new JPanel();
	/*******************************************************/
	
	
	/**********************finances*************************/ 
	private static JTable ticketTable = new JTable(new PassengerTableModel(null));
	private static JScrollPane scrollPane = new JScrollPane(ticketTable);	
	/*******************************************************/
	
    
	// if val is within min and max, returns val
	// otherwise returns the closest bound
	private static double Clamp(double min,double max,double val)
	{
		return 
			val > max? max : 
			val < min? min : 
				val;
	}

	// The cost of 1 checked in bag is free for each passenger, any additional bags will cost £25 per bag.
	public static double CalcLuggageCost(int count)
	{
		return (Math.max(1, count) - 1) * 25;
	}
	
	// Total costs
	// of tickets include both the departure and return flight. Economy tickets are equal to 0.5 x flight distance,
	// business class tickets are equal to 1.0 x flight distance and first-class tickets are equal to 1.5 x flight distance
	public static double CalcFlightCost(ComfortLevel passengerComfort,double distance)
	{
		return (1 + passengerComfort.ordinal()) * 0.5 * distance;
	}
	
	// this assumes that the airports are the same between outbound and inbound journeys.
	// depending on the booking implementation, this has a strong likelihood to change.	
	public static double CalcTicketCost(ComfortLevel passengerComfort,double distance)
	{
		return 2 * CalcFlightCost(passengerComfort,distance);
	}
	
	// Compensation is equal to £100 if the flight’s departure is delayed by more than an hour and less than or equal
	// to 2 hours. Compensation is £200 if the delay is more than 2 hours and less than or equal to 3 hours.
	// Compensation is £300 if the delay is more than 3 hours
	public static double CalcFlightCompensation(double delay)
	{
		return 
				delay <= 1 ?   0 : 
				delay <= 2 ? 100 : 
				delay <= 3 ? 200 :
			/*delay > 3?  */ 300;
	}

	
	// today
	// todo: parse csv string
	// todo: calculate comfort level by seat position. this means seat needs to be stored in the ticket
	// todo: update CalcTicketCost -> journeys aren't the same distance both ways. 
	// todo: update passenger list when more food,items,tickets,etc are bought.
	// todo: fill top of window background with nice picture
	// todo: set the height of the top of the window to a fixed height - the picture will have to slide to one side or something
	
	// tomorrow
	// todo: write report
	// todo: write peer review
	// todo: merge my component with everyone else
	
	
	
	public static Result<Integer> AddPassenger(PassengerData p)
	{
		Result<Integer> returnValue = new Result<Integer>("passenger already exists");
		
		// todo: store passengers sorted by ticket id so i dont have to iterate the entire thing to find them if they exist

		if (!((PassengerTableModel)ticketTable.getModel()).contains(p))		
		{
			((PassengerTableModel)ticketTable.getModel()).addRow(p);		
			returnValue = new Result<Integer>(((PassengerTableModel)ticketTable.getModel()).getRowCount() - 1);
		}
		return returnValue;
	}
	public static void RemovePassenger(PassengerData p)
	{
		((PassengerTableModel)ticketTable.getModel()).removeRow(p);
	}
	
	static void initFinances()
	{
		PassengerData[] passengersList = new PassengerData[5];				
		for (int i = 0; i < passengersList.length; ++i) 
			passengersList[i] = new PassengerData();
		
		passengersList[0].departureFlight.delay = 0;
		passengersList[1].departureFlight.delay = 1;
		passengersList[2].departureFlight.delay = 2;
		passengersList[3].departureFlight.delay = 3;
		passengersList[4].departureFlight.delay = 4;

		passengersList[0].returnFlight.delay = 0;
		passengersList[1].returnFlight.delay = 0;
		passengersList[2].returnFlight.delay = 9;
		passengersList[3].returnFlight.delay = 3;
		passengersList[4].returnFlight.delay = 1;

		passengersList[0].returnFlight.flight.distance = 212;
		passengersList[1].returnFlight.flight.distance = 52;
		passengersList[2].returnFlight.flight.distance = 835;
		passengersList[3].returnFlight.flight.distance = 120;
		passengersList[4].returnFlight.flight.distance = 208;
		
		passengersList[0].departureFlight.flight.distance = 190;
		passengersList[1].departureFlight.flight.distance = 545;
		passengersList[2].departureFlight.flight.distance = 838;
		passengersList[3].departureFlight.flight.distance = 140;
		passengersList[4].departureFlight.flight.distance = 260;

		passengersList[0].departureFlight.flight.destinationName = "Tokyo";;
		passengersList[1].departureFlight.flight.destinationName = "Austria";
		passengersList[2].departureFlight.flight.destinationName = "Budapest";
		passengersList[3].departureFlight.flight.destinationName = "Portugal";
		passengersList[4].departureFlight.flight.destinationName = "Greenland";
		
		passengersList[0].returnFlight.flight.sourceName = "Tokyo";;
		passengersList[1].returnFlight.flight.sourceName = "Austria";
		passengersList[2].returnFlight.flight.sourceName = "Budapest";
		passengersList[3].returnFlight.flight.sourceName = "Portugal";
		passengersList[4].returnFlight.flight.sourceName = "Greenland";

		passengersList[0].departureFlight.flight.sourceName = "Japan";
		passengersList[1].departureFlight.flight.sourceName = "Syria";
		passengersList[2].departureFlight.flight.sourceName = "Kansas";
		passengersList[3].departureFlight.flight.sourceName = "Portugal";
		passengersList[4].departureFlight.flight.sourceName = "Austria";;
		
		passengersList[0].returnFlight.flight.destinationName = "Japan";
		passengersList[1].returnFlight.flight.destinationName = "Syria";
		passengersList[2].returnFlight.flight.destinationName = "Kansas";
		passengersList[3].returnFlight.flight.destinationName = "Portugal";
		passengersList[4].returnFlight.flight.destinationName = "Austria";;
		
		passengersList[0].luggageCount = 0;
		passengersList[1].luggageCount = 1;
		passengersList[2].luggageCount = 2;
		passengersList[3].luggageCount = 3;
		passengersList[4].luggageCount = 4;		
		
		passengersList[0].moneySpent.Food = 00;
		passengersList[1].moneySpent.Food = 10;
		passengersList[2].moneySpent.Food = 20;
		passengersList[3].moneySpent.Food = 30;
		passengersList[4].moneySpent.Food = 40;
		passengersList[0].moneySpent.Shops = 50;
		passengersList[1].moneySpent.Shops = 40;
		passengersList[2].moneySpent.Shops = 30;
		passengersList[3].moneySpent.Shops = 20;
		passengersList[4].moneySpent.Shops = 10;				
		passengersList[0].moneySpent.Ticket = 0;
		// passengersList[1].moneySpent.Ticket = 100;   // this should be changed to flight distance
		// passengersList[2].moneySpent.Ticket = 500;   // this should be changed to flight distance
		// passengersList[3].moneySpent.Ticket = 1000;  // this should be changed to flight distance
		// passengersList[4].moneySpent.Ticket = 5000;  // this should be changed to flight distance
		
		passengersList[0].name.firstName = "Kye";
		passengersList[1].name.firstName = "Anne";
		passengersList[2].name.firstName = "Jack";
		passengersList[3].name.firstName = "Norman";
		passengersList[4].name.firstName = "Slender";				
		passengersList[0].name.lastName = "Cunningham";
		passengersList[1].name.lastName = "Frank";
		passengersList[2].name.lastName = "Ripper";
		passengersList[3].name.lastName = "Bates";
		passengersList[4].name.lastName = "Man";	
		
		passengersList[0].ticketNumber = new TicketNumber();
		passengersList[1].ticketNumber = new TicketNumber();
		passengersList[2].ticketNumber = new TicketNumber();
		passengersList[3].ticketNumber = new TicketNumber();
		passengersList[4].ticketNumber = new TicketNumber();

		for (int i = 0; i < passengersList.length; ++i)
			AddPassenger(passengersList[i]);
	
		// segment window into content regions
		JPanel top = new JPanel();
		JPanel center = new JPanel();
		
		JButton viewFlights = new JButton("Flights");
		JButton viewSeats = new JButton("Seats");
		JButton viewShops = new JButton("Shops");
		JButton viewPassengers = new JButton("Passengers");
		JButton viewFinances = new JButton("Finances");
		JButton viewArrivals = new JButton("Arrivals");
		JButton viewDepartures = new JButton("Departures");		
		
		// register button callbacks
		viewFlights.addActionListener((unused) -> {cardLayout.show(panelContainer,"flights");});
		viewSeats.addActionListener((unused) -> {cardLayout.show(panelContainer,"seats");});
		viewShops.addActionListener((unused) -> {cardLayout.show(panelContainer,"shops");});
		viewPassengers.addActionListener((unused) -> {cardLayout.show(panelContainer,"passengers");});
		viewFinances.addActionListener((unused) -> {cardLayout.show(panelContainer,"finances");});
		viewArrivals.addActionListener((unused) -> {cardLayout.show(panelContainer,"arrivals");});
		//viewDepartures.addActionListener((unused) -> {cardLayout.show(panelContainer,"departures");});
		viewDepartures.addActionListener((unused) -> 
		{
			PassengerData p = new PassengerData();
			p.name.firstName = "procedural";
			p.name.lastName = "name";
			p.departureFlight.delay = 0;
			p.departureFlight.flight.distance = 1000;
			
			p.returnFlight.delay = 2;
			p.returnFlight.flight.distance = 880;
			
			AddPassenger(p);
		});
		
		// set button backgrounds
		viewFlights.setBackground(Color.BLACK);
		viewSeats.setBackground(Color.BLACK);
		viewShops.setBackground(Color.BLACK);
		viewPassengers.setBackground(Color.BLACK);
		viewFinances.setBackground(Color.BLACK);
		viewArrivals.setBackground(Color.BLACK);
		viewDepartures.setBackground(Color.BLACK);
		// set button foregrounds
		viewFlights.setForeground(Color.WHITE);
		viewSeats.setForeground(Color.WHITE);
		viewShops.setForeground(Color.WHITE);
		viewPassengers.setForeground(Color.WHITE);
		viewFinances.setForeground(Color.WHITE);
		viewArrivals.setForeground(Color.WHITE);
		viewDepartures.setForeground(Color.WHITE);
		// set table colors
		ticketTable.setBackground(Color.DARK_GRAY);
		ticketTable.setForeground(Color.WHITE);
		
		// set panel backgrounds
		top.setBackground(Color.BLACK);
		center.setBackground(Color.BLACK);		
		
		// set layout for the window 
		top.setLayout(new FlowLayout());
		center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); 
		finances.setLayout(new BoxLayout(finances,BoxLayout.Y_AXIS));
		
		// add content to the top of the window
		top.add(viewFlights);
		top.add(viewSeats);
		top.add(viewShops);
		top.add(viewPassengers);
		top.add(viewFinances);
		top.add(viewArrivals);
		top.add(viewDepartures);
		
		// add content to the center of the window
		center.add(scrollPane);
		
		// submit
		finances.add(top);
		finances.add(center);
	}
	
	public static void main(String[] args)
	{		
		panelContainer.setLayout(cardLayout);
		initFinances();				
		// non finance stuff. ignore this for now
		for (JPanel x : new JPanel[]{ flights, seats, shops, passengers, arrivals, departures } ) 
		{
			JButton viewFlights = new JButton("Flights");
			JButton viewSeats = new JButton("Seats");
			JButton viewShops = new JButton("Shops");
			JButton viewPassengers = new JButton("Passengers");
			JButton viewFinances = new JButton("Finances");
			JButton viewArrivals = new JButton("Arrivals");
			JButton viewDepartures = new JButton("Departures");
			
			viewFlights.addActionListener((unused) -> {cardLayout.show(panelContainer,"flights");});
			viewSeats.addActionListener((unused) -> {cardLayout.show(panelContainer,"seats");});
			viewShops.addActionListener((unused) -> {cardLayout.show(panelContainer,"shops");});
			viewPassengers.addActionListener((unused) -> {cardLayout.show(panelContainer,"passengers");});
			viewFinances.addActionListener((unused) -> {cardLayout.show(panelContainer,"finances");});
			viewArrivals.addActionListener((unused) -> {cardLayout.show(panelContainer,"arrivals");});
			viewDepartures.addActionListener((unused) -> {cardLayout.show(panelContainer,"departures");});
			
			
			x.add(viewFlights);
			x.add(viewSeats);
			x.add(viewShops);
			x.add(viewPassengers);
			x.add(viewFinances);
			x.add(viewArrivals);
			x.add(viewDepartures);
		}
		
		flights.setBackground(Color.BLACK);
		seats.setBackground(Color.RED);
		shops.setBackground(Color.BLUE);
		passengers.setBackground(Color.GREEN);
		arrivals.setBackground(Color.WHITE);
		departures.setBackground(Color.GRAY);
		
		panelContainer.add(flights,"flights");
		panelContainer.add(seats,"seats");
		panelContainer.add(shops,"shops");
		panelContainer.add(passengers,"passengers");
		panelContainer.add(finances,"finances");
		panelContainer.add(arrivals,"arrivals");
		panelContainer.add(departures,"departures");	    
		
		// initial card to show
		cardLayout.show(panelContainer,"finances");
		
		
		frame.getContentPane().add(panelContainer);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}