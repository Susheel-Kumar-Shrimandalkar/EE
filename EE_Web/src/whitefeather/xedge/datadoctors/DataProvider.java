package whitefeather.xedge.datadoctors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import whitefeather.xedge.appconfig.Constants;


public class DataProvider extends ExcelDataOperationHandlers
{	
	public static void createXLFile() throws FileNotFoundException
	{
		if(Constants.TESTDATA_CONTAINER.endsWith(".xlsx"))//Refactor this code to DataWriter class later
		{
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Test");
		}
		else if(Constants.TESTDATA_CONTAINER.endsWith(".xls"))
		{
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("Test");
		}
	}
	
	public static void setExcelFileType(String sheetName) throws FileNotFoundException
	{
		inputFileStream = new FileInputStream(Constants.TESTDATA_CONTAINER);//Refactor code later to take FileName as separate argument
		try {
			if(Constants.TESTDATA_CONTAINER.endsWith(".xlsx"))//Refactor this code to DataWriter class later
			{
				workbook = new XSSFWorkbook(inputFileStream);
				sheet = workbook.getSheet(sheetName);
				row = (XSSFRow) row;
				cell = (XSSFCell) cell;
				setDataStyle();
				
			}
			else if(Constants.TESTDATA_CONTAINER.endsWith(".xls"))
			{
				workbook = new HSSFWorkbook(inputFileStream);
				sheet = workbook.getSheet(sheetName);
				row = (HSSFRow) row;
				cell = (HSSFCell) cell;
				setDataStyle();
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	
	
	public static HashMap<Integer, String> readExcelData() throws IOException
//	public static HashMap<String, String> readExcelData() throws IOException
	{
//	setExcelFileType("Test Cases");

		setExcelFileType("db_names");
		try {
			rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext())
			{
				row = rowIterator.next();
				cellIterator = row.cellIterator();
				numberOfColumns = row.getPhysicalNumberOfCells();
				while(cellIterator.hasNext())
				{
					cell = cellIterator.next();
					
					if(cell.getCellTypeEnum().equals(CellType.STRING))
					{
						readExcelMap.put(counter++,cell.getStringCellValue());
//						readExcelMap.put(cell.getStringCellValue(),cell.getStringCellValue());
					}
					/*else if(cell.getCellTypeEnum().equals(CellType.NUMERIC))
					{
						readExcelMap.put(counter++, Double.toString(cell.getNumericCellValue()));
					}
					else if(cell.getCellTypeEnum()==null)
					{
						break;
					}*/
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return readExcelMap;
	}
	
	public static List<String> getWebBrowser() throws IOException
	{		
		getBrowser = new ArrayList<String>();
		setExcelFileType("Browsers");
			for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) 
			{
				  row = sheet.getRow(rowIndex);
				  if (row != null)
				  {
				    for (int colIndex = 0; colIndex < row.getPhysicalNumberOfCells(); colIndex++) 
				    {
				      if (colIndex == 0) //read specific column. Here we are reading 1st column only (Browsers) column
				      {
				        cell = row.getCell(colIndex);
				        if (cell != null)
				        {
				        	getBrowser.add(cell.getStringCellValue());
				          break;
				        }
				      }
				    }
				  }
			 }
		return getBrowser;
	}
	
	public static HashMap<Integer, String> getDomainDetails() throws FileNotFoundException
	{
		domainDetailsCounter=0;
		setExcelFileType("Domain Details");
		
		try {
			rowIterator = sheet.rowIterator();
			while(rowIterator.hasNext())
			{
				row = rowIterator.next();
				cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					cell = cellIterator.next();
					
					if(cell.getCellTypeEnum().equals(CellType.STRING))
					{
						readDomainDetailsMap.put(domainDetailsCounter++, cell.getStringCellValue());
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		numberOfClients = sheet.getPhysicalNumberOfRows()-1;
		return readDomainDetailsMap;
	}
	
	public static String testReportFileNameGenerator() throws FileNotFoundException
	{
		int domainName = 4;
		String testReportFileName = getDomainDetails().get(domainName)+"_"+".xlsx";
		return testReportFileName;
	}
	
	public static String sheetNameGenerator(int domain) throws FileNotFoundException
	{
		Collection<String> _sheetName = getDomainDetails().values();
		ArrayList<String> listOfValues = new ArrayList<String>(_sheetName);
		String sheetName  =listOfValues.get(domain).toString();
		return sheetName;
	}
	
	
	public static boolean checkSkip() throws IOException
	{
		
		Collection<String> skipValues = readExcelData().values();
		boolean xlFlag = false;
		for(String  value : skipValues)
		{
			if(value.equals("Skip"))
				xlFlag=true;
			else
				xlFlag=false;
				break;
		}
		return xlFlag;
	}
	
	/*public static boolean checkSkipValue(int _skipCell) throws IOException
	{
		_skipCell=skipCellNumber;
		boolean xlFlag = false;
		for(Map.Entry<Integer, String> skipCell : readExcelData().entrySet())
		{
			Integer key = skipCell.getKey();
			String value = skipCell.getValue();
			if(key.equals(_skipCell) && value.equalsIgnoreCase("Yes"))
			{
				xlFlag=true;
				break;
			}
			else if (key.equals(_skipCell) && value.equalsIgnoreCase("Skip"))
			{
				xlFlag=false;
				break;
			}
		}
		skipCellNumber+=4;
		return xlFlag;
	}*/
	
	public static int getNumberOfColumnsInSourceFile()
	{
		System.out.println(numberOfColumns);
		return numberOfColumns;
	}
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(readExcelData());
		
		System.out.println(readExcelData().get(1));
		
//		checkSkipValue(skipCellNumber);
//		checkSkipValue(skipCellNumber);
//		checkSkipValue(skipCellNumber);
//		checkSkipValue(skipCellNumber);
		

//		System.out.println(getWebBrowser());
//		System.out.println(getWebBrowser().get(2));
//		System.out.println(getDomainDetails());
//		System.out.println(numberOfClients);
//		System.out.println(getDomainDetails().get(4));
//		System.out.println(sheetNameGenerator(4));
		
	}
	
}

