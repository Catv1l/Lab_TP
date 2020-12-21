package lab5;

public class Enemy extends Gen {

    String name;

    public Enemy(String name)
    {
        super(name);
        this.name = name;
    }

    public static void checkRandom(int a1, Player p, Enemy e)
    {
        if (e.a == a1)
        {
            e.Lives(e);
            System.out.println("Вы угадали, теперь у врага " + e.name + " осталось " + e.lives + " жизней");
        }
        else if (e.a > a1)
            System.out.println("Вы не угадали! Число, что вы пытались угадать было больше!");
        else if (e.a < a1)
            System.out.println("Вы не угадали! Число, что вы пытались угадать было меньше!");
    }
}
