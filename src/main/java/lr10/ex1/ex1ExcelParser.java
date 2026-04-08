package lr10.ex1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ex1ExcelParser {
    private static final String FILE_PATH = "src/main/java/lr10/ex1/example1.xlsx";
    private static final String SHEET_NAME = "Товары";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                parseExcel(scanner);
                break; // выходим, если всё прошло успешно
            } catch (IOException e) {
                System.err.println("Ошибка ввода/вывода: " + e.getMessage());
                System.out.println("Возможные причины:");
                System.out.println("- Файл не существует по пути: " + FILE_PATH);
                System.out.println("- Файл повреждён или имеет неправильный формат");
                System.out.println("- Файл открыт в другой программе");

                if (!retry(scanner)) return;
            } catch (IllegalArgumentException e) {
                System.err.println("Ошибка данных: " + e.getMessage());
                System.out.println("Возможные причины:");
                System.out.println("- Лист с именем '" + SHEET_NAME + "' не найден");
                System.out.println("- Файл не является .xlsx");

                if (!retry(scanner)) return;
            } catch (Exception e) {
                System.err.println("Неизвестная ошибка: " + e.getMessage());
                e.printStackTrace();

                if (!retry(scanner)) return;
            }
        }
    }

    private static void parseExcel(Scanner scanner) throws IOException {
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;

        try {
            fis = new FileInputStream(FILE_PATH);
            workbook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                throw new IllegalArgumentException("Лист с именем '" + SHEET_NAME + "' не найден.");
            }

            System.out.println("\n=== Данные с листа '" + SHEET_NAME + "' ===\n");

            boolean hasData = false;
            for (Row row : sheet) {
                if (row != null) {
                    hasData = true;
                    for (Cell cell : row) {
                        String value = formatCellValue(cell);
                        System.out.print(value + "\t");
                    }
                    System.out.println();
                }
            }

            if (!hasData) {
                System.out.println("Лист пуст.");
            }

        } finally {
            if (workbook != null) {
                workbook.close();
            }
            if (fis != null) {
                fis.close();
            }
        }
    }

    private static String formatCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return "ФОРМУЛА: " + cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "НЕИЗВЕСТНЫЙ ТИП";
        }
    }

    private static boolean retry(Scanner scanner) {
        System.out.print("\nХотите попробовать снова? (да/нет): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("да") || input.equals("yes") || input.equals("y");
    }
}