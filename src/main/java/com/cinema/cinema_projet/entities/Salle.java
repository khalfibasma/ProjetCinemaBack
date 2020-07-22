package com.cinema.cinema_projet.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Salle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombrePlaces;
   @ManyToOne
   @JoinColumn(name = "id_cinema")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonIgnore
    private Cinema cinema;
   @OneToMany(mappedBy = "salle")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;


   @OneToMany(mappedBy = "salle")
    private Collection<Projection> projections;
}
