package com.cenyu.adapter;

public class MusicAdapter {

    private MediaPlayer mediaPlayer;
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MusicAdapter(MediaPlayer mediaPlayer, AdvancedMediaPlayer advancedMediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    public void play(String type, String fileName) {
        if(type.equals("mp3")) {
            mediaPlayer.playMP3(fileName);
        } else if(type.equals("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if(type.equals("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("format is not supported");
        }
    }
}

interface MediaPlayer {

    void playMP3(String fileName);
}

class Mp3Impl implements MediaPlayer {

    @Override
    public void playMP3(String fileName) {
        System.out.println(fileName + ".mp3 is playing ...");
    }
}

interface AdvancedMediaPlayer {

    void playVlc(String fileName);
    void playMp4(String fileName);
}

class VlcMp4Impl implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println(fileName + ".vlc is playing ...");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println(fileName + ".mp4 is playing ...");
    }
}

class Demo {

    public static void main(String[] args) {
        MusicAdapter adapter = new MusicAdapter(new Mp3Impl(), new VlcMp4Impl());
        adapter.play("mp3", "x");
        adapter.play("mp4", "y");
        adapter.play("vlc", "z");
    }
}
