Feature: Loginfeature

  This feature deals with the login functionality of the application.

   Scenario: Log in with correct username and password
     Given I navigate to the Login page
     And I enter the following for Login
       |email       |password |
       |hiba.darwish+admin@edayna.com |Test1234@ |
     And I click login button
     And I click on Sign Out button
     Then I should see the Login page Again
