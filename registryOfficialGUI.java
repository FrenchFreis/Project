import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class registryOfficialGUI implements ActionListener {
    JButton back, register;
    JTextField user, userid, userFirstname, userLastname, emailadd;
    JPasswordField pass, pass2;
    JCheckBox checkBox1;
    JFrame frame;

    logingui loginObject = new logingui();

    public void Registerme() {
        frame = new JFrame();

        back = new JButton();

        back.setText("Back");
        back.setBounds(130, 350, 100, 20);
        back.addActionListener(this);

        register = new JButton();
        register.setText("Register");
        register.setBounds(240, 350, 100, 20);
        register.addActionListener(this);

        // user profile
        userid = new JTextField();
        userFirstname = new JTextField();
        userLastname = new JTextField();
        emailadd = new JTextField();

        // user acc
        user = new JTextField();
        pass = new JPasswordField();
        pass2 = new JPasswordField();

        userid.setBounds(130, 190, 210, 20);
        userFirstname.setBounds(130, 210, 210, 20);
        userLastname.setBounds(130, 230, 210, 20);
        emailadd.setBounds(130, 250, 210, 20);

        user.setBounds(130, 270, 210, 20);
        pass.setBounds(130, 290, 210, 20);
        pass2.setBounds(130, 310, 210, 20);

        JLabel idLabel = new JLabel("ID Number");
        idLabel.setBounds(30, 190, 100, 20);

        JLabel fnameLabel = new JLabel("First Name");
        fnameLabel.setBounds(30, 210, 100, 20);

        JLabel lnameLabel = new JLabel("Last Name");
        lnameLabel.setBounds(30, 230, 100, 20);

        JLabel emaiLabel = new JLabel("Email Address");
        emaiLabel.setBounds(30, 250, 100, 20);

        JLabel userL = new JLabel("Username");
        userL.setBounds(30, 270, 100, 20);

        JLabel passL = new JLabel("Password");
        passL.setBounds(30, 290, 100, 20);

        JLabel passL2 = new JLabel("Password");
        passL2.setBounds(30, 310, 100, 20);

        checkBox1 = new JCheckBox("Show Password");
        checkBox1.setBounds(100, 100, 200, 50);
        checkBox1.addActionListener(this);

        // ADDING ELEMENTS
        frame.add(back);
        frame.add(register);

        frame.add(userid);
        frame.add(userFirstname);
        frame.add(userLastname);
        frame.add(emailadd);

        frame.add(user);
        frame.add(pass);
        frame.add(pass2);

        frame.add(idLabel);
        frame.add(fnameLabel);
        frame.add(lnameLabel);
        frame.add(emaiLabel);
        frame.add(userL);
        frame.add(passL);
        frame.add(passL2);

        frame.add(checkBox1);

        frame.setSize(400, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    //UNCOMMENT IF YOU WANT TO TEST BY ITSELF

    // public static void main(String[] args) throws Exception {
    //     registryOfficialGUI registryObject = new registryOfficialGUI();

    //     registryObject.Registerme();

    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {

            loginObject.frontGUI();
        }
        if (e.getSource() == register) {

            String idnum = userid.getText();
            String userfname = userFirstname.getText();
            String userLname = userLastname.getText();
            String useremail = emailadd.getText();

            if (userid.getText().equals("")) {
                idnum = "none";
            }

            if (userFirstname.getText().equals("")) {
                userfname = "none";
            }

            if (userLastname.getText().equals("")) {
                userLname = "none";
            }

            if (emailadd.getText().equals("")) {
                useremail = "none";
            }

            String username = user.getText();
            String passText = new String(pass.getPassword());
            String passText2 = new String(pass2.getPassword());
            if (passText.equals(passText2)) {
                try {
                    FileWriter accwriter = new FileWriter("src\\accounts.txt", true);
                    accwriter.write(username + "; " + passText + "; " + idnum + "; " + userfname + "; " + userLname
                            + "; " + useremail);
                    accwriter.write(System.getProperty("line.separator"));
                    accwriter.close();
                    JOptionPane.showMessageDialog(null, "Success");
                    frame.dispose();
                    loginObject.frontGUI();
                } catch (IOException error) {
                    System.out.println("An error occurred.");
                    error.printStackTrace();
                }
            }

        }

        if (checkBox1.isSelected()) {
            pass.setEchoChar((char) 0);
            pass2.setEchoChar((char) 0);
        } else {
            pass.setEchoChar('*');
            pass2.setEchoChar('*');
        }
    }

}