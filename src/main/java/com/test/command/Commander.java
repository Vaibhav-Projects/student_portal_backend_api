package com.test.command;

public interface Commander<T, S> extends Command<T, S> {

	S issueCommand(T t);
}
