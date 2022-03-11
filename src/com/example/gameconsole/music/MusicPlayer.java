package com.example.gameconsole.music;

import com.example.gameconsole.Playable;

public class MusicPlayer implements Playable {

    protected String[] mediaFiles;
    protected int currentMediaFileIndex;

    public MusicPlayer(String[] mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    @Override
    public void play() {
        System.out.println("Music Player: Playing " + mediaFiles[currentMediaFileIndex]);
    }

    public void next() {
        currentMediaFileIndex = ++currentMediaFileIndex % mediaFiles.length;
        System.out.println("Music Player: Moved to index " + (currentMediaFileIndex + 1));
    }

}
