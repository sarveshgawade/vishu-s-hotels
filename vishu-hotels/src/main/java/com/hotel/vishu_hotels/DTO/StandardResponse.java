package com.hotel.vishu_hotels.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * Below annotations are used to reduce writing of boile plate code
 * Data => no need of writing getters and setters
 * NoArgsConstructor => no need of writing default constructor
 * AllArgsConstructor => no need of writing paramaterized constructor
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse<T> {
    private T data ;
    private int statusCode ;
    private String message ;
}
