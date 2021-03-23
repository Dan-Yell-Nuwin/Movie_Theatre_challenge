# Movie_Theatre_challenge

#Overview:
Implement an algorithm for assigning seats within a movie theater to
fulfill reservation requests. Assume the movie theater has the seating
arrangement of 10 rows x 20 seats, as illustrated to the right.
Your homework assignment is to design and write a seat assignment
program to maximize both customer satisfaction and customer
safety. For the purpose of public safety, assume that a buffer of three
seats and/or one row is required.

#Instructions:
* Download code and then access the Movie_Theatre_challene directory
* cd into the src folder
* edit the test.txt file so that it runs with the reservations you want.
* in the terminal run 'java Solution.java test'
* The command should print out "theatre is full" if the reservations fill up all the spots.
It will also print out the path of the out file with all the seatings for each reservation in 'out.txt'.

#Algorithm Assumptions
* We assume that the size of the movie theatre is 10 rows and 20 seating columns.
* If all the seats are filled, we will print "seating is full" and stop booking seats.
* Assume that for each group booked, they must be separated by at least 3 rows horizontally and have 1 empty row buffer.
* We will book each group horizontally and keep booking in the next line.


