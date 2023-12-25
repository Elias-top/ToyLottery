package file_system;

import file_system.enums.StatusFileFS;

public interface Logable {
    StatusFileFS writeToLogFile(String file_path, String data);
}
