import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class GUI {

    public JLabel label;
    public JLabel gen;
    public JFrame frame;

    public GUI()  {
        frame = new JFrame();

        JPanel panel = new JPanel();

        Font font = new Font("Serif", Font.PLAIN, 28);
        label = new JLabel("Hello");
        gen = new JLabel("0");
        label.setFont(font);
        gen.setFont(font);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(gen);

        frame.setPreferredSize(new Dimension(400,300));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);

    }
    void updateGUI(String fittest, int genNum) throws InterruptedException {
        label.setText(fittest);
        gen.setText("Generation: " + genNum);
        TimeUnit.MICROSECONDS.sleep(3);
        frame.repaint();

    }
    public static void main(String[] args) {
        new GUI();



    }

}

