package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String lastName;
    
    @Min(value=1)
    private Integer age;

    @NotBlank
    @Email
    private String email;
}
