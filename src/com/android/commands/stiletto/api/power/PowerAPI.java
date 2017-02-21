package com.android.commands.stiletto.api.power;

import android.os.IPowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.commands.stiletto.StilettoAPI;
import com.google.gson.Gson;

/**
 * Created by guohao4 on 2/21/17.
 */
public class PowerAPI extends StilettoAPI {
    @Override
    public void parse(String... args) {

        Gson gson = new Gson();

        if ("reboot".equals(args[0])) {
            println("rebooting...");
            IPowerManager pm = IPowerManager.Stub.asInterface(ServiceManager.getService("power"));
            println("pm = " + pm);
            try {
                pm.reboot(false, null, false);
            } catch (RemoteException e) {
                println(e.getLocalizedMessage());
            } catch (SecurityException se) {
                println("pm throws secure err = " + se.getLocalizedMessage());
            }
        }
    }
}
