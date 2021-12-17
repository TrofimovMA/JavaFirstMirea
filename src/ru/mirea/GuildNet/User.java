package ru.mirea.GuildNet;

public class User {
    public String login;
    public String password;

    User()
    {
        login = "login";
        password = "password";
    }

    User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String toString(){
        return "{ USER : login = "+this.login+" ; password = "+this.password+" }";
    }
}
