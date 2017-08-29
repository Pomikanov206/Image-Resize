package attributeAD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoAD {

    private static int index = 0;

//    public static void setImage(String data){
//
//        String name = gerUserName(data);
//        String post = getPost(data);
//        String workNumb = getWorkNumber(data);
//        String mobileNumb = getMobileNumb(data);
//        name.
//        String[] commands = {"powershell.exe","Import-Module ActiveDirectory \n",
//                "$photo = [byte[]](Get-Content D:\\Photo\\" + user + ".jpg -Encoding byte) \n",
//                "Set-ADUser " + user + " -Replace @{thumbnailPhoto=$photo} \n",
//                "Set-ADUser " + user + " -Replace @{jpegPhoto=$photo} "};
//
//        try {
//            Process powerShellProcess = Runtime.getRuntime().exec(commands);
//            powerShellProcess.getOutputStream().close();
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getStackTrace());
//        }
//    }

    private static String gerUserName(String data){

        Pattern p = Pattern.compile("^*,");
        Matcher m = p.matcher(data);
        return m.toString();
    }

    private static String getPost(String data){
        return null;
    }

    private static String getWorkNumber(String data){
        return null;
    }
    private static String getMobileNumb(String data){
        return null;
    }
}
