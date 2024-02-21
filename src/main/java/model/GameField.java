package model;

import java.util.*;

public class GameField {
    Cell[][] field;

    public GameField(int fieldSize) {
        this.field = new Cell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {

                field[i][j] = new Cell(i * fieldSize + j);
                if (i > 0) {
                    field[i][j].setUpSide(field[i - 1][j]);
                }
                if (j > 0) {
                    field[i][j].setLeftSide(field[i][j - 1]);
                }
            }
        }


    }

    /**
     * Извлекает ячейку по указанным координатам (i, j).
     *
     * @param i индекс строки
     * @param j индекс столбца
     * @return ячейку по указанным координатам
     */
    public Cell getCell(int i, int j) {
        return field[i][j];
    }

    /**
     * Проверяет, пуста ли ячейка в позиции (i, j).
     *
     * @param i индекс строки
     * @param j индекс столбца
     * @return true, если ячейка пуста, в противном случае — false
     */
    public boolean isEmptyCell(int i, int j) {
        return field[i][j].isEmpty();
    }

    /**
     * Устанавливает указанную ячейку с данным игроком, если она пуста.
     *
     * @param i      индекс строки ячейки
     * @param j      индекс столбца ячейки
     * @param player значение игрока, которое нужно установить
     * @return true, если ячейка была установлена, false, если ячейка не пуста
     */
    public boolean setCell(int i, int j, boolean player) {
        if (isEmptyCell(i, j)) {
            field[i][j].setPlayer(player);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список индексов, представляющих пустые ячейки поля.
     *
     * @return список индексов пустых ячеек
     */
    public List<Integer> getEmptyCells() {
        List<Integer> emptyCells = new ArrayList<>();
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isEmptyCell(i, j)) {
                    emptyCells.add(i * field.length + j);
                }
            }
        }
        return emptyCells;
    }
}
