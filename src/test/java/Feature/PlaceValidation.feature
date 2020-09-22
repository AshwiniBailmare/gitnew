Feature: Validating Place API;
@AddPlaceAPI @Regression
Scenario Outline: Verify if Place is being  succesfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When User calls "addPlaceAPI" with "Post" http request
Then the API call got succes with status code 201
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id created maps to "<name>" with "getPlaceAPI"


Examples:

|    name        |language|address|
|ashwini bailmare|english |nagpur maharshtra|
|sandhya bailmare|marathi|ramtek,maharashtra|

@DeletePlaceAPI @Regression
Scenario: verify if delete place functionality is worked
Given DeletePlace Payload
When User calls "deletePlaceAPI" with "Post" http request
Then the API call got succes with status code 200
And "status" in response body is "OK"