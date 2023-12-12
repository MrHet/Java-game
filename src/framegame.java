import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class framegame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel laname = new JLabel();
    JLabel lac = new JLabel("Number of Attempt: ");
    JLabel lab = new JLabel("Balance (in £): ");
    JLabel lachan = new JLabel("5");
    JLabel labalance = new JLabel("3");
    JLabel latext = new JLabel("Select any one from below ");
    JLabel laselect1 = new JLabel("1 - Bet Under ");
    JLabel laselect2 = new JLabel("2 - Bet seven ");
    JLabel laselect3 = new JLabel("3 - Bet Over ");
    JTextField userinput = new JTextField("1");
    JButton button = new JButton("Bet");
    JButton buammount = new JButton("Change Stakes");
    JButton buttonexit = new JButton("Exit");
    JRadioButton opt1 = new JRadioButton("");
    JRadioButton opt2 = new JRadioButton("");
    JRadioButton opt3 = new JRadioButton("");
    framesummary summary = new framesummary();

    framegame() {
        String name = laname.getText();
        summary.heading.setText("" + name);
        summary.frame.setVisible(false);
        laname.setBounds(20, 10, 200, 25);
        laname.setFont(new Font(null, Font.BOLD, 12));
        lac.setBounds(320, 10, 200, 25);
        lac.setFont(new Font(null, Font.BOLD, 12));
        lab.setBounds(320, 30, 200, 25);
        lab.setFont(new Font(null, Font.BOLD, 12));
        lachan.setBounds(433, 10, 200, 25);
        lachan.setFont(new Font(null, Font.BOLD, 12));
        labalance.setBounds(405, 30, 200, 25);
        labalance.setFont(new Font(null, Font.BOLD, 12));
        latext.setBounds(150, 40, 200, 25);
        latext.setFont(new Font(null, Font.BOLD, 12));
        laselect1.setBounds(150, 60, 200, 25);
        laselect1.setFont(new Font(null, Font.BOLD, 12));
        laselect2.setBounds(150, 80, 200, 25);
        laselect2.setFont(new Font(null, Font.BOLD, 12));
        laselect3.setBounds(150, 100, 200, 25);
        laselect3.setFont(new Font(null, Font.BOLD, 12));
        userinput.setBounds(320, 130, 120, 23);
        userinput.setFont(new Font(null, Font.PLAIN, 12));
        userinput.setEditable(false);
        opt1.setBounds(230, 64, 20, 20);
        opt2.setBounds(230, 84, 20, 20);
        opt3.setBounds(230, 104, 20, 20);
        button.setBounds(170, 130, 100, 28);
        buammount.setBounds(320, 100, 120, 25);
        buttonexit.setBounds(185, 165, 70, 24);
        button.addActionListener(this);
        buttonexit.addActionListener(this);
        buammount.addActionListener(this);
        ButtonGroup bg = new ButtonGroup();
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);

        frame.add(lac);
        frame.add(lab);
        frame.add(buammount);
        frame.add(opt1);
        frame.add(opt2);
        frame.add(opt3);
        frame.add(buttonexit);
        frame.add(button);
        frame.add(userinput);
        frame.add(laname);
        frame.add(lachan);
        frame.add(labalance);
        frame.add(latext);
        frame.add(laselect1);
        frame.add(laselect2);
        frame.add(laselect3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(480, 270);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int chances = Integer.parseInt(lachan.getText());
        int amount = Integer.parseInt(labalance.getText());
        ;
        if (e.getSource() == buammount) {
            userinput.setEditable(true);
        }
        if (e.getSource() == button) {

            int userstake = Integer.parseInt(userinput.getText());
            diceroll dice = new diceroll();
            int dicenum = dice.total;
            if (userstake <= amount & userstake > 0) {
                switch (chances) {
                case 0:
                    frame.setVisible(false);
                    summary.why.setText("You have used all chances!!!");
                    summary.frame.setVisible(true);
                    
                    break;
                case 1:
                    chances--;
                    if (opt1.isSelected() == true) {
                        if (dicenum < 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You won, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You lost, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    if (opt2.isSelected() == true) {
                        if (dicenum == 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You won, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You lost, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    if (opt3.isSelected() == true) {
                        if (dicenum > 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You won, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ5.setText("You lost, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }

                    frame.setVisible(false);
                    summary.why.setText("You have used all chances!!!");
                    summary.frame.setVisible(true);
                    
                    break;

                case 2:
                    chances--;
                    if (opt1.isSelected() == true) {
                        if (dicenum < 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You won, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You lost, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    if (opt2.isSelected() == true) {
                        if (dicenum == 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You won, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You lost, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    if (opt3.isSelected() == true) {
                        if (dicenum > 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You won, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ4.setText("You lost, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    break;

                case 3:
                    chances--;
                    if (opt1.isSelected() == true) {
                        if (dicenum < 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You won, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You lost, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    if (opt2.isSelected() == true) {
                        if (dicenum == 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You won, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You lost, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    if (opt3.isSelected() == true) {
                        if (dicenum > 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You won, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ3.setText("You lost, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    break;

                case 4:
                    chances--;
                    if (opt1.isSelected() == true) {
                        if (dicenum < 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You won, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You lost, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    if (opt2.isSelected() == true) {
                        if (dicenum == 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You won, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You lost, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    if (opt3.isSelected() == true) {
                        if (dicenum > 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You won, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ2.setText("You lost, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    break;

                case 5:
                    chances--;
                    if (opt1.isSelected() == true) {
                        if (dicenum < 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You won, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You lost, Your bet was Under. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }
                        }
                    }
                    if (opt2.isSelected() == true) {
                        if (dicenum == 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You won, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You lost, Your bet was seven. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    if (opt3.isSelected() == true) {
                        if (dicenum > 7) {
                            JOptionPane.showMessageDialog(frame, "You have won. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount + userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You won, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);

                        } else {
                            JOptionPane.showMessageDialog(frame, "You have lost. Computer has rolled " + dicenum);
                            lachan.setText("" + chances);
                            amount = amount - userstake;
                            labalance.setText("" + amount);
                            summary.summ1.setText("You lost, Your bet was over. Computer has rolled " + dicenum);
                            summary.finallable.setText("Your balanace:£ " + amount);
                            if (amount == 0) {
                                frame.setVisible(false);
                                summary.why.setText("You ran out of money!!!");
                                summary.frame.setVisible(true);
                            }

                        }
                    }
                    break;

                default:
                    break;

                }
            } else if (amount == 0) {
                frame.setVisible(false);
                summary.why.setText("You ran out of money!!!");
                summary.frame.setVisible(true);
                summary.finallable.setText("Your balanace:£ " + amount);
            } else if(userstake<1){
                JOptionPane.showMessageDialog(frame,
                        "Please Enter a Valid Value");
            }
            else {
            	JOptionPane.showMessageDialog(frame,
                        "You dont have enough balance, Please change your stakes");
            }

        }
        if (e.getSource() == buttonexit) {

            System.exit(1);
        }
    }
}
