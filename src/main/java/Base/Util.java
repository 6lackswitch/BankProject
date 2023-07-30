package Base;

import java.time.LocalDateTime;

public class Util {
    public static String fibonacciInt() {
        int day = LocalDateTime.now().getDayOfMonth() + 1;
        int a = 0;
        int b = 1;
        for (int i = 2; i <= day; ++i) {
            int next = a + b;
            a = b;
            b = next;
        }
        return String.valueOf(b);
    }
}
