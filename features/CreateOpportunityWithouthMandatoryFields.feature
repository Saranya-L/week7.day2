Feature: Create Opportunity without mandatory fields
@feature
Scenario Outline: Try to Create Opportunity without mandatory fields in salesforce
When click sales option from App Launcher
Then click on Opportunity tab button
Then click new for new opportunity
And Enter Opportunity name in the text box as <opportunity>
And Choose close date as Tomorrow
And Click on Save button
Then Verify the Alert message displayed
Examples:
|opportunity|
|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|

@smoke
Scenario Outline: Try to Create Opportunity without mandatory fields in salesforce
When click sales option from App Launcher
Then click on Opportunity tab button
Then click new for new opportunity
And Choose close date as Tomorrow
And Click on Save button
Then Verify the Alert message displayed

@sanity
Scenario Outline: Try to Create Opportunity without mandatory fields in salesforce
When click sales option from App Launcher
Then click on Opportunity tab button
Then click new for new opportunity
And Select Stage as Need Analysis option
And Click on Save button
Then Verify the Alert message displayed

@regression
Scenario Outline: Try to Create Opportunity without mandatory fields in salesforce
When click sales option from App Launcher
Then click on Opportunity tab button
Then click new for new opportunity
And Enter Opportunity name in the text box as <opportunity>
And Click on Save button
Then Verify the Alert message displayed
Examples:
|opportunity|
|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|
