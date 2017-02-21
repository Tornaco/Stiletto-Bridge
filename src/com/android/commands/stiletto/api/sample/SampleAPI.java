package com.android.commands.stiletto.api.sample;

import com.android.commands.stiletto.StilettoAPI;
import com.google.gson.Gson;

/**
 * Created by guohao4 on 2/21/17.
 */
public class SampleAPI extends StilettoAPI {
    @Override
    public void parse(String... args) {
        String jsonStr = args[0];
        SampleObject param = new Gson().fromJson(jsonStr, SampleObject.class);
        println(param);
    }
}
