package file_system;

import java.io.BufferedWriter;
import java.io.FileWriter;

import file_system.enums.StatusFileFS;

public class MakeLogBW implements Logable{

    public StatusFileFS writeToLogFile(String file_path, String data){
        try (BufferedWriter writter = new BufferedWriter(new FileWriter(file_path, true))) {
            writter.write(data + "\n");
        }
        catch (Exception e) {
            e.printStackTrace();
            return StatusFileFS.FileNotWrote;
        }
        return StatusFileFS.FileWrote;        
    }
}
