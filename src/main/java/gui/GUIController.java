package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class GUIController {
    JFrame frame;

    /**
     * Изменение цвета фона ячейки в frame.
     *
     * @param i индекс ячейки
     * @param color цвет, который нужно установить
     */
    public void changeCell(int i, Color color) {
        frame.getContentPane().getComponent(i).setBackground(color);
    }
    /**
     * Измените JFrame, связанный с этим объектом.
     *
     * @param frame новый JFrame, который будет связан с этим объектом
     */
    public void changeFrame(JFrame frame) {
        this.frame = frame;
    }
    /**
     * Метод вызывающий экран победы.
     *
     * @param player объект игрока
     * @return void
     */
    public void win(Controller.Player player) {
        frame.setVisible(false);
        SwingUtilities.invokeLater(() -> new WinScreenForwardingEvents(player));
    }
}
