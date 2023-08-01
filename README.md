** AUTH TOKEN API**
In Memory Authentication
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
"username" : "ABHI",
"password": "ABHI"
}'
**GET API -** 

curl --location 'http://localhost:8080/api/v1/employees' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data '

**POST API -**

curl --location 'http://localhost:8080/api/v1/employees' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA3MjM5LCJleHAiOjE2OTA4MjUyMzl9.kKxJTz5YOPlxb7ldZBV1Vp7BHfyg5B1yISmzCiO8d-lxdv__HOwj6KIdnJI4lLxVf3nZS9Bu_QlZQRCEbwZRLA' \
--data-raw '{
"firstName" : "Luffy",
"middleName" : "D",
"lastName" : "Monkey",
"email" : "luffyD@gmail.com",
"employeeDetails" : {
"salary" : 56000,
"age" : 19,
"gender" : "male",
"joiningDate" : "2022-06-01"
} ,
"addresses" : [
{
"addressType" : 2,
"city" : "Nagpur" ,
"country" : "India",
"postalCode" : 440015,
"state" : "MH",
"street" : "chatrapati Square"
}
]
}'

**PUT**

curl --location --request PUT 'http://localhost:8080/api/v1/employees/3' \
--header 'Content-Type: application/json' \
--data-raw '{
"firstName" : "Luffy",
"middleName" : "D",
"lastName" : "Monkey",
"email" : "luffyD@gmail.com",
"employeeDetails" : {
"salary" : 56000,
"age" : 19,
"gender" : "male",
"joiningDate" : "2022-06-01"
}

}'

**DELETE**

curl --location --request DELETE 'http://localhost:8080/api/v1/employees/3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data ''

**GET BY ID**
curl --location 'http://localhost:8080/api/v1/employees/3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data ''

