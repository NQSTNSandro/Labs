package Container;
import java.util.LinkedList;

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
    static boolean isDelim(char c) {
        return c == ' ';
    }

    /**
     * @param c символ из строки
     * @return если ариф. действие, то идем дальше
     */
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    /**
     * @return приоритет операций
     */
    static int priority(char op) {
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
    static void processOperator(LinkedList<Integer> st, char op) {
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
     * @param s строка/выражение
     * @return результат
     */
    public static int eval(String s) {
        LinkedList<Integer> st = new LinkedList<Integer>();
        LinkedList<Character> op = new LinkedList<Character>();
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

}
