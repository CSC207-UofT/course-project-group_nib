# Phase 0 Progress report

## Task 1 Choose Domain: 

Our group decided to make a Entity.Note-Uploading System. Users can login with username and password to their accounts, and can either create a new note, modify an existing note, comment on other notes, or rate notes. 

## Task 2 Written Specification:
There are various Categories as courses in the system where users can upload their notes corresponding to each course.  Each note is classified by courses. The note is labeled with the date updated, and indicates whether it can be edited by the user. If a note is the original form from the user who uploads it, a tag called “Original” will be labeled as well. If the note is not original, it should have references listing the referenced articles. Each user can login to their account by username and password. If the user doesn’t have the password yet, he should register and set a new one. The user can leave comments and rate the notes. If a user uploaded a note, its name will be shown as the author of the note, and indicate the type of the note, such as pdf, jpeg, typing or handwritten. When notes are uploaded, users who browse the notes can leave comments and ratings for the author of the notes. Users can gain stars on their profile when they are rated with high credibility. The notes with authors that have higher credibility can be shown prioritized compared to other notes in a course. Once each note is uploaded, it will be uploaded to a database that collects and compiles the notes. The notes can be sorted by name of course, originality, author(user)’s credibility. 


## Task 3 CRC Models: (See GitHub folder crc_cards)

After several editing and brainstorming, we finally decided that there should be 6 entities, 4 use cases, 3 interface adapters, and 1 framework in total. 
The parent class of the entity is NoteManagement, which stores notes info such as "editable" "commentable" "referable" "changes" "comment" "reference" and updates the note info when needed.  NoteManagement collaborates with the INote interface and its child classes, which are named CategoryA to CategoryE, representing our 5 different branches of studies.
The three use cases are for the users, since Entity.Entity.User stores user info in our system, Register allows users to register, and ProjectMain helps users to access the MainPageController, which can be understood as the home page of our system.
We have two controllers and two presenters in the interface adapters. MainPageController allows users to interact with notes, and collaborates with another controller WelcomePartController, the presenter UserInfo, and the use case ProjectMain. WelcomePartController allows users to register or login, and interacts with the presenters UserInfo and TableReader, the controller MainPageController, and the use case ProjectMain to proceed the completion of register or login. The presenter TableReader stores user account info, reads and checks if user info are valid, interacting with the use case Entity.Entity.User, the database UserInfoTable, and the controller WelcomePartController. Another presenter UserInfo checks if users can successfully register or log in their accounts, collaborating with TableReader, Entity.Entity.User, UserInfoTable, and WelcomePartController.
The database UserInfoTable stores user information, both usernames and passwords, which will be used by TableReader, UserInfo, Register, Entity.Entity.User.

Clean Architecture:
There are 4 layers for clean architecture. The Framework & Drives layer is for containing the database. Therefore, we located UserInfoTable.csv in this layer for storing notes and user info Data. The Controller Adapter layer is for controllers, gateway and presenters. TableReader.java is a gateway for accessing our CSV file. WelcomePartController.java and MainPageController.java are for users to log in and interact with notes.The UserInfo.java works to verify whether the username and password match or not. Our UseCase contains 3 classes that interact with input user Data and paring users to the related notes. The ProjectMain.java access Data provided by the user from higher layers,  UserNotePare.java and Entity.Entity.User.java will process the Data and manipulate entities to produce the outputs, then return to its upper layer. The classification of notes are all located at the entity level,  5 categories of notes inherit from an abstract class UseCase.UserNotePair.java. Each category can add its instance values and methods to fulfill the user's requirements. Each layer of files depends on its adjacent layers(from outer to inner) or depends within the same layer. And The names of functions, classes, and variables declared in an outer layer are not mentioned by the code in an inner layer.
 Therefore changes in outer layers will not affect the inner layer and make the program well organized.
 
## Task 4 Scenario Walk-Through (extended explanation on CRC cards):
When a user starts the system, they will be interacting with WelcomePartController. In order to complete these commands, WelcomePartController will call Usecase Class: UserInfo. The WelcomePartController first greets the user and then asks for the user to input if they want to register or log in. UserInfo will check whether the users type the correct username and password or not. If a user types “register”, their inputs of username and password will be stored into the database. If a user types in “log in”, the system will ask for the username and corresponding password. If password is not match to the usename, the system will give response “Password incorrect”. Otherwise, the system will give the response “Correct Password”.
Users will be entering the next TableRead, which supposing their input of username and passwords are matched with an existing user object’s attributes stored in the database. The usecase class of the entity class Entity.Entity.User, Entity.Entity.User. UserInfo, will be called in order to check if .Register is complete or not. If user’s inputs are not found in the package Data, they will be rejected to log in, and ask if they want to register. Both UserInfo and TableReader should be in the same package, as they store the user Data.

## Task 5 Skeleton Program: (Code see GitHub folder src)

- Package Entity includes UseCase.UserNotePair, INotes, Category A, Category B, Category C, Category D, Category E
- Package Controller includes MainPageController, WelcomePartController.
- Package UseCase.UserNotePair includes UseCase.UserNotePair.
- Package UseCase includes Register, Entity.Entity.User.
- Package Data includes TableReader, UserInfo, UserInfoTable
- Package Tests includes TestUserNotePair
- ProjectMain.java

 *Extra Progress:
Build pattern is used in our project to construct a complex object for each user and his/her actions on notes. The object contains a user, a list of notes created, a list of notes edited, a list of notes he/she commented on, and a list of notes he/she rated, and since some of the parameters are optional (e.g. a user might not comment on any notes), we can use Build pattern to achieve our goal. To give a basic idea of the Build pattern, it is a pattern that allows the use of the same construction process to create different representations. A class called UseCase.UserNotePair is created, which has a nested builder class containing methods to set all parameters, and finally build the UseCase.UserNotePair object.

SOLID Principle: We keep SRP ISP and DIP perfectly. 

## Progress We’ve Made:
We have implemented entity, usecase and controller generally . We also implement a user log  and manage system.		
## Problems We Encountered:
The first problem we are facing is we are a large group. It is challenging to get everyone at the same time for a meeting. The second problem is that we have an issue between users and notes. The third problem is we don't have a lot of experience in writing Tests, and we were thinking about how to write a test that can test all cases in our code. 
## Future implements & changes
First, we are going to implement all the classes in the CRC models. This involves massive coding and debugging, as well as constructing Tests for functionalities. The project should be fully functional after all the things are implemented because we believe that we have done well during the designing phase.
Second, depending on the course requirement of csc207, we are going to choose the way of storing the Data, including user details and all the notes. If sending and receiving requests are allowed in this course, then we will construct a server by using nodejs. This might not be marked, but it increases the completeness of the whole project. But if not, we are going to set up a local database or continue using the current csv file as storing material.
Entity.Entity.User interface is also a major part of the project. 




