package week7_assignment.p2;

import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    Playlist(int maxSize) {
        songs = new String[maxSize];
        count = 0;
    }

    void addSong(String title) {
        if (count >= songs.length) {
            System.out.println("Playlist is full");
            return;
        }
        songs[count++] = title;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println(p.getSongs()[0]);
        System.out.println(p.getSongCount());
    }
}
