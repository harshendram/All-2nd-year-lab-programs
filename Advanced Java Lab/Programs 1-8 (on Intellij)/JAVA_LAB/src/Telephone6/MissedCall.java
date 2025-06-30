package Telephone6;

import java.time.LocalTime;


public class  MissedCall
{
    LocalTime time;
    String name;
    long number;

    public MissedCall(LocalTime time, String name, long number)
    {
        this.time = time;
        this.name = name;
        this.number = number;
    }

    public String toString()
    {
        return "Time: " + time + ", Name: " + name + ", Number: " + number;
    }
}