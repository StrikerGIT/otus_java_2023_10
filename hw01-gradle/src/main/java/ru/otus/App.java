
package ru.otus;
import static com.google.common.base.Strings.*;

public class App {
    public static void main(String... args) {
        String str = null;
        str = nullToEmpty(str);
        str = emptyToNull(str);
        if(!isNullOrEmpty(str)) {
            System.out.println(str); // ругается на отсутствие логера
        }
    }
}
