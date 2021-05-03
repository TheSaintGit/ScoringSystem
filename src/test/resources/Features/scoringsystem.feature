Feature: Score for 100m
  I want set result on 100m and get my points.


  Scenario: Add a result get points
    Given I want to add my result 10 sek
    When I press add
    Then My points would be 1096

 Scenario Outline: Add a event and result get points
    Given I the event is "<event>" and the result is <result>
    When I press sum
    Then My points on the event is <points> points
   Examples:
     | event              | result      | points     |
     | 100m               | 10.72       | 924        |
     | Long jump          | 807         | 1079       |
     | Shot put           | 16.57       | 886        |
     | Pole vault         | 500         | 910        |
