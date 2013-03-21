Meta:
@themes Book

Narrative:
In order to delete books in the library
As a librarian
I want to delete books through the website

Scenario:

Given a library with only a single unborrowed book with <isbn>

When librarian deletes the book <isbn>

Then the book <isbn> is deleted from the library

Examples:
 
| isbn       |
| 1234567962 |
