package com.example.demo.account;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
}
