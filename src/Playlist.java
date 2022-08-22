import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String playlistName;
    private SongList songs;

    // Constructor

    public Playlist(String name) {
        this.playlistName = name;
        this.songs = new SongList();
    }

    // Getters

    public String getPlaylistName() {
        return playlistName;
    }

    // Methods

    public boolean addSong(Song song) {
        return songs.addSong(song);
    }
    public void printPlaylistContents() {
        songs.printSongs();
    }
    public void startPlaylist() {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = songs.getSongs().listIterator();
        boolean quit = false;
        boolean goingForward = true;
        String playlistMenu = "Playlist Menu\n" +
                              "press \n" +
                              "0 - quit playlist and return to main menu\n" +
                              "1 - next song\n" +
                              "2 - previous song\n" +
                              "3 - replay track";

        if (songs.getSongs().getFirst().getTitle().isEmpty()) {
            System.out.println("No songs in selected playlist...");
        } else {
            Song track = listIterator.next();
            System.out.println("Now Playing --- " + track.getTitle() + " ---> " + track.getDuration());
        }

        while(!quit) {
            System.out.println(playlistMenu);
            int action = scanner.nextInt();
            switch(action) {
                case 0:
                    System.out.println("Exiting playlist - returning to main menu...");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        Song track = listIterator.next();
                        System.out.println("Now Playing --- " + track.getTitle() + " ---> " + track.getDuration());
                    } else {
                        System.out.println("End of Playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        Song track = listIterator.previous();
                        System.out.println("Now Playing --- " + track.getTitle() + " ---> " + track.getDuration());
                    } else {
                        System.out.println("Already at beginning of playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            Song track = listIterator.previous();
                            System.out.println("Now replaying " + track.getTitle() + " ---> " + track.getDuration());
                            goingForward = false;
                        } else {
                            System.out.println("Already at beginning of playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            Song track = listIterator.next();
                            System.out.println("Now replaying " + track.getTitle() + " ---> " + track.getDuration());
                            goingForward = true;
                        } else {
                            System.out.println("End of Playlist - no more tracks...");
                        }
                    }
                    break;
                default:
                    quit = true;
                    break;
            }
        }

    }


    private class SongList {
        private LinkedList<Song> songs;

        public SongList() {
            this.songs = new LinkedList<>();
        }

        private LinkedList<Song> getSongs() {
            return this.songs;
        }

        private boolean addSong(Song song) {
            if (songs.contains(song)) {
                System.out.println("Song is already in playlist...");
            } else {
                songs.add(song);
                return true;
            }
            return false;
        }
        public Song findSong(String title) {
            for (Song searchedSong: songs) {
                if (searchedSong.getTitle().equals(title)) {
                    return searchedSong;
                }
            }
            return null;
        }
        private void printSongs() {
            ListIterator<Song> songListIterator = this.songs.listIterator();
            System.out.println("**** " + getPlaylistName() + " Track List ****");
            int trackNum = 1;
            if (songs.getFirst().getTitle().isEmpty()) {
                System.out.println(getPlaylistName() + " has no tracks...");
            } else {
                while(songListIterator.hasNext()) {
                    Song track = songListIterator.next();
                    System.out.println(trackNum + ". " + track.getTitle() + " --- " + track.getDuration());
                    trackNum++;
                }
            }

        }
    }
}
