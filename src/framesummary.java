import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class framesummary implements ActionListener {
    JFrame frame = new JFrame();
    JLabel heading = new JLabel("");
    JLabel summ1 = new JLabel(" ");
    JLabel summ2 = new JLabel(" ");
    JLabel summ3 = new JLabel(" ");
    JLabel summ4 = new JLabel(" ");
    JLabel summ5 = new JLabel(" ");
    JLabel finallable = new JLabel(" ");
    JLabel why = new JLabel(" ");
    JTextField feild = new JTextField();

    JButton buttonexit = new JButton("Exit");
    JButton again = new JButton("Try Again");

    framesummary() {
        heading.setBounds(50, 10, 200, 25);
        heading.setFont(new Font(null, Font.BOLD, 12));
        
        summ1.setBounds(90, 30, 350, 25);
        summ1.setFont(new Font(null, Font.BOLD, 12));
        summ2.setBounds(90, 60, 350, 25);
        summ2.setFont(new Font(null, Font.BOLD, 12));
        summ3.setBounds(90, 90, 350, 25);
        summ3.setFont(new Font(null, Font.BOLD, 12));
        summ4.setBounds(90, 120, 350, 25);
        summ4.setFont(new Font(null, Font.BOLD, 12));
        summ5.setBounds(90, 150, 350, 25);
        summ5.setFont(new Font(null, Font.BOLD, 12));
        
        finallable.setBounds(170, 180, 200, 25);
        finallable.setFont(new Font(null, Font.BOLD, 12));
        why.setBounds(160, 10, 200, 25);
        why.setFont(new Font(null, Font.BOLD, 12));

        buttonexit.setBounds(250, 210, 100, 25);
        buttonexit.addActionListener(this);
        again.setBounds(130, 210, 100, 25);
        again.addActionListener(this);
        
        frame.add(why);
        frame.add(buttonexit);
        frame.add(feild);
        frame.add(heading);
        frame.add(summ1);
        frame.add(summ2);
        frame.add(summ3);
        frame.add(summ4);
        frame.add(summ5);
        frame.add(finallable);
        frame.add(again);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(480, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == again) {

            new framename();
            summ1.setText("");
            summ2.setText("");
            summ3.setText("");
            summ4.setText("");
            summ5.setText("");
            frame.setVisible(false);
        }
        if(e.getSource()==buttonexit) {
        	System.exit(1);
        }

    }
}
