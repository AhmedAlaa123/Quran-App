package com.example.mysqlonline;

public class surahData {
    private String name,city,url;
    private int ayatNumber;
public surahData(String url,String name,String city,int ayatNumber)
{
    this.url=url;
    this.name=name;
    this.city=city;
    this.ayatNumber=ayatNumber;
}
    public String getName() {
        return name;
    }

    public int getAyatNumber() {
        return ayatNumber;
    }

    public String getCity() {
        return city;
    }

    public String getUrl() {
        return url;
    }
}
