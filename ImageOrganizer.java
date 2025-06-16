import java.io.*;
public class ImageOrganizer {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\nagos\\OneDrive\\Pictures\\Saved Pictures"); 
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Folder not found.");
            return;
        }
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                String ext = getExtension(file.getName());
                if (ext.equals("jpg") || ext.equals("png")) {
                    File newDir = new File(folder, ext);
                    newDir.mkdir();
                    file.renameTo(new File(newDir, file.getName()));
                }
            }
        }
        System.out.println("Images organized by extension.");
    }
    static String getExtension(String name) {
        int dot = name.lastIndexOf(".");
        return (dot == -1) ? "" : name.substring(dot + 1).toLowerCase();
    }
}
