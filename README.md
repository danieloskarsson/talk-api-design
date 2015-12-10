# API Design

This repository is the DEMO part of my talk about API design
 at Gothia Science Park 2015-12-09.
 
You need Maven 3 and Java 1.8 to run the DEMO.

`mvn clean jetty:run-war`

Press Ctrl+C to stop the server from running.


Invoke requests and receive responses using cURL or a similar tool:

`curl -s -v http://localhost:8080/`

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:03:24 GMT
< Content-Type: text/plain
< Content-Length: 11
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
Hello World
```

`curl -s -v -X GET http://localhost:8080/`

-X GET is default in curl

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:03:24 GMT
< Content-Type: text/plain
< Content-Length: 11
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
Hello World
```

`curl -s -v http://localhost:8080/users`

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /users HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:04:11 GMT
< Content-Type: application/json
< Content-Length: 2
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
[]
```

`curl -s -v -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/users -d @user.json`

Sending JSON, Requesting JSON, POSTing the contents of the file user.json

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> POST /users HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: application/json
> Content-Type: application/json
> Content-Length: 52
>
* upload completely sent off: 52 out of 52 bytes
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:25:50 GMT
< Content-Type: application/json
< Content-Length: 95
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
{"id":"c710cc61-03fc-479b-9143-65750d4add5d","userName":"daniel","realName":"Daniel Oskarsson"}
```

The server generates and automatically returns the ID

`curl -s -v  -H "Accept: application/json" http://localhost:8080/users`

Explicitly asking for JSON when doing GET so that the server cannot respond with anything else

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /users HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: application/json
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:28:33 GMT
< Content-Type: application/json
< Content-Length: 97
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
[{"id":"c710cc61-03fc-479b-9143-65750d4add5d","userName":"daniel","realName":"Daniel Oskarsson"}]
```

`curl -s -v  -H "Accept: application/json" http://localhost:8080/users | jq .`

Pretty printing and much more is possible with ./jq

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /users HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: application/json
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:29:10 GMT
< Content-Type: application/json
< Content-Length: 97
< Server: Jetty(9.3.6.v20151106)
<
{ [97 bytes data]
* Connection #0 to host localhost left intact
[
  {
    "id": "c710cc61-03fc-479b-9143-65750d4add5d",
    "userName": "daniel",
    "realName": "Daniel Oskarsson"
  }
]
```

`curl -s -v  -X DELETE http://localhost:8080/users/c710cc61-03fc-479b-9143-65750d4add5d`

Deleting the user with id c710cc61-03fc-479b-9143-65750d4add5d

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> DELETE /users/c710cc61-03fc-479b-9143-65750d4add5d HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 204 No Content
< Date: Thu, 10 Dec 2015 09:32:23 GMT
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
```

`curl -s -v http://localhost:8080/users`

```
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /users HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.43.0
> Accept: */*
>
< HTTP/1.1 200 OK
< Date: Thu, 10 Dec 2015 09:04:11 GMT
< Content-Type: application/json
< Content-Length: 2
< Server: Jetty(9.3.6.v20151106)
<
* Connection #0 to host localhost left intact
[]
```