# Assignment 7
## CS5551 - Advanced Software Engineering
### Report: Documentation/Report_Assignment7.pdf
---

| Method | Service Endpoint      | Payload              | Description                                                |
|--------|-----------------------|----------------------|------------------------------------------------------------|
| GET    | /docs/all             | -                    | Retrieves all the documents in the collection.             |
| POST   | /register/post        | zip, city, state     | Creates a new document with the received payload.          |
| GET    | /retrieve/doc         | state                | Retrieves document by find function using state parameter. |
| POST   | /update/doc           | id, zip, city, state | Updates zip, city, state based on id of the document.      |
| DELETE | /delete/doc           | id                   | Deletes document by delete function using id paramter.     |
---

###Response when $http call is made to /docs/all using GET method
![alt-text][logo]
[logo]: http://i.imgur.com/8sQTloT.png?1  "Home Page"

##MLab Screenshots
###Update
![alt-text][logo]
[logo]: http://i.imgur.com/CvUrwqE.png "Update"

##Before Deleting - 18 Documents
![alt-text][logo]
[logo]: http://i.imgur.com/wQHT2uv.png "Before Deleting"

##After Deleting - 17 Documents
![alt-text][logo]
[logo]: "After Deleting"

