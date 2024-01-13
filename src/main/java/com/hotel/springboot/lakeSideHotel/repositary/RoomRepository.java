package com.hotel.springboot.lakeSideHotel.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.springboot.lakeSideHotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

	Room save(Room room);

}
