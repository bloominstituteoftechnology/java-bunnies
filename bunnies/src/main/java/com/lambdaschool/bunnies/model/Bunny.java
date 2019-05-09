package com.lambdaschool.bunnies.model;

import java.util.concurrent.atomic.AtomicLong;

public class Bunny
{
    private static AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private double weight;

    public Bunny()
    {
    }

    public Bunny(String name, double weight)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.weight = weight;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Bunny{" + "id=" + id + ", name='" + name + '\'' + ", weight=" + weight + '}';
    }
}
