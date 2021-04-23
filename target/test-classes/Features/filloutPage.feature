Feature: To test populating the test page

Scenario Outline: Populate web page
 Given user is on the web page
 When user populates the <firstname> and <lastname> fields
 And selects the <sex> and <years>
 And user click the submit button
 Then message is returned to the user
 
 Examples:
 |firstname|lastname|sex|years|
 |Tony|Starks|M|1|
 |Wanda|Maximoff|F|2|
 |Luke|T'Challa|M|3|
 |Steve|Rogers|M|4|
 |James|Rhodes|M|5|
 |Bruce|Banner|M|6|
 |Natasha|Romonov|F|7|

 