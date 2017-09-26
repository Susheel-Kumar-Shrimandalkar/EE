package whitefeather.xedge.appservices;


import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.Reporter;
import whitefeather.xedge.appconfig.Constants;
import whitefeather.xedge.appconfig.ObjectMapping;


public class EmailerService 
{
	static ObjectMapping properties = new ObjectMapping(Constants.USERDATA);
	
	public static void SendTestReport() throws FileNotFoundException
	{
		
	      // Host Name of the Server. ExtraaEdge Server uses Gmail Servers and hence Gmail host
	      String host = "smtp.gmail.com";
	      
	      Properties props = new Properties();
	      
	      //Allow to authenticate Email Account
	      props.put("mail.smtp.auth", "true");
	      
	      //Enable Transport Layer Security
	      props.put("mail.smtp.starttls.enable", "true");
	      
	      //Set Host Email Server
	      props.put("mail.smtp.host", host);
	      
	      //Provide Port Number for Host set
	      props.put("mail.smtp.port","587");
	      

	      // Create new session. Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(
	            		   properties.getFromEmailAddress(), properties.getFromEmailAccountPassword());
	            }
	         });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         try {
				message.setFrom(new InternetAddress(properties.getFromEmailAddress(),"ExtraaEdge Technology Solutions"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	         message.addRecipients(Message.RecipientType.TO,
        			 InternetAddress.parse(properties.getToEmailAddress()));
        	 message.addRecipients(Message.RecipientType.CC,
        			 InternetAddress.parse(properties.getCCEmailAddresses()));
        	 message.addRecipients(Message.RecipientType.BCC, properties.getBCCEmailAddresses());
        	 

	         // Set Subject: header field
	         message.setSubject("Test Report || "+properties.getCurrentTime());

	         
	         // Create a multipart message
	         Multipart multipart = new MimeMultipart();
	         
	         // Create the message part
	         MimeBodyPart messageBodyPart = new MimeBodyPart();

	         /*
	         // Now set the actual message
	         messageBodyPart.setText("Hi, \nThis is system generated Email. Sample demonstration of Emailing the Test Report."
	         		+ "\nPlease find below the attached report of recent "
	         		+ "deployment. To view the report, download and open it in suitable browser.");	        
	         // Set text message part
	       		  multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         
	         String filename = ".//test-output//emailable-report.html";
	         GenerateZip.generateZipReport();
	         String filename = Constants.ZIPDESTLOCATION;
	         */
	         
	         String filename = ".//test-output//emailable-report.html";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName("TestReport.html");
	         
	         multipart.addBodyPart(messageBodyPart);
	         BodyPart htmlBodyPart = new MimeBodyPart();
	         
	         String someHtmlMessage="<html> <style type=\"text/css\" id=\"media-query\"> body{margin: 0; padding: 0;}table, tr, td{vertical-align: top; border-collapse: collapse;}.ie-browser table, .mso-container table{table-layout: fixed;}*{line-height: inherit;}a[x-apple-data-detectors=true]{color: inherit !important; text-decoration: none !important;}[owa] .img-container div, [owa] .img-container button{display: block !important;}[owa] .fullwidth button{width: 100% !important;}.ie-browser .col, [owa] .block-grid .col{display: table-cell; float: none !important; vertical-align: top;}.ie-browser .num12, .ie-browser .block-grid, [owa] .num12, [owa] .block-grid{width: 530px !important;}.ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div{line-height: 100%;}.ie-browser .mixed-two-up .num4, [owa] .mixed-two-up .num4{width: 176px !important;}.ie-browser .mixed-two-up .num8, [owa] .mixed-two-up .num8{width: 352px !important;}.ie-browser .block-grid.two-up .col, [owa] .block-grid.two-up .col{width: 265px !important;}.ie-browser .block-grid.three-up .col, [owa] .block-grid.three-up .col{width: 176px !important;}.ie-browser .block-grid.four-up .col, [owa] .block-grid.four-up .col{width: 132px !important;}.ie-browser .block-grid.five-up .col, [owa] .block-grid.five-up .col{width: 106px !important;}.ie-browser .block-grid.six-up .col, [owa] .block-grid.six-up .col{width: 88px !important;}.ie-browser .block-grid.seven-up .col, [owa] .block-grid.seven-up .col{width: 75px !important;}.ie-browser .block-grid.eight-up .col, [owa] .block-grid.eight-up .col{width: 66px !important;}.ie-browser .block-grid.nine-up .col, [owa] .block-grid.nine-up .col{width: 58px !important;}.ie-browser .block-grid.ten-up .col, [owa] .block-grid.ten-up .col{width: 53px !important;}.ie-browser .block-grid.eleven-up .col, [owa] .block-grid.eleven-up .col{width: 48px !important;}.ie-browser .block-grid.twelve-up .col, [owa] .block-grid.twelve-up .col{width: 44px !important;}@media only screen and (min-width: 550px){.block-grid{width: 530px !important;}.block-grid .col{display: table-cell; Float: none !important; vertical-align: top;}.block-grid .col.num12{width: 530px !important;}.block-grid.mixed-two-up .col.num4{width: 176px !important;}.block-grid.mixed-two-up .col.num8{width: 352px !important;}.block-grid.two-up .col{width: 265px !important;}.block-grid.three-up .col{width: 176px !important;}.block-grid.four-up .col{width: 132px !important;}.block-grid.five-up .col{width: 106px !important;}.block-grid.six-up .col{width: 88px !important;}.block-grid.seven-up .col{width: 75px !important;}.block-grid.eight-up .col{width: 66px !important;}.block-grid.nine-up .col{width: 58px !important;}.block-grid.ten-up .col{width: 53px !important;}.block-grid.eleven-up .col{width: 48px !important;}.block-grid.twelve-up .col{width: 44px !important;}}@media (max-width: 550px){.block-grid, .col{min-width: 320px !important; max-width: 100% !important;}.block-grid{width: calc(100% - 40px) !important;}.col{width: 100% !important;}.col > div{margin: 0 auto;}img.fullwidth{max-width: 100% !important;}}</style></head><!--[if mso]><body class=\"mso-container\" style=\"background-color:#FFFFFF;\"><![endif]--><body class=\"clean-body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #FFFFFF\"> <div class=\"nl-container\" style=\"min-width: 320px;Margin: 0 auto;background-color: #FFFFFF\"> <div style=\"background-color:#2C2D37;\"> <div style=\"Margin: 0 auto;min-width: 320px;max-width: 530px;width: 530px;width: calc(22000% - 120470px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid two-up\"> <div style=\"border-collapse: collapse;display: table;width: 100%;\"> <div class=\"col num6\" style=\"Float: left;max-width: 320px;min-width: 265px;width: 265px;width: calc(29415px - 5500%);background-color: transparent;\"> <div style=\"background-color: transparent; width: 100% !important;\"> <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:20px; padding-bottom:5px; padding-right: 0px; padding-left: 0px;\"> <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"><div style=\"font-size:12px;line-height:14px;font-family:&quot;Trebuchet MS&quot;, &quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, &quot;Lucida Sans&quot;, Tahoma, sans-serif;color:#F80E00;text-align:center;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px\"><span style=\"font-size: 22px; line-height: 26px;\"><strong>Front End Test Report</strong></span><br></p></div></div></div></div></div><div class=\"col num6\" style=\"Float: left;max-width: 320px;min-width: 265px;width: 265px;width: calc(29415px - 5500%);background-color: transparent;\"> <div style=\"background-color: transparent; width: 100% !important;\"> <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:20px; padding-bottom:20px; padding-right: 0px; padding-left: 0px;\"> <div style=\"padding-right: 5px; padding-left: 15px; padding-top: 10px; padding-bottom: 0px;\"><div style=\"font-size:12px;line-height:18px;color:#6E6F7A;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:center;\"><div style=\"line-height:18px; font-size:12px; text-align: center;\"><strong><span style=\"font-size: 16px; line-height: 24px;\">"+properties.getCurrentTime()+"</span></strong></div></div></div></div></div></div></div></div></div><div style=\"background-color:#323341;\"> <div style=\"Margin: 0 auto;min-width: 320px;max-width: 530px;width: 530px;width: calc(22000% - 120470px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \"> <div style=\"border-collapse: collapse;display: table;width: 100%;\"> <div class=\"col num12\" style=\"min-width: 320px;max-width: 530px;width: 530px;width: calc(21000% - 110770px);background-color: transparent;\"> <div style=\"background-color: transparent; width: 100% !important;\"> <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:0px; padding-bottom:0px; padding-right: 0px; padding-left: 0px;\"> <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"> <div align=\"center\"><div style=\"border-top: 10px solid transparent; width:100%; line-height:0px;\">&nbsp;</div></div></div><div style=\"padding-right: 0px; padding-left: 0px; padding-top: 30px; padding-bottom: 30px;\"><div style=\"font-size:12px;line-height:14px;color:#ffffff;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 17px;text-align: center\"><strong><span style=\"font-size: 28px; line-height: 33px;\">Deployment 2.3.1<br></span></strong></p></div></div><div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"> <div align=\"center\"><div style=\"border-top: 10px solid transparent; width:100%; line-height:0px;\">&nbsp;</div></div></div></div></div></div></div></div></div><div style=\"background-color:#61626F;\"> <div style=\"Margin: 0 auto;min-width: 320px;max-width: 530px;width: 530px;width: calc(22000% - 120470px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\" class=\"block-grid \"> <div style=\"border-collapse: collapse;display: table;width: 100%;\"> <div class=\"col num12\" style=\"min-width: 320px;max-width: 530px;width: 530px;width: calc(21000% - 110770px);background-color: transparent;\"> <div style=\"background-color: transparent; width: 100% !important;\"> <div style=\"border-top: 0px solid transparent; border-left: 0px solid transparent; border-bottom: 0px solid transparent; border-right: 0px solid transparent; padding-top:30px; padding-bottom:30px; padding-right: 0px; padding-left: 0px;\"> <div style=\"padding-right: 10px; padding-left: 10px; padding-top: 25px; padding-bottom: 10px;\"><div style=\"font-size:12px;line-height:14px;color:#ffffff;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 18px;line-height: 22px;text-align: center\"><span style=\"text-decoration: underline; font-size: 18px; line-height: 21px;\"><span style=\"font-size: 14px; line-height: 16px;\" mce-data-marked=\"1\">System Generated Email Report</span></span></p></div></div><div style=\"padding-right: 10px; padding-left: 10px; padding-top: 0px; padding-bottom: 10px;\"><div style=\"font-size:12px;line-height:18px;color:#B8B8C0;font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;text-align:left;\"><p style=\"margin: 0;font-size: 14px;line-height: 21px;text-align: center\">&nbsp;<br></p>This is system generated email. Test report for current deployment is attached below.&nbsp;To view, download and&nbsp;open it in your favorite browser.</div></div><div align=\"center\" class=\"button-container center\" style=\"padding-right: 10px; padding-left: 10px; padding-top:15px; padding-bottom:10px;\"> <div style=\"color: #ffffff; background-color: #C7702E; border-radius: 25px; -webkit-border-radius: 25px; -moz-border-radius: 25px; max-width: 134px; width: 94px; width: 25%; border-top: 0px solid transparent; border-right: 0px solid transparent; border-bottom: 0px solid transparent; border-left: 0px solid transparent; padding-top: 5px; padding-right: 20px; padding-bottom: 5px; padding-left: 20px; font-family: Arial, 'Helvetica Neue', Helvetica, sans-serif; text-align: center; mso-border-alt: none;\"> <span style=\"font-size:16px;line-height:32px;\"><span style=\"font-size: 14px; line-height: 28px;\" data-mce-style=\"font-size: 14px;\" mce-data-marked=\"1\">Thank You</span></span> </div></div><div style=\"padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px;\"> <div align=\"center\"><div style=\"border-top: 0px solid transparent; width:100%; line-height:0px;\">&nbsp;</div></div></div></div></div></div></div></div></div></div></body></html>";
	         htmlBodyPart.setContent(someHtmlMessage, "text/html; charset=utf-8");
	         
	         multipart.addBodyPart(htmlBodyPart);
	         message.setContent(multipart);

	         //Send message
	         Transport.send(message);
	         Reporter.log("Test report has been sent to intended recepeints successfully",true);
	      } 
	      catch (MessagingException e) 
	      {
	    	  Reporter.log("Sending Test report to intended recepients is failed.",true);
	         throw new RuntimeException(e);
	      }
	  }

/*	public static void main(String[] args) throws FileNotFoundException {
		SendTestReport();
	}
*/

}

