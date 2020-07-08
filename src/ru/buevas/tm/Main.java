package ru.buevas.tm;

import ru.buevas.tm.constant.TerminalConst.CmdParams;

public class Main {

    public static void main(String[] args) {
        printWelcome();
        run(args);
    }

    public static void run(final String[] args) {
        if (args == null || args.length < 1) return;

        final String param = args[0];
        switch (param) {
            case CmdParams.VERSION: {
                printVersion();
            }
            case CmdParams.ABOUT: {
                printAbout();
            }
            case CmdParams.HELP: {
                printHelp();
            }
            default: {
                printError();
            }
        }
    }

    public static void printWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    public static void printVersion() {
        System.out.println("Task Manager version 1.0.0");
        System.exit(0);
    }

    public static void printAbout() {
        System.out.println("Developer: Andrey Buev (buev_as@mail.ru)");
        System.exit(0);
    }

    public static void printHelp() {
        System.out.println("version - Display version information");
        System.out.println("about - Display developer information");
        System.out.println("help - Display list of commands information");
        System.exit(0);
    }

    public static void printError() {
        System.out.println("Error: Unknown parameter");
        System.exit(-1);
    }
}
