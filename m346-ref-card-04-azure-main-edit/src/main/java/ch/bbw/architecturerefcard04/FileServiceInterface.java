package ch.bbw.architecturerefcard04;

import java.io.File;
import java.util.List;

public interface FileServiceInterface {
    List<String> listFiles();
    void uploadFile(File file);
    byte[] downloadFile(String filename);
    void deleteFile(String filename);
}
