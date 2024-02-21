package gui;

import javax.swing.*;

public class CellButton extends JButton {
    private final int value;

    public CellButton(int value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
