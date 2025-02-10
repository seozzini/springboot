package com.example.demo.insa.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ReportController {

	// private final EmployeesService employeesService;

	@Autowired
	DataSource datasource;

	@GetMapping("fileDown")
	public void fileDown(HttpServletResponse response) throws IOException {
		FileInputStream fi = new FileInputStream("c:/Temp/data.txt");
		int readByte;
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.setHeader("Content-Disposition", "attachment; filename=" + "data.txt");
		while ((readByte = fi.read()) != -1) {
			response.getOutputStream().write(readByte);
		}
		fi.close();
	}

	@GetMapping("empPdf")
	public void report(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 레포트파일
		InputStream jasperStream = getClass().getResourceAsStream("/reports/emp.jasper");

		// 레포트 + 데이터(conn) => 완성
		Connection conn = datasource.getConnection();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, null, conn);
		conn.close();
		
		//pdf출력
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	@GetMapping(value= "pdfView")
	public ModelAndView pdfview() throws Exception {
		//model.setAttribute("key","value")
		return new ModelAndView("pdfView", "filename", "/reports/emp.jasper");
	}
	
	@GetMapping(value= "pdfViewDown")
	public ModelAndView pdfviewDown() throws Exception {
		return new ModelAndView("pdfViewDown", "filename", "/reports/emp.jasper");
	}

}
