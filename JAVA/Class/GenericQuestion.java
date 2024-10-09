
class Media<T, U, V> {

    T a;
    U b;
    V c;

    void printDetail() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class AudioSong extends Media<String, Integer, Integer> {

    AudioSong(String name, int length, int releaseDate) {
        this.a = name;
        this.b = length;
        this.c = releaseDate;
    }
}

class VideoSong extends Media<String, Integer, String> {

    VideoSong(String name, int length, String releaseDate) {
        this.a = name;
        this.b = length;
        this.c = releaseDate;
    }
}

class Movie extends Media<String, String, String> {

    Movie(String name, String mainActor, String mainActress) {
        this.a = name;
        this.b = mainActor;
        this.c = mainActress;
    }
}

public class GenericQuestion {

    public static void main(String[] args) {
        AudioSong audio = new AudioSong("Song A", 180, 2020);
        VideoSong video = new VideoSong("Video B", 240, "2021-05-01");
        Movie movie = new Movie("Movie C", "Actor X", "Actress Y");

        audio.printDetail();
        video.printDetail();
        movie.printDetail();
    }
}
