package hackerton.refactor.domain.service;

import hackerton.refactor.general.enums.BadStatusCode;
import hackerton.refactor.general.exception.ServerErrorException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.UUID;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    private final Semaphore emailSemaphore = new Semaphore(20);

    @Async("emailAsyncExecutor")
    public void sendEmail(String email) {

        boolean acquired = false;

        try {
            acquired = emailSemaphore.tryAcquire(3, TimeUnit.SECONDS);

            if (!acquired) {
                throw new ServerErrorException(
                        BadStatusCode.MAIL_QUEUE_FULL_EXCEPTION
                );
            }

            String verificationCode = generateCode();

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(new InternetAddress(
                    "zibi_official@naver.com", "경상났네 운영팀"));
            helper.setTo(email);
            helper.setSubject("[경상났네] 이메일 인증번호 안내");

            Context context = new Context();
            context.setVariable("code", verificationCode);

            String htmlContent =
                    templateEngine.process("email/verification", context);

            helper.setText(htmlContent, true);

            javaMailSender.send(message);


        } catch (Exception e) {
            throw new ServerErrorException(
                    BadStatusCode.FAIL_TO_SEND_MAIL_EXCEPTION
            );

        } finally {
            if (acquired) {
                emailSemaphore.release();
            }
        }
    }

    public String generateCode() {
        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        return uuid.substring(0, 6);
    }
}
