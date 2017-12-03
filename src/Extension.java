import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Extension {
    private ArrayList<String> folders = new ArrayList<>();
    public void getExtension(String dir) {
        int countFolders = 0;
        int countFiles = 0;
        File folder = new File(dir);
        //массив файлов
        File[] files = folder.listFiles();
        //список для сохранения только расширений
        ArrayList<String> extensions = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            //счетчик папок и добавление в список папок из папки
            if (files[i].isDirectory() && !files[i].isHidden()) {
                countFolders++;
                folders.add(files[i].getAbsolutePath());
            }
            //счетчик файлов
            if (files[i].isFile() && !files[i].isHidden()) {
                countFiles++;
            }
            //получение только расширений
            if (files[i].isFile() && !files[i].isHidden()) {
                extensions.add(files[i].getName().substring(files[i].getName().lastIndexOf(".") + 1));
            }
        }
        //Множество, чтобы избавиться от повторений расширений
        Set<String> set = new LinkedHashSet<>(extensions);
        //массив расширений без повторений
        String[] extensionsWithoutDuplicate = set.toArray(new String[set.size()]);

        System.out.println("\nПапка: " + dir + "\nКол-во папок: " + countFolders + " Кол-во файлов: " + countFiles);

        for (int i = 0; i < extensionsWithoutDuplicate.length; i++) {
            System.out.println(extensionsWithoutDuplicate[i] + " - " + Collections.frequency(extensions, extensionsWithoutDuplicate[i]));
        }
    }

    public String getFolder(int i) {
        return folders.get(i);
    }
    public int foldersSize() {
        return folders.size();
    }
}
