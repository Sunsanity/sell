package com.imooc.config;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * Created by hasee on 2017/9/24.
 */
public class iText {

    public static void main(String[] args) throws Exception
    {
        //创建Document对象
        Document doc=new Document(PageSize.A4,0,0,50,0);

        //获得PdfWriter实例，将文档放到输出流上
        PdfWriter.getInstance(doc, new FileOutputStream("e:\\业务处理.pdf"));

        //字体设置
        /*
         * 由于itext不支持中文，所以需要进行字体的设置，我这里让itext调用windows系统的中文字体，
         * 找到文件后，打开属性，将文件名及所在路径作为字体名即可。
         */
        //创建BaseFont对象，指明字体，编码方式,是否嵌入
        BaseFont bf=BaseFont.createFont("C:\\Windows\\Fonts\\simkai.ttf", BaseFont.IDENTITY_H, false);
        //创建Font对象，将基础字体对象，字体大小，字体风格
        Font font=new Font(bf,13,Font.NORMAL);
        Font font1=new Font(bf,15,Font.BOLD);


        /*
         * 添加7列的表格
         */

        //创建PdfTable对象
        PdfPTable table=new PdfPTable(6);

        //设置各列的列宽
        table.setTotalWidth(new float[]{100,100,100,100,100,100});


        //添加表格内容
        table.addCell(getPDFCell("流程名称：",font));
        PdfPCell cell=new PdfPCell();
        cell=mergeCol("公出申请", font, 2);
        table.addCell(cell);
        table.addCell(getPDFCell("任务号：",font));
        cell=mergeCol("183101170613002", font, 2);
        table.addCell(cell);


        table.addCell(getPDFCell("标题：",font));
        cell=mergeCol("信息技术部-吴春阳- 4天(2017-06-21 10:22:26--2017-06-24 18:22:38)", font, 4);
        table.addCell(cell);
        table.addCell("");

        table.addCell(getPDFCell("申请人：",font));
        cell=mergeCol("吴春阳", font, 2);
        table.addCell(cell);
        table.addCell(getPDFCell("申请部门：",font));
        cell=mergeCol("信息技术部", font, 2);
        table.addCell(cell);

        table.addCell(getPDFCell("优先级：",font));
        cell=mergeCol("高", font, 2);
        table.addCell(cell);
        table.addCell(getPDFCell("申请时间：",font));
        cell=mergeCol("2017-06-13 10:36:21", font, 2);
        table.addCell(cell);


        table.addCell(getPDFCell("任务描述：",font));
        cell=mergeCol("根据中国保险行业协会下发《关于举办保险公司信息化建设系列培训（第二期）—— 保险公司信息化系统建设专题培训班的通知》的要求，公司委派信\n" +
                "息技术部同召和我参加本次培训，培训地点：北京，培训时间：2017.06.22-2017.06.24，请领导批准！", font, 5);
        table.addCell(cell);


        cell=mergeRow("附件名称：", font, 4);
        table.addCell(cell);
        cell=mergeCol("关于举办保险公司信息化建设系列培训（第二期）--保险公司信息化系统建设专题培训班的通知(1).pdf", font, 5);
        table.addCell(cell);
        cell=mergeCol("华保收〔2017〕 243号—关于举办保险公司信息化建设系列培训（第二期）--保险公司信息化系统建设专题培训班的\n" +
                "通知.PDF", font, 5);
        table.addCell(cell);
        cell=mergeCol("华保收〔2017〕 243号—附件1：保险公司信息化建设系列培训（第二期）课程表.docx", font, 5);
        table.addCell(cell);
        cell=mergeCol("华保收〔2017〕 243号—附件2：报到通知.doc", font, 5);
        table.addCell(cell);

        table.addCell("");
        table.addCell(getPDFCell("审批人",font));
        table.addCell(getPDFCell("审批时间",font));
        table.addCell(getPDFCell("审批结果",font));
        cell=mergeCol("审批意见", font, 2);
        table.addCell(cell);

        table.addCell(getPDFCell("申请部门负责人",font));
        table.addCell(getPDFCell("胡同召",font));
        table.addCell(getPDFCell("2017-06-14 11:36:46",font));
        table.addCell(getPDFCell("同意",font));
        cell=mergeCol("同意。", font, 2);
        table.addCell(cell);

        table.addCell(getPDFCell("申请部门分管总",font));
        table.addCell(getPDFCell("何万军 ",font));
        table.addCell(getPDFCell("2017-06-14 11:59:22",font));
        table.addCell(getPDFCell("同意",font));
        cell=mergeCol("同意。", font, 2);
        table.addCell(cell);

        table.addCell(getPDFCell("人力资源部门考勤审\n" +
                "核",font));
        table.addCell(getPDFCell("张小琳",font));
        table.addCell(getPDFCell("2017-06-15 11:50:42",font));
        table.addCell(getPDFCell("同意",font));
        cell=mergeCol("已审核。", font, 2);
        table.addCell(cell);


        //文档写入内容

        doc.open();
        Paragraph title=new Paragraph("业务处理\n\n\n",font1);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        doc.add(title);
        doc.add(table);
        doc.close();



    }

    //合并行的静态函数
    public static PdfPCell mergeRow(String str,Font font,int i) {

        //创建单元格对象，将内容及字体传入
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));
        //设置单元格内容居中
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //将该单元格所在列包括该单元格在内的i行单元格合并为一个单元格
        cell.setRowspan(i);

        return cell;
    }

    //合并列的静态函数
    public static PdfPCell mergeCol(String str,Font font,int i) {

        PdfPCell cell=new PdfPCell(new Paragraph(str,font));
        cell.setMinimumHeight(25);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //将该单元格所在行包括该单元格在内的i列单元格合并为一个单元格
        cell.setColspan(i);

        return cell;
    }

    //获取指定内容与字体的单元格
    public static PdfPCell getPDFCell(String string, Font font)
    {
        //创建单元格对象，将内容与字体放入段落中作为单元格内容
        PdfPCell cell=new PdfPCell(new Paragraph(string,font));

        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        //设置最小单元格高度
        cell.setMinimumHeight(25);
        return cell;
    }
}
