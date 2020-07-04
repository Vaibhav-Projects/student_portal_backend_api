package com.test.school.portal.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.command.Command;
import com.test.command.Commander;
import com.test.school.portal.command.tasks.teacher.TeacherCommand;
import com.test.school.portal.command.teacher.TeacherCommander;
import com.test.school.portal.service.request.TeacherRequest;
import com.test.school.portal.service.response.TeacherResponse;

@Configuration
public class TeacherCommandConfig {

	@Bean(name = "teacherCommander")
	public Commander<TeacherRequest, TeacherResponse> teacherCommander() {
		TeacherCommander commander = new TeacherCommander();

		@SuppressWarnings("unchecked")
		Command<TeacherRequest, TeacherResponse>[] commands = new Command[] { teacherCommand() };
		commander.setCommands(commands);
		return commander;
	}

	@Bean
	public TeacherCommand teacherCommand() {
		TeacherCommand command = new TeacherCommand();
		return command;
	}
}
