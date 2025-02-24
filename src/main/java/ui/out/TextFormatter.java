package ui.out;

import Model.Entities.Car.Car;
import java.util.List;
import java.util.Map;

/**
 * Класс, позволяющий аккуратно выводит любой вид информации, имеется множество перегруженных методов для удобства
 */

public abstract class TextFormatter {

    /**
     * Класс подстраивается под ширину линии в классе Printer, чтобы вывод был равномерный и ровный
     * @see Printer
     */

    private static final int WIDTH = Printer.getLine().length();

    static String formatText(String ... textArray) {

        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();

        for (String word : textArray) {
            if (line.length() + word.length() + 1 <= WIDTH) {
                line.append(word).append(' ');
            } else {
                result.append(line.toString().trim()).append('\n');
                line = new StringBuilder(word).append(' ');
            }
        }

        if (!line.isEmpty()) {
            result.append(line.toString().trim());
        }

        return result.toString();
    }

    static String formatText(List<?> list) {
        if(list.isEmpty())
            return centerText("Список пуст");
        StringBuilder stringBuilder = new StringBuilder();
        for(Object object : list)
            stringBuilder.append(object.toString()).append("\n");
        return stringBuilder.toString();
    }

    static String formatList(List<List<String>> list) {
        if(list.isEmpty())
            return centerText("Список пуст");
        StringBuilder stringBuilder = new StringBuilder();
        for(List<String> l : list)
            stringBuilder.append(formatText(l)).append("\n");
        return stringBuilder.toString();
    }

    static String formatText(Map<?,?> map) {
        if(map.isEmpty())
            return centerText("Список пуст");
        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<?,?> entry : map.entrySet())
            stringBuilder.append(entry.getValue().toString()).append("\n");
        return stringBuilder.toString();
    }

    public static String centerText(String text) {
        int textLength = text.length();
        int padding = (WIDTH - textLength) / 2;
        StringBuilder centeredText = new StringBuilder();
        centeredText.append(" ".repeat(Math.max(0, padding)));
        centeredText.append(text);
        centeredText.append(" ".repeat(Math.max(0, padding)));
        return centeredText.toString();
    }
}
