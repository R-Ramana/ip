# User Guide

## Table of Contents
[1. Introduction](#intro)<br>
[2. Setting Up](#setup)<br>
[3. Features](#features)<br>
[4. Usage](#usage)<br>
[5. Command Summary](#summary)


## <a name="intro">1. Introduction</a>
Edith is a command line based task manager. Mainly there are 3 classes of tasks (todo, deadline and event). Tasks can be marked as completed, deleted and searched for by inputting a keyword. The details of the tasks are also recorded and stored in a text file called Duke.txt.

You can download the jar file [here](https://github.com/R-Ramana/ip/releases/tag/A-Jar).

## <a name="setup">2. Setting Up</a>
Please refer to the [setting up guide](https://github.com/R-Ramana/ip/blob/master/README.md) for detailed instructions to set up the project on IntelliJ.

## <a name="features">3. Features</a> 

### Add Task
As mentioned previously, there are 3 types of tasks:

`deadline`
`event`
`todo`

Add one task at a go. The `deadline` and `event` tasks need to have the time specified.

### List Task(s)
Displays a list of all existing tasks. The following information will be provided

Task type:
`T` - todo
`E` - event
`D` - deadline

Status:
Y - Task is marked as done
N - Task is incomplete

Task ID and description of task (includes the time for `deadline` and `event`)

### Delete Task
Delete one task at a time. Removes task from the local memory as well.

### Mark Task as Done
Mark one task as completed at a time. All tasks can be marked as done.

### Find Task(s)
Search for task(s) by entering a keyword.

### Exit Program
Stops running the program.


## <a name="usage">4. Usage</a>

### `todo` - Add todo

Adds a todo task.

Format:

`todo TASK_DESCRIPTION`

Example of usage: 

`todo read Java coding standards`

Expected outcome:

```
Got it. I've added this task:
[T][N] read Java coding standards

Now you have 1 tasks in the list.
```

### `event` - Add event

Adds an event task.

Format:

`event TASK_DESCRIPTION /at START_TIME`

Example of usage: 

`event CS2113 Tutorial /at 2020-10-01 13:00`

:bulb: <b>Tip: Input START_TIME with the following format - YYYY-MM-DD HH:MM</b>

Expected outcome:

```
Got it. I've added this task:
[E][N] CS2113 Tutorial (at: Oct 01, 2020 13:00:00)

Now you have 2 tasks in the list.
```

### `deadline` - Add deadline

Adds a deadline task.

Format:

`deadline TASK_DESCRIPTION /by END_TIME`

Example of usage: 

`deadline complete ip /by Friday`

:bulb: <b>Tip: Input END_TIME with the following format - YYYY-MM-DD HH:MM</b>

Expected outcome:

```
Got it. I've added this task:
[D][N] complete ip (by: Friday)

Now you have 3 tasks in the list.
```

### `list` - List all tasks

Removes any specified task. The corresponding task ID must be specified. The task ID can be obtained by the `list` command.

Example of usage: 

`list`

Expected outcome:

```
Here are the tasks in your list:
 1. [T][N]  read Java coding standards
 2. [E][N]  CS2113 Tutorial  (at: Oct 01, 2020 13:00:00)
 3. [D][N]  complete ip  (by: Friday)
```

### `delete` - Delete Task

Removes any specified task. The corresponding task ID (e.g. 1, 2, 3...) must be specified. The task ID can be obtained by the `list` command.

Format:

`delete TASK_ID`

Example of usage: 

`delete 2`

Expected outcome:

```
 Noted. I've removed this task:
  [E][N]  CS2113 Tutorial  (at: Oct 01, 2020 13:00:00)
 Now you have 2 tasks in the list.
```

### `done` - Mark task as completed

Marks any specified task as completed. The corresponding task ID (e.g. 1, 2, 3...) must be specified. The task ID can be obtained by the `list` command.

Format:

`done TASK_ID`

Example of usage: 

`done 1`

Expected outcome:

```
  Nice! I've marked this task as done:
   [T][Y]  read Java coding standards
```

### `find` - Find tasks

Narrow the search for particular tasks. A keyword has to be entered.

Format:

`find KEYWORD`

Example of usage: 

`find ip`

Expected outcome:

```
  Here are the matching tasks in your list:
 1. [D][Y]  complete ip  (by: Friday)
```

### `exit` - Exit the program

Application ends. User has successfully terminated the running of program.

Example of usage: 

`bye`

Expected outcome:

```
 Bye. I hope I have helped you. See you soon!
```


## <a name="summary">5. Command Summary</a>
Target Action | Example Code
------------  | -------------
Add todo | `todo read Java coding standards`
Add event | `event CS2113 Tutorial /at 2020-10-01 13:00`
Add deadline | `deadline complete ip /by Friday`
List tasks | `list`
Mark task as done | `done 2`
Delete task | `delete 1`
Find task | `find ip`
Exit program | `bye`
