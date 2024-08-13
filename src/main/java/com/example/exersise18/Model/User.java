package com.example.exersise18.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(10) not null")
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 5)
    private String name;
    @Column(columnDefinition = "varchar(10) not null unique")
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5)
    private String username;
    @NotEmpty(message = "password cannot be empty")
    @Column(columnDefinition = " varchar(10) not null")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    @Column(columnDefinition = "varchar(30) not null unique")
    private String Email;
    @NotEmpty(message = "role cannot be empty")
    @Pattern(regexp = "user|admin", message = "role must be either 'user' or 'admin' only")
@Column(columnDefinition = "varchar(5) not null ")

    private String role;
    @NotNull(message = "name cannot be null")
    @Positive
    @Column(columnDefinition = " int not null")
    private int age;

}
