package main.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



public class Main {

	public static void main(String[] args) {
		Collection<ReportVO> dataList = new ArrayList<ReportVO>();
		ReportVO report = new ReportVO();
		report.setTitulo("TITULO");
		report.setDescription("Esto es una pruebaEsto es una pruebaEsto es una pruebaEsto es una pruebaEsto es una pruebaEsto es una pruebaEsto es una pruebaEsto es una prueba");
		dataList.add(report); 
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
		Map<String,Object> parameters = new HashMap<>();
	

		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport("test.jasper", parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream("test.pdf"));
 
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
