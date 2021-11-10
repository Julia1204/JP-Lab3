import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class LoginWindow extends JFrame{

    private JPanel panel = new JPanel();
    private JFrame frame = new JFrame();
    private JTextField userText = new JTextField(20);
    private JLabel userLabel = new JLabel("User");
    private JPasswordField passwordText = new JPasswordField(20);
    private JLabel passwordLabel = new JLabel("Password");
    private JButton loginButton = new JButton("Login");
    private JButton cancelButton = new JButton("Cancel");
    private HashMap<String, String> data = new HashMap<>();

//*********************************************************************************************************

    public LoginWindow() throws HeadlessException {
        this.setTitle("Login");
        this.setSize(400, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);

        panel.setLayout(null);

        userLabel.setBounds(10, 20, 160, 30);
        panel.add(userLabel);
        userText.setBounds(100, 20, 160, 30);
        panel.add(userText);

        passwordLabel.setBounds(10, 50, 160, 30);
        panel.add(passwordLabel);
        passwordText.setBounds(100, 50, 160, 30);
        panel.add(passwordText);


        loginButton.setBounds(10, 90, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isCorrect();
            }


        });
        panel.add(loginButton);

        cancelButton.setBounds(100, 90, 80, 25);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();

            }
        });
        panel.add(cancelButton);


        passwordText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    loginButton.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        frame.setVisible(true);


    }

    private void isCorrect() {
        data.put("Julia", "abcd");
        data.put("Ala", "ma_kota");
        data.put("Jan", "Kowalski");

        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        if (data.containsKey(user) && data.get(user).equals(password)) {
            panel.setBackground(Color.GREEN);

        } else {
            panel.setBackground(Color.RED);
        }

    }

    private void clear() {
        userText.setText("");
        passwordText.setText("");
        panel.setBackground(Color.white);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginWindow loginWindow = new LoginWindow();
                    loginWindow.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

}
