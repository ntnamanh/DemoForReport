package com.example.demo.account;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document(collection = "account")
public class Account {
    @Id
    private String id;
    private String username;
    private String password;
    private Person person;
    private boolean role;

    public Account(String username, String password, boolean role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" + "username: " + username + "\n" + "password: " + password;
    }
}
