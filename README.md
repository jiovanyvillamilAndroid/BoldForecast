
# BoldForecast

Simple Forecast project to see the current temperature, and also check the next hours and next days.



## Screenshots

![App Screenshot](https://github.com/user-attachments/assets/921eaa38-937a-4206-9ea1-66673f314a2a)


## TechStack

- MVVM Architecture
- Jetpack compose
- Jetpack Navigation
- Hilt
- Retrofit
- Mockito
- SplashScreen API
- Lottie


## Installation

To install the project modify/create the gradle.properties file

```bash
  TEST_API_KEY="addheretheAPIKey"
```

This helps the project retrieve the API key for making the calls to api.weatherapi.com
## API Reference



### Base URL
```http
https://api.weatherapi.com/v1/
```


#### Get all items
```http
  GET /search.json
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. The API Key is provided by the gradle.properties file |
| `q` | `string` | Some text check more https://www.weatherapi.com/docs/ |

#### Get item

```http
  GET /forecast.json
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. The API Key is provided by gradle.properties file |
| `q` | `string` | Some text check more https://www.weatherapi.com/docs/ |
| `days` | `integer` | next forecast days  |


