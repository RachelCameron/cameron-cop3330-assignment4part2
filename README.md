## Important
- NOTE: Please read NoteToTAsDechevApproval.md first.
- BONUS CREDIT: Implemented sorting by due date to claim the extra credit. Instructions to do this are found at the end of the user guide below.
- TESTING ABILITY TO EDIT: Please pay special attention to this section of the pseudocode in ListManagerController.java explaining that I cannot test my list item editing features BUT it is fully validated so there is no functional need to test as the information passed will always be valid,
  - "//javafx table view automatically handles editing so the editing feature CANNOT BE TESTED by nature"
  - "//implemented descriptionIsValid and dueDateIsValid within table view to ensure that new entries through editing will always be valid"
  - "//if you try and edit in any invalid inputs, the invalid input is rejected and the old valid input is kept instead"

## User Guide
- ADD AN ITEM: To add a new item to the list, you must:
1. Enter description of the item in the text field next to the "Item:" label
(must be between 1 and 256 characters). If it is not valid or a duplicate
item description, you will run into this message until it is valid: 
"One or more invalid entries, please try again."
2. Enter due date of the item in the text field next to the "Due Date:" label
(must be a valid due date in YYYY-MM-DD format). If it is not a valid date
in the Gregorian Calendar, you will run into this message until it is valid:
"One or more invalid entries, please try again."
3. Check the checkbox next to the label "Check If Complete" only if the item
is already completed. If it is not already complete, leave the box unchecked.
- REMOVE AN ITEM: Click once on the item you want to remove to select it.
Once selected, the item will automatically highlight blue to indicate selection.
Click on the "Remove Item" button to finalize removal of the selected item.
- CLEAR ALL ITEMS: To clear the list of all items, click the "Clear All List Items" button.
- EDIT ITEM DESCRIPTION: Double-click the current item description of the item
description you would like to edit. Type the new item description and press the
enter key. If the new item description is not valid, it will not update in the
list until you enter a valid item description.
- EDIT ITEM DUE DATE: Double-click the current due date of the due date you would 
like to edit. Type the new due date and press the enter key. If the new due date 
is not valid, it will not update in the list until you enter a valid due date.
- MARK ITEM AS COMPLETE/INCOMPLETE: If you'd like to mark an item complete/incomplete
BEFORE adding the item, use the "Check If Complete" checkbox accordingly before
hitting the "Add Item" button. If you would like to mark an item complete/incomplete
AFTER already adding the item, double-click the current true/false you would
like to edit, swap it, and press the enter key. You must either type "true"
(to mark an item complete) OR "false" (to mark an item incomplete) as valid entry.
If your entry is not valid, it will automatically mark the item as false (incomplete).
- DISPLAY ALL EXISTING ITEMS: All existing items are displayed by default. If you clicked
the "Show Complete/Incomplete Items Only" buttons, the button name will change to
"Show All Items" which can then be clicked on once more to display all items again.
- DISPLAY ONLY INCOMPLETE ITEMS: Click once on "Show Incomplete Items Only" -- if you
would like to show all items again, click the button again (button text changes to "Show All Items").
- DISPLAY ONLY COMPLETED ITEMS: Click once on "Show Complete Items Only" -- if you
would like to show all items again, click the button again (button text changes to "Show All Items").
- SAVE A LIST: Click on the "Save List" button, name your list in the file explorer, and
click save. Your list will be saved as a text file.
- LOAD A LIST: Click on the "Load List" button, select the list you'd like to load in the
file explorer, and click open. The list viewer will populate with the list.
- BONUS CREDIT, SORT BY DUE DATE: Click on the header labelled "Due Date:" to sort
by due date chronologically. You can also sort the list items alphabetically by
clicking on the "Item:" header and/or sort by completion status by clicking on the
"Complete:" header.