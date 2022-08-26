Feature: Create New Opportunity
@feature
Scenario Outline: To create new opportunity in salesforce
When click Sales from App Launcher
Then click on Opportunity tab
When click on New button
And Enter Opportunity name as 'Salesforce Automation by Saranya L'
Then Get the text and Store it and print
And Choose close date as Today
And Select Stage as Need Analysis
When Click Save
Then Verify Oppurtunity Name as 'Salesforce Automation by Saranya L'

@smoke
Scenario Outline: To create new opportunity in salesforce
When click Sales from App Launcher
Then click on Opportunity tab
When click on New button
And Enter Opportunity name as 'Salesforce Automation by Saranya L'
Then Get the text and Store it
And Choose close date as Today
And Select Stage as Need Analysis
When Click Save
Then Verify Oppurtunity Name as 'Salesforce Automation by Saranya L'

@sanity
Scenario Outline: To create new opportunity in salesforce
When click Sales from App Launcher
Then click on Opportunity tab
When click on New button
And Enter opportunity name as <opportunityname>
Then Get the text and Store it
And Choose close date as Today
And Select Stage as Need Analysis
When Click Save
Then Verify opportunity name as <opportunitynameverify>
Examples:
|opportunityname|opportunitynameverify|
|Salesforce Automation by Saranya L|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|Salesforce Automation by Viji S|

@regression
Scenario Outline: To create new opportunity in salesforce
When click Sales from App Launcher
Then click on Opportunity tab
When click on New button
And Enter opportunity name as <opportunityname>
Then Get the text and Store it and print
And Choose close date as Today
And Select Stage as Need Analysis
When Click Save
Then Verify opportunity name as <opportunitynameverify>
Examples:
|opportunityname|opportunitynameverify|
|Salesforce Automation by Saranya L|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|Salesforce Automation by Viji S|