package com.itheima.form;

import java.awt.Label;
import java.io.File;
import java.util.List;

import com.itheima.domain.Cust;
import com.itheima.service.CustServiceImpl;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class baobiao {

    public  void m() {
        try {
            WritableWorkbook wwb = null;
             
               // 创建可写入的Excel工作簿
               String fileName = "D://book.xls";
               File file=new File(fileName);
               if (!file.exists()) {
                   file.createNewFile();
               }
               //以fileName为文件名来创建一个Workbook
               wwb = Workbook.createWorkbook(file);

               // 创建工作表
               WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
               
               //查询数据库中所有的数据
               CustServiceImpl custServiceImpl = new CustServiceImpl();
               List<Cust> list= custServiceImpl.getAllCust();
               //要插入到的Excel表格的行号，默认从0开始
               jxl.write.Label labelId= new jxl.write.Label(0, 0, "产品id(productid)");//表示第
               jxl.write.Label labelparam= new jxl.write.Label(1, 0, "静测值(parame1)");
               jxl.write.Label labelparamp= new jxl.write.Label(2, 0, "静测值标志位(parame1p)");
               jxl.write.Label labelparam2= new jxl.write.Label(3, 0, "阀口泄露值(parame2)");
               jxl.write.Label labelparam2p= new jxl.write.Label(4, 0, "阀口泄露标志位(parame2)");
               jxl.write.Label labeltime= new jxl.write.Label(5, 0, "生产时间(time)");
               ws.addCell(labelId);
               ws.addCell(labelparam);
               ws.addCell(labelparamp);
               ws.addCell(labelparam2);
               ws.addCell(labelparam2p);
               ws.addCell(labeltime);
               for (int i = 0; i < list.size(); i++) {
            	   jxl.write.Label labelproductid= new jxl.write.Label(0, i+1, list.get(i).getProductid()+"");
            	   jxl.write.Label labelparam1_i= new jxl.write.Label(1, i+1, list.get(i).getParame1());
            	   jxl.write.Label labelparam1p_i= new jxl.write.Label(2, i+1, list.get(i).getParame1p());
            	   jxl.write.Label labelparam2_i= new jxl.write.Label(3, i+1, list.get(i).getParame2());
            	   jxl.write.Label labelparam2p_i= new jxl.write.Label(4, i+1, list.get(i).getParame2p());
            	   jxl.write.Label labeltime_i= new jxl.write.Label(5, i+1, list.get(i).getTime().toString());
                   ws.addCell(labelproductid);
                   ws.addCell(labelparam1_i);
                   ws.addCell(labelparam1p_i);
                   ws.addCell(labelparam2_i);
                   ws.addCell(labelparam2p_i);
                   ws.addCell(labeltime_i);
               }
             
              //写进文档
               wwb.write();
              // 关闭Excel工作簿对象
               wwb.close();
             
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}