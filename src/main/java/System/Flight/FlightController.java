package System.Flight;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/flights")
public class FlightController {
	
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }
    
    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }
    
    @GetMapping("{flightId}")
    public List<Flight> getFlightById(@PathVariable("flightId") UUID flightId) {
        return flightService.getFlightById(flightId);
    }
    
    @PostMapping
    public String addNewFlight(@RequestBody  Flight flight) {
        String returnMessage = flightService.addNewFlight(flight);
        return returnMessage;
    }
    
    @DeleteMapping("{flightId}")
    public String deleteFlight(@PathVariable("flightId") UUID flightId) {
        return flightService.deleteFlight(flightId);
    }
    
    @PutMapping("{flightId}")
    public String updateFlight(@PathVariable("flightId") UUID flightId,
                              @RequestBody Flight updatedFlight) {
        return flightService.updateFlight(flightId, updatedFlight);
    }
    
    @GetMapping("/filter")
    public List<Flight> getFilterFlights(
    		@RequestParam(required = false) String from,
    		@RequestParam(required = false) String to,
    		@RequestParam(required = false) Number fareA,
    		@RequestParam(required = false) Number fareB) {
        return flightService.getFilterFlights(from, to, fareA, fareB);
    }
}
