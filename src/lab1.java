public class lab1 {
    public static int k;
    public static void main(String[] args)
    {
        //Создание потока
        Thread myThready1 = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                k = (int) (1+Math.random()*10);
                System.out.println("Сгенерированное число: "+(int)k);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("Поток был прерван");
                }
            }
        });

        Thread myThready2 = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                k=(int)Math.pow(k,2);
                System.out.println("Квадрат числа: "+(int)k);
            }
        });

        Thread myThready3 = new Thread(new Runnable() {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                k=(int)Math.pow(k,3);
                System.out.println("Куб числа: "+(int)k);
            }
        });
        for(int i=0;i<10;i++)
        {
        myThready1.run();	//Запуск потока
        if (k%2==0)
        {
            myThready2.run();
        }
        else
        {
            myThready3.run();
        }
            System.out.println("\n");
        }
    }
}
