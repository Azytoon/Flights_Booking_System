package System.Ticket;

import java.util.List;
import java.util.UUID;

import System.Flight.Flight;
import System.User.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDataAccessService {
private final JdbcTemplate jdbcTemplate;

    
    public TicketDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /********************LIST Tickets******************/
    public List<Ticket> selectAllTickets() {
        String sql = "" +
                "SELECT * from tickets";

        return jdbcTemplate.query(sql, mapTicketFromDb());
    }
    public List<Ticket> getTicketsByTicketId(UUID ticketId) {
        String sql = "" +
                "SELECT * FROM tickets "+
                "WHERE ticket_id = '"+ticketId+"'";

        return jdbcTemplate.query(sql, mapTicketFromDb());
    }
    public List<Ticket> getTicketsByUserId(UUID userId) {
        String sql = "" +
                "SELECT * FROM tickets "+
                "WHERE user_id = '"+userId+"'";

        return jdbcTemplate.query(sql, mapTicketFromDb());
    }
    public List<Ticket> getTicketsByFlightId(UUID flightId) {
        String sql = "" +
                "SELECT * FROM tickets "+
                "WHERE flight_id = '"+flightId+"'";

        return jdbcTemplate.query(sql, mapTicketFromDb());
    }
    public List<Ticket> checkTicketId(UUID ticketId) {
        String sql = "" +
                "SELECT * FROM tickets "+
                "WHERE ticket_id = '"+ticketId+"'";

        return jdbcTemplate.query(sql, mapTicketFromDb());
    }
    public List<User> checkUserId(UUID userId) {
        String sql = "" +
                "SELECT * FROM users "+
                "WHERE user_id = '"+userId+"'";

        return jdbcTemplate.query(sql, mapUserFromDb());
    }
    public List<Flight> checkFlightId(UUID flightId) {
        String sql = "" +
                "SELECT * FROM flights "+
                "WHERE flight_id = '"+flightId+"'";

        return jdbcTemplate.query(sql, mapFlightFromDb());
    }
    /*****************MAP*****************************/  			 
    private RowMapper<Ticket> mapTicketFromDb() {
        return (resultSet, i) -> {
        	String ticketIdStr = resultSet.getString("ticket_id");
            UUID TicketId = UUID.fromString(ticketIdStr);
            
            String flightIdStr = resultSet.getString("flight_id");
            UUID FlightId = UUID.fromString(flightIdStr);
            
            String userIdStr = resultSet.getString("user_id");
            UUID UserId = UUID.fromString(userIdStr);
            
            String TicketClass = resultSet.getString("ticketClass");
            
            return new Ticket(
            		TicketId,
                    FlightId,
                    UserId,
                    TicketClass	    
            );
        };
    }
    
    private RowMapper<Flight> mapFlightFromDb() {
        return (resultSet, i) -> {
            String flightIdStr = resultSet.getString("flight_id");
            UUID FlightId = UUID.fromString(flightIdStr);
            String From = resultSet.getString("from_city");
            String To = resultSet.getString("to_city");
            Number classA_Fare = resultSet.getInt("fareA");
            Number classB_Fare = resultSet.getInt("fareB");
            String departureTime = resultSet.getString("departureTime");
            String arrivalTime = resultSet.getString("arrivalTime");
            
            return new Flight(
                    FlightId,
                    From,
                    To,
                    classA_Fare,
                    classB_Fare,
                    departureTime,
                    arrivalTime  	    
            );
        };
    }
    
    private RowMapper<User> mapUserFromDb() {
        return (resultSet, i) -> {
            String userIdStr = resultSet.getString("user_id");
            UUID UserId = UUID.fromString(userIdStr);

            String Name = resultSet.getString("user_name");
            
            return new User(
                    UserId,
                    Name
            );
        };
    }
    /*****************ADD**************************/
    public int insertTicket(UUID ticketId, Ticket ticket) {
        String sql = "" +
                "INSERT INTO tickets (" +
                " ticket_id, " +
                " flight_id, " +
                " user_id, " +
                " ticketClass )" +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                ticketId,
                ticket.getFlightId(),
                ticket.getUserId(),
                ticket.getTicketClass()
        );
    }
    public void checkTicket(Ticket ticket) {
    	if(checkUserId(ticket.getUserId()).size() == 0) {
    		throw new IllegalArgumentException("userId Not Exist");
    	}
    	if(checkFlightId(ticket.getFlightId()).size() == 0) {
    		throw new IllegalArgumentException("flightId Not Exist");
    	}
    	if (!ticket.getTicketClass().equals("classA") &&
            !ticket.getTicketClass().equals("classB")) {
    		throw new IllegalArgumentException(
    				"TicketClass should be classA or classB");
    	}
    }
    /****************DELETE*************************/
	public int deleteTicketById(UUID ticketId) {
	        String sql = "" +
	                "DELETE FROM tickets " +
	                "WHERE ticket_id = ?";
	        return jdbcTemplate.update(sql, ticketId);
	}
	/***************Update********************/
    int updateTicketClass(UUID ticketId, String ticketClass) {
        String sql = "" +
                "UPDATE tickets " +
                "SET ticketClass = ? " +
                "WHERE ticket_id = ?";
        return jdbcTemplate.update(sql, ticketClass, ticketId);
    }
//    /****************FILTER*******************/
//	public List<Flight> getFilterFlights(String from, String to, Number fareA, Number fareB) {
//      String sql = "" +"SELECT * FROM flights WHERE flight_id IS NOT null ";
//      
//      if(from != null) sql+="AND from_city = '"+from+"' ";
//      if(to != null) sql+="AND to_city = '"+to+"' ";
//      if(fareA != null) sql+="AND fareA = '"+fareA+"' ";
//      if(fareB != null) sql+="AND fareB = '"+fareB+"' ";
//        
//      return jdbcTemplate.query(sql, mapFlightFromDb());
//	}


}
