public class Song {
    private String title;
    private String duration;

    // Constructor
    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getters

    public String getTitle() {
        return this.title;
    }
    public String getDuration() {
        return this.duration;
    }

    // Method

    public static Song createSong(String title, String duration) {
        Song newSong = new Song(title, duration);
        return newSong;
    }
}
