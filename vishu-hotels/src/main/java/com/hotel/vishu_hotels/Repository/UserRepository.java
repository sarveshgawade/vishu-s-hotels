package com.hotel.vishu_hotels.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.vishu_hotels.Entity.User;
import java.util.List;


/*
 *  Note:
        The field name after 'By' must exactly match the name in the entity.

        So if your entity has private String email; then you must write findByEmail, not findByMail.
 */

public interface UserRepository extends JpaRepository<User,Long> {

    // Optional<User> findById(long id);    

    Optional<User> findByUsername(String username) ;


    /*
     * findByHotel_HotelName uses the underscore _ to navigate nested properties.
        This means: find users where user.hotel.hotelName = ?
     */
   
}
