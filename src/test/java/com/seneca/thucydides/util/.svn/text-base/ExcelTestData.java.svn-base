package com.seneca.thucydides.util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author satheesh.guduru
 *
 */
public class ExcelTestData {

    /**
     * 
     */
    private transient Collection<Object[]> data = null;

    private boolean skipFirstRow=true;
    private String sheetName=null;
    private int reqIdcelNo=200000; 
    private String reqIdValue;
    private int testTypeCelNo=200000;
    private int testResultCelNo=200000;
    private String testTypeValue;
    private String testResult;
    private int testDesccelNo=200000;
    private String testDescValue;
    private TestOutcomeDetails testOutcomeDetails; 
    private int rowNo=1;
    private String rowName;
    private Map <String,TestOutcomeDetails> testTagOutcomes=new HashMap<String,TestOutcomeDetails>();
    public ExcelTestData(String fileName,Class sheetName) throws IOException {
    	System.out.println("File name-->"+fileName);
    	this.sheetName=sheetName.getSimpleName();
    	System.out.println("Sheet Name-->"+this.sheetName);
    	  InputStream spreadsheet = new FileInputStream(fileName);
        this.data = loadFromSpreadsheet(spreadsheet);
    }

    public ExcelTestData(Class sheetName) throws IOException {
    	this.sheetName=sheetName.getSimpleName();
    	System.out.println("Sheet Name-->"+this.sheetName);
    	  InputStream spreadsheet = new FileInputStream("Testdata.xls");
        this.data = loadFromSpreadsheet(spreadsheet);
    }
    /**
     * @return
     */
    public Collection<Object[]> getData() {
    	
    //	System.out.println("******************************data**********************************--->"+data);
    	//System.out.println("testTypeValue--->"+testTypeValue);
    	 if(testTypeValue.toLowerCase().contains("automation")){
    		// System.out.println("testTypeValue in if --->"+testTypeValue);
    	 testOutcomeDetails=new TestOutcomeDetails();
    	 testOutcomeDetails.setRequirementId(reqIdValue);
         testOutcomeDetails.setTestType(testTypeValue);
         testOutcomeDetails.setTestClassName(sheetName);
         testTagOutcomes.put(testOutcomeDetails.getTestClassName(), testOutcomeDetails);
         }
    	 CommonUtil.setTestOutcomeDetails(testTagOutcomes);
        return data;
    }

    /**
     * @param excelFile
     * @return
     * @throws IOException
     */
    private Collection<Object[]> loadFromSpreadsheet(final InputStream excelFile)
            throws IOException {
    	try{
        HSSFWorkbook workbook = new HSSFWorkbook(excelFile);

        data = new ArrayList<Object[]>();
        
        Sheet sheet = workbook.getSheet(sheetName);

        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<Object[]>();
        List<Object> rowData = new ArrayList<Object>();

        for (Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
            	if(skipFirstRow){
            		 
            		 for (int column = 0; column < numberOfColumns; column++) {
                         Cell cell = row.getCell(column);
                         Object obj=objectFrom(workbook, cell);
                        // System.out.println("obj.toString()--->"+obj.toString());
                         if(obj.toString().equals("Req_Id")){
                         reqIdcelNo=column;   
                         }if(obj.toString().equals("Test_Type")){
                        	 testTypeCelNo=column;
                         }
                         if(obj.toString().equals("Test_Description")){
                        	 testDesccelNo=column;
                         }
                         if(obj.toString().equals("Test_Result")){
                        	 testResultCelNo=column;
                         }
            		 }
                   skipFirstRow=false;
                   //System.out.println("reqIdcelNo--->"+reqIdcelNo);
                  // System.out.println("testTypeCelNo--->"+testTypeCelNo);
                   //System.out.println("testDesccelNo--->"+testDesccelNo);
            		continue;
            		
            	}
            
                rowData.clear();
                for (int column = 0; column < numberOfColumns; column++) {
                	Cell  cell;
                	if(column!=reqIdcelNo && column!=testTypeCelNo && column!=testDesccelNo && column!=testResultCelNo ){
                		if(getStringValueFrom(workbook,row.getCell(testTypeCelNo)).toLowerCase().contains("manual")){
               		    }else{
                		cell = row.getCell(column);
                		rowData.add(getStringValueFrom(workbook, cell));
               		   }
                	}
                	
                	if(reqIdcelNo==column){
                		 cell = row.getCell(column);
                		reqIdValue = getStringValueFrom(workbook, cell);

                	}
                	if(testTypeCelNo==column){
                		 cell = row.getCell(column);
                		testTypeValue=getStringValueFrom(workbook, cell);
                		
                	}
                		if(testDesccelNo==column){
                			 cell = row.getCell(column);
                     		testDescValue=getStringValueFrom(workbook, cell);;
                		}
                			if(testResultCelNo==column){
                				 cell = row.getCell(column);
                				testResult=getStringValueFrom(workbook, cell);;
                        		}	
                }
                if(testTypeValue.toLowerCase().contains("manual")){
                	rowName="[Row "+rowNo+"]";
                //	System.out.println("rowName-->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--->"+rowName);
           		    testOutcomeDetails=new TestOutcomeDetails();
                    testOutcomeDetails.setRequirementId(reqIdValue);
                    testOutcomeDetails.setTestType(testTypeValue);
                    testOutcomeDetails.setTestClassName(sheetName);
                    testOutcomeDetails.setTestRowNo(rowName);
                    testOutcomeDetails.setTestResult(testResult);
                  // System.out.println("--testDescValue--->"+testDescValue);
                    if(testDescValue!=null){
                    testOutcomeDetails.setTestDescription(testDescValue);
                    }
                    testTagOutcomes.put(testOutcomeDetails.getTestRowNo(),testOutcomeDetails);
                    rowNo++;
                  }
                
                rows.add(rowData.toArray());
            }
          
        }
      return rows;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return data;  
    }

    /**
     * @param row
     * @return
     */
    private boolean isEmpty(final Row row) {
        Cell firstCell = row.getCell(0);
        boolean rowIsEmpty = (firstCell == null)
                || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
        return rowIsEmpty;
    }

    /**
     * Count the number of columns, using the number of non-empty cells in the
     * first row.
     */
    /**
     * @param sheet
     * @return
     */
    private int countNonEmptyColumns(final Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }

    /**
     * @param cells
     * @return
     */
    private int firstEmptyCellPosition(final Row cells) {
        int columnCount = 0;
        for (Cell cell : cells) {
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    /**
     * @param workbook
     * @param cell
     * @return
     */
    private Object objectFrom(final HSSFWorkbook workbook, final Cell cell) {
        Object cellValue = null;

        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cellValue = getNumericCellValue(cell);
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType()  ==Cell.CELL_TYPE_FORMULA) {
            cellValue = evaluateCellFormula(workbook, cell);
        }

        return cellValue;
    
    }
    /**
     * @param workbook
     * @param cell
     * @return
     */
    private String getStringValueFrom(final HSSFWorkbook workbook, final Cell cell) {
        Object cellValue = null;

        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cellValue = getNumericCellValue(cell);
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType()  ==Cell.CELL_TYPE_FORMULA) {
            cellValue = evaluateCellFormula(workbook, cell);
        }

        return cellValue.toString();
    
    }

    /**
     * @param cell
     * @return
     */
    private Object getNumericCellValue(final Cell cell) {
        Object cellValue;
        if (DateUtil.isCellDateFormatted(cell)) {
            cellValue = new Date(cell.getDateCellValue().getTime());
        } else {
            cellValue = cell.getNumericCellValue();
        }
        return cellValue;
    }

    /**
     * @param workbook
     * @param cell
     * @return
     */
    private Object evaluateCellFormula(final HSSFWorkbook workbook, final Cell cell) {
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);
        Object result = null;
        
        if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            result = cellValue.getBooleanValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            result = cellValue.getNumberValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
            result = cellValue.getStringValue();   
        }
        
        return result;
    }
}