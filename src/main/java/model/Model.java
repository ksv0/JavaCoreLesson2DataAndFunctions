package model;

import java.util.List;

public class Model {
    private GameMode gameMode;
    private GameField gameField;
    private int lastHit;


    public Model() {
        gameMode = new GameMode();
        gameField = new GameField(gameMode.getFieldSize());

    }

    public Model(int fieldSize, int winLength) {
        gameMode = new GameMode(fieldSize, winLength);
        gameField = new GameField(fieldSize);
    }

    /**
     * Получить размер поля.
     *
     * @return размер поля
     */
    public int getFieldSize() {
        return gameMode.getFieldSize();
    }

    /**
     * Проверьте, пуста ли ячейка по данному индексу.
     *
     * @param i индекс ячейки
     * @return true, если ячейка пуста, в противном случае — false
     */
    public boolean isEmptyCell(int i) {
        return gameField.isEmptyCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
    }

    /**
     * Изменение ячейки по указанному индексу в зависимости от хода игрока.
     *
     * @param i      индекс ячейки, которую нужно изменить
     * @param player игрок, делающий ход
     * @return true, если ячейка была успешно изменена, в противном случае — false
     */
    public boolean changeCell(int i, boolean player) {
        return gameField.setCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize(), player);
    }

    /**
     * Получает список пустых ячеек игрового поля.
     *
     * @return список пустых ячеек
     */
    public List<Integer> getEmptyCells() {
        return gameField.getEmptyCells();
    }


    /**
     * Метод расчета количества непрерывно связанных в данный момент ячеек игрока в диагональном направлении.
     *
     * @param i    индекс ячейки
     * @param side — направление диагонали
     * @return количество постоянно подключенных в данный момент ячеек игроков в диагональном направлении
     */
    public int getDiagonalPlayers(int i, boolean side) {
        Cell cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
        int count = 1;//текущая клетка учет
        if (side) {
            // проверка на существование клетки, проверка на пустоту и проверка на игрока с текущей клетки
            while (cell.getUpRightSide() != null && !cell.getUpRightSide().isEmpty() && cell.getUpRightSide().isPlayer() == cell.isPlayer()) {
                cell = cell.getUpRightSide();
                count++;

            }
            cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
            while (cell.getDownLeftSide() != null && !cell.getDownLeftSide().isEmpty() && cell.getDownLeftSide().isPlayer() == cell.isPlayer()) {
                cell = cell.getDownLeftSide();
                count++;

            }
        } else {
            while (cell.getUpLeftSide() != null && !cell.getUpLeftSide().isEmpty() && cell.getUpLeftSide().isPlayer() == cell.isPlayer()) {
                cell = cell.getUpLeftSide();
                count++;

            }
            cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
            while (cell.getDownRightSide() != null && !cell.getDownRightSide().isEmpty() && cell.getDownRightSide().isPlayer() == cell.isPlayer()) {
                cell = cell.getDownRightSide();
                count++;

            }
        }

        return count;
    }

    /**
     * Метод расчета количества непрерывно связанных в данный момент ячеек игрока в линии по заданному индексу.
     *
     * @param i Индекс ячейки в игровом поле.
     * @return Количество последовательных игроков в строке по заданному индексу.
     */
    public int getLinePlayers(int i) {
        Cell cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
        int count = 1;
        while (cell.getRightSide() != null && !cell.getRightSide().isEmpty() && cell.getRightSide().isPlayer() == cell.isPlayer()) {
            cell = cell.getRightSide();
            count++;

        }
        cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
        while (cell.getLeftSide() != null && !cell.getLeftSide().isEmpty() && cell.getLeftSide().isPlayer() == cell.isPlayer()) {
            cell = cell.getLeftSide();
            count++;

        }
        return count;

    }

    /**
     * Метод расчета количества непрерывно связанных в данный момент ячеек игрока в столбце по заданному индексу.
     *
     * @param i индекс ячейки
     * @return количество ячеек игрока в столбце
     */
    public int getColumnPlayers(int i) {
        Cell cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
        int count = 1;
        while (cell.getUpSide() != null && !cell.getUpSide().isEmpty() && cell.getUpSide().isPlayer() == cell.isPlayer()) {
            cell = cell.getUpSide();
            count++;

        }
        cell = gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize());
        while (cell.getDownSide() != null && !cell.getDownSide().isEmpty() && cell.getDownSide().isPlayer() == cell.isPlayer()) {
            cell = cell.getDownSide();
            count++;

        }

        return count;
    }

    /**
     * Получает длину выигрыша из игрового режима.
     *
     * @return длину выигрыша
     */
    public int getWinLenght() {
        return gameMode.getWinLenght();
    }

    /**
     * Проверяет, принадлежит ли ячейка с индексом i игроку.
     *
     * @param i индекс ячейки
     * @return true, если ячейка принадлежит игроку, в противном случае — false
     */
    public boolean isPlayerCell(int i) {
        return gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize()).isPlayer();
    }

    /**
     * Извлекает окружающие ячейки для данного индекса.
     *
     * @param i индекс ячейки
     * @return список ячеек окружения
     */
    public List<Integer> getEnvironmentCells(int i) {
        return gameField.getCell(i / gameMode.getFieldSize(), i % gameMode.getFieldSize()).getEnvironment();

    }

    public int getLastHit() {
        return lastHit;
    }
    public void setLastHit(int lastHit) {
        this.lastHit = lastHit;
    }
}
