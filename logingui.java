import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class logingui implements ActionListener {
    JButton login, register;
    JTextField user;
    JPasswordField pass;
    JFrame frame;

    void frontGUI() {
        frame = new JFrame();

        login = new JButton();
        register = new JButton();

        login.setText("Login");
        login.setBounds(130, 350, 100, 20);

        login.addActionListener(new loginAction());

        register.setText("Register");
        register.setBounds(240, 350, 100, 20);

        register.addActionListener(this);

        user = new JTextField();
        pass = new JPasswordField();

        user.setBounds(130, 290, 210, 20);
        pass.setBounds(130, 310, 210, 20);

        JLabel userL = new JLabel("Username");
        userL.setBounds(30, 290, 100, 20);

        JLabel passL = new JLabel("Password");
        passL.setBounds(30, 310, 100, 20);

        // ADDING ELEMENTS
        frame.add(login);
        frame.add(register);
        frame.add(user);
        frame.add(pass);
        frame.add(userL);
        frame.add(passL);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {

            registryOfficialGUI registryObject = new registryOfficialGUI();
            registryObject.Registerme();
        }

    }

    class loginAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String path = "src\\accounts.txt";

            File file = new File(path);

            try {
                Scanner inputBuffer = new Scanner(file);

                while (inputBuffer.hasNext()) {
                    String line = inputBuffer.nextLine();
                    String[] values = line.split("; ");
                    if (values[0].equals(user.getText())) {
                        if (values[1].equals(new String(pass.getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Success amaezing");
                            System.out.println("ID Number: " + values[2]);
                            System.out.println("First Name: " + values[3]);
                            System.out.println("Last Name: " + values[4]);
                            System.out.println("Email Address: " + values[5]);
                        }
                    }
                }
            } catch (FileNotFoundException fe) {
                System.out.println("Something Went Wrong");
                // fe.printStackTrace();

            }
            

        }

    }
}
