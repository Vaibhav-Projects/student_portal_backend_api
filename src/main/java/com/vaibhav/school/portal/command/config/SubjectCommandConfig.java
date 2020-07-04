package com.vaibhav.school.portal.command.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaibhav.command.Command;
import com.vaibhav.command.Commander;
import com.vaibhav.school.portal.command.subject.SubjectCommander;
import com.vaibhav.school.portal.command.tasks.subject.SubjectCommand;
import com.vaibhav.school.portal.service.request.SubjectRequest;
import com.vaibhav.school.portal.service.response.SubjectResponse;

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
