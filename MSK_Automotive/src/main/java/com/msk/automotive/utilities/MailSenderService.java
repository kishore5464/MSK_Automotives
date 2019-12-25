package com.msk.automotive.utilities;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
//import org.springframework.ui.velocity.VelocityEngineUtils;

@Configuration
@PropertySource("classpath:/application_path.properties")
@Service
public class MailSenderService {

	@Autowired
	Environment environment;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	VelocityEngine velocityEngine;

	private final String fromEmailAddress = "fbtkishore@gmail.com";

	public void sendAccessCode(final String email, final String access_code) {
		final String subject = "Forgot Password";
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
				message.setTo(email);
				message.setFrom(new InternetAddress(fromEmailAddress));
				message.setSubject(subject);
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("email", email);
				model.put("access_code", access_code);

//				String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "./templates/forget_pass.vm",
//						"UTF-8", model);
//				message.setText(body, true);
			}
		};
		this.mailSender.send(preparator);
	}

}