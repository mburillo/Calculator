package command;

import requester.Calculator;

public interface Command {
    void execute(Calculator calc);
}