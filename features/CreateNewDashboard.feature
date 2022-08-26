Feature: Create New Dashboard

@feature
Scenario Outline: To create new dashboard in salesforce
When click Dashboards from App Launcher
Then Click on the New Dashboard option 
And Enter Name as 'Salesforce Automation by Saranya L'
Then get text and store and print
When Click on Create
Then Click on Save
Then Click on done
Then Verify Dashboard name as 'Salesforce Automation by Saranya L'

@smoke
Scenario Outline: To create new dashboard in salesforce
When click Dashboards from App Launcher
Then Click on the New Dashboard option 
And Enter Name as 'Salesforce Automation by Saranya L'
When Click on Create
Then Click on Save
Then Click on done
Then Verify Dashboard name as 'Salesforce Automation by Saranya L'

@sanity
Scenario Outline: To create new dashboard in salesforce
When click Dashboards from App Launcher
Then Click on the New Dashboard option 
And Enter dashboardname as <dashboardname>
When Click on Create
Then Click on Save
Then Click on done
Then Verify dashboard name as <dashboardnameverify>
Examples:
|dashboardname|dashboardnameverify|
|Salesforce Automation by Saranya L|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|Salesforce Automation by Viji S|

@regression
Scenario Outline: To create new dashboard in salesforce
When click Dashboards from App Launcher
Then Click on the New Dashboard option 
And Enter dashboardname as <dashboardname>
Then get text and store and print
When Click on Create
Then Click on Save
Then Click on done
Then Verify dashboard name as <dashboardnameverify>
Examples:
|dashboardname|dashboardnameverify|
|Salesforce Automation by Saranya L|Salesforce Automation by Saranya L|
|Salesforce Automation by Priya M|Salesforce Automation by Priya M|
|Salesforce Automation by Viji S|Salesforce Automation by Viji S|