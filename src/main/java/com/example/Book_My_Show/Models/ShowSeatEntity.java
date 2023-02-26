package com.example.Book_My_Show.Models;


import com.example.Book_My_Show.Enum.SeatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "show_seats")
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id ;
    private  String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;



    private boolean booked;



    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;


    @ManyToOne
    @JoinColumn
    private TicketEntity ticketEntity;

}
