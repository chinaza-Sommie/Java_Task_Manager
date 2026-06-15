// OPERATIONS : Add, Delete, Update, mark-in-progress , mark-done , list list done, list todo list in-progress
    // A user comes on the and is prompted with the operations to add data
    // METHODS ALGORITHM
    // Accept Input is processed my the EndpointActions class
    // if operation Add then process add method
    // if operation update then process update method
    // if operation delete then process delete method
    // if operation mark-in-progress then process mark-in-progress method
    // if operation mark-done then process mark-done method
    // if operation list then process list method
    // if operation list done then process listDone method
    // if operation list todo then process listTodo method
    // if operation list in-progress then process list in-progress method

    // APP.java - calls the methods based on the operation called
    // 

    //FILES:
    // 1 class and one class with inheritance (Task Manager and Task)
    // Task Manger (handles every operation except the Update)
    // Tasks (handles the update )

    // DATASTRUCTURE FOR THE STORAGE
    // HashMap

    // ALGORITHM
    // -> Display available operations
    // -> Accept input from user

    // -> IF operation == "add"
//      -> Ask the user for the task description
//      -> Call the addData() method
//      -> Store the task in the database
//      -> Display a success message with the generated task ID

// -> ELSE IF operation == "delete"
//      -> Ask the user for the task ID
//      -> Call the deleteTask() method
//      -> Remove the task with the matching ID from the database
//      -> Display a success or failure message

// -> ELSE IF operation == "update"
//      -> Display all available tasks (optional)
//      -> Ask the user for the task ID
//      -> Ask the user for the new task description
//      -> Call the update() method
//      -> Update the description of the matching task
//      -> Update the "updatedAt" field
//      -> Display a success or failure message

// -> ELSE IF operation == "mark-in-progress"
//      -> Ask the user for the task ID
//      -> Call markTaskProgress(taskID, "in-progress")
//      -> Update the status of the matching task to "in-progress"
//      -> Display a success or failure message

// -> ELSE IF operation == "mark-done"
//      -> Ask the user for the task ID
//      -> Call markTaskProgress(taskID, "done")
//      -> Update the status of the matching task to "done"
//      -> Display a success or failure message

// -> ELSE IF operation == "list"
//      -> Retrieve all tasks from the database
//      -> Display all tasks

// -> ELSE IF operation == "list done"
//      -> Call listBasedOnStatus("done")
//      -> Display all completed tasks

// -> ELSE IF operation == "list todo"
//      -> Call listBasedOnStatus("todo")
//      -> Display all pending tasks

// -> ELSE IF operation == "list in-progress"
//      -> Call listBasedOnStatus("in-progress")
//      -> Display all tasks currently in progress

// -> ELSE IF operation == "exit"
//      -> Display a goodbye message
//      -> Terminate the program

// -> ELSE
//      -> Display "Invalid operation. Please try again."

// -> Return to the beginning of the loop and display the operations again




