package lab5;

import java.io.IOException;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws IOException {
        Scanner in2 = new Scanner(System.in);

        Player player = new Player("Пользователь");
        Enemy enemy = new Enemy("Компьютер");

        int a1;
        while (enemy.lives > 0 && player.lives > 0) {

            enemy.a = (int) (Math.random() * 10);
            player.a = (int) (Math.random() * 10);

            System.out.println("Введите число от 1 до 10: ");
            a1 = in2.nextInt();

            enemy.checkRandom(a1, player, enemy);
            player.checkRandom(player.a, enemy, player);

        }
        System.out.println("Игра окончена! ");
    }
}
