import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Gui Frame = new Gui();
        Frame.setContentPane(Frame.mainPanel);
        Frame.setTitle("GUI demo");
        Frame.setSize(420,420);
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
