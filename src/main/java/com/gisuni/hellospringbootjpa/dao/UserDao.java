package com.gisuni.hellospringbootjpa.dao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "userdata")
public class UserDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long  Id;

    @Column(name = "user_name")
    public String name;

    @Column(name = "user_age")
    public int age;

    @Column(name = "user_address")
    public String address;

    public Date registerTime;
}
