package com.android.commands.stiletto.common;

import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.common.base.Preconditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by guohao4 on 2/21/17.
 */
public class StilettoCommandSender {

    @WorkerThread
    public void send(@NonNull Command command, @NonNull ResultReceiver resultReceiver) {

        Preconditions.checkNotNull(command, "null command");
        Preconditions.checkNotNull(resultReceiver, "null receiver");

        try {
            InputStream is = Runtime.getRuntime().exec(command.toString()).getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String message;

            while ((message = reader.readLine()) != null) {
                resultReceiver.onResult(message);
            }

        } catch (IOException e) {
            resultReceiver.onError(e.getLocalizedMessage());
        }
    }

    public void sendAsync(final Command command, final ResultReceiver resultReceiver) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                send(command, resultReceiver);
            }
        }).start();
    }
}
