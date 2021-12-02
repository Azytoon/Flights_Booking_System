package System.Flight;

import java.util.UUID;

public class Flight {
	
		private final UUID FlightId;

	    private  String From = null;
	    
	    private  String To = null;
	    
	    private  Number classA_Fare = null;
	    
	    private  Number classB_Fare = null;
	    

		private  String departureTime = null;

	    private  String arrivalTime = null;
	    
	    public Flight(UUID flightId, String from, String to, Number classA_Fare, Number classB_Fare, String departureTime, String arrivalTime) {
			this.FlightId = flightId;
			this.From = from;
			this.To = to;
			this.classA_Fare = classA_Fare;
			this.classB_Fare = classB_Fare;
			this.departureTime = departureTime;
			this.arrivalTime = arrivalTime;
		}

	    public UUID getFlightId() {
			return FlightId;
		}
	    
		public String getFrom() {
			return From;
		}

		public String getTo() {
			return To;
		}

		public Number getClassA_Fare() {
			return classA_Fare;
		}
		public Number getClassB_Fare() {
			return classB_Fare;
		}
		public String getDepartureTime() {
			return departureTime;
		}

		public String getArrivalTime() {
			return arrivalTime;
		}

		@Override
		public String toString() {
			return "Flight [FlightId=" + FlightId + ", From=" + From + ", To=" + To + ", classA_Fare=" + classA_Fare
					+ ", classB_Fare=" + classB_Fare + ", departureTime=" + departureTime + ", arrivalTime="
					+ arrivalTime + "]";
		}
		
	    public boolean checkNullFields() {
	    	if(this.getArrivalTime() == null ||
	    	   this.getClassA_Fare() == null ||
	    	   this.getClassB_Fare() == null ||
	    	   this.getDepartureTime() == null ||
	    	   this.getFrom() ==null ||
	    	   this.getTo() == null) return true;
	    	else return false;
	    }
	    public boolean checkIfAllNullFields() {
	    	if(this.getArrivalTime() == null &&
	    	   this.getClassA_Fare() == null &&
	    	   this.getClassB_Fare() == null &&
	    	   this.getDepartureTime() == null &&
	    	   this.getFrom() ==null &&
	    	   this.getTo() == null) return true;
	    	else return false;
	    }
}
