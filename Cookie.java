package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {

    String dirPath = "data2";
    String fileName = "cookie.txt";

    List<String> cookieItems = null;

    public void readCookieFile() throws FileNotFoundException {
        cookieItems = new ArrayList<>();

        File file = new File(dirPath + File.separator + fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String readString;

        try {
            while ((readString = br.readLine())!= null) {
                cookieItems.add(readString);
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    public String returnCookie() {

        Random rand = new Random();

        if (cookieItems != null) {

            return cookieItems.get(rand.nextInt(cookieItems.size()));
            
        } else {
            return "there is no cookie";
        }
        
    }

    public void showCookies() {

        if (cookieItems != null) {

            // option 1
            cookieItems.forEach(e -> System.out.println(e));

            // option 2
            // for (String string : cookieItems) {
            //     System.out.println(string);
            // }
            
        }
        
    }
    
}
