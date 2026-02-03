package org.dcj;

public class test_04 {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        Computer computer = new Computer();

        computer.use(keyBoard);
        computer.use(mouse);
    }
}
