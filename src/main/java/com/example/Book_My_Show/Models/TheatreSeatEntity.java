package com.example.Book_My_Show.Models;

import com.example.Book_My_Show.Enum.SeatType;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "theatre_seats")
public class TheatreSeatEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;

    //    @Column(columnDefinition = "seat_no",nullable = false)
    String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;


    private int rate;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;

    public TheatreSeatEntity( String seatNo,SeatType seatType,int rate){
        this.seatNo = seatNo;
        this.rate = rate;
        this.seatType =seatType;
    }


}
