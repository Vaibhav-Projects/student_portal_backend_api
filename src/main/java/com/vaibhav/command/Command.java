package com.vaibhav.command;

public interface Command<T, S> {

	default void execute(T t) {
	}

	default S process(T t) {
		return null;
	}

	default boolean isProcessor() {
		return false;
	}
}
