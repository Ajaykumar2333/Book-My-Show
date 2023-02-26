package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TIcketRepo extends JpaRepository<TicketEntity,Integer> {

}
