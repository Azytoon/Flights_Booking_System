package System.Flight;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDataAccessService {
	private final JdbcTemplate jdbcTemplate;

    
    public FlightDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /********************LIST FLIGHTS******************/
    public List<Flight> selectAllFlights() {
        String sql = "" +
                "SELECT " +
                " flight_id, " +
                " from_city, " +
                " to_city, " +
                " fareA, " +
                " fareB, " +
                " departureTime, " +
                " arrivalTime " +
                "FROM flights";

        return jdbcTemplate.query(sql, mapFlightFromDb());
    }
    public List<Flight> selectFlightById(UUID flightId) {
        String sql = "" +
                "SELECT " +
                " flight_id, " +
                " from_city, " +
                " to_city, " +
                " fareA, " +
                " fareB, " +
                " departureTime, " +
                " arrivalTime " +
                "FROM flights "+
                "WHERE flight_id = '"+flightId+"'";

        return jdbcTemplate.query(sql, mapFlightFromDb());
    }
    /*****************MAP*****************************/  			 
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
    /*****************ADD**************************/
    public int insertFlight(UUID flightId, Flight flight) {
        String sql = "" +
                "INSERT INTO flights (" +
                " flight_id, " +
                " from_city, " +
                " to_city, " +
                " fareA, " +
                " fareB, " +
                " departureTime, " +
                " arrivalTime )" +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                flightId,
                flight.getFrom(),
                flight.getTo(),
                flight.getClassA_Fare(),
                flight.getClassB_Fare(),
                flight.getDepartureTime(),
                flight.getArrivalTime()
        );
    }
    /****************DELETE*************************/
	public int deleteFlightById(UUID flightId) {
	        String sql = "" +
	                "DELETE FROM flights " +
	                "WHERE flight_id = ?";
	        return jdbcTemplate.update(sql, flightId);
	}
	/***************Update********************/
    int updateFromCity(UUID flightId, String fromCity) {
        String sql = "" +
                "UPDATE flights " +
                "SET from_city = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, fromCity, flightId);
    }
    int updateToCity(UUID flightId, String toCity) {
        String sql = "" +
                "UPDATE flights " +
                "SET to_city = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, toCity, flightId);
    }
    int updateClassA_Fare(UUID flightId, Number fareA) {
        String sql = "" +
                "UPDATE flights " +
                "SET fareA = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, fareA, flightId);
    }
    int updateClassB_Fare(UUID flightId, Number fareB) {
        String sql = "" +
                "UPDATE flights " +
                "SET fareB = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, fareB, flightId);
    }
    int updateDepartureTime(UUID flightId, String departureTime) {
        String sql = "" +
                "UPDATE flights " +
                "SET departureTime = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, departureTime, flightId);
    }
    int updateArrivalTime(UUID flightId, String arrivalTime) {
        String sql = "" +
                "UPDATE flights " +
                "SET arrivalTime = ? " +
                "WHERE flight_id = ?";
        return jdbcTemplate.update(sql, arrivalTime, flightId);
    }
    /****************FILTER*******************/
	public List<Flight> getFilterFlights(String from, String to, Number fareA, Number fareB) {
      String sql = "" +"SELECT * FROM flights WHERE flight_id IS NOT null ";
      
      if(from != null) sql+="AND from_city = '"+from+"' ";
      if(to != null) sql+="AND to_city = '"+to+"' ";
      if(fareA != null) sql+="AND fareA = '"+fareA+"' ";
      if(fareB != null) sql+="AND fareB = '"+fareB+"' ";
        
      return jdbcTemplate.query(sql, mapFlightFromDb());
	}

}
