package test.zoe.exportExcel;

import test.zoe.utils.ExportOrderData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2017/8/10
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class testExport {
    public static void main(String[] args) throws Exception {
        HttpServletResponse res = null;//测试代码
        HttpServletRequest req = null;//测试代码
        /**构建表头*/
        String[] titleName = new String[]{"主商品编号","主商品名称","供应商","审核时间","审核结果"};
        String[][] columnName;
        List<String> list = new ArrayList<String>();
        list.add("hi");
        list.add("hello");
        list.add("你好！");
        columnName = new String[list.size() + 1][titleName.length];

        for (int r = 0; r < list.size(); r++) {//按行写excel
            columnName[r][0] = list.get(r);
            columnName[r][1] = list.get(r);
            columnName[r][2] = list.get(r);
        }
        String sheetName = "导出结果";
        String fileName = "导出结果-";
        ExportOrderData.exportClassroom(req,res,titleName,columnName,sheetName,fileName);
    }

}
