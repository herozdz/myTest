package test.zoe.utils;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @Description 
 * @date 2014-3-14
 */
public class ExportOrderData {
	
public static void exportClassroom(HttpServletRequest request,HttpServletResponse response,String[] titleName,String[][] colsName,String sheetName,String fileName) throws Exception{ 
		
		response.setContentType("application/vnd.ms-excel");
		response.setCharacterEncoding("UTF-8");
		if(request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
			fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");//firefox浏览器
//			sheetName = new String(sheetName.getBytes("UTF-8"), "ISO8859-1");//firefox浏览器
		}else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){
			fileName = URLEncoder.encode(fileName, "UTF-8");//IE浏览器
//			sheetName = URLEncoder.encode(sheetName, "UTF-8");//IE浏览器
		}
//		response.addHeader("Content-Disposition", "attachment;filename="+fileName+".xls"); 
	     response.setHeader("Content-disposition", "attachment; filename="
					+ new String((fileName+".xls").getBytes("utf-8"), "ISO8859-1"));
		
		WritableWorkbook wbook = Workbook.createWorkbook(response.getOutputStream()); //建立excel文件  
		WritableSheet wsheet = wbook.createSheet(sheetName, 0); //工作表名称  
		
		//设置Excel字体  
		WritableFont wfont = new WritableFont(WritableFont.ARIAL, 16,  
		WritableFont.BOLD, false,  
		jxl.format.UnderlineStyle.NO_UNDERLINE,  
		jxl.format.Colour.BLACK);  
		WritableCellFormat titleFormat = new WritableCellFormat(wfont);  
		//String[] title = { "教室名", "容 量", "类 型", "其他说明" };  
		
		//设置Excel表头  
		for(int i = 0; i < titleName.length; i++){
			Label excelTitle = new Label(i, 0, titleName[i], titleFormat);
			wsheet.addCell(excelTitle);
		}
		for(int r = 0; r < colsName.length; r++){
			for(int c = 0; c < colsName[r].length; c++){
				Label content = new Label(c, r+1,colsName[r][c]);
				wsheet.addCell(content);
			}
		}
		wbook.write(); //写入文件  
		wbook.close();
	}  

}
