package ru.mirea.GuildNet;

public class User {
    public String login;
    public String password;
    public App.FamilyStatus fs;
    public int favNum;

    User(String login, String password, App.FamilyStatus fs, int favNum)
    {
        this.login = login;
        this.password = password;
        this.fs = fs;
        this.favNum = favNum;
    }

    public String toString(){
        return "{ USER : login = "+this.login+
                " ; password = "+this.password+
                " ; fs = "+this.fs+
                " ; favNum = "+this.favNum+
                " }";
    }
}
