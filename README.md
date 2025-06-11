
# 🎵 LE SSERAFIM Page API Documentation

**Base URL:** `https://lesserafimapi.onrender.com/api`   
**Swagger UI documentation:** `https://lesserafimapi.onrender.com/swagger-ui/index.html`   
**Locally:** `http://localhost:8080/api`   
---

## 📁 Endpoints

### 🔹 GET `/members`

Retrieve a list of all LE SSERAFIM members.

#### Example Response:
```json
[
  {
    "id": 1,
    "name": "Kim Chaewon",
    "birthname": "Kim Chaewon",
    "image1URL": "http://localhost:8080/images/members/chaewon.png",
    "image2URL": "http://localhost:8080/images/members/chaewon2.png",
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

Retrieve details of a specific member by their ID.

#### Example:
`GET /members/1`

---

### 🔹 GET `/discographies`

Get all discography entries.

#### Example Response:
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
    "imageURL": "http://localhost:8080/images/discography/fearless.png"
  }
]
```

---

### 🔹 GET `/discographies/{id}`

Retrieve a specific album by ID.

#### Example:
`GET /discographies/1`

---

### 🔹 GET `/musicVideos`

Fetch all official music videos.

#### Example Response:
```json
[
  {
    "id": 1,
    "title": "Different",
    "iframeSrc": "https://www.youtube.com/embed/HFZUAXhdnHk?si=-MtMTDnQAR2azgpl"
  }
]
```

---

### 🔹 GET `/musicVideos/{id}`

Get specific music video details by ID.

#### Example:
`GET /musicVideos/1`

---

### 🔹 GET `/timeline`

Retrieve major events and milestones in LE SSERAFIM’s history.

#### Example Response:
```json
[
  {
    "id": 1,
    "title": "Pre-debut",
    "imageURL": "http://localhost:8080/images/timeline/logo.png",
    "date": "2021-01-01T00:00:00.000+00:00",
    "text": "In August 2021, rumors emerged that Sakura and Kim Chaewon were joining a new girl group under Source Music, later confirmed when Sakura signed an exclusive contract with Source Music on September 23. Chaewon’s profile was removed from Woollim Entertainment, fueling speculation that she had also signed with HYBE. In March 2022, it was confirmed that Sakura, Chaewon, and Huh Yunjin were part of the new group, LE SSERAFIM, which would debut in May. The group’s name, revealed through a 72-hour countdown, was an anagram of IM FEARLESS. The group’s members were revealed in early April 2022, starting with Sakura, followed by the others. Their debut song snippets and exclusive content were shared, and 120,000 digital souvenirs sold out during the project."
  }
]
```

---

### 🔹 GET `/timeline/{id}`

Fetch a specific historical event by ID.

#### Example:
`GET /timeline/1`

---
