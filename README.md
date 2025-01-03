# 환전 시스템
 
## [ API 명세서 ]

### 유저 API

| 기능    | Method | URL                 | request  | response | 상태코드                                     |
|-------|--------|---------------------|----------|----------|------------------------------------------|
| 유저 등록 | POST   | /users          | 요청 body  | 등록 정보    | 200: 정상 등록        |
| 유저 로그인    | POST | /users/login | 요청 body | -        | 200: 정상 로그인  404: 찾을 수 없음 |
| 유저 로그아웃    | GET | /users/logout | -  | -        | 200: 정상 로그아웃 |
| 유저 전체 조회 | GET    | /users      | 요청 param | 조회 정보 | 200: 정상 조회      |
| 유저 선택 조회 | GET    | /users/{id}      | 요청 param | 조회 정보 | 200: 정상 조회  404: 찾을 수 없음    |
| 유저 선택 삭제    | DELETE | /users/{id} | 요청 param     | -        | 200: 정상 삭제  404: 찾을 수 없음 |

- `POST` 유저 등록

`URL: /users`

요청
```
{
    "name": "test",
    "email": "test1@test.com",
    "password": "123456"
}
```
응답
```
{
    "id": 1,
    "name": "test",
    "email": "test@test.com"
}
```

- `POST` 로그인

`URL: users/login`

요청
```
{
    "email": "test@test.com",
    "password": "123456"
}
```
응답
```
-
```
- `GET` 로그아웃

`URL: users/logout`

요청
```
-
```
응답
```
-
```

- `GET` 유저 전체 조회

URL : /users

요청
```
-
```
응답
```
[
    {
        "id": 1,
        "username": "test",
        "email": "test@test.com"
    },
    {
        "id": 2,
        "username": "test2",
        "email": "test2@test.com"
    }
]
```


- `GET` 유저 선택 조회

`URL: /users/{id}`

요청
```
-
```
응답
```
{
    "id": 1,
    "username": "test",
    "email": "test@test.com"
}
```

- `DELETE` 유저 선택 삭제

URL : /users/{id}

요청
```
-
```
응답
```
-
```


### 통화 API

| 기능       | Method | URL                  | request  | response | 상태코드                                             |
|----------|--------|----------------------|----------|----------|--------------------------------------------------|
| 통화 등록    | POST   | /currencies      | 요청 body  | 등록 정보    | 200: 정상등록  400: 잘못된 요청                |
| 통화 전체 조회 | GET    | /currencies       | 요청 param | 목록 조회 정보 | 200: 정상 조회           |
| 통화 선택 조회    | GET    | /currencies/{id} | 요청 param     | 조회 정보    | 200: 정상 조회 404: 찾을 수 없음        |

- `POST` 통화 등록

`URL: currencies`

요청
```
{
    "currencyName": "USD",
    "exchangeRate": "1430.00",
    "symbol": "$"
}
```

응답
```
{
    "id": 1,
    "currencyName": "USD",
    "exchangeRate": 1430.00,
    "symbol": "$"
}
```

- `GET` 통화 전체 조회

`URL: /currencies`

요청
```
-
```
응답
```
[
    {
        "id": 1,
        "currencyName": "USD",
        "exchangeRate": 1430.00,
        "symbol": "$"
    }
]
```

- `GET` 일정 선택 조회

`URL: /currencies/{id}`

요청
```
-
```
응답
```
{
    "id": 1,
    "currencyName": "USD",
    "exchangeRate": 1430.00,
    "symbol": "$"
}
```

### 환전 API

| 기능    | Method | URL                 | request  | response | 상태코드                                     |
|-------|--------|---------------------|----------|----------|------------------------------------------|
| 환전 요청 | POST   | /exchanges          | 요청 body  | 등록 정보    | 200: 정상 등록        |
| 환전 선택 조회 | GET    | /exchanges/{id}      | 요청 param | 조회 정보 | 200: 정상 조회  404: 찾을 수 없음    |
| 환전 선택 수정    | PATCH | /exchanges/{id} | 요청 param     | -        | 200: 정상 삭제  404: 찾을 수 없음 |

- `POST` 환전 요청

`URL: /exchanges`

요청
```
{
    "userId": "1",
    "currencyId": "1",
    "beforeAmount": 2000000
}
```
응답
```
{
    "exchangeId": 1,
    "userId": 1,
    "currencyName": "USD",
    "exchangeRate": 1430.00,
    "beforeAmount": 2000000,
    "afterAmount": 1398.60,
    "status": "NORMAL"
}
```

- `GET` 환전 선택 조회

`URL: /exchanges/{id}`

요청
```
-
```
응답
```
[
    {
        "exchangeId": 1,
        "userId": 1,
        "currencyName": "USD",
        "exchangeRate": 1430.00,
        "beforeAmount": 2000000.00,
        "afterAmount": 1398.60,
        "status": "NORMAL"
    },
    {
        "exchangeId": 2,
        "userId": 1,
        "currencyName": "USD",
        "exchangeRate": 1430.00,
        "beforeAmount": 1000000.00,
        "afterAmount": 699.30,
        "status": "NORMAL"
    }
]
```

- `PATCH` 환전 선택 수정

URL : /exchanges/{id}

요청
```
-
```
응답
```
{
    "exchangeId": 1,
    "userId": 1,
    "currencyName": "USD",
    "exchangeRate": 1430.00,
    "beforeAmount": 1000000.00,
    "afterAmount": 699.30,
    "status": "CANCELLED"
}
```


## [ ERD ]

<img width="743" alt="image" src="https://github.com/user-attachments/assets/12edf4ed-0e38-4dba-8409-12c0b2325c6c">


