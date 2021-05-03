package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ExcelSteps {


    @Given("I want to add my result {int} points")
    public void i_want_to_add_my_result_points(Integer int1) throws IOException {
        //Process p=Runtime.getRuntime().exec ( System.getenv( "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE" ));
        //FileInputStream file = new FileInputStream(new File("C:\\Users\\nv95j\\IdeaProjects\\ScoringSystem\\Excel\\"));
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("resultat");
        System.out.println(int1);

        Object[][] bookData = {
                {"100m sprint", "Kenny Kula", int1 + " points"}

        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }
        try (FileOutputStream outputStream = new FileOutputStream("resultat.xlsx")) {
            workbook.write(outputStream);
        }


    }


    @When("I press save my score")
    public void i_press_save_my_score() {

    }

    @Then("My points should be {int} in Excel")
    public void my_points_should_be_in_excel(Integer int1) {

            try
            {
                FileInputStream file = new FileInputStream(new File("resultat.xlsx"));

                //Create Workbook instance holding reference to .xlsx file
                XSSFWorkbook workbook = new XSSFWorkbook(file);

                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

                //Get first/desired sheet from the workbook
                XSSFSheet sheet = workbook.getSheetAt(0);



                //Iterate through each rows one by one
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext())
                {
                    Row row = rowIterator.next();
                    //For each row, iterate through all the columns
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext())
                    {
                        Cell cell = cellIterator.next();
                        //Check the cell type after eveluating formulae
                        //If it is formula cell, it will be evaluated otherwise no change will happen

                        System.out.print(cell.getStringCellValue() + " ");
                        // System.out.print(cell.getNumericCellValue() + "tt");
                        /*
                        switch (evaluator.evaluateInCell(cell).getCellType())
                        {
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.print(cell.getNumericCellValue() + "tt");
                                break;
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue() + "tt");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                //Not again
                                break;
                        }


                         */

                    }
                    System.out.println("");
                }
                file.close();

            }

            catch (Exception e)
            {
              e.printStackTrace();
            }

      // assertEquals(String.valueOf(int1), String.valueOf(value));
        }

}
