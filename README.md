# sparta-scheduleapp

---
1. [일정관리 앱 API 명세서](#일정관리-앱-API-명세서)
2. [ERD](#ERD)
---

## 일정관리 앱 API 명세서

|    기능    | Method |           URL           |  request   |  response  |     상태코드     |
|:--------:|:------:|:-----------------------:|:----------:|:----------:|:------------:|
|   일정생성   |  POST  |       /schedules        |  요청 body   |   일정 정보    | 201 : 정상 등록  |
| 전체 일정 조회 |  GET   |       /schedules        |  요청 param  |  다건 응답 정보  |  200: 정상 조회  |
| 선택 일정 조회 |  GET   | /schedules/{scheduleId} |  요청 param  |  단건 응답 정보  |  200: 정상조회   |
| 선택 일정 수정 | PATCH  | /schedules/{scheduleId} |  요청 body   |   수정 정보    |  200: 정상 수정  |
| 선택 일정 삭제 | DELETE | /schedules/{scheduleId} |  요청 param  |     -      |  200: 정상 삭제  |

<br/>

---

## 1. 일정 생성

| Method | URL        |
|:------:|------------|
|  POST  | /schedules |

<br/>

### request
```json=
{
	"todo" : "공부하기",
	"name" : "작성자이름",
	"password" : "1234",
	"create_at" : "2024-10-30 20:53"
}
```

<br/>

### response
```json=
{
	"id": 1
	"todo" : "공부하기",
	"name" : "작성자이름",
	"password" : "1234",
	"create_at" : "2024-10-30 20:53",
}
```

<br/>

### 상태코드
| Code | Description |
|:----:|:-----------:|
| 201  |  일정 생성 성공   |
| 400  |  일정 생성 실패   |


<br/>
<br/>

---

## 2. 전체 일정 조회

| Method | URL        |
|:------:|------------|
|  GET   | /schedules |

<br/>

### request
```json=
{

}
```
<br/>

### response
```json=
{
	"schedules": [
		{
			"id" : "1",
			"todo" : "공부하기",
			"name" : "작성자이름",
			"create_at" : "2024-10-30 20:53",
		},
		{
			"id" : "2",
			"todo" : "공부하기",
			"name" : "작성자이름",
			"create_at" : "2024-10-30 20:53",
		},
		{
			"id" : "3",
			"todo" : "공부하기",
			"name" : "작성자이름",
			"create_at" : "2024-10-30 20:53",
		},
	]
}
```
<br/>

### 상태코드
| Code | Description |
|:----:|:-----------:|
| 200  |  전체 조회 성공   |
| 400  |  저체 조회 실패   |


<br/>
<br/>

---

## 3. 선택 일정 조회

| Method | URL                     |
|:------:|-------------------------|
|  GET   | /schedules/{scheduleId} |

<br/>

### request
```json=
{

}
```

### response
```json=
{
	"id" : "1",
	"todo" : "공부하기",
	"name" : "작성자이름",
	"create_at" : "2024-10-30 20:53",
}
```

### 상태코드
| Code | Description |
|:----:|:-----------:|
| 200  |  선택 조회 성공   |
| 400  |  선택 조회 실패   |


<br/>
<br/>

---

## 4. 선택 일정 수정

| Method | URL                     |
|:------:|-------------------------|
| PATCH  | /schedules/{scheduleId} |

<br/>

### request
```json=
{
	"todo" : "식사하기",
	"password" : "1234",
	"modified_at" : "2024-10-31 20:53",
}
```

### response
```json=
{
	"id" : "1",
	"todo" : "식사하기",
	"name" : "작성자이름",
	"password" : "1234",
	"create_at" : "2024-10-31 20:53",
	"modified_at" : "2024-11-01 11:53",
}
```

### 상태코드
| Code | Description |
|:----:|:-----------:|
| 200  |  일정 수정 성공   |
| 400  |  일정 수정 실패   |
| 403  |    권한 없음    |


<br/>
<br/>

---

## 5. 선택 일정 삭제

| Method | URL                     |
|:------:|-------------------------|
| DELETE | /schedules/{scheduleId} |

<br/>

### request
```json=
{ 
	"password" : "1234"
}
```

### response
```json=
{

}
```

### 상태코드
| Code | Description |
|:----:|:-----------:|
| 200  |  일정 삭제 성공   |
| 400  |  일정 삭제 실패   |
| 403  |    권한 없음    |

<br/>

---

## ERD
![img.png](ERD.png)
