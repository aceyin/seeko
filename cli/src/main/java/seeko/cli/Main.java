package seeko.cli;

/**
 * Created by aceyin on 13-11-21.
 */
public class Main {
    public static void main(String... args) {
        System.out.println("Trying to get FILE_FILTERS: ");
        System.out.println(System.getenv("FILE_FILTERS"));
        System.out.println(System.getProperty("FILE_FILTERS"));
    }
}
