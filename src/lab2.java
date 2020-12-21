import java.util.Scanner;


public class lab2 {

    public static void tabl(){
        Scanner in =new Scanner (System.in);
        String[][] inf = {
                {"United States","45,785,090","19.8","14.3"},
                {"Russia","11,048,064","4.8","7.7"},
                {"Germany","9,845,244","4.3","11.9"},
                {"Saudi Arabia","9,060,433","3.9","31.4"},
                {"United Arab Emirates","7,826,981","3.4","83.7"},
                {"United Kingdom","7,824,131","3.4","12.4"},
                {"France","7,439,086","3.2","11.6"},
                {"Canada","7,284,069","3.1","20.7"},
                {"Australia","6,468,640","2.8","27.7"},
                {"Spain","6,466,605","2.8","13.8"}

        };
        System.out.printf("%-30s%-30s%-30s%-30s","Country","Immigrants","% world total","% population");
        System.out.println();
        for(int i =0;i<10;i++){
            for (int j=0;j<4;j++){
                if (j==1){
                    inf[i][j]=inf[i][j].replace(",","");
                }
                System.out.printf("%-30s",inf[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        int x=0;
        double x1 = 0;

        for(int i=0;i<10;i++)
        {
            x+=Integer.parseInt(inf[i][1]);
        }
        System.out.println("Общее количество иммигрантов в этих странах: "+x);


        for(int i=0;i<10;i++)
        {
            x1+=Double.parseDouble(inf[i][2]);
        }
        System.out.println("Общий процент иммигрантов в мире приходящийся на эти страны: "+x1+" %");

        double max=Double.parseDouble(inf[0][2]);
        double min=Double.parseDouble(inf[0][2]);
        for(int i=0;i<10;i++){
            x1=Double.parseDouble(inf[i][2]);
            if (x1>max){
                max=x1;
            }
            if (x1<min){
                min=x1;
            }
        }
        System.out.println("Страны с самым высоким и самым низким процентом иммигрантов: ");
        System.out.print("max: ");
        for (int i=0;i<10;i++){
            x1=Double.parseDouble(inf[i][2]);
            if (max==x1){
                System.out.print(inf[i][0]+" - "+inf[i][2]+"%; ");
            }
        }
        System.out.println();
        System.out.print("min: ");
        for (int i=0;i<10;i++){
            x1=Double.parseDouble(inf[i][2]);
            if (min==x1){
                System.out.print(inf[i][0]+" - "+inf[i][2]+"%; ");
            }
        }
        System.out.println();


        double summastran=0;
        for(int i=0;i<10;i++){
            x=Integer.parseInt(inf[i][1]);//
            x1=Double.parseDouble(inf[i][3]);//
            summastran+= x/x1*100;//

        }
        System.out.print("Общая численность населения всех десяти стран: ");
        System.out.printf("%.0f ",summastran);
    }


        public static void main(String[] args) {
            tabl();
        }

}


