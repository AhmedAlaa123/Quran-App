package com.example.mysqlonline;

public class AzkarContent {
    private String zikrContent;
    private  String count;
    public AzkarContent(String zikrContent, String count)

    {
        this.zikrContent=zikrContent;
        this.count=count;
    }

    public String getCount() {
        return count;
    }

    public String getZikrContent() {
        return zikrContent;
    }
}
