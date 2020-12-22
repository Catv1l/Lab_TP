package lab3;
import java.util.ArrayList;


public class Streams {
    public static ArrayList<String> RESULT = new ArrayList<>();//итоговый результат
    public static void Stream(String str,int n,ArrayList<String> u1,int depth){
        Thread[] Tcreate = new Thread[n];//создаём массив потоков
        RESULT.add(str+ " 0");//добавляем нулевой url
        for(int i=0;i<Tcreate.length;i++){
            int k=i;
            Tcreate[i]=new Thread(new Runnable() {
                public void run() {
                    ArrayList<String> Streamurl = new ArrayList<>();
                    ArrayList<String> otvet = new ArrayList<>();
                    String[] stroka = u1.get(k).split("1split1");//сплитим строку
                    for(int j=1;j<stroka.length;j++){
                        Streamurl.add(stroka[j]);//добавляем url с глубиной 1 в лист и в итоговый результат
                        RESULT.add(stroka[j]);
                    }
                    otvet = URLGlubina.URLSTREAM(Streamurl,depth);//вызываем функцию
                    for(int i = 0;i<otvet.size();i++){//все url добавляем в итоговый результат
                        RESULT.add(otvet.get(i));
                    }
                    System.out.println(k+1 + " поток выполнен");
                }
            });
            Tcreate[i].setName("Stream"+i);
            Tcreate[i].start();//запуск потока
        }
        int conec=0;//счётчик для проверки завершения потоков
        boolean r=true;
        while(r){
            for(int i=0;i<n;i++) {//перебираем все потоки, если они завершены, прибавляет счётчик
                if(!Tcreate[i].isAlive())
                    conec++;
            }
            if(conec==n){//если счётчик равен заданному пользователем количеству потоков
                System.out.println("Вывод: ");
                for(int i=0;i<RESULT.size();i++){//выводим итоговый результат
                    System.out.println(RESULT.get(i));
                }
                r=false;
            }
            conec=0;//обнуляем счётчик
        }
    }

}