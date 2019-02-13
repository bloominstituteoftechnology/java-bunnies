package com.lamdaschool.bunnies;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class BunnyMessage implements Serializable
{
    private final String text;
    private final int priority;
    private final boolean secret;

    public BunnyMessage(@JsonProperty("Text") String text,
                         @JsonProperty("priority") int priority,
                         @JsonProperty("secret") boolean secret)
    {
        this.text = text;
        this.priority = priority;
        this.secret = secret;
    }
}
