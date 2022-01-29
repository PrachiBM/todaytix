@test
Feature: Automate Booking

  Scenario: 1. User Journey for booking tickets
    Given User in on application home page
    When User selects the New York city
    Then User searches The Phantom of the Opera show
    Then the show page is displayed
    Then User clicks on Get Tickets
    Then User selects a date and shows are displayed
    And User selects a show and selectSection is displayed
    And User selects a section and user form and two payment options displayed
    And User enters form data with FirstName LastName ab@gmail.com Password PersonName aa@gmail.com 7404742045 values
