package com.android.commands.stiletto;

/**
 * Created by guohao4 on 2/21/17.
 */
public class StilettoCmd implements Runnable {

    enum CommandVerb {
        UNSPECIFIED
    }

    static String[] mArgs;
    int mNextArg;

    CommandVerb mVerb = CommandVerb.UNSPECIFIED;


    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            printUsage();
            return;
        }

        mArgs = args;
        try {
            new StilettoCmd().run();
        } catch (Exception e) {
            print("Unable to run stiletto command");
        }
    }

    private String nextArg() {
        if (mNextArg >= mArgs.length) {
            return null;
        }
        String arg = mArgs[mNextArg];
        mNextArg++;
        return arg;
    }

    private static void printUsage() {
        print("usage:  stiletto [--user <USER_ID> | current] get namespace key");
    }

    private static void print(Object arg) {
        System.err.println(String.valueOf(arg));
    }

    @Override
    public void run() {

        String arg;
        boolean valid = false;
        try {
            while ((arg = nextArg()) != null) {
                print("arg=" + arg);
            }
        } catch (Exception e) {
            valid = false;
        }

        if (valid) {
            try {
               switch (mVerb) {

               }
            } catch (Exception e) {
                print("Error while accessing settings provider");
                e.printStackTrace();
            }
        } else {
            printUsage();
        }
    }
}
