Feature: Open Excel
  I want to open excel to add some data.


  Scenario: Add a result to Excel
    Given I want to add my result 1096 points
    When I press save my score
    Then My points should be 1096 in Excel

