package com.example.gameconsole;

import com.example.gameconsole.animal.Animal;
import com.example.gameconsole.animal.Cat;
import com.example.gameconsole.animal.Dog;
import com.example.gameconsole.music.MusicPlayer;

public class GameConsole {

    public static void main(String[] args) {

        Game game = new Game();

        Dog dog1 = new Dog("Scooby");
        Dog dog2 = new Dog("Tiger");
        Cat cat1 = new Cat("Bella");
        MusicPlayer musicPlayer1 = new MusicPlayer(new String[] {
                "alpha.mp3",
                "beta.mp3",
                "gamma.mp3"
        });

        game.addPlayable(dog1);
        game.addPlayable(dog2);
        game.addPlayable(cat1);
        game.addPlayable(musicPlayer1);

        Playable[] playables = game.getPlayables();

        for(Playable playable: playables) {

            playable.play();

            if(playable instanceof Animal) {
                Animal animal = (Animal) playable;
                animal.eat();
            }

            if(playable instanceof MusicPlayer) {
                MusicPlayer musicPlayer = (MusicPlayer) playable;
                musicPlayer.next();
                musicPlayer.play();
            }
        }

    }
}
