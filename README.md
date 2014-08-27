#iyam

Application I y'am what I y'am

##Introduction

This application is really just my personal application to maintain and administer things that are
important to me. This is an application for me to use. Currently I just have a header that was  
interesting and worked for me, however I'm going to provide a feature where the header can be changed 
using the upload feature (modified).

This application was created using an AppFuse archetype. This was setup using Maven with a command
built on this page, http://appfuse.org/display/APF/AppFuse+QuickStart

The application uses Hibernate for persistence and Tapestry for the web framework. I'm using MySQL
for now as the relational database and running the application in a Jetty container locally for use
and testing.

##Top Level Menus

These menus are presented across the top of the application in the navigation bar below the header 
image. Each menu is described below along with each of the sub-menus.

### Me

This is my personal menu. Things here truly pertain to me.  Sub-menus include Projects, Education,
Health, and Security. This menu should be available only to ADMIN_ROLE.

### Work

This menu is about getting things done.  Work is effort and effort is given to the following sub-menus,
Automation, Employment, Part-Time, Business, House, Yard, and Weekend.