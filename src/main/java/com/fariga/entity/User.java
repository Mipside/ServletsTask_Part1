package com.fariga.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String status;
}
