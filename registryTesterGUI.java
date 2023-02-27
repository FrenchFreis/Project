import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class registryTesterGUI {
    JButton login, register;

    public void Registerme() {
        JFrame frame = new JFrame();

        login = new JButton();

        login.setText("Login");
        login.setBounds(130, 350, 100, 20);

        register = new JButton();
        register.setText("Registerfdsf");
        register.setBounds(240, 350, 100, 20);

        JTextField user, pass;

        user = new JTextField();
        pass = new JTextField();

        user.setBounds(130, 310, 210, 20);
        pass.setBounds(130, 290, 210, 20);

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

}
