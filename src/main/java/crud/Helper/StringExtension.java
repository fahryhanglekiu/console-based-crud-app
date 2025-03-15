package Helper;

public class StringExtension {
    private static StringExtension instance;

    public static StringExtension getInstance(){
        if(instance == null)
            instance = new StringExtension();

        return instance;
    }

    public static String Trim(String stringToTrim){
        return stringToTrim.replaceFirst("\\s++$", "");
    }
}
