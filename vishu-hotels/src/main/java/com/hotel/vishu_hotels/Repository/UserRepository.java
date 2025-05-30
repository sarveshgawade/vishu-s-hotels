package com.hotel.vishu_hotels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.vishu_hotels.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
