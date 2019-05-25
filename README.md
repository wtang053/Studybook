# Studybook
README

HEADER

Studybook
Daivic Vora, Walter Tang, Junhe (Tim) Cui



Description/Introduction: 
Our program is a study assistant which brings together people who have the same class. It solves the problem of having to seek out a study group and creates a study environment. I have had trouble in some of my classes and think that a class coming together to assist each other in studying would benefit everyone. It will also motivate people to study by creating an environment of people with the same goal. The program will have a page which contains all of your current classes and once you have clicked on a class, instead of showing a progress report like School Loop, it will show people who also have an account and are taking the same class. Once you are on this page, you are able to create a study group, in which you select a time, place and overview of the study session. Multiple can be made and other people in your class get notified that a study group has been created. They can then join the study group that was created. The goal is to successfully create a study group that is shared among other users. The target audience is all students who are looking for study groups. The primary feature of our program is the “create study group” button. This button creates a group which sends notifications to all other people in that class.


Instructions: 

	Double click Client.jar

	Left-Click Register button

	Input username, password

	Left-Click Login

	Re-enter username and password

	On home page, all classes are listed

	Left-Click on a class (chat room)

	Studdents can talk with each other in the chat room




Features list: 

MUST-DO

	Create a login page (Done)

	Create a method to create accounts (Done)

	Allow students to add classes when making an account (Done)

	Use networking to allow other people who share the same class to appear in their class (Done)

	Create a “Study” button (Done in another way)


WANT-TO

	Have a notification system (-)

	Allow the adding of classes after class is created (-)

	Save login information (Done)

	Add a description to study group/be able to create a study group (-)

	Have a clean user interface (Done)


STRETCH

	Allow login with school loop username and password (-)

	“Reset Password” and “Forgot Password” Method (-)

	Have “show proficiency” button in own account which states how well you are doing in class (-)

	Be able to link e-mail which notifies when study group forms (-)

	Implement a friends list (-)



Class list: 

	StudybookApplication
	controller.Chatroom
	StudentController
	ElectiveRoomDAO
	EnglishRoomDAO
	MathRoomDAO
	ScienceRoomDAO
	StudentDAO
	ElectiveChatRoom
	EnglishChatRoom
	MathChatRoom
	ScienceChatRoom
	swing.Chatroom
	Student
	Login
	Register
	RoomSelection
	ActionResult
	ResultCode
	Swingutil



Credit list:

	Classes
		StudybookApplication - Tim
		controller.Chatroom - Tim
		StudentController - Tim
		ElectiveRoomDAO - Tim
		EnglishRoomDAO - Tim
		MathRoomDAO - Tim
		ScienceRoomDAO - Tim
		StudentDAO - Tim
		ElectiveChatRoom - Tim
		EnglishChatRoom - Tim
		MathChatRoom - Tim
		ScienceChatRoom - Tim
		swing.Chatroom - Tim
		Student - Walter
		Login - Daivic, Tim
		Register - Daivic, Tim
		RoomSelection - Tim
		ActionResult - Tim
		ResultCode - Tim
		Swingutil - Tim
	Others
		Powerpoint - Walter
		UML - Walter
		Set up a MySQL database - Tim
		Use Amazon Web Services (AWS) to build a cloud server - Tim
		Create executable files - Tim
		
	
	Well I am not responsible for everything but I am asked for it so :)

Feedback:

	We like your idea and would use this in real life :)
	There are two class “islands” that need to be connected
	Make a schedule class that has classes
	Then make student have a schedule
	“Classes” would be a super class that should be renamed “Class”
	Different subjects would extend “Class” and override methods in “Class”
	Where does data for student classes come from?
	Are you using a database?
	Explain what your classes represent (what is MainPage) and elaborate on your credits list


