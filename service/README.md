## minesweeper-service

A very simple REST service for a hypothetical minefield game generator.

To run, in the top directory of the folder, do

    ./gradlew clean bootRun
The service will listen on port 8080.

An example JSON payload is present in src/test/resources/sample.json, to POST this using HTTPie (httpie.org)
do the following:

    http POST localhost:8080/minefield < src/test/resources/sample.json
If all is well, the service should return the following response:

    HTTP/1.1 200
    Content-Type: application/json;charset=UTF-8
    Date: Thu, 09 Feb 2017 21:32:19 GMT
    Transfer-Encoding: chunked
    [
        "1110",
        "1*10",
        "1221",
        "01*1",
        "0111"
    ]
    
There is a second endpoint which will store the generated hints and return the repository ID:

    http POST localhost:8080/minefield < src/test/resources/sample.json
If the hints were generated, the generated ID is returned:

    HTTP/1.1 201
    Content-Type: application/json;charset=UTF-8
    Date: Wed, 15 Feb 2017 21:45:06 GMT
    Transfer-Encoding: chunked
    
    {
        "hintsId": "b402c774-bca1-4d1b-8bed-8b57b5176d01"
    }
    


