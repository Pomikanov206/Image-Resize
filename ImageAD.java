package attributeAD;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageAD {

    private static String user = null;

    public static void setImage(String path){

        Pattern p = Pattern.compile("^(.*)\\.jpg");
        Matcher m = p.matcher(path.toLowerCase());
        if(m.find()) {
            user = m.group(1);
            System.out.println(user);
        }
        String[] commands = {"powershell.exe"," Import-Module ActiveDirectory \n",
                "$photo = [byte[]](Get-Content D:\\Photo\\scaled\\" + user + ".jpg -Encoding byte) \n",
                "Set-ADUser " + user + " -Replace @{thumbnailPhoto=$photo} \n",
                "Set-ADUser " + user + " -Replace @{jpegPhoto=$photo} "};

        try {
            Process powerShellProcess = Runtime.getRuntime().exec(commands);
            powerShellProcess.getOutputStream().close();
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }
}
