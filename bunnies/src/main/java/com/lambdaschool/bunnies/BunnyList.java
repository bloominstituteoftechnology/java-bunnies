package com.lambdaschool.bunnies;

import com.lambdaschool.bunnies.model.Bunny;

import java.util.ArrayList;

public class BunnyList
{
    public ArrayList<Bunny> bunnyList = new ArrayList<Bunny>();

    public BunnyList()
    {
        bunnyList.add(new Bunny("BarnBarn", 5.5));
        bunnyList.add(new Bunny("Cinnamon", 4.7));
        bunnyList.add(new Bunny("Jessica",  5.0));
    }

    public Bunny findBunny(CheckBunny tester)
    {
        for (Bunny b : bunnyList)
        {
            if (tester.test(b))
            {
                return b;
            }
        }
        return null;
    }

    public ArrayList<Bunny> findBunnies(CheckBunny tester)
    {
        ArrayList<Bunny> tempBunnyList = new ArrayList<>();

        for (Bunny b: bunnyList)
        {
            if (tester.test(b))
            {
                tempBunnyList.add(b);
            }
        }

        return tempBunnyList;
    }
}
