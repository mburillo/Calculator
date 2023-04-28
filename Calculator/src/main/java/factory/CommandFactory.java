package factory;

import command.Command;

public interface CommandFactory{
    Command create(String[] arg);
}
