package Utility;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	public static ExtentReports report;

	public static ExtentReports getreportInstance() {

		if (report == null) {
			Date date = new Date();
			String reportName = date.toString().replace(" ", "-").replace(":", "_")+".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					"C:\\java\\channelproject\\extentreports\\" +reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			report.setSystemInfo("OS", "Windows11");
			report.setSystemInfo("Enviournment", "Production");
			report.setSystemInfo("BuildNumber", "9.11.94");
			report.setSystemInfo("Browser", "chrome");
			htmlReporter.config().setDocumentTitle("UI Automation");
			htmlReporter.config().setReportName("UI Testing Report");
		}
		return report;
	}
}
