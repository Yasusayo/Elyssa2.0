package nona.mi.elyssa.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.io.File;

public class Gui{

    private JFrame jframe;
    private JPanel mainPanel;

    private JPanel pathPanel;
    private JLabel pathLabel;
    private JTextField pathField;

    private JPanel timePanel;
    private JLabel timeLabel;
    private JTextField timeField;

    private JPanel buttonPanel;
    private JButton check;

    public Gui(){

        jframe = new JFrame("Elyssa2.0");
        jframe.setSize(500, 150);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.setResizable(false);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        pathPanel = new JPanel();
        pathPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pathPanel.setBackground(Color.PINK);

        pathLabel = new JLabel("Rom path: ");
        pathLabel.setForeground(Color.BLACK);
        pathField = new JTextField(36);

        pathPanel.add(pathLabel);
        pathPanel.add(pathField);
        mainPanel.add(pathPanel);

        timePanel = new JPanel();
        timePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        timePanel.setBackground(Color.PINK);

        timeLabel = new JLabel("Time (millis): ");
        timeLabel.setForeground(Color.BLACK);
        timeField = new JTextField(36);

        timePanel.add(timeLabel);
        timePanel.add(timeField);
        mainPanel.add(timePanel);

        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.PINK);

        check = new JButton("START");
        check.setBackground(Color.YELLOW);
        check.setForeground(Color.BLACK);
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Thread t = new Thread(new Runnable(){
                    @Override
                    public void run(){
                        manageInputs();
                    }
                });
                t.start();
            }
        });
        check.addKeyListener(new KeyListener(){
            @Override
            public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Thread t = new Thread(new Runnable(){
                        @Override
                        public void run(){
                            manageInputs();
                        }
                    });
                    t.start();
                }
            }
            @Override
            public void keyTyped(KeyEvent e){

            }
            @Override
            public void keyReleased(KeyEvent e){

            }
        });

        buttonPanel.add(check);
        mainPanel.add(buttonPanel);

        jframe.add(mainPanel);
        jframe.setVisible(true);
    }

    private void manageInputs(){

        String pathText = pathField.getText();
        String timeText = timeField.getText();

        File file = new File(pathText);

        if (file.exists()) {

            String extension = "";
            String fileName = file.getName();
            extension = fileName.substring(fileName.indexOf(".")+1);

            if (extension.equalsIgnoreCase("gba")) {

                try{
                    Integer targetTime = Integer.parseInt(timeText);

                    if (targetTime > 0) {
                        //new MyBot(file, targetTime);
                    }

                } catch(Exception ex){
                    say("Invalid time.");
                }

            } else {
                say("The file does not seem to be .gba.");
            }

        } else {
            say("The file does not exists.");
        }
    }

    private void say(String message){
        JOptionPane.showMessageDialog(null, message);
    }

}