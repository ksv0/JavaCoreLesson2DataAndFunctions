package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenForwardingEvents extends JFrame {
    private Controller controller;
    private JRadioButton firstGameModeRadioButton;
    private JRadioButton secondGameModeRadioButton;
    private JRadioButton thirdGameModeRadioButton;
    private JRadioButton fourthGameModeRadioButton;
    private JRadioButton extremeGameModeRadioButton;

    private JButton startButton;
    private JButton exitButton;



    private JFormattedTextField textField;

    public TitleScreenForwardingEvents(Controller controller) {
        super("Крестики-Нолики");
        this.controller = controller;
        controller.changeView(this);

        setSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(2,6));

        startButton = new JButton("START");
        exitButton = new JButton("EXIT");
        firstGameModeRadioButton = new JRadioButton("3x3 ||3");
        secondGameModeRadioButton = new JRadioButton("5x5 ||4");
        thirdGameModeRadioButton = new JRadioButton("10x10 ||5");
        fourthGameModeRadioButton = new JRadioButton("50x50 ||15");
        extremeGameModeRadioButton = new JRadioButton("1000x1000 ||50{не работает}");
        firstGameModeRadioButton.setSelected(true);


        getContentPane().add(firstGameModeRadioButton);
        getContentPane().add(secondGameModeRadioButton);
        getContentPane().add(thirdGameModeRadioButton);
        getContentPane().add(fourthGameModeRadioButton);
        getContentPane().add(extremeGameModeRadioButton);
        getContentPane().add(startButton);
        getContentPane().add(exitButton);

        Forwarder forwarder = new Forwarder();
        startButton.addActionListener(forwarder);
        exitButton.addActionListener(forwarder);
        firstGameModeRadioButton.addActionListener(forwarder);
        secondGameModeRadioButton.addActionListener(forwarder);
        thirdGameModeRadioButton.addActionListener(forwarder);
        fourthGameModeRadioButton.addActionListener(forwarder);
        extremeGameModeRadioButton.addActionListener(forwarder);

        pack();
        setVisible(true);
    }
    public class Forwarder implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(firstGameModeRadioButton)){
                controller.setGameMode(3,3);
                secondGameModeRadioButton.setSelected(false);
                thirdGameModeRadioButton.setSelected(false);
                fourthGameModeRadioButton.setSelected(false);
                extremeGameModeRadioButton.setSelected(false);
            }
            if (e.getSource().equals(secondGameModeRadioButton)){
                controller.setGameMode(5,4);
                firstGameModeRadioButton.setSelected(false);
                thirdGameModeRadioButton.setSelected(false);
                fourthGameModeRadioButton.setSelected(false);
                extremeGameModeRadioButton.setSelected(false);
            }
            if (e.getSource().equals(thirdGameModeRadioButton)){
                controller.setGameMode(10,5);
                firstGameModeRadioButton.setSelected(false);
                secondGameModeRadioButton.setSelected(false);
                fourthGameModeRadioButton.setSelected(false);
                extremeGameModeRadioButton.setSelected(false);
            }
            if (e.getSource().equals(fourthGameModeRadioButton)){
                controller.setGameMode(50,15);
                firstGameModeRadioButton.setSelected(false);
                secondGameModeRadioButton.setSelected(false);
                thirdGameModeRadioButton.setSelected(false);
                extremeGameModeRadioButton.setSelected(false);
            }
            if (e.getSource().equals(extremeGameModeRadioButton)){
                controller.setGameMode(1000,50);
                firstGameModeRadioButton.setSelected(false);
                secondGameModeRadioButton.setSelected(false);
                thirdGameModeRadioButton.setSelected(false);
                fourthGameModeRadioButton.setSelected(false);
            }
            if (e.getSource().equals(exitButton)) {
                System.exit(0);
            }
            if (e.getSource().equals(startButton)){
                setVisible(false);
                SwingUtilities.invokeLater(() -> new GameScreenForvardingEvents(controller));
            }
        }

    }
}
