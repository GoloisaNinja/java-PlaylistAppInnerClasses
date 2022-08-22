import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        Collection newCollection = new Collection("UserCollection");
        startMusicApplication();
        availableActions();
        while (!quit) {
            System.out.println("\nEnter action: (9 to print out all actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Exiting music application...");
                    quit = true;
                    break;
                case 1:
                    createNewAlbum(newCollection);
                    break;
                case 2:
                    addSongToAlbum(newCollection);
                    break;
                case 3:
                    createNewPlaylist(newCollection);
                    break;
                case 4:
                    addSongToPlaylist(newCollection);
                    break;
                case 5:
                    printAlbumSongs(newCollection);
                    break;
                case 6:
                    printPlaylistSongs(newCollection);
                    break;
                case 7:
                    startPlaylist(newCollection);
                    break;
                case 8:
                    printAlbumsInCollection(newCollection);
                    break;
                case 9:
                    availableActions();
                    break;
                default:
                    System.out.println("Action not recognized....");
                    quit = true;
                    break;
            }
        }

    }

    private static void startMusicApplication() {
        System.out.println("Opening Music Application...");
    }
    private static void availableActions() {
        System.out.println("Music Application Actions" + "\n" +
                           "0 - shutdown music application" + "\n" +
                           "1 - create new Album" + "\n" +
                           "2 - create new Song and add to Album" + "\n" +
                           "3 - create new Playlist" + "\n" +
                           "4 - add song to Playlist" + "\n" +
                           "5 - print Album Songs" + "\n" +
                           "6 - print Playlist Songs" + "\n" +
                           "7 - start Playlist" + "\n" +
                           "8 - print Albums in Collection" + "\n" +
                           "9 - print available actions"
                          );
    }
    private static void createNewAlbum(Collection collection) {
        System.out.println("Name your album");
        String albumName = scanner.nextLine();
        Album newAlbum = new Album(albumName);
        collection.addAlbumToCollection(newAlbum);
    }
    private static void addSongToAlbum(Collection collection) {
        System.out.println("Provide the Album you want to add to");
        String albumName = scanner.nextLine();
        Album albumForAddition = collection.retrieveAlbum(albumName);
        if (albumForAddition == null) {
            System.out.println("Album you provided is not in your collection - try creating it first...");
        } else {
            System.out.println("Provide the Song Name you want to add this album");
            String songName = scanner.nextLine();
            System.out.println("Provide the duration of this song");
            String songDuration = scanner.nextLine();
            Song songToAdd = new Song(songName, songDuration);
            albumForAddition.addSongToAlbum(songToAdd);
        }
    }
    private static void createNewPlaylist(Collection collection) {
        System.out.println("Create a name for your Playlist");
        String playlistName = scanner.nextLine();
        Playlist newPlaylist = new Playlist(playlistName);
        collection.addPlaylistToCollection(newPlaylist);
    }
    private static void addSongToPlaylist(Collection collection) {
        System.out.println("What playlist do you want to add to?");
        String playlistName = scanner.nextLine();
        Playlist playlist = collection.retrievePlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist doesn't exist...");
        } else {
            System.out.println("What album is your song from?");
            String albumName = scanner.nextLine();
            Album album = collection.retrieveAlbum(albumName);
            if (album == null) {
                System.out.println("That album is not in your collection...");
            } else {
                System.out.println("What song do you want to add?");
                String songToAdd = scanner.nextLine();
                Song song = album.findSong(songToAdd);
                if (song == null) {
                    System.out.println("Song is not on that album...");
                } else {
                    playlist.addSong(song);
                }
            }
        }
    }
    private static void printAlbumSongs(Collection collection) {
        System.out.println("Which album do you want to see a track list for?");
        String albumName = scanner.nextLine();
        Album album = collection.retrieveAlbum(albumName);
        if (album == null) {
            System.out.println("Album not in your collection...");
        } else {
            album.printAlbumDetails(album);
        }

    }
    private static void printPlaylistSongs(Collection collection) {
        System.out.println("Which Playlist do you want to see a track list for?");
        String playlistName = scanner.nextLine();
        Playlist playlist = collection.retrievePlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist does not exist...");
        } else {
            playlist.printPlaylistContents();
        }
    }
    private static void startPlaylist(Collection collection) {
        System.out.println("Which Playlist do you want to listen to?");
        String playlistName = scanner.nextLine();
        Playlist playlist = collection.retrievePlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist does not exist...");
        } else {
            playlist.startPlaylist();
        }
    }

    private static void printAlbumsInCollection(Collection collection) {
        ArrayList<Album> albums = collection.getAlbums();
        if (albums.size() > 0) {
            System.out.println("****Albums in Collection****");
            for (int i = 0; i < albums.size(); i++) {
                System.out.println((i + 1) + ". " + albums.get(i).getAlbumName());
            }
        } else {
            System.out.println("****No Albums in Collection****");
        }
    }
}