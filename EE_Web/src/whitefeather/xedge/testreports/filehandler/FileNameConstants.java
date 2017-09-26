package whitefeather.xedge.testreports.filehandler;

import whitefeather.xedge.facilitator.HelperHand;

public class FileNameConstants {

	/*
	 * Folder name constants
	 */

	public static final String ROOT_FOLDER = "Test Automation Report (EETSPL Pune)";

	public static final String SUITE_FOLDER_PREFIX = "Test Report";

	public static final String SUITE_FOLDER_SUFFIX = "_Report";

	public static final String HYPHEN = "-";

	public static final String CSS_FOLDER = "css";

	public static final String JS_FOLDER = "js";

	public static final String FONT_FOLDER = "fonts";

	public static final String IMAGE_FOLDER = "image";

	public static final String XML_FOLDER = "xml";

	public static final String XSL_FOLDER = "xsl";

	public static final String RESOURCE_FOLDER = ".\\src\\whitefeather\\xedge\\testreports\\html-rsc\\";

	/*
	 * XML file name used in CreateXML class
	 */

	public static final String XML_FILE_NAME = "realTimeResults";

	/*
	 * XSL file name used in CreateHTML class
	 */

	public static final String DASHBOARD_XSL = "dashboard.xsl";

	/*
	 * public static final String GROUP_PAGE_XSL = "group-page.xsl";
	 * 
	 * public static final String CLASS_PAGE_XSL = "class-page.xsl";
	 */

	public static final String DASHBOARD_HTML = "dashboard";

	public static final String INDEX_HTML = "index.html";

	/*
	 * public static final String GROUP_PAGE_HTML = "bygroup.html";
	 * 
	 * public static final String CLASS_PAGE_HTML = "byclass.html";
	 */

	/*
	 * index.html static content
	 */

	public static final String INDEX_HEADER = "<!DOCTYPE HTML>" + "<html>" + "<head>" + "<title>Test Automation Report (Runt-Time): Web Version</title>"
			+ "<meta name='viewport' content='width=device-width, initial-scale=1'>"
			+ "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />"
			+ "<link href='css/bootstrap.min.css' rel='stylesheet' type='text/css' />"
			+ "<link href='css/new-style.css' rel='stylesheet' type='text/css' />"
			+ "<link href='css/font-awesome.min.css' rel='stylesheet'>"
			+ "<script src='js/jquery-1.10.2.min.js'></script>" + "<script src='js/bootstrap.min.js'></script>"
			+ "</head>";

	public static final String INDEX_BODY_PRE = "<body class='body-w-bg'>" + "<div class='container-fluid'>"
			+ "<div class='col-md-3'>" + "</div>" + "<div class='col-md-6 center hazy gap-top'>"
			+ "<div class='txt'></div>" 
			+ "<h2> <b><font size=\"6\", color=\"red\"><center>Front End Test Report for<br>Deployment "
			+HelperHand.getDate()+"</center></font></b></h2><br>"
			+ "<h3><b>ExtraaEdge Technology Solutions, Pune</b> </h3>";

	public static final String INDEX_BODY_POST = "</div>" + "<div class='col-md-3'>" + "</div>" + "</div>" + "</body>"
			+ "</html>";
}
