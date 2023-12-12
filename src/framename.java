import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class framename implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Enter Your Name: ");
    JTextField feild = new JTextField();
    JButton button = new JButton("Begin");
    JFrame framegame = new JFrame();
    JLabel lab = new JLabel("Welcome ! To Betting Game ");

    framename() {
        label.setBounds(118, 98, 200, 25);
        label.setFont(new Font(null, Font.BOLD, 12));
        feild.setBounds(220, 100, 150, 25);
        feild.setFont(new Font(null, Font.PLAIN, 12));
        button.setBounds(190, 140, 100, 20);
        button.addActionListener(this);
        lab.setBounds(140, 40, 300, 25);
        lab.setFont(new Font(null, Font.BOLD, 16));

        
        
        frame.add(lab);
        frame.add(button);
        frame.add(feild);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(480, 270);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = (feild.getText());
        framegame xyz = new framegame();
        xyz.laname.setText("Hello " + name);
        xyz.summary.heading.setText("Hello " + name);
        frame.setVisible(false);
        System.out.print(name);

    }
    public static void main(String[] args) {
        framename begin= new framename();
     }
}
