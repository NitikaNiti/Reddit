package com.reddit.reddit.service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.reddit.reddit.exception.SpringRedditException;
import com.reddit.reddit.model.NotificationEmail;

import jdk.internal.org.jline.utils.Log;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
	private final JavaMailSender javaMailSender;
	private final MailContentBuilder mailContentBuilder;

	void sendMail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("nitikamicrosoft1@gmail.com");
			messageHelper.setTo(notificationEmail.getRecipient());
			messageHelper.setSubject(notificationEmail.getSubject());
			messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
		};
		try {
			javaMailSender.send(messagePreparator);
				log.info("activation mail send");
			}catch(MailException e) {
				throw new SpringRedditException("Exception occured while sending the message!!" + notificationEmail.getRecipient());
			}
		}
	}

