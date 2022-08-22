import java.util.ArrayList;

public class Collection {
    private String collectionName;
    private ArrayList<Album> albumCollection;
    private ArrayList<Playlist> playlistCollection;

    // Constructor
    public Collection(String name) {
        this.collectionName = name;
        this.albumCollection = new ArrayList<Album>();
        this.playlistCollection = new ArrayList<Playlist>();
    }

    // Getters
    public ArrayList<Album> getAlbums() {
        return this.albumCollection;
    }
    public ArrayList<Playlist> getPlaylists() {
        return this.playlistCollection;
    }

    // Methods
    public boolean addAlbumToCollection(Album album) {
        if (retrieveAlbum(album.getAlbumName()) == null) {
            this.albumCollection.add(album);
            return true;
        } else {
            return false;
        }

    }
    public boolean addPlaylistToCollection(Playlist playlist) {
        if (retrievePlaylist(playlist.getPlaylistName()) == null) {
            this.playlistCollection.add(playlist);
            return true;
        } else {
            return false;
        }

    }

    public Album retrieveAlbum(String albumName) {
        for (int i = 0; i < albumCollection.size(); i++) {
            Album currentAlbum = albumCollection.get(i);
            if (currentAlbum.getAlbumName().equals(albumName)) {
                return currentAlbum;
            }
        }
        return null;
    }
    public Playlist retrievePlaylist(String playlistName) {
        for (int i = 0; i < playlistCollection.size(); i++) {
            Playlist currentPlaylist = playlistCollection.get(i);
            if (currentPlaylist.getPlaylistName().equals(playlistName)) {
                return currentPlaylist;
            }
        }
        return null;
    }
}
