Feature: UI Ebay General Operations
  This feature file contains general ebay tests


  Scenario: Verify that shopping cart is empty
    Given I am on the ebay main page
    And I accept the cookies
    When I click on shopping cart icon
    Then I should don´t have any items in my cart
    And I click on start shopping button
    Then Verify that I am back on the ebay main page


  Scenario Outline: Finding some products
    Given I am on the ebay main page
    And I accept the cookies
    When I search for a "<PRODUCT_NAME>"
    Then The page title should start with "<PRODUCT_NAME>"

    Examples:
      | Description | PRODUCT_NAME  |
      | Case cheese | cheese        |
      | Case book   | book          |
      | Case shirt  | shirt         |


  Scenario Outline: Verify Sign in and register page
    Given I am on the ebay main page
    And I accept the cookies
    When I click on "<PAGE_NAME>" link
    Then Verify that I am on "<PAGE_NAME>" page

    Examples:
      | Description   | PAGE_NAME |
      | Case Sign in  | Sign in   |
      | Case register | register  |

######################################################################
# IMPORTANT: 2 SCENARIOS BELOW ARE JUST EXAMPLES AND ARE NOR AUTOMATED
######################################################################

  Scenario Outline: Search and Add some product to the shopping cart
    Given I am on the ebay main page
    And I accept the cookies
    When I search for a "<PRODUCT_NAME>"
    Then The page title should start with "<PRODUCT_NAME>"
    And  I Click on the first product in the results
    And I Click on Buy Add to cart Button
    Then Verify that product is in the shopping cart

    Examples:
      | Description | PRODUCT_NAME  |
      | Case cheese | cheese        |
      | Case book   | book          |
      | Case shirt  | shirt         |


  Scenario Outline: Sign in to Ebay
    Given I am on the ebay main page
    And I accept the cookies
    When I click on "Sign in" link
    Then Verify that I am on "Sign in" page
    And I enter "<EMAIL_OR_USERNAME>" and click on Continue button
    And I enter "<PASSWORD>" and click on Sign In button
    Then Verify that I am Signed in on Ebay

    Examples:
      | Description   | EMAIL_OR_USERNAME | PASSWORD       |
      | Case email    | some@email.com    | some_password1 |
      | Case username | some_username     | some_password2 |
