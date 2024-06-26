package co.edu.unbosque.util;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

/**
 * The EnvioCorreo class provides functionality to send emails with or without attachments
 * using SMTP servers such as Gmail and Outlook.
 *
 *@author Moreno.JP
 * @version 26/04/2024
 */

public class EnvioCorreo {

	private static final String PROTOCOL = "smtp";
	private static final String SMTP_SERVER_LIVE = "smtp.live.com";
	private static final String SMTP_SERVER_GMAIL = "smtp.gmail.com";
	private static final String SMTP_PORT_GMAIL = "587";
	private static final String SMTP_USERNAME = "correodev.unbosque@gmail.com";
	private static final String SMTP_PASSWORD = "kwew abxx mted ttmi";
	
	private Properties props = new Properties();

	 /**
     * Sends an email with the specified parameters.
     *
     * @param destino The recipient's email address.
     * @param asunto The subject of the email.
     * @param texto The body text of the email.
     * @param archivo The file to be attached to the email, can be null.
     * @return true if the email was sent successfully, false otherwise.
     */
	
	public boolean enviaCfd(final String destino, final String asunto, final String texto, File archivo) {
		try {
			Multipart multipart = new MimeMultipart();
			MimeBodyPart attachmentPart = null;
			if (archivo != null) {
				BodyPart _texto = new MimeBodyPart();
				_texto.setText(texto);
				attachmentPart = new MimeBodyPart();
				FileDataSource fileDataSource = new FileDataSource(archivo);
				attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				attachmentPart.setFileName(texto);
				attachmentPart.attachFile(archivo);
				multipart.addBodyPart(attachmentPart);
				multipart.addBodyPart(_texto);
			}
			
			String cuenta[] = SMTP_USERNAME.split("@");
			SMTP_SERVER(SMTP_USERNAME, cuenta[1]);
			
			Session session = Session.getDefaultInstance(props);
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(destino));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
			message.setSubject(asunto);
			message.setText(texto);
			if (archivo != null) {
				message.setContent(multipart);
			}
			
			Transport t = session.getTransport(PROTOCOL);
			t.connect(SMTP_USERNAME, SMTP_PASSWORD);
			t.sendMessage(message, message.getAllRecipients());

			t.close();
			return true;
		} catch (MessagingException | IOException e) {

			return false;
		}
	}

	/**
     * Configures the SMTP server properties based on the user's email domain.
     *
     * @param user The email username.
     * @param cuenta The email domain.
     */
	
	public void SMTP_SERVER(final String user, final String cuenta) {
		switch (cuenta) {
		case "gmail.com":
			props.setProperty("mail.smtp.host", SMTP_SERVER_GMAIL);
			props.setProperty("mail.smtp.port", SMTP_PORT_GMAIL);
			break;
		case "outlook.com":
		case "hotmail.com":
		case "live.com.mx":
			props.setProperty("mail.smtp.host", SMTP_SERVER_LIVE);
			props.setProperty("mail.smtp.port", SMTP_PORT_GMAIL);
			break;
		}
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.user", user);
		props.setProperty("mail.smtp.auth", "true");
	}
}
