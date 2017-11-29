package whitefeather.xedge.datadoctors;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Set;


public class ReportGenerator extends ExcelDataOperationHandlers
{	
	public static void generateTestReportInExcelFormat() throws IOException
	{
		Set<Integer> keySet = writeTestResultsMap.keySet();
		rowNum=0;
		
		ExcelDataOperationHandlers.setDataStyle();
		for(Integer key:keySet)
		{
			row = sheet.createRow(rowNum++);
			Object [] readExcelDataKeys = writeTestResultsMap.get(key);
			cellNum=0;
			
			for(Object obj : readExcelDataKeys)
			{
				cell = row.createCell(cellNum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
					if(cell.getStringCellValue().equals("Pass"))
						cell.setCellStyle(_passStyle);
					else if(cell.getStringCellValue().equals("Fail"))
						cell.setCellStyle(_failStyle);
					else if(cell.getStringCellValue().equals("Skipped"))
						cell.setCellStyle(_skipStyle);
				else if(obj instanceof Date)
					cell.setCellValue((Date)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
					if(obj instanceof Integer)
						cell.setCellStyle(_alignStyle);
			}
			
			for(int i=0;i<row.getPhysicalNumberOfCells();i++)
			{
				sheet.getRow(0).getCell(i).setCellStyle(_headerStyle);
				sheet.autoSizeColumn(i);
			}
			
			try {
//				outputFileStream = new FileOutputStream(new File(Constants.TESTREPORT_CONTAINER));
				workbook.write(outputFileStream);
				outputFileStream.close();
//				workbook.removeSheetAt(0);
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
//	public static void main(String[] args) {
//		
//	}

}
