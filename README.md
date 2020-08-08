# Employee Access Card System

# Synopsys:

The application allocates Identity/Access cards to Employees and also maps a location to employee. Each employee can have 1 or more access cards allocated. Each allocation can have different access attributes. 
Each employee belongs to one location. The table structures and sample data for these entities are provided in this document for reference.

# Problem Statement:

Build a simple Springboot application to display employee records, along with respective cards allocated, access attributes and location detail. Basically, a simple join of all 4 tables and presenting the data at once. 

1.	Provide a json response that contains a paginated record set, with sort and filter options on all fields.
a.	Filter/Sort on any one or all attributes across all entities
b.	Specify the page size i.e, # records in a single response
2.	Find a way to filter by location, which should list all employees under that location tree. 
a.	If India is chosen, all records should be displayed
b.	If Navi Mumbai is chosen, only employees under that location hierarchy should be shown
Note: 
•	Join should be done at Application level
•	Any db of user’s choice can be used (mysql preferred)
•	Response will be a json with all attributes from join table


# Entities used:
1.	Employee
a.	Employee Records.
2.	Card Master
a.	List of Access cards and their format
3.	Mapping Employee Card
a.	Maps Employee to Access Card and sets access attributes 
4.	Location Master
a.	List of all locations (hierarchical relationship table)
