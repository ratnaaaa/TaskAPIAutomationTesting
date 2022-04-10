Feature: Reqresin

  Scenario: Success Get users
    When user send GET users request to reqresin
    Then response status code should be 200
    And response structure should match json schema "user.Json"

  Scenario: Success Post User
    When user send POST login request to reqresin
    Then response status code should be 200
    And response structure should match json schema "Post-User.Json"

  Scenario: Unsuccessfull Login
    When user send POST UnSuccesslogin request to reqresin
    Then response status code should be 400
    And response structure should match json schema "ussuccesLogin.Json"

  Scenario: Success PUT update
    When user send PUT Update request to reqresin
    Then response status code should be 200
    And response structure should match json schema "Put-Update.Json"

    Scenario: Delete User
      When user send Delete request to reqresin
      Then response status code should be 204