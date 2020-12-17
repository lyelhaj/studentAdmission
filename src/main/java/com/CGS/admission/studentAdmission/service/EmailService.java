package com.CGS.admission.studentAdmission.service;

import com.CGS.admission.studentAdmission.entities.MailRequest;
import com.CGS.admission.studentAdmission.entities.MailRespons;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration config;

    public MailRespons sendEmail(MailRequest request, Map<String, Object> model) {
        MailRespons response = new MailRespons();
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            //helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
            Template t = config.getTemplate("email-template.ftl");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

            helper.setTo(request.getTo());
            helper.setText(html, true);
            helper.setSubject(request.getSubject());
            helper.setFrom(request.getFrom());
            sender.send(message);
            response.setMessage("mail sent to : " + request.getTo());
            response.setStatus(Boolean.TRUE);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return response;

    }
}
