@Batch24
Feature: Verify total price including shipping 
Scenario: User able to add second highest dress and see total price 
	Given user go to practice site 
	When user click on the dresses tab 
	And user capture all dress price from resultset 
	And user add to cart the second highest price dress 
	#	Then user verify total price including shipping user verify the welcome screen 