package dealWithExcell;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;

public class ExcelOperater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		jxl.Workbook readwb = null;
		try{
			 //构建Workbook对象, 只读Workbook对象   
            //直接从本地文件创建Workbook   
			InputStream instream = new FileInputStream("C:/Users/cyu088/Desktop/fuck.xls");
			readwb = Workbook.getWorkbook(instream);
			 //Sheet的下标是从0开始   
            //获取第一张Sheet表   
			Sheet readsheet = readwb.getSheet(0);
			//获取Sheet表中所包含的总列数
			int rsColumns = readsheet.getColumns();
			//获取Sheet表中所包含的总行数
			int rsRows = readsheet.getRows();
			//获取指定单元格的对象引用   
			for(int i=0;i<rsRows;i++){
				for(int j=0;j<rsColumns;j++){
					Cell cell = readsheet.getCell(j,i);
					System.out.print(cell.getContents()+" ");
				}
			System.out.println();
			}
			 //利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄   
			jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File("C:/Users/cyu088/Desktop/fuckU.xls"),readwb);
			jxl.write.WritableSheet ws = wwb.getSheet(0);//读取第一张工作表 
			jxl.write.WritableCell wc = ws.getWritableCell(0, 0); //获得第一个单元格对象 
			if(wc.getType()==CellType.LABEL){//判断单元格的类型, 做出相应的转化 ,能够对其进行修改的Label类型
				Label labelwc = new Label(0, 0, "hehe");
				ws.addCell(labelwc);
				Label l = (Label)wc;
				l.setString("新姓名");
			}
			wwb.write();
			wwb.close();	
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			readwb.close();
		}
	
	}

}
