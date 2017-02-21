package com.android.commands.stiletto.common;

/**
 * Created by guohao4 on 2/21/17.
 */
public interface ResultReceiver {
    void onResult(String res);
    void onError(String message);
}
