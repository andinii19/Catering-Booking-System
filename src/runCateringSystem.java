import javax.swing.*;
import java.io.FileNotFoundException;

public class runCateringSystem {
    public static void main(String[] args)throws FileNotFoundException{
        JFrame jFrame = new JFrame("Catering");
        jFrame.setContentPane(new CateringSystem().getRootPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(1000,500);
        jFrame.setVisible(true);
    }
}
