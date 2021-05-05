Feature: Score for 100m
  I want set result on 100m and get my points.
  Feature:  Add Athlets

  Scenario: Add and save names
    Given I have entered number 3 of athlets
    Given I have entered nr 1 athlets name "Carolina"
    Given I have entered nr 2 athlets name "Johnny"
    Given I have entered nr 3 athlets name "Belle"
    When i done
    Then the athlets should be shown