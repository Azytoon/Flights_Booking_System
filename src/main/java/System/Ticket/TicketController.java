package System.Ticket;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tickets")
public class TicketController {
	
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }
    @GetMapping("ticketId/{ticketId}")
    public List<Ticket> getTicketsByTicketId(
    		@PathVariable("ticketId") UUID ticketId) {
        return ticketService.getTicketsByTicketId(ticketId);
    }
    @GetMapping("userId/{userId}")
    public List<Ticket> getTicketsByUserId(
    		@PathVariable("userId") UUID userId) {
        return ticketService.getTicketsByUserId(userId);
    }
    @GetMapping("/flightId/{flightId}")
    public List<Ticket> getTicketsByFlightId(
    		@PathVariable("flightId") UUID flightId) {
        return ticketService.getTicketsByFlightId(flightId);
    }
    
    @PostMapping
    public String addNewTicket(@RequestBody  Ticket ticket) {
    	return ticketService.addNewTicket(ticket);      
    }
    
    @DeleteMapping("{ticketId}")
    public String deleteTicket(@PathVariable("ticketId") UUID ticketId) {
        return ticketService.deleteTicket(ticketId);
    }
    
    @PutMapping("{ticketId}")
    public String updateTicket(@PathVariable("ticketId") UUID ticketId,
    						   @RequestParam String updatedClass) {
    	return ticketService.updateTicket(ticketId, updatedClass);
    }
    /*
    @GetMapping("/filter")
    public List<Flight> getFilterFlights(
    		@RequestParam(required = false) String from,
    		@RequestParam(required = false) String to,
    		@RequestParam(required = false) Number fareA,
    		@RequestParam(required = false) Number fareB) {
        return flightService.getFilterFlights(from, to, fareA, fareB);
    }
*/
}
