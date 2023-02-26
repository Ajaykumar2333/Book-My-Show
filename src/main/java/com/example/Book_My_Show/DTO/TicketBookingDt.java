package com.example.Book_My_Show.DTO;

import com.example.Book_My_Show.Models.ShowEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TicketBookingDt {
    private int showID;

    private int userID;
 private List<String > requestedSeats;

}
