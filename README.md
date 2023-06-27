# online-sponsored-ads
This project is focused on developing a powerful module that empowers sellers to effortlessly create and manage promotional campaigns for their products.


| APIs            | METHOD | URL                             | Parameters                            | Expected result |
| ----------------|--------|---------------------------------|---------------------------------------|-----------------|   
| Create campaign | POST   | http://localhost:8080/campaigns | campaignName<String> + products<LIST> |                 |
| Serve Ad        | GET    | Toronto                         |                                       |                 |


http://localhost:8080/campaigns
{
"campaignName":"Valentine day",
"products":[
{
"productId":1
},
{
"productId":2
}
]
}

---------------------

http://localhost:8080/campaigns

[
{
"campaignId": 1,
"campaignName": "Black Friday",
"products": []
},
{
"campaignId": 2,
"campaignName": "Summer Sales",
"products": []
},
{
"campaignId": 3,
"campaignName": "Valentine day",
"products": [
{
"productId": 1,
"productName": "ElectraWave Bluetooth Speaker"
},
{
"productId": 2,
"productName": "PowerPulse Wireless Charger"
}
]
}
]