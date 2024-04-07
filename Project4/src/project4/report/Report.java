package project4.report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;

public abstract class Report {
	PDDocument document;
	PDPage page;
	protected PDPageContentStream contentStream;
	String filename;
	File file;
	float currOffsetX;
	float currOffsetY;
	public Report(String filename, String title) {
		try {
			Files.deleteIfExists(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.file = new File(filename);
		this.filename = filename;
		
		document = new PDDocument();
		page = new PDPage();
		document.addPage(page);
		try {
			//setting title
			contentStream = new PDPageContentStream(document, page);
			PDType1Font titleFont = new PDType1Font(FontName.TIMES_BOLD);
			int marginTop = 30;
			int fontSize = 16;
			float titleWidth = titleFont.getStringWidth(title) / 1000 * fontSize;
			float titleHeight = titleFont.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
			contentStream.beginText();
			contentStream.setFont(new PDType1Font(FontName.TIMES_BOLD), 16);
			contentStream.newLineAtOffset((page.getMediaBox().getWidth() - titleWidth) / 2, page.getMediaBox().getHeight() - marginTop - titleHeight);
			contentStream.showText(title);
			contentStream.setFont(new PDType1Font(FontName.TIMES_ROMAN), 12);
			contentStream.newLineAtOffset(((page.getMediaBox().getWidth() - titleWidth) / -2) + 25, -1.5f*16);
			currOffsetX = 25;
			currOffsetY = marginTop + titleHeight + 1.5f*16;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void open() {
		try {
			Desktop.getDesktop().open(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void closeAndSave() {
		try {
			contentStream.endText();
			contentStream.close();
			document.save(filename);
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void addLine(String text) {
		try {
			PDType1Font font = new PDType1Font(FontName.TIMES_ROMAN);
			int fontSize = 12;
			float fontHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
			if(currOffsetY + fontHeight > page.getMediaBox().getHeight()) {
				contentStream.endText();
				contentStream.close();
				page = new PDPage();
				document.addPage(page);
				contentStream = new PDPageContentStream(document, page);
				contentStream.beginText();
				contentStream.newLineAtOffset(25, page.getMediaBox().getHeight() - 30);
				currOffsetY = 30;
			}
			contentStream.setFont(font, fontSize);
			contentStream.showText(text);
			contentStream.newLineAtOffset(0, -1.5f * 12);
			currOffsetY += fontHeight *1.33;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void addLineWithTitle(String title, String text) {
		try {
			PDType1Font font = new PDType1Font(FontName.TIMES_BOLD);
			int fontSize = 12;
			float fontHeight = font.getFontDescriptor().getFontBoundingBox().getHeight() / 1000 * fontSize;
			if(currOffsetY + fontHeight > page.getMediaBox().getHeight()) {
				contentStream.endText();
				contentStream.close();
				page = new PDPage();
				document.addPage(page);
				contentStream = new PDPageContentStream(document, page);
				contentStream.beginText();
				contentStream.newLineAtOffset(25, page.getMediaBox().getHeight() - 30);
				currOffsetY = 30;
			}
			contentStream.setFont(font, fontSize);
			contentStream.showText(title);
			font = new PDType1Font(FontName.TIMES_ROMAN);
			contentStream.newLineAtOffset(125, 0);
			contentStream.setFont(font, fontSize);
			contentStream.showText(text);
			contentStream.newLineAtOffset(-125, -1.5f * 12);
			currOffsetY += fontHeight *1.33;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
