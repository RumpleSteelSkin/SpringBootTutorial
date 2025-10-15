package io.github.rumplesteelskin.springboottutorials.main.entities;

@SuppressWarnings("unused")
public class Player {
    private long id;
    private String name;
    private double score;

    public Player(long id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
