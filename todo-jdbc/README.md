# ToDo
A ToDo application build using spring-boot+MySql. 


Docs -> https://documenter.getpostman.com/view/17357775/2s93m7WgbR


## Tech Stack 
- Back-End 
	- JAVA
	- Spring Boot
	- MySql
- Front-End 
  - JavaScript

## Features  
- Create todo
- View todos/todo
- delete todo by id
- find todo by id
- changes status of todo {Todo, In-Progress,Done}

### ToDo
- [ ] API
- [ ] UI
- [ ] ER-Design
- [ ] DB
- [ ] Unit Testing 
- [ ] Integration Testing 
- [ ] Documentation 
- [ ] Dockerization

  
### Schema 
```sql
CREATE TABLE todo
  (
     id     INT NOT NULL auto_increment,
     name   VARCHAR(100) NOT NULL,
     status VARCHAR(20) NOT NULL,
     PRIMARY KEY (id)
  ); 
```