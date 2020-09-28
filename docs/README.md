# User Guide

## Introduction
Edith is a command line based task manager. Mainly there are 3 classes of tasks (todo, deadline and event). Tasks can be marked as completed, deleted and searched for by inputting a keyword. The details of the tasks are also recorded and stored in a text file called Duke.txt.

## Setting Up
Please refer to the [setting up guide](https://github.com/R-Ramana/ip/blob/master/README.md) for detailed instructions to set up the project on IntelliJ.

## Features 

### Add A Task
As mentioned previously, there are 3 types of tasks:

`deadline`
`event`
`todo`

Add one task at a go. The `deadline` and `event` tasks need to have the time specified.

### Delete A Task
Delete one task at a time. Removes task from the local memory as well.

### Mark Task as Completed
Mark one task as completed at a time. All tasks can be marked as done.

### Find Task(s)
Search for task(s) by entering a keyword.

### List Task(s)
Displays a list of all existing tasks. The following information will be provided

Task type:
`T` - todo
`E` - event
`D` - deadline

Status:
Tick - if task is marked as done
Cross - if task is incomplete

Description of task (includes the time for `deadline` and `event`)

### Exit Program
Stops running the program.


## Usage

### `Keyword` - Describe action

Describe action and its outcome.

Example of usage: 

`keyword (optional arguments)`

Expected outcome:

`outcome`
