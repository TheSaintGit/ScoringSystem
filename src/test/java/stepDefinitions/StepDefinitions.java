package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
public class StepDefinitions {
    double p=0;
    double a=0;
    double b=0;
    double c=0;
    double d=0;
    double e=0;
    int result=0;


        @Given("I want to add my result {double} sek")
        public void i_want_to_add_my_result_sek(double time) {
            p= time;
            System.out.println("your time in 100m are " + p + " sek");
    }

        @When("I press add")
        public void i_press_add() {
            a=25.4347;                  //  (a(b-p)^c)
            b=18;
            c=1.81;
            d=b-p;
            e= Math.pow(d,c);
            result= (int) (a*e);

    }

        @Then("My points would be {int}")
        public void my_points_would_be(Integer int1) {
            assertEquals(String.valueOf(int1), String.valueOf(result));
            System.out.println("your score was " + result +" point´s");

    }
    }

