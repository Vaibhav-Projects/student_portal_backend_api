package com.vaibhav.command;

import java.util.Arrays;

public abstract class AbstractCommander<T, S> implements Commander<T, S> {

	private Command<T, S>[] commands;

	@Override
	public S issueCommand(T request) {
		S response = null;
		for (Command<T, S> command : commands) {
			if (command.isProcessor()) {
				response = command.process(request);
			} else {
				command.execute(request);
			}
		}
		return response;
	}

	public void setCommands(Command<T, S>[] commands) {
		this.commands = Arrays.copyOf(commands, commands.length);
	}
}
