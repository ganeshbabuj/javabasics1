package com.example.gameconsole;

import java.util.Arrays;

public class Game {

    private int count;
    private Playable[] playables = new Playable[10];

    public Playable[] getPlayables() {
        return Arrays.copyOfRange(this.playables, 0, count);
    }

    public void addPlayable(Playable playable) {
        playables[count++] = playable;
    }
}
