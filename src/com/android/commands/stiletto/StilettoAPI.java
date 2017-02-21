package com.android.commands.stiletto;

/**
 * Created by guohao4 on 2/21/17.
 */
public abstract class StilettoAPI {

    public abstract void parse(String... args);

    protected void println(Object arg) {
        System.err.println(String.valueOf(arg));
    }
}
