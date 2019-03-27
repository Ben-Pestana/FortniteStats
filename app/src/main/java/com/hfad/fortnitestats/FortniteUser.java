package com.hfad.fortnitestats;

public class FortniteUser {

    private String username;
    private String console;
    private String href;

    public FortniteUser(String username, String console, String href) {
        this.username = username;
        this.console = console;
        this.href = href;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "FortniteUser{" +
                "username='" + username + '\'' +
                ", console='" + console + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
