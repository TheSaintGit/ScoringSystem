package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoringStepsHepta {

    double p = 0;
    double d = 0;
    double e = 0;
    int result = 0;
    int score =0;

        @Given("In Heptathlon on the event {string} and the result is {double}")
        public void i_the_event_is_and_the_result_is(String event, Double result) {

            switch (event){
                case "200m" ->{
                    score=calculateRun(result, 4.99087,42.5,1.81);
                    System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
                }
                case "800m" ->{
                    score=calculateRun(result, 0.11193,254,1.88);
                    System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
                }
                case "100m hurdles" ->{
                    score=calculateRun(result, 9.23076,26.7 ,12.93);
                    System.out.println("The event is " + event + " and your time is " + result + " Sec and you got "+ score +" points");
                }
                case "Long jump" ->{
                    score=calculateJump(result , 0.188807, 210,1.41);
                    System.out.println("The event is " + event + " and you jumped " + result + " Centimeters and you got "+ score +" points");
                }
                case "High jump" ->{
                    score=calculateJump(result , 1.84523, 75,1.348);
                    System.out.println("The event is " + event + " and you jumped " + result + " Centimeters and you got "+ score +" points");
                }
                case "Shot put" -> {
                    score=calculateThrow(result, 56.02111, 1.5,1.05);
                    System.out.println("The event is " + event + " and you Threw " + result + " Meters and you got "+ score +" points");
                }
                case "Javelin throw" -> {
                    score=calculateThrow(result, 15.9803, 3.8,1.04);
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

        @When("I press count")
        public void i_press_sum() {
        }

        @Then("My Hepta points on the event is {int} points")
        public void my_points_on_the_event_is_points(Integer int1) {
            assertEquals(int1, score);
        }
}
