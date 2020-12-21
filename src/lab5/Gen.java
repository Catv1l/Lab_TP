package lab5;

public class Gen {
    public int a;
    public int lives;
    String name;

    public Gen(String name)
    {
        this.name = name;
        this.lives = 100;
    }
    public static void Lives(Gen p)
    {
        p.lives -= 10;
    }
}
