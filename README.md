# EventRecommendationSystem
[Demo](http://www.yufengyuanx.com/Nearby)
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

### Frontend


### Test

