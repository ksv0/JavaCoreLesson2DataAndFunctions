package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;


public class WinScreenForwardingEvents extends JFrame {
    JLabel winMessage;
    JButton button;

    public WinScreenForwardingEvents(Controller.Player player) {
        super("Крестики-Нолики");
        setLayout(new GridLayout(2, 1));
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        winMessage = new JLabel(player.getName() + " WIN!");
        winMessage.setHorizontalAlignment(SwingConstants.CENTER);


        button = new JButton("Exit");

        getContentPane().add(winMessage);
        getContentPane().add(button);

        button.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}
