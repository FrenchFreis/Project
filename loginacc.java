import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class loginacc {
    public static void main(String[] args) throws Exception {
        do{
            boolean isLogin = login();
            if(isLogin){
                System.out.println("login is successful");
            }
            else{
                System.out.println("try again");
            }
        }   while(true);
    }
        public static boolean login(){
        Boolean isAuthenticated = false;

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        String path = "accounts.txt";

        File file =  new File(path);

        try { 
            Scanner inputBuffer = new Scanner(file);

            while(inputBuffer.hasNext()){
                String line = inputBuffer.nextLine();
                String[] values = line.split("; ");
                 if (values[0].equals(username)){
                    if (values[1].equals(password)){
                        isAuthenticated = true;
                    }
                 }
            }
        }
        catch(FileNotFoundException fe){
            fe.printStackTrace();

        }
        return isAuthenticated;
}
}