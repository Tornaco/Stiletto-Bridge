package com.android.commands.stiletto.common;

import com.google.gson.Gson;

/**
 * Created by guohao4 on 2/21/17.
 */
public class Command {

    private static final String COMMAND_STILETTO = "stiletto";
    private static final String ARGS_SPLITTER = " ";

    private String args;

    private Command(String args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return args;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder startedBuilder() {
        return new Builder().start();
    }

    public static class Builder {

        private Builder() {
            // Noop
        }

       private StringBuilder argsBuilder = null;

        public Builder start() {
            argsBuilder = new StringBuilder(COMMAND_STILETTO);
            return Builder.this;
        }

        public Builder addArg(String arg) {
            argsBuilder.append(ARGS_SPLITTER);
            argsBuilder.append(arg);
            return Builder.this;
        }

        public Builder addArgs(String... args) {
            for (String arg : args) {
                addArg(arg);
            }
            return Builder.this;
        }

        public Builder addArg(Object src) {
            argsBuilder.append(ARGS_SPLITTER);
            String str = new Gson().toJson(src);
            argsBuilder.append(str);
            return Builder.this;
        }

        public Builder addArgs(Object... args) {
            for (Object arg : args) {
                addArg(arg);
            }
            return Builder.this;
        }

        public Command build() {
            return new Command(argsBuilder.toString());
        }
    }
}
