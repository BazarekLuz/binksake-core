package eng.core.binksake.common;

public class URLHelper {
    public static String formatArtistName(String input) {
        String illegalCharacters = "\\/:*?<>|\"";
        String regex = "[" + illegalCharacters + "]";
        return input
                .replaceAll(regex, "")
                .replaceAll("\\s+", " ")
                .replace(" ", "-")
                .toLowerCase();
    }
}
