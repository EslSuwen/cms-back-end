package com.cqjtu.cms.util;

import com.cqjtu.cms.constant.Constants;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

/**
 * @Auther: hepengrui
 * @Date: 2018/12/17 17:39
 * @Description:
 */
@Slf4j
public class ExcelUtils {

    /**
     * 第一索引默认值
     */
    private final static int FIRST_INDEX = 0;

    /**
     * 第二索引默认值
     */
    private final static int SECOND_INDEX = 1;

    /**
     * 默认行高
     */
    private final static short DEFAULT_ROW_HEIGHT = (short) (21.5 * 20);


    public static <T> List<T> readExcel(InputStream inputStream, String fileName, Class<T> rowObjectClass, List<String> fieldNames) {
        return readExcel(inputStream, fileName, rowObjectClass, FIRST_INDEX, fieldNames, SECOND_INDEX, FIRST_INDEX);
    }

    public static <T> List<T> readExcel(InputStream inputStream, String fileName, Class<T> rowObjectClass, int sheetIndex, List<String> fieldNames, int startRowIndex, int startCellIndex) {
        if (inputStream == null || rowObjectClass == null || CollectionUtils.isEmpty(fieldNames)) {
            log.info("required params is null.");
            return null;
        }
        Workbook workbook = parse2Workbook(inputStream, fileName);
        if (workbook == null) {
            log.warn("excel file read error");
            return null;
        }
        return readExcel(workbook, rowObjectClass, sheetIndex, fieldNames, startRowIndex, startCellIndex);
    }

    /**
     * 读取excel文件
     *
     * @param workbook       excel文件
     * @param rowObjectClass 实体对象class
     * @param sheetIndex     sheet索引
     * @param fieldNames     字段名称
     * @param startRowIndex  行索引
     * @param startCellIndex 列索引
     * @param <T>
     * @return
     */
    public static <T> List<T> readExcel(Workbook workbook, Class<T> rowObjectClass, int sheetIndex, List<String> fieldNames, int startRowIndex, int startCellIndex) {
        if (workbook == null || rowObjectClass == null || CollectionUtils.isEmpty(fieldNames)) {
            log.info("required params is null.");
            return null;
        }
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        if (sheet == null) {
            return null;
        }
        return parseSheetToObejct(sheet, rowObjectClass, fieldNames, startRowIndex, startCellIndex);
    }

    public static Workbook parse2Workbook(InputStream inputStream, String fileName) {
        if (inputStream == null) {
            log.info("required params is null.");
            return null;
        }

        Workbook workbook = null;
        try {
            if (fileName.endsWith(Constants.XLS_SUFFIX)) {
                workbook = new HSSFWorkbook(inputStream);
            }
            if (fileName.endsWith(Constants.XLSX_SUFFIX)) {
                workbook = new XSSFWorkbook(inputStream);
            }

        } catch (IOException e) {
            log.error("parse excel file error");
        }
        return workbook;
    }


    /**
     * 转换sheet为实体列表
     *
     * @param sheet
     * @param rowObjectClass 实体对象class
     * @param fieldNames     字段列表
     * @param startRowIndex  开始行索引
     * @param startCellIndex 开始列索引
     * @param <T>
     * @return
     */
    public static <T> List<T> parseSheetToObejct(Sheet sheet, Class<T> rowObjectClass, List<String> fieldNames, int startRowIndex, int startCellIndex) {
        if (sheet == null || rowObjectClass == null || CollectionUtils.isEmpty(fieldNames)) {
            log.info("required params is null.");
            return null;
        }
        List<T> rowObjectList = Lists.newArrayList();
        /**
         * 循环解析sheet的每一行
         */
        for (int j = startRowIndex; j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (blankRow(row)) {
                continue;
            }
            T rowObject = parseRow2Object(rowObjectClass, fieldNames, row, startCellIndex);
            if (rowObject != null) {
                rowObjectList.add(rowObject);
            }
        }
        return rowObjectList;
    }

    /**
     * excel行解析为对象
     *
     * @param rowObjectClass
     * @param fieldNames
     * @param row
     * @param startCellIndex
     * @param <T>
     * @return
     */
    public static <T> T parseRow2Object(Class<T> rowObjectClass, List<String> fieldNames, Row row, int startCellIndex) {
        if (row == null || rowObjectClass == null || CollectionUtils.isEmpty(fieldNames)) {
            log.info("required params is null.");
            return null;
        }

        T rowObject = BeanUtils.instantiateClass(rowObjectClass);
        for (int k = 0; k < fieldNames.size(); k++) {
            String fieldName = fieldNames.get(k);
            String cellValue = cellVal(row, k + startCellIndex);
            if (StringUtils.isEmpty(cellValue) || StringUtils.isEmpty(fieldName)) {
                continue;
            }
            setProperty(rowObjectClass, rowObject, fieldName, cellValue);
        }
        return rowObject;
    }

    /**
     * 属性设置器
     *
     * @param clazz
     * @param obj
     * @param fieldName
     * @param value
     * @param <T>
     */
    private static <T> void setProperty(Class<T> clazz, T obj, String fieldName, String value) {
        PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(clazz, fieldName);
        Method writeMethod = pd.getWriteMethod();
        //日期转换器
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                Date result = null;
                if (value instanceof String) {
                    String dateStr = (String) value;
                    result = DateUtils.parse(dateStr);
                }
                return result;
            }
        }, Date.class);
        try {
            writeMethod.invoke(obj, ConvertUtils.convert(value, pd.getPropertyType()));
        } catch (Exception e) {
            log.error("failed to set the propertyName method,the propertyName is:{},the value is:{},the obj is {}", fieldName, value, obj, e);
        }
    }

    /**
     * 判断一行是否为空行
     *
     * @param row
     * @return
     */
    public static boolean blankRow(Row row) {
        if (row == null) {
            return true;
        }
        boolean isBlank = true;
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            if (!blankCell(row, i)) {
                isBlank = false;
                break;
            }
        }
        return isBlank;
    }


    /**
     * 判断是否空行
     *
     * @param row
     * @param index
     * @return
     */
    private static boolean blankCell(Row row, int index) {
        String val = cellVal(row, index);
        return StringUtils.isBlank(val);
    }

    /**
     * 获取指定单元格的值
     *
     * @param row
     * @param index
     * @return
     */
    private static String cellVal(Row row, int index) {
        if (row == null) {
            return null;
        }
        Cell cell = row.getCell(index);
        String value = null;
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    int style = cell.getCellStyle().getDataFormat();
                    switch (style) {
                        case 14:
                        case 176:
                        case 177:
                        case 178:
                        case 179:
                        case 180:
                        case 181:
                        case 182:
                        case 183:
                        case 184:
                        case 185:
                        case 186:
                        case 187:
                        case 188:
                        case 189:
                        case 190:
                            Date date = cell.getDateCellValue();
                            value = DateUtils.formatDate(date);
                            break;
                        default:
                            Object inputValue;
                            double doubleVal = cell.getNumericCellValue();
                            long longVal = Math.round(doubleVal);
                            if (Double.parseDouble(longVal + ".0") == doubleVal) {
                                inputValue = longVal;
                            } else {
                                inputValue = doubleVal;
                            }
                            value = String.valueOf(inputValue);
                            break;
                    }
                    break;
                case BOOLEAN:
                    value = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    value = String.valueOf(cell.getCellFormula());
                    break;
                case BLANK:
                    break;
                case ERROR:
                    break;
                default:
                    break;
            }
        }

        return value != null ? value.trim() : null;
    }

    public static <T> Workbook export2Excel(Class<T> rowObjectClass, List<T> rowObjectList, String sheetName, List<String> fieldNames, List<String> headers) {
        return export2Excel(new XSSFWorkbook(), rowObjectClass, rowObjectList, sheetName, fieldNames, headers, SECOND_INDEX, FIRST_INDEX, null, null);
    }

    public static <T> Workbook export2Excel(Class<T> rowObjectClass, List<T> rowObjectList, String sheetName, List<String> fieldNames, List<String> headers, int startRowIndex, int startCellIndex,
                                            CellStyle headerCellStyle, CellStyle bodyCellStyle) {
        return export2Excel(new XSSFWorkbook(), rowObjectClass, rowObjectList, sheetName, fieldNames, headers, startRowIndex, startCellIndex, headerCellStyle, bodyCellStyle);
    }


    /**
     * 导出数据到excel
     *
     * @param wb
     * @param rowObjectClass  实体class
     * @param rowObjectList   实体列表
     * @param sheetName       sheet名称
     * @param fieldNames      字段名称列表
     * @param headers         表头列表
     * @param startRowIndex   开始行索引
     * @param startCellIndex  开始列索引
     * @param headerCellStyle 表头样式
     * @param bodyCellStyle   表体样式
     * @param <T>
     * @return
     */
    public static <T> Workbook export2Excel(Workbook wb, Class<T> rowObjectClass, List<T> rowObjectList, String sheetName, List<String> fieldNames, List<String> headers, int startRowIndex, int startCellIndex,
                                            CellStyle headerCellStyle, CellStyle bodyCellStyle) {
        if (wb == null || rowObjectClass == null || CollectionUtils.isEmpty(fieldNames) || CollectionUtils.isEmpty(headers) || !StringUtils.isBlank(sheetName)) {
            log.info("required params is null.");
            return null;
        }
        Sheet sheet = wb.createSheet(sheetName);
        sheet.setDefaultRowHeight(DEFAULT_ROW_HEIGHT);
        /**
         * 生成表头 表头默认为第一行
         */
        Row headerRow = sheet.createRow(FIRST_INDEX);
        headerCellStyle = headerCellStyle == null ? getDefaultHeaderCellStyle(wb) : headerCellStyle;
        int i = startCellIndex;
        for (String header : headers) {
            Cell cell = headerRow.createCell(i++);
            cell.setCellValue(header);
            cell.setCellStyle(headerCellStyle);
        }

        /**
         * 生成表体
         */
        bodyCellStyle = bodyCellStyle == null ? getDefaultBodyCellStyle(wb) : bodyCellStyle;
        int j = startRowIndex;
        for (T rowObject : rowObjectList) {
            Row bodyRow = sheet.createRow(j++);
            int c = startCellIndex;
            for (String fieldName : fieldNames) {
                Cell cell = bodyRow.createCell(c++);
                Object value = getProperty(rowObjectClass, rowObject, fieldName);
                //todo 所有列先暂时置为String类型
                cell.setCellValue(value == null ? "" : value.toString());
                cell.setCellStyle(bodyCellStyle);
            }
        }
        autoColumnWidth(sheet, headers.size());
        return wb;
    }

    /**
     * 自动调整列宽
     *
     * @param sheet
     * @param maxColumn
     */
    private static void autoColumnWidth(Sheet sheet, int maxColumn) {
        for (int i = 0; i < maxColumn; i++) {
            sheet.autoSizeColumn(i);
        }
        //获取当前列的宽度，然后对比本列的长度，取最大值
        for (int columnIndex = 0; columnIndex < maxColumn; columnIndex++) {
            int columnWidth = sheet.getColumnWidth(columnIndex) / 256;
            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(columnIndex) != null) {
                    Cell currentCell = currentRow.getCell(columnIndex);
                    int length = 0;
                    try {
                        length = currentCell.toString().getBytes("UTF-8").length;
                    } catch (UnsupportedEncodingException e) {
                        length = currentCell.toString().getBytes().length;
                    }
                    if (columnWidth < length + 1) {
                        columnWidth = length + 1;
                    }
                }
            }
            sheet.setColumnWidth(columnIndex, columnWidth * 256);
        }
    }

    private static <T> Object getProperty(Class<T> rowObjectClass, T obj, String fieldName) {
        Object value = null;
        try {
            PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(rowObjectClass, fieldName);
            Method readMethod = pd.getReadMethod();
            value = readMethod.invoke(obj);
        } catch (Exception e) {
            log.error("fail to get the fieldName method,the fieldName is:{},this obj is :{}", fieldName, obj, e);
        }
        return value;
    }


    /**
     * 默认表头样式
     *
     * @param wb
     * @return
     */
    private static CellStyle getDefaultHeaderCellStyle(Workbook wb) {
        CellStyle headerCellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontName("等线");
        font.setFontHeightInPoints((short) 11);
        font.setColor(Font.COLOR_NORMAL);
        headerCellStyle.setFont(font);

        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setAlignment(HorizontalAlignment.LEFT);
        headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return headerCellStyle;
    }

    /**
     * 默认表体样式
     *
     * @param wb
     * @return
     */
    private static CellStyle getDefaultBodyCellStyle(Workbook wb) {
        CellStyle bodyCellStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("等线");
        font.setFontHeightInPoints((short) 11);
        font.setColor(Font.COLOR_NORMAL);
        bodyCellStyle.setFont(font);
        bodyCellStyle.setBorderLeft(BorderStyle.THIN);
        bodyCellStyle.setBorderBottom(BorderStyle.THIN);
        bodyCellStyle.setBorderTop(BorderStyle.THIN);
        bodyCellStyle.setAlignment(HorizontalAlignment.LEFT);
        bodyCellStyle.setBorderRight(BorderStyle.THIN);
        bodyCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        return bodyCellStyle;
    }

}
