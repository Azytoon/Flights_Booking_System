package System.Flight;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class FlightService {

    private final FlightDataAccessService flightDataAccessService;

    
    public FlightService(FlightDataAccessService flightDataAccessService) {
			this.flightDataAccessService = flightDataAccessService;
	}
    /************LIST**********************/
	public List<Flight> getAllFlights() {
        return flightDataAccessService.selectAllFlights();
	}
	public List<Flight> getFlightById(UUID flightId) {
        return flightDataAccessService.selectFlightById(flightId);
	}
	/************ADD***********************/
	public String addNewFlight(Flight flight) {
        return addNewFlight(null, flight);
    }
	
    String addNewFlight(UUID flightId, Flight flight) {
        UUID newFlightId = Optional.ofNullable(flightId)
                .orElse(UUID.randomUUID());
        if (flight.checkNullFields()) {
        	return "fields can't be null";	
        }
        else {
        	flightDataAccessService.insertFlight(newFlightId, flight);
            return "flight is added successfully";
         }
    }
    /**************DELETE***********************/
	public String deleteFlight(UUID flightId) {
		if (flightDataAccessService.selectFlightById(flightId).size() == 0) {
			throw new NoSuchElementException("flight with this ID not exist");
		}
		else {
	        flightDataAccessService.deleteFlightById(flightId);
	        return "flight is deleted successfully";
		}
	}

	/*******************UPDATE******************/
	public String updateFlight(UUID flightId, Flight updatedFlight) {
		if (flightDataAccessService.selectFlightById(flightId).size() == 0) {
			throw new NoSuchElementException("flight with this ID not exist");
		}
        if (updatedFlight.checkIfAllNullFields()) {
        	return "you should update at least one field";	
        }
        
		Optional.ofNullable(updatedFlight.getFrom())
        .filter(FromCity -> FromCity!= null)
        .map(StringUtils::capitalize)
        .ifPresent(FromCity -> flightDataAccessService.updateFromCity(flightId, FromCity));
		
		Optional.ofNullable(updatedFlight.getTo())
        .filter(ToCity -> ToCity!= null)
        .map(StringUtils::capitalize)
        .ifPresent(ToCity -> flightDataAccessService.updateToCity(flightId, ToCity)); 
		
		Optional.ofNullable(updatedFlight.getClassA_Fare())
        .filter(fareA -> fareA!= null)
        .ifPresent(fareA -> flightDataAccessService.updateClassA_Fare(flightId, fareA)); 
		
		Optional.ofNullable(updatedFlight.getClassB_Fare())
        .filter(fareB -> fareB!= null)
        .ifPresent(fareB -> flightDataAccessService.updateClassB_Fare(flightId, fareB));        
		
		Optional.ofNullable(updatedFlight.getDepartureTime())
        .filter(DepartureTime -> DepartureTime!= null)
        .ifPresent(DepartureTime -> flightDataAccessService.updateDepartureTime(flightId, DepartureTime));
		
		Optional.ofNullable(updatedFlight.getArrivalTime())
        .filter(ArrivalTime -> ArrivalTime!= null)
        .ifPresent(ArrivalTime -> flightDataAccessService.updateArrivalTime(flightId, ArrivalTime)); 
		
		return "Flight updated successfully";
	}
	/**************FILTER*******************/
	public List<Flight> getFilterFlights(String from, String to, Number fareA, Number fareB) {
        return flightDataAccessService.getFilterFlights(from, to, fareA, fareB);
	}
}
	
