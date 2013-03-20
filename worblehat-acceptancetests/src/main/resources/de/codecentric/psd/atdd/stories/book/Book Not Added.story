Narrative:
In order to keep a clean database of books
As a librarian
I want to have my entries validated

Scenario:

Given an empty library

When the librarian tries to add a book with an <attribute> of <value>

Then the library contains a no book with an <attribute> of <value>
And the page contains error message <message>

Examples:
 
| attribute | value      | message               |
| ISBN      | 5234567969 | Please enter a valid ISBN (eg. 1236538763 or if isbn-13 it needs the correct format eg. 1-4028-9462-7)     |
| Edition   | 2. Edition | Please enter a valid edition  |

