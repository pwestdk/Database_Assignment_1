# Database_Assignment_1 
- Simple DB with Hashmap-based Index
- Author: Philip West Christiansen
- Contact: pwestdk@gmail.com
- Credentials: CPH-PC79

## Description of project: 

Program creates a text file "database.txt" in root of project folder. Text file will when created contain 10 unique keys with corresponding values based on a hashmap. Keys are indexes ranging starting from 1 and the corresponding value is are names. For example "Key: 1 - Value: Philip". Project contains method that will print entire database to console, method that allows you to write new entries to the database and find a value based on their index key. Below is a description of all the methods. 

## Setup

Clone repository. Open in prefered IDE, i used "Netbeans IDE 8.2". Run main method. Boom.  

## Description of methods:

db_create()
- Creates the database if it does not already exist in root. If created inputs 10 entires from db_hardinput() method based on a hashmap. 

creating_hash()
- Reads entire database, and creates a new hashmap. 

db_write(String input)
- Makes you able add a new entry to the database, by inserting a value (for example: "Philip"). 

db_read()
- Prints out entire database to console.

db_find(String id)
- find a value based on their index key.

db_hardinput()
- 10 hardcoded entries for the database, called in db_create().

## Example of using project:

Below is what the current main-method looks like:

    // Run this method to create the DB (.txt file database.txt), with hardcoded inputs
    db_create();

    // Creating hashmap
    creating_hash();

    // Write a name to the database
    //db_write("Mikkel");
    //db_write("Hamza");

    // Read entire the database
    db_read();

    // Find specific ID in the database
    db_find("4");
    
This is an example as to how to run the project. "database.txt" is created in root. A hashmap is created based on reading file created. You can uncomment the db_write() methods to write new entries to the database. The entire database is read and printed to console and we find value of key 4. 
