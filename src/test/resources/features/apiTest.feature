@test
Feature: Automate Inventory Service

  Scenario Outline: 1. valid response - 200 OK
    Given I call Inventory service with quantity <quantity> and from date <fromDate> and <toDate> and query parameter 5feb92a5-86a7-4f86-aaa0-9b90d63cbfee
    And use header key affiliateId and header value londontheatredd
    Then I get response 200
    And the minimum price is not Null
    Examples:
      | quantity | fromDate | toDate   |
      | 0        | 20220204 | 20220212 |
      | 1        | 20220205 | 20220213 |
      | 2        | 20220206 | 20220214 |
      | 6        | 20220207 | 20220215 |

  Scenario Outline: 2. Not Found - 404
    Given I call Inventory service with quantity <quantity> and from date <fromDate> and <toDate> and query parameter 5feb92a5-86a7-4f86-aaa0-9b90d63cbfee
    Then I get response 404
    And Error message is Product not found
    Examples:
      | quantity | fromDate | toDate   |
      | 0        | 20220204 | 20220212 |

  Scenario Outline: 3. Invalid request - 400
    Given I call Inventory service with quantity <quantity> and from date <fromDate> and <toDate> and query parameter 5feb92a5-86a7-4f86-aaa0-9b90d63cbfee
    And use header key affiliateId and header value londontheatredd
    Then I get response 400
    Examples:
      | quantity | fromDate | toDate   |
      | 3        | 20220102 | 20220212 |
