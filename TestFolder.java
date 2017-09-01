import attributeAD.InfoAD;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFolder {

    private final static String PATH_FOLDER = ".";

    public static void main(String[] args) throws IOException {


//        Object[] o = Files.lines(Paths.get("mail.csv"), StandardCharsets.UTF_8).toArray();
        List<String> a = Files.readAllLines(Paths.get("mail.csv"),StandardCharsets.UTF_8);
        System.out.println(a.get(0));
       // for (int i = 0; i < o.length; i++) {
            ArrayList<String> arrayList = getUserName(a.get(0));

//            String user = arrayList.get(0);
//            String post = arrayList.get(1);
//            String workNumb = arrayList.get(2);
//            String mobileNumb = arrayList.get(3);

            String user = arrayList.get(0);
            String post = arrayList.get(1);
            String workNumb = arrayList.get(2);
            String mobileNumb = arrayList.get(3);

            System.out.println("name: " + user + " post: " + post + " numb: " + workNumb + " mob: " + mobileNumb);
        String[] commands = {"powershell.exe","Import-Module ActiveDirectory \n",
                "Set-ADUser " + user + " -Replace @{title='\"" + post + "\"'} \n",
                "Set-ADUser " + user + " -Replace @{telephoneNumber='\"" + workNumb + "\"'} \n",
                "Set-ADUser " + user + " -Replace @{mobile='\"" + mobileNumb + "\"'} "};

        for (String s: commands
             ) {
            System.out.println(s);
        }

        try {
            Process powerShellProcess = Runtime.getRuntime().exec(commands);
            powerShellProcess.getOutputStream().close();
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

        }
//    }

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

    private static ArrayList<String> getUserName(String data){
        Pattern p = Pattern.compile("^(.*),(.*),(.*),(.*)");
        Matcher m = p.matcher(data);
        ArrayList<String> dataList = new ArrayList<>();
        if(m.find())
        {
            dataList.add(m.group(1));
            dataList.add(m.group(2));
            dataList.add(m.group(3));
            dataList.add(m.group(4));
            return dataList;
        }
        return null;
    }

}
