package com.ktech.user.service.UserService.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_Table")
@Builder
public class User
{
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name ="NAME",length = 20)
    private String name;
    @Column(name = "EMAIL",length = 100)
    private  String email;
    @Column(name = "ABOUT")
    private String about;
    @Transient
    private List<Rating> ratingList= new ArrayList<>();
   /*  @Transient
    private List<Hotel> hotelList=new ArrayList<>();*/


}
