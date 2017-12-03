public class Main {
    public static void main(String[] args) {
        Extension e = new Extension();
        e.getExtension("D:/torrent");
        for (int i = 0; i < e.foldersSize(); i++) {
            e.getExtension(e.getFolder(i));
        }
    }
}