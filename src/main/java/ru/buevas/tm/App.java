package ru.buevas.tm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ru.buevas.tm.constant.TerminalConst.CmdParams;

/**
 * Основной класс приложения
 *
 * @author Andrey Buev
 */
public class App {

    /**
     * Точка входа в приложение
     *
     * @param args - параметры командной строки, переданные при старте приложения
     */
    public static void main(String[] args) {
        printWelcome();
        run(args);
        process();
    }

    /**
     * Запуск приложения с аргументом из командной строки
     *
     * @param args - массив аргументов
     */
    public static void run(final String[] args) {
        if (args == null || args.length < 1) {
            return;
        }

        final String command = args[0];
        System.exit(execCommand(command));
    }

    /**
     * Запуск приложения в режиме бесконечного цикла
     */
    public static void process() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String command = "";
        while (!CmdParams.EXIT.equals(command)) {
            try {
                command = reader.readLine();
                execCommand(command);
                System.out.println();
            } catch (IOException e) {
                printError(e.getMessage());
            }
        }
    }

    /**
     * Выполнение команды
     *
     * @param command - выполняемая команда
     * @return код ошибки или 0 в случае успешного завершения
     */
    public static int execCommand(final String command) {
        if (command == null || command.isEmpty()) {
            return -1;
        }
        switch (command) {
            case CmdParams.VERSION: {
                return printVersion();
            }
            case CmdParams.ABOUT: {
                return printAbout();
            }
            case CmdParams.HELP: {
                return printHelp();
            }
            case CmdParams.EXIT: {
                return exit();
            }
            default: {
                return printError("Unknown parameter");
            }
        }
    }

    /**
     * Вывод на экран приветствия
     */
    public static void printWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    /**
     * Вывод на экран версии приложения
     *
     * @return 0
     */
    public static int printVersion() {
        System.out.println("Task Manager version 1.0.0");
        return 0;
    }

    /**
     * Вывод на экран сведений о разработчике
     *
     * @return 0
     */
    public static int printAbout() {
        System.out.println("Developer: Andrey Buev (buev_as@mail.ru)");
        return 0;
    }

    /**
     * Вывод на эркан справки по доступным командам
     *
     * @return 0
     */
    public static int printHelp() {
        System.out.println("version - Display version information");
        System.out.println("about - Display developer information");
        System.out.println("help - Display list of commands information");
        System.out.println("exit - Close application");
        return 0;
    }

    /**
     * Вывод на экран сообщения об ошибке
     *
     * @param message - сообщение
     * @return -1
     */
    public static int printError(String message) {
        System.out.println("Error: " + message);
        return -1;
    }

    /**
     * Завершение работы приложения
     *
     * @return 0
     */
    public static int exit() {
        System.exit(0);
        return 0;
    }
}
