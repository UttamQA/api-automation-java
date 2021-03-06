Feature: Library Microservice 
				 Funcionality of Adding a book,get book using author name/id and delete book from library
 
  @AddBook
  Scenario: Verify the request for AddBook API successfully generates a isbn in response after adding the book
    Given I make a "AddBook" API call
    When  api response status of "200" is received 
    And   check the "isbn" field is correctly present in the api response
		Then  I make a GetBook API call using "AuthorName"
    When  api response status of "200" is received 
    And   check the fields value present in response is not null
		Then  I make a GetBook API call using "ID"
    When  api response status of "200" is received 
    And   check the fields value present in response is not null
		Then  I made a "DeleteBook" API call
		When  api response status of "200" is received
		Then  check the api response message contains "successfully deleted"
		
  #@GetBook
  #Scenario Outline: Verify the request for GetBook API using Author name returns succesfully the book details in response for the Author
    #Given I make a GetBook API call using <QueryParam>
    #When  api response status of "200" is received 
    #Then  check the fields value present in response is not null
#		Examples:
#		|QueryParam  |ParamValue|
#		|"AuthorName"|"John Foe"|
#		|"ID"				 |"1234"		|    
#
#	@DeleteBook
#	Scenario Outline: Verify the request for DeleteBook API deletes the book record
#		Given I made a "DeleteBook" API call
#		When api response status of "200" is received
#		Then check the api response message contains "successfully deleted"
#		Examples:
#		