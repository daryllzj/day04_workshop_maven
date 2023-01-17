package sdf;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        String dirPath = "data2";
        File newDir = new File(dirPath);

        if (newDir.exists()) {
            System.out.println("Directory already exists");
        } else {
            newDir.mkdir();
        }

        Cookie cookie = new Cookie();
        // cookie.readCookieFile();
        // System.out.println("\nall cookies");
        // cookie.showCookies();
        // System.out.println("\nrandom cookie");
        // System.out.println(cookie.returnCookie());

        // Server
        ServerSocket ss = new ServerSocket(12345);
        System.out.println("building connection...");
        Socket s = ss.accept(); // establish connection and wait for client to connect

        System.out.println("connection established");

        cookie.readCookieFile();

        try (InputStream is = s.getInputStream()){
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String msgReceived = "";

            try (OutputStream os = s.getOutputStream()) {
                BufferedOutputStream bos = new BufferedOutputStream(os);
                DataOutputStream dos = new DataOutputStream(bos);

            while (!msgReceived.equals("close")) {
                msgReceived = dis.readUTF();

                if (msgReceived.equalsIgnoreCase("get-cookie")) {
                    String cookieValue = cookie.returnCookie();
                    System.out.println(cookieValue);

                    dos.writeUTF(cookieValue);
                    dos.flush();
                }
            }
            dos.close();
            bos.close();
            os.close();
    
        } catch (EOFException e) {
            e.printStackTrace();
            s.close();
            ss.close();
        }



    }
}
}
