package com.test.school.portal.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.command.Command;
import com.test.command.Commander;
import com.test.school.portal.command.student.StudentCommander;
import com.test.school.portal.command.tasks.student.StudentCommand;
import com.test.school.portal.service.request.StudentRequest;
import com.test.school.portal.service.response.StudentResponse;

@Configuration
public class StudentCommandConfig {

	@Bean(name = "studentCommander")
	public Commander<StudentRequest, StudentResponse> studentCommander() {
		StudentCommander commander = new StudentCommander();

		@SuppressWarnings("unchecked")
		Command<StudentRequest, StudentResponse>[] commands = new Command[] { studentCommand() };
		commander.setCommands(commands);
		return commander;
	}

	@Bean
	public StudentCommand studentCommand() {
		StudentCommand command = new StudentCommand();
		return command;
	}
}
