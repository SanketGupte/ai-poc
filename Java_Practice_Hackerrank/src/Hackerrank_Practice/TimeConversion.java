package Hackerrank_Practice;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeConversion {
    public static void main(String[] args) {
        String s = "07:05PM";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("hh:mma", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(s, inputFormatter);
        String format = time.format(outputFormatter);
        System.out.println(format);
    }
}
