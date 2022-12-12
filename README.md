Task 1. Student
--------------------
You need to create a txt file with rows(You need to read data from file):
- Name of student
- Average mark
- Scholarship
Rewrite the file with these criterias:
If average mark is greater than 4.5, increase the scholarship up to 30%
If average is lower than 2, remove this student.
Then, you need to sort them ascending by mark.

**Example:**

  input.txt before compiling:
  
    Medet 3.5 20000
    Azamat 4.7 20000
    Ali 1.6 20000
    Togzhan 2.9 20000
    Aidana 4.8 20000
    
  output.txt after compiling:
  
    Togzhan will take 20000(2.9)
    Medet will take 20000(3.5)
    Azamat will take 26000(4.7)
    Aidana will take 26000(4.8)

Task 2. Book
--------------------------
You need to create a txt file with rows(You need to read data from file):
- Name of book
- Genre
- Year
- Price
Rewrite the file with these criterias:
If book is published more than 30 years ago, decrease the price down to 35%.
If book is published earlier than 5 years, increase the price up to 15%.
You also need to remove all books with genre "fantasy".
Then, you need to sort them by price.

**Example:**

  input.txt before compiling:

    Idiot classical 1845 5000
    Azazel detective 2005 9000
    Origin history 2018 10000
    Hobbit fantasy 1998 6500
    Alchemist drama 1970 23000

  output.txt after compiling:

    Alchemist 14950
    Origin 11500
    Azazel 9000
    Idiot 3250
