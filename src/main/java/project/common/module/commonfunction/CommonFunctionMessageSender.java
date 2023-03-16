package project.common.module.commonfunction;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.MimeMessageHelper;

import project.conf.resource.ormapper.dto.oracle.SysUser;
import zebra.mail.AbstractMessageSender;
import zebra.util.ConfigUtil;

@SuppressWarnings("rawtypes")
public class CommonFunctionMessageSender extends AbstractMessageSender implements ApplicationListener {
	public void sendResetPasswordMessage(SysUser sysUser, String randomString) throws Exception {
		String defaultEncoding = ConfigUtil.getProperty("mail.default.encoding");
		String subject = "Password Reset Notice";
		String userName = sysUser.getUserName();
		String email = sysUser.getEmail();

		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, defaultEncoding);

			mimeMessageHelper.setTo(new InternetAddress(email, userName, defaultEncoding));
			mimeMessageHelper.setFrom(ConfigUtil.getProperty("mail.default.from"));
			mimeMessageHelper.setSubject(subject);

			StringBuffer sb = new StringBuffer();
			sb.append("<html><head></head><body>");
			sb.append("Password Reset Notice for "+userName+"<br/><br/>");
			sb.append("Login ID : "+sysUser.getLoginId()+"<br/>");
			sb.append("Password : "+randomString+"<br/>");
			sb.append("</body></html>");

			mimeMessageHelper.setText(sb.toString(), sb.toString());

			javaMailSender.send(mimeMessage);
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		}
	}

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
	}
}