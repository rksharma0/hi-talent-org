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
        //System.out.println(lines[0]);
      for (int i = 8; i < lines.length; i++) {
           System.out.println(lines[i]);
        }


	}
}
