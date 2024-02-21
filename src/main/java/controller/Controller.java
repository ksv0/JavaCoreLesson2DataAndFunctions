package controller;

import gui.GUIController;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Controller {
    Model model;
    GUIController view;
    Random random;

    public Controller(Model model, GUIController view) {
        this.model = model;
        this.view = view;
        random = new Random();
    }

    /**
     * Получить размер поля.
     *
     * @return размер поля
     */
    public int getFieldSize() {
        return model.getFieldSize();
    }

    /**
     * Установите режим игры с указанным размером поля и длиной выигрыша.
     *
     * @param fieldSize размер игрового поля
     * @param winLenght длина, необходимая для победы в игре.
     */
    public void setGameMode(int fieldSize, int winLenght) {
        model = new Model(fieldSize, winLenght);
    }

    /**
     * Обрабатывает событие нажатия кнопки и соответствующим образом обновляет модель и представление.
     *
     * @param playerMove ход, сделанный игроком
     */
    public void buttonPressed(int playerMove) {
        if (isEmptyCell(playerMove)) {
            model.changeCell(playerMove, Player.USER.isUser);
            view.changeCell(playerMove, Player.USER.getColor());
            checkDeadHeat();
            if (checkWin(playerMove)) {
                return;
            }
            checkDeadHeat();
            checkWin(computerMove(playerMove));
        }
    }

    /**
     * Способ сделать ход для компьютерного игрока.
     * Метод сначала извлекает пустые ячейки,
     * ячейки окружения хода игрока и ячейки последнего попадания из игровой модели.
     * Затем он проверяет, какие ячейки доступны компьютеру для нацеливания,
     * на основе окружения хода игрока и ячеек последнего попадания.
     * Наконец, он выбирает случайную ячейку для перемещения,
     * обновляет игровую модель и представление и возвращает ход компьютера
     *
     * @param playerMove ход, сделанный игроком
     * @return ход, сделанный компьютером
     */
    private int computerMove(int playerMove) {
        List<Integer> cellList = model.getEmptyCells();
        List<Integer> targetEnvironmentList = model.getEnvironmentCells(playerMove);
        List<Integer> lastHitList = model.getEnvironmentCells(model.getLastHit());
        List<Integer> aimList = new ArrayList<>();

        for (int i : targetEnvironmentList) {
            if (cellList.contains(i)) {
                aimList.add(i);
            }
        }
        for (int i : lastHitList) {
            if (cellList.contains(i)) {
                aimList.add(i);
            }
        }


        int computerMove;
        if (!aimList.isEmpty() && random.nextBoolean()) {
            computerMove = aimList.get(random.nextInt(aimList.size()));
        } else {
            computerMove = cellList.get(random.nextInt(cellList.size()));
        }
        model.changeCell(computerMove, Player.COMPUTER.isUser());
        view.changeCell(computerMove, Player.COMPUTER.getColor());
        model.setLastHit(computerMove);
        return computerMove;
    }

    /**
     * Проверяет, выиграл ли игрок игру на основе заданной позиции.
     *
     * @param i позиция для проверки выигрыша
     * @return true, если игрок выиграл, в противном случае — false
     */
    private boolean checkWin(int i) {
        if (checkDiagonal(i, true) >= model.getWinLenght()
                || checkDiagonal(i, false) >= model.getWinLenght()
                || checkColumn(i) >= model.getWinLenght()
                || checkLine(i) >= model.getWinLenght()
        ) {
            if (model.isPlayerCell(i)) {
                view.win(Player.USER);

            } else {
                view.win(Player.COMPUTER);
            }
            return true;
        }
        return false;

    }

    /**
     * Метод расчета количества непрерывно связанных в данный момент ячеек игрока в диагональном направлении.
     *
     * @param i    индекс ячейки
     * @param side — направление диагонали
     * @return количество постоянно подключенных в данный момент ячеек игроков в диагональном направлении
     */
    private int checkDiagonal(int i, boolean side) {
        return model.getDiagonalPlayers(i, side);
    }

    /**
     * Проверяет линию по заданному индексу.
     *
     * @param i индекс для проверки
     * @return количество клеток игрока на линии
     */
    private int checkLine(int i) {
        return model.getLinePlayers(i);
    }

    /**
     * Метод проверки столбца по заданному индексу.
     *
     * @param i индекс столбца для проверки
     * @return количество клеток игрока в столбце
     */
    private int checkColumn(int i) {
        return model.getColumnPlayers(i);
    }

    /**
     * Проверка на ничью в игре.
     */
    private void checkDeadHeat() {
        if (model.getEmptyCells().size() == 0) {
            view.win(Player.DEAD_HEAT);
        }
    }

    /**
     * Проверка, пуста ли ячейка с индексом i.
     *
     * @param i индекс ячейки, которую нужно проверить
     * @return true, если ячейка пуста, в противном случае — false
     */
    private boolean isEmptyCell(int i) {
        return model.isEmptyCell(i);
    }

    public void changeView(JFrame frame) {
        view.changeFrame(frame);
    }


    public enum Player {
        USER(true, new Color(166, 0, 255), "YOU"),
        COMPUTER(false, new Color(248, 193, 54), "COMPUTER"),
        DEAD_HEAT(false, new Color(0, 0, 0), "YOU NOT");

        boolean isUser;
        Color color;
        String name;

        Player(boolean isUser, Color color, String name) {
            this.isUser = isUser;
            this.color = color;
            this.name = name;
        }

        /**
         * @return true, если игрок является пользователем, в противном случае — false.
         */
        public boolean isUser() {
            return isUser;
        }

        /**
         * Отдает цвет игрока.
         *
         * @return цвет игрока
         */
        public Color getColor() {
            return color;
        }

        /**
         * Отдает имя игрока.
         *
         * @return имя игрока
         */
        public String getName() {
            return name;
        }
    }
}
