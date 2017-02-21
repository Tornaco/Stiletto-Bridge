package com.android.commands.stiletto.api.sample;

/**
 * Created by guohao4 on 2/21/17.
 */
public class SampleObject {

    String n;
    int i;
    float f;

    public float getF() {
        return f;
    }

    public int getI() {
        return i;
    }

    public String getN() {
        return n;
    }

    public void setF(float f) {
        this.f = f;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "N-I-F" + n + "-" + i + "-" + f;
    }
}
