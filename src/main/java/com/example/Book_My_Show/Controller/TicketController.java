package com.example.Book_My_Show.Controller;

import com.example.Book_My_Show.DTO.TicketBookingDt;
import com.example.Book_My_Show.Models.TicketEntity;
import com.example.Book_My_Show.ServiceLayer.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/add")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/Ticket")
    public String addTicket(@RequestBody TicketBookingDt ticketBookingDt) {
        String ans = " ";

        try {
            ans = ticketService.bookTicket(ticketBookingDt);
        } catch (Exception e) {
            return "Request Seats not available ";
        }
        return ans;


    }
}
