# CampusCafe

In this project, we implement multi-thread, serialization, MVC observer pattern, txt files. 

- Preset data. Preset data of user and card are saved in the folder of database.
a) cardCollection.txt
It is used to save the preset account numbers, passwords and account extensions. (For single user, the default extension is 0. For family users, they share the same account and password, with different extension numbers.)  
b) .ser files, 
They are used to save the profile information of user and card.

- This project implemented multi-Thread. Running CampusSmartCafe.jar(under OOPProject folder) will open two GUI at the same time. To test single user case, only need to login in one GUI. To test family user case, login in both GUI, using card number 1002, password 0000, extension 0 and 1 separately.   
Family user have the same GUI as single user, except family uses can buy food at the same time. The console will show the money in the shared account  is deducted separately and successfully. 

- Every user (including family user) has her/his own dietary and expense profiles. S/he can set or update her/his own fund limit. Family users share one account, which includes the total account balance. “Family Expense Profile” shows the total expense records in the family by displaying every member’s separated records.

- The menu of footsore in GUI is implemented as JTable. After entering quality in the table, please hit “enter” and keep the lines of selected item highlighted, then click “checkout”. The input may be taken as null if not following these steps. 
