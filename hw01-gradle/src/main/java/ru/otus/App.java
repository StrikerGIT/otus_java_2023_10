package ru.otus;

import static com.google.common.base.Strings.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class.getSimpleName());

    @SuppressWarnings("UseOfSystemOutOrSystemErr")
    public static void main(String... args) {
        String str = null;
        str = nullToEmpty(str);
        str = emptyToNull(str);
        if (!isNullOrEmpty(str)) {
            logger.log(Level.INFO, str);
        }
    }
}
