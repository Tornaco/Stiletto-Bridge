package com.android.commands.stiletto;

import android.os.Binder;
import com.android.commands.stiletto.api.power.PowerAPI;
import com.android.commands.stiletto.api.sample.SampleAPI;

/**
 * Created by guohao4 on 2/21/17.
 */
public class StilettoCmd implements Runnable {

    enum CommandVerb implements APIFetcher{
        POWER {
            @Override
            public StilettoAPI getAPI() {
                return new PowerAPI();
            }
        },
        PKG {
            @Override
            public StilettoAPI getAPI() {
                return null;
            }
        },
        AM {
            @Override
            public StilettoAPI getAPI() {
                return null;
            }
        },
        SETTINGS {
            @Override
            public StilettoAPI getAPI() {
                return null;
            }
        },
        SAMPLE {
            @Override
            public StilettoAPI getAPI() {
                return new SampleAPI();
            }
        },
        UNSPECIFIED {
            @Override
            public StilettoAPI getAPI() {
                return null;
            }
        };

        static CommandVerb from(String arg) {
            for (CommandVerb c : values()) {
                if (arg.equalsIgnoreCase(c.name())) {
                    return c;
                }
            }
            return UNSPECIFIED;
        }
    }

    interface APIFetcher {
        StilettoAPI getAPI();
    }

    class FakeService extends Binder {

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

        long uid = Binder.getCallingUid();
        print("uid:" + uid);
        long pid = Binder.getCallingPid();
        print("pid:" + pid);

        Binder.clearCallingIdentity();

        String arg = nextArg();
        mVerb = CommandVerb.from(arg);
        print("verb=" + mVerb);
        if (mVerb == CommandVerb.UNSPECIFIED) {
            print("Bad arg:" + arg);
            return;
        }
        mVerb.getAPI().parse(nextArg());
    }
}
