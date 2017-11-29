package whitefeather.xedge.datadoctors;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelDataOperationHandlers 
{
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	public static Font font;
	public static CellStyle _passStyle, _failStyle,_headerStyle,_alignStyle,_skipStyle;
	public static Iterator<Row> rowIterator;
	public static Iterator<Cell> cellIterator;
	public static HashMap<Integer, String> readExcelMap  = new HashMap<Integer, String>();;
	public static HashMap<Integer, String> readDomainDetailsMap  = new HashMap<Integer, String>();;
	public static  List<String>  getBrowser;
	public static FileInputStream inputFileStream;
	public static int rowNum, cellNum,skipCellNumber,numberOfColumns,domainDetailsCounter,numberOfClients;
	public static  FileOutputStream outputFileStream;
	static HashMap<Integer, String> readTestCasesMap;
	public static LinkedHashMap<Integer, Object[]> writeTestResultsMap;
	public static int counter;
	
	public static void setDataStyle()
	{
		_alignStyle = workbook.createCellStyle();
		_alignStyle.setAlignment(HorizontalAlignment.CENTER);
		_passStyle = workbook.createCellStyle();
		_passStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		_passStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		_passStyle.setAlignment(HorizontalAlignment.CENTER);
		
		_failStyle = workbook.createCellStyle();
		_failStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		_failStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		_failStyle.setAlignment(HorizontalAlignment.CENTER);
		
		_headerStyle = workbook.createCellStyle();
		_headerStyle.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
		_headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    
	    font = workbook.createFont();
        font.setColor(IndexedColors.WHITE.getIndex());
        _passStyle.setFont(font);
	}
	
	

}

