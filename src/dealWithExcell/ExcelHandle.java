package dealWithExcell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.Date;


import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;

import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WritableCell; 
/**2种方法：Workbook，就可以通过它来访问Excel Sheet（术语：工作表）：
从输入流创建Workbook读取excel数据表   
InputStream is = new FileInputStream(sourcefile);   
jxl.Workbook workbook = Workbook.getWorkbook(is);   
直接从本地文件（.xls）创建Workbook   
Workbook workbook = Workbook.getWorkbook(new File(excelfile));   
*/
public class ExcelHandle {
	public ExcelHandle(){
		
	}
	/***读取Excel*/
	public static void readExcel(String filePath){
	
			InputStream is = null;
			try {
				is = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Workbook rwb = null;
			try {
				rwb = Workbook.getWorkbook(is);
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//这里有两种方法获取sheet表:名字和下标（从0开始）
			Sheet st = rwb.getSheet(0);
			Cell c00 = st.getCell(0,0);//获得第一行第一列单元的值 
			String strc00 = c00.getContents();//通用的获取cell值的方式,返回字符串
			System.out.println(strc00);
			if(c00.getType()==CellType.LABEL){//class:L  获得cell具体类型值的方式
				LabelCell labelc00 = (LabelCell) c00;
				strc00 = labelc00. getString();
			}
			System.out.println(strc00);//输出,两张方法都可以
			int rsColumns = st.getColumns();
			int rsRows = st.getRows();
			for(int i=0;i<rsRows;i++){
				for(int j=0;j<rsColumns;j++){
					Cell cell = st.getCell(j, i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
			rwb.close();
		
	}
	/**输出Excel*/  
	public static void writeExcel(OutputStream os){
		try{
			 /** 只能通过API提供的 工厂方法来创建Workbook，而不能使用WritableWorkbook的构造函数，因为类WritableWorkbook的构造函数为 protected类型：方法一：直接从目标文件中读取 WritableWorkbook wwb = Workbook.createWorkbook(new File(targetfile));方法 二：如下实例所示 将WritableWorkbook直接写入到输出流*/  
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			//创建Excel工作表 指定名称和位置
			WritableSheet ws = wwb.createSheet("Test Sheet1", 0);
			/**************往工作表中添加数据*****************/  
			//1.添加Label对象 
			Label label = new Label(0,0,"test"); 
			ws.addCell(label);
			//添加带有字型Formatting对象
			WritableFont wf = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			Label labelcf = new Label(1,0,"this is a label test",wcf);
			ws.addCell(labelcf);
			//2.添加Number对象
			Number labelN = new Number(0,1,3.14159);
			ws.addCell(labelN);
			//3.添加Boolean对象
			jxl.write.Boolean labelB = new jxl.write.Boolean(0,2,true);
			ws.addCell(labelB);
			jxl.write.Boolean labelB1 = new jxl.write.Boolean(1,2,false);
			ws.addCell(labelB1);
			//4.添加DateTime对象
			jxl.write.DateTime labelDT = new jxl.write.DateTime(0,3,new Date());
			ws.addCell(labelDT);
			//5.添加带有formatting的DateFormat对象
			DateFormat df = new DateFormat("dd MM yyyy hh:mm:ss");
			WritableCellFormat wcfDF = new WritableCellFormat(df);
			DateTime laberDTF = new DateTime(1,3,new Date(),wcfDF);
			ws.addCell(laberDTF);
			//6.添加图片对象,jxl只支持png格式图片
			File image = new File("C:/Users/cyu088/Desktop/1.jpg");
			WritableImage wimage = new WritableImage(0, 4, 6, 7, image);
			ws.addImage(wimage);
			//7.写入工作表
			wwb.write();
			
			wwb.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/** 将file1拷贝后,进行修改并创建输出对象file2  
	* 单元格原有的格式化修饰不能去掉，但仍可将新的单元格修饰加上去，  
	 * 以使单元格的内容以不同的形式表现  */  

	public static void modifyExcel(File file1,File file2){
		try{
			Workbook rwb = Workbook.getWorkbook(file1);
			
			WritableWorkbook wwb = Workbook.createWorkbook(file2,rwb);
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLUE);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			WritableSheet ws = wwb.getSheet(0);
			WritableCell wc = ws.getWritableCell(0, 0);
			//判断单元格的类型,做出相应的转换
			if(wc.getType()==CellType.LABEL){
				Label labelCf = new Label(0, 0,"new fuck", wcfFC);
				ws.addCell(labelCf);
			}
			wwb.write();
			wwb.close();
			rwb.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelHandle.readExcel("C:/Users/cyu088/Desktop/fuck3.xls");
		File filewrite = new File("C:/Users/cyu088/Desktop/fuck4.xls");
		ExcelHandle.modifyExcel(filewrite,new File("C:/Users/cyu088/Desktop/fuck5.xls"));
		try {
			filewrite.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(filewrite);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExcelHandle.writeExcel(os);
	}
		
}
