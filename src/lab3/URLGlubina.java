package lab3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLGlubina {
    public static String result = "";
    public static ArrayList<String> URLresult = new ArrayList<>();
    public static ArrayList<String> URLSTREAM(ArrayList<String> Streamurl, int depth){// функци для вывода url
        for(int i=1;i<depth;i++){//пока счётчик не равен глубине
            for(int j=0;j<Streamurl.size();j++){//перебираем array list
                String[] y = Streamurl.get(j).split(" ");// сплитим строку на глубину и url
                int depthy = Integer.parseInt(y[1]);
                if(depthy==i)//если глубина равна счётчику глубины
                    URLglubina(y[0],depthy,Streamurl);// вызываем функцию
            }
        }
        return Streamurl;
    }
    public static ArrayList<String> URLpotok1(String url, int depth){
        ArrayList<String> Null = new ArrayList<>();
        URLglubina(url,depth,Null);
        return Null;
    }
    public static void URLglubina(String url, int depth,ArrayList<String> Streamurl) {
        ArrayList<Integer> D = new ArrayList<>();//лист для подсчёта глубины
        ArrayList<String> URLglubinahash = new ArrayList<>();//лист для подсчёта url
        try {
            URL http = new URL(url);//подключение к ссылке
            BufferedReader in = new BufferedReader(//считывание текста ссылки
                    new InputStreamReader(
                            http.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                result += inputLine;
            in.close();
        } catch (IOException e) {//выводим в случае ошибки
            System.out.println("java Crawler " + url + " " + depth);
        }
        String str1 = "";
        String aPattern = "<(a)\\b[^>]*>";//создаём паттерн "а...."
        Pattern REGEX = Pattern.compile(aPattern);
        Matcher matcher = REGEX.matcher(result);
        while (matcher.find()) {
            str1 += " " + matcher.group();//добавляем итог в строку
        }
        String httpPattern = "href=\\\"(.*?)\\\"";//создаём паттерн"а href=..."
        Pattern REGEX1 = Pattern.compile(httpPattern);
        Matcher matcher1 = REGEX1.matcher(str1);
        result = "";
        while (matcher1.find()) {
            if (matcher1.group().length() <= 6) {//если выражение меньше 6, то следующее выражение
                continue;
            } else {//иначе
                if (matcher1.group().substring(6, 7).equals("/") && matcher1.group().substring(7, 8).equals("/")) {
                    //проверяем, если начинается с "//", то добавляем http и добавляем в листы
                    URLglubinahash.add("http:" + matcher1.group().substring(6, matcher1.group().length() - 1));
                    D.add(depth + 1);
                } else if (matcher1.group().substring(6, 7).equals("h"))//иначе добавляем в листы
                    URLglubinahash.add(matcher1.group().substring(6, matcher1.group().length() - 1));
                D.add(depth + 1);
            }
        }

        for(int i=0;i<URLglubinahash.size();i++){
            Streamurl.add(URLglubinahash.get(i)+" " + D.get(i));//элементы листов с одинаковым индексом добавляются в итоговый лист
        }
        URLglubinahash.clear();
        D.clear();
    }


}