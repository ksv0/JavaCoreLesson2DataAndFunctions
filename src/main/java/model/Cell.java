package model;

import java.io.BufferedWriter;
import java.util.*;
import java.util.function.Consumer;

//todo убрать ненужные методы
public class Cell  {
    private boolean player;
    private boolean empty;

    private int value;

    private Cell upSide;

    private Cell downSide;
    private Cell leftSide;
    private Cell rightSide;
    private Cell upLeftSide;
    private Cell upRightSide;
    private Cell downLeftSide;
    private Cell downRightSide;
    public Cell(int value) {
        empty = true;
        player = false;
        this.value = value;
    }

    public int getValue() {
            return value;
    }

    public void setPlayer(boolean player) {
        this.empty = false;
        this.player = player;
    }


    public boolean isEmpty() {
        return empty;
    }

    public boolean isPlayer() {
        if (isEmpty()) {
            throw new RuntimeException("Cell is empty");
        }
        return player;
    }
    public Cell getUpSide() {
        return upSide;
    }



    public void setUpSide(Cell upSide) {
        this.upSide = upSide;
        upSide.setDownSide(this);
        if(upSide.getLeftSide()!=null){
            this.upLeftSide = upSide.getLeftSide();
            upSide.getLeftSide().setDownRightSide(this);
        }
        if(upSide.getRightSide()!=null){
            this.upRightSide = upSide.getRightSide();
            upSide.getRightSide().setDownLeftSide(this);
        }
    }

    public Cell getDownSide() {
        return downSide;
    }

    public void setDownSide(Cell downSide) {
        this.downSide = downSide;
    }

    public Cell getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(Cell leftSide) {
        this.leftSide = leftSide;
        leftSide.setRightSide(this);
    }

    public Cell getRightSide() {
        return rightSide;
    }

    public void setRightSide(Cell rightSide) {
        this.rightSide = rightSide;
    }

    public Cell getUpLeftSide() {
        return upLeftSide;
    }

    public void setUpLeftSide(Cell upLeftSide) {
        this.upLeftSide = upLeftSide;
    }

    public Cell getUpRightSide() {
        return upRightSide;
    }

    public void setUpRightSide(Cell upRightSide) {
        this.upRightSide = upRightSide;
    }

    public Cell getDownLeftSide() {
        return downLeftSide;
    }

    public void setDownLeftSide(Cell downLeftSide) {
        this.downLeftSide = downLeftSide;
    }

    public Cell getDownRightSide() {
        return downRightSide;
    }

    public void setDownRightSide(Cell downRightSide) {
        this.downRightSide = downRightSide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return player == cell.player
                && empty == cell.empty
                && Objects.equals(upSide, cell.upSide)
                && Objects.equals(downSide, cell.downSide)
                && Objects.equals(leftSide, cell.leftSide)
                && Objects.equals(rightSide, cell.rightSide);
    }

    public List<Integer> getEnvironment() {
        List<Integer> list = new ArrayList<>();
        if (upSide != null) {
            list.add(upSide.getValue());
        }
        if (downSide != null) {
            list.add(downSide.getValue());
        }
        if (leftSide != null) {
            list.add(leftSide.getValue());
        }
        if (rightSide != null) {
            list.add(rightSide.getValue());
        }
        if (upLeftSide != null) {
            list.add(upLeftSide.getValue());
        }
        if (upRightSide != null) {
            list.add(upRightSide.getValue());
        }
        if (downLeftSide != null) {
            list.add(downLeftSide.getValue());
        }
        if (downRightSide != null) {
            list.add(downRightSide.getValue());
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Cell{");
        sb.append("value=");
        sb.append(value);
        sb.append(", upSide=");
        if (upSide == null) {
            sb.append("null");
        }else {
            sb.append(upSide.getValue());
        }
        sb.append(", downSide=");
        if (downSide == null) {
            sb.append("null");
        }else {
            sb.append(downSide.getValue());
        }
        sb.append(", leftSide=");
        if (leftSide == null) {
            sb.append("null");
        }else {
            sb.append(leftSide.getValue());
        }
        sb.append(", rightSide=");
        if (rightSide == null) {
            sb.append("null");
        }else {
            sb.append(rightSide.getValue());
        }
        sb.append(", upLeftSide=");
        if (upLeftSide == null) {
            sb.append("null");
        }else {
            sb.append(upLeftSide.getValue());
        }
        sb.append(", upRightSide=");
        if (upRightSide == null) {
            sb.append("null");
        }else {
            sb.append(upRightSide.getValue());
        }
        sb.append(", downLeftSide=");
        if (downLeftSide == null) {
            sb.append("null");
        }else {
            sb.append(downLeftSide.getValue());
        }
        sb.append(", downRightSide=");
        if (downRightSide == null) {
            sb.append("null");
        }else {
            sb.append(downRightSide.getValue());


        }
        return sb.toString();
    }



}
