package com.lambdaschool.bunnies.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicLong;

public class Bunny
{
    private static final Logger logger = LoggerFactory.getLogger(Bunny.class);

    private static final AtomicLong counter = new AtomicLong();
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

        logger.info("We created a bunny");
        logger.debug("Yes we created a bunny with id " + this.id);
    }

    public Bunny(Bunny toClone)
    {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.weight = toClone.getWeight();
    }

    public long getId()
    {
        return id;
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
