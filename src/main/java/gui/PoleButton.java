package gui;

import javax.swing.*;

public class PoleButton extends JButton {
    private int value;

    public PoleButton(int value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
