# Loosely Coupled Order Api

![Architecture](https://raw.githubusercontent.com/mstykt/loosely-coupled-order-api/statics/statics/lc-arch-1.png)

You can see loosely coupling environment article on [loosely coupling environment article](https://medium.com/@mesutyakut/loosely-coupled-microservices-2dabebbd3112 "medium")

<br />
All dependencies and backing services dockerized and mocked. 
<br />
tips: productId '25' will give timeout. Feign timeout set 2 second. You can change settings and see differences

Project up:

`cd docker`
<br />
`docker-compose up -d`

Now you are ready to run project stand alone

#### Sample requests:

Ordinary request and response:

**request:**
<br />
```
curl -X POST 'http://localhost:8080/orders' \
-H 'Content-Type: application/json' \
-d '{
"buyerId": 15,
"productId": 19,
"sellerId": 32,
"orderField1": "field 1",
"orderField2": "field 2",
"quantity": 3
}'
```

**response:**
<br />
```
{
  "id": 1,
  "buyerId": 15,
  "productId": 19,
  "productField1": "productField1",
  "productField2": "productField2",
  "sellerId": 32,
  "sellerField1": "sellerField1",
  "sellerField2": "sellerField2",
  "orderField1": "field 1",
  "orderField2": "field 2",
  "quantity": 3
}
```

**Timeout request:**

```
curl -X POST 'http://localhost:8080/orders' \
-H 'Content-Type: application/json' \
-d '{
"buyerId": 15,
"productId": 25,
"sellerId": 32,
"orderField1": "field 1",
"orderField2": "field 2",
"quantity": 3
}'
```

**Timeout response:**

```
{
  "timestamp": "2022-04-07T13:43:10.375+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/orders"
}
```

you will get read timeout exception, product mock set timeout for productId: 25

---
#### Cache:

when you call

`curl http://localhost:8080/orders/summary/{id}`

you will see log like below but after first call log won't be appeir all response will come from cache during cache ttl
<br />
log: `get order summary by id: {id}`

