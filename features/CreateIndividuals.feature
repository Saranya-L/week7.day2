Feature: Create New Indiviual
@feature
Scenario Outline: To create new individual in salesforce
When click Individuals from App Launcher
Then Click on the Dropdown icon in the Individuals tab
When Click on New Individual
And Enter the Last Name as 'Loganathan'
Then get the text and store and print it
When click Save button for individuals
Then verify Individuals Name as 'Loganathan'

@smoke
Scenario Outline: To create new individual in salesforce
When click Individuals from App Launcher
Then Click on the Dropdown icon in the Individuals tab
When Click on New Individual
And Enter the Last Name as 'Loganathan'
When click Save button for individuals
Then verify Individuals Name as 'Loganathan'

@sanity
Scenario Outline: To create new individual in salesforce
When click Individuals from App Launcher
Then Click on the Dropdown icon in the Individuals tab
When Click on New Individual
And Enter lastname as <lastname>
When click Save button for individuals
Then verify individual name as <lastnameverify>
Examples:
|lastname|lastnameverify|
|Loganathan|Loganathan|
|Murugan|Murugan|
|Selvam|Selvam|

@regression
Scenario Outline: To create new individual in salesforce
When click Individuals from App Launcher
Then Click on the Dropdown icon in the Individuals tab
When Click on New Individual
And Enter lastname as <lastname>
Then get the text and store and print it
When click Save button for individuals
Then verify individual name as <lastnameverify>
Examples:
|lastname|lastnameverify|
|Loganathan|Loganathan|
|Murugan|Murugan|
|Selvam|Selvam|