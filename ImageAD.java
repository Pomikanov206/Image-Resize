package attributeAD;

public class ImageAD {

    public static void setImage(String user){

        String[] commands = {"powershell.exe","Import-Module ActiveDirectory \n",
                "$photo = [byte[]](Get-Content D:\\Photo\\" + user + ".jpg -Encoding byte) \n",
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
