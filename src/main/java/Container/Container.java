package Container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Sergey Bochkov
 * {@link <a href="https://ru.wikipedia.org/wiki/">...</a>Обратная_польская_запись}
 * @version Lab 2
 */
public class Container {
    /**
     * @param c символ из строки
     * @return если пробел идем дальше
     */
    public boolean isDelim(char c) {
        return c == ' ';
    }

    /**
     * @param c символ из строки
     * @return если ариф. действие, то идем дальше
     */
    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    /**
     * @return приоритет операций
     */
    public int priority(char op) {
        return switch (op) {
            case '+', '-' -> 1;
            case '*', '/', '%' -> 2;
            default -> -1;
        };
    }

    /**
     * @param st лист с числами
     * @param op символ из строки
     *           Прикрепил ссылку на википедию в самом начале
     */
    public void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        switch (op) {
            case '+' -> st.add(l + r);
            case '-' -> st.add(l - r);
            case '*' -> st.add(l * r);
            case '/' -> st.add(l / r);
            case '%' -> st.add(l % r);
        }
    }

    /**
     * @param str исходное выражение
     * @return если кол-во скобок() одинаковое и нет никаких символов кроме чисел ариф операций и скобок, то выражение введено коректно
     */
    public Boolean errors(String str) {
        int left = 0;
        int right = 0;
        String str_2 = str;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                left++;
            if (str.charAt(i) == ')')
                right++;
        }
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '+', '-', '*', '/', '(', ')' ->
                        str_2 = str_2.replace(str_2.charAt(i), ' ');
            }
        }
        str_2 = str_2.replace(" ", "");
        return right == left && str_2.length() == 0;
    }

    /**
     * @param s строка/выражение
     * @return результат
     */
    public int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
        if (errors(s)) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isDelim(c))
                    continue;
                if (c == '(')
                    op.add('(');
                else if (c == ')') {
                    while (op.getLast() != '(')
                        processOperator(st, op.removeLast());
                    op.removeLast();
                } else if (isOperator(c)) {
                    while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                        processOperator(st, op.removeLast());
                    op.add(c);
                } else {
                    StringBuilder operand = new StringBuilder();
                    while (i < s.length() && Character.isDigit(s.charAt(i)))
                        operand.append(s.charAt(i++));
                    --i;
                    st.add(Integer.parseInt(operand.toString()));
                }
            }
            while (!op.isEmpty())
                processOperator(st, op.removeLast());
            return st.get(0);
        }
        else System.out.println("Некорректное выражение");
        return 0;
    }

}
