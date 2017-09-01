package attributeAD;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataLoad {
    private String path;
    public DataLoad(String path)
    {
        this.path = path;
    }

    public Object[] loadFile(){
        Object[] o = null;
        try {
            o = Files.lines(Paths.get(path), StandardCharsets.UTF_8).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return o;
    }
}
