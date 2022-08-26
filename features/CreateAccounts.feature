Feature: Create New Account

@feature
Scenario Outline: To create new account in salesforce
When Click Sales from App Launcher
Then Click on Accounts tab 
When Click on New button
And Enter 'Saranya' as account name
Then get the text and Store it and print
Then Select Ownership as Public
When click Save
Then verify Account name as 'Saranya'

@smoke
Scenario Outline: To create new account in salesforce
When Click Sales from App Launcher
Then Click on Accounts tab 
When Click on New button
And Enter 'Saranya' as account name
Then get the text and Store it
Then Select Ownership as Public
When click Save
Then verify Account name as 'Saranya'

@sanity
Scenario Outline: To create new accounts in salesforce
When Click Sales from App Launcher
Then Click on Accounts tab 
When Click on New button
And Enter account name as <acctname>
Then get the text and Store it
Then Select Ownership as Public
When click Save
Then verify account name as <verifyacctname>
Examples:
|acctname|verifyacctname|
|Saranya|Saranya|
|Priya|Priya|
|Monisha|Monisha|

@regression
Scenario Outline: To create new accounts in salesforce
When Click Sales from App Launcher
Then Click on Accounts tab 
When Click on New button
And Enter account name as <acctname>
Then get the text and Store it and print
Then Select Ownership as Public
When click Save
Then verify account name as <verifyacctname>
Examples:
|acctname|verifyacctname|
|Saranya|Saranya|
|Priya|Priya|
|Monisha|Monisha|




