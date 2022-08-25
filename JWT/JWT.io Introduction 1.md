## JWT란?
___

JWT는 Json Web Token의 약자다. 사용자 인증을 위해 사용하는 암호화 토큰을 의미하는데 크게는 권한부여, 정보교환에서 유용하게 사용된다.

* 인증(권한부여) 

JWT가 사용되는 가장 일반적인 용도이다. 사용자가 로그인하면 그 요청에는 JWT가 포함되므로 사용자는 해당 토큰이 허용도는 경로나 서비스와 리소스에 액세스 할 수 있다. singel sing on(SSO) 통합인증 방식은 오버헤드를 감소시켜 줄 수 있고, 다른 도메인에서 쉽게 사용 할 수 있는 기능 때문에 요즘 JWT에서 널리 사용하는 기능입니다.

* 정보교환

JSON 웹토큰은 당사자간에 정보를 안전하게 전송하는 좋은 방법이다. 예를들어 publicKey/SecretKey 쌍을 이용하여 JWT에 서명 할 수 있으므로 보낸 사람이 해당하는 사용자가 맞는지 확인 할 수 있다. 또한 Header와 payloda를 사용하여 서명을 계산할 때 내용이 변경되지 않았는지 확일 할 수도 있다.

## JSON의 웹 토큰 구조
___
JSON Web Token은 점(.)으로 구분되어 3개의 부분으로 구성되어 있다.
Header / Payload / Signature(서명)


ex) xxxx.yyyy.zzzzz

### Header
___
일반적으로 JWT인 토큰 유형과 사용중인 서명 알고리즘(HMAC SHA256 또는 RSA 등)의 두 부분으로 구성된다.

`{   "alg": "HS256",   "typ": "JWT" } `

이 header는 Base64Url로 인코딩되어 JWT의 첫 번째 부분을 형성


### payload
___

토큰의 두번째 부분은 claim을 포함하는 payload. claim은 엔티티(일반적으로 User)및 추가 데이터에 대한 명령문이다. Claim에는 등록, 공개 및 비공개청구의 세가지 유형이 있다. 

* public claim : JWT를 사용하는 사람들이 우너하는 대로 정의 할 수 있다. 그러나 충들을 방지하려면 IANA JSON Web Token Registry에 정의하거나 충돌 방지 namespace를 포함하는 URI로 정의해야 한다..

* private claim : 사용에 동의한 당사자 간에 정보를 공유하기 위해 작성된 cumstom claim이며 registered(등록)이나 public claim이 아니다.

`{   "sub": "1234567890",   "name": "John Doe",   "admin": true } `
이 payload는 Base64Url로 인코딩되어 JSON Web 토큰의 두 번째 부분을 형성합니다.


### Signature

시그니처(서명) 부분을 만들려면 인코딩 된 헤어, 인코딩 된 payload, 비밀, 헤더에 지정된 알고리즘을 가져와서 서명해야 합니다. 예를 들어 HMAC SHA256 알고리즘을 사용하는 경우 시그니처는 다음과 같이 작성됩니다.

`HMACSHA256(   base64UrlEncode(header) + "." +   base64UrlEncode(payload),   secret) `

서명은 메시지가 도중에 변경되지 않았는지 확인하는 데 사용되며, 개인 키로 서명된 토큰의 경우 JWT의 발신인이 누구인지 확인할 수도 있습니다.




