package com.solarmosaic.client.mail.configuration

import java.util.Properties
import javax.mail.Authenticator

/**
 * JavaMail API configuration for SMTP.
 * @see https://javamail.java.net/nonav/docs/api/com/sun/mail/smtp/package-summary.html
 *
 * @param host The hostname of the mail server.
 * @param port The port number of the mail server.
 * @param tls Enables or disables the use of a TLS-protected connection.
 * @param debug Enables or disables debug mode.
 */
case class SmtpConfiguration(
  host: String,
  port: Int,
  tls: Boolean = false,
  debug: Boolean = false,
  authenticator: Option[Authenticator] = None
) {
  /** The [[Properties]] representation of the configuration. */
  val properties: Properties = {
    val props = new Properties

    props.put("mail.debug", debug.toString)
    props.put("mail.smtp.host", host)
    props.put("mail.smtp.port", port.toString)
    props.put("mail.smtp.starttls.enable", tls.toString)
    props.put("mail.smtp.auth", authenticator.isDefined.toString)

    props
  }
}
