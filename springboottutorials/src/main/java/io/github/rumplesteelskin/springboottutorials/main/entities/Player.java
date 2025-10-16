package io.github.rumplesteelskin.springboottutorials.main.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
