# MS3Challenge
#### Simple JAVA app that moves data from an CSV file into a SQLite database(db) while eliminating empty cells and columns

# Purpose of Project:

#### The purpose of this project is to build code in JAVA that will allow a user to move data from a CSV file intoa SQLite database(db) without losing information from the original file. The format of the new file in the db should be the same as with the original in the CSV file.

# Steps to Get The App Up And Running:

#### Step 1) Copy this file from this GitHub repository
#### Step 2) Create a table within the SQLite db
#### Step 3) Link your SQLite database by copying the address for SQLite database and placing it into the DriverManager.getConnection parameters on line 27 in the MainCLass class.
#### Step 4) Next, enter the location of the original CSV file in the getListAccountFromTextFile() parameter on line 48 of the MainClass class.
#### Step 5) Then, you enter the name of the table created in step 2 into three different places in the code. The first place is the connection.createstatement parmeter on line 31. The second place is the connection.createstatement parmeter on line 36. Lastly, the string query on line 42. In each instance the user just needs to replace the name "TallOrder" to the table name from step 2.

#### Note: At this point the application is ready to run. However, if you receive a JDBC error it would be because you did not copy SQLite JDBC driver to your project and import it to build path.


# Overview:
#### The overview of my approach is to remain straight forward and simple. I start off by putting the file into the proper class using the FileInputStream class, the InputStreamReader class and then finally the BufferedReader class. I then place the information into a line reference and then a line.split reference so informatin can be parsed by the commas in the document. After checking each record to make sure it is divided into 10 sections like the orginal CSV records, the complying records are saved in an ArrayList. The noncomplying records are saved as an increment to the IncorrectRecord reference object tally. The complying records are then inserted into the new table. I believe my design choices are straight forward. My application returns:
#### 493 records to the database
#### 5509 failed records
#### 6002 records received

