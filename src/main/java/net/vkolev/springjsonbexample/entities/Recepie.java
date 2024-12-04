package net.vkolev.springjsonbexample.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "recepies")
@Data
public class Recepie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String name;
    private Double ppu;

    @Column(columnDefinition = "jsonb")
    private String batters;

    @Column(columnDefinition = "jsonb")
    private String topping;
}
