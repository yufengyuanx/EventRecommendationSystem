# EventRecommendationSystem
[Demo](http://www.yufengyuanx.com/event)

sample username: 1111

sample password: 2222

## Objective

1. Show nearby Events according to your position (TicketMaster API).
2. Provide recommendation according to your favorite history.
3. Extension for muliple database and API.

## Project Structure
````
EventRecommendationSystem
|----Java Resources
|    |----src
|         |----algorithm
|         	   |----GeoRecommendation.java
|         |----db
|         	   |----DBConnection.java
|         	   |----DBConnectionFactory.java
|         |----db.mongodb
|         	   |----MongoDBConnection.java
|         	   |----MongoDBUtil.java
|         |----db.mysql
|         	   |----MySQLConnection.java
|         	   |----MySQLDBUtil.java
|         |----entity
|         	   |----Items.java
|         |----external
|         	   |----ExternalAPI.java
|         	   |----ExternalAPIFactory.java
|         |----external.ticketmaster
|         	   |----GeoHash.java
|         	   |----TicketMasterAPI.java
|         |----rpc
|         	   |----SearchItem.java
|         	   |----RecommendItem.java
|         	   |----ItemHistory.java
|         	   |----Login.java
|         	   |----Logout.java
|         	   |----RpcHelper.java
|----WebContent
|    |----scripts
|         |----main.js
|    |----styles
|         |----main.css
|    |----index.html

````


### Backend

#### Database structure

#### SearchItem

1. get user_id
2. get user position (lat, lon)
3. get data from API([TicketMasterAPI](https://developer.ticketmaster.com/))
3. clean data and response to front end

#### RecommendItem

Recommendation based on geo distance and similar categories.

#### ItemHistory

Query database.

#### TicketMasterAPI

sample result

````JSON
	{
		  "country": "United States Of America",
		  "address": "99 Grove Street",
		  "item_id": "G5vYZfMfT3Ifc",
		  "city": "San Francisco",
		  "latitude": 37.778479,
		  "rating": 0,
		  "description": "All ages welcome. 8 ticket limit per household includes tickets purchased during presale and during on sale. All tickets for this show are general admission, standing on floor level or seated upstairs on a first come, first serve basis.",
		  "url": "http://www.ticketmaster.com/khalid-the-roxy-tour-san-francisco-california-05-05-2018/event/1C0053753F4A852D",
		  "zipcode": "94102",
		  "name": "Khalid: The Roxy Tour",
		  "state": "California",
		  "categories": [
		    "Music"
		  ],
		  "longitude": -122.417473
	}
````

### Frontend


### Test

