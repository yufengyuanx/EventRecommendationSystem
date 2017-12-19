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
|         |----external.yelp
|         	   |----TwoStepOAuth.java
|         	   |----YelpAPI.java
|         |----rpc
|         	   |----SearchItem.java
|         	   |----RecommendItem.java
|         	   |----ItemHistory.java
|         	   |----Login.java
|         	   |----Logout.java
|         	   |----RpcHelper.java
|         |----offline
|         	   |----Purify.java
|         	   |----FindPeak.java
|----WebContent
|    |----scripts
|         |----main.js
|    |----styles
|         |----main.css
|    |----index.html

````


### Backend

#### Database structure

##### MySQL
````
items (item_id, name, city, state, country, zipcode, rating, address, latitude, longitude, description, snippet, snippet_url, image_url, url)

categories (item_id, category)

users (user_id, password, first_name, last_name)

history (history_id, user_id, item_id, last_favor_time)
````

##### MongoDB
````
users (firstname, lastname, password, user_id, favorite)

items (item_id, name, city, state, country, zipcode, rating, address, 
       latitude, longitude, description, snippet, snippet_url, image_url, url, categories)
````

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
###Log

#### Online Log Analysis - ELK

-> Logstash (get log information) 
 
-> ElasticSearch (analysis in-time log information)  

->  Kibana (visualization)


#### Offline Log Analysis - MongoDB
````
MongoDB.collection.mapreduce(map, reduce)
````

### Frontend

**Ajax**

### Test

**Junit4**

Unit Test

**JMeter**

500 Thread Http request for search

Throughput 29.8/sec


200 Thread http request for search
````
Caused by: java.io.IOException: Server returned HTTP response code: 429 for URL: http://app.ticketmaster.com/discovery/v2/events.json?
apikey=Mv73AUlSvrG7LkJ8j5MGKAOpWWMdiqU2&geoPoint=9q9k&keyword=&radius=50
	at 
	sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1840)
	at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1441)
	at java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:480)
	at external.ticketmaster.TicketMasterAPI.search(TicketMasterAPI.java:46)
	... 26 more
java.io.IOException: Server returned HTTP response code: 429 for URL: http://app.ticketmaster.com/discovery/v2/events.json?apikey=Mv73AUlSvrG7LkJ8j5MGKAOpWWMdiqU2&geoPoint=9q9k&keyword=&radius=50
````



