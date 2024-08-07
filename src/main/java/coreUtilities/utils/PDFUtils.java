package coreUtilities.utils;

import java.io.IOException;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

public class PDFUtils {
	
	PDFUtil pdfUtil;
	
	public PDFUtils() {
		pdfUtil = new PDFUtil();
	}
	
	/**
	 * This method is useful to get the total number of pages present in the given pdf file
	 * @param file - The complete file path including the file name
	 * @return {@link Integer} - returns total number of pages
	 * @throws IOException
	 */
	public int getPdfPageCount(String file) throws IOException {
		return pdfUtil.getPageCount(file);
	}
	
	/**
	 * This method is useful to get the text from all the pages in the given pdf file
	 * @param file - The complete file path including the file name
	 * @return {@link String} - returns the complete text from all the pages
	 * @throws IOException
	 */
	public String getText(String file) throws IOException {
		return pdfUtil.getText(file);
	}
	
	/**
	 * This method is useful to get the text from all the pages in the given pdf file
	 * @param file - The complete file path including the file name
	 * @param startPage - The page number from where the text should be extracted till end of the pages
	 * @return {@link String} - returns the complete text from all the pages
	 * @throws IOException
	 */
	public String getText(String file, int startPage) throws IOException {
		return pdfUtil.getText(file, startPage);
	}
	
	/**
	 * This method is useful to get the text from all the pages in the given pdf file
	 * @param file - The complete file path including the file name
	 * @param startPage - The page number from where the text should be extracted
	 * @param endPage - The page number till what the text should be extracted
	 * @return {@link String} - returns the complete text from all the pages
	 * @throws IOException
	 */
	public String getText(String file, int startPage, int endPage) throws IOException {
		return pdfUtil.getText(file, startPage, endPage);
	}
	
	/**
	 * This method is useful to compare 2 pdf files w:r:t the text present in both the files
	 * @param isVisualModeRequired - This will help to compare both the PDFs in visual mode
	 * @param isDifferenceRequired - This will help if user requires the differences present while comparing the PDfs
	 * @param file1 - The complete file path including the file name
	 * @param file2 - The complete file path including the file name
	 * @param differenceStorePath - When any difference present in the both the PDFs, it'll get collected and store in this location
	 * @return {@link Boolean}
	 * @throws IOException
	 */
	public boolean compare(boolean isVisualModeRequired, boolean isDifferenceRequired, String file1, String file2, String differenceStorePath) throws IOException {
		if(isVisualModeRequired) {
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		}
		if(isDifferenceRequired) {
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfUtil.highlightPdfDifference(true);
			pdfUtil.setImageDestinationPath(differenceStorePath);
		}
		return pdfUtil.compare(file1, file2);
	}
	
	/**
	 * This method is useful to compare 2 pdf files for the given page range. If we want to compare a particular page the start page number and end page number
	 * @param isVisualModeRequired - This will help to compare both the PDFs in visual mode
	 * @param isDifferenceRequired - This will help if user requires the differences present while comparing the PDfs
	 * @param file1 - The complete file path including the file name
	 * @param file2 - The complete file path including the file name
	 * @param startPage - Indicates the start page from where the comparison should start
	 * @param endPage - Indicates the end page where the comparison should stop
	 * @param differenceStorePath - When any difference present in the both the PDFs, it'll get collected and store in this location
	 * @return {@link Boolean}
	 * @throws IOException
	 */
	public boolean compare(boolean isVisualModeRequired, boolean isDifferenceRequired, String file1, String file2, 
							int startPage, int endPage, String differenceStorePath) throws IOException {
		if(isVisualModeRequired) {
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
		}
		if(isDifferenceRequired) {
			pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfUtil.highlightPdfDifference(true);
			pdfUtil.setImageDestinationPath(differenceStorePath);
		}
		return pdfUtil.compare(file1, file2, startPage, endPage);
	}
}





















/* public Map<String, String> readExcelPOI(String excelFilePath, String sheetName) throws FilloException
    {
        HashMap<String, String> dataMap = new HashMap<>();
 
        try (FileInputStream fis = new FileInputStream(excelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
 
            // Get the first sheet
            //Sheet sheet = workbook.getSheetAt(0);
            Sheet sheet = workbook.getSheet(sheetName);
 
            // Iterate through each row in the sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
 
                // Get the first and second cell from each row
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);
 
                // Convert cells to string and put them in the HashMap
                String key = getCellValueAsString(keyCell);
                String value = getCellValueAsString(valueCell);
 
                dataMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return dataMap;
    }
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
 
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
    
     */