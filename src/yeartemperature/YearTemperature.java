package YearTemperature;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class YearTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] months = new int[12][31];
        String[] monthsNames = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        //31 - 0янв 2мар 4май 6июл 7авг 9окт 11дек
        //30 - 3апр 5июн 8сен 10ноя
        //28 - 1фев

        for (int i = 0; i < months.length; i++) {
            switch (i) {
                case 0:
                case 2:
                case 9:
                case 4:
                case 6:
                case 7:
                case 11:
                    for (int j = 0; j < months[i].length; j++) {
                        months[i][j] = 0;
                    }
                    break;
                case 3:
                case 5:
                case 8:
                case 10:
                    for (int j = 0; j < months[i].length - 1; j++) {
                        months[i][j] = 0;
                    }
                    break;
                case 1:
                    for (int j = 0; j < months[i].length - 3; j++) {
                        months[i][j] = 0;
                    }
            }
        }
        
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
        
        int midtemp = 0;
        for (int i = 0; i < months.length; i++) {
            for (int j = 0; j < months[i].length; j++) {
                midtemp += months[i][j];
            }
            System.out.println(midtemp);
        }
        
        while (true) {
            System.out.print("Введите день --> ");
            int day = scanner.nextInt();
            System.out.print("Введите месяц --> ");
            int month = scanner.nextInt(); 

            System.out.println(day + monthsNames[month-1] + " температура была " + months[month-1][day-1] + "°C");
        }
    }
}
