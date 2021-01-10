Feature: Find information on otus.ru

  #Test 9
  @Regression
  Scenario:  Verify the date when starts next Java QA Engineer course
    When Open "https://otus.ru/"
    And Testing button is pressed on the main page
    Then Verify date for the next Java QA Engineer course

  #Test 10
  @Regression
  Scenario:  Find all professors that have Java QA Engineer on main page
    When Open "https://otus.ru/"
    And Our Teachers section is selected from the Teachers menu
    Then Find all teachers with Java QA Engineer on main page
