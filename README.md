# ChatService
다양한 방식의 채팅서비스 구현

## 채팅서비스 구현 방법

### 1. HTTP통신으로 구현

HTTP 통신 방식은 client가 req를 보내면 server가 res를 보내는 방식이다.

stateless이기 때문에 server가 client에게 데이터를 전송 할 수 없다. 

채팅서버에서 이게 왜 문제가 될까?? 

client가 내용과 채팅방 번호를 POST방식으로 서버에 보내면 된다.

하지만 변경된 데이터를 받기 위해서는 다시 채팅방을 호출 해야한다.

매번 채팅마다 이렇게 되면 서버의 부하가 많이 걸릴것이다.

또한 다른 클라이언트들은 채팅이 왔다는 사실을 실시간으로 인지하지 못한다.

직접 서버에 GET방식으로 채팅방 url을 요청해야 데이터를 받을것이다.

#### 개선된 HTTP통신 방식

### 1-1. Polling 방식으로 구현


### 1-2. Long-Polling 방식으로 구현


### 2. 웹소켓 통신으로 구현

웹소켓 통신은 TCP/IP 방식이고 초기 연결을 위한 서버로 한번의 request만 있고 종료 될 때까지 계속 연결돼있다.

Handshake로 서로 연결하게 되고 양쪽에서 메시지를 주고 받는다. 계속 연결되어 있는 상태이기 때문에 서로가 주기적으로 heartbeat 패킷을 보내서 연결을 확인한다.

close를 하게 되면 연결이 종료된다.

한번의 요청으로 계속 연결되고 서버도 데이터 전송이 가능하기 때문에 실시간 스트리밍이 가능하다.

또한 HTTP에서 동작이 가능해서 방화벽 제약이 없다.

### 2-1. l대N 통신을 위해서 Stomp

DB Model 설계

![image](https://user-images.githubusercontent.com/31639082/155435044-963784de-02ea-47a6-a770-da29d7a9d30b.png)

유저테이블에 chatroom을 fk로 두면 지저분해진다.

그래서 chatroomuser 테이블을 따로 만들어서 채팅방에 들어있는 유저를 확인 할 수 있게 했다.




