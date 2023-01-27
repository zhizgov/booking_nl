package com.example.bookingnl.domain;

import com.example.bookingnl.exceptions.InvalidData;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String location;

    @NotBlank
    private String imageURL;


    @NotNull
    @Setter(AccessLevel.NONE)
    private double pricePerNight;


    public void setPricePerNight(double pricePerNight) throws InvalidData {
        if(pricePerNight>0){
            this.pricePerNight = pricePerNight;
        }
        else {
            throw new InvalidData();
        }
    }
}
