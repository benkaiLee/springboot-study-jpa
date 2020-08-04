package com.gisuni.hellospringbootjpa.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder(value = {"address","age"})

public class User {

    @JsonIgnore
    public Long  Id;

    public String name;
    public int age;
    public String address;

    public List<Person> family;
}
