package model;

public class GameMode {
    private  int fieldSize;
    private  int winLenght;

    public GameMode() {
        this(3, 3);
    }
    public GameMode(int fieldSize, int winLength) {
        this.fieldSize = fieldSize;
        this.winLenght = winLength;
    }
    /**
     * Получить размер поля.
     *
     * @return размер поля
     */
    public int getFieldSize() {
        return fieldSize;
    }

    public int getWinLenght() {
        return winLenght;
    }
}
