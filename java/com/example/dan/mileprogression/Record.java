package com.example.dan.mileprogression;

/**
 * Created by dan on 4/12/15.
 */

public class Record {
    private int id;
    private String Time;
    private String Athlete;
    private String Nationality;
    private int Year;

    public Record(int id, String Time, String Athlete, String Nationality, int Year) {
        this.setId(id);
        this.setTime(Time);
        this.setAthlete(Athlete);
        this.setNationality(Nationality);
        this.setYear(Year);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTime() { return Time; }

    public void setTime(String Time) { this.Time = Time; }

    public String getAthlete() { return Athlete; }

    public void setAthlete(String Athlete) { this.Athlete = Athlete; }

    public String getNationality() { return Nationality; }

    public void setNationality(String Nationality) { this.Nationality = Nationality; }

    public int getYear() { return Year; }

    public void setYear(int Year) { this.Year = Year; }

}