package com.raj.parsing;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfParser {

	public static void main(String[] args) throws IOException {

		String path = System.getProperty("user.dir");
		
		//System.out.println(path);
		
		
		File file = new File(path+File.separator+"anurag_dec_21.pdf");
		InputStream is = new FileInputStream(file);
		
		PDFParser parser = new PDFParser(is);
		parser.parse();
		
		COSDocument cosdoc = parser.getDocument();
		PDDocument pddoc = new PDDocument(cosdoc);		
		
		PDFTextStripper str = new PDFTextStripper();
		String data = str.getText(pddoc);
        String lines[] =data.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            
      	  if(lines[i].contains("Payee Name")) {
      		  
      		  System.out.println("Payee Name"+""+lines[i].substring(("Payee Name").length()+1,lines[i].length()));
      	  }else if(lines[i].contains("Nickname")) {
      		  
      		  System.out.println(("Nickname")+""+lines[i].substring(("Nickname").length()+1,lines[i].length()));
      	  }else if(lines[i].contains("Credit Account No")) {
      		  
      		 System.out.println(("Credit Account No")+""+lines[i].substring(("Credit Account No").length()+1,lines[i].length()));
      	  }else if(lines[i].contains("Remarks")) {
      		System.out.println(("Remarks")+""+lines[i].substring(("Remarks").length()+1,lines[i].length()));
      	  }else if(lines[i].contains("Debit Account")) {
      		  
      		System.out.println(("Debit Account")+""+lines[i].substring(("Debit Account").length()+1,lines[i].length()));  
      	  }else if(lines[i].contains("Date")){
      		  
      		System.out.println(("Date")+""+lines[i].substring(("Date").length()+1,lines[i].length()));  
      	  }else if(lines[i].contains("Amount")) {
      		  
      		System.out.println(("Amount")+""+lines[i].substring(("Amount").length()+1,lines[i].length()));   
      	  }else if(lines[i].contains("Payment Type")) {
      		  
      		System.out.println(("Payment Type")+""+lines[i].substring(("Payment Type").length()+1,lines[i].length()));  
      	  }else if(lines[i].contains("Pay via")) {
      		  
      		System.out.println(("Pay via")+""+lines[i].substring(("Pay via").length()+1,lines[i].length()));   
      	  }
   }
      

      

	}
}
