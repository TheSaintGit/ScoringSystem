package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoringStepsDeca {
    double p = 0;
    double a = 0;
    double b = 0;
    double c = 0;
    double d = 0;
    double e = 0;
    int result = 0;
    int score =0;


    @Given("I want to add my result {double} sek")
    public void i_want_to_add_my_result_sek(double time) {
        p = time;
        System.out.println("your time in 100m are " + p + " sek");
    }

    @When("I press add")
    public void i_press_add() {
        a = 25.4347;                  //  (a(b-p)^c)
        b = 18;
        c = 1.81;
        d = b - p;
        e = Math.pow(d, c);
        result = (int) (a * e);

    }

    @Then("My points would be {int}")
    public void my_points_would_be(Integer int1) {
        assertEquals(int1, result);
        System.out.println("your score was " + result + " point´s");

    }

    @Given("I the event is {string} and the result is {double}")
    public void i_the_event_is_and_the_result_is(String event, Double result) {

        switch (event){
            case "100m" ->{
                    score=calculateRun(result, 25.4347,18,1.81);
                System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
            }
            case "400m" ->{
                score=calculateRun(result, 1.53775,82,1.81);
                System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
            }
            case "110m hurdles" ->{
                score=calculateRun(result, 5.74352,28.5 ,1.92);
                System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
            }
            case "1500m" ->{
                score=calculateRun(result, 0.03768,480,204.87);
                System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
            }
            case "Long jump" ->{
                score=calculateJump(result , 0.14354, 220,1.4);
                System.out.println("The event is " + event + " and you jumped " + result + " Centimeters and you got "+ score +" points");
            }
            case "High jump" ->{
                score=calculateJump(result , 0.8465, 75,1.42);
                System.out.println("The event is " + event + " and you jumped " + result + " Centimeters and you got "+ score +" points");
            }
            case "Pole vault" ->{
                score=calculateJump(result , 0.2797, 100,1.35);
                System.out.println("The event is " + event + " and you jumped " + result + " Centimeters and you got "+ score +" points");
            }
            case "Shot put" -> {
                score=calculateThrow(result, 51.39, 1.5,1.05);
                System.out.println("The event is " + event + " and you Threw " + result + " Meters and you got "+ score +" points");
            }
            case "Discus throw" -> {
                score=calculateThrow(result, 12.91, 4,41.51);
                System.out.println("The event is " + event + " and you Threw " + result + " Meters and you got "+ score +" points");
            }
            case "Javelin throw" -> {
                score=calculateThrow(result, 10.14, 7,1.08);
                System.out.println("The event is " + event + " and you Threw " + result + " Meters and you got "+ score +" points");
            }
        }

    }

    private int calculateJump(double result,double a,double b, double c) {             //  (a(p-b)^c)
        p = result;
        d = p-b;
        e = Math.pow(d, c)*a;
        return (int) this.e;
    }

    private int calculateThrow(double result,double a,double b, double c) {        //  (a(p-b)^c)
        p = result;
        d = p - b;
        e = Math.pow(d, c)*a;
        return (int) this.e;
    }

    private int calculateRun(double result,double a,double b, double c) {            //  (a(b-p)^c)
        p = result;
        d = b - p;
        e = Math.pow(d, c)*a;
        return (int) this.e;
    }

    @When("I press sum")
    public void i_press_sum() {
    }

    @Then("My points on the event is {int} points")
    public void my_points_on_the_event_is_points(Integer int1) {
        assertEquals(int1, score);
    }
}

