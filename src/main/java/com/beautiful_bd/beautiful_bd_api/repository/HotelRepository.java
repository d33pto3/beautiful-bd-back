package com.beautiful_bd.beautiful_bd_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.beautiful_bd.beautiful_bd_api.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
