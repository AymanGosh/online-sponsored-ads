# online-sponsored-ads
This project is focused on developing a powerful module that empowers sellers to effortlessly create and manage promotional campaigns for their products.


| APIs            | METHOD | URL                                      | Parameters                                           | Expected result |
| ----------------|--------|------------------------------------------|------------------------------------------------------|-----------------|   
| Create campaign | POST   | http://localhost:8080/campaigns          | @RequestBody = campaignName<String> & products<LIST> |                 |
| Serve Ad        | GET    | http://localhost:8080/campaigns/serve-ad | @RequestParam = category                             |                 |

-------------
# Examples:
### POST : http://localhost:8080/campaigns
#### RequestBody:
```json
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
```
#### Result :
 add a note to your README file
---------------------
### GET : http://localhost:8080/campaigns
#### Result : 
```json
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
```
-------------------------
http://localhost:8080/campaigns/serve-ad?category=Electronics
```json
{
"productId": 2,
"productName": "Canon EOS 5D Mark IV",
"productCategory": "Electronics",
"productPrice": 2499.99
}
```