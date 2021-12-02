package System.Ticket;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TicketService {

private final TicketDataAccessService ticketDataAccessService;

    
    public TicketService(TicketDataAccessService ticketDataAccessService) {
			this.ticketDataAccessService = ticketDataAccessService;
	}
    /************LIST**********************/
	public List<Ticket> getAllTickets() {
        return ticketDataAccessService.selectAllTickets();
	}
	public List<Ticket> getTicketsByTicketId(UUID ticketId) {
        return ticketDataAccessService.getTicketsByTicketId(ticketId);
	}
	public List<Ticket> getTicketsByUserId(UUID userId) {
        return ticketDataAccessService.getTicketsByUserId(userId);
	}
	public List<Ticket> getTicketsByFlightId(UUID flightId) {
        return ticketDataAccessService.getTicketsByFlightId(flightId);
	}
	/************ADD***********************/
	public String addNewTicket(Ticket ticket) {
        return addNewTicket(null, ticket);
    }
	
    String addNewTicket(UUID ticketId, Ticket ticket) {
        UUID newTicketId = Optional.ofNullable(ticketId)
                .orElse(UUID.randomUUID());
        ticketDataAccessService.checkTicket(ticket);
        ticketDataAccessService.insertTicket(newTicketId, ticket);
        return "ticket reserved successfully";
    }
    /**************DELETE***********************/
	public String deleteTicket(UUID ticketId) {
		if (ticketDataAccessService.checkTicketId(ticketId).size() == 0) {
			throw new NoSuchElementException("ticket with this ID not exist");
		}
		else {
	        ticketDataAccessService.deleteTicketById(ticketId);
	        return "ticket is canceled successfully";
		}
	}

	/*******************UPDATE******************/
	public String updateTicket(UUID ticketId, String updatedClass) {
		if (ticketDataAccessService.checkTicketId(ticketId).size() == 0) {
			throw new NoSuchElementException("ticket with this ID not exist");
		}
    	if (!updatedClass.equals("classA") &&
            !updatedClass.equals("classB")) {
        		throw new IllegalArgumentException(
        				"TicketClass should be classA or classB");
    	}	
        ticketDataAccessService.updateTicketClass(ticketId, updatedClass);
		return "Flight updated successfully";
	}
//	/**************FILTER*******************/
//	public List<Flight> getFilterFlights(String from, String to, Number fareA, Number fareB) {
//        return flightDataAccessService.getFilterFlights(from, to, fareA, fareB);
//	}

}
