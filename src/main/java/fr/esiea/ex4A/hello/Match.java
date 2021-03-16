package fr.esiea.ex4A.hello;

public class Match {
    final private String name;
    final private String twitter;

    public Match(String name, String twitter) {
        this.name = name;
        this.twitter = twitter;
    }

    public String getName() {
        return name;
    }

    public String getTwitter() {
        return twitter;
    }
}
