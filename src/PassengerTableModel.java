import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

public class PassengerTableModel extends AbstractTableModel {

	    ArrayList<PassengerData> data;	    
	    private final static String[] header =
	    	{
	    			"name",
	    			"date of birth",
	    			"ticket number",
	    			"luggage",
	    			"outbound",
	    			"inbound",
	    			"ticket cost",
	    			"food cost",
	    			"shops cost",
	    			"compensation",
	    			"total cost"
	    	};

	    public PassengerTableModel(PassengerData[] obj) 
	    {
	        data = new ArrayList<PassengerData>();
	        
	        if (obj != null)
	        {
	        	for (int i = 0; i < obj.length; ++i) 
	        	{
	        		data.add(obj[i]);
	        	}
	        }
	    }

	    @Override
	    public int getRowCount() {
	        return data.size();
	    }

	    @Override
	    public int getColumnCount() {
	        return header.length;
	    }

	    @Override
	    public Class<?> getColumnClass(int columnIndex) {	        
	        if (columnIndex == 0) return String.class; // name
	        if (columnIndex == 1) return Date.class;   // dob
	        if (columnIndex == 2) return long.class;   // ticket no
	        if (columnIndex == 3) return int.class;    // luggage
	        
	        if (columnIndex == 4) return String.class;    // outbound flight data 
	        if (columnIndex == 5) return String.class;    // inbound flight data
	        
	        if (columnIndex == 6) return double.class; // ticket cost -- seat comfort * flight distance
	        if (columnIndex == 7) return double.class; // food cost
	        if (columnIndex == 8) return double.class; // shop cost
	        if (columnIndex == 9) return double.class; // comp
	        if (columnIndex == 10) return int.class;    // total	        
	        return Object.class;
	    }

	    @Override
	    public String getColumnName(int index) {
	        return header[index];
	    }
	    
	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	if (columnIndex == 0) return data.get(rowIndex).name.firstName + " " + data.get(rowIndex).name.lastName;	    	
	    	if (columnIndex == 1) return data.get(rowIndex).dob;
	    	if (columnIndex == 2) return data.get(rowIndex).ticketNumber.GetNumber();	
	    	if (columnIndex == 3) return "" + Finances.CalcLuggageCost(data.get(rowIndex).luggageCount) + " (" + data.get(rowIndex).luggageCount + " bags)";	    
	    	
	    	if (columnIndex == 4) return data.get(rowIndex).departureFlight.flight.sourceName + " -> " + data.get(rowIndex).departureFlight.flight.destinationName + " (" + data.get(rowIndex).departureFlight.flight.distance + ")";	    
	    	if (columnIndex == 5) return data.get(rowIndex).returnFlight.flight.sourceName + " -> " + data.get(rowIndex).returnFlight.flight.destinationName + " (" + data.get(rowIndex).returnFlight.flight.distance + ")";	    
	    	
	    	if (columnIndex == 6) return Finances.CalcFlightCost(ComfortLevel.buisness_class, data.get(rowIndex).departureFlight.flight.distance) + Finances.CalcFlightCost(ComfortLevel.buisness_class, data.get(rowIndex).returnFlight.flight.distance); 	    	
	    	if (columnIndex == 7) return data.get(rowIndex).moneySpent.Food;
	    	if (columnIndex == 8) return data.get(rowIndex).moneySpent.Shops;
	    	if (columnIndex == 9) return Finances.CalcFlightCompensation(data.get(rowIndex).departureFlight.delay) + Finances.CalcFlightCompensation(data.get(rowIndex).returnFlight.delay);
	    	if (columnIndex == 10) return 0; // total cost
	    	return null;	    	    	
	    }

	    public void addRow(PassengerData item) {
	        data.add(item);
	        // int row = data.indexOf(item);
	        
	        // fireTableRowsInserted(row, row);
	        fireTableRowsInserted(data.size() - 1, data.size() - 1);
	    }

	    public boolean contains(PassengerData item)
	    {
	    	return data.contains(item);
	    }
	    public void removeRow(PassengerData item) {
	        if (data.contains(item)) {
	            int row = data.indexOf(item);
	            data.remove(row);
	            fireTableRowsDeleted(row, row);
	        }
	    }
	}