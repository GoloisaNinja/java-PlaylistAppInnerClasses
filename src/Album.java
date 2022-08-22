import java.util.ArrayList;

public class Album {
    private String albumName;
    private SongList songs;

    // Constructor
    public Album(String name) {
        this.albumName = name;
        this.songs = new SongList();
    }

    // Getters

    public String getAlbumName() {
        return this.albumName;
    }

    // Methods

    public Song findSong(String title) {
        return songs.findSong(title);
    }
    public Song findSong(int trackNumber) {
        return songs.findSong(trackNumber);
    }

    public boolean addSongToAlbum(Song song) {
        return this.songs.addSong(song);
    }

    public void printAlbumDetails(Album album) {
        System.out.println("****" + album.getAlbumName() + "****");
        int track = 1;
        for (Song songToPrint: songs.getSongs()) {
            System.out.println(track + ". " + songToPrint.getTitle() + " --- " + songToPrint.getDuration());
            track++;
        }
    }



    // Inner Classes
    private class SongList {
        private ArrayList<Song> songs;
        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public ArrayList<Song> getSongs() {
            return this.songs;
        }

        private boolean addSong(Song song) {
            if (songs.contains(song)) {
                System.out.println("Song already on album...");
                return false;
            } else {
                this.songs.add(song);
                return true;
            }

        }

        private Song findSong(String title) {
            for (Song checkedSong: this.songs) {
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}
