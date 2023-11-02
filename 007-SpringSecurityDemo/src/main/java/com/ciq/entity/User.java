package com.ciq.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String fname;
    private String lname;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {@JoinColumn(name="uid",referencedColumnName = "uid")},inverseJoinColumns = {@JoinColumn(name="rid",referencedColumnName = "rid")})
    private List<Role> roles;
}
