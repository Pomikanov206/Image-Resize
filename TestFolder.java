import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFolder {

    private final static String PATH_FOLDER = ".";

    public static void main(String[] args) throws IOException {

        ArrayList<String> arrayList = new ArrayList<>();
        String[] s = new String[50];

        Object[] o = Files.lines(Paths.get("src\\images\\mail.csv"), StandardCharsets.UTF_8).toArray();
        for (int i = 0; i < o.length; i++)
            System.out.println(o[i].toString());

        System.out.println(gerUserName("agro100,Петя,336,258"));
    }

    private static String gerUserName(String data){
        Pattern p = Pattern.compile("^(.*),(.*),(.*),(.*)");
        Matcher m = p.matcher(data);
        if(m.find())
        {
            String name = m.group(1);
            String post = m.group(2);
            String numb = m.group(3);
            String mob = m.group(4);
            return "name: " + name + "post: " + post + "numb: " + numb + "mob: " + mob;
        }
        return null;
    }

}
