package com.vithsense.pojos;

import com.vithsense.enums.CommandType;

public class Command {
    private CommandType type;
    private String commandText;
    private String expectedResult;
    private int timeout;

    public Command(CommandType type, String commandText, String expectedResult, int timeout) {
        this.type = type;
        this.commandText = commandText;
        this.expectedResult = expectedResult;
        this.timeout = timeout;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public String getCommandText() {
        return commandText;
    }

    public void setCommandText(String commandText) {
        this.commandText = commandText;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "Command{" +
                "type=" + type +
                ", commandText='" + commandText + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", timeout=" + timeout +
                '}';
    }
}
