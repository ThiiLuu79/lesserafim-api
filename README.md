
# 🎵 LE SSERAFIM API Documentation

Base URL: https://lesserafimapi.onrender.com/api   
Locally: http://localhost:8080/api   
Swagger UI documentation: https://lesserafimapi.onrender.com/swagger-ui/index.html   
---
## 🛠 Technologies
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/apachemaven-C71A36.svg?style=for-the-badge&logo=apachemaven&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)

## 📁 Endpoints

### 🔹 GET `/members`

Get a list of all LE SSERAFIM members.

#### Example Response :
```json
[
  {
    "id": 1,
    "name": "Kim Chaewon",
    "birthname": "Kim Chaewon",
    "image1URL": "https://lesserafimapi.onrender.com/images/members/chaewon.png",
    "image2URL": "https://lesserafimapi.onrender.com/images/members/chaewon2.png",
    "description": "Kim Chaewon is a South Korean singer and leader of LE SSERAFIM. She is known for her captivating voice and leadership skills in the group.",
    "birthday": "2000-08-01T00:00:00.000+00:00",
    "position": "Leader, Vocalist, Dancer",
    "nationality": "South Korean",
    "instagram": "https://www.instagram.com/_chaechae_1/",
    "height": 164.0,
    "weight": 42.0,
    "bloodtype": "B",
    "mbti": "ESTP",
    "zodiac": "Leo",
    "chineseZodiac": "Dragon"
  }
]
```

---

### 🔹 GET `/members/{id}`

Get details of a specific member by their ID.

#### Example :
`GET /members/1`

---

### 🔹 GET `/discographies`

Get all discography entries.

#### Example Response :
```json
[
  {
    "id": 1,
    "title": "FEARLESS",
    "releaseDate": "2022-05-02T00:00:00.000+00:00",
    "songs": [
      "The World Is My Oyster",
      "FEARLESS",
      "Blue Flame",
      "The Great Mermaid",
      "Sour Grapes"
    ],
    "imageURL": "https://lesserafimapi.onrender.com/images/discography/fearless.png"
  }
]
```

---

### 🔹 GET `/discographies/{id}`

Get a specific album by ID.

#### Example :
`GET /discographies/1`

---

### 🔹 GET `/musicVideos`

Get all official music videos.

#### Example Response :
```json
[
  {
    "id": 1,
    "title": "Different",
    "iframeSrc": "https://www.youtube.com/embed/HFZUAXhdnHk?si=-MtMTDnQAR2azgpl",
    "releaseDate": "2025-06-08T00:00:00.000+00:00"
  }
]
```

---

### 🔹 GET `/musicVideos/{id}`

Get specific music video details by ID.

#### Example :
`GET /musicVideos/1`

---

### 🔹 GET `/timeline`

Get major events and milestones in LE SSERAFIM’s history.

#### Example Response :
```json
[
  {
    "id": 1,
    "title": "Pre-debut",
    "imageURL": "https://lesserafimapi.onrender.com/images/timeline/logo.png",
    "date": "2021-01-01T00:00:00.000+00:00",
    "text": "In August 2021, rumors emerged that Sakura and Kim Chaewon were joining a new girl group under Source Music, later confirmed when Sakura signed an exclusive contract with Source Music on September 23. Chaewon’s profile was removed from Woollim Entertainment, fueling speculation that she had also signed with HYBE. In March 2022, it was confirmed that Sakura, Chaewon, and Huh Yunjin were part of the new group, LE SSERAFIM, which would debut in May. The group’s name, revealed through a 72-hour countdown, was an anagram of IM FEARLESS. The group’s members were revealed in early April 2022, starting with Sakura, followed by the others. Their debut song snippets and exclusive content were shared, and 120,000 digital souvenirs sold out during the project."
  }
]
```

---

### 🔹 GET `/timeline/{id}`

Get a specific historical event by ID.

#### Example :
`GET /timeline/1`

---
## ℹ️ Data Sources
[Discography data source](https://kprofiles.com/le-sserafim-discography/)   
[Members data source](https://kprofiles.com/le-sserafim-members-profile/)   
---
## 🚀 Command to import data
```sh
./mvnw spring-boot:run "-Dspring-boot.run.arguments=--spring.profiles.active=manual-import"
```
