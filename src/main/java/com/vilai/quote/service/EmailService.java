package com.vilai.quote.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    public String sendEmail(String to, String subject, String content) {
        Email from = new Email("maadhava.muralidharan+b@chargebee.com"); // Replace with your verified email
        Email toEmail = new Email(to);
        subject = "Important: Please find your Chargebee Quote here";

        // Body text for the email
        String bodyText = "Dear Customer,\n\nPlease find the attached PDF document, which includes a personalized quotation crafted to best suit your requirements.\n\nBest regards,\nTeam VilAI | Chargebee";

        Content emailContent = new Content("text/plain", bodyText);

        Mail mail = new Mail(from, subject, toEmail, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            File pdfFile = new File("/Users/cbit011042/work/quotes/src/main/resources/Quote.pdf"); // Replace with your file path
            byte[] fileContent = Files.readAllBytes(pdfFile.toPath());
            String encodedContent = Base64.getEncoder().encodeToString(fileContent); // Encode file in Base64

            // Create the attachment object
            Attachments attachments = new Attachments();
            attachments.setFilename("Quote.pdf");
            attachments.setType("application/pdf");
            attachments.setDisposition("attachment");
            attachments.setContent(encodedContent);

            // Add the attachment to the email
            mail.addAttachments(attachments);
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            return "Email sent with status code: " + response.getStatusCode() + response.getBody();
        } catch (IOException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}

