Feature: Create a scorecard
  As an officials i want to chose a number of participants and get a new scorecard with correct number of rows.


  // Scenario Outline: Start a new scorecard
  //  Given I want to add <"number"> of participants
  //  And I write a <"name"> of a particiapants
  //  When I press save my score
  //  Then My points should be 1096 in Excel

  //  Examples:
   //   | number     | result      | points     |
    //  | 1          | 10.72       | 924        |
     // | 2          | 807         | 1079       |
     // | 10         | 16.57       | 886        |
     // | 39         | 500         | 910        |
     // | 40         |

  Scenario: Start a new scorecard
    Given I want to add 1 numbers of participants
    When I press enter
    Then I will have a matrix with 1 rows and 22 columns
