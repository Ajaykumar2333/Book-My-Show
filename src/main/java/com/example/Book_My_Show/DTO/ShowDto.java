package com.example.Book_My_Show.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class ShowDto {

    LocalDate  showDate;
    LocalTime showTime;
     int movieId;
    int theatreId;
    private  double multiplier;

}


