#Phase 2 Project Document

## SOLID Principles


###Single Responsibility Principle:

A class should have one and only one reason to change, meaning that a class should have only one job.

* The system has to interact with the `Notes` entity in various ways. Therefore, we created different Use Case objects to carry each functionality rather than combine them as a whole. Examples are `NoteCreation`, `NoteEdition`, etc. 

* To control the overall complexity of the system, an abstract class `NoteInfoManipulation` is created and all the Note-Controlling Use Case objects (such as `NoteCreation`) are inherited from it. The Controller calls the abstract parent class but uses the functionalities in the subclasses to do different jobs. Each subclass only take one job from the parent class.

* The logic is the same in the user authorization sections. Jobs such as login and register are distributed to separated classes `UserCreation` and `UserAuthentication`.


###Open-Closed Principle:
Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification. 

* The above-mentioned abstract class `NoteInfoManipulation`, along with `UserInfoManipulation` which controls the `User` Entity are also examples of Open-Closed Principle. All the Entity-controlling objects are their subclasses as they provide a universal constructor pattern for instantiation.

* If there are new functionalities need to be implemented, all we need to do is simply create a new use case object to inherit one of them and add new features based on the requirement. No code modifications are needed.


###Liskov Substitution Principle :
Every subclass or derived class should be substitutable for their base or parent class. The subclass should satisfy all features of its parent class before implementing new features.

* All the subclasses of `UserInfoManipulation` have implemented all the methods in the parent class. Therefore, they can take any of the jobs that the parent class takes without raising any issues. 

* All the subclasses of `NoteInfoManipulation` have implemented all the methods in the parent class. Therefore, they can take any of the jobs that the parent class takes without raising any issues. 


### Interface Segregation Principle:
A client should never be forced to implement an interface that it doesn’t use, or clients shouldn’t be forced to depend on methods they do not use.

* There are two directions of information output in the Use Case layer: one towards controller and one towards database. Although they are in the same section, we created different interfaces to ensure that the interfaces are clean and simple. e.g. `NoteInfoDataAccess` only deals with the output of `Notes` to the database and `UserInfoOutput` only deals with the output of `User` to the controller. They fall into the same layer (Use Case) but they are separated.

### Dependency Inversion Principle：
Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.

* Interfaces are created to block the dependency flow from lower-level modules to higher-level modules. 

* In the Use Case layer, `UserInfoOutput` interface is created and the `UserInfoPresenter` in the controller layer implements it. When, for instance, `UserCreation` is going to make a return to the controller class, it uses the interface to change the presenter object rather than depend on it directly. This prevents `UserCreation` from explicitly knowing the details of  `UserInfoPresenter`, thus prevents dependency inversion. Dependency injection is also used here as the presenter object is sent to the Use Case by the controller.

* The pattern is similar when the the system is accessing data. A `UserInfoAccess` object implement the `DataAccessInterface` in the Use Case layer and is injected to `UserCreation`. The Use Case objects manipulates the interface to make real changes to the database.



## Clean Architecture

### Entities: 

#### `Notes`

an Entity that stores the information of the notes.


* `Users`: an Entity that stores the information of the users.


### Use Cases: 



NoteCreation, NoteFactory, DataAccessInterface, UserInfoManipulation[UserCreation, UserSuthentication], UserInfoOutput
For use cases, the UserInfoManipulation is a superclass for UserAuthentication and UserCreation. The two interfaces are called internal layers to decrease dependency and coupling. The NoteCreation class calls by MainPageController for setting the attributes of each note when created. The NoteCreation class can only interact with the Notes class which belongs to the use case

### Controllers: 
WelcomePartController and MainPageController. WelcomePartController controls users’ registration and login. It calls corresponding use cases to create a new user object or check if the input information exists. MainPageController controls the creation and edition of the notes by users by calling relevant Use Case classes as CreateNotes and EditNotes.


### UI & DB: 
UserInfoTable.csv, Android or Software, MainPageInterface,  UserInfoAccess, CommandLineInterface.
The Framework & Drives layer contains databases and user interfaces. We have TableReader to interact with our CSV file to access data.
There are 2 UI in the program, the CommandLineInterface interacts with UserInfoController which receives the account information that the user inputted. Similar to the MainPageInterface which receives commands to interact with notes. Both classes are simulating UI for this system. 
We also added an Interface Entity which only belongs to the UI layer.
Since the UserMainInterface provides command lines for users to create or do some actions to the notes, which will result in tons of variables and cause code smell. Therefore we created the NotesCreateForm which encapsulates variables that simplified the code.






## Design Patterns


[Expected, but didn’t apply] Template method can help us to override specific steps of the algorithm in subclasses but not change the structure which is inherited from its superclass. To be more specific, when we use the template method, it will separate the algorithm from the superclass into steps by steps, each step will allow the subclass to override. Be mentioned that the methods of the superclass do not override. In order to implement every subclass, we need to declare all separated algorithm steps “abstract”. Therefore, the advantages about the template method are that we can extend individual step in each subclass, while the structure in the superclass is the same all the time. Based on our project, a note-uploading system, the most important thing is to upload files into the system. However, different readers may prefer different file formats. For example, pdf files, word docx files, .txt files or csv files. All files have similar code for data processing and analysis, the differences are the format and some basic typesetting. By using the template method design pattern, we will not write similar code for three times. What we need to do is to create a main abstract class, which is implemented by every subclass. 



## Use of GitHub Features
Pull the most up to date files from the main repository to individual repositories. 
Push the files to the main repo and leave meaningful comments
Issues: We create new issues identifying new features, and then leave the TODOs in some files to give check points for future modification.
Pull Requests on the branches that might be eligible to be merged to the main repository.


## Testing (Compared to Phase 1)
In Phase 1, we tested most of the use case methods and we’ve tested the update table method for user information.
In Phase 2, all methods for the user have been tested (user login and register, user information table update, check whether the username matches the password) without affecting the source database. We created a new csv file just for testing, and overloaded the methods that directly read or update the csv file. Polymorphism on TableReader constructor (which reads the user information table) so that all testing results will show only in the test file.
Most methods for notes have been tested ( such as note creation, note edition, note deletion, note information table update). We’ve also created a testing csv file, and the source database won’t be affected. Methods that will directly update or read the source database are overloaded for testing purposes. Polymorphism on the NoteTableReader constructor so that all the testing results will show in the testing file and note the source database.


## Problems We Face
Template design pattern was not applied as expected. At first, we considered uploading different types of notes such as pdf, word, txt, etc. Due to time constraint and lack of knowledge in knowing how to upload documents such as pdf or pictures to the system, we finally decided not to apply that.
Teammates either dropped the course,  got sick or were in hospital, so it was really hard to have everyone together to talk about the project.


## What To Do Next…
Keep working on extending functions on notes, and the interactions between users. E.g: Like notes
Think about how we can better apply clean architecture in our code to make it more “clean”.
Think about more design patterns that can be applied.




