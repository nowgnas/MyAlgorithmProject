package algorithm;

import java.io.File;

public class Categorizing {

    public static void main(String[] args) {
        String fileDirectory1 = "/Users/nowgnas/ssafy/MyAlgorithmProject/src/algorithm";
        String fileDirectory2 = "/Users/nowgnas/ssafy/MyAlgorithmProject/src/algoclass";
        File dir = new File(fileDirectory1);

        String[] filenames = dir.list();

        for (String name :
                filenames) {
            String packageName = fileDirectory1 + "/" + name;
            File dir2 = new File(packageName);
            String[] packagename = dir2.list();
            for (String name2 :
                    packagename) {
                System.out.println(name2);
            }
        }

    }
}
