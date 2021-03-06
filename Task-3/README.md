# Task 3

A simple RESTful API

# Implementation

[Http1.1 RFC for GET, POST, DELETE and PUT](https://tools.ietf.org/html/rfc7231#section-4.3)

## Data
All data classes are extended from BaseData class.  
BaseData holds all the basic information which everyother resource class should have.  
Such as id, created, updated and HATEOAS links.  
Data specific attributes should all have getters and setters set when implemented.

## Services
Services which actually manage resources are extended for BaseService class.  
BaseService class uses generic typing to determine data type.  
BaseService should implement all the basic operations.  
Rest of the services are extended from BaseService class and use Singleton pattern.  
Any service specific methods can be implemented in those classes.  

## Resources
All the actual RESTful implementations are implemented in Resource classes.  
Any new resource class should be added to Ties456RestMain class' classes HashSet.  
Otherwise it won't get loaded when the server is started.

# API Document
## Blogs - Upper Level Resource
| Path          | Method | Parameters | Response | Failures | Description                |
|---------------|--------|------------|----------|----------|----------------------------|
|/blogs         | GET    | NONE       | 200      | NONE     | Gets all Blogs             |
|/blogs         | POST   | NONE       | 201      | 400      | Adds Blog from Message Body|
|/blogs/{blogId}| GET    | NONE       | 200      | 404      | Gets blog by id            |
|/blogs/{blogId}| DELETE | NONE       | 204      | NONE     | Removes blog by id         |
|/blogs/{blogId}| PUT    | NONE       | 200      | 400      | Updates blog by id         |

## Comments - Nested Resource
| Path                               | Method | Parameters | Response | Failures | Description                 |
|------------------------------------|--------|------------|----------|----------|-----------------------------|
|/blogs/{blogId}/comments            | GET    | NONE       | 200      | NONE     | Gets Blogs Comments         |
|/blogs/{blogId}/comments            | POST   | NONE       | 201      | 400      | Adds new Comment            |
|/blogs/{blogId}/comments/{commentId}| GET    | NONE       | 200      | 404      | Gets Comment from blog by id|
|/blogs/{blogId}/comments/{commentId}| DELETE | NONE       | 204      | NONE     | Deletes comment from blog   |
|/blogs/{blogId}/comments/{commentId}| PUT    | NONE       | 200      | 400      | Updates comment from blog   |


## Podcasts - Upper Level Resource
| Path                | Method | Parameters | Response | Failures | Description       |
|---------------------|--------|------------|----------|----------|-------------------|
|/podcasts            |GET     |NONE        |200       |NONE      | Gets All Podcasts |
|/podcasts            |POST    |NONE        |201       |400       | Adds Podcast      |
|/podcasts/{podcastId}|GET     |NONE        |200       |NONE      | Get Podcast       |
|/podcasts/{podcastId}|DELETE  |NONE        |204       |404       | Deletes Podcast   |
|/podcasts/{podcastId}|PUT     |NONE        |200       |400       | Updates Podcast   |


## Likes - Nested Resource
| Path                               | Method | Parameters | Response | Failures | Description               |
|------------------------------------|--------|------------|----------|----------|---------------------------|
|/podcasts/{podcastId}/likes         |GET     |NONE        |200       |NONE      | Gets Podcasts Likes       |
|/podcasts/{podcastId}/likes         |POST    |NONE        |201       |400       | Adds Like to Podcast      |
|/podcasts/{podcastId}/likes/{likeId}|GET     |NONE        |200       |404       | Gets Podcasts Like        |
|/podcasts/{podcastId}/likes/{likeId}|DELETE  |NONE        |204       |NONE      | Deletes Like from Podcast |
|/podcasts/{podcastId}/likes/{likeId}|PUT     |NONE        |200       |400       | Updates Podcasts Like     |

## Data Structures

### BaseData
|Name    |Type  |Include in POST|
|--------|------|---------------|
|id      |long  |NO             |
|created |Date  |NO             |
|updated |Date  |NO             |
|links   |Array |NO             |

### Blog
Has all the BaseData attributes as well.  

|Name    |Type  |Include in POST|
|--------|------|---------------|
|writer  |String|Required       |
|title   |String|Required       |
|blogText|String|Required       |

### Comment
Has all the BaseData attributes as well.  

|Name    |Type  |Include in POST|
|--------|------|---------------|
|blogId  |long  |NO             |
|user    |String|Required       |
|comment |String|Required       |

### Podcast
Has all the BaseData attributes as well.  

|Name      |Type  |Include in POST|
|----------|------|---------------|
|caster    |String|Required       |
|title     |String|Required       |
|podcastUrl|String|Required       |

### Like
Has all the BaseData attributes as well.  

|Name     |Type  |Include in POST|
|---------|------|---------------|
|podcastId|long  |NO             |
|user     |String|Required       |
|score    |int   |Required       |

# Running locally

0. TODO better guide d_O_b
1. Import Maven project
2. Run Project as Server

# Usage

1. Use [Postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop) for testing
2. Base URL is http://localhost:tomcat_port/

# Examples for Data
Use these for testing purposes

## Blog
POST /blogs

```json
{"writer":"John Smith", "title":"Fine Blog Update", "Lorem ipsun etc etc"}
{"writer":"Marge Simpson", "title":"About Homer", "D'Oh"}
```

## Comment
POST /blogs/{blogId}/comments
```json
{"user":"MightyCommenter23234", "comment":"First!"}
{"user":"realDoge21", "comment":"Wow such blog"}
```

## Podcast
POST /podcast
```json
{"caster":"Casper the Ghost", "tile":"Haunting", "podcastUrl":"http://localghost"}
{"caster":"Podcasters", "tile":"Winter is Coming", "podcastUrl":"http://127.0.0.1"}
```

## Like
POST /podcast/{likeId}/likes
```json
{"user":"timtim", "score":9000}
{"user":"samuel98", "score":1}
```
