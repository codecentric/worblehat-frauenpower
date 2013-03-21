Meta:
@themes Book

Narrative:
In order to show borrowed books sorted in the library
As a user
I want to see my books sorted by date on the website

Scenario:

Given an empty library
And a user <user> has borrowed books <isbns> at <borrowDate>

When a user <user> wants to see his borrowed books <isbns>

Then the books <isbns> are sorted by return date

Examples:
    
| user            | isbns                 | borrowDate   |
| user1@dings.com | 0321293533            | 2013-03-21   |
| user1@dings.com | 1234567962            | 2013-03-20   |
