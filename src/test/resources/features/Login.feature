Feature: Login and Data Feature
  As an authenticated
  I want to login to application
  I want to enter data and save it

  #Test 1
  @Regression
  Scenario Outline: Test parameters
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    Then If credentials are valid, user will see profile icon on main page


    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ | "validEmail@gmail.com"      | "validPass"     |
      | https://otus.ru/ | "invalidEmail@gmail.com"    | "invalidPass"   |


  #Test 2
  @Smoke
  Scenario Outline: User can open his Private room
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select Private room from the menu
    Then Valid "https://otus.ru/learning/" is opened

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

  #Test 3
  @Regression
  Scenario Outline: User can enter Personal data in his profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    And Enter Personal data
    Then Press Save

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

  #Test 4
  @Regression
  Scenario Outline: Entered Personal data is shown in the Profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    Then Entered Personal data is shown in the Profile and is valid

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

  #Test 5
  @Regression
  Scenario Outline: User can enter Main data in his profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    And Enter Main data
    Then Press Save

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

  #Test 6
  @Regression
  Scenario Outline: Entered Main data is shown in the Profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    Then Entered Main data is shown in the Profile and is valid

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

    #Test 7
  @Regression
  Scenario Outline: User can enter Contact Information in his profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    And Enter Contact Information
    Then Press Save

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |

  #Test 8
  @Regression
  Scenario Outline: Entered Contact Information is shown in the Profile
    Given I am on the main page using URL "<url>"
    When I press Sing In button
    And I enter <login>, <pass>
    And Press on users icon and select My Profile from the menu
    Then Entered Contact Information is shown in the Profile and is valid

    Examples:
      | url              | login                       | pass            |
      | https://otus.ru/ |"validEmail@gmail.com"       | "validPass"     |


