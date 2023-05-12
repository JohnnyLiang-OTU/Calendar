# Calendar
 
**Last update made on: May 12, 2023.**
Initially, I was planning to make a calendar and a to-do list app in one project, however, the calendar itself presented many challenges -which I will detail later on- that made me not continue working on this project.

### What have I learned from this project?
- How to use JavaFX.
- How to use the Time package, and how scary times are.
- The importance of modular programming (expand more on this later).

### How far have I gotten with this project?
![alt text](https://github.com/JohnnyLiang-OTU/Calendar/blob/master/finalProduct.png?raw=true)
This is what I have accomplished so far. 
Once the program runs, the GUI will run and display the buttons (<) and (>) and a basic calendar layout that shows the weekdays and has buttons for each day of the month.
The (<) (>) buttons will, respectively, go to the previous and next month. It will also update the position of the buttons according to this new month.
The buttons for each day of the month, once pressed, will open a new window called FORM with the fields Duration and Description, and a combo box Start.
This button basically allows the user to create a time event which will start at the selected time, last the selected duration, and have a description.
Once the submit button is clicked, all this information will be stored in a Calendar.java and be displayed in the terminal. Unfortunately, I haven't implemented a record
feature to keep track of all the events added after the program is closed.

### Why I stopped?
The main reason I stopped is because of how terribly based is the program, in more specific words, the coding is poorly structured. At some point I realized
that to make a simple change, I had to refactor a lot of functions just to make up with that small change, here I realized how paramount is modular programming.
What I should've made are shorter functions and more specific functions, each function is supposed to do one task. I believe this would've helped with maintanability and flexibility.

END
