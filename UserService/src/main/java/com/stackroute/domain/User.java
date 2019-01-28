/**
 * Muzix Application domain class and used lombok annotations to reduce the number of codes
 */
package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    //Variables
    @Id
    private int userId;
    private String userName;
    private String userGender;
    private int userDOB;

}
