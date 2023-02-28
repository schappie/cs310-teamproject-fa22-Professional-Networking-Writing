# cs310-teamproject-fa22-Professional-Networking-Writing
### Introduction

This the main project from my **Software Engineering** I class at _Jacksonville State University_. The goal of this project is to create a time-clock application that has multiple features such as a grace period for clock ins and outs, grace periods for breaks, and the ability to view timestamps virtually across every device the application may be running on. Myself along with 4 of my team members worked on this application over the course of half a semester using the **SCRUM** method. Our Scrum Master was Austin Sanderson (a fellow student) and our project owner was Professor Snellen.

### Methodology

Our program is written in java and has two main types of classes: **main classes** and **DAO classes**. The application works by first taking or adding data to an SQL file. This data includes employees, departments, clock ins and outs (punches), work locations, and other information that comes with the features of the application. This data is retrieved by a DAO class that was created specifically to get or send the necessary data for the main function of whatever feature the user is using. For example, if one were to "clock in" on the application, the "PunchDAO" class would get the time from the "Punch" class and add it to the SQL in the appropriate spot, thus recording the moment the clock in happens. These main files such as "Punch" contain either constructors or hash maps, getters for each of the variables, and a ToString override to print when an action has taken place. The DAO classes do most of the heavy lifting containing huge "for" loops and queries to get or add data to the SQL files for their main counterparts.

### Results

The results of the project were on par. Compared to the other groups in class, ours ended up somewhere in the middle. We did not complete all the features that were given to us, however, we completed many of them, staying ahead of some of our classmates throughout each sprint. The application itself works with all of the key features such as clocking in and out, finding departments, and lunch breaks. It is certainly not up to standard for commercial use, but with limit time and coding experience I was proud at what we had accomplished.

### Conclusion

This class was focused more on using SCRUM than coding with java. That being said, the only coding resource we were provided were PowerPoints containing different concepts and examples we could use on our own. Having never even owned a computer three years ago, I learned leaps and bounds about coding from my teammates and my four hour long coding sessions in my room. I learned to work as apart of a group in and out of the classroom. Often, my team would meet on days we did not have class to work on the project together. We would also split into groups of twos and threes to tackle different features with partners. Using Scrum, I am now prepared for a workplace that also uses Scrum having been in the inner workings.
