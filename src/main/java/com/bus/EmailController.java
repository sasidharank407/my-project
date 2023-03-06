package com.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bus.beans.OrderHistory;
import com.bus.service.emailservice;

@Controller
public class EmailController {
	@Autowired
    private emailservice emailService;

    @PostMapping("send-booking-email")
    public ResponseEntity<String> sendBookingEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String message, @RequestBody OrderHistory booking) {
        String result = emailService.sendBookingEmail(to, subject, message, booking);
        return ResponseEntity.ok(result);
    }

}
