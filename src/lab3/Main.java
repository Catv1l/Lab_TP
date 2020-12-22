package lab3;

import java.io.IOException;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner n = new Scanner(System.in);
        System.out.print("Введите URL: ");
        String str = n.nextLine();
        System.out.print("Введите глубину: ");
        int depth=n.nextInt();
        System.out.print("Введите количество потоков: ");
        int stream = n.nextInt();
        ArrayList<String> Null = URLGlubina.URLpotok1(str,0);//добавляем все url глубиной 1
        ArrayList<String> u1 = new ArrayList<>();// лист для записи url глубиной 1
        for(int j=0;j< stream;j++){
            u1.add("1");
        }
        int s = 0;
        int p =0;
        while(s!=Null.size()-1){// создаём счётчик (пока он не равен количеству url)
            String k = u1.get(p)+"1split1"+ Null.get(s);//допабляем url
            u1.set(p,k);//изменяем лист
            s++;
            p++;
            if(p==stream)//если счётчик равен количеству потоков, то обнуляем его и к
                p=0;
            k="";
        }
        Streams.Stream(str,stream,u1,depth);
    }
}
