Feature: Score for different events heptathlon
  I want pica an event and set result on that to get my points.

  Scenario Outline: Heptathlon add a event and result get points
    Given In Heptathlon on the event "<event>" and the result is <result>
    When I press count
    Then My Hepta points on the event is <points> points
    Examples:
      | event              | result      | points     |
      | 200m               | 23.73       | 1007       |
      | Long jump          | 661         | 1043       |
      | Shot put           | 13.15       | 737        |
