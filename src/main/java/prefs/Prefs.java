package prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    public static final String JDBC_CONNECTION_URL = "jdbcUrl";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = String.join("\n", Files.readAllLines(Paths.get(filename)));
            prefs = new Gson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getString(String key){
        return  prefs.get(key).toString();
    }
}
