Feature: Score for 100m
  I want set result on 100m and get my points.


  Scenario: Add a result get points
    Given I want to add my result 10 sek
    When I press add
    Then My points would be 1096