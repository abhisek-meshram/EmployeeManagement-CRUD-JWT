**AUTH TOKEN API**

In Memory Authentication
curl --location 'http://localhost:8081/auth/login' \
--header 'Content-Type: application/json' \
--data '{
"username" : "ABHI",
"password": "ABHI"
}'
**GET API -** 

curl --location 'http://localhost:8081/api/v1/employees' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data '

**POST API -**

curl --location 'http://localhost:8081/api/v1/employees' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwOTgwMTEwLCJleHAiOjE2OTA5OTgxMTB9.qqO7XGM5j3ndKixjerx6JRK2ci6hcvqdpuLVHDs_Mso93ohbu0PFWDFsMUcKqaoGMYxx7BnEUVihaNPeitalng' \
--data '{
"firstName" : "Zoro",
"middleName" : "F",
"lastName" : "Roronoa",
"salary" : 46000,
"age" : 21,
"gender" : "male",
"joiningDate" : "2022-08-01",
"addresses" : [
{
"addressType" : 1,
"city" : "Pune" ,
"country" : "India",
"postalCode" : 411027,
"state" : "MH",
"street" : "chatrapati Square"
}
]
}'

**PUT**

curl --location --request PUT 'http://localhost:8081/api/v1/employees/16' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwOTgwMTEwLCJleHAiOjE2OTA5OTgxMTB9.qqO7XGM5j3ndKixjerx6JRK2ci6hcvqdpuLVHDs_Mso93ohbu0PFWDFsMUcKqaoGMYxx7BnEUVihaNPeitalng' \
--data '{
"firstName" : "Zoro",
"middleName" : "F",
"lastName" : "Roronoa",
"salary" : 45000,
"age" : 21,
"gender" : "male",
"joiningDate" : "2022-08-10",
"addresses" : [
{
"addressType" : 1,
"city" : "Pune" ,
"country" : "India",
"postalCode" : 411061,
"state" : "MH",
"street" : "sangvi phata"
}
]
}'

**DELETE**

curl --location --request DELETE 'http://localhost:8081/api/v1/employees/3' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data ''

**GET BY ID**
curl --location 'http://localhost:8081/api/v1/employees/16' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBQkhJIiwiaWF0IjoxNjkwODA4MDE0LCJleHAiOjE2OTA4MjYwMTR9.tz-oJqJygNuXYa-wF_qU_OBpBz5Ipd2-nSKhb8YOxJeJxeVI9AFzbOUPKL4YKkFGD1IcGMlG3nXPBuikHVkA6g' \
--data ''

