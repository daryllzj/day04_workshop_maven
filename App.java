package sdf;

import java.io.File;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        String dirPath = "data2";
        File newDir = new File(dirPath);

        if (newDir.exists()) {
            System.out.println("Directory already exists");
        } else {
            newDir.mkdir();
        }

    }
}
