package com.lamdaschool.bunnies;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Bunny
{
    private @Id @GeneratedValue Long id;
    private String name;
    private double weight;

    public Bunny()
    {
        // default constructor
    }

    public Bunny(String name, double weight)
    {
        this.name = name;
        this.weight = weight;
    }
}
