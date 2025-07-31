package com.hotel.vishu_hotels.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.vishu_hotels.Repository.UserRepository;


@RestController
@RequestMapping("/api/vishu-hotels/user")
public class UserController {

    @Autowired
    private UserRepository userRepository ;

    
    
}   
