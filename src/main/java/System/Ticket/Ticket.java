package System.Ticket;

import java.util.UUID;

public class Ticket {
	private final UUID TicketId;
	private final UUID FlightId;
	private final UUID UserId;
    private  String  TicketClass;//"classA", "classB"
    
    
    
    
	public Ticket(UUID ticketId, UUID flightId, UUID userId, String ticketClass) {
		TicketId = ticketId;
		FlightId = flightId;
		UserId = userId;
		TicketClass = ticketClass;
	}
	public String getTicketClass() {
		return TicketClass;
	}
	public void setTicketClass(String ticketClass) {
		TicketClass = ticketClass;
	}
	public UUID getTicketId() {
		return TicketId;
	}
	public UUID getFlightId() {
		return FlightId;
	}
	public UUID getUserId() {
		return UserId;
	}
	@Override
	public String toString() {
		return "Ticket [TicketId=" + TicketId + ", FlightId=" + FlightId + ", UserId=" + UserId + ", TicketClass="
				+ TicketClass + "]";
	}
}
