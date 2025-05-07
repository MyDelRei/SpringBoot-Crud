package com.example.subcriptionApi.models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class subcription {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id ;
    private String email;
    private String subcriptionType;
    private BigDecimal price;
    private boolean active;


}
