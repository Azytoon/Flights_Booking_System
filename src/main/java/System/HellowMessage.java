package System;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HellowMessage {
    @GetMapping
    public String WelcomMessage() {
        return "Hellow in Flights_Booking_System App";
    }
}
