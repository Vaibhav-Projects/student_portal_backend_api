package com.test.school.portal.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.command.Command;
import com.test.command.Commander;
import com.test.school.portal.command.subject.SubjectCommander;
import com.test.school.portal.command.tasks.subject.SubjectCommand;
import com.test.school.portal.service.request.SubjectRequest;
import com.test.school.portal.service.response.SubjectResponse;

@Configuration
public class SubjectCommandConfig {

	@Bean(name = "subjectCommander")
	public Commander<SubjectRequest, SubjectResponse> subjectCommander() {
		SubjectCommander commander = new SubjectCommander();

		@SuppressWarnings("unchecked")
		Command<SubjectRequest, SubjectResponse>[] commands = new Command[] { subjectCommand() };
		commander.setCommands(commands);
		return commander;
	}

	@Bean
	public SubjectCommand subjectCommand() {
		SubjectCommand command = new SubjectCommand();
		return command;
	}

}
