package com.uver99.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class DummyMailService implements MailSender {
    final Logger  LOG = LoggerFactory.getLogger(DummyMailService.class);
	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		LOG.debug("=====================");
		LOG.debug("=개발:send()=");
		LOG.debug("=====================");
	}

	@Override
	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		LOG.debug("=====================");
		LOG.debug("=개발:send()=");
		LOG.debug("=====================");

	}

}
