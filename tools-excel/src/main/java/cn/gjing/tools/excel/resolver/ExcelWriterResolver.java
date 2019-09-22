package cn.gjing.tools.excel.resolver;

import cn.gjing.tools.excel.BigTitle;
import cn.gjing.tools.excel.ExcelStyle;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Supplier;

/**
 * Excel writer resolver
 *
 * @author Gjing
 **/
public interface ExcelWriterResolver {

    /**
     * 创建Excel读解析器
     *
     * @param workbook  workbook 工作簿
     * @param response  response
     * @param header    列表头
     * @param fieldList Excel列表头字段集合
     * @param fileName  文件名
     * @return ExcelWriterResolver
     */
    ExcelWriterResolver builder(Workbook workbook, HttpServletResponse response, List<String> header, List<Field> fieldList, String fileName);

    /**
     * 写Excel
     *
     * @param excelClassList Excel对应的实体集合
     */
    void write(List<?> excelClassList);

    /**
     * 设置Excel的大标题
     *
     * @param bigTitle bigTitle
     */
    void setBigTitle(BigTitle bigTitle);

    /**
     * 设置列表头样式
     *
     * @param headerStyle excelStyle
     */
    void setHeaderStyle(Supplier<? extends ExcelStyle> headerStyle);

    /**
     * 设置大标题样式
     *
     * @param bigTitleStyle excelStyle
     */
    void setBigTitleStyle(Supplier<? extends ExcelStyle> bigTitleStyle);

    /**
     * 设置正文样式
     *
     * @param contentStyle excelStyle
     */
    void setContentStyle(Supplier<? extends ExcelStyle> contentStyle);

}
