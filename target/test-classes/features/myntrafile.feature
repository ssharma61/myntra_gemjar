@Myntra1
Feature: Testing myntra website

  Scenario: Validate Myntra page open
    Given Myntra icon and Profile icon is displayed
    Then Main elements are available on screen
    And Validate if Search tab is available

  Scenario: Check Singup or Login button functionality
    Given I have clicked on Signup or login button under profile
    Then Validate the UI is redirected to login or signup page
    And User should not able to proceed with invalid mobile number
    Then User to validate the termsofuse and privacypolicy link

  Scenario: Test Home page Search functionality
    Then click on search text and provide "saree" and validate the url
    Then Validate navigated page opened correctly
    Then Validate data under all filter tags
    Then validate the navigated page elements

  Scenario: Check Women clothing button and validate the functionalities
    Given Hover on "Women" and click on "Dresses"
    Then Validate the URL on navigated women jacket page
    Then Validate the images are visible on screen
    Then Check brand button search functionality
    Then Go to the end of page and validate the number of pages and available buttons

  Scenario: Test Add to Bag functionality
    Given Click on image and validate if it opens in new window
    Then Validate the URL and text on the window
#    And Validate a click on ADD TO BAG, it should ask for size
#    Then Select the size "M" and click on ADD TO BAG and validate item added to bag
#    And Validate checkout page
#    Then Validate Remove and wishlist functionality


