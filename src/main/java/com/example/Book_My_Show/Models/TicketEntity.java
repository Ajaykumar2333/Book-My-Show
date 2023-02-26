package com.example.Book_My_Show.Models;


import jdk.jfr.MemoryAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tickets")
public class TicketEntity {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String alloted_seats;

    private int amount;

    private Date bookedAt;


    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    private List<ShowSeatEntity> bookedSeats;





}
