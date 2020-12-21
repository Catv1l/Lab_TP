package lab5;

public class Player extends Gen{
    String name;

    public Player(String name)
    {
        super(name);
        this.name = name;
    }

    public static void checkRandom(int a1, Enemy e, Player p)
    {
        if (e.a == a1)
        {
            p.Lives(p);
            System.out.println("Враг попал в вас! У " + p.name + " осталось " + p.lives + " жизней");
        }
        else
            System.out.println("Враг не угадал число");
    }
}
