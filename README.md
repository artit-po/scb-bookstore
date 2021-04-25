# scb-bookstore

<b> step deploy </b>
- create mysql database using script in this project in <b> /bookstore/src/main/resources/sql/scb_bookstore.sql</b>
- pull this repository and open another ide.
- run maven update project for load dependencies.
- configuration java build path.
- run this project using run as spring boot project.
- after run success open api document this below.

<b> url api documet</b> 
- http://localhost:9080/scb-bookstore/swagger-ui.html

<b>applications properties configurations</b>
- <b>url.scb.books</b> is url scb books
- <b>url.scb.books.recommend</b> is url scb books recommendation
- <b>rest.client.timeout=1000</b> is time out and read data in call api
