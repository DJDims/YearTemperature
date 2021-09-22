package YearTemperature;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class YearTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] months = new int[12][];
        String[] monthsNames = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        //31 - 0янв 2мар 4май 6июл 7авг 9окт 11дек
        //30 - 3апр 5июн 8сен 10ноя
        //28 - 1фев

        months[0] = new int[31];
        months[1] = new int[28];
        months[2] = new int[31];
        months[3] = new int[30];
        months[4] = new int[31];
        months[5] = new int[30];
        months[6] = new int[31];
        months[7] = new int[31];
        months[8] = new int[30];
        months[9] = new int[31];
        months[10] = new int[30];
        months[11] = new int[31];
        
        for (int i = 0; i < months.length; i++) {
            switch (i) {
                case 0:
                case 1:
                case 11:
                    for (int j = 0; j < months[i].length; j++) {
                        months[i][j] = ThreadLocalRandom.current().nextInt(-18,3);
                    }
                    break;
                case 2:
                case 3:
                case 4:
                    for (int j = 0; j < months[i].length; j++) {
                        months[i][j] = ThreadLocalRandom.current().nextInt(0,10);
                    }
                    break;
                case 5:
                case 6:
                case 7:
                    for (int j = 0; j < months[i].length; j++) {
                        months[i][j] = ThreadLocalRandom.current().nextInt(15,25);
                    }
                    break;
                case 8:
                case 9:
                case 10:
                    for (int j = 0; j < months[i].length; j++) {
                        months[i][j] = ThreadLocalRandom.current().nextInt(7,14);
                    }
                    break;
            }
        }
        
        for (int i = 0; i < months.length; i++) {
            int midtemp = 0;
            for (int j = 0; j < months[i].length; j++) {
                midtemp += months[i][j];
            }
            System.out.println("Средняя температура в " + monthsNames[i] + " " + midtemp/months[i].length + "°C");
        }
        
        while (true) {
            System.out.print("Введите день --> ");
            int day = scanner.nextInt();
            System.out.print("Введите месяц --> ");
            int month = scanner.nextInt(); 

            System.out.println(day + " " + monthsNames[month-1] + " температура была " + months[month-1][day-1] + "°C");
        }
    }
}
