package ksv;

import controller.Controller;
import gui.GUIController;
import gui.TitleScreenForwardingEvents;
import model.Model;

import javax.swing.*;

public class App {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() ->
                new TitleScreenForwardingEvents(
                new Controller(
                        new Model(),
                        new GUIController()
                )));
    }
}
