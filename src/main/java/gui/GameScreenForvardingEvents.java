package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameScreenForvardingEvents extends JFrame {
    Controller controller;


    public GameScreenForvardingEvents(Controller controller) {
        super("Крестики-Нолики");
        this.controller = controller;
        controller.changeView(this);

        setMinimumSize(new Dimension(900, 900));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(controller.getFieldSize(), controller.getFieldSize()));

        Forwarder forwarder = new Forwarder();

        for (int i = 0; i < controller.getFieldSize() * controller.getFieldSize(); i++) {
            CellButton button = new CellButton(i);
            button.addActionListener(forwarder);

            getContentPane().add(button);
        }
        pack();
        setVisible(true);


    }

    public class Forwarder implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

                controller.buttonPressed(Integer.parseInt(e.toString().substring(e.toString().indexOf("value=") + 6)));


        }
    }
}
