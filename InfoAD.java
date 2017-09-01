package attributeAD;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoAD {

    public void setAttribute(String data){
        Object[] arrayData = loadData(data);

        for (int i = 0; i < arrayData.length; i++)
        {
            startSet(arrayData[i].toString());
        }
    }

    private static void startSet(String data){

        ArrayList<String > arrayList = getAttribute(data);

        String user = arrayList.get(0);
        String post = arrayList.get(1);
        String workNumb = arrayList.get(2);
        String mobileNumb = arrayList.get(3);

        System.out.println("name: " + user + " post: " + post + " numb: " + workNumb + " mob: " + mobileNumb);

        String[] commands = {"powershell.exe","Import-Module ActiveDirectory \n",
                "Set-ADUser " + user + " -Replace @{title='\"" + post + "\"'} \n",
                "Set-ADUser " + user + " -Replace @{telephoneNumber='\"" + workNumb + "\"'} \n",
                "Set-ADUser " + user + " -Replace @{mobile='\"" + mobileNumb + "\"'} "};

        try {
            Process powerShellProcess = Runtime.getRuntime().exec(commands);
            powerShellProcess.getOutputStream().close();
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    private static Object[] loadData(String path){
        DataLoad dataLoad = new DataLoad(path);
        Object[] data = dataLoad.loadFile();
        return data;
    }

    private static ArrayList<String> getAttribute(String data){
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
